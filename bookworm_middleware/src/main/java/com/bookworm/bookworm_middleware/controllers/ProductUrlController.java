package com.bookworm.bookworm_middleware.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.bookworm_middleware.services.ProductUrlService;

@RestController
@CrossOrigin("*")
public class ProductUrlController {

	private final ProductUrlService productDetailService;

	@Autowired
	public ProductUrlController(ProductUrlService productDetailService) {
		this.productDetailService = productDetailService;
	}

	@GetMapping("/api/producturl/{productId}")
	public String getProductUrl(@PathVariable Integer productId) {
		return productDetailService.getUrlByProductId(productId);
	}
}
