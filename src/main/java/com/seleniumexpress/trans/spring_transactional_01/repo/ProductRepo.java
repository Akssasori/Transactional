package com.seleniumexpress.trans.spring_transactional_01.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.seleniumexpress.trans.spring_transactional_01.model.Product;

@Repository
public class ProductRepo {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveProduct(Product product) {
		
		String sql = "INSERT INTO PRODUCT VALUES (?,?)";
		Object[] args = {product.getId(), product.getName()};
		jdbcTemplate.update(sql, args);
		
		System.out.println("product saved...");
	}

}

/* @Transactional(propagation = Propagation.REQUIRES_NEW) >> suspend an active trans, if any. 
create a new trans, and execute the code under it */

