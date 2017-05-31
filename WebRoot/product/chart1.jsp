<%@ page language="java" import="java.util.*,com.jxc.jfreecharts.ProductCharts" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chart1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  	<%
  	ProductCharts pc=new ProductCharts();
	String fileName=pc.genBarChart(session, request, response);
	System.out.println(fileName);
	%>
    <img src="DisplayChart?filename=<%=fileName %>" width="700" height="500" border="1"/>
  </body>
</html>
