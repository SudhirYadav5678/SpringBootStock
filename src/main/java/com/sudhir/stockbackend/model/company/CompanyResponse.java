package com.sudhir.stockbackend.model.company;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class CompanyResponse {
    private Long companyId;
    private String companySymbol;
    private String companyName;
    private String companyEmail;
    private String description;
    private BigDecimal initialStockPrice;
    private BigDecimal stockQuantity;
    private BigDecimal currentStockPrice;
    private boolean publicAvailable;
    private BigDecimal accountBalance;
    private String bankName;
    private String accountNumber;
    private String ifscCode;
    private String upiId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
