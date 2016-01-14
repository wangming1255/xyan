<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/head3.jsp" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="utf-8"/>
<title><xyan:message key="page.title.common"/> </title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="用户操作错误" name="description"/>
<meta content="xyan" name="author"/>
<meta name="MobileOptimized" content="320">
<body>
<div class="body">
	<div>亲，<span class="error-red"><xyan:message key="${message}"/> </span></div>
	<div>您可以<a href="${path}">返回首页</a>，或者<a href="${path}/toWebSocket">联系站主</a></div>
</div>
</body>
</html>