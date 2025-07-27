package com.sudhir.stockbackend.model.company;

public class CompanyMapper {
    public static CompanyModel toEntity(CompanyRequest request) {
        return CompanyModel.builder()
                .companySymbol(request.getCompanySymbol())
                .companyName(request.getCompanyName())
                .companyEmail(request.getCompanyEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .description(request.getDescription())
                .initialStockPrice(request.getInitialStockPrice())
                .stockQuantity(request.getStockQuantity())
                .currentStockPrice(request.getCurrentStockPrice())
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
                .createdAt(request.getCreatedAt())
                .updatedAt(request.getUpdatedAt())
                .build();
    }
}
