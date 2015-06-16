<!--
	作者：林玉生
	时间：2015-04-27
	描述：公告页面
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
		<link rel="stylesheet" type="text/css" href="../css/font-awesome/style.css" />
		<link rel="stylesheet" type="text/css" href="../js/bootstrap/css/bootstrap.min.css" />
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap/js/bootstrap.min.js"></script>
		<style type="text/css">
		
		</style>
	</head>

	<body>
		<ol class="breadcrumb">
		  <li><a href="">首页</a></li>
		  <li class="active">系统公告</li>
		</ol>
		<div class="panel-group" id="accordion">
		  <div class="panel panel-default">
		    <div class="panel-heading">
		      <h4 class="panel-title">
		      	<span class="badge pull-left">1</span>&nbsp;
		        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
		          	公告一
		        </a>
		      </h4>
		    </div>
		    <div id="collapseOne" class="panel-collapse collapse in">
		      <div class="panel-body">
		        	公告内容公告内容公告内容公告内容公告内容<br />
		        	公告内容公告内容公告内容公告内容公告内容<br />
		        	公告内容公告内容公告内容公告内容公告内容<br />
		        	公告内容公告内容公告内容公告内容公告内容<br />
		        	公告内容公告内容公告内容公告内容公告内容
		      </div>
		    </div>
		  </div>
		  <div class="panel panel-default">
		    <div class="panel-heading">
		      <h4 class="panel-title">
		      	<span class="badge pull-left">2</span>&nbsp;
		        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
		        	公告二
		        </a>
		      </h4>
		    </div>
		    <div id="collapseTwo" class="panel-collapse collapse">
		      <div class="panel-body">
		       		公告内容公告内容公告内容公告内容公告内容
		      </div>
		    </div>
		  </div>
		  <div class="panel panel-default">
		    <div class="panel-heading">
		      <h4 class="panel-title">
		      	<span class="badge pull-left">3</span>&nbsp;
		        <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
		         	公告三
		        </a>
		      </h4>
		    </div>
		    <div id="collapseThree" class="panel-collapse collapse">
		      <div class="panel-body">
		        	公告内容公告内容公告内容公告内容公告内容
		      </div>
		    </div>
		  </div>
		  <div class="panel panel-default">
		    <div class="panel-heading">
		      <h4 class="panel-title">
		      	<span class="badge pull-left">4</span>&nbsp;
		        <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
		         	公告四
		        </a>
		      </h4>
		    </div>
		    <div id="collapseFour" class="panel-collapse collapse">
		      <div class="panel-body">
		        	公告内容公告内容公告内容公告内容公告内容
		      </div>
		    </div>
		  </div>
		</div>
	</body>

</html>