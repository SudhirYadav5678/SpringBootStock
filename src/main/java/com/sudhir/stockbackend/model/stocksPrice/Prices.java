package com.sudhir.stockbackend.model.stocksPrice;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "Stocks_Prices")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "company_symbol", nullable = false, unique = true)
    private String companySymbol;

    @Column(name = "previous_Prices")
    private List<BigDecimal> prices;
    @Column(name = "Current_Prices")
    private BigDecimal currentPrice;
}
