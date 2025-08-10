package com.sudhir.stockbackend.model.sell;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class SellResponse {
    private Long sellId;

    private String userId;

    private String companyName;

    private BigDecimal NoOfStocks;

    private  BigDecimal amount;
}
