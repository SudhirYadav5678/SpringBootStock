package com.sudhir.stockbackend.service;

import com.sudhir.stockbackend.model.buy.BuyMapper;
import com.sudhir.stockbackend.model.buy.BuyModel;
import com.sudhir.stockbackend.model.buy.BuyRequest;
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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@AllArgsConstructor
public class BuyService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private BuyRepository buyRepository;


    private final Map<String, BlockingQueue<BuyRequest>> companyQueues = new ConcurrentHashMap<>();
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public BuyOrderService(UserRepository userRepository,
                           CompanyRepository companyRepository,
                           BuyRepository buyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
        this.buyRepository = buyRepository;
    }

    public void enqueueOrder(BuyRequest request) {
        companyQueues
                .computeIfAbsent(request.getCompanyName(), name -> {
                    BlockingQueue<BuyRequest> queue = new LinkedBlockingQueue<>();
                    startProcessingThread(name, queue);
                    return queue;
                })
                .offer(request);
    }

    private void startProcessingThread(String companyName, BlockingQueue<BuyRequest> queue) {
        executorService.submit(() -> {
            while (true) {
                try {
                    BuyRequest request = queue.take(); // waits for new orders
                    processOrder(request); // transactional method
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Transactional
    public void processOrder(BuyRequest request) {
        UserModel user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User does not exist"));

        CompanyModel company = companyRepository.findByCompanyName(request.getCompanyName())
                .orElseThrow(() -> new RuntimeException("Company does not exist"));

        BigDecimal totalCost = request.getStockAmount().multiply(request.getTransitionAmount());

        if (user.getAccountBalance().compareTo(totalCost) < 0) {
            throw new RuntimeException("Insufficient account balance");
        }

        // Deduct and save
        user.setAccountBalance(user.getAccountBalance().subtract(totalCost));
        userRepository.save(user);

        // Save stock purchase
        BuyModel buy = BuyMapper.toEntity(request);
        buyRepository.save(buy);

        System.out.println("Processed order for " + companyName + ": " + request);
    }
}
