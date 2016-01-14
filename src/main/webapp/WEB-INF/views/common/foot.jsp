<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
/**页面底部*/
.foot{bottom:0; background: #a0b3d6 none repeat scroll 0 0; border-top: 3px solid #a0b3d6;  height:100px;display:table;  clear: both;}
.foot>p{vertical-align:middle;display:table-cell;	border:1px solid #a0b3d6;background-color:#a0b3d6;width:760px; text-align: center;}
/**返回页面顶部*/
p#back-to-top{position:fixed; bottom:50px; left:1300px; display: none;}
p#back-to-top a{
      text-align:center;text-decoration:none; color:#d1d1d1; display:block;  width:30px;
      /*使用CSS3中的transition属性给跳转链接中的文字添加渐变效果*/
      -moz-transition:color 1s; -webkit-transition:color 1s; -o-transition:color 1s;}
p#back-to-top a:hover{ color:#979797;}
p#back-to-top a span{
      background:#d1d1d1 url(app/img/arrow-up.jpg) no-repeat center center/30px 30px;
      border-radius:6px; display:block; height:30px; width:30px; margin-bottom:5px;
      /*使用CSS3中的transition属性给<span>标签背景颜色添加渐变效果*/
      -moz-transition:background 1s; -webkit-transition:background 1s;-o-transition:background 1s;}
#back-to-top a:hover span{
      background:#979797 url(/xyan/app/img/arrow-up.jpg) no-repeat center center/30px 30px;
      border:1px;}
</style>
<div class="foot">
	<p>
		<!-- Powerd by <a href="/xyan">xyan</a> | Designed by
			<a href="/xyan">xyan</a> -->
		<span class="error-red">网站内容仅限于学习交流，禁止任何商业用途！</span> <br>
		Copyright© 2015-2016 欣言-欣言空间-欣言生活 <br>
		<!-- <a href="http://www.miibeian.gov.cn/" target="_blank">鄂ICP备09015569号</a> -->
	</p>
</div>
<p id="back-to-top">
	<a><span></span>返回顶部</a>
</p>
<script type="text/javascript" src="${path}/assets/plugins/layer/layer.js"></script>
</body>
</html>