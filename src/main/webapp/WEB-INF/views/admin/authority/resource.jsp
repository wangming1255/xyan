<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>资源管理</title>
<style>
.menu-2{text-indent: 2em;}
.menu-3{text-indent: 4em;}
.menu-4{text-indent: 6em;}
</style>
<div class="breadcrumbs" id="breadcrumbs">
	<script type="text/javascript">
		try {
			ace.settings.check('breadcrumbs', 'fixed')
		} catch (e) {
		}
	</script>

	<ul class="breadcrumb">
		<li><i class="icon-home home-icon"></i> <a href="${path}/admin/index">首页</a></li>
		<li class="active">权限管理</li>
		<li class="active">资源管理</li>
	</ul>
	<!-- .breadcrumb -->

	<div class="nav-search" id="nav-search">
		<form class="form-search">
			<span class="input-icon"> 
				<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" /> <i class="icon-search nav-search-icon"></i>
			</span>
		</form>
	</div>
	<!-- #nav-search -->
</div>
<div class="page-content">
	<div class="page-header">
		<h1>角色管理</h1>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="widget-body">
				<div class="widget-main">
					<div class="row">
						<!-- 左侧角色树 -->
						<div class="col-sm-12">
							<div class="row">
								<button onclick="delResource()" class="btn btn-app btn-xs float-r">删除</button>
								<button onclick="editResource()" class="btn btn-app btn-xs float-r">修改</button>
								<button onclick="addResource()" class="btn btn-app btn-xs float-r">添加</button>
							</div>
							<div class="widget-box">
								<div class="widget-header widget-header-flat">
									<h4>资源列表</h4>
								</div>
								<div class="widget-body">
									<table id="dataTable" class="table table-bordered align-center font12 mar-bottom-0 dataTable">
										<thead>
											<tr>
					                            <th width="15%" class="text-center">资源名称</th>
					                            <th width="9%" class="align-center">资源类型</th>
					                            <th width="10%" class="align-center">资源图标</th>
					                            <th width="11%" class="align-center">是否可用</th>
					                            <th width="9%" class="align-center">操作</th>
					                        </tr>
										</thead>
										<tbody id="tbody">
											<c:forEach items="${resourceList}" var="item">
												<tr class="checkBOX">
													<td class="menu-${item.level+1} text-left">
														<i class="isCheck icon-check-empty" data-id="${item.id}" data-level="${item.level}"></i>
														${item.resourceName }
													</td>
													<td>${item.resourceType }</td>
													<td>${item.icon }</td>
													<td>${item.available }</td>
													<td>xxx</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function(){
	$(".checkBOX").click(function(){
		if($(".isCheck",this).hasClass("icon-check")){
			$(".isCheck",this).removeClass("icon-check").addClass("icon-check-empty");
		}else{
			$(".isCheck",this).removeClass("icon-check-empty").addClass("icon-check");
		}
	});
});
function addResource(){
	if($(".icon-check").length>1){
		$.cxDialog({
			info: '最多选择一个资源！',
			 background: '#000',
			 okText:"确定",
			 ok:function(){
			 	$.cxDialog.close();
			 }
		});
		return ;
	}
	$.dialogCenter({
		id:"resourceAdd",
		bg:true,
		url:"${path}/admin/authority/resource/dialog/add?pId="+$(".icon-check").data("id")+"&level="+$(".icon-check").data("level"),
		title:"新增资源"
	});
}
</script>
<script type="text/javascript" src="${path}/static/js/dialog.js"></script>
