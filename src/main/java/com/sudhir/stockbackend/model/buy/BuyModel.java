package com.sudhir.stockbackend.model.buy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "stocks_buyList")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BuyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;

    @Column(name = "stock_Buyer", nullable = false)
    private String username;

    @Column(name = "stock_company", nullable = false)
    private String companyName;

    @Column(name = "transition_amount", nullable = false)
    private BigDecimal transitionAmount;

    @Column(name = "no_of_stocks", nullable = false)
    private BigDecimal stockAmount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
