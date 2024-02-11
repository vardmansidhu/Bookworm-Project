package com.bookworm.bookworm_middleware.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookworm.bookworm_middleware.entities.MyShelf;

public interface IMyShelfRepository extends JpaRepository<MyShelf, Integer> {
    
}