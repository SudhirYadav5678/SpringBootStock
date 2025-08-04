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
        Optional<UserModel> user = userRepository.findByUsername(request.getUsername());
        if(user.isEmpty()){
            throw new RuntimeException("User Name does not exist");
        }
        System.out.println(user);
        Optional<CompanyModel> company = companyRepository.findByCompanyName(request.getCompanyName());
        if(company.isEmpty()){
            throw new RuntimeException("Company Name does not exist");
        }
        System.out.println("user in stock"+user);
        System.out.println("company in stock"+company);
        BuyModel buy = BuyMapper.toEntity(request);
        BuyModel buyStock = buyRepository.save(buy);
        return BuyMapper.toResponse(buyStock);
    }
}
