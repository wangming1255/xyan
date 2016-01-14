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
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
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