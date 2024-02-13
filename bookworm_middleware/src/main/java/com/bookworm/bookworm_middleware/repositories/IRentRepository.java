package com.bookworm.bookworm_middleware.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookworm.bookworm_middleware.entities.Rent;

public interface IRentRepository extends JpaRepository<Rent, Integer>{
    
}
