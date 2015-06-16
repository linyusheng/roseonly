<!--
	作者：方小斌,龙威
	时间：2015-04-27
	描述：网站首页
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/public.css" />
		<link rel="stylesheet" type="text/css" href="css/swiper3.07.min.css"/>
		<link rel="stylesheet" href="css/story.css" type="text/css"/>
		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/swiper3.07.jquery.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/public.js" ></script>
	</head>

	<body>
		<!-- 引入头部导航 -->
		<jsp:include flush="true" page="public/header.jsp"></jsp:include>
		
		<div class="container">
			<!-- 左导航 -->
			<jsp:include flush="true" page="public/menu.jsp"></jsp:include>
			
			<!-- 主体部分 ：width:962px;(内容自由发挥)-->
			<div class="main">
				<!--图片---->
				<div class="reallove_content">
    	            <img src="img/reallove08.jpg" class="reallove_img" alt="真爱故事" />
    	            <img src="img/reallove02.jpg" class="reallove_img" alt="真爱故事" />
    	            <a href="starStory.html"><img src="img/reallove09.jpg" class="star_love_img" alt="明星故事" /></a>
    	            <a href="loveStory.html"><img src="img/reallove11.jpg" class="reallove_img" alt="真爱故事" /></a>
				</div>
			</div>
		</div>
		
	</body>

</html>
