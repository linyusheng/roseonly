<!-- 
  	作者：林玉生
	时间：2015-05-10
	描述：我的收藏
 -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="css/public.css" />
		<link rel="stylesheet" type="text/css" href="css/shopping.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/public.js" ></script>
	</head>

	<body>
		<!-- 引入头部导航 -->
		<jsp:include flush="true" page="public/header.jsp"></jsp:include>
		
		<div class="container">
		    <div class="title">
		        <a href="./"><img class="img" src="img/roseonly.jpg" /></a>
		    </div>
		    <div class="content">
		        <div class="order">
			        <ul>
			            <li><a href="order?method=getOrders">我的订单</a></li>
			            <li><a href="user">基本信息</a></li>
			            <li><a href="user?method=editPwdPage">修改密码</a></li>
			            <li class="active_li"><a href="collect?method=myCollect">我的收藏</a></li>
			            <li><a href="recaddress?method=getAddress">收货地址</a></li>
			        </ul>
			        <table cellspacing="0">
			            <tr class="shopping_cart_title">
			            	<td>序号</td>
			                <td>商品图</td>
			                <td>名称</td>
			                <td>单价</td>
			                <td>操作</td>
			            </tr>
			            <c:forEach var="collect" items="${collectList}" varStatus="s">
			            <tr>
			            	<td>${s.index+1 }</td>
			                <td width="380px">
			                    <a href="roseinfo?roseId=${collect.roseId }"><img src="${collect.picture }" width="100px" style="vertical-align: middle;"/></a>
			                </td>
			                <td>${collect.roseName }</td>
			                <td>￥${collect.rosePrice }</td>
			                <td><a href="collect?method=delete&collectId=${collect.collectId }">删除</a></td>
			            </tr>
			            </c:forEach>
			        </table>
			        
			    </div>
			</div>
		    <div class="footer">
		        <img class="QR-small" src="img/QR-small.jpg" />
		        <div class="icon-cell">
		            <img src="img/icon_store.png" />
		            <span>实体店</span>
		        </div>
		        <div class="icon-cell">
			        <img src="img/icon_care.png" />
			        <span>保养物语</span>
		        </div>
		        <div class="icon-cell">
		            <img src="img/icon_finger.png" />
		            <span>指圈测量</span>
		        </div>
		        <div class="icon-cell">
		            <img src="img/icon_per.png" />
		            <span>个人中心</span>
		        </div>
		    </div>
		</div>
		<div class="foot-nav">
		    <ul>
		        <a href="#"><li class="about-us">关于我们</li></a>
		        <li>|</li>
		        <a href="#"><li>常见问题</li></a>
		        <li>|</li>
		        <a href="#"><li>加入我们</li></a>
		        <li>|</li>
		        <a href="#"><li>退换条例</li></a>
		        <li>|</li>
		        <a href="#"><li>新浪微博</li></a>
		    </ul>
	        <span>韶关学院信息科学与工程学院12计算机03班No.1组</span>
		</div>
    </body>
</html>