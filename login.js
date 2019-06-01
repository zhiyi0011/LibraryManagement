/**
 * 定义登录的函数 
 */
function login(){
		//用变量接收表单
		var fm=$("#loginForm");
		//调用ajax进行数据的提交，并接收返回数据
		$.ajax({
			url:"lg",//表单的提交
			type:"post",//提交方式
			data:fm.serialize(),//提交到服务器中的数据，需要表单提供S
			dataType:"json",//服务器返回的数据类型
			success:function(dt){
				console.info(dt);
				if(dt.error){
					//登陆成功，跳转页面
					location.href="html/main.html";
				}
				else{
					//登录失败，给出提示
					alert(dt.msg);
				}
			}
		});
}
