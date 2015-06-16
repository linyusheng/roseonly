<!-- 
  	作者：冯金凤
	时间：2015-05-10
	描述：基本信息页
 -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
	<head>
	<title>基本信息</title>
	<link rel="stylesheet" type="text/css" href="css/public.css" />
	<link rel="stylesheet" type="text/css" href="css/shopping.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/public.js" ></script>
	<script type="text/javascript">
		
	</script>
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
			            <li class="active_li"><a href="user">基本信息</a></li>
			            <li><a href="user?method=editPwdPage">修改密码</a></li>
			            <li><a href="collect?method=myCollect">我的收藏</a></li>
			            <li><a href="recaddress?method=getAddress">收货地址</a></li>
			        </ul>
			        
			        <div class="userinfo">
						<!-- 表格 -->
						<form action="user?method=edit" method="post" id="qy_form">
						<table cellpadding="0" cellspacing="0">
							<tr>
								<td>帐号</td>
								<td>
									<input name="account" type="text" value="${user.account }" maxlength="15" disabled="disabled"/>
								</td>
							</tr>
							<tr>
								<td>手机</td>
								<td>
									<input name="mobile" type="number" value="${user.mobile }" maxlength="11" required="required"/>
								</td>
							</tr>
							<tr>
								<td>邮箱</td>
								<td>
									<input name="email" type="email" value="${user.email }" required="required"/>
								</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<input type="submit" value="提交修改" onclick="return checkuserInfo();" />
								</td>
	
							</tr>
						</table>
						</form>
					</div>
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
