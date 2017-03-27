if(!sessionStorage.getItem("operateID")){
	window.location.href = "../../operationFailure.html"
}
$(document).ready(function(){
    search();
})
function ss(){
//	search()
    $('#tab').bootstrapTable('refresh');
}
function checkData(res){
    return res;
}

function search() {
    $('#tab').bootstrapTable({
        method:'post',
        url:'../../order/queryFault.do',
        cache:false,
        height:"auto",
        striped:true,
        pagination:true,
        pageSize:5,
        pageNumber:1, 
//      search : true,
        sidePagination:'client',
        contentType:"application/x-www-form-urlencoded",
        queryParams:queryParams,
        queryParamsType:'undefined', // undefined
        sortable:true,
        sortName:"faultNum",
        sortOrder:"desc",
        showColumns : true,
        responseHandler:checkData,
        columns:[
            {
                field:'check',
                width:'30px',
                checkbox:true
            }, {
                field:'LeaseNo',
                title:'订单编号',
                align:'center',
                valign:'middle',
                sortable:true            
            }, {
                field:'LeaseCarNo',
                title:'车牌号&nbsp;&nbsp;&nbsp;&nbsp;',
                align:'center',
                valign:'middle',
                sortable:true                                  
            },{
            	field:'LeaseTime',
                title:'订单时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                align:'center',
                valign:'middle',
                sortable:true   
            },{
                field:'UserName',
                title:'用户名称',
                align:'center',
                valign:'middle'
            }, {
                field:'UserPhone',
                title:'手机号码',
                align:'center',
                valign:'middle'
            }, {
                field:'FaultNo',
                title:'故障编号',
                align:'center',
                valign:'middle'
            }, {
                field:'FaultTime',
                title:'故障发生时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                align:'center',
                valign:'middle'
            }, {
                field:'FaultDetail',
                title:'故障详情&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                align:'center',
                valign:'middle'          
            }, {
                field:'UserFault',
                title:'故障责任&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                align:'center',
                valign:'middle' ,
                formatter:UserFaultFormatter 
            }, {
                field: 'FaultStatus',
                title: '故障处理状态&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                align: 'center',
                valign: 'middle',
                formatter:FaultStatusFormatter
            }, {
                field: 'FaultBailFee',
                title: '应缴纳保证金/元',
                align: 'center',
                valign: 'middle'
            },{
                field: 'FaultBailPay',
                title: '已缴纳保证金/元',
                align: 'center',
                valign: 'middle'
            },{
                field: 'FaultRepairStatus',
                title: '故障维修状态',
                align: 'center',
                valign: 'middle',
                formatter:FaultRepairStatusFormatter
            },{
                field: 'FaultRepairTime',
                title: '维修完成时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                align: 'center',
                valign: 'middle',
                formatter:FaultRepairTimeFormatter
            },{
                field: 'FaultRepairDetail',
                title: '维修详情&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                align: 'center',
                valign: 'middle'
            },{
                field: 'FaultRepairFee',
                title: '维修费用/元',
                align: 'center',
                valign: 'middle'
            },{
                field: 'FaultUserFee',
                title: '客户需付费/元',
                align: 'center',
                valign: 'middle'
            },{
                field: 'FautlUserPayStatus',
                title: '客户支付状态',
                align: 'center',
                valign: 'middle',
                formatter:FauUserPayStatusFormatter
            },{
                field: 'FaultUserPay',
                title: '客户已支付费用/元',
                align: 'center',
                valign: 'middle'
            },{
                field: 'FaultUserPayTime',
                title: '支付时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                align: 'center',
                valign: 'middle'
            }, {
                field:'operate',
                title:'操作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                valign:'middle',
                formatter:operateFormatter,
                events:operateEvents 
            }
        ],
        onLoadSuccess:function(){
//            alert("success");
        },
        onLoadError:function(){
//            alert("失败");
//            location.reload();
        }
    });
};

function operateFormatter(value, row, index){
    return [
        '<a class="detail" href="javascript:void(0)" title="like">维修录入</a>&nbsp;|',
        '<a class="deposit" href="javascript:void(0)" title="like">扣除故障保证金</a>&nbsp;|',
        '<a class="unfreeze" href="javascript:void(0)" title="like">解冻故障保证金</a>&nbsp;'
    ].join('');
}
window.operateEvents={
		'click .detail':function(e, value, row, index){
			$('#repaireRecord').click();
	      	$('#fault_repaire').attr('data-id',row.LeaseID);
	      	$('#fault_repaire').attr('data-faultID',row.FaultID);
		},
		'click .deposit':function(e,value,row,index){
			$("#deductDeposit").click();
			$("#dec_table").attr('data-id',row.LeaseID); 
			$("#dec_table").attr('data-faultID',row.FaultID);			
		},
		'click .unfreeze':function(e,value,row,index){
			$("#unfreezeDeposit").click();
			$("#unfreeze_table").attr("data-id",row.LeaseID);
			$("#unfreeze_table").attr('data-faultID',row.FaultID);
		}
}

