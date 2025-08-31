package com.sudhir.stockbackend.model.stocksPrice;

import com.sudhir.stockbackend.model.company.CompanyModel;

public class CompanyPriceMapper {

    public static Prices toCompanyPrice(CompanyModel request){
        return Prices.builder()
                .companyName(request.getCompanyName())
                .companySymbol(request.getCompanySymbol())
                .currentPrice(request.getCurrentStockPrice())
                .build();

    }
}
