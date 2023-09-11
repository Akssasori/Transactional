package com.seleniumexpress.trans.spring_transactional_01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seleniumexpress.trans.spring_transactional_01.model.Product;
import com.seleniumexpress.trans.spring_transactional_01.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;
	
	@Transactional
	public void saveProductInfo() {
		
//		System.out.println("method started : " + "saveProductInfo()");
		
		for (int i =1; i <=10; i++) {
			Product product =  new Product();
			product.setId(i);
			product.setName("Test Product " + i);
			
			productRepo.saveProduct(product);
			
		} //commit
		
//		System.out.println("method completed : " + "saveProductInfo()");
	}

}
