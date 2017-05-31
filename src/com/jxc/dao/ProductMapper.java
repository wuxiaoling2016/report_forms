package com.jxc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jxc.model.Product;

@Repository("productMapper")
public interface ProductMapper {
	List<Product> findAll();
	Product findById(Integer pid);
	void addProduct(Product product);
	void updateProduct(Product product);
}
