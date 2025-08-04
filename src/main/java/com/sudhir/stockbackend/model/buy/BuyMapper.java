package com.sudhir.stockbackend.model.buy;

public class BuyMapper {

    public static BuyModel toEntity(BuyRequest request){
        BuyModel buy = new BuyModel();
        return BuyModel.builder()
                .username(request.getUsername())
                .companyName(request.getCompanyName())
                .stockAmount(request.getStockAmount())
                .transitionAmount(request.getTransitionAmount())
                .build();
    }

    public static BuyResponse toResponse(BuyModel buyStock) {
        return BuyResponse.builder()
                .stockId(buyStock.getStockId())
                .username(buyStock.getUsername())
                .companyName(buyStock.getCompanyName())
                .transitionAmount(buyStock.getTransitionAmount())
                .stockAmount(buyStock.getStockAmount())
                .build();
    }
}
