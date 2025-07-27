package com.sudhir.stockbackend.repository;

import com.sudhir.stockbackend.model.company.CompanyModel;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel,Long> {
    Optional<CompanyModel> findByCompanyEmail(String companyName);
}
