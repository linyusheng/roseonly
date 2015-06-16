<!-- 
  	作者：余卓璇
	时间：2015-05-10
	描述：我的订单页
 -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>收货地址</title>
		<link rel="stylesheet" type="text/css" href="css/public.css" />
		<link rel="stylesheet" type="text/css" href="css/shopping.css" />
		<link rel="stylesheet" type="text/css" href="css/address.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/public.js" ></script>
		<script type="text/javascript" src="js/city.min.js" ></script>
		<script type="text/javascript" src="js/address.js" ></script>
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
			            <li><a href="#">我的收藏</a></li>
			            <li class="active_li"><a href="recaddress?method=getAddress">收货地址</a></li>
			        </ul>
			        <table id="listTable" border="0" cellspacing="0" cellpadding="0" class="tbl-main">
						<tbody>
						<tr class="thead-tbl-grade" style="border-bottom: 1px solid #83847E;">
							<td>收货人</td>
							<td>省</td>
							<td>市</td>
							<td>区</td>
							<td>详细地址</td>
							<td>邮编</td>
							<td>电话/手机</td>
							<td>操作</td>
						</tr>
						<c:forEach var="recinfo" items="${recList}">
							<tr class="thead-tbl-address  address-default ">
							    <td>${recinfo.consignee}</td>
								<td>${recinfo.privince}</td>
								<td>${recinfo.city}</td>
								<td>${recinfo.area}</td>
								<td>${recinfo.address} </td>
								<td>${recinfo.postcode}</td>
								<td>${recinfo.mobile}</td>
								<td style="display:none;">${recinfo.recInfoId }</td>
								<td>
									<a href="javascript:void(0);" class="edit">修改</a> |
								    <a href="recaddress?method=delete&recinfoId=${recinfo.recInfoId}" class="del">删除</a>
								</td>
							</tr>
						</c:forEach>
			        </tbody>
				</table>
				<div class="recMain">
				    <!--path-->
					<div id="content">
						<div class="col-main">
							<div class="main-wrap">
						    	<div class="form-box" id="J_FormBox">
									<div id="mapContainer"></div>
									<div class="item item-title">
										<span class="item-label tsl" data-phase-id="d_p_addNewDeliverAddress" id="J_DeliverTitle">新增收货地址　</span><span class="tsl" data-phase-id="d_p_addNewDeliverAddressNotice">电话号码、手机号选填一项,其余均为必填项</span>
									</div>
									<form id="J_FormDeliver" action="" method="post">
										<div class="item item-devision" id="J_ItemDivision" >
											<input type="hidden" name="recinfoId" value="0" />
											<span class="item-label tsl" data-phase-id="d_p_location">所在地区 <i>*</i></span>
											<div id="J_CitySelect" class="ks-clear clearfix">
						               			<div class="liststyle">
						               				<div class="location">
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
									               	<div class="item item-street" id="J_ItemStreet" >
														<label class="item-label tsl" data-phase-id="d_p_addressDetail">详细地址 <i>*</i></label>
														<div class="ks-combobox" id="J_ComboboxStreet" aria-pressed="false">
															<div class="ks-combobox-input-wrap">
																<textarea class="ks-combobox-input i-ta disabled tsl" aria-combobox="list" role="combobox" autocomplete="off" name="address" id="J_Street" placeholder="建议您如实填写详细收货地址，例如街道名称，门牌号码，楼层和房间号等信息" data-inner_placeholder="d_p_input_inner_detailAddress" data-pattern="^[\s\S]{5,120}$" data-msg="d_p_detailAddress_msg" data-ph="建议您如实填写详细收货地址，例如街道名称，门牌号码，楼层和房间号等信息" ></textarea>
															</div>
														</div>
													</div>
													<div class="item item-postcode" id="J_ItemPostCode">
														<label class="item-label tsl" data-phase-id="d_p_postCode">邮政编码 </label>
														<div class="item-warp">
															<input name="postcode" maxlength="16" data-item="postcode" placeholder="如您不清楚邮递区号，请填写000000" data-inner_placeholder="d_p_input_inner_postCode" data-ph="如您不清楚邮递区号，请填写000000" data-pattern="^.{0,16}$" data-msg="d_p_postCode_msg" class="i-text tsl" id="J_PostCode" type="text" value="">
														</div>
													</div>
													<div class="item item-name" id="J_ItemName">
														<label class="item-label tsl" data-phase-id="d_p_receiverName">收货人姓名 <i>*</i></label>
														<div class="item-warp">
															<input name="consignee" class="i-text tsl" type="text" id="J_Name" placeholder="长度不超过25个字符" data-inner_placeholder="d_p_input_inner_fullName" data-pattern="^.{2,25}$" data-msg="d_p_fullName_msg" data-ph="长度不超过25个字符" value="">
														</div>
													</div>
													<div class="item item-mobile" id="J_ItemMobile">
														<label class="item-label tsl" data-phase-id="d_p_mobileNumber">手机号码 </label>
														<div class="item-warp">
															<input name="mobile" class="i-text tsl" type="text" id="J_Mobile" placeholder="电话号码、手机号码必须填一项" data-inner_placeholder="d_p_input_inner_mobile" data-pattern="^\d{6,20}$" data-ph="电话号码、手机号码必须填一项" data-msg="d_p_mobile_msg" value="">
														</div>
													</div>
													<div class="item">
														<button type="submit" class="btn tsl" data-phase-id="d_p_saveSubmit">保存</button>
													</div>
												</div>
											</div>
										</div>
									</form>  
								</div>
							</div>
						</div>
					</div>
				</div>               	
				<div class="col-sub">	
			    	<style>
						#Content .col-sub,
						#content .col-sub {
							width: 140px;
							margin-left: -100%;
							*display: inline;
						}
					</style>	
				</div>	
				<!--path-->
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