//维修录入提交
function repaireClick(){
	var cookieval=readCookie("operateID");		
	var data = {
		'operatorID':cookieval,
		'faultID':$('#fault_repaire').attr("data-faultID"),
		'repairTime':$("#repairTime").val(),
		'repairDetail':$("#repairDetail").val(),
		'repairFee':$("#repairFee").val(),
		'userPayFee':$("#userPayFee").val(),
		'remark':$("#remark").val()
	}
	console.log(data)
	$.ajax({
	type:"post",
	dataType:"json",
	url:"../../order/faultRepaired.do",
	data:data,
	success:function(data){
		if(data.status==0){
//			alert("提交成功")
			$("#del_btn").click();
			$(".del_msg").text("提交成功！")
			search();
			ss();
		}else if(data.status==101){
			$("#del_btn").click();
			$(".del_msg").text("找不到车辆！")
//			alert("找不到车辆")
		}else if(data.status==102){
			$("#del_btn").click();
			$(".del_msg").text("故障发生时间早于预约时间/提车时间！")
//			alert("故障发生时间早于预约时间/提车时间")
		}
	},
	error:function(data){
		$("#del_btn").click();
		$(".del_msg").text("服务器异常！")
//		console.log("服务器异常")
	}
})
}

//扣除故障保证金接口
	function dec_click(){
		var cookieval=readCookie("operateID");	
		var data={
				'operatorID':cookieval,
				'leaseID':$('#dec_table').attr("data-id"),
				'faultID':$('#dec_table').attr("data-faultID"),
				'decMoney':$("#decMoney").val(),
				'decReason':$("#decReason").val(),
//				'freeBail':$("#freeBail").val()
		}
		console.log(data)
		$.ajax({
			type:"post",
			dataType:"json",
			url:"../../order/useFaultBail.do",
			data:data,
			success:function(data){
				if(data.status=='0'){
					$("#del_btn").click();
					$(".del_msg").text("扣除成功！")
				}else if(data.status=='101'){
					$("#del_btn").click();
					$(".del_msg").text("保证金未缴纳或已解冻，无法扣除！")
				}else if(data.status=="102"){
					$("#del_btn").click();
					$(".del_msg").text("保证金剩余金额不足!剩余金额："+data.data.RemainMoney)
				}else if(data.status=="103"){
					$("#del_btn").click();
					$(".del_msg").text("保证金解冻失败!")
				}else if(data.status=="104"){
					$("#del_btn").click();
					$(".del_msg").text("故障或事故状态不对，不能扣除!");
				}else if(data.status=="201"){
					$("#del_btn").click();
					$(".del_msg").text("没有故障信息!")
				}
			},
			error:function(data){
				$("#del_btn").click();
				$(".del_msg").text("服务器异常！")
//				console.log("服务器异常")
			}
		})
	}

