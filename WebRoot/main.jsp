<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
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
	
	<style type="text/css">
		.westItem{text-align:center;padding:10px}
		.westItem a{text-decoration:none;}
		.westItem a:hover{color:red;}
	</style>
	
	<script type="text/javascript">
		/*
		 *	点击超链接添加选项页的函数
		*/
		function addTabs(title,href){
			var tab=$("#main");
			if(tab.tabs('exists',title)){
			//如果点击的选项卡已经存在，则选中该选项卡
				tab.tabs('select',title);
			}else{
				var content;
				if(href){
					content="<iframe src='"+href+"' style='width:100%;height:100%'></iframe>"
				}else{
					content="此功能还在开发中";
				}
				
				tab.tabs('add',{
					title:title,//标题
					content:content,//选修页内容
					closable:true
				});
			}
		}
	</script>
  </head>
  
  <body class="easyui-layout">
    <div data-options="region:'north',split:false" style="height:205px;background:grey">
    <img alt="" src="images/banner.jpg" width="1520px" height="203px">
    </div>
    <div data-options="region:'west',split:true" style="width:150px" title="导航菜单">
    	<div class="easyui-accordion" fit="true">
    		<div title="供货管理" data-options="iconCls:'icon-save'" style="padding:5px;overflow:auto">
    			<div class="westItem">
    				<a href="javascript:addTabs('供货商列表','list.jsp')">
    					<img alt="" src="images/Communication.gif" align="middle">
    					<span>供货商列表</span>
    				</a>
    			</div>
    			<div class="westItem">
    				<a href="javascript:addTabs('添加供货商','list2.jsp')">
    					<img alt="" src="images/Homework.gif" align="middle">
    					<span>添加供货商</span>
    				</a>
    			</div>
    			<div class="westItem">
    				<a href="javascript:addTabs('权限设置')">
    					<img alt="" src="images/Quiz.gif" align="middle">
    					<span>权限设置</span>
    				</a>
    			</div>
    		</div>
    		<div title="商品管理" data-options="iconCls:'icon-edit'" style="padding:5px;overflow:auto">
    			<div class="westItem">
    				<a href="javascript:addTabs('商品列表','product/list.jsp')">
    					<img alt="" src="images/Communication.gif" align="middle">
    					<span>商品列表</span>
    				</a>
    			</div>
    			<div class="westItem">
    				<a href="javascript:addTabs('添加商品','product/add.jsp')">
    					<img alt="" src="images/Homework.gif" align="middle">
    					<span>添加商品</span>
    				</a>
    			</div>
    			<div class="westItem">
    				<a href="#">
    					<img alt="" src="images/Quiz.gif" align="middle">
    					<span>数据备份</span>
    				</a>
    			</div>
    		</div>
    	</div>
    </div>
    <div data-options="region:'center',split:false" >
    	<div id="main" class="easyui-tabs" fit="true" >
    		<div title="首页" style="padding:10px">
    			<h2>XXX公司首页</h2>
    		</div>
    	</div>
    </div>
  </body>
  </body>
</html>
