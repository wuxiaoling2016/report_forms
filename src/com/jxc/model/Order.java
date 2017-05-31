package com.jxc.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer oid;//订单编号
	private Date otime;//订单日期
	private Customer customer;//买家
	private Integer ostatus;//订单状态：0未完成，1已完成
	private Integer otype;//订单类型：0买进，1退货
	private List<Items> items;//所有订单项
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Date getOtime() {
		return otime;
	}
	public void setOtime(Date otime) {
		this.otime = otime;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getOstatus() {
		return ostatus;
	}
	public void setOstatus(Integer ostatus) {
		this.ostatus = ostatus;
	}
	public Integer getOtype() {
		return otype;
	}
	public void setOtype(Integer otype) {
		this.otype = otype;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	
}
