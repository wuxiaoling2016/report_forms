package com.jxc.service;

import java.util.List;

import com.jxc.model.Product;

public interface ProductService {
	List<Product> findAll();
	Product findById(Integer pid);
	void addProduct(Product product);
	void updateProduct(Product product);
}
