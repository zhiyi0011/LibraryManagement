/**
 * 定义表的列，然后调用mytable方法
 */
var cols=[
	{checkbox:true},
	{
		field:"Reader_id",
		title:"编号"
	},
	
	{
		field:"Rname",
		title:"姓名"
	},
	{
		field:"Sex",
		title:"性别"
	},
	{
		field:"Depart",
		title:"系别"
	}
];


//定义变量，用于储存url地址
var url="";
function addReas(){
	$("#tt").text("添加读者");
	url="addR";
	addOption();
//	console.info("123456")
	
	$("#dataForm").modal("show");
}
function editReas(){
	$("#tt").text("修改信息");
	url="editR";
	addOption();
	
	//获得选中的数据，并且把数据填充到form表单
	//1.获取选中的数据
	var arr=$("#reaTable").bootstrapTable("getSelections");
	if(arr.length!=1){
		alert("请选择一行");
		return false;
	}
	//2.将数据填充到form表单中
	$("#Reader_id").val(arr[0].Reader_id);
	$("#Rname").val(arr[0].Rname);
	$("#Sex").val(arr[0].Sex);
	$("#Depart").val(arr[0].Depart);
	$("#dataForm").modal("show");
}
function delReas(){
	//1.获取选中的数据集
	var arr=$("#reaTable").bootstrapTable("getSelections");
	if(arr.length!=1){
		alert("请选择一行");
		return false;
	}
	if(confirm("是否删除")){
		//调用ajax进行删除
		$.ajax({
			url:"delR",
		    data:{
		    	"Reader_id":arr[0].Reader_id
		    },
		    dataType:"json",
		    success:function(dt){
		    	if(dt.error){
		    		//刷新表格
		    		  $("#reaTable").bootstrapTable("refresh");
		    	}else{
		    		alert(dt.msg);
		    	}
		    }
			
		});
		
	}
	
}
//下拉列表

function addOption(){
	$.ajax({
		url:"showRea",
		dataType:"json",
		success:function(dt){
			//清空列表项
			$("#Sex").empty();
			//添加
			$("#Sex").append("<option value='0'></option>");
			$("#Sex").append("<option value='男'>男</option>");
			$("#Sex").append("<option value='女'>女</option>");
		}
	});
}

//提交按钮的事件
function dataSubmit(){
	//1.获得表单元素
	var fm=$("#ReaForm");
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
	    		$("#reaTable").bootstrapTable("refresh");
	    	}else{
	    		alert(dt.msg);
	    	}
	    }
		
	});
	
}
$(document).ready(function(){
	//调用mytable函数
	mytable("#reaTable","showRea",cols,"#tbar");
	
	$("#addRea").on("click",addReas);
	$("#editRea").on("click",editReas);
	$("#btnSub").on("click",dataSubmit);
	$("#delRea").on("click",delReas);

});