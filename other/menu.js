/**
 * 
 */
//定义一个加载页面的函数
function addpage(pageName){
		$.ajax({
			url:pageName,
		    dataType:"html",
		    cache:false,//关闭浏览器的缓存
		    contentType:"application/x-www-form-urlencoded;charset=utf-8",
		    success:function(dt){
		    	$("#page").html(dt);
		    }
		});
	}

$(document).ready(function(){
	//添加菜单项
	$.ajax({
		url:"menu",
		dataType:"json",
		success:function(dt){
			$.each(dt.data,function(i,n){
				//i计数编号，n菜单元素
				//添加主菜单
				//将group1替换为n.mid,将菜单一替换为n.mtitle
				$("#menuContainer").append("<div class='panel panel-warning leftMenu'>" +
						" <div class='panel-heading' data-target='#group" +
						n.mid +
						"' data-toggle='collapse'><h4 class='panel-title' ><span class='glyphicon glyphicon-plus'></span>" +
						n.mtitle +
						" </h4></div><div id='group" +
						n.mid +
						"' class='panel-collapse collapse in'><ul class='list-group'></ul></div></div>");//添加主菜单结束
				
				//添加子菜单
				$.each(n.list,function(j,m){//i计数编号，n为子菜单元素
					$("#group"+n.mid+" ul").append("<li class='list-group-item'>" +
							"<a class='menu-item-left' href='javascript:addpage(\""+m.path+"\")'>" +
							"<span class='glyphicon glyphicon-th-list'><font color='black'></font></span>" +
							m.mtitle +
							"</a></li>");
				});
			})
		}
	});	
	
	
	
	
	
	$(document).on("hidden.bs.collapse shown.bs.collapse",".collapse",function(event){
		 $(this).prev().find(".glyphicon").toggleClass("glyphicon-plus glyphicon-minus");
		// $(this).prev().find("span.pull-right.text-muted").toggleClass("expandir fechar");
		   // event.stopPropagation();
	});
	
	
	
});