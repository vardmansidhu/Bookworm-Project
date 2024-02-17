package com.bookworm.bookworm_middleware.services;

import java.util.List;
import java.util.Optional;

import com.bookworm.bookworm_middleware.entities.Product;

public interface IProductService {
	
	public void addProduct(Product product);

	public List<Product> getAllProducts();
	
	public Product getProduct(int id) ;

	public Optional<Product> deleteById(int id);

	//public void updateById(int id, Product obj);
	
	//public void updateById(ProductMaster product,long id);
	
	List<Product> getByType(int id);
	
	List<Product> getByTypeAndLang(int typeId, int langId);
	
	List<Product> getByGenre(int id);

}
