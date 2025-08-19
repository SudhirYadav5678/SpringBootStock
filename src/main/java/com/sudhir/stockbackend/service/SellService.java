package com.sudhir.stockbackend.service;

import com.sudhir.stockbackend.model.buy.BuyModel;
import com.sudhir.stockbackend.model.company.CompanyModel;
import com.sudhir.stockbackend.model.sell.SellRequest;
import com.sudhir.stockbackend.model.user.UserModel;
import com.sudhir.stockbackend.repository.BuyRepository;
import com.sudhir.stockbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;
@Service
@AllArgsConstructor
public class SellService {

    private final UserRepository userRepository;
    private final BuyRepository buyRepository;

    public String sellStock(@RequestParam String username, @RequestBody SellRequest request){
        Optional<UserModel> user = userRepository.findByUsername(username);
        if(user.isEmpty()){
            throw new RuntimeException("User with ${username} dose not exit");
        }

        // stocks information
        Optional<BuyModel> userBuy = buyRepository.findByUsername(username);
        if(userBuy.isEmpty()){
            throw new RuntimeException("User with username dose not exit");
        }

        UserModel savedUser = user.get();
        BuyModel savedBuyUser = userBuy.get();

        // check for the stocks exits in user account.
        if (!(Objects.equals(savedBuyUser.getCompanyName(), request.getCompanyName())
                && savedBuyUser.getStockAmount().compareTo(request.getNoOfStocks()) >= 0)) {
            throw new RuntimeException("Given Information about the account is incorrect please check your details.");
        }

        // add this all stocks to admin stocks and remove for the user account.
        Optional<BuyModel> adminUser = buyRepository.findByUsername("SudhirYadavAdmin");
        if (adminUser.isEmpty()){
            throw new RuntimeException("Error while stocks selling in adding to admin part");
        }
        BuyModel admin = adminUser.get();
        //adding into admin account
        admin.setCompanyName(request.getCompanyName());
        admin.setStockAmount(request.getNoOfStocks());

        //stocks removing form userAccount
        savedBuyUser.setStockAmount(savedBuyUser.getStockAmount().subtract(request.getNoOfStocks()));

        return "Order for the sell of stocks completed";
    }


    // price decrease after every buy of stocks.
    public void stockPriceDecrease(CompanyModel request){
        BigDecimal company = request.getCurrentStockPrice();
        BigDecimal newPrice = company.subtract(company.multiply(BigDecimal.valueOf(0.1)));
        request.setCurrentStockPrice(newPrice);
    }
}
