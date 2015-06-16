<!--
	作者：林玉生
	时间：2015-04-27
	描述：角色管理页面
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
		<script type="text/javascript" src="<%=basePath %>js/role-manager.js"></script>
		<style type="text/css">
		.modal{overflow: hidden;}
		</style>
	</head>

	<body>
		<div id="addButton" class="panel panel-info" style="text-align: center;cursor: pointer;margin-bottom: 10px;">
		   <div class="panel-heading">
		   		<h4 class="panel-title" >
		      		<i class="icon-plus"></i>&nbsp;添加角色
		      	</h4>
		   </div>
		</div>
		<div class="panel-group" id="accordion">
			<c:forEach var="role" items="${roleList }" varStatus="s">
			<div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			      	<span class="badge pull-left" style="background: #408CCA;">${s.index+1 }</span>&nbsp;
			        <a style="display:none;">${role.typeId }</a>
			        <a style="display:none;">${role.typeName }</a>
			        <a data-toggle="collapse" data-parent="#accordion" href="#collapse${s.index }">
			          	${role.typeName }(${role.uList.size() })
			        </a>
			        <a href="#editDialog" data-toggle="modal" data-backdrop="false" class="btn btn-default btn-xs pull-right edit">
						<i class="icon-edit"></i> 编辑
					</a>
			      </h4>
			    </div>
			    <c:if test="${role.uList.size() != 0}">
			    <div id="collapse${s.index }" class="panel-collapse collapse">
			      <div class="panel-body">
			        	<table class="table table-bordered table-hover" style="margin-bottom: 0;">
							<thead>
								<tr>
									<th>ID</th>
									<th>帐号</th>
									<th>密码</th>
									<th>电话</th>
									<th>邮箱</th>
									<th>创建时间</th>
								</tr>
							</thead>
							<tbody style="cursor: pointer;">
							
								<c:forEach var="user" items="${role.uList}">
								<tr>
									<td>${user.userId }</td>
									<td>${user.account }</td>
									<td>${user.password }</td>
									<td>${user.mobile }</td>
									<td>${user.email }</td>
									<td>${user.createTime }</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
			      </div>
			    </div>
			    </c:if>
			  </div>
			</c:forEach>
		</div>
		<!-- 添加角色对话框 -->
		<div id="addDialog" data-backdrop="false" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="add-user" aria-hidden="true">
			<div class="modal-dialog" style="width: 300px;margin-top: 15%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">请输入角色名称</h4>
					</div>
					<form id="addForm" role="form" action="roleManager?method=add" method="post">
					<div class="modal-body" style="overflow: hidden;">
						<div class="user-list">
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-group"></i></span>
									<input type="text" name="typeName" class="form-control" required placeholder="角色名">
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
		<!-- 编辑角色对话框  -->
		<div id="editDialog" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 300px;margin-top: 15%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">修改角色名称</h4>
					</div>
					<form id="editForm" role="form" action="roleManager?method=edit" method="post">
					<div class="modal-body" style="overflow: hidden;">
						<div class="user-list">
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-group"></i></span>
									<input type="text" name="typeName" class="form-control"  >
									<input type="hidden" name="typeId" >
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
		
	</body>

</html>