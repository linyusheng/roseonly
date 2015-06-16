<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 左导航 -->
<div class="left-nav">
	<div>
		<div class="logo">
			<a href="./"><img border="0" title="roseonly" alt="roseonly专爱花店" src="img/logo.png"></a>
		</div>
		<div id="menu"></div>
		<div class="line"></div>
		<img src="img/happy-tb.png" alt="Happy" class="gread">
	</div>
</div>
