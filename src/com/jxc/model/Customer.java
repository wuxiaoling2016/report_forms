package com.jxc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer cid;//客户编号
	private String cname;//客户姓名
	private List<Order> orders=new ArrayList<Order>();//用户的订单
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
