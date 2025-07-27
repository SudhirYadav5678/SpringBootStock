package com.sudhir.stockbackend.model.user;

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
public class UserAccountRequest {

    private BigDecimal accountBalance ;

    @NotNull(message = "Bank name is required")
    private String bankName;

    @NotNull(message = "Bank Account Number is required")
    private String accountNumber;

    @NotNull(message = "Bank Account IFSC Number is required")
    private String ifscCode;

    private String upiId;

}
