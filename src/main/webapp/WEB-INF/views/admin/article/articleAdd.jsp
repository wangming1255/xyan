<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--引入wangEditor.css-->
<link rel="stylesheet" type="text/css" href="${path}/static/plugin/wangEditor-2.1.12/css/wangEditor.min.css">
<title>完善文章信息</title>
<div class="breadcrumbs" id="breadcrumbs">
	<script type="text/javascript">
		try {
			ace.settings.check('breadcrumbs', 'fixed')
		} catch (e) {
		}
	</script>
	<ul class="breadcrumb">
		<li><i class="icon-home home-icon"></i> <a
			href="${path}/admin/index">首页</a></li>
		<li><a href="${path}/admin/article">文章管理</a></li>
		<li class="active">新增文章</li>
	</ul>
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
	<div class="mar15">
		<!--表格-->
		<div class="widget-header relative bor-bottom">
			<h5>完善文章信息</h5>
		</div>
		<div class="table-responsive">
			<form id="dataForm" action="#">
				<input type="hidden" value="" name="id">
				<table class="table table-bordered align-center font12 mar-bottom-0 dataTable">
					<tbody>
						<tr>
							<td style="width: 12%" class="text-right bold">文章标题：</td>
							<td style="width: 21%" class="text-left pad-right-0">
								<div class="sol-xs-12 form_date">
									<input type="text" value="" id="title" name="title"  class="sol-xs-11 calendar J-checkInDate">
								</div>
							</td>
							<td style="width: 12%" class="text-right bold">释放日期</td>
							<td style="width: 21%" class="text-left pad-right-0">
								<div class="sol-xs-12 form_date">
									<input type="text" value="" id="releaseDate" name="releaseDate" class="sol-xs-11 calendar J-checkInDate">
								</div>
							</td>
							<td style="width: 12%" class="text-right bold">手续费</td>
							<td style="width: 21%" class="text-left pad-right-0">
								<div class="sol-xs-11">
									<input type="text" value="" id="handlingFee" name="handlingFee" class="sol-xs-12 text-right initNumFormat blurFormat">
								</div>
							</td>
						</tr>
						<tr>
							<td style="width: 12%" class="text-right bold">释放后放款日</td>
							<td style="width: 21%" class="text-left pad-right-0">
								<div class="sol-xs-12 form_date">
									<input type="text" value="" name="lendingDay"  id="lendingDay" class="sol-xs-11 calendar J-checkInDate">
								</div>
							</td>
							<td style="width: 12%" class="text-right bold">释放后产品计息起始日</td>
							<td style="width: 21%" class="text-left  pad-right-0">
								<div class="sol-xs-12 newForm_date">
									<input type="text" value=""  name="interestStartDay" id="interestStartDay" class="sol-xs-11 calendar J-checkInDate">
								</div>
							</td>
							<td style="width: 12%" class="text-right bold">释放后产品计息终止日</td>
							<td style="width: 21%" class="text-left  pad-right-0">
								<div class="sol-xs-12 newForm_date">
									<input type="text" value=""  name="interestEndDay" id="interestEndDay" class="sol-xs-11 calendar J-checkInDate">
								</div>
							</td>
						</tr>
						<tr>
							<td style="width: 12%" class="text-right bold">备注</td>
							<td colspan="5" style="width: 21%" class="text-left pad-right-0">
								<div class="sol-xs-11">
									 <textarea name="remark" id="remark" class="sol-xs-12"></textarea>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
			<div class="text-center">
				<a class="button btn-green mar15" onclick="" href="javascript:;">提交</a> 
				<a class="button btn-grey mar15" href="${path}/admin/article">返回</a>
			</div>
			<!--page-content-->
		</div>
	</div>
	<div class="clear"></div>
</div>


<!--引入jquery和wangEditor.js-->   <!--注意：javascript必须放在body最后，否则可能会出现问题-->
<script type="text/javascript" src="${path}/static/plugin/wangEditor-2.1.12/js/wangEditor.min.js"></script>
<script type="text/javascript">
    var editor = new wangEditor('remark');
    editor.config.uploadImgUrl = '${path}/index/wangEditor/upload';
    editor.create();
</script>