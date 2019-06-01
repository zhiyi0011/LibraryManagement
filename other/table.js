/**
 * 定义一个table通用的函数
 */
function mytable(id,url,columns,barId){
	$(id).bootstrapTable({
		url:url,
		method:"post",
		search:true, //搜索框
		columns:columns,
		toolbar:barId,
		striped:true,
		pagination:true,
		pageList:[20],
		pageSize:10,
		pageNumber:1
		
	});
}


//首页头部时间
$(document).ready(
		function() {
			setInterval(function() {
				var date = new Date();
//				var year = date.getFullYear();
//				var month = date.getMonth() + 1;
//				var day = date.getDay();
//				var hour = date.getHours();
//				var minute = date.getMinutes();
//				var second = date.getSeconds();
//				switch (day) {
//				case 1:
//					var week = "星期一";
//					break;
//				case 2:
//					var week = "星期二";
//					break;
//				case 3:
//					var week = "星期三";
//					break;
//				case 4:
//					var week = "星期四";
//					break;
//				case 5:
//					var week = "星期五";
//					break;
//				case 6:
//					var week = "星期六";
//					break;
//				default:
//					var week = "星期天";
//				}

//				var time = year + "-" + month + "-" + day + "&nbsp;" + week
//						+ "&nbsp;" + hour + ":" + minute + ":" + second;
				 var time=date.toLocaleString();
				$("#time").html(time);
			}, 1000);
		});