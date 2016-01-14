<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
	String basePath2 = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/common/head.jsp" %>
<html>
<head>
<script type="text/javascript">
var dPath = '<%=basePath%>';
var uid='${sessionScope.login_user.id}';
var fromName='${sessionScope.login_user.userName}';
var websocket;
if ('WebSocket' in window) {
	websocket = new WebSocket("ws://" + dPath + "/ws?uid="+uid);
} else if ('MozWebSocket' in window) {
	websocket = new MozWebSocket("ws://" + dPath + "/ws"+uid);
} else {
	websocket = new SockJS("http://" + dPath + "/ws/sockjs"+uid);
}
websocket.onopen = function(event) {
	/* console.log("WebSocket:已连接");
	console.log(event); */
};
websocket.onmessage = function(event) {
	var data=JSON.parse(event.data);
	//console.log("WebSocket:收到一条消息",data);
	var textCss="fmsg_text";
	$("#message-show").append("<div class='fmsg'><label class='name'>"+data.fromName+"&nbsp;"+data.date+"</label><div><span class='"+textCss+"'>"+data.text+"</span></div></div>");
	scrollToBottom();
};
websocket.onerror = function(event) {
	/* console.log("WebSocket:发生错误 ");
	console.log(event); */
};
websocket.onclose = function(event) {
	/* console.log("WebSocket:已关闭");
	console.log(event); */
}
//发送消息
function sendMsg(){
	var v=$("#msg").val();
	if(v==""||v.trim()==''){
		return;
	}else{
		var data={};
		data["from"]=uid;
		data["fromName"]=fromName;
		data["to"]="all";
		data["text"]=v;
		websocket.send(JSON.stringify(data));
		//$("#content").append("<div class='tmsg'><label class='name'>我&nbsp;"+new Date().Format("yyyy-MM-dd hh:mm:ss")+"</label><div class='tmsg_text'>"+data.text+"</div></div>");
		scrollToBottom();
		$("#msg").val('');
	}
}
//显示屏滚动到底部			
function scrollToBottom(){
	var div = document.getElementById('message-show');
	div.scrollTop = div.scrollHeight;
}
//格式化日期			
Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

$(function(){
	$("#msg").keydown(function(event){
		var code;
		 if(window.event){
			 code = window.event.keyCode; // IE
		 }else{
			 code = event.which; // Firefox
		 }
		if(code==13){ 
			sendMsg();            
		}
	})
});
//清空消息			
function clearAll(){
	$("#message-show").empty();
}
</script>
</head>
<body>
	<div class="owner-info">
		<div>
			<span>邮箱:</span>
			<span>w18855525068@163.com</span>
		</div>
		<div>
			<span>github：</span>
			<a href="https://github.com/wangming1255">https://github.com/wangming1255</a>
		</div>
	</div>
	<div class="message-body">
		<div class="message-welcome">欢迎：${sessionScope.login_user.userName }</div>
		<div id="message-show" class="message-show"></div>
		<div class="message-input">
			<textarea placeholder="请输入要发送的信息" id="msg" class="msg"></textarea>
			<input type="button" value="发送" class="send" onclick="sendMsg()" >
			<input type="button" value="清空" class="clear" onclick="clearAll()">
		</div>
	</div>
<style type="text/css">
.owner-info{ left: 62px; position: absolute; top: 62px;}
.message-body{
	width: 499px;
	margin:40px auto;
	background-color: #fff;
	height: 600px;
	border:1px solid #e5e5e5;
}
.message-welcome{
border-bottom:1px solid #e5e5e5;
}
.message-body .message-show{
	width: 100%;
	height: 499px;
	overflow-y:scroll;
	border-bottom:1px solid #e5e5e5;
}
.message-body .message-show .fmsg_text{
	background-color: #cff;
	border: 1px solid #cfc;
}
.message-body .message-show .fmsg_text::after{
	content: "    ";
}
.message-body .message-show .fmsg_text:after{
	content: "    ";
}
.message-body .message-input .msg{
	width:98.8%;
	resize:none;
}
.message-body .message-input .send{
	margin-left: 380px;
}
</style>
</body>
</html>
