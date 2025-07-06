package com.sudhir.stockbackend.model.company;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CompanyRequest {
    @NotBlank(message = "Company name must not be blank")
    private String companyName;

    private String description;

    @NotNull(message = "Initial stock price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Initial stock price must be greater than 0")
    private BigDecimal initialStockPrice;

    @NotNull(message = "Stock quantity is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Stock quantity must be greater than 0")
    private BigDecimal stockQuantity;

    @NotNull(message = "Current stock price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Current stock price must be greater than 0")
    private BigDecimal currentStockPrice;

    private boolean publicAvailable;

}
