package com.sudhir.stockbackend.model.company;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "company_stocks_prices")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockPriceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyModel company;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name="company_symbol", nullable = false,unique = true)
    private String companySymbol;

    @Column(name = "initial_stock_price", nullable = false)
    private BigDecimal initialStockPrice;

    @Column(name = "stock_quantity", nullable = false)
    private BigDecimal stockQuantity;

    @Column(name = "current_stock_price", nullable = false)
    private BigDecimal currentStockPrice;

    private BigDecimal stockHigh;

    private BigDecimal stockLow;

}
