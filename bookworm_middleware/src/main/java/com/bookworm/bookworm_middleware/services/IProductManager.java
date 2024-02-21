package com.bookworm.bookworm_middleware.services;

import java.util.List;
import java.util.Optional;

import com.bookworm.bookworm_middleware.entities.Product;

public interface IProductManager {

	public void addProduct(Product product);

	public List<Product> getAllProducts();

	public Product getProduct(int id);

	public Optional<Product> deleteById(int id);

	// public void updateById(int id, Product obj);

	// public void updateById(ProductMaster product,long id);

	List<Product> getByType(int id);

	List<Product> getByLanguage(int id);

	List<Product> getLanguageAndType(int lang_id, int type_id);

	List<Product> getByGenre(int id);

	String getProductNamebyId(int id);

	public List<Product> getProductsByTypeNotInShelf(int typeId, int customerId);

	public List<Product> getProductsByLanguageAndTypeNotInShelf(int language_id, int type_id, int customerId);

}
