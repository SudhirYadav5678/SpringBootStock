package com.sudhir.stockbackend.controller;

import com.sudhir.stockbackend.model.buy.BuyRequest;
import com.sudhir.stockbackend.model.buy.BuyResponse;
import com.sudhir.stockbackend.service.BuyService;
import jakarta.validation.Valid;
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
    public ResponseEntity<BuyResponse> stockBuy(@RequestBody BuyRequest request ){
        System.out.println(request);
        BuyResponse buy = buyService.createStockBuy(request);
        return new ResponseEntity<>(buy, HttpStatus.OK);
    }
}