//	解冻保证金
	function unfreezeClick(){
		var cookieval=readCookie("operateID");		
		var datas = {
			'operatorID':cookieval,
			'leaseID':$('#unfreeze_table').attr("data-id"),
			'faultID':$('#unfreeze_table').attr("data-faultID"),
		}
		$.ajax({
			type:"post",
			dataType:"json",
			url:"../../order/freeFaultBail.do",
			data:datas,
			async:false,
			success:function(data){
				if(data.status=='0'){
//					$("#del_btn").click();
//					$(".del_msg").text("解冻成功，解冻金额为："+data.data.FreeMoney+"元！");
					var feeNum = data.data.FreeMoney;	
					var sendData = {
							'operatorID':cookieval,
							'leaseID':$('#unfreeze_table').attr("data-id")							
						}
					console.log(sendData)
					$.ajax({
						type:"post",
						dataType:"json",
						url:"../../order/faultEnd.do",
						data:sendData,
						async:false,
						success:function(data){
							if(data.status=="0"){
								$("#del_btn").click();								
								$(".del_msg").text("解冻成功，解冻金额为："+feeNum+"元！");
								$(".finish_tip").text("故障已处理完毕!");
							}
//				  			else if(data.status=="101"){
//								$("#del_btn").click();
//								$(".del_msg").text("解冻成功，解冻金额为："+feeNum+"元！");
//								$(".finish_tip").text("找不到故障，故障仍未处理完毕!");
//							}else if(data.status=="102"){
//								$("#del_btn").click();
//								$(".del_msg").text("解冻成功，解冻金额为："+feeNum+"元！");
//								$(".finish_tip").text("故障状态不对，故障仍未处理完毕!");
//							}else if(data.status=="103"){
//								$("#del_btn").click();
//								$(".del_msg").text("解冻成功，解冻金额为："+feeNum+"元！");
//								$(".finish_tip").text("故障费用未支付，故障仍未处理完毕!");
//							}else if(data.status=="104"){
//								$("#del_btn").click();
//								$(".del_msg").text("解冻成功，解冻金额为："+feeNum+"元！");
//								$(".finish_tip").text("保证金未解冻，故障仍未处理完毕!");
//							}							
						},
						error:function(data){
							$("#del_btn").click();
							$(".del_msg").text("处理完毕服务器异常！")
						}
					})					
				}else if(data.status=='101'){
					$("#del_btn").click();
					$(".del_msg").text("保证金未缴纳或已解冻，无法解冻！")
//					var sendData = {
//							'operatorID':cookieval,
//							'leaseID':$('#unfreeze_table').attr("data-id")							
//						}
//					console.log(sendData)
//					$.ajax({
//						type:"post",
//						dataType:"json",
//						url:"../../order/faultEnd.do",
//						data:data,
//						async:false,
//						success:function(data){
//							if(data.status=="0"){
//								$("#del_btn").click();								
//								$(".del_msg").text("解冻成功，解冻金额为："+feeNum+"元！");
//								$(".finish_tip").text("故障已处理完毕!");
//							}
//							else if(data.status=="101"){
//								$("#del_btn").click();
//								$(".del_msg").text("解冻成功，解冻金额为："+feeNum+"元！");
//								$(".finish_tip").text("找不到故障，故障仍未处理完毕!");
////								$(".del_msg").text("找不到故障!");
//							}else if(data.status=="102"){
//								$("#del_btn").click();
//								$(".del_msg").text("解冻成功，解冻金额为："+feeNum+"元！");
//								$(".finish_tip").text("故障状态不对，故障仍未处理完毕!");
////								$(".del_msg").text("故障状态不对!");
//							}else if(data.status=="103"){
//								$("#del_btn").click();
//								$(".del_msg").text("解冻成功，解冻金额为："+feeNum+"元！");
//								$(".finish_tip").text("故障费用未支付，故障仍未处理完毕!");
////								$(".del_msg").text("故障费用未支付!");
//							}else if(data.status=="104"){
//								$("#del_btn").click();
//								$(".del_msg").text("解冻成功，解冻金额为："+feeNum+"元！");
//								$(".finish_tip").text("保证金未解冻，故障仍未处理完毕!");
////								$(".del_msg").text("保证金未解冻!");
//							}							
//						},
//					})					
				}else if(data.status=="201"){
					$("#del_btn").click();
					$(".del_msg").text("没有故障信息！")
				}
			},
			error:function(data){
				$("#del_btn").click();
				$(".del_msg").text("服务器异常！")
//				console.log("服务器异常")
			}
		})
	}
	
var sn;
var so;
function queryParams(params) {
    sn = params.sortName;
    so = params.sortOrder;
    var cookieval=readCookie("operateID");	
    return {
        pageSize: params.pageSize,
        pageNumber: params.pageNumber,
        sortName: params.sortName,
        sortOrder: params.sortOrder,
        'operatorID':cookieval,
		'days':$("#faultDays").val(),
		'faultStatus':$("#faultStatus").val(),
		'leaseID':$("#faultLeaseID").val(),
		'carNo':$("#carNum").val()
    };
}
//function dateFormatter(value, row, index){
//    var myDate=new  Date();
//    myDate.setTime(row.createTime);
//    return myDate.formatter('yy-MM-dd')
//}

//事故责任字段解析
function UserFaultFormatter(value,row,index){
    var UserFault;
    switch(value)
    {
        case 1:
        	UserFault='车辆自身故障';
            break;
        case 2:
        	UserFault='会员导致的故障';
            break;
        case 3:
        	UserFault='待确认';
            break;
        default :
        	UserFault='';
            break;
    }
    return UserFault;
}
//故障处理状态字段解析
function FaultStatusFormatter(value,row,index){
    var FaultStatus;
    switch(value)
    {
        case 1:
        	FaultStatus='已录入';
            break;
        case 2:
        	FaultStatus='已确认故障责任';
            break;
        case 3:
        	FaultStatus='待缴纳保证金';
            break;
        case 4:
        	FaultStatus='已缴纳保证金';
            break;
        case 5:
        	FaultStatus='已维修';
            break;
        case 6:
        	FaultStatus='已完成';
            break;
        case 7:
        	FaultStatus='撤销';
            break;
        default :
        	FaultStatus='';
            break;
    }
    return FaultStatus;
}

//故障维修状态字段解析
function FaultRepairStatusFormatter(value,row,index){
    var FaultRepairStatus;
    switch(value)
    {
        case 0:
        	FaultRepairStatus='正在维修';
            break;
        case 1:
        	FaultRepairStatus='维修完毕';
            break;
        default :
        	FaultRepairStatus='';
            break;
    }
    return FaultRepairStatus;
}
//客户支付状态字段解析
function FauUserPayStatusFormatter(value,row,index){
    var FauUserPayStatus;
    switch(value)
    {
        case 0:
        	FauUserPayStatus='未支付';
            break;
        case 1:
        	FauUserPayStatus='已支付';
            break;
        default :
        	FauUserPayStatus='';
            break;
    }
    return FauUserPayStatus;
}

//维修完毕时间字段解析
function FaultRepairTimeFormatter(value,row,index){
	var FaultRepairTime;
	if(!row.FaultRepairTime){
		FaultRepairTime == "";
	}
	return FaultRepairTime;
}


