<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.read-content{
		text-indent: 2em;
	}
</style>
</head>
<body>
<div class="main-content">
	<h1>${model.title}</h1>
	<div>
		<p>本文作者 <a href="${path}">王明</a></p>
		<p>本文地址：<a href="${path}/read/${model.id}">http://www.xyan.com/read/${model.id}</a></p>
	</div>
	<div class="read-content">${model.content}</div>
	<div class="other">
		<span class="other-pre">
			上一篇：
			<c:if test="${preModel.id eq null }">
				<a href="###">没有了</a>
			</c:if>
			<c:if test="${preModel.id ne null}">
				<a href="${path}/read/${preModel.id}">${preModel.title}</a>
			</c:if>
		</span>
		<style type="text/css">
			h1{
				font-weight: bold;
			}
			.main-content{
				width: 999px;
				margin: 45px auto;
				background-color: #fff
			}
			.other-pre{float: left;}
			.other-next{float: right;}
			.comment-add input,.comment-add textarea{
				background-color: #fff;
    			border: 1px solid #7f9db9;
			}
			.comment-add input:focus, .comment-add textarea:focus {
			    border-color: #34538b;
			    box-shadow: 0 1px #f0f3f9 inset;
			}
			.button{
				min-height: 1.5em;
			    display: inline-block;
			    padding: 12px 36px;
			    margin: 10px 5px 5px 0px;
			    cursor: pointer;
			    opacity: 0.9;
			    color: #FFF;
			    font-size: 1em;
			    letter-spacing: 1px;
			    text-shadow: rgba(0,0,0,0.9) 0px 1px 2px;
			    background: #434343;
			    border: 1px solid #242424;
			    border-radius: 4px;
			    box-shadow: rgba(255,255,255,0.25) 0px 1px 0px, inset rgba(255,255,255,0.25) 0px 1px 0px, inset rgba(0,0,0,0.25) 0px 0px 0px, inset rgba(255,255,255,0.03) 0px 20px 0px, inset rgba(0,0,0,0.15) 0px -20px 20px, inset rgba(255,255,255,0.05) 0px 20px 20px;
			    transition: all 0.1s linear;
			}
			.button:hover{
			    box-shadow: rgba(0,0,0,0.5) 0px 2px 5px, inset rgba(255,255,255,0.25) 0px 1px 0px, inset rgba(0,0,0,0.25) 0px 0px 0px, inset rgba(255,255,255,0.03) 0px 20px 0px, inset rgba(0,0,0,0.15) 0px -20px 20px, inset rgba(255,255,255,0.05) 0px 20px 20px;
			}
			.button span{
				display: block;
			    position: relative;
			    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#00ffffff', endColorstr='#00ffffff',GradientType=1 );
			    background: linear-gradient(left, rgba(255,255,255,0) 0%,rgba(255,255,255,1) 50%,rgba(255,255,255,0) 100%);
			    padding: 0px 12px;
			    top: -12px;
			    left: -24px;
			    text-align:center;
			    height: 1px;
			    box-shadow: rgba(255,255,255,0.2) 0px 1px 5px;
			    transition: all 0.3s ease-in-out;
			}
			.comment-f{ color: #34538b;cursor: pointer; }
			.comment-list ol li{
				list-style: outside none decimal;
				border: 1px solid #ddd;
				margin-top: 20px;
			}
			.pay{
				background: #eee none repeat scroll 0 0;
    			border: 1px dashed #ccc;
    			margin-top: 25px;
			}
			.alipay_img img{
					width: 400px;
					height: 320px;
			}
		</style>
		<span class="other-next">
			下一篇：
			<c:if test="${nextModel.id eq null}">
				<a href="###">没有了</a>
			</c:if>
			<c:if test="${nextModel.id ne null}">
				<a href="${path}/read/${nextModel.id}">${nextModel.title}</a>
			</c:if>
		</span>
	</div>
	<div class="clearf"></div>
	<div class="pay">
		如果您觉得本文的内容对您的学习有所帮助，您可以支付宝(左)或微信(右)：
		<div class="alipay_img">
			&nbsp;&nbsp;&nbsp;&nbsp;
			<img src="${path}/app/img/ali-pay.jpg">
			&nbsp;&nbsp;&nbsp;&nbsp;
			<img src="${path}/app/img/wechat-pay.jpg">
			&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
	</div>
	<div class="read-comment">
		<h2>评论区</h2>
		<div class="comment-add">
			<form action="" id="addCommentForm">
				<input name="blogId" value="${model.id}" type="hidden">
				<div><input type="text" name="title"/>&nbsp;&nbsp;名称</div>
				<div><input type="text" style="line-height: 34px;" name="commentCode"><img alt="评论验证码" class="code-img"src="${path}/commentImg"></div>
				<div>
					<textarea rows="" cols="" name="content"></textarea>
				</div>
				<div class="button" onclick="addComment()" ><span></span>发表评论</div>
			</form>
		</div>
		<div class="comment-list">
			<ol id="comment-ol">
				<c:forEach items="${commentList}" var="item">
					<li>
						<div>
							<fmt:formatDate value="${item.commentDate}" pattern="yyyy年M月d日  H时m分s秒"/>
							<span class="comment-f">${item.userName}</span>说到
							<span class="comment-title">${item.title}</span>
							</div>
						<div class="comment-content">${item.content}</div>
						<span class="comment-f" id="${item.id}">回复</span>
					</li>
				</c:forEach>
			</ol>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/common/foot.jsp" %>
<script type="text/javascript" src="${path}/assets/plugins/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${path}/assets/plugins/layer/layer.js"></script>
<script type="text/javascript" src="${path}/app/js/animatescroll.js"></script>
<script type="text/javascript">
	function addComment(){
		 $.ajax({
				type : "post",
				url : "${path}/saveComment",
				data :$('#addCommentForm').serialize(),
				success : function(msg) {
					//comment-ol/*id
					if(msg.success){
						var li=[];
						li.push("<li>");
						li.push("<div>");
						li.push(format(msg.modelData.commentDate, 'yyyy年MM月dd日 HH时mm分ss秒'));
						li.push("<span class='comment-f'>"+msg.modelData.userName+"</span>说到");
						li.push("<span class='comment-title'>"+msg.modelData.title+"</span>");
						li.push("</div>");
						li.push("<div class='comment-content'>"+msg.modelData.content+"</div>");
						li.push("<span class='comment-f' id='"+msg.modelData.id+"'>回复</span>");		
						$("#comment-ol").append(li.join(''));
						$('#comment-ol li:last').animatescroll({element:'#comment-ol',padding:20});
						layer.msg('评论成功', {
						    icon: 1,
						    time: 800 //2秒关闭（如果不配置，默认是3秒）
						});
					}else{
						layer.msg('评论失败', {
						    icon: 1,
						    time: 800 //2秒关闭（如果不配置，默认是3秒）
						});
					}
		
				}
		 });
	}
	$(function(){
		$(".comment-f").click(function(){
			
		});
	});
	
	var format = function(time, format){
	    var t = new Date(time);
	    return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a){
	        switch(a){
	            case 'yyyy':
	                return t.getFullYear();
	                break;
	            case 'MM':
	                return t.getMonth() + 1;
	                break;
	            case 'mm':
	                return t.getMinutes();
	                break;
	            case 'dd':
	                return t.getDate();
	                break;
	            case 'HH':
	                return t.getHours();
	                break;
	            case 'ss':
	                return t.getSeconds();
	                break;
	        }
	    })
	}
</script>
</body>
</html>