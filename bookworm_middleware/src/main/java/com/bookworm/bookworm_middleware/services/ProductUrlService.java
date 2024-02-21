package com.bookworm.bookworm_middleware.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookworm_middleware.repositories.ProductUrlRepository;

@Service
public class ProductUrlService {

    private final ProductUrlRepository productDetailRepository;

    @Autowired
    public ProductUrlService(ProductUrlRepository productDetailRepository) {
        this.productDetailRepository = productDetailRepository;
    }

    public String getUrlByProductId(Integer productId) {
        return productDetailRepository.findUrlByProductId(productId);
    }
}
