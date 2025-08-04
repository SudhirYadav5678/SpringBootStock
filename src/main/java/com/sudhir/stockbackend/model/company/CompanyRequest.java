package com.sudhir.stockbackend.model.company;


import com.sudhir.stockbackend.model.user.Role;
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

    @NotNull(message = "Company Symbol must not be blank")
    private String companySymbol;

    @NotNull(message = "Company Email must not be blank")
    private String companyEmail;

    @NotBlank(message = "Password must not be blank")
    private String password;

    @Builder.Default
    private Role role = Role.COMPANY;

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

    @Builder.Default
    private boolean publicAvailable = true;

    @Builder.Default
    private boolean enabled = true;

    private BigDecimal accountBalance;

    @NotNull(message = "Bank name  is required")
    private String bankName;

    @NotNull(message = "Account number  is required")
    private String accountNumber;

    @NotNull(message = "Ifsc code is required")
    private String ifscCode;

    private String upiId;

}
