package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import com.ecommerce.utils.Response;


@RestController
public class ProductController {
	@Autowired
	ProductService productService;

	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/addProduct")
	public ResponseEntity Producta( @RequestBody Product product) {
		ResponseEntity responseObject = null;
		try {
			Response response = productService.addProduct(product);
			responseObject = new ResponseEntity(response,response.getOperation()?HttpStatus.CREATED:HttpStatus.BAD_REQUEST);
			
		}
		catch(Exception error) {
			System.out.println(error);
			Response response = new Response();
			response.setMessage(error.getMessage());
			response.setOperation(true);
			response.setStatusCode(500);
			responseObject = new ResponseEntity(response,response.getOperation()?HttpStatus.CREATED:HttpStatus.BAD_REQUEST);
			
		}
		return responseObject;
		 }
	
	

}
