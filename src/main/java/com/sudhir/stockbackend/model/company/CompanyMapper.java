package com.sudhir.stockbackend.model.company;

import com.sudhir.stockbackend.model.UserModel;

public class CompanyMapper {
    public static CompanyModel toEntity(CompanyRequest request, Long userId) {
        UserModel user = UserModel.builder().userId(userId).build();
        return CompanyModel.builder()
                .companyName(request.getCompanyName())
                .description(request.getDescription())
                .initialStockPrice(request.getInitialStockPrice())
                .stockQuantity(request.getStockQuantity())
                .currentStockPrice(request.getCurrentStockPrice())
                .publicAvailable(request.isPublicAvailable())
                .userId(user)
                .build();
    }

    public static CompanyResponse toResponse(CompanyModel request) {
        return CompanyResponse.builder()
                .companyId(request.getCompanyId())
                .companyName(request.getCompanyName())
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
