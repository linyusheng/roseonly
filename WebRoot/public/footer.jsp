<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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