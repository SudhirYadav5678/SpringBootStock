package com.sudhir.stockbackend.model.sell;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class SellRequest {
   @NotNull(message = "User id is necessary")
    private String userId;
    @NotNull(message = "Company name is necessary")
    private String companyName;
    @NotNull(message = "No of stocks are necessary")
    private BigDecimal NoOfStocks;

}
