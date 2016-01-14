<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/views/common/head-adv.jsp" %>
</head>
<body>
<div class="body">
	<div>
		<c:forEach items="${list}" var="item">
			<div class="item">
				<h2>
					<a class="item-title" href="${path}/read/${item.id}">${item.title}</a>
				</h2>
				<small class="item-other">
					<span><fmt:formatDate value="${item.createTime}" pattern="yyyy年M月d日" /></span>
					<span>类别：${item.typeName} </span> 
					<span>阅读次数：${item.readCount} </span>
				</small>
				<div class="item-text">${item.contentText}</div>
				<a class="item-more" href="${path}/read/${item.id}">阅读更多...</a>
			</div>
		</c:forEach>
		<style type="text/css">
			small {display:block; font-family: Arial,sans-serif;font-size: 0.88em;line-height: 1.5em;}
			.item { margin: 0 0 40px;font-size:95%;overflow: hidden;text-align: justify;}
			.item .item-title{font-size: 18px;margin-left:10px; color:#29b4f0;text-decoration:none; transition: all 0.28s ease-in 0s;}
			.item .item-title:hover{color:#0d8abf;text-decoration:underline;}
			.item .item-more:hover{color: #00b7e9;text-decoration:underline;}
			.item .item-text{margin-top:5px;text-indent:2em; margin-bottom:5px; border-bottom: 1px dotted #999;border-top: 1px dotted #999;}
			.item .item-other{margin-left: 80px;color:#777;}
			.item .item-more{margin-left: 5px;text-decoration:none; }
		</style>
	</div>
</div>
<style type="text/css">
.page{width: 999px;margin: 10px auto;padding: 35px;}
.page .page-text{text-align: center;}
.page .page-contain{position: relative;width: 999px;}
.page .page-item{cursor: pointer;background-color:#09C; display: block;height: 35px;width: 65px;text-align: center;line-height: 35px;}
.page .page-item:hover{background-color:#00b7e9;}
.page .page-no{color:#000;background-color:#666; display: block;height: 35px;width: 65px;text-align: center;line-height: 35px;}
.page .page-up{position: absolute;left:433px;border:1px solid black;border-top-left-radius:17px;border-bottom-left-radius:17px;}
.page .page-down{position: absolute;right: 433px;;border:1px solid black;border-top-right-radius:17px;border-bottom-right-radius:17px;border-left: none;}
</style>
<div class="page">
	<div class="page-text">共有${page.totalCount}条记录</div>
	<div class="page-contain">
		<c:if test="${page.pageNo eq 1 or page.pageNo lt 1 }">
			<span class="page-no page-up"  title="上一页">上一页</span>
		</c:if>
		<c:if test="${page.pageNo gt 1}">
			<a class="page-item page-up" href="${path}/blog/list?pageNo=${page.pageNo-1}&&pageSize=${page.pageSize}" title="上一页">上一页</a>
		</c:if>
		<c:if test="${page.pageNo lt page.totalPages or page.pageNo eq page.totalPages}">
			<span class="page-no page-down"  title="下一页">下一页</span>
		</c:if>
		<c:if test="${page.pageNo lt page.totalPages}">
			<a class="page-item page-down" href="${path}/blog/list?pageNo=${page.pageNo+1}&&pageSize=${page.pageSize}" title="下一页">下一页</a>
		</c:if>
	</div>
</div>
<%@ include file="/WEB-INF/views/common/foot.jsp" %>
</body>
</html>