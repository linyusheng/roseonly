<!--
	作者：余卓璇
	时间：2015-05-01
	描述：玫瑰详细信息页
-->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/public.css" />
		<link rel="stylesheet" type="text/css" href="css/rose_info.css" />
		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/jquery.lazyload.js"></script>
		<script type="text/javascript" src="js/public.js" ></script>
		<script type="text/javascript" src="js/rose_info.js" ></script>
	</head>

	<body>
		<!-- 引入头部导航 -->
		<jsp:include flush="true" page="public/header.jsp"></jsp:include>
		
		<div class="container">
			<!-- 左导航 -->
			<jsp:include flush="true" page="public/menu.jsp"></jsp:include>
			
			<!-- 主体部分 ：width:962px;(内容自由发挥)-->
			<div class="main">
                <a href="roselist?brandId=1"><img src="img/14294998254764441.jpg" alt="金牛座" title="金牛座" /></a>
				<div class="block">
	        	    <span class="span"><a href="./">首页</a>&nbsp;>&nbsp;${brand.brandName}</span>
	                <div id="content">
	                    <div class="roseDiv">
	                        <img class="lazy" src="img/lazyload.gif" data-original="${rose.picture}" alt="${rose.roseName}" title="${rose.roseName}" />
	                        <div class="roseMessage">
	                            <h2>Classic</h2>
	                            <p>${rose.roseName}</p>
	                            <label>￥${rose.rosePrice}</label>
	                            <div class="count">
		                            <span>购买数量：</span>
		                            <a href="javascript:sub();"><img id="icon_down" src="img/icon_down.png" /></a>
		                            <input id="num" type="text" value="1" />
		                            <input id="hide" type="hidden" value="${rose.roseNum}" />
		                            <a href="javascript:add();"><img id="icon_up" src="img/icon_up.png" /></a>
	                            </div>
	                            <p class="roseNum">库存:${rose.roseNum}件</p>
	                            <input type="button" class="btn1" value="立即购买" onclick="nowBuy(${rose.roseId},${brand.brandId})" />
	                            <input type="button" class="btn2" value="加入购物车" onclick="shopping(${rose.roseId},${brand.brandId});"/></a>
	                        </div>
	                    </div>
	                    <div class="roseDiv2">
	                        ${rose.details}
					    </div>
	        	    </div>
	        	    <script type="text/javascript" charset="utf-8">
						$(function() {
						    $("img.lazy").lazyload({ effect : "fadeIn" });
						});
					</script>
			    </div>
		    </div>
		</div>
	</body>
</html>
