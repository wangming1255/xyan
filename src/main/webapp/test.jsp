<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>flexslider说明</title>
<style type="text/css">
pre{
	-moz-border-bottom-colors: none;
    -moz-border-left-colors: none;
    -moz-border-right-colors: none;
    -moz-border-top-colors: none;
    background: #fafafa none repeat scroll 0 0;
    border-color: #d7d7d7;
    border-image: none;
    border-style: solid;
    border-width: 1px 1px 1px 5px;
    font-size: 12px;
    margin: 6px auto;
    padding: 4px;
    white-space: pre-wrap;
    word-wrap: break-word;
}
</style>
</head>
<body>
<dl>
	<dt>lexslider具有以下特性：</dt>
    <dd>支持滑动和淡入淡出效果。</dd>
    <dd>支持水平、垂直方向滑动。</dd>
    <dd>支持键盘方向键控制。</dd>
    <dd>支持触控滑动。</dd>
    <dd>支持图文混排，支持各种html元素。</dd>
   	<dd>自适应屏幕尺寸。</dd>
    <dd>可控制滑动单元个数。</dd>
    <dd>更多选项设置和回调函数。</dd>
</dl>
<h2>HTML</h2>
<div>
	首先在页面head部位载入jquery库文件和Flexslider插件，以及Flexslider所需的基本css样式文件。
	<pre>
		<code class="html">
			<link rel="stylesheet" type="text/css" href="flexslider.css" /> 
			<script type="text/javascript" src="jquery-1.7.2.min.js"></script> 
			<script type="text/javascript" src="jquery.flexslider-min.js"></script> 
		</code>
	</pre>
	然后在body中加入以下HTML代码：
	<pre>
		<code class="html">
			<div class="flexslider"> 
			      <ul class="slides"> 
			        <li><img src="images/s1.jpg" /></li> 
			        <li><img src="images/s2.jpg" /></li> 
			        <li><img src="images/s3.jpg" /></li> 
			        <li><img src="images/s4.jpg" /></li> 
			      </ul> 
			</div> 
		</code>
	</pre>
</div>
<p>
	我们使用了.flexslider来包括所有需要滚动的内容元素，然后使用&lt;ul class="slides"&gt;这个class非常关键，
	内部的滚动内容都是针对.slides的，然后在&lt;li&gt;内部加入任意html元素，包括图片和文字。
</p>
<h2>jQuery</h2>
<div>
	调用Flexslider插件非常简单，使用如下代码：
	<pre>
		<code class="html">
			$(function() { 
			    $(".flexslider").flexslider(); 
			}); 
		</code>
	</pre>    
</div>
<p>
然后预览网页效果，一个内容切换效果就完成了，当然想要更多个性化设置，flexslider提供了丰富的选项配置以及回调函数绝对可以满足大多数开发者需求。
</p>
<h3>Flexslider选项设置</h3>
<table>
	<thead>
		<tr>
			<th>参数</th>
			<th>描述</th>
			<th>默认值</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>animation</td>
			<td>动画效果类型，有"fade"：淡入淡出，"slide"：滑动</td>
			<td>"fade"</td>
		</tr>
		<tr>
			<td>easing</td>
			<td>内容切换时缓动效果，需要jquery easing插件支持 </td>
			<td>"swing"</td>
		</tr>
		<tr>
			<td>direction</td>
			<td>内容滚动方向，有"horizontal"：水平方向 和"vertical"：垂直方向</td>
			<td>"horizontal"</td>
		</tr>
		<tr>
			<td>animationLoop</td>
			<td>是否循环滚动 </td>
			<td>true</td>
		</tr>
		<tr>
			<td>startAt</td>
			<td>初始滑动时的起始位置，定位从第几个开始滑动 	</td>
			<td>0</td>
		</tr>
		<tr>
			<td>slideshow</td>
			<td>是否自动滑动</td>
			<td>true</td>
		</tr>
		<tr>
			<td>slideshowSpeed</td>
			<td>滑动内容展示时间(ms)</td>
			<td>7000</td>
		</tr>
		<tr>
			<td>animationSpeed</td>
			<td>内容切换时间(ms)</td>
			<td>600</td>
		</tr>
		<tr>
			<td>initDelay</td>
			<td>初始化时延时时间</td>
			<td>0</td>
		</tr>
		<tr>
			<td>pauseOnHover</td>
			<td>鼠标滑向滚动内容时，是否暂停滚动</td>
			<td>false</td>
		</tr>
		<tr>
			<td>touch</td>
			<td>是否支持触摸滑动 </td>
			<td>true</td>
		</tr>
		<tr>
			<td>directionNav</td>
			<td>是否显示左右方向箭头按钮</td>
			<td>true</td>
		</tr>
		<tr>
			<td>keyboard</td>
			<td>是否支持键盘方向键操作</td>
			<td>true</td>
		</tr>
		<tr>
			<td>minItems</td>
			<td>一次最少展示滑动内容的单元个数</td>
			<td>1</td>
		</tr>
		<tr>
			<td>maxItems</td>
			<td>一次最多展示滑动内容的单元个数</td>
			<td>0</td>
		</tr>
		<tr>
			<td>move</td>
			<td>一次滑动的单元个数</td>
			<td>0</td>
		</tr>
		<tr>
			<td>回调函数</td>
			<td>
				start: function(){},<br/>
				before: function(){},<br/>
				after: function(){},<br/>
				end: function(){},<br/>
				added: function(){},<br/>
				removed: function(){},<br/>
				init: function(){}, 
			</td>
			<td>-</td>
		</tr>
	</tbody>
</table>
<p>
	更多Flexslider相关信息可以访问Flexslider官网地址：
	<a href="http://www.woothemes.com/flexslider/">http://www.woothemes.com/flexslider/</a>
</p>
</body>
</html>