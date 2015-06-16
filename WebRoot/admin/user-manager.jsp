<!--
	作者：林玉生
	时间：2015-04-27
	描述：用户管理页面
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
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/font-awesome/style.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>js/bootstrap/css/bootstrap.min.css"/>
		<script type="text/javascript" src="<%=basePath %>js/jquery.min.js" ></script>
		<script type="text/javascript" src="<%=basePath %>js/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/user-manager.js"></script>
		<style type="text/css">
			.input-group-addon {cursor: pointer;}
			.input-group {margin:0 auto;width: 264px;margin-bottom: 10px;}
			.input-group:last-child {margin-bottom: 0;}
			.modal{overflow: hidden;}
			#addDialog .input-group-addon,#editDialog .input-group-addon{width:39px;}
		</style>
	</head>

	<body>

		<div class="btn-group" style="float: left;">
			<a href="#addDialog" data-toggle="modal" data-backdrop="false" class="btn btn-default">
				<i class="icon-plus"></i> 新增用户
			</a>
			<a href="javascript:void(0);" class="btn btn-default" id="delete-users">
				<i class="icon-trash"></i>  批量删除
			</a>
		</div>
		<form id="searchForm" action="userManager?method=searchUser" method="post">
			<div class="input-group" style="float:left;width:200px;margin-left: 100px ;">
				<input type="text" name="q" class="form-control" required placeholder="帐号，邮箱，手机">
				<span class="input-group-addon" id="search"><i class="icon-search"></i></span>
				<button type="submit" id="searchSubmit" style="display:none;"></button>
			</div>
		</form>
		<table class="table table-bordered table-hover">
			<caption>&nbsp;</caption>
			<thead>
				<tr>
					<th width="33">
						<input type="checkbox" id="all-check" />
					</th>
					<th>ID</th>
					<th>用户类型</th>
					<th>帐号</th>
					<th>密码</th>
					<th>电话</th>
					<th>邮箱</th>
					<th>创建时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody style="cursor: pointer;">
				<c:forEach var="user" items="${requestScope.pageVO.rows}">
				<tr>
					<td>
						<input type="checkbox" class="checkbox" />
					</td>
					<td>${user.userId }</td>
					<td style="display:none;">${user.typeId }</td>
					<td>${user.typeName }</td>
					<td>${user.account }</td>
					<td>${user.password }</td>
					<td>${user.mobile }</td>
					<td>${user.email }</td>
					<td>${user.createTime }</td>
					<td>
						<a href="#editDialog" data-toggle="modal" data-backdrop="false" class="btn btn-default btn-xs edit">
							<i class="icon-edit"></i> 编辑
						</a>
						<a href="#deleteDialog" data-toggle="modal" data-backdrop="false" class="btn btn-default btn-xs delete">
							<i class="icon-trash"></i> 删除
						</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:choose>
			<c:when test="${q == null }">
				<jsp:include flush="true" page="allUserPage.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include flush="true" page="searchUserPage.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>

		<!--<div class="input-group" style="float:right;width: 160px;">
			<span class="input-group-addon">跳转</span>
			<input type="text" class="form-control" value="1">
			<span class="input-group-addon">共&nbsp;5&nbsp;页</span>
		</div>-->


		<!-- 添加用户对话框 -->
		<div id="addDialog" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="add-user" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">请输入用户信息</h4>
					</div>
					<form id="addForm" role="form" action="userManager?method=add" method="post">
					<div class="modal-body" style="overflow: hidden;">
						<div class="user-list">
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-group"></i></span>
									<select name="typeId" class="form-control" >
										<option value="1">普通用户</option>
								        <option value="2">VIP用户</option>
								        <option value="3">黄钻用户</option>
								        <option value="4">超级管理员</option>
								        <option value="5">管理员</option>
									</select>
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-user"></i></span>
									<input type="text" name="account" id="account" class="form-control" required placeholder="帐号">
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-key"></i></span>
									<input type="password" name="password" class="form-control" required placeholder="密码">
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-envelope"></i></span>
									<input type="email" name="email" class="form-control" placeholder="邮箱">
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-tablet"></i></span>
									<input type="number" name="mobile" class="form-control" placeholder="手机">
								</div>
						</div>
					</div>
					<div class="modal-footer" style="margin-top: 0;">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">提交</button>
						<button type="reset" class="reset" style="display:none;"></button>
					</div>
					</form>
				</div>
			</div>
		</div>
		
		<!-- 编辑用户对话框  -->
		<div id="editDialog" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
					</div>
					<form id="editForm" role="form" action="userManager?method=edit" method="post">
					<div class="modal-body" style="overflow: hidden;">
						<div class="user-list">
								<div class="input-group">
									<span class="input-group-addon">ID</span>
									<input type="text" name="userId" class="form-control" readonly >
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-group"></i></span>
									<select name="typeId" class="form-control" >
										<option value="1" >普通用户</option>
								        <option value="2">VIP用户</option>
								        <option value="3">黄钻用户</option>
								        <option value="4">超级管理员</option>
								        <option value="5">管理员</option>
									</select>
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-user"></i></span>
									<input type="text" name="account" class="form-control" readonly >
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-key"></i></span>
									<input type="password" name="password" class="form-control" required >
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-envelope"></i></span>
									<input type="email" name="email" class="form-control" placeholder="邮箱">
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-tablet"></i></span>
									<input type="number" name="mobile" class="form-control" placeholder="手机">
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-time"></i></span>
									<input type="text" name="createTime" class="form-control" readonly >
								</div>
						</div>
					</div>
					<div class="modal-footer" style="margin-top: 0;">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">提交</button>
						<button type="reset" class="reset" style="display:none;"></button>
					</div>
					</form>
				</div>
			</div>
		</div>

		<!-- 删除用户对话框 -->
		<div id="deleteDialog" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 300px;margin-top: 15%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">提示</h4>
					</div>
					<div class="modal-body">
						<center><i class="icon-warning-sign"></i>&nbsp;你确定要删除该用户吗？</center>
					</div>
					<div class="modal-footer" style="margin-top: 0;">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" id="btn-delete-user">确定</button>
					</div>
				</div>
			</div>
		</div>
		<!-- 批量删除用户对话框 -->
		<div id="deletesDialog" data-backdrop="false" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 300px;margin-top: 15%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">提示</h4>
					</div>
					<div class="modal-body">
						<center><i class="icon-warning-sign"></i>&nbsp;你确定要删除这些用户吗？</center>
					</div>
					<div class="modal-footer" style="margin-top: 0;">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" id="btn-deletes-user">确定</button>
					</div>
				</div>
			</div>
		</div>
		<!-- 提示对话框 -->
		<div id="tip_dialog" data-backdrop="false" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 300px;margin-top: 15%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">提示</h4>
					</div>
					<div class="modal-body" style="overflow: hidden;text-align: center;">
						<div id="tip_content"></div>
					</div>
					<div class="modal-footer" style="margin-top: 0;">
						<button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>