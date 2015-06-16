<!--
	作者：林玉生
	时间：2015-05-03
	描述：前台菜单管理页面
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
		<script type="text/javascript" src="<%=basePath %>js/menu-manager.js"></script>
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
			<a href="#addDialog" data-toggle="modal" data-backdrop="false" class="btn btn-default" >
				<i class="icon-plus"></i> 添加菜单
			</a>
			<a href="javascript:void(0);" class="btn btn-default" id="deletes">
				<i class="icon-trash"></i> 批量删除
			</a>
			<!-- <a href="#staticDialog" data-toggle="modal" data-backdrop="false" class="btn btn-default">
				<i class="icon-pushpin"></i> 静态化所有菜单
			</a> -->
		</div>
		
		<table class="table table-bordered table-hover">
			<caption>&nbsp;</caption>
			<thead>
				<tr>
					<th width="33">
						<input type="checkbox" id="all-check" />
					</th>
					<th>ID</th>
					<th>菜单名称</th>
					<th>访问资源</th>
					<th>跳转方式</th>
					<th>状态</th>
					<th width="140">操作</th>
				</tr>
			</thead>
			<tbody style="cursor: pointer;">
				<c:forEach var="menu" items="${menuList}">
				<tr>
					<td><input type="checkbox" class="checkbox" /></td>
					<td>${menu.menuId }</td>
					<td>${menu.menuName }</td>
					<td>${menu.menuUrl }</td>
					<td>${menu.target }</td>
					<td>${menu.status }</td>
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

		<!-- 添加对话框 -->
		<div id="addDialog" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="add-user" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">请输入菜单信息</h4>
					</div>
					<form id="addForm" role="form" action="menuManager?method=add" method="post">
					<div class="modal-body" style="overflow: hidden;">
						<div class="user-list">
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-reorder"></i></span>
									<input type="text" name="menuName" class="form-control" required placeholder="菜单名称">
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-link"></i></span>
									<input type="text" name="menuUrl" class="form-control" required placeholder="访问资源">
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-columns"></i></span>
									<select name="target" class="form-control" >
										<option value="">本窗口</option>
								        <option value="_blank">新窗口</option>
									</select>
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-wrench"></i></span>
									<select name="status" class="form-control" >
										<option value="可用">可用</option>
								        <option value="禁用">禁用</option>
									</select>
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
		
		<!-- 编辑对话框  -->
		<div id="editDialog" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">修改菜单信息</h4>
					</div>
					<form id="editForm" role="form" action="menuManager?method=edit" method="post">
					<div class="modal-body" style="overflow: hidden;">
						<div class="user-list">
							<div class="input-group">
								<span class="input-group-addon">ID</span>
								<input type="text" name="menuId" class="form-control" readonly >
							</div>
							<div class="input-group">
									<span class="input-group-addon"><i class="icon-reorder"></i></span>
									<input type="text" name="menuName" class="form-control" required placeholder="菜单名称">
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-link"></i></span>
									<input type="text" name="menuUrl" class="form-control" placeholder="访问资源">
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-columns"></i></span>
									<select name="target" class="form-control" >
										<option value=""></option>
								        <option value="_blank">_blank</option>
									</select>
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="icon-wrench"></i></span>
									<select name="status" class="form-control" >
										<option value="可用">可用</option>
								        <option value="禁用">禁用</option>
									</select>
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

		<!-- 删除对话框 -->
		<div id="deleteDialog" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 300px;margin-top: 15%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">提示</h4>
					</div>
					<div class="modal-body">
						<center><i class="icon-warning-sign"></i>&nbsp;你确定要删除该菜单吗？</center>
					</div>
					<div class="modal-footer" style="margin-top: 0;">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" id="btn-delete">确定</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 批量删除对话框 -->
		<div id="deletesDialog" data-backdrop="false" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 300px;margin-top: 15%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">提示</h4>
					</div>
					<div class="modal-body">
						<center><i class="icon-warning-sign"></i>&nbsp;你确定要删除这些菜单吗？</center>
					</div>
					<div class="modal-footer" style="margin-top: 0;">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" id="btn-deletes">确定</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 静态化对话框 -->
		<!-- 
		<div id="staticDialog" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 300px;margin-top: 15%;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">提示</h4>
					</div>
					<div class="modal-body">
						<center><i class="icon-info-sign"></i>&nbsp;你确定要静态化所有菜单吗？</center>
					</div>
					<div class="modal-footer" style="margin-top: 0;">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" id="staticMenu">确定</button>
					</div>
				</div>
			</div>
		</div>
		 -->
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