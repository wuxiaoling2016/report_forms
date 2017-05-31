package com.jxc.model;

import java.io.Serializable;

public class Items implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer iid;//订单项编号
	private Order order;//订单信息
	private Product product;//产品信息
	private Integer ipquantity;//产品数量
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getIpquantity() {
		return ipquantity;
	}
	public void setIpquantity(Integer ipquantity) {
		this.ipquantity = ipquantity;
	}
	
}
