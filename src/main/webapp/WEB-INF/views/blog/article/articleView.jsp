<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<title>${model.title}</title>
<div class="content">
	<div class="page-header">
		<h3 class="text-center">${model.title}</h3>
	</div>
	<div class="row">
		<p class="dateview">
			<span>
				<fmt:formatDate value="${model.updateTime}" pattern="yyyy-MM-dd"/>
			</span>
			<span>作者：xyan</span>
			<span>分类：<a target="_blank" href="${path}/blog/type">心灵记录</a></span>
			<span>阅读(${model.readCount})</span>
			<span>评论(${model.commentCount})</span>
		</p>
		<br>
	</div>
	<div>
		${model.content }
	</div>
</div>