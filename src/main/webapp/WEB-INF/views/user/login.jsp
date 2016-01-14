<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link href="${path}/assets/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="login-container">
		<div id="login1">
			<form id="form1">
				<table>
					<tr>
						<td>登录名</td>
						<td>
							<input type="text" name="loginName1" id="loginName1"/>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>密&nbsp;&nbsp;码</td>
						<td>
							<input type="password" name="password1" id="password1"/>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>验证码</td>
						<td>
							<input type="text" name="ycode1" id="ycode1"/>
						</td>
						<td>
							<img src="${path}/randomImg" id="yCodeImg" onclick="refresh()" width="68px"/>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<button type="button" onclick="login(1)">登录</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="login2">
			<table></table>
		</div>
	</div>
	<script type="text/javascript" src="${path}/assets/plugins/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="${path}/app/js/jquery.md5.js"></script>
	<script type="text/javascript" src="${path}/assets/plugins/layer/layer.js"></script>
	<script type="text/javascript">
		function refresh(){
			console.log(1);
			$("#yCodeImg").prop("src","${path}/randomImg?d="+new Date().getTime());
		}
		function login(num){
			var datas=null;
			if(num==1){
				datas={"loginName":$("#loginName1").val(),"password":$.md5($("#password1").val()),"ycode":$("#ycode1").val()};
			}else{
				datas={"loginName":$("#loginName2").val(),"password":$.md5($("#password2").val()),"ycode":$("#ycode2").val()};
			}
			$.ajax({
				type : "post",
				url : "${path}/user/login",
				data :datas,
				success : function(msg) {
					if(msg.login&&msg.success){
						layer.msg(msg.message, {
						    icon: 1,
						    time: 1000 //2秒关闭（如果不配置，默认是3秒）
						}, function(){
						    //do something
						    $('#token', window.parent.document).attr("token",msg.str1);
						    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						    parent.layer.close(index);
						});
					}else{
						layer.msg(msg.message, {
						    icon: 1,
						    time: 2000 //2秒关闭（如果不配置，默认是3秒）
						});
					}
				}
			});
		}
	</script>
</body>
</html>