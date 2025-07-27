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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
