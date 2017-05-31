package com.jxc.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class PurchaseOrder implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer poid;//进货单编号
	private Product product;//供货商编号
	private Date ptime;//进货时间
	private Integer pstatus;//订单状态 ：0代表未完成，1代表已完成
	private Integer ptype;//订单类别，0代表进货，1代表退货
	private List<Pitems> pitems;//所有的进货单项
	public Integer getPoid() {
		return poid;
	}
	public void setPoid(Integer poid) {
		this.poid = poid;
	}
	
	public Date getPtime() {
		return ptime;
	}
	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}
	public Integer getPstatus() {
		return pstatus;
	}
	public void setPstatus(Integer pstatus) {
		this.pstatus = pstatus;
	}
	public Integer getPtype() {
		return ptype;
	}
	public void setPtype(Integer ptype) {
		this.ptype = ptype;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Pitems> getPitems() {
		return pitems;
	}
	public void setPitems(List<Pitems> pitems) {
		this.pitems = pitems;
	}
	
}
