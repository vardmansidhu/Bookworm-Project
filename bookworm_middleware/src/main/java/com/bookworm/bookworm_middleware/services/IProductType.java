package com.bookworm.bookworm_middleware.services;

import java.util.List;
import java.util.Optional;

import com.bookworm.bookworm_middleware.entities.ProductType;

public interface IProductType {
	
	List<ProductType> getAllProducts();

	void addProductType(ProductType pro);

	void delete(Integer id);

	void update(ProductType p, Integer id);

	Optional<ProductType> getByType(String type);
}
