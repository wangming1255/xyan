<%@page import="com.xyan.core.config.ApplicationConfig"%>
<%@page import="com.xyan.web.core.WebUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/head.jsp" %>
<script type="text/javascript" src="${path}/app/ckeditor/ckeditor.js"></script>
<link href="${path}/assets/plugins/bootstrap/css/bootstrap.css" rel="stylesheet"/>
<% 
	boolean isAdmin=WebUtil.isAdmin(); 
	if(isAdmin&&ApplicationConfig.IS_ADMIN){
		request.getRequestDispatcher("/page/isAdmin").forward(request, response);
	}
%>
<div class="body">
<h1>后台管理<small>--新增博客</small></h1>
<div class="container-fluid">
		<form action="" method="post" id="addForm" name="addForm">
			<table class="table table-striped">
				<tr>
					<td>标题:</td>
					<td>分类:</td>
				</tr>
				<tr>
					<td>
						<input class="text lh-text" type="text" name="title" />
					</td>
					<td>
						<select id="type" name="type" class="cd-select text">
							<option value="-1" selected>请选择</option>
							<c:forEach items="${typeList}" var="item">
								<option value="${item.id}">${item.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">标签</td>
				</tr>
				<tr>
					
					<td colspan="2">
						<input class="text width-per-98" type="text" value="" name="label"   placeholder="以‘，’分割"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">简介</td>
				</tr>
				<tr>
					<td colspan="2">
						<input class="text width-per-98" type="text" value=""   name="introduce" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="hidden" name="contentText" id="contentText">
						<textarea rows="30" id="content" cols="50"  class="text" name="content">请输入.</textarea>
						<script type="text/javascript">var editor=CKEDITOR.replace("content");</script>
					</td>
				</tr>
			</table>
			<style type="text/css">
				.lh-text{line-height: 40px;height: 40px}
				.width-per-98 {height: 40px;  line-height: 40px; width: 98%;}
				.button-zone{position: relative;width: }
				.wrap{position: relative;top: -50%;left: -50%;}
				.content{position: relative;top: 50%;left: 50%;padding: 0 424px;}
			</style>
			<div class="button-zone">
				<div class="wrap">
					<div class="content">
						<span class="button-save">
							<button type="button" id="save-button"  class="btn btn-info">保存</button>
						</span>
						<span class="button-cancel">
							<button type="button" id="cancel-button" class="btn btn-info">取消</button>
						</span>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript" src="${path}/assets/plugins/bootstrap/js/bootstrap.js"></script>
<!-- 下拉选插件 start -->
<link rel="stylesheet" type="text/css" href="${path}/assets/plugins/jquery-select/css/selectordie.css" />
<link rel="stylesheet" type="text/css" href="${path}/assets/plugins/jquery-select/css/selectordie_theme_02.css" />
<script type="text/javascript" src="${path}/assets/plugins/jquery-select/js/selectordie.js"></script>
<script type="text/javascript">
$(function(){
	$('select').selectOrDie({
		cycle: true,
		size:4
	});
});
</script>
<!-- 下拉选 end -->
<!-- 弹出层 -->
<script type="text/javascript" src="${path}/assets/plugins/layer/layer.js"></script>
<script type="text/javascript">
	$(function(){
		$(".home").click(function(){
			window.location.href="${path}";
		});
		$(".button-zone").on("click",".button-cancel",function(){
			layer.confirm('取消后将跳转到网站首页，确定吗？', {
			    btn: ['确定','取消'] //按钮
			}, function(){
				location.href="${path}";
			},function(){
				//layer.closeAll();
			});
		}).on("click",".button-save",function(){
			layer.confirm('确定保存吗？', {
			    btn: ['确定','取消'] //按钮
			}, function(){
				
				$("#content").text(editor.getData());
				$("#contentText").val(CKEDITOR.instances.content.document.getBody().getText());
				$("#addForm").serialize();
				 $.ajax({
						type : "post",
						url : "${path}/admin/save",
						data :$('#addForm').serialize(),
						success : function(msg) {
							layer.msg('保存成功', {
							    icon: 1,
							    time: 800 //2秒关闭（如果不配置，默认是3秒）
							}, function(){
								layer.closeAll();
							});
						}
				 });
			    
			}, function(){
			    //layer.close();
			});
		});
	});
</script>
<%@ include file="/WEB-INF/views/common/foot.jsp" %>