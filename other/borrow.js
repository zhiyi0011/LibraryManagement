/**
 * 定义表的列，然后调用mytable方法
 */
var cols=[
	{checkbox:true},
	{
		field:"Borrow_id",
		title:"编号"
	},
	{
		field:"Reader_id",
		title:"读者编号"
	},
	{
		field:"book_id",
		title:"书号"
	},
	{
		field:"Borrow_date",
		title:"借阅日期"
	},
	{
		field:"Send_date",
		title:"归还日期"
	},
	{
		field:"Continue_send",
		title:"是否续借"
	}
];
//定义变量，用于存储url地址
var url="";
function addBors(){
	$("#tt").text("书籍借阅办理");
	url="addBorrow";
	addOption();
	$("#dataForm").modal("show");
}

function editBors(){
	$("#tt").text("更改借阅信息");
	url="editBorrow";
	addOption();
	//获得选中的数据，并且把数据填充到form表单上
	//1.获取选中的数据集
	var arr=$("#borTable").bootstrapTable("getSelections");
	if(arr.length!=1){
		alert("请选择一行");
		return false;
	}
	//2。将数据填充到form表单中
	$("#Borrow_id").val(arr[0].Borrow_id);
	$("#Reader_id").val(arr[0].Reader_id);
	$("#book_id").val(arr[0].book_id);
	$("#Borrow_date").val(arr[0].Borrow_date);
	$("#Send_date").val(arr[0].Send_date);
	
	$("#dataForm").modal("show");
}

function delBors(){
	//1.获取选中的数据集
	var arr=$("#borTable").bootstrapTable("getSelections");
	if(arr.length!=1){
		alert("请选择一行");
		return false;
	}
	if(confirm("是否删除")){
		//调用ajax进行删除
		$.ajax({
			url:"delBorrow",
			data:{
				"Borrow_id":arr[0].Borrow_id},
			dataType:"json",
			success:function(dt){
				if(dt.error){
					//刷新表格
					$("$borTable").bootstrapTable("refresh");
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
		url:"showBor",
		dataType:"json",
		success:function(dt){
			//清空列表项
			$("#Continue_send").empty();
			//添加
			$("#Continue_send").append("<option value='是'>是</option>");
			$("#Continue_send").append("<option value='否'>否</option>");
		}
	});
}
//提交按钮的事件
function dataSubmit(){
	//alert(url);
	//1.获得表单元素
	var fm=$("#BorForm");
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
				$("#borTable").bootstrapTable("refresh");
			}else{
				alert(dt.msg);
			}
		}
	});
}
$(document).ready(function(){
	//调用mytable函数
	mytable("#borTable","showBor",cols,"#tbar");
	//调用给按钮绑定函数的功能
	$("#addBor").on("click",addBors);
	$("#editBor").on("click",editBors);
	$("#btnSub").on("click",dataSubmit);
	$("#delBor").on("click",delBors);
});