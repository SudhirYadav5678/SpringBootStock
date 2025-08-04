package com.sudhir.stockbackend.model.buy;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyRequest {
    @NotBlank(message = "User Name is required")
    private String username;
    @NotBlank(message = "Company Name is required")
    private String companyName;
    @NotBlank(message = "Transition Amount is required")
    private BigDecimal transitionAmount;
    @NotBlank(message = "Stock Amount is required")
    private BigDecimal stockAmount;
}
