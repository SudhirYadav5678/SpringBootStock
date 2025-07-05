package com.sudhir.stockbackend.repository;

import com.sudhir.stockbackend.model.UserModel;
import com.sudhir.stockbackend.model.company.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel,Long> {
}
