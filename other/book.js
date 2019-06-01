/**
 * 
 */
 var cols=[
	 {checkbox:true},
	 {
		 field:"book_id",
		 title:"序号"
	 },
	 {
		 field:"bname",
		 title:"书名"
	 } ,
	 {
		 field:"bauthor",
		 title:"作者"
	 },
	 {
		 field:"borrow",
		 title:"是否借出"
	 },
	 {
		 field:"btype",
		 title:"系别"
	 },
	 {
		 field:"Inventory",
		 title:"库存量"
	 }
	 
	 ];
//添加
//定义变量，用于存储url地址
 var url="";
 function addboos(){
 	$("#tt").text("书籍借阅");
 	url="addB";
 	 addOption();
 	$("#dataForm").modal("show");
 }


//修改
 function editboos(){
		$("#tt").text("修改信息");
		url="editB";
		 addOption();
		
		//获得选中的数据，并且把数据填充到form表单
		//1.获取选中的数据
		var arr=$("#booTable").bootstrapTable("getSelections");
		if(arr.length!=1){
			alert("请选择一行");
			return false;
		}
		//2.将数据填充到form表单中
		$("#book_id").val(arr[0].book_id);
		$("#bname").val(arr[0].bname);
		$("#bauthor").val(arr[0].bauthor);
		$("#borrow").val(arr[0].borrow);
		$("#btype").val(arr[0].btype);
		$("#Inventory").val(arr[0].Inventory);
		
		$("#dataForm").modal("show");
	}

 //删除
 function delboos(){
 	//1.获取选中的数据集
 	var arr=$("#booTable").bootstrapTable("getSelections");
 	if(arr.length!=1){
 		alert("请选择一行");
 		return false;
 	}
 	if(confirm("是否删除")){
 		//调用ajax进行删除
 		$.ajax({
 			url:"delB",
 			data:{
 				"book_id":arr[0].book_id},
 			dataType:"json",
 			success:function(dt){
 				if(dt.error){
 					//刷新表格
 					$("$booTable").bootstrapTable("refresh");
 				}else{
 					alert(dt.msg);
 				}
 			}
 		});
 	}
 }
//给下拉列表添加数据
 function addOption(){
 	$.ajax({
 		url:"showBoo",
 		dataType:"json",
 		success:function(dt){
 			//清空列表项
 			$("#borrow").empty();
 			//添加
 			$("#borrow").append("<option value='是'>是</option>");
 			$("#borrow").append("<option value='否'>否</option>");
 		}
 	});
 }
 //提交按钮的事件
 function dataSubmit(){
 	//alert(url);
 	//1.获得表单元素
 	var fm=$("#BooForm");
 	//2.调用ajax进行数据的提交
 	$.ajax({
 		url:url,
 		type:"post",
 		data:fm.serialize(),
 		dataType:"json",
 		success:function(dt){
 			if(dt.error){
 				$("#dataForm").modal("hide");//隐藏模态框
 				//刷新表格
 				$("#booTable").bootstrapTable("refresh");
 			}else{
 				alert(dt.msg);
 			}
 		}
 	});
 }
 $(document).ready(function(){
 	//调用mytable函数
 	mytable("#booTable","showBoo",cols,"#tbar");
 	//调用给按钮绑定函数的功能
 	$("#addboo").on("click",addboos);
 	$("#editboo").on("click",editboos);
 	$("#btnSub").on("click",dataSubmit);
 	$("#delboo").on("click",delboos);
 });