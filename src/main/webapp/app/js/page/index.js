$(function(){
	//返回顶部
	$('#back-to-top').click(function() {
		$("html,body").animate({
			scrollTop : 0
		}, 400);
		return false;
	});
	$(window).scroll(function() {
		if ($(window).scrollTop() > 100) {
			$("#back-to-top").fadeIn(1500);
		} else {
			$("#back-to-top").fadeOut(1500);
		}
	});
});

function checkLogin(obj){
	$.ajax({
		type : "get",
		url : path+"/user/checkLogin",
		success : function(msg) {
			if(msg.login&&msg.success){
				// ws.send($("#chat").val());
			}else{
				var index = layer.open({
					title:"请登录",
				    type: 2,
				    content: path+'/user/toLogin',
				    area: ['300px', '195px'],
				});
			}
		}
	});
}