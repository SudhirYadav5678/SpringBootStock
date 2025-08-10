package com.sudhir.stockbackend.controller;

import com.sudhir.stockbackend.model.buy.BuyRequest;
import com.sudhir.stockbackend.model.buy.BuyResponse;
import com.sudhir.stockbackend.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/stock-buy")
public class BuyController {

    @Autowired
    private BuyService buyService;
    @PostMapping("/buy")
    public String stockBuy(@RequestBody BuyRequest request ){
        System.out.println(request);
        String buy = buyService.addOrderBuy(request);
        return "Order is complete";
    }
}
