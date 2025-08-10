package com.sudhir.stockbackend.repository;

import com.sudhir.stockbackend.model.buy.BuyModel;
import com.sudhir.stockbackend.model.sell.SellModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyRepository extends JpaRepository<BuyModel,Long>{
    Optional<BuyModel> findByUsername(String username);
}
