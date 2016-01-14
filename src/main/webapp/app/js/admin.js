var Admin={
	/**新增*/
	add :function(){
		var parentId=this.checkId();//获取选中的行
	},
	/**编辑*/
	edit :function(){
		var id=this.checkId();
		if(id.length!=1){
			alert("请选择一个");
		}else{
			window.location.href="/xyan/admin/edit/"+id.ids
		}
	},
	/**
	 * 保存
	 * @param num
	 */
	save :function(num){},
	/**获取选中的行*/
	checkId:function(){
		var length=$(".checkBOX:checked").length;
		var ids=[];
		if(length>0){
			$(".checkBOX:checked").each(function(){
				ids.push($(this).prop("name"));
			});
			return {"length":length,"ids":ids.join(",")};
		}else{
			return {"length":length,"ids":""};
		}
	},
	/**删除菜单*/
	del :function(){
		var id=this.checkId();
	},
	
	/**处理行点击事件*/
	fTrClick:function(obj){
		var check=$(obj).find(".checkBOX");
		var checked=check.prop("checked");
		if(checked){
			check.removeProp("checked");
		}else{
			check.prop("checked","checked");
		}
	}
}