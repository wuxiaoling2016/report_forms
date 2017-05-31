package com.jxc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jxc.dao.ProductMapper;
import com.jxc.model.Product;
@Service("productService")
@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
public class ProductServiceImpl implements ProductService{
	@Resource(name="productMapper")
	private ProductMapper dao;
	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public Product findById(Integer pid) {
		return dao.findById(pid);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public void addProduct(Product product) {
		dao.addProduct(product);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public void updateProduct(Product product) {
		dao.addProduct(product);
	}

}
