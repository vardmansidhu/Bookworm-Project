package com.bookworm.bookworm_middleware.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.bookworm_middleware.dtos.ProductDto;
import com.bookworm.bookworm_middleware.entities.Product;
import com.bookworm.bookworm_middleware.services.IProductManager;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class ProductController {
	@Autowired
	private IProductManager proService;

	@GetMapping(value = "/get")
	public List<Product> showProducts() {
		return proService.getAllProducts();
	}

	@GetMapping(value = "get/{pid}")
	public Product getPro(@PathVariable int pid) {
		Product p = proService.getProduct(pid);
		return p;
	}

	@GetMapping(value = "get/{typeId}/{langId}")
	public List<Product> getByTypeAndLang(@PathVariable int typeId, @PathVariable int langId) {
		return proService.getLanguageAndType(langId, typeId);
	}

	// @GetMapping("getNotInShelf/{customerId}")
	// public ResponseEntity<List<Product>> getProductsNotInShelf(@PathVariable
	// Integer customerId) {
	// List<Product> products = proService.getProductsNotInShelf(customerId);
	// return new ResponseEntity<>(products, HttpStatus.OK);
	// }

	@GetMapping("/getByTypeNotInShelf/{typeId}/{customerId}")
	public ResponseEntity<List<Product>> getProductsByTypeNotInShelf(@PathVariable int typeId,
			@PathVariable int customerId) {
		List<Product> products = proService.getProductsByTypeNotInShelf(typeId, customerId);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/getByLanguageAndTypeNotInShelf/{language_id}/{type_id}/{customerId}")
	public ResponseEntity<List<Product>> getProductsByLanguageAndTypeNotInShelf(@PathVariable int language_id,
			@PathVariable int type_id, @PathVariable int customerId) {
		List<Product> products = proService.getProductsByLanguageAndTypeNotInShelf(language_id, type_id, customerId);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@DeleteMapping(value = "delete/{pid}")
	public void removepro(@PathVariable int pid) {
		proService.deleteById(pid);
	}

	@PostMapping(value = "/add")
	public void addpro(@RequestBody Product product) {
		proService.addProduct(product);
	}

	@GetMapping("/getByType/{id}")
	public List<Product> getByType(@PathVariable int id) {
		System.out.println("bytype");
		List<Product> list = proService.getByType(id);
		// List<ProductDto> sendList = new ArrayList<>();
		// for (Product obj : list) {
		// ProductDto newObje = new ProductDto();
		// newObje.setId(obj.getProductId());
		// newObje.setLibrary(obj.isLibrary());
		// newObje.setMinRentDays(obj.getMinRentDays());
		// newObje.setPrice(obj.getBasePrice());
		// newObje.setProductName(obj.getProductName());
		// newObje.setRentable(obj.isRentable());
		// newObje.setRentPerDay(obj.getRentPerDay());
		// System.out.println("Is rentable "+obj.isRentable());
		// sendList.add(newObje);
		// }
		return list;
	}

	@GetMapping("/getByLanguage/{id}")
	public List<ProductDto> getByLanguage(@PathVariable int id) {
		System.out.println("bytype");
		List<Product> list = proService.getByLanguage(id);
		List<ProductDto> sendList = new ArrayList<>();
		for (Product obj : list) {
			ProductDto newObje = new ProductDto();
			newObje.setId(obj.getProductId());
			newObje.setLibrary(obj.isLibrary());
			newObje.setMinRentDays(obj.getMinRentDays());
			newObje.setPrice(obj.getBasePrice());
			newObje.setProductName(obj.getProductName());
			newObje.setRentable(obj.isRentable());
			newObje.setRentPerDay(obj.getRentPerDay());
			System.out.println("Is rentable " + obj.isRentable());
			sendList.add(newObje);
		}
		return sendList;
	}

	@GetMapping("/getByGenre/{id}")
	public List<ProductDto> getByGenre(@PathVariable int id) {
		System.out.println("bytype");
		List<Product> list = proService.getByGenre(id);
		List<ProductDto> sendList = new ArrayList<>();
		for (Product obj : list) {
			ProductDto newObje = new ProductDto();
			newObje.setId(obj.getProductId());
			newObje.setLibrary(obj.isLibrary());
			newObje.setMinRentDays(obj.getMinRentDays());
			newObje.setPrice(obj.getBasePrice());
			newObje.setProductName(obj.getProductName());
			newObje.setRentable(obj.isRentable());
			newObje.setRentPerDay(obj.getRentPerDay());
			System.out.println("Is rentable " + obj.isRentable());
			sendList.add(newObje);
		}
		return sendList;
	}

}
