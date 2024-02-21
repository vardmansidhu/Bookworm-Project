package com.bookworm.bookworm_middleware.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookworm_middleware.entities.ProductBeneficiary;
import com.bookworm.bookworm_middleware.repositories.IProductBeneficiaryRepository;

@Service
public class ProductBeneficiaryManager implements IProductBeneficiaryManager {

    @Autowired
    private IProductBeneficiaryRepository repository;

    @Override
    public List<ProductBeneficiary> findByProductId(Integer productId) {
        return repository.findBeneficiariesByProductId(productId);
    }
}
