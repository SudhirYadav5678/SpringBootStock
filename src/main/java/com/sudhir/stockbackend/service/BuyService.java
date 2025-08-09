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
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BuyService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private BuyRepository buyRepository;

    public BuyResponse createStockBuy(BuyRequest request){
        Optional<UserModel> userOpt = userRepository.findByUsername(request.getUsername());
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User does not exist");
        }

        Optional<CompanyModel> companyOpt = companyRepository.findByCompanyName(request.getCompanyName());
        if (companyOpt.isEmpty()) {
            throw new RuntimeException("Company Name does not exist");
        }

        UserModel user = userOpt.get();
        CompanyModel company = companyOpt.get();

        BigDecimal totalCost = request.getStockAmount().multiply(request.getTransitionAmount());

        if (user.getAccountBalance().compareTo(totalCost) < 0) {
            throw new RuntimeException("Insufficient account balance");
        }

        // Deduct balance
        user.setAccountBalance(user.getAccountBalance().subtract(totalCost));
        userRepository.save(user);

        // Save stock purchase
        BuyModel buy = BuyMapper.toEntity(request);
        BuyModel buyStock = buyRepository.save(buy);

        return BuyMapper.toResponse(buyStock);
    }
}
