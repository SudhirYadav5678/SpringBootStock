package com.sudhir.stockbackend.controller;

import com.sudhir.stockbackend.model.stocksPrice.Prices;
import com.sudhir.stockbackend.service.GetPrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/stock-Prices")
@RestController
public class ShowPrice {
    @Autowired
    private GetPrices getPrices;

    @GetMapping("/{company-name}")
    public Prices getPriceByCompanyName(@RequestParam String companyName){
        Prices stockPrice = getPrices.getStockPriceByName(companyName);
        return stockPrice;
    }
}
