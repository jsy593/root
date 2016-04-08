/*文本域字节*/
function size(par) {
var max = 200; 
if (par.value.length < max) 
var str = max - par.value.length; 
document.getElementById("span").innerHTML = str.toString(); 
} 

/*右侧个股咨询*/
$(document).ready(function(){
	$("#aFloatTools_Show").click(function(){
		$('#divFloatToolsView').animate({width: 'show', opacity: 'show'}, 'normal',function(){
			$('#divFloatToolsView').show();
		});
		$('#aFloatTools_Show').attr('style','display:none');
		$('#aFloatTools_Hide').attr('style','display:block');
	});
	
	$("#aFloatTools_Hide").click(function(){
		$('#divFloatToolsView').animate({width: 'hide', opacity: 'hide'}, 'normal',function(){
			$('#divFloatToolsView').hide();
		});
		$('#aFloatTools_Show').attr('style','display:block');
		$('#aFloatTools_Hide').attr('style','display:none');
	});
});


/*幻灯片*/
(function($){
	$.fn.slide=function(options){
       var defaults= {
		   affect:3,     //1：上下滚动; 2:幕布式; 3:左右滚动；4：淡入淡出
		   time: 4000,   //间隔时间
		   speed:500,    //动画快慢
		   dot_text:true,//按钮上有无序列号
	   };
	   var opts=$.extend(defaults,options);
	   
		   var $this=$(this);
		   var ool=$("<div class='dot'><p></p></div>");
		   var $box=$this.find("ul");
		   var $li=$box.find("li");
		   var timer=null;
		   var num=0;
	   
	   $this.append(ool);
	   $box.find("li").each(function(i){
			ool.find("p").append($("<b></b>"));
			if(opts.dot_text){
				ool.find("b").eq(i).html(i+1)
			}
       })
	   ool.find("b").eq(0).addClass("cur");
	   switch(opts.affect){
		   case 3:
			   $box.css({"width":$li.eq(0).width()*$li.length});
			   $li.css("float","left");
			   break;
	   }
	   $box.find("li").eq(0).show(0);
	   ool.find("b").mouseover(function(){	
			num=$(this).index();
			run ();
		})
		timer=setInterval(auto,opts.time);
			function auto(){
				num<$box.find("li").length-1?num++:num=0;
				run();
			}
		function run(){
			ool.find("b").eq(num).addClass("cur").siblings().removeClass("cur");
				switch(opts.affect){
					case 3:
						$box.stop(true,false).animate({"left":-224*num},opts.speed);
						break;	
				}
		}
		$this.mouseover(function(){
			  clearInterval(timer);	
		})
		 $this.mouseout(function(){
			  timer=setInterval(auto,opts.time);	
		})
}
})(jQuery)

$(function(){
	$(".af3").slide({
		affect:3,
		time:3000,
		speed:400,
	});

})

/*上传图片*/
var uploadPreview = function(setting) {
    var _self = this;
    _self.IsNull = function(value) {
        if (typeof (value) == "function") { return false; }
        if (value == undefined || value == null || value == "" || value.length == 0) {
            return true;
        }
        return false;
    }
    _self.DefautlSetting = {
        UpBtn: "",
        DivShow: "",
        ImgShow: "",
        Width: 0,
        height: 0,
        ImgType: ["gif", "jpeg", "jpg", "bmp", "png"],
        ErrMsg: "选择文件错误,图片类型必须是(gif,jpeg,jpg,bmp,png)中的一种",
        callback: function() { }
    };

    _self.Setting = {
        UpBtn: _self.IsNull(setting.UpBtn) ? _self.DefautlSetting.UpBtn : setting.UpBtn,
        DivShow: _self.IsNull(setting.DivShow) ? _self.DefautlSetting.DivShow : setting.DivShow,
        ImgShow: _self.IsNull(setting.ImgShow) ? _self.DefautlSetting.ImgShow : setting.ImgShow,
        Width: _self.IsNull(setting.Width) ? _self.DefautlSetting.Width : setting.Width,
        Height: _self.IsNull(setting.Height) ? _self.DefautlSetting.Height : setting.Height,
        ImgType: _self.IsNull(setting.ImgType) ? _self.DefautlSetting.ImgType : setting.ImgType,
        ErrMsg: _self.IsNull(setting.ErrMsg) ? _self.DefautlSetting.ErrMsg : setting.ErrMsg,
        callback: _self.IsNull(setting.callback) ? _self.DefautlSetting.callback : setting.callback
    };

    _self.getObjectURL = function(file) {
        var url = null;
        if (window.createObjectURL != undefined) {
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) {
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) {
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }

    _self.Bind = function() {

			document.getElementById(_self.Setting.UpBtn).onchange = function() {
				if (this.value) {
					if (!RegExp("\.(" + _self.Setting.ImgType.join("|") + ")$", "i").test(this.value.toLowerCase())) {
						alert(_self.Setting.ErrMsg);
						this.value = "";
						return false;
					}
					if (navigator.userAgent.indexOf("MSIE") > -1) {
						try {
							document.getElementById(_self.Setting.ImgShow).src = _self.getObjectURL(this.files[0]);
						} catch (e) {
							var div = document.getElementById(_self.Setting.DivShow);
							this.select();
							top.parent.document.body.focus();
							var src = document.selection.createRange().text;
							document.selection.empty();
							document.getElementById(_self.Setting.ImgShow).style.display = "none";
							div.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
							div.style.width = _self.Setting.Width + "px";
							div.style.height = _self.Setting.Height + "px";
							div.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = src;
						}
					} else {
						document.getElementById(_self.Setting.ImgShow).src = _self.getObjectURL(this.files[0]);
					}
					_self.Setting.callback();
				}
	
        }
    }

    _self.Bind();
}

function file_click(){
	var WARP = document.getElementById('warp');
	var WARP_LI = WARP.getElementsByTagName('li');
	for(var i=0; i<WARP_LI.length;i++){
		new uploadPreview({ UpBtn: "up_img_WU_FILE_"+i, ImgShow: "imgShow_WU_FILE_"+i});		
	}
}
window.onload = file_click;