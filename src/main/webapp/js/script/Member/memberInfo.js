if(!sessionStorage.getItem("operateID")){
	window.location.href = "../../operationFailure.html"
}
$(document).ready(function(){
    search();
})
function ss(){
    $('#tab').bootstrapTable('refresh');
}
function checkData(res){
    return res;
}
function search() {
    $('#tab').bootstrapTable({
        method:'post',
        url:'../../vip/loadUsers.do',
        cache:false,
        height:"auto",
        striped:true,
        pagination:true,
        pageSize:10,
        pageNumber:1,
        //search : true,
        sidePagination:'client',
        contentType:"application/x-www-form-urlencoded",
        queryParams:queryParams,
        queryParamsType:'undefined', // undefined
        sortable:true,
        sortName:"userNo",
        sortOrder:"desc",
        //showColumns : true,
        responseHandler:checkData,
        columns:[
            {
                field:'check',
                checkbox:true
            }, {
                field:'userNo',
                title:'会员编号',
                align:'center',
                valign:'middle',
                sortable:true          
            }, {
                field:'userName',
                title:'会员名',
                align:'center',
                valign:'middle',
                sortable:true
            }, {
                field:'telPhone',
                title:'手机号码',
                align:'center',
                valign:'middle',
                sortable:true
            }, {
                field:'authentication',
                title:'认证状态',
                align:'center',
                valign:'middle',
                formatter:authenticationFormatter,
                sortable:true
            }, {
                field:'createTimeStr',
                title:'创建时间',
                align:'center',
                valign:'middle',
               //formatter:dateFormatter,
                sortable:true
            }, {
                field:'approveTimeStr',
                title:'认证时间',
                align:'center',
                valign:'middle',
              //  formatter:dateFormatter,
                sortable:true
            }, {
                field:'rentalStatusInt',
                title:'租车状态',
                align:'center',
                valign:'middle',
                formatter:rentalStatusIntFormatter,
                sortable:true            
            }, {
                field:'amount',
                title:'积分数',
                align:'center',
                valign:'middle',
              //  formatter:dateFormatter,
                sortable:true
            }, {
                field:'level',
                title:'积分等级',
                align:'center',
                valign:'middle',
              //  formatter:dateFormatter,
                sortable:true
            }, {
                field:'operate',
                title:'操&nbsp;&nbsp;&nbsp;&nbsp;作',
                align:'center',
                valign:'middle',
                formatter:operateFormatter,
                events:operateEvents
            }
        ],
        
        onLoadSuccess:function(){
            //alert("success");
        	
        },
        onLoadError:function(){
           // location.reload();
        }
    });
}

var sn;
var so;
function queryParams(params){
	sn=params.sortName;
	so=params.sortOrder;
    return{
        pageSize:params.pageSize,
        pageNumber:params.pageNumber,
        sortName:params.sortName,
        sortOrder:params.sortOrder,
        userNo:$('#userNo').val(),
        userName:$('#userName').val(),
        telphone:$('#telphone').val(),
        createTimeStr:$('#createTimeStr').val(),
        approveTimeStr:$('#approveTimeStr').val(),
        authentication:$('#authentication').val()
    };
};
//认证状态
var authentication;
function authenticationFormatter(value,row,index){	
	switch(value){
	case 0:
		authentication="未认证";
		break;
	case 1:
		authentication="认证中";
		break;
	case 2:
		authentication="已认证";
		break;
	case 3:
		authentication="认证失败";
		break;
	default :
		authentication="";
		break;
	}
	return authentication;	
}
//租车状态
function rentalStatusIntFormatter(value,row,index){
	var rentalStatusInt;
	switch(value){
	case 0:
		rentalStatusInt="正常";
		break;
	case 1:
		rentalStatusInt="预约";
		break;
	case 2:
		rentalStatusInt="租车中";
		break;
	default :
		rentalStatusInt="";
		break;
	}
	return rentalStatusInt;	
}
function operateFormatter(value, row, index){
    return [
        '<a class="info" href="javascript:void(0)" title="info">认证信息</a>',
    ].join('');
}
window.operateEvents={
    'click .info': function (e, value, row, index){  	
    	$('#Modal').click();
    	$("#vip_imgs").attr("data-id",row.userID);
    	var data={'userID':$("#vip_imgs").attr("data-id")};
    	$.ajax({			
    			type:"post",
    			dataType:"json",
    			url: "../../vip/showUserData.do",    	    
    			data:data,
    			success: function (data) {	    
    				var result=data.data;
    				if(data.status==0){ 
    					$('#userNo').val(result.userNo);
    				    $("#phone").val(result.telPhone);    				    		    				    	   				    		        				    	        				    	
    				    $('#userName').val(result.userName);       				    	        				    	       				    	
        				$('#age').val(result.age);
        				$('#birStr').val(result.birStr);
        				$('#nationality').val(result.nationality);
        				$('#License').val(result.License);
        				$('#createTimeStr').val(result.createTimeStr) ;  	    		 
        				$('#authentication').val(result.authentication);
        				    	
        				$("#idPicA").attr("src",result.idPicA);
        				$("#idPicB").attr("src",result.idPicB);
        				$("#liPicA").attr("src",result.liPicA);
        				$("#liPicB").attr("src",result.liPicB); 
        				if(result.sex==1){
        				    $('#sex').val("男");
        				}else if(result.sex==2){
        				    $('#sex').val("女");
        				}
        				    return result.sex;
    				    }   				    	     				    		 	    				    		
    			},
    			error: function (data){	   	    	
    				   alert("服务异常!");	
    			}
    		});    				
     	}
}
//认证状态修改
$(function(){
	$('#save').click(function(){		
		var cookieval=readCookie("companyID");    					
		var value=$('#authentiCation').val();  
		var because=$('#reason').val();
		var data={
				'operatorID':cookieval,
				'userID':$("#vip_imgs").attr("data-id"),         					 
				'authentication':value, 
				'reason':because
		};			         				
		$.ajax({		
			type:"post",
			dataType:"json",
			url: "../../vip/changAuthentication.do",    	    
			data:data,
			success: function (result){	
				if(result.status==0){        					    	
			    		alert("认证成功！");
			    		search();
				    	ss();
			    	} else {
			    		alert('认证失败！');
			    	}        				         					   				    	     				    		 	    				    		
			},
			error: function (result){	   	    	
					alert("服务异常！");	
			}
		})	   	 
	})   
})
 window.onload = function(){
	var obj_select = document.getElementById("authentiCation");
	var obj_div = document.getElementById("two");
		obj_select.onchange = function(){
			obj_div.style. visibility = this.value==3? "visible" : "hidden";
		}
}