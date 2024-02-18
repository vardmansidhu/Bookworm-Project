package com.bookworm.bookworm_middleware.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.bookworm_middleware.entities.ProductType;
import com.bookworm.bookworm_middleware.services.IProductTypeManager;
import com.bookworm.bookworm_middleware.services.ProductTypeManagerImpl;

@RestController
@RequestMapping("/api/productType")
@CrossOrigin("*")
public class ProductTypeController {

	@Autowired
	ProductTypeManagerImpl p;

	@GetMapping(value = "/get")
	public List<ProductType> showAllProducts() {
		return p.getAllProducts();

	}

	@DeleteMapping(value = "/delete/{pid}")
	public void deleteProduct(@PathVariable Integer pid) {
		p.delete(pid);
	}

	@PutMapping(value = "/update/{pid}")
	public void updateProduct(@RequestBody ProductType product, @PathVariable Integer pid) {
		p.update(product, pid);
	}

	@PostMapping(value = "/add")
	public void addpro(@RequestBody ProductType product) {
		p.addProductType(product);
	}

	@GetMapping("/get/{type}")
	public Optional<ProductType> getByType(@PathVariable String type) {
		return p.getByType(type);
	}

}
