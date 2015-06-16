$(function(){
	//让ajax变为同步方式
	//$.ajaxSetup({async:false});
	//检查用户账号
	$("#account").on({
		"keyup": function(){
			var ele = $(this),v = ele.val();
		    if(v.length < 5 || v.length > 12){
		    	$('#account_tip').text("账号长度为5-12个字符!");
		    	ele.data("status",0);
		    }else{
		    	$('#account_tip').text("");
		    	ele.data("status",1);
		    }
		},
		"change": function(){
			var ele = $(this),v = ele.val();
			ele.trigger("keyup");
			if(ele.data("status") == 0){
				return;
			}
			ele.data("status",0);
			$.post("register?method=checkUser",{account:v},function(r){
				if(r == 1){
					ele.data("status",1);
				}else{
					$('#account_tip').text("该用户名已被注册！");
					ele.data("status",0);
				}
			});
		}
	});
	//检查密码
	$("#pwd").on("blur keyup change",function(){
		var ele = $(this),v = ele.val();
		if(v.length <6 || v.length >12){
	    	$('#pwd_tip').text("长度为6-12个字符!");
	    	ele.data("status",0);
	    }else{
	    	$('#pwd_tip').text("");
	    	ele.data("status",1);
	    }
	});
	//检查确认密码
	 $("#repwd").on("blur keyup change",function(){
		 var ele = $(this),v = ele.val();
		 var pwd = $("#pwd").val();
		 if(v != pwd){
			 $('#repwd_tip').text("两次输入的密码不一致!");
			 ele.data("status",0);
		 }else{
			 $('#repwd_tip').text("");
			 ele.data("status",1);
		 }
	 });
	//检查验证码
	$("#checkcode").on("blur",function(){
		var ele = $(this),v = ele.val();
		ele.data("status",0);
		$.post("register?method=checkCode",{checkcode:v},function(r){
			if(r == 1){
				$('#checkcode_tip').text("");
				ele.data("status",1);
			}else{
				$('#checkcode_tip').text("验证码不正确！");
				ele.data("status",0);
			}
		});
		
	});
	//提交注册
	$('#registerForm').submit(function(){
		$('#registerForm input[type=button],#registerForm input[type=submit]').data("status",1);
		var inputs = $('#registerForm input');
		var b = true;
		$.each(inputs,function(i,item){
			if(!$(item).data('status')){
				b = false;
			}
		});
		return b;
	});
	
});                             
/**
 * 刷新验证码
 */
function refreshCheckCode(){
	var img = document.getElementById('img_checkcode');
	//这里必须加入随机数不然地址相同（浏览器缓存）无法重新加载 
	img.setAttribute('src', 'register?method=getCheckCode&'+Math.random());	
}
