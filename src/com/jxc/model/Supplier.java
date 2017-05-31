package com.jxc.model;

import java.io.Serializable;
import java.util.List;

public class Supplier implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer sid;
	private String sname;//供货商厂家名
	private String contact;//联系人姓名
	private String sphone;//联系人电话
	private List<Product> products;//拥有的所有商品
	private List<PurchaseOrder> purchaseOrders;//所有的进货单
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}
	public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}
	
}
