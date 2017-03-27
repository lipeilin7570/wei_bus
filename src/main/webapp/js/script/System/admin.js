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
//加载所有操作员信息
function search() {
    $('#tab').bootstrapTable({
        method:'post',
        url:'../../operator/findoperator.do',
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
        sortName:"sysloginname",
        sortOrder:"desc",
        //showColumns : true,
        responseHandler:checkData,
        columns:[
            {
                field:'check',
                align:'center',
                checkbox:true           
            }, {
                field:'sysusename',
                title:'用户名称',
                align:'center',
                valign:'middle',
                sortable:true          
            }, {
                field:'sysloginname',
                title:'登录账号',
                align:'center',
                valign:'middle',                
                sortable:true
            }, {
                field:'createtime',
                title:'创建时间',
                align:'center',
                valign:'middle',
          //      formatter:dateFormatter,
                sortable:true
            }, {
                field:'logintime',
                title:'登录时间',
                align:'center',
                valign:'middle',
         //       formatter:logintimeFormatter  
            }, {
                field:'roleid',
                title:'所属角色名称',
                align:'center',
                valign:'middle'
            }, {
                field:'depttype',
                title:'部门',
                align:'center',
                valign:'middle'
            }, {
                field:'dutytype',
                title:'职务',
                align:'center',
                valign:'middle',
            }, {
                field:'telphone',
                title:'电话',
                align:'center',
                valign:'middle',                                                     
            }, {
                field:'status',
                title:'状态',
                align:'center',
                valign:'middle',
                formatter:statusFormatter           
            }, {
                field:'remark',
                title:'备注',
                align:'center',
                valign:'middle'
            }, {
                field:'operate',
                title:'操作',
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
};
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
        userName:$('#userName').val(),
        loginName:$('#loginName').val(),
        companyID:$('#companyID').val(),
        roleID:$('#roleID').val(),
        status:$('#status').val(),
        telPhone:$('#telPhone').val()
    };
};
/*function dateFormatter(value, row, index){
    var myDate=new  Date();
    myDate.setTime(row.createTime);
    return myDate.formatter('yy-MM-dd')
}*/
function statusFormatter(value,row,index){
    var status;
    switch(value)
    {
        case 1:
            status='正常';
            break;
        case 2:
            status='暂停';
            break;
        case 3:
            status='销户';
            break;
        default :
            status='';
            break;
    }
    return status;
}
function operateFormatter(value, row, index){
    return [
        '<a class="edit" href="javascript:void(0)" title="Like" >编辑</a>&nbsp;&nbsp;',
        '<a class="empower" href="javascript:void(0)" title="status" >授权</a>'
    ].join('');
}
window.operateEvents={
    'click .edit': function (e, value, row, index){    	
    	$('#username').text(row.sysusename);    	
    	$('#loginno').text(row.sysloginname);   	  	
    	$('#user_telephone').text(row.telphone);   	
        $('#revise').click();              	
    },
    'click .empower': function (e, value, row, index){
    	$('#statusBtn').click();   	
    }
} 
//编辑提交
$(function(){
	$('#submit').click(function(){  
		var cookieval=readCookie("operateID")
    	var data={
    			'operatorID':cookieval,   			
				'pwd':$('#Pwd').val(),																								
    	};
    	$.ajax({
    		   type:"post",
			   dataType:"json",
			   url: "../../operator/changeInfo.do",    	    
			   data:data,
			   success:function(data){
				   if(data.status==0){
					   alert("编辑成功！");
					   search();
					   ss();
				   }
			   },
			   error:function(data){				   
				   alert("编辑失败！");
			   }
    	})
   })
})
//授权提交
$(function(){
	$('#btn_status').click(function(){  
		var cookieval=readCookie("operateID")
    	var data={
    			'operatorID':cookieval,   			
				'roleID':$('#role_name').val(),																								
    	};
    	$.ajax({
    		   type:"post",
			   dataType:"json",
			   url: "../../operator/changeOperatorRole.do",    	    
			   data:data,
			   success:function(data){
				   if(data.status==0){
					   alert("授权成功！");
					   search();
					   ss();
				   }
			   },
			   error:function(data){				   
				   alert("授权失败！");
			   }
    	})
   })
})
//新增
function addOpr(){
	$('#impload').click();			
}
function urlSubmit(){	
	var data={
			//'operatorID':row.sysoperatorid,
			'userName':$('#userName').val(),
			'pwd':$('#pwd').val(),
			'loginName':$('#loginName').val(),
			'roleID':$('#roleId').val(),
			'deptType':$('#deptType').val(),
			'telPhone':$('#telPhone').val(),
			'companyID':$('#company').val(),
			'remark':$('#remark').val()
	}
	$.ajax({
		type: "POST",
        url: "../../operator/addOperator.do",        
        dataType: "json",
        async:true,
        data:data,
        success:function(data){	        	
        	if(data.status==0){
        		alert('新增成功！');
        		search();
        		ss();
        	}
        },
        error:function(){
        	alert('新增失败！');
        }
	})	
}
//角色授权提交
//授权按钮
//function authorizeClick(){
//	var cookieval=readCookie("operateID");
//	
//	var data = {
//			'operatorID':'cookieval',
//			'role_name':$("#role_name").val()
//		}
//	$.ajax({
//		type:"POST",
//		url:"../../operator/",
//		dataType:"json",
//		data:data,
//		success:function(data){
//			if(data.status==0){
//				$(".tip_btn").click();
//				$(".tip_msg").text("授权成功！");
//			}else if(data.status==1){
//				$(".tip_btn").click();
//				$(".tip_msg").text("");
//			}else if(data.status==2){
//				$(".tip_btn").click();
//				$(".tip_msg").text("");
//			}else if(data.status==3){
//				$(".tip_btn").click();
//				$(".tip_msg").text();
//			}
//		},
//		error:function(){
//				$(".tip_btn").click();
//				$(".tip_msg").text("服务器异常！");
//		}			
//	})
//}
//角色授权