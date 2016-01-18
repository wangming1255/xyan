<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- taglib library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 自定义标签库 -->
<%@ taglib prefix="xyan" uri="com.xyan.tag"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title><xyan:message key="page.title.common"/></title>
<!-- css -->
<!-- 框架css -->
<link type="text/css" rel="stylesheet" href="${path}/app/css/simple.css" />
<link type="text/css" rel="stylesheet" href="${path}/assets/css/style.css" />
<link rel="shortcut icon" href="${path}/app/img/favicon.ico" />
<!-- script -->
<script type="text/javascript" src="${path}/assets/plugins/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
var path='<%=application.getAttribute("path")%>';
</script>
</head>
<body>
<style>
/**头部 start*/
.head{ 
	position:fixed; 
	z-index:2; 
	top:0; 
	width: 100%; 
	height: 35px;
	line-height: 35px;
	box-shadow:0 0 3px rgba(0, 0, 0, 0.2);
	filter:alpha(opacity=100 finishopacity=50 style=1 startx=0,starty=0,finishx=0,finishy=150) progid:DXImageTransform.Microsoft.gradient(startcolorstr=#ccc,endcolorstr=#999,gradientType=0);
    -ms-filter:alpha(opacity=100 finishopacity=50 style=1 startx=0,starty=0,finishx=0,finishy=150) progid:DXImageTransform.Microsoft.gradient(startcolorstr=#ccc,endcolorstr=#999,gradientType=0);/*IE8*/	
    background:#ccc; /* 一些不支持背景渐变的浏览器 */  
    background:-moz-linear-gradient(top, #ccc, #999);  
    background:-webkit-gradient(linear, 0 0, 0 bottom, from(#ccc), to(#999));  
    background:-o-linear-gradient(top, #ccc,#999); 
	background:-moz-linear-gradient(top,#ccc,#999);
}
.head .head-top{width: 999px;margin: 0 auto;}
.head .head-top a{text-decoration: none;color:#369;}
.head .head-top a:hover{color:#00f}
.head .head-top-item-back{display:inline-block;background-repeat:no-repeat;width: 34px;height:35px;vertical-align: middle;	background-repeat: no-repeat;}
.head .head-top-item .home{background-image: url("${path}/app/img/home.png");}
.head .head-top-item .front{background-image: url("${path}/app/img/tag_red.png");}
.head .head-top-item .back{	background-image: url("${path}/app/img/tag_blue.png");}
.head .head-top-item .soft{background-image: url("${path}/app/img/tag_green.png");}
.head .head-top-item .item-picture{background-image: url("${path}/app/img/tag_white.png");}
.head .head-top-item .item-about{background-image: url("${path}/app/img/tag_gray.png");}
.head .head-top-item .communication{background-image: url("${path}/app/img/tag_violet.png");}
.head .head-bottom{display: none;width: 100%;}
.head .head-bottom .head-bottom-introduct{background-color: #e5e5e5;text-align: center;}
/**头部 end*/
</style>
<div class="head">
	<div class="head-top">
		<a href="${path}" target="_self" class="head-top-item">
			<span class="head-top-item-back home"></span>
			<span class="head-top-item-text">
				欢迎您，这是xyan的个人空间
			</span>
		</a>
		| 
		<a href="${path}/blog/list" target="_blank" class="head-top-item">
			<span class="head-top-item-back front"></span>
			<span class="head-top-item-text">
				技术集成
			</span>
		</a>
		| 
		<a href="${path}/work/list" target="_blank" class="head-top-item">
			<span class="head-top-item-back soft"></span>
			<span class="head-top-item-text">
				我的作品
			</span>
		</a>
		| 
		<a href="${path}/img/list" target="_blank" class="head-top-item">
			<span class="head-top-item-back item-picture"></span>
			<span class="head-top-item-text">
				站内图片
			</span>
		</a>
		| 
		<a href="###" class="head-top-item about">
			<span class="head-top-item-back item-about"></span>
			<span class="head-top-item-text">
				关于我
			</span>
		</a>
		|
		<a href="${path}/toWebsocket"  class="head-top-item">
			<span class="head-top-item-back communication"></span>
			<span class="head-top-item-text">
				站内交流
			</span>
		</a>
	</div>
	<div class="head-bottom">
		<div class="head-bottom-introduct">复深蓝资深工程师</div>
	</div>
</div>