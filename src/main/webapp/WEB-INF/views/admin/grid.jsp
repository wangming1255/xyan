<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<title>Bootstrap����</title>
<!-- inline styles related to this page -->

<style>
.center {
	text-align: center;
}

.center [class*="col-"] {
	margin-top: 2px;
	margin-bottom: 2px;
	padding-top: 4px;
	padding-bottom: 4px;
	position: relative;
	text-overflow: ellipsis;
}

.center [class*="col-"]  span {
	position: relative;
	z-index: 2;
	display: inline-block;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 100%;
}

.center [class*="col-"]:before {
	position: absolute;
	top: 0;
	bottom: 0;
	left: 2px;
	right: 2px;
	content: "";
	display: block;
	border: 1px solid #DDD;
	z-index: 1;
}

.center [class*="col-"]:hover:before {
	background-color: #FCE6A6;
	border-color: #EFD27A;
}
</style>


<div class="page-header">
	<h1>
		Grid <small> <i class="icon-double-angle-right"></i> bootstrap
			grid sizing
		</small>
	</h1>
</div>
<!-- /.page-header -->

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->

		<div class="center">
			<div class="row">
				<div class="col-xs-12">
					<span>.col-xs-12</span>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-1">
					<span>.col-xs-1</span>
				</div>

				<div class="col-xs-11">
					<span>.col-xs-11</span>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-6 col-sm-2">
					<span>.col-xs-6.col-sm-2</span>
				</div>

				<div class="col-xs-6 col-sm-10">
					<span>.col-xs-6.col-sm-10</span>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-12 col-lg-6">
					<span>.col-xs-12.col-lg-6</span>
				</div>

				<div class="col-xs-12 col-lg-6">
					<span>.col-xs-12.col-lg-6</span>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-4">
					<span>.col-xs-4</span>
				</div>

				<div class="col-xs-8">
					<span>.col-xs-8</span>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-5">
					<span>.col-xs-5</span>
				</div>

				<div class="col-xs-7">
					<span>.col-xs-7</span>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-6">
					<span>.col-xs-6</span>
				</div>

				<div class="col-xs-6">
					<span>.col-xs-6</span>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-7">
					<span>.col-xs-7</span>
				</div>

				<div class="col-xs-5">
					<span>.col-xs-5</span>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-8">
					<span>.col-xs-8</span>
				</div>

				<div class="col-xs-4">
					<span>.col-xs-4</span>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-9">
					<span>.col-xs-9</span>
				</div>

				<div class="col-xs-3">
					<span>.col-xs-3</span>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-10">
					<span>.col-xs-10</span>
				</div>

				<div class="col-xs-2">
					<span>.col-xs-2</span>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-11">
					<span>.col-xs-11</span>
				</div>

				<div class="col-xs-1">
					<span>.col-xs-1</span>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-12">
					<span>.col-xs-12</span>
				</div>
			</div>
		</div>

		<!-- PAGE CONTENT ENDS -->
	</div>
	<!-- /.col -->
</div>
<!-- /.row -->