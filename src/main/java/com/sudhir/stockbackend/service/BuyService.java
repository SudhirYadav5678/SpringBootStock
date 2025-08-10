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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;


@Service
@AllArgsConstructor
public class BuyService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private BuyRepository buyRepository;

    private final Map<String, LinkedBlockingQueue<BuyRequest>> companyOrders = new ConcurrentHashMap<>();

    public void addOrderINQueue(BuyRequest request){
        companyOrders
                .computeIfAbsent(request.getCompanyName(),
                        k -> new LinkedBlockingQueue<>()
                )
                .offer(request);
    }

    @Transactional
    public BuyResponse processOrder(BuyRequest request) {
        UserModel user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User does not exist"));

        CompanyModel company = companyRepository.findByCompanyName(request.getCompanyName())
                .orElseThrow(() -> new RuntimeException("Company does not exist"));

        BigDecimal totalCost = request.getStockAmount().multiply(request.getTransitionAmount());

        if (user.getAccountBalance().compareTo(totalCost) < 0) {
            throw new RuntimeException("Insufficient account balance");
        }
        // add to queue for FIFO
        addOrderINQueue(request);

        var order = companyOrders.containsKey(request.getUsername());
        if(!order){
            throw new RuntimeException("Error while adding order in queue");
        }

        // amount reduce from userAccount.
        user.setAccountBalance(user.getAccountBalance().subtract(totalCost));
        // todo:add stock and company in user profile.
        userRepository.save(user);

        // amount reduce from company.
        company.setStockQuantity(company.getStockQuantity().subtract(request.getStockAmount()));
        companyRepository.save(company);

        // Save stock purchase
        BuyModel buy = BuyMapper.toEntity(request);
        buyRepository.save(buy);

        BuyResponse savedBuy = BuyMapper.toResponse(buy);

        System.out.println("Processed order for " + company.getCompanyName() + ": " + request);
        return savedBuy;
    }
}
