package com.bookworm.bookworm_middleware.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookworm_middleware.entities.Product;
import com.bookworm.bookworm_middleware.repositories.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {
    
    @Autowired
    IProductRepository productRepo;

    @Override
	public void addProduct(Product product) {

		System.out.println("Inside the service \n" + productRepo.save(product));
	}

	@Override
	public Product getProduct(int id)  {
		Product obj = productRepo.getById(id);
        return obj;

	}

	@Override
	public Optional<Product> deleteById(int id) {

		Optional<Product> obj = productRepo.findById(id);
		productRepo.deleteById(id);
		return obj;

	}

//	@Override
//	public void updateById(int id, Product product) {
//           
//		productRepo.u
//		
//	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public List<Product> getByType(int id) {
		return productRepo.findByProductType(id);
	}

	@Override
	public List<Product> getByTypeAndLang(int typeId, int langId) {
		// TODO Auto-generated method stub
		return productRepo.findByProductLanguageAndType(typeId,langId);
	}

	@Override
	public List<Product> getByGenre(int id) {
		// TODO Auto-generated method stub
		return productRepo.findByProductGenre(id);
	}

//	@Override
//	public void updateById(Product product, long id) {
//		ProductRepo.updateById(product, id);
//	}

   
}
