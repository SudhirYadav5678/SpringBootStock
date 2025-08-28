package com.sudhir.stockbackend.service;

import com.sudhir.stockbackend.model.company.CompanyModel;
import com.sudhir.stockbackend.model.stocksPrice.Prices;
import com.sudhir.stockbackend.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetPrices {
    @Autowired
    private CompanyRepository companyRepository;

    public Prices getStockPriceByName(String companyName) {
        //todo: separate company details and stocks prices different.
        Optional<CompanyModel> companyModel = companyRepository.findByCompanyName(companyName);
        if(companyModel.isEmpty()){
            throw new RuntimeException("Company name is not present");
        }
        CompanyModel company = companyModel.get();

    }
}
