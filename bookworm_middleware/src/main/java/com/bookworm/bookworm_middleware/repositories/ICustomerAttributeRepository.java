package com.bookworm.bookworm_middleware.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookworm.bookworm_middleware.entities.CustomerAttribute;

@Repository
public interface ICustomerAttributeRepository extends JpaRepository<CustomerAttribute, Integer> {

}
