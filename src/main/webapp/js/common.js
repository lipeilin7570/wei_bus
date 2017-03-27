(function(){
	$.COM={
		alert:function(text){
			var warn=document.createElement('div');
			$(warn).attr('id','badWarn');
			$(warn).html(text);
			$('body').append(warn);
			$(warn).fadeIn('slow',function(){
				setTimeout(function(){
					$(warn).remove();
				},1500);
			});
			setTimeout(function(){
				$(warn).fadeOut('slow');
			},1000);
		},
		ajax:function(url,data,type){
			var out;
			$.ajax({
				url:url,
				data:data,
				type:type,
				async:false,
				success:function(res){
					out=res;
				}
			});
			return out;
		},
		//s==>2016-09-14 15:51:13
		getTimeTp1:function(time){
			var Time=new Date();
			//var s=Date.parse(Time); console.log(s/1000);//console.log(s/1000);==>s
			if(time)Time.setTime(time* 1000);
			var year=Time.getFullYear(),
				month=Time.getMonth()+1,
				day=Time.getDate(),
				hours=Time.getHours(),
				minute=Time.getMinutes(),
				seconds=Time.getSeconds();
			if(month<10)month='0'+month;
			if(day<10)day='0'+day;
			if(hours<10)hours='0'+hours;
			if(minute<10)minute='0'+minute;
			if(seconds<10)seconds="0"+seconds;
			return year+"-"+month+"-"+day+' '+hours+":"+minute+":"+seconds;
		},
		//2016-09-14 15:51:13  ==>  s*1000
		getTimeTp2:function(time){
			return Date.parse(new Date(time));
		},
		
		isPhone:function(phone){
			if (!/^(\+86)?[1][34578]\d{9}$/.test(phone))return false;return true;
		},
		
		getLinkData:function(name){
			var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		    var r = window.location.search.substr(1).match(reg); //console.log(window.location.search.substr(1)); console.log(r);
		    if(r!=null)return  unescape(r[2]); return null;
		}
	};
	$.Cookie={
		delet:function(name){
			var date=new Date();
		    date.setTime(date.getTime()-10000);
		    document.cookie=name+"=v; expire="+date.toGMTString()+"; path=/";
		},
		get:function(name,sysoperatorid){
			var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
		    if(arr=document.cookie.match(reg))return (arr[2]);return null;   
		},
		set:function(name,value,sysoperatorid){
			document.cookie=name+'='+value; //console.log(document.cookie);
			document.cookie=sysoperatorid+'='+value;
		}
	};
})($);
