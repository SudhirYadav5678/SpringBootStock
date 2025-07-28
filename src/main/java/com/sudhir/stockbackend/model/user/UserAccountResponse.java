package com.sudhir.stockbackend.model.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserAccountResponse {
    private Long userId;
    private String username;
    private String email;
    private String fullName;
    private BigDecimal accountBalance ;
    private String bankName;
    private String accountNumber;
    private String ifscCode;
    private String upiId;
}
