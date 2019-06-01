
/**
 * 定义表的列，然后调用mytable方法
 */
var cols=[
	{checkbox:true},
	{
		field:"demage_id",
		title:"编号"
	},
	{
		field:"dname",
		title:"图书名字"
	},
	{
		field:"writer",
		title:"作者"
	},
	{
		field:"dtype",
		title:"图书系别"
	},
	{
		field:"dInventory",
		title:"图书存量"
	},
	{
		field:"damage",
		title:"是否损坏"
	}
];
//定义变量，用于存储url地址
function editDems(){
	$("#tt").text("图书报损");
	url="editD";
	//获得选中的数据，并且把数据填充到form表单
	//1.获取选中的数据
	var arr=$("#demTable").bootstrapTable("getSelections");
	if(arr.length!=1){
		alert("请选择一行");
		return false;
	}
	//2.将数据填充到form表单中
	$("#demage_id").val(arr[0].demage_id);
	//$("#dname").val(arr[0].dname);
	//$("#writer").val(arr[0].writer);
	//$("#dtype").val(arr[0].dtype);
	//$("#dInventory").val(arr[0].dInventory);
	//$("#Inventory").val(arr[0].Inventory);
	/*$("#damage").val(arr[0].damage);*/
	
	$("#dataForm").modal("show");
}

//提交按钮的事件
function dataSubmit(){
	//alert(url);
	//1.获得表单元素
	var fm=$("#DemForm");
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
				$("#demTable").bootstrapTable("refresh");
			}else{
				alert(dt.msg);
			}
		}
	});
}
$(document).ready(function(){
	//调用mytable函数
	mytable("#demTable","Dem",cols,"#tbar");
	//调用给按钮绑定函数的功能
	$("#editDem").on("click",editDems);
	$("#btnSub").on("click",dataSubmit);
});