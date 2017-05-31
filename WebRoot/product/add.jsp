<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="jquery-easyui-1.3.6/jquery.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.6/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.6/themes/icon.css">
  </head>
  
  <body>
  	<h2>添加新产品</h2>
    <form action="addProduct" method="post" enctype="multipart/form-data">
    	<table border="0">
    		<tr><td>产品名：</td><td><input type="text" placehoder="请输入产品名" name="pname"></td></tr>
    		<tr><td>产品品牌：</td><td><input type="text" placehoder="请输入产品品牌" name="brand"></td></tr>
    		<tr><td>产品数量：</td><td><input type="text" placehoder="请输入产品数量" name="quantity"></td></tr>
    		<tr><td>产品价格：</td><td><input type="text" placehoder="请输入产品价格" name="price"></td></tr>
    		<tr><td>产品成本：</td><td><input type="text" placehoder="请输入产品成本" name="cost"></td></tr>
    		<tr><td>产品图片：</td><td><input type="file" placehoder="请上传产品图片" name="myfile"></td></tr>
    		<tr><td><input type="submit" value="提交"></td><td><input type="reset" value="重置"></td></tr>
    	</table>
    </form>
  </body>
</html>
