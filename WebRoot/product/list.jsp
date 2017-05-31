<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
	<script type="text/javascript" src="js/productlist.js"></script>
  </head>
  
  <body>
    <div class="easyui-layout" fit="true">
  		<div data-options="region:'north'" title="高级查询" style="height:80px;padding:10px">
  			<input type="text" placeholder="产品名称" id="pname">
  			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="advSearch()">查询</a>
  		</div>  	
    <div data-options="region:'center'">
    	<div id="editTool">
    		<!-- plain=true设置按钮的平滑显示效果 -->
    		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="updateProduct()" plain="true">修改</a>
    		<a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="saveProduct()" plain="true" style="display:none" id="save">保存</a>
    		<a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="redoProduct()" plain="true" style="display:none" id="redo">撤销</a>
    		<a href="" class="easyui-linkbutton" iconCls="icon-print" onclick="printProduct()" plain="true" id="printProduct">打印</a>
    		<a href="" class="easyui-linkbutton" iconCls="icon-print" onclick="printProductChart1()" plain="true" id="printProductChart1">生成柱状图</a>
    	</div>
    	<table id="dgProduct"></table>
    </div>
    </div>
  </body>
</html>
