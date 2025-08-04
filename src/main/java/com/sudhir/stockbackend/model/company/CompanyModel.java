package com.sudhir.stockbackend.model.company;

import com.sudhir.stockbackend.model.user.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "company_name")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name="company_symbol", nullable = false,unique = true)
    private String companySymbol;

    @Column(name="company_email",nullable = false,unique = true)
    private String companyEmail;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private String description;

    @Column(name = "initial_stock_price", nullable = false)
    private BigDecimal initialStockPrice;

    @Column(name = "stock_quantity", nullable = false)
    private BigDecimal stockQuantity;

    @Column(name = "current_stock_price", nullable = false)
    private BigDecimal currentStockPrice;

    private boolean publicAvailable;

    private boolean enabled;

    @Column(nullable = false)
    private BigDecimal accountBalance = BigDecimal.ZERO;

    private String bankName;

    private String accountNumber;

    private String ifscCode;

    private String upiId;


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
