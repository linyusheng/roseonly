<!-- 
          作者：张小花
	时间：2015-05-10
	描述：提交订单页
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/public.css" />
		<link rel="stylesheet" type="text/css" href="css/order.css" />
		<link rel="stylesheet" type="text/css" href="css/city.css" />
		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/public.js" ></script>
		<script type="text/javascript" src="js/city.min.js" ></script>
		<script type="text/javascript" src="js/order.js" ></script>
	</head>

	<body>
		<!-- 引入头部导航 -->
		<jsp:include flush="true" page="public/header.jsp"></jsp:include>
		
		<div class="container">
			<!-- 引入logo条-->
			<jsp:include flush="true" page="public/logo.jsp"></jsp:include>
			
			<div class="shopping">
				<div class="order-nav">填写核对订单信息</div>
				<div class="per-nav">收货人信息</div>
				<table style="margin-top: 10px;line-height: 38px;font-size: 17px;">
					<c:forEach var="address" items="${addressList }">
					<tr>
						<td width="30"><input type="radio" name="address_id" class="radio_address" /></td>
						<td width="730">
							<span id="product_address_105383">
								${address.consignee }&nbsp;
								${address.privince }${address.city }${address.area }&nbsp;${address.address }  
								邮编:${address.postcode }  手机:${address.mobile }
							</span>
						</td>
						<td>
							<a href="recaddress?method=getAddress">【修改】</a>
							<a href="order?method=deleteAddress&recinfoId=${address.recInfoId }">【删除】</a>
						</td>
					</tr>
					</c:forEach>
					<tr>
						<td width="30"><input type="radio" name="address_id" id="address_id_0" value="0" onclick="$('#consignee_addr').show();"/></td>
						<td><label for="address_id_0" style="cursor:pointer;">点击添加新地址</label></td>
					</tr>
			    </table>
			    <input type="hidden" name="addressId" >
			    <div id="consignee_addr" class="hide" style="display:none;">
			    	<form action="order?method=addAddress" name="J_FormDeliver" method="post">
			    	<table>
			    		<tr>
							<td>&nbsp;</td>
							<td><font color="red">*</font>收 货 人：</td>
							<td><input type="text" name="consignee" id="person" class="Inp"  /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><font color="red">*</font>手机号码：</td>
							<td><input type="text" name="mobile" id="tel" maxlength="11" class="Inp" onchange="checkmobile(this);" onfocus="cleanmobileTip();" /></td>
							<td><div id="mobile_tip"></div></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><font color="red">*</font>省&nbsp;&nbsp;&nbsp;&nbsp份：</td>
							<td>
								<div class="liststyle">
									<span id="Province">
	                                    <i>请选择省份</i>
	                                    <ul style="overflow-y:auto;height:300px;">
	                                        <li><a href="javascript:void(0)" alt="请选择省份">请选择省份</a></li>
	                                    </ul>
	                                    <input type="hidden" name="cho_Province" value="请选择省份">
	                                </span>
	                                <span id="City">
	                                    <i>请选择城市</i>
	                                    <ul style="overflow-y:auto;height:300px">
	                                        <li><a href="javascript:void(0)" alt="请选择城市">请选择城市</a></li>
	                                    </ul>
	                                    <input type="hidden" name="cho_City" value="请选择城市">
	                                </span>
	                                <span id="Area">
	                                    <i>请选择地区</i>
	                                    <ul style="overflow-y:auto;height:300px">
	                                        <li><a href="javascript:void(0)" alt="请选择地区">请选择地区</a></li>
	                                    </ul>
	                                    <input type="hidden" name="cho_Area" value="请选择地区">
	                                </span>
								</div>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><font color="red">*</font>地&nbsp;&nbsp;&nbsp;&nbsp址：</td>
							<td><input type="text" name="address" id="address" class="Inp2" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><font color="red">*</font>邮&nbsp;&nbsp;&nbsp;&nbsp编：</td>
							<td><input type="text" name="postcode" id="zip" class="Inp" maxlength="6" onchange="checkzip(this);" onfocus="cleanzipTip();" /></td>
							<td style="float: left;"><div id="zip_tip"></div></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td style="color: #D40000;font-size: smaller;">请您使用准确邮编以便于您准时收货。</td>
						</tr>
			    	</table>
			    	<input type="submit" value="保存" class="save"/>
			    	<input type="button" value="取消" class="cancel" onclick="$('#consignee_addr').hide();"/>
			    	</form>
			    </div>
			    <div class="chose">
					<div style="float:left;">商品清单</div>
					<div style="float: right;font-weight: bold;"><a href="shopping?method=seeMyCart" style="color:#38a6c2;float: right;">【返回购物车】</a></div>
				</div>
				
				<form action="order?method=add" method="post">
				<input type="hidden" name="recInfoId" value="${addressList.get(0).recInfoId }"/>
				<table cellpadding="0" cellspacing="0"  style="margin-top:20px;font-weight: bold;">
					<c:forEach var="shopping" items="${shoppingList }">
					<tr style="line-height: 50px;">
						<td>
							<div class="commodity-list">
							    <img src="${shopping.picture }" width="150px" height="150px"/>
							</div>
						</td>
						<td>
							<div class="commodity-list-left" style="margin-right: 3px;">
								<span class="list-font-color1">商品名称：</span>
							    <span class="list-font-color2">${shopping.roseName }</span><br />
							    <span class="list-font-color1">商品数量：</span>
							    <span class="list-font-color2">${shopping.num }</span><br />
							    <span class="list-font-color1">商品单价：</span>
							    <span class="list-font-color2">￥${shopping.rosePrice }</span>
							</div>
						</td>
						<td>
							<div class="commodity-list-right">
								<table>
									<tr>
										<td><span class="list-font-color1">收货人：</span></td>
										<td>
											<span class="list-font-color2">${addressList.get(0).consignee }</span>
											<input type="hidden" name="consignee" value="${addressList.get(0).consignee }" />
										</td>
									</tr>
									<tr>
										<td><span class="list-font-color1">地址:</span></td>
										<td>
											<span class="list-font-color2">
												${addressList.get(0).privince }${addressList.get(0).city }${addressList.get(0).area }
												${addressList.get(0).address } 邮编:${addressList.get(0).postcode } 手机:${addressList.get(0).mobile }
											</span>
											<!-- <span><a href="#">【更改】</a></span> -->
										</td>
									</tr>
									<tr>
										<td><span class="list-font-color3">您的签名<font color="red">*</font>：</span></td>
										<td><input type="text" name="signs"  style="outline: none; background-color: ghostwhite;width:374px;height: 35px;" required="required"/></td>
									</tr>
								
								</table>
								 
							</div>
						</td>
				</tr>
				<tr>
					<td><span class="list-font-color2">爱语<font style="font-size: x-small;">（200）</font>:</span></td>
					<td colspan="2"><textarea name="bless" clos="100" rows="5" maxlength="200" style="width: 700px;background-color: ghostwhite;"></textarea></td>
				</tr>
				</c:forEach>
			</table>
		    
			<div class="sum">
				<span style="float: right;">总计：￥9000</span>
			</div>
			<div class="ordersumbit">
				<input type="submit" id="pay_submit_btn" value="提交订单" />
			</div>
			</form>
			
			
			
			
			
			
			
		</div>
	</body>

</html>