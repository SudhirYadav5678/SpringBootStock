package com.sudhir.stockbackend.model.sell;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "sell_Stocks")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellId;
    @Column(name = "user_id", nullable = false)
    private String userId;
    @Column(name = "company_name", nullable = false)
    private String companyName;
    @Column(name = "no_of_stocks", nullable = false)
    private BigDecimal NoOfStocks;
    @Column(name = "full_name", nullable = false)
    private  BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }
}
