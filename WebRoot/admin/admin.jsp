<!--
	作者：林玉生
	时间：2015-04-27
	描述：后台主界面
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title> roseonly后台管理系统 </title>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/font-awesome/style.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>js/bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/admin.css"/>
		<script type="text/javascript" src="<%=basePath %>js/jquery.min.js" ></script>
		<script type="text/javascript" src="<%=basePath %>js/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/admin.js" ></script>
	</head>
	
	<body>
		<!--顶部导航栏-->
		<div class="bar">
			<a href="" class="pull-left">
				<h4>
					<i class="icon-cloud"></i> roseonly后台管理系统
				</h4>
			</a>
			<div class="pull-right">
				<a href="javasrcipt:void(0);">欢迎你，${user.account}</a>
				<a href="#myInfo_dialog" data-toggle="modal" data-backdrop="static">
					<i class="icon-user"></i> 个人信息
				</a>
				<a href="#editPsw_dialog" data-toggle="modal" data-backdrop="static">
					<i class="icon-cog"></i> 修改密码
				</a>
				<a href="logout">
					<i class="font-icon icon-off"></i> 注销
				</a>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-2">
					<a href="admin/notice.jsp" class="list-group-item" target="main">
						<i class="icon-bullhorn"></i> 系统公告
					</a>
					<a href="userManager" class="list-group-item" target="main">
						<i class="icon-user"></i> 用户管理
					</a>
					<a href="roleManager" class="list-group-item" target="main">
						<i class="icon-group"></i> 角色管理
					</a>
					<a href="menuManager" class="list-group-item" target="main">
						<i class="icon-list"></i> 菜单管理
					</a>
					<a href="roseManager" class="list-group-item" target="main">
						<i class="icon-heart"></i> 玫瑰管理
					</a>
					<a href="orderManager" class="list-group-item" target="main">
						<i class="icon-list-alt"></i> 订单管理
					</a>
					<!-- <a href="shoppingManager" class="list-group-item" target="main">
						<i class="icon-shopping-cart"></i> 购物车管理
					</a> -->
					<!-- <a href="brandManager" class="list-group-item" target="main">
						<i class="icon-bookmark"></i> 玫瑰品牌管理
					</a> -->
					<a href="storyManager" class="list-group-item" target="main">
						<i class="icon-bookmark"></i> 玫瑰故事管理
					</a>
				</div>
				<div class="col-lg-10">
					<iframe name="main" src="userManager" width="99%" height="550" id="frame_content"  frameborder="0" framespacing="0" scrolling="no"></iframe>
					<script type="text/javascript">
					    function reinitIframe(){
					    var iframe = document.getElementById("frame_content");
					    try{
					    var bHeight = iframe.contentWindow.document.body.scrollHeight;
					    var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
					    var height = Math.max(bHeight, dHeight);
					    iframe.height =  height;
					    }catch (ex){}
					    }
					    window.setInterval("reinitIframe()", 200);
					</script>
				</div>
			</div>
			
		</div>
		<!--个人信息模态框-->
		<div id="myInfo_dialog" class="modal fade"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content" style="margin:100px auto;">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">个人信息</h4>
					</div>
					<form class="bs-example bs-example-form" role="form" id="myInfo_form" action="">
					<div class="modal-body" style="overflow: hidden;">
						<div class="user-list">
							<div class="input-group">
								<span class="input-group-addon">帐号</span>
								<input type="text" class="form-control" value="${user.account}" readonly="true">
							</div>
							<div class="input-group">
								<span class="input-group-addon">角色</span>
								<input type="text" class="form-control" value="${userType}" readonly="true">
							</div>
							<div class="input-group">
								<span class="input-group-addon">邮箱</span>
								<input type="email" class="form-control" name="email" value="${user.email}" id="email" required>
							</div>
							<div class="input-group">
								<span class="input-group-addon">电话</span>
								<input type="number" class="form-control" name="mobile" value="${user.mobile}" id="mobile" required>
							</div>
							<div class="input-group">
								<span class="input-group-addon">注册时间</span>
								<input type="text" class="form-control" value="${user.createTime}" readonly="true">
							</div>
							
						</div>
					</div>
					<div class="modal-footer" style="margin-top: 0;">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="关闭" />
						<input type="submit" class="btn btn-primary" value="提交更改" />
					</div>
					</form>
				</div>
			</div>
		</div>
		<!--修改密码模态框-->
		<div id="editPsw_dialog" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content" style="margin:100px auto; width:310px;">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">修改密码</h4>
					</div>
					<form class="bs-example bs-example-form" role="form" id="editPsw_form" action="">
					<div class="modal-body" style="overflow: hidden;">
						<div class="user-list">
							<div class="input-group">
								<span class="input-group-addon">原密码</span>
								<input type="password" name="oldPsd" required class="form-control" />
							</div>
							<div class="input-group">
								<span class="input-group-addon">新密码</span>
								<input type="password" name="newPsd" required class="form-control" />
							</div>
							<div class="input-group" style="margin-bottom: 0;">
								<span class="input-group-addon">确认密码</span>
								<input type="password" name="confirmPsd" required class="form-control" />
							</div>
						</div>
					</div>
					<div class="modal-footer" style="margin-top: 0;">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="关闭" />
						<input type="submit" class="btn btn-primary" id="" value="提交更改" />
						<input type="reset" id="reset" style="display:none;" />
					</div>
					</form>
				</div>
			</div>
		</div>
		<!-- 提示框 -->
		<div id="tip_dialog" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content" style="margin:100px auto; width:250px;">
					<div class="modal-body" style="overflow: hidden;text-align: center;">
						<div id="tip_content"></div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>