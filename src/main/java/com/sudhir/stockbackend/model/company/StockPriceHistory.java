package com.sudhir.stockbackend.model.company;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "company_stocks_prices_history")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockPriceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "stock_price_id", nullable = false)
    private StockPrice stockPrice;

    @Column(name = "time", nullable = false)
    private java.time.LocalDateTime time;

    @Column(name = "price", nullable = false, precision = 19, scale = 4)
    private BigDecimal price;
}
