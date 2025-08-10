package com.sudhir.stockbackend.model.buy;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private BigDecimal stockAmount;

}
