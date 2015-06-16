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
				<!--幻灯片开始-->
				<div class="swiper-container" style="width: 962px;height: 500px;">
					<div class="swiper-wrapper">
				        <div class="swiper-slide">
				        	<a href="#" target="_blank">
				        		<img src="img/indexpic/01.jpg" width="962px" height="500px" title="" alt="" border="0"/>
				        	</a>
				        </div>
				        <div class="swiper-slide">
				        	<a href="#" target="_blank">
				        		<img src="img/indexpic/02.jpg" width="962px" height="500px" title="" alt="" border="0"/>
				        	</a>
				        </div>
				        <div class="swiper-slide">
				        	<a href="#" target="_blank">
				        		<img src="img/indexpic/03.jpg" width="962px" height="500px" title="" alt="" border="0"/>
				        	</a>
				        </div>
				        <div class="swiper-slide">
				        	<a href="#" target="_blank">
				        		<img src="img/indexpic/04.jpg" width="962px" height="500px" title="" alt="" border="0"/>
				        	</a>
				        </div>
				        <div class="swiper-slide">
				        	<a href="#" target="_blank">
				        		<img src="img/indexpic/05.jpg" width="962px" height="500px" title="" alt="" border="0"/>
				        	</a>
				        </div>
				        <div class="swiper-slide">
				        	<a href="#" target="_blank">
				        		<img src="img/indexpic/06.jpg" width="962px" height="500px" title="" alt="" border="0"/>
				        	</a>
				        </div>
				    </div>
				    <div class="swiper-pagination"></div>
				    <div class="swiper-button-prev"></div>
    				<div class="swiper-button-next"></div>
				</div>
				<style>
				.swiper-pagination-bullet{width: 10px; height: 10px;}
				.swiper-pagination-bullet-active{background: #414141;}
				.swiper-button-prev{background: url(img/icon-slides.png) -89px;}
				.swiper-button-next{background: url(img/icon-slides.png) -132px;}
				.swiper-button-prev:hover{background: url(img/icon-slides.png) -5px;}
				.swiper-button-next:hover{background: url(img/icon-slides.png) -50px;}
				</style>
				<script>
					var mySwiper = new Swiper ('.swiper-container', {
						autoplay : 3000,
					    loop: true,
					    // 如果需要分页器
					    pagination: '.swiper-pagination',
					    paginationClickable :true,
					    // 如果需要前进后退按钮
					    nextButton: '.swiper-button-next',
					    prevButton: '.swiper-button-prev',
					  });        
				</script>
				<!--幻灯片结束-->
				<div class="main_view_line"></div>
				<div class="index_ph1">
					<a href="#" target="_blank">
						<img src="img/indexpic/1.jpg" border="0" width="602" height="300"/>
					</a>
				</div>
				<div class="index_ph2">
					<a href="#" target="_blank">
						<img src="img/indexpic/456.jpg" border="0" width="350" height="613"/>
					</a>
				</div>
				<div class="index_ph1">
					<a href="#" target="_blank">
						<img src="img/indexpic/2.jpg" border="0" width="295" height="300"/>
					</a>
				</div>
				<div class="index_ph2">
					<a href="#" target="_blank">
						<img src="img/indexpic/3.jpg" border="0" width="295" height="300"/>
					</a>
				</div>
				<div class="main_view_line"></div>
				<div class="index_ph1">
					<a href="#" target="_blank">
						<img src="img/indexpic/7.jpg" border="0"width="476" height="300"/>
					</a>
				</div>
				<div class="index_ph2">
					<a href="#" target="_blank">
						<img src="img/indexpic/8.jpg" border="0" width="476" height="300"/>
					</a>
				</div>
				<div class="index_ph2">
					<a href="#" target="_blank">
						<img src="img/indexpic/11.jpg" border="0" width="314" height="314"/>
					</a>
				</div>
				<div class="index_ph1">
					<a href="#" target="_blank">
						<img src="img/indexpic/9.jpg" border="0" width="314" height="314"/>
					</a>
				</div>
				<div class="index_ph2">
					<a href="#" target="_blank">
						<img src="img/indexpic/10.jpg" border="0" width="314" height="314"/>
					</a>
				</div>
			</div>
		</div>
		
	</body>

</html>
