<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>欢迎登陆</title>
<style type="text/css">
html,body {
	height: 100%;
}
.box {
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#6699FF', endColorstr='#6699FF'); /*  IE */
	background-image:linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-o-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-moz-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-webkit-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-ms-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	margin: 0 auto;
	position: relative;
	width: 100%;
	height: 100%;
}
.login-box {
	width: 100%;
	max-width:500px;
	height: 400px;
	position: absolute;
	top: 50%;

	margin-top: -200px;
	/*设置负值，为要定位子盒子的一半高度*/
	
}
@media screen and (min-width:500px){
	.login-box {
		left: 50%;
		/*设置负值，为要定位子盒子的一半宽度*/
		margin-left: -250px;
	}
}	

.form {
	width: 100%;
	max-width:500px;
	height: 305px;
	margin: 5px auto 0px auto;
	padding-top: 25px;
}	
.login-content {
	height: 300px;
	width: 100%;
	max-width:500px;
	background-color: rgba(255, 250, 2550, .6);
	float: left;
}		
	
	
.input-group {
	margin: 0px 0px 30px 0px !important;
}
.form-control,
.input-group {
	height: 40px;
}

.form-group {
	margin-bottom: 0px !important;
}
.login-title {
	padding: 20px 10px;
	background-color: rgba(0, 0, 0, .6);
}
.login-title h1 {
	margin-top: 10px !important;
}
.login-title small {
	color: #fff;
}

.link p {
	line-height: 20px;
	margin-top: 30px;
}
.btn-sm {
	padding: 8px 24px !important;
	font-size: 16px !important;
}
</style>
<div class="box">
	<div class="login-box">
		<div class="login-title text-center">
			<h1><small>登录</small></h1>
		</div>
		<div class="login-content ">
			<div class="form">
				<form action="#" method="post">
					<div class="form-group">
						<div class="col-xs-12  ">
							<div class="input-group">
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-user"></span>
								</span> 
								<input type="text" name="loginName" id="loginName" class="form-control" placeholder="用户名" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-12  ">
							<div class="input-group">
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-lock"></span>
								</span> 
								<input type="password" name="password" id="password" class="form-control" placeholder="密码" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-12  ">
							<div class="input-group">
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-lock"></span>
								</span> 
								<input type="text" name="code" style="height: 40px;width: 48%;margin-right: 8px" id="code" class="form-control" placeholder="验证码" /> 
								<img alt="验证码" id="loginImg" style="height: 40px;width: 48%;cursor: pointer;" onclick="refresh();" class="form-control" src="${path}/user/loginCode?d=<%=new Date().getTime()%>">
							</div>
						</div>
					</div>
					<div class="form-group form-actions">
						<div class="col-xs-4 col-xs-offset-4 ">
							<button type="button" onclick="login()"
								class="btn btn-sm btn-info">
								<span class="glyphicon glyphicon-off"></span> 登录
							</button>
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-6 link">
							<p class="text-center remove-margin">
								<small>忘记密码？</small> <a href="javascript:void(0)"><small>找回</small></a>
							</p>
						</div>
						<div class="col-xs-6 link">
							<p class="text-center remove-margin">
								<small>还没注册?</small> <a href="javascript:void(0)"><small>注册</small></a>
							</p>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${path}/static/js/jquery/jquery.md5.js"></script>
<script type="text/javascript">
	function login() {
		$.ajax({
			type : "POST",
			url : "${path}/user/login",
			data : {
				"loginName" : $("#loginName").val(),
				"password" : $.md5($("#password").val()),
				"code" : $("#code").val()
			},
			complete:function(){
				$("#errorMess").animate({opacity:'0.2',},2000,function(){
					$("#errorMess").css("opacity",1).html("");
				});
			},
			success : function(msg) {
				//$("#error").show(400);
				$("#errorMess").html(msg.message);
				var backURL="${backURL}";
				console.log(backURL);
				/* if(!!backURL&&msg.success&&backURL!="/xyan/user/backURL"){
					setTimeout(function(){
						location.href="backURL";
					},1000)
				} */
			}
		});
	}
	function refresh(){
		$("#loginImg").prop("src","${path}/user/loginCode?d="+Math.random());
	}
</script>
