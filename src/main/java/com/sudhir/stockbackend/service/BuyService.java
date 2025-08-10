package com.sudhir.stockbackend.service;

import com.sudhir.stockbackend.model.buy.BuyMapper;
import com.sudhir.stockbackend.model.buy.BuyModel;
import com.sudhir.stockbackend.model.buy.BuyRequest;
import com.sudhir.stockbackend.model.buy.BuyResponse;
import com.sudhir.stockbackend.model.company.CompanyModel;
import com.sudhir.stockbackend.model.user.UserModel;
import com.sudhir.stockbackend.repository.BuyRepository;
import com.sudhir.stockbackend.repository.CompanyRepository;
import com.sudhir.stockbackend.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;


@Service
@AllArgsConstructor
public class BuyService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private BuyRepository buyRepository;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    private final Map<String, LinkedBlockingQueue<BuyRequest>> companyOrders = new ConcurrentHashMap<>();
    private final Map<String, AtomicBoolean> processingFlags = new ConcurrentHashMap<>();

    public String addOrderBuy(BuyRequest request) {
        Optional<UserModel> user = userRepository.findByUsername(request.getUsername());
        if(user.isEmpty()){
            throw new RuntimeException("User Name does not exit");
        }
        Optional<CompanyModel> company = companyRepository.findByCompanyName(request.getCompanyName());
        if(company.isEmpty()){
            throw new RuntimeException("Company Name does not exit");
        }

        // checking the sufficient stock and user balance.
        UserModel requestedUser = user.get();
        CompanyModel requestedCompany = company.get();

        var amount = requestedUser.getAccountBalance();
        var stockPrice = requestedCompany.getCurrentStockPrice();
        var stockAmount = requestedCompany.getStockQuantity();
        if (stockAmount.subtract(request.getStockAmount()).compareTo(BigDecimal.ZERO) < 0) {
           throw new RuntimeException("Insufficient amount of stocks. Please enter less amount of stocks.");
        }
        BigDecimal totalCost = request.getStockAmount().multiply(stockPrice);
        if (amount.subtract(totalCost).compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Insufficient amount in your account. Please enter less amount of stocks.");
        }

        // adding in queue for FIFO for each company
        companyOrders
                .computeIfAbsent(request.getCompanyName(), k -> new LinkedBlockingQueue<>())
                .offer(request);

        // 6. Start processing if not already running
        processingFlags
                .computeIfAbsent(request.getCompanyName(), k -> new AtomicBoolean(false));

        if (processingFlags.get(request.getCompanyName()).compareAndSet(false, true)) {
            executorService.submit(() -> processOrdersForCompany(request.getCompanyName()));
        }

        return "Order placed in queue.";
    }

    private void processOrdersForCompany(String companyName) {
        try {
            LinkedBlockingQueue<BuyRequest> queue = companyOrders.get(companyName);
            BuyRequest request;
            while ((request = queue.poll()) != null) {
                processOrder(request); // Your stock-buying logic here
            }
        } finally {
            // Allow new processing threads to be triggered for this company
            processingFlags.get(companyName).set(false);

            // Check if new orders arrived while processing
            if (!companyOrders.get(companyName).isEmpty() &&
                    processingFlags.get(companyName).compareAndSet(false, true)) {
                executorService.submit(() -> processOrdersForCompany(companyName));
            }
        }
    }

    @Transactional
    private void processOrder(BuyRequest request) {
        // Deduct stock from company
        CompanyModel company = companyRepository.findByCompanyName(request.getCompanyName()).orElseThrow();
        company.setStockQuantity(company.getStockQuantity().subtract(request.getStockAmount()));
        companyRepository.save(company);

        // Deduct amount from user
        UserModel user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        BigDecimal totalCost = request.getStockAmount().multiply(company.getCurrentStockPrice());
        user.setAccountBalance(user.getAccountBalance().subtract(totalCost));
        userRepository.save(user);

        // Save buy record
        BuyModel buy = BuyMapper.toEntity(request);
        buyRepository.save(buy);
    }
}
