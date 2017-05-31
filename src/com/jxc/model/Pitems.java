package com.jxc.model;

import java.io.Serializable;

public class Pitems implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer piid;//进货项编号
	private PurchaseOrder purchaseOrder;//进货单
	private Product product;//进货产品
	private Integer pipquantity;//进货数量
	public Integer getPiid() {
		return piid;
	}
	public void setPiid(Integer piid) {
		this.piid = piid;
	}
	
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getPipquantity() {
		return pipquantity;
	}
	public void setPipquantity(Integer pipquantity) {
		this.pipquantity = pipquantity;
	}
	
}
