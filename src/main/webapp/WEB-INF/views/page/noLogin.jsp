<%@page import="com.xyan.web.core.WebUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<%@ include file="/WEB-INF/views/common/head-adv.jsp" %>
<% WebUtil.removeLoginUser(request); %>
<link href="${path}/assets/css/button.css" rel="stylesheet"/>
</head>
<body>
	<div class="body">
		<input type="hidden" value="${callUrl}" id="callUrl"/>
		<div class="message">
			<img alt="登录图片" class="message-img" src="${path}/app/img/yangmi-1.jpg">
			<div class="zone">女神镇可否？</div>
		</div>
		<style type="text/css">
			.message{float: left;margin-top: -80px;}
			.message-img{display: block;}
			.login{float: left;width: 256px;margin-left: 150px;background-color: #fafafa;box-shadow: 0 0 3px rgba(0, 0, 0, 0.2);}
			.login table{width:100%;padding-left: 15px;}
			.login table tr td{line-height: 1.2em;}
			.w442{width: 224px;}
			.w441{width: 118px;}
			.lst-right{margin-left: 148px; margin-right: 20px;}
			.login::before, .login::after {
			    bottom: 15px;
			    box-shadow: 0 15px 10px rgba(44, 44, 44, 0.9);
			    content: "";
			    left: 10px;
			    position: absolute;
			    top: 10px;
			    transform: rotate(-3deg);
			    width: 50%;
			    z-index: -1;
			}
			.login::after {
			    left: auto;
			    right: 10px;
			    transform: rotate(3deg);
			}
			.login-text{line-height: 34px;}
			.errorMess{color:red;text-align: center;}
		</style>
		<div class="login">
			<div>
				<span class="zone"><xyan:message key="${message}"/></span>
			</div>
			<div id="errorMess" class="errorMess"></div>
			<form action="" id="loginForm">
				<table>
					<tr><td colspan="2" align="left">登录名</td></tr>
					<tr>
						<td width="60%" align="left">
							<input type="text" class="w442 login-text" name="loginName" id="loginName">
						</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2"  align="left">密码</td>
					</tr>
					<tr>
						<td align="left">
							<input type="password" class="w442 login-text" name="password" id="password">
						</td>
						<td></td>
					</tr>
					<tr>
						<td align="left">验证码</td>
					</tr>
					<tr>
						<td align="left">
							<div>
								<input type="text" class="w441 login-text" name="loginCode" id="loginCode">
								<img alt="验证码刷新太频繁" class="code-img" src="${path}/loginImg" id="loginImg">
							</div>
						</td>
						<td>
						</td>
					</tr>
				</table>
				<div>
					<button type="button" style="width:100%;" onclick="login()" class="button button-glow button-rounded button-raised button-primary">登录</button>
				</div>
			</form>
			<div>
				<a class="lst-right" href="${path}/user/toRegister">注册</a>
				<a  href="${path}/user/toForget">忘记密码</a>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${path}/app/js/jquery.md5.js"></script>
	<script type="text/javascript" src="${path}/assets/plugins/layer/layer.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#loginForm").keypress(function(event){
				var code;
				 if(window.event){
					 code = window.event.keyCode; // IE
				 }else{
					 code = event.which; // Firefox
				 }
				 if(code==13){
					 login();
				 }
			});
			$("#loginImg").click(function(){
				$(this).prop("src",path+"/loginImg?date="+new Date().getTime());
			});
		});
		function login(){
			var datas={"loginName":$("#loginName").val(),"password":$.md5($("#password").val()),"loginCode":$("#loginCode").val()};
			$.ajax({
				type : "post",
				url : "${path}/user/login",
				data :datas,
				success : function(msg) {
					if(msg.login&&msg.success){
						$("#errorMess").empty();
						layer.msg(msg.message, {
						    icon: 1,
						    time: 1000 //2秒关闭（如果不配置，默认是3秒）
						},function(){
							window.location=$("#callUrl").val();
						});
					}else{
						$("#loginImg").prop("src",path+"/loginImg?date="+new Date().getTime());
						$("#errorMess").html(msg.message);
					}
				}
			});
		}
	</script>
</body>
</html>