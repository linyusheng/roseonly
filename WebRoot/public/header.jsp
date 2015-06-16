<!--
	作者：林玉生
	时间：2015-04-27
	描述：顶部导航栏
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 头部导航 -->
<div class="header">
	<div class="head">
		<a href="./" class="roseonly-logo"></a>
		<div class="right">
			<c:if test="${user.userId != null}">
				<a id="user_center" href="order?method=getOrders" title="个人中心">个人中心&nbsp;|</a>
				<a id="logout" href="logout" title="注销">&nbsp;注销</a>
				<a href="shopping?method=seeMyCart" title="购物车" class="right-shop"><span id="cartNum">购物车</span></a>
			</c:if>
			<c:if test="${user.userId == null}">
				<a id="login" href="javascript:void(0);" title="登录">登录&nbsp;|</a>
				<a id="register" href="register" title="注册" >&nbsp;注册</a>
			</c:if>
			<a class="left">热线电话 183-1602-2547&nbsp;</a>
			<a href="javascript:void(0);" title="收藏夹" class="collect" onclick="addToFavorite('roseonly玫瑰礼盒_多色玫瑰花_roseonly优惠券_玫瑰花礼盒_roseonly诺誓官网 ','http://www.roseonly.com.cn/');">收藏夹</a>
		</div>
	</div>
</div>
<!--淡白色阴影层alogin -->
<div class="alogin"></div>
<!--登录界面的div login-->
<div class="login">
	<!--登陆界面中的标题div-->
	<div class="title">
		<a href="javascript:void(0);" id="close"><img src="img/close.png" /></a>
	</div>
	<div class="login_logo"><img src="img/bounced01.png" /></div>
	<!--表单-->
	<form action="" method="post" id="login_form">
		<div class="userpass username">
			<input type="text" name="username" required class="userfor" placeholder="请输入帐号" />
		</div>
		<div class="userpass password">
			<input type="password" name="password" required class="userfor" placeholder="请输入密码" />
		</div>
		<!--一系列提交按钮-->
		<div class="divsubmit">
			<a href="register" style="float: left;margin-left:5px;">立即注册</a>
			<a href="#">忘记密码？</a>
			</br>
			<input type="submit" value="登录" id="submit"/>
			<div id="tip" style="color:red;"></div>
		</div>
	</form>
</div>
