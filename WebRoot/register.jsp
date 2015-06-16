<!--
	作者：张小花
	时间：2015-04-27
	描述：注册页面
-->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/public.css" />
		<link rel="stylesheet" type="text/css" href="css/register.css" />
		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/pwdstrength.js"></script>
		<script type="text/javascript" src="js/public.js" ></script>
		<script type="text/javascript" src="js/register.js" ></script>
	</head>

	<body>
		<!-- 引入头部导航 -->
		<jsp:include flush="true" page="public/header.jsp"></jsp:include>
		
		<div class="container">
			<!-- 左导航 -->
			<jsp:include flush="true" page="public/menu.jsp"></jsp:include>
			
			<!-- 主体部分 ：width:962px;(内容自由发挥)-->
			<div class="main">
				<div class="main_header">
				    <p class="hfont">————&nbsp;REGISTER&nbsp;————</p><br /><br />
				    <p class="hfont1">————&nbsp;注册&nbsp;————</p>
				</div>
				<div class="main_body">
				    <form action="register?method=add" id="registerForm" method="post">
				    	<table id="middle1" class="table" cellpadding="0" cellspacing="0">
				    		<tr>
					            <td>
					                <span class="mfont">帐号</span>
					            </td>
					            <td>
					                <input type="text" id="account" name="account" required size="30" class="form_border" />
					            </td>
					            <td><div id="account_tip"></div></td>
					        </tr>
					        <tr>
					            <td>
					                <span class="mfont">密码</span>
					            </td>
					            <td>
					                <input type="password" id="pwd" name="pwd" required size="30" class="form_border" onKeyUp="pwStrength(this.value)"  onBlur="pwStrength(this.value)"/>
	                            </td>
	                            <td><div id="pwd_tip"></div></td>
					        </tr>
					        <tr>
					        	<td>
					                <span class="mfont">密码强度</span>
					            </td>
					            <td>
					            	<div id="pwdstrength" class="pwdstrength_div">
					            		<table class="pwdstrength_table" cellpadding="0" cellspacing="0">
					            			<tr class="pwdstrength_style">
					            				<td width="100" id="strength_L"><span class="pwdfont">弱</span></td>
	                                            <td width="100" id="strength_M"><span class="pwdfont">中</span></td>
	                                            <td width="100" id="strength_H"><span class="pwdfont">强</span></td>
					            			</tr>
					            		</table>
					            	</div>
					            </td>
					        </tr>
					        <tr>
					            <td>
					                <span class="mfont">确认密码</span>
					            </td>
					            <td>
					                <input type="password" id="repwd" name="repwd" required size="30" class="form_border" />
					            </td>
					            <td><div id="repwd_tip"></div></td>
					        </tr>
					        <tr>
					            <td>
					                <span class="mfont">验证码</span>
					            </td>
					            <td>
					            	<input name="checkcode" id="checkcode" type="text" required class="form_border checkinput" maxlength="4"/>
                            		<img src="register?method=getCheckCode" id="img_checkcode" onclick="refreshCheckCode();" title="点击刷新" />
					                <a href="javascript:refreshCheckCode();" class="check_img_chang">换一张</a>
					            </td>
					            <td><div id="checkcode_tip"></div></td>
					        </tr>
					        <tr height="60">
					        	<td></td>
			    				<td >
			    					<input type="button" class="button_style" value="返回" onclick="window.location.href='./'" />
								    <input type="submit" class="button_style" value="提交" />
			    				</td>
				    		</tr>
				    	</table>
				    </form>
				</div>
		    </div>
		</div>
	</body>
</html>
