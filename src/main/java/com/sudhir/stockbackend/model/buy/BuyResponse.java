package com.sudhir.stockbackend.model.buy;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyResponse {
    private Long stockId;
    private String username;
    private String companyName;
    private BigDecimal transitionAmount;
    private BigDecimal stockAmount;
}
