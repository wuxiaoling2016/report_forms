package com.jxc.model;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer uid;
	private String uname;
	private String upwd;
	private Integer utype;//用户类型，只有高等级的才可以管理账号
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public Integer getUtype() {
		return utype;
	}
	public void setUtype(Integer utype) {
		this.utype = utype;
	}
	
}
