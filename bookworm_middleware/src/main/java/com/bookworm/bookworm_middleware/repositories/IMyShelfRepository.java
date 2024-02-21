package com.bookworm.bookworm_middleware.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.bookworm_middleware.entities.MyShelf;
import com.bookworm.bookworm_middleware.entities.Product;

@Repository
public interface IMyShelfRepository extends JpaRepository<MyShelf, Integer> {

    @Query("SELECT m.productId FROM MyShelf m WHERE m.customerId = :customerId AND (m.expiryDate IS NULL OR m.expiryDate > CURRENT_DATE)")
    List<Product> findByCustomerId(@Param("customerId") Integer customerId);

}