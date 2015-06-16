$(function() {
	//点击弹出登录框
	$("#login").click(function() {
		$(".alogin").show();
		$(".login").show();
	});
	//点击关闭登录框
	$("#close").click(function() {
		$(".login").hide();
		$(".alogin").hide();
	});
	//擦除提示
	$(".userfor").focus(function(){
		$('#tip').text("");
	});
	//登录表单验证
	$("#login_form").submit(function() {
		var data = {
			username : $("input[name='username']").val(),
			password : $("input[name='password']").val()
		};
		//改变登录按钮文字
		$('#submit').val('登录...');
		$.post('login', data, function(result) {
			if (result == "index") {
				window.location.href = window.location.href;
			} else if(result == "admin"){
				window.location.href = "admin";
			} else if(result == "fail"){
				$('#submit').val('登录');
				$('#tip').text("用户名或密码错误！");
			}
		});
		return false;
	});
	//加载菜单栏
	$.getJSON('js/menu.json',function(data){
		var d = data[0];
		for(var i=0;i < d.length; i++){
			$('#menu').append(
				"<span class='serir'><a href='"+d[i].menuUrl+"' target='"+d[i].target+"'>"+d[i].menuName+"</a></span>");
		}
	});
});


//添加收藏夹
function addToFavorite(title, url) {
	var ua = navigator.userAgent.toLowerCase();
	if (ua.indexOf("360se") > -1) {
		alert("由于360浏览器功能限制，请按 Ctrl+D 手动收藏！");
	} else if (ua.indexOf("msie 8") > -1) {
		window.external.AddToFavoritesBar(url, title); //IE8
	} else if (document.all) {
		try {
			window.external.addFavorite(url, title);
		} catch (e) {
			alert('您的浏览器不支持,请按 Ctrl+D 手动收藏!');
		}
	} else if (window.sidebar) {
		try {
			window.sidebar.addPanel(title, url, "");
		} catch (e) {
			alert('您的浏览器不支持,请按 Ctrl+D 手动收藏!');
		}
	} else {
		alert('您的浏览器不支持,请按 Ctrl+D 手动收藏!');
	}
}