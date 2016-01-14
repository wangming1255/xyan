<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/head.jsp" %>
<link href="${path}/assets/plugins/bootstrap/css/bootstrap.css" rel="stylesheet"/>
<div class="body">
<h1>后台管理<small>--技术集成</small></h1>
<div class="container-fluid">
	<div class="row">
		<span class="col-md-12 text-right">
			<button type="button" onclick="Admin.add()" class="btn btn-info">新增</button>
			<button type="button" onclick="Admin.edit()" class="btn btn-info">编辑</button>
			<button type="button" onclick="Admin.del()" class="btn btn-info">删除</button>
		</span>
	</div>
	<table class="table table-striped table-bordered">
		<c:forEach items="${list}" var="item">
			<tr>
				<td class="text-center">
					<input type="checkbox"/>
				</td>
				<td class="text-center">
					${item.typeName}
				</td>
				<td class="text-center">
					${item.title}
				</td>
				<td class="text-center">
					${item.introduce}
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</div>
<script type="text/javascript" src="${path}/assets/plugins/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/app/js/admin.js"></script>
<%@ include file="/WEB-INF/views/common/foot.jsp" %>