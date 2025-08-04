package com.sudhir.stockbackend.model.company;

import com.sudhir.stockbackend.model.user.Role;

public class CompanyMapper {
    public static CompanyModel toEntity(CompanyRequest request) {
        return CompanyModel.builder()
                .companySymbol(request.getCompanySymbol())
                .companyName(request.getCompanyName())
                .companyEmail(request.getCompanyEmail())
                .password(request.getPassword())
                .role(request.getRole() != null ? request.getRole() : Role.COMPANY)
                .description(request.getDescription())
                .initialStockPrice(request.getInitialStockPrice())
                .stockQuantity(request.getStockQuantity())
                .currentStockPrice(request.getCurrentStockPrice())
                .accountBalance(request.getAccountBalance())
                .accountNumber(request.getAccountNumber())
                .bankName(request.getBankName())
                .ifscCode(request.getIfscCode())
                .upiId(request.getUpiId())
                .publicAvailable(request.isPublicAvailable())
                .enabled(request.isEnabled())
                .build();
    }

    public static CompanyResponse toResponse(CompanyModel request) {
        return CompanyResponse.builder()
                .companyId(request.getCompanyId())
                .companySymbol(request.getCompanySymbol())
                .companyName(request.getCompanyName())
                .companyEmail(request.getCompanyEmail())
                .description(request.getDescription())
                .initialStockPrice(request.getInitialStockPrice())
                .stockQuantity(request.getStockQuantity())
                .currentStockPrice(request.getCurrentStockPrice())
                .publicAvailable(request.isPublicAvailable())
                .accountBalance(request.getAccountBalance())
                .accountNumber(request.getAccountNumber())
                .bankName(request.getBankName())
                .ifscCode(request.getIfscCode())
                .upiId(request.getUpiId())
                .createdAt(request.getCreatedAt())
                .updatedAt(request.getUpdatedAt())
                .build();
    }
}
