
//从localStorage中取出json字符串，然后将json字符串转化成对象,并返回.
if(!sessionStorage.getItem("operateID")){
	window.location.href = "operationFailure.html"
}

//从localStorage中取出json字符串，然后将json字符串分割
var id =  JSON.parse(sessionStorage.getItem("objStr")).menuList.split(",");
//遍历分割的id字符串
	id.forEach(function(obj){		
		$("#"+obj).css("display","block")
	})
//导航管理显示和隐藏
    $('#img-toggle').click(function(){
        if($("#aside").is(":hidden")){
            $("#aside").show();
        }else{
            $("#aside").hide();
        }
    });

//导航图标的切换
/*function toggle(){
    var imgObj=document.getElementById('img-toggle');
    var flag=(imgObj.getAttribute("src",2)=="imgs/top.png")
    imgObj.src=flag?"imgs/bottom.png":"imgs/top.png";
}*/
//导航栏隐藏与现实
$('.open').click(function(){
    if($(this).attr('class')=='closed'){
        $(this).attr('class','open');
        $(this).next('ul').attr('class','show')
    }else{
        $(this).attr("class","closed");
        $(this).next("ul").attr("class","hide");
    }
})
//安全退出
function back(){
      // if (confirm("您确吗？"))
      //  top.location = "login.html";
        //return false;
}
//用户修改自己信息
function overlay(){	
    $('#impload').click();
}
//修改提交
$(function(){	
	$('#impbut').click(function(){
		var cookieval=readCookie('operateID');
		var data={
				'operatorID':cookieval,
				'userName':$('#userName').val(),
				'pwd':$('#pwd').val(),
				'loginName':$('#loginName').val(),
				'deptType':$('#deptType').val(),
				'dutyType':$('#dutyType').val(),
				'telPhone':$('#telPhone').val(),
				'remark':$('#remark').val(),
		};
		$.ajax({
			type:'post',
			url:'../../operator/updateInfo.do',
			dataType:'json',
			data:data,
			success:function(data){
				if(data.status==0){
					alert('修改成功！');
				}else if(data.status==101){
					alert('登录名已存在！');
				}
			},
			error:function(){
				alert('服务异常！');
			}
		})
	})
})
//modal返回
function back(){
    window.close();
}