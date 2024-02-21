package com.bookworm.bookworm_middleware.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookworm.bookworm_middleware.entities.ProductUrl;

public interface ProductUrlRepository extends JpaRepository<ProductUrl, Integer> {

    @Query("SELECT p.url FROM ProductUrl p WHERE p.productId.productId = :productId")
    String findUrlByProductId(@Param("productId") Integer productId);
}