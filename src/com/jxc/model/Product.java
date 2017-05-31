package com.jxc.model;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pid;
	private String pname;
	private String brand;//商品品牌
	private Integer quantity;
	private Double price;
	private Double cost;//商品成本
	private String picture;//图片路径
	private List<Supplier> suppliers;//所有的供货商
	private List<Pitems> pitems;//所有进单项
	private List<Items> items;//所有订单项
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public List<Supplier> getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
	public List<Pitems> getPitems() {
		return pitems;
	}
	public void setPitems(List<Pitems> pitems) {
		this.pitems = pitems;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
