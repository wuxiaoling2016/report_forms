var editRow=undefined;//用于记录当前正在被编辑的行号

$(function(){
	
	$("#dgProduct").datagrid({
		url:"listProduct",
		title:"产品信息表",
		nowrap:true,//不自动换行
		rownumbers:true,//显示行号
		striped:true,//显示斑马线
		columns:[[
		     {field:"id",title:"编号",width:50,checkbox:true},
		     {field:"pid",title:"产品编号",width:100,sortable:true,
		    	 //添加列编辑器
		    	 editor:{
		    		type:"numberbox" ,
		    		options:{
		    			required:true,
		    			min:1,
		    			max:9999
		    		}
		    	 }
		     },
		     {field:"pname",title:"产品名称",width:100,sortable:true,
		    	 editor:{
			    		type:"validatebox" ,
			    		options:{
			    			required:true			    			
			    		}
			    	 }},
		     {field:"brand",title:"产品品牌",width:100,sortable:true,
		    	 editor:{
			    		type:"validatebox" ,
			    		options:{
			    			required:true			    			
			    		}
			    	 }},
		     {field:"quantity",title:"数量",width:100,sortable:true,
		    	 editor:{
			    		type:"numberbox" ,
			    		options:{
			    			required:true,
			    			min:1,
			    			precision:0//小数位数
			    		}
			    	 }},
			{field : "price",
				title : "价格",
				width : 100,
				sortable : true,
				editor : {
					type : "numberbox",
					options : {
						required : true,
						min : 1,
						precision : 2 //小数位数
					}
				}},
			{field:"cost",title:"成本",width:100,sortable:true,
			    editor:{
				    	type:"numberbox" ,
				    	options:{
				    		required:true,
				    		min:1,
				    		precision:2//小数位数
				    		}
				    	 }}

		]],
		pagination:true,//显示分页工具栏
		pageSize:10,//初始页面大小
		pageList:[2,5,10,20],//页面大小的下拉列表
		sortName:"pid",//初始排序列
		sortOrder:"DESC",//初始排序规则
		toolbar:"#editTool",//绑定工具栏
		//完成编辑一行时触发的事件
		onAfterEdit:function(rowIndex,rowData,changes){
			//alert($.param(rowData));
			
			//获取新修改的行数组
			var updated=$("#dgProduct").datagrid('getChanges','updated');
			var url="";
			var state="";
			
			
			if(updated.length>0){
				url="updateProduct";
				state="修改";
			}
			
			$.ajax({
				url:url,
				type:"POST",
				data:$.param(rowData),
				//发送请求前事件
				beforeSend:function(){
					//进入数据加载状态
					$("#dgProduct").datagrid("loading");
				},
				success:function(data){
					//结束加载状态
					$("#dgProduct").datagrid("loaded");
					//加载第一页数据
					$("#dgProduct").datagrid("load");
					$.messager.show({
						title:"提示信息",
						msg:data+"个产品信息"+state+"成功"
					});
					editRow=undefined;
				}
			});
			
		}
	});
	$("#printProduct").click(function(){
		if(confirm("你确定要打印吗？")){
			document.location.href="printProduct";
		};
		
	});
	$("#printProductChart1").click(function(){
		if(confirm("你确定要生成柱状图吗？")){
			document.location.href="product/chart1.jsp";
		};
		
	});
});


/*
*	查询按钮事件
*/
function advSearch(){
	//向后台传参数ename的值，并重新加载和显示第一页数据
	$("#dgProduct").datagrid('load',{'pname':$.trim($("#pname").val())});
}



//撤销按钮事件
function redoProduct(){
	$("#dgProduct").datagrid('rejectChanges');
	$("#save,#redo").hide();//隐藏保存和撤销按钮
	editRow=undefined;
}

//保存按钮事件
function saveProduct(){
	$("#save,#redo").hide();//隐藏保存和撤销按钮
	//结束行编辑状态
	$("#dgProduct").datagrid('endEdit',editRow);
	
}

//修改按钮事件
function updateEmp(){
	//获取所有选中行的数组
	var rows=$("#dgProduct").datagrid('getSelections');
	if(rows.length==0){
		$.messager.alert("警告","请选择一行进行修改","warning");
	}else if(rows.length>1){
		$.messager.alert("警告","只能选择一行进行修改","warning");
	}else{
		$("#save,#redo").show();//显示保存和撤销按钮
		//获取选择行的索引值
		var rowIndex=$("#dgProduct").datagrid('getRowIndex',rows[0]);
		$("#dgProduct").datagrid('beginEdit',rowIndex);
		//获取员工编号列的编辑器
		var cell=$("#dgProduct").datagrid('getEditor',{index:rowIndex,field:"pid"});
		//设置empno编号列的编辑器状态为只读
		cell.target.prop("readonly",true);
		editRow=rowIndex;
	}
}










