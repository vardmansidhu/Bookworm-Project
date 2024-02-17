package com.bookworm.bookworm_middleware.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookworm_middleware.entities.ProductType;
import com.bookworm.bookworm_middleware.repositories.IProductTypeRepository;

@Service
public class ProductTypeManagerImpl implements IProductTypeManager{

	@Autowired
	private IProductTypeRepository repository;

	
	@Override
	public List<ProductType> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public void addProductType(ProductType pro) {
		repository.save(pro);
		
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void update(ProductType p, Integer id) {
		repository.update(p.getTypeDesc(), id);
	}

	@Override
	public Optional<ProductType> getByType(String type) {
		return repository.findByTypeDesc(type);
	}

}
