<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/head-adv.jsp" %>
<!-- 首页css -->
<link type="text/css" rel="stylesheet" href="${path}/app/css/index.css" />
<!-- 图片轮播css -->
<link  type="text/css"rel="stylesheet" href="${path}/assets/plugins/flexslider/flexslider.css">
	<div class="main-body">
		<div class="main float ">
			<div class="main-front">
				<h2>
					<span></span>
					前端技术
				</h2>
				<div class="main-front-container">
					<c:forEach var="item" items="${frontList}">
						<div class="main-front-item">
							<span class="item-t-title"><a
								href="${path}/read/${item.id}" target="_blank">${item.title}</a></span>
							<div class="item-title">
								<span class="item-title-item"> <fmt:formatDate
										value="${item.createTime}" pattern="yyyy年M月d日" />
								</span><span class="item-title-item">类别：${item.typeName} </span> <span
									class="item-title-item">阅读次数：${item.readCount} </span>
							</div>
							<div class="item-content ellipsis">${item.introduce}</div>
							<div class="item-foot">
								<a href="${path}/read/${item.id}" target="_blank">阅读更多...</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="main-back">
				<h2>
					<span></span>
					后端集成
				</h2>
				<div class="main-back-container">
					<c:forEach var="item" items="${backList}">
						<div class="main-front-item">
							<span class="item-t-title"><a
								href="${path}/read/${item.id}" target="_blank">${item.title}</a></span>
							<div class="item-title">
								<span class="item-title-item"> <fmt:formatDate
										value="${item.createTime}" pattern="yyyy-MM-dd" />
								</span> <span class="item-title-item"> ${item.typeName} </span> <span
									class="item-title-item"> ${item.readCount} </span>
							</div>
							<div class="item-content">${item.introduce}</div>
							<div class="item-foot">
								<a href="${path}/read/${item.id}" target="_blank">阅读更多...</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="mid-blank float"></div>
		<div class="right float ">
			<div class="right-img">
				<div class="right-img-container">
					<div>
						诚招广告商入驻
					</div>
					<div>
						诚招广告商入驻
					</div>
					<div>
						诚招广告商入驻
					</div>
					<div>
						诚招广告商入驻
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="clearf"></div>
	<div class="picture m-auto">
		<h2>妹子欣赏</h2>
		<div>
			<div class="flexslider carousel">
		        <ul class="slides">
		          <li class="picture-item">
		          	 <img src="${path}/app/img/mm1.jpg" />
		          </li>
		          <li class="picture-item"> 
		          	<img src="${path}/app/img/mm2.jpg" />
		          </li>
		          <li class="picture-item"> 
		          	<img src="${path}/app/img/mm3.jpg" />
		          </li>
		          <li class="picture-item"> 
		          	<img src="${path}/app/img/mm4.jpg" />
		          </li>
		          <li class="picture-item"> 
		          <img src="${path}/app/img/mm5.jpg" />
		           	</li>
		          <li class="picture-item"> 
		          	<img src="${path}/app/img/mm6.jpg" />
		          </li>
		        </ul>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/foot.jsp" %>
</body>
<script type="text/javascript" src="${path}/assets/plugins/flexslider/jquery.flexslider.js"></script>
<script type="text/javascript" src="${path}/assets/myPlugins/ellipsis.js"></script>
<script type="text/javascript" src="${path}/app/js/page/index.js"></script>
<script type="text/javascript" src="${path}/assets/plugins/layer/layer.js"></script>
<script type="text/javascript">
	$(function() {
		$(".ellipsis").ellipsis({times:3});
		//图片轮播
		$(".flexslider").flexslider({
			animation: "easeInOutQuart",
	        animationLoop: false,
	        slideshowSpeed:2000,
	        animationSpeed:300,
	        itemWidth: 210,
	        itemMargin: 5,
			minItems: 4,
	        maxItems: 5,
			move:1
	       // pausePlay: true
		});
	});
</script>

</html>