package com.sudhir.stockbackend.controller;

import com.sudhir.stockbackend.model.stocksPrice.Prices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping()
@RestController
public class ShowPrice {
    @Autowired
    private GetPrices getPrices;

    @MessageMapping("/prices/{company-name}")
    @SendTo("/get-stocks-prices/{company-name}")
    public Prices getPriceByCompanyName(@RequestParam String companyName){
        Prices stockPrice = getPrices.getStockPriceByName(companyName);
        return stockPrice;
    }
}
