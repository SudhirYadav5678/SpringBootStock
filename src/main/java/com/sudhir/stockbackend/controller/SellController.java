package com.sudhir.stockbackend.controller;

import com.sudhir.stockbackend.model.sell.SellRequest;
import com.sudhir.stockbackend.service.SellService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sell")
@AllArgsConstructor
public class SellController {
    private final SellService sellService;

    @PostMapping("/sell-stock")
    public String sellStock(@RequestParam String username, @RequestBody SellRequest request){
        String sell = sellService.sellStock(username,request);
        return "Sell of stocks done";
    }
}
