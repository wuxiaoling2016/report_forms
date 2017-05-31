package com.jxc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 测试连接成功
 */
public class DBUtil {
	private static final String driverName="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/jxc?serverTimezone=UTC";
               
	private static final String username="jxc";
	private static final String password="tiger";
	static{
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		Connection conn=DBUtil.getConnection();
		System.out.println(conn);
	}
}
