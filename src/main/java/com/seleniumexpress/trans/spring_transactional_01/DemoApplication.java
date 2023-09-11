package com.seleniumexpress.trans.spring_transactional_01;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.seleniumexpress.trans.spring_transactional_01.config.ProductConfig;
import com.seleniumexpress.trans.spring_transactional_01.service.ProductService;


public class DemoApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);
		context.registerShutdownHook();
		
		ProductService productService = context.getBean("productService", ProductService.class);
		productService.saveProductInfo();
		
		context.close();
	}

}
