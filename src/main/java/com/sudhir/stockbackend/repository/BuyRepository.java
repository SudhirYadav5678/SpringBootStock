package com.sudhir.stockbackend.repository;

import com.sudhir.stockbackend.model.buy.BuyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyRepository extends JpaRepository<BuyModel,Long>{
}
