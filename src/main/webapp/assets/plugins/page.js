(function(){
	//container 容器，count 总页数 pageindex 当前页数
	function setPage(container, count, pageindex,pageSize,url) {
		var container = container;//document.getElementById(containerId);
		var count = count;
		var pageindex = pageindex;
		var a = [];
		// 总页数少于10 全部显示,大于10 显示前3 后3 中间3 其余....
		if (pageindex == 1) {
			a[a.length] = "<a href=\"###\" class=\"prev unclick\">prev</a>";
		} else {
			a[a.length] = "<a href=\""+url+"?pageNo="+(pageindex-1)+"&pageSize="+pageSize+"\" class=\"prev\">prev</a>";
		}
		//设置
		function setPageList() {
			if (pageindex == i) {
				a[a.length] = "<a href=\""+url+"?pageNo="+i+"&pageSize="+pageSize+"\" class=\"on\">" + i + "</a>";
			} else {
				a[a.length] = "<a href=\""+url+"?pageNo="+i+"&pageSize="+pageSize+"\">" + i + "</a>";
			}
		}
		// 总页数小于10
		if (count <= 10) {
			for (var i = 1; i <= count; i++) {
				setPageList();
			}
		// 总页数大于10页
		}  else {
			if (pageindex <= 4) {
				for (var i = 1; i <= 5; i++) {
					setPageList();
				}
				a[a.length] = "...<a href=\""+url+"?pageNo="+count+"&pageSize="+pageSize+"\">" + count + "</a>";
			} else if (pageindex >= count - 3) {//当前页在最后三个中
				a[a.length] = "<a href=\""+url+"?pageNo=1&pageSize="+pageSize+"\">1</a>...";
				for (var i = count - 4; i <= count; i++) {
					setPageList();
				}
			} else { // 当前页在中间部分
				a[a.length] = "<a href=\""+url+"?pageNo=1&pageSize="+pageSize+"\">1</a>...";
				for (var i = pageindex - 2; i <= pageindex + 2; i++) {
					setPageList();
				}
				a[a.length] = "...<a href=\""+url+"?pageNo="+count+"&pageSize="+pageSize+"\">" + count + "</a>";
			}
		}
		if (pageindex == count) {
			a[a.length] = "<a href=\"###\" class=\"next unclick\">next</a>";
		} else {
			a[a.length] = "<a href=\""+url+"?pageNo="+(pageindex+1)+"&pageSize="+pageSize+"\" class=\"next\">next</a>";
		}
		container.innerHTML = a.join("");
		// 事件点击
		/*var pageClick = function() {
			var oAlink = container.getElementsByTagName("a");
			var inx = pageindex; // 初始的页码
			oAlink[0].onclick = function() { // 点击上一页
				if (inx == 1) {
					return false;
				}
				inx--;
				setPage(container, count, inx);
				return false;
			}
			for (var i = 1; i < oAlink.length - 1; i++) { // 点击页码
				oAlink[i].onclick = function() {
					inx = parseInt(this.innerHTML);
					setPage(container, count, inx);
					return false;
				}
			}
			oAlink[oAlink.length - 1].onclick = function() { // 点击下一页
				if (inx == count) {
					return false;
				}
				inx++;
				setPage(container, count, inx);
				return false;
			}
		}()*/
	};
	
	initPage=function(id){
		var jDom=$("#"+id);
		var pageSize=jDom.attr("pageSize");
		var count=jDom.attr("totalPages");
		var pageIndex=parseInt(jDom.attr("pageNo"));
		var url=jDom.attr("formId")?$("#"+jDom.attr("formId")).prop("action"):jDom.attr("pageUrl");
		console.log(url);
		setPage(jDom[0], count, pageIndex,pageSize,url);
	}
})()

