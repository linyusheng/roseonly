<!-- 
  	作者：冯金凤
	时间：2015-05-10
	描述：修改密码页
 -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>我的信息-修改密码</title>
	<link rel="stylesheet" type="text/css" href="css/public.css" />
	<link rel="stylesheet" type="text/css" href="css/shopping.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/public.js" ></script>
	<script type="text/javascript">
		$(function(){
			//验证原始密码
			$("#oldpwd").on("blur",function(){
				var ele = $(this),v = ele.val();
				$.post('admin?method=checkOldPsw',{oldPsd:v},function(r){
					if(r == "false"){
						$('#oldpwd_tip').text("原始密码不正确!");
			    		ele.data("status",0);
					}else{
						$('#oldpwd_tip').text("");
						ele.data("status",1);
					}
				});
				
			});
			//检查确认密码
			 $("#repwd").on("blur keyup change",function(){
				 var ele = $(this),v = ele.val();
				 var pwd = $("#newpwd").val();
				 if(v != pwd){
					 $('#repwd_tip').text("两次输入的密码不一致!");
					 ele.data("status",0);
				 }else{
					 $('#repwd_tip').text("");
					 ele.data("status",1);
				 }
			 });
			//提交修改
			$('#editpwd_form').submit(function(){
				var status1 = $('#oldpwd').data("status");
				var status2 = $('#repwd').data("status");
				var b = true;
				if(!status1){
					b = false;
				}
				if(!status2){
					b = false;
				}
				return b;
			});
		});
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
			            <li><a href="user">基本信息</a></li>
			            <li class="active_li"><a href="user?method=editPwdPage">修改密码</a></li>
			            <li><a href="collect?method=myCollect">我的收藏</a></li>
			            <li><a href="recaddress?method=getAddress">收货地址</a></li>
			        </ul>
			        
			        <div class="userinfo">
						<!-- 表格 -->
						<form action="user?method=editPwd" method="post" id="editpwd_form">
						<table cellpadding="0" cellspacing="0">
							<tr>
								<td><font style="color:red;">*</font>旧密码</td>
								<td>
									<input name="oldpwd" id="oldpwd" type="password" value="" maxlength="15" required="required"/>
									<span id="oldpwd_tip" style="float:left;"></span>
								</td>
								
							</tr>
							<tr>
								<td><font style="color:red;">*</font>新密码</td>
								<td>
									<input name="newpwd" type="password" id="newpwd" value="" maxlength="11" required="required"/>
									<span id="newpwd_tip"></span>
								</td>
								
							</tr>
							<tr>
								<td><font style="color:red;">*</font>确认密码</td>
								<td>
									<input name="repwd" type="password" id="repwd" value="" required="required"/>
									<span id="repwd_tip"></span>
								</td>
								
							</tr>
							<tr>
								<td></td>
								<td>
									<input type="submit" value="提交修改" />
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
