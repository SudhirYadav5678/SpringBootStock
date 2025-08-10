package com.sudhir.stockbackend.service.buyService;

import com.sudhir.stockbackend.model.buy.BuyRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

@Service
@AllArgsConstructor
public class BuyOrder {

    private final Map<String, LinkedBlockingQueue<BuyRequest>> companyOrders = new ConcurrentHashMap<>();

    private

}
