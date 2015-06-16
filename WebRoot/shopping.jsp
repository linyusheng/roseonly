<!-- 
          作者：余卓璇
	时间：2015-05-06
	描述：购物车页
 -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>我的购物车</title>
		<link rel="stylesheet" type="text/css" href="css/public.css" />
		<link rel="stylesheet" type="text/css" href="css/shopping.css" />
		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/public.js" ></script>
		<script type="text/javascript" src="js/shopping.js" ></script>
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
			        <span class="myshopping">我的购物车</span>
			        <a href="shopping?method=deleteAll&brandId=${brandId}"><span class="clearshopping">清空购物车</span></a>
			        <table cellspacing="0">
			            <tr class="shopping_cart_title">
			                <td>序号</td>
			                <td>品牌</td>
			                <td>商品名称</td>
			                <td>单价</td>
			                <td>数量</td>
			                <td>操作</td>
			            </tr>
			            
			            <c:forEach var="shopping" items="${shoppingList}" varStatus="i">
				            <tr>
				                <td>${i.index+1}</td>
				                <td>roseonly</td>
				                <td>
					                <a href="javascript:void(0);"><img class="img1" src="${shopping.picture}" width="200px" /></a>
					                <span class="shopping_name">${shopping.roseName}</span>
				                </td>
				                <td>￥${shopping.rosePrice}</td>
				                <td style="display:none;">${shopping.rosePrice}</td>
				                <td class="total_price" style="display:none;">${shopping.rosePrice * shopping.num}</td>
				                <td>
				                	<a href="javascript:void(0);" onclick="sub(this,${shopping.shoppingId});"><img src="img/cart02.png"/></a>
				                	<input name="num" id="num" type="text" value="${shopping.num }" />
				                	<input name="hide" id="hide" type="hidden" value="${shopping.roseNum}" />
				                	<a href="javascript:void(0);" onclick="add(this,${shopping.shoppingId});"><img src="img/cart03.png"/></a>
				                </td>
				                <td><a href="shopping?method=delete&shoppingId=${shopping.shoppingId}&brandId=${brandId}">删除</a></td>
				            </tr>
			            </c:forEach>
			        </table>
			        <div class="totalDiv">
				        <span class="total">合计：￥<font id="cart_total"></font></span>
				        <input type="button" class="btn1" value="继续购买" onclick="location.href='roselist?brandId=${brandId}'" />
				        <input type="button" class="btn2" value="立即结算" id="cart_pay" />
			        </div>
			    </div>
			    <div class="help">
			        <span>订单帮助</span><br /><br />
			        <p>热线电话:183-1602-2547</p>
			        <p>客服邮箱:<a href="#">2275755329@qq.com</a>  客服工作时间：周一至周日9:00-21:00</p>
			        <p>如果您在下单过程中遇到问题，请与我们联系。因为鲜花商品对配送时效有特殊要求，订购后请随时登录查询物流状态。</p>
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
		
		<!-- 引入底部导航 -->
		<jsp:include flush="true" page="public/footer.jsp"></jsp:include>
    </body>
</html>