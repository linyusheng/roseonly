<!--
	作者：余卓璇
	时间：2015-04-28
	描述：玫瑰列表页
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/public.css" />
		<link rel="stylesheet" type="text/css" href="css/rose_list.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.lazyload.js"></script>
		<script type="text/javascript" src="js/public.js" ></script>
		<script>
			$(function(){
				$('.coll_text').hide();
				$('.li').hover(function(){
					$(".coll_text",this).slideToggle(300);
				});
			});
			function shopping(roseId,brandId){
				$.post('shopping', {}, function(r){
					if(r == 1){
						window.location.href="shopping?method=getList&roseId="+roseId+"&brandId="+brandId+"&num=1";
					}else{
						$(".alogin").show();
						$(".login").show();
					}
				});
			}
			function addCollect(roseId){
				$.post('collect?method=add',{roseId:roseId},function(r){
					console.info(r);
					if(r == 1){
						alert("收藏成功！");
					}else if(r == 0){
						alert("已收藏！");
					}else{
						$(".alogin").show();
						$(".login").show();
					}
				});
			}
		</script>
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
	                	<c:forEach var="rose" items="${list}">
	                		<div class="li">
		                        <a href="roseinfo?roseId=${rose.roseId}">
		                        	<img src="img/lazyload.gif" data-original="${rose.picture}" alt="${rose.roseName}"  title="${rose.roseName}" class="lazy" />
		                        </a>
		                        <div class="btn">
		                            <label>￥${rose.rosePrice}</label>
			                        <input type="button" class="btn1" value="加入购物车" onclick="shopping(${rose.roseId},${brand.brandId });" />
			                        <input type="button" class="btn2" value="查看详情" onclick="location.href='roseinfo?roseId=${rose.roseId}';" />
		                        </div>
		                        <div class="coll">
		                        	<div class="coll_text"><a href="javascript:addCollect(${rose.roseId });">收藏</a></div>
		                        </div>
	                    	</div>
	                	</c:forEach>
	            	</div>
	        	</div>
	        	<script type="text/javascript" charset="utf-8">
					$(function() {
					    $("img.lazy").lazyload({ effect : "fadeIn" });
					});
				</script>
			</div>
		</div>
	</body>
</html>
