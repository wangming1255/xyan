<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table table-bordered align-center font12 mar-bottom-0 dataTable" id="dataTable">
	<tbody id="tbody">
	</tbody>
</table>
<!-- 分页 start  -->
<div class="page-header-search">
	<table
		class="table table-bordered align-text-center font12 mar-bottom-0 dataTable">
		<tbody>
			<tr class="ui-toolbar">
				<td colspan="10">
					<div class="pagination right">
						<span class="pagination-text">每页显示：</span>
						<div class="selector align-left">
							<span class="selector-txt">10</span> <i class="iconfont"></i> <select
								class="form-control selSpan" id="pageSizeId" style="opacity: 0;">
								<option value="10" selected="selected">10</option>
								<option value="20">20</option>
								<option value="30">30</option>
							</select>
						</div>
					</div>
					<div id="pagination"
						data-url="${path}/blog/board/pageData"
						class="pagination right"></div>
					<div class="clear"></div>
				</td>
			</tr>
		</tbody>
	</table>
</div>
<script type="text/javascript">
	$().ready(function() {
		//HTML分页
		$.MyPage.initHTML();
	});
</script>