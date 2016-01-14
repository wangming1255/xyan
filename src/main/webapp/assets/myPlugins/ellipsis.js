/***
 * @author wangming
 * @since 2015年11月20日
 * 文字溢出处理
 * 文字所在的地方必须设置line-height
 */
(function($){      
    $.fn.extend({      
    	ellipsis:function(opt){      
    		   
			/*默认显示两行*/
			var defaults = {     
			    times:2
			  };
			var opts = $.extend({}, defaults, opt);   
			return $(this).each(function(){
				var $p = $(this);
				var bHeight=parseFloat($p.css("lineHeight").replace("px"))*opts.times;
				var height=$p.height()||$p.innerHeight()||$p.outerHeight()||$p.css("height");
				if($p.text().length>900){
					$p.text($p.text().substr(0,900));
				}
				if($p.text().length>400){
					$p.text($p.text().substr(0,400));
				}
				while (height > bHeight) {
					$p.text($p.text().replace(/(\s)*([a-zA-Z0-9]+|\W)(\.\.\.)?$/, "..."));
					height=$p.height()||$p.innerHeight()||$p.outerHeight()||$p.css("height");
				};
			});
		
    		
    	}      
    })      
})(jQuery); 