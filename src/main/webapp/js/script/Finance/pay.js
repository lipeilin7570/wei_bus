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
var url="";
function search() {
    $('#tab').bootstrapTable({
        method:'post',
        url:url,
        cache:false,
        height:"auto",
        striped:true,
        pagination:true,
        pageSize:5,
        pageNumber:1,
        search : true,
        sidePagination:'server',
        contentType:"application/x-www-form-urlencoded",
        queryParams:queryParams,
        queryParamsType:'undefined', // undefined
        sortable:true,
        sortName:"createTime",
        sortOrder:"desc",
        //showColumns : true,
        responseHandler:checkData,
        columns:[
            {
                field:'check',
                checkbox:true
            }, {
                field:'costNum',
                title:'缴费流水号',
                align:'center',
                valign:'middle',
                width:'50px',
                sortable:true
            }, {
                field:'memberName',
                title:'会员名称',
                align:'center',
                valign:'middle',
                width:'50px',
                sortable:true
            }, {
                field:'telPhone',
                title:'手机号',
                align:'center',
                valign:'middle',
                width:'50px',
                sortable:true
            }, {
                field:'costType',
                title:'缴费类型',
                align:'center',
                valign:'middle',
                formatter:costTypeFormatter,
                width:'100px',
                sortable:true
            }, {
                field:'createTime',
                title:'创建时间',
                align:'center',
                valign:'middle',
                formatter:dateFormatter,
                width:'50px',
                sortable:true
            }, {
                field:'completeTime',
                title:'完成时间',
                align:'center',
                valign:'middle',
                formatter:dateFormatter,
                width:'50px'
            }, {
                field:'feeMoney',
                title:'总费用',
                align:'center',
                valign:'middle',
                width:'50px',
                sortable:true
            }, {
                field:'PayMoney',
                title:'支付费用',
                align:'center',
                valign:'middle',
                width:'50px'                                
            }, {
                field:'payType',
                title:'支付方式',
                align:'center',
                valign:'middle',
                formatter:payTypeFormatter,
                width:'50px'
            }, {
                field:'feeStatus',
                title:'缴费状态',
                align:'center',
                valign:'middle',
                formatter:FeeStatusFormatter,
                width:'50px'
            }, {
                field:'checkMan',
                title:'审核人',
                align:'center',
                valign:'middle',
                width:'50px'           
            }, {
                field:'status',
                title:'审核状态',
                align:'center',
                valign:'middle',
                formatter:statusFormatter,
                width:'50px'
            }, {
                field:'remark',
                title:'备注',
                align:'center',
                valign:'middle',
                width:'50px'
            }
        ],
        onLoadSuccess:function(date){
          //  alert(date.data[10].carID);
        },
        onLoadError:function(){
           // location.reload();
        }
    });
};
//时间校验
function dateFormatter(value, row, index) {
	var myDate=new Date();
	myDate.setTime(row.enterTime);
    return myDate.format("yyyy-MM-dd");    
}
//费用类型
function costTypeFormatter(value,row,index){
	var costType;
	switch(value){
		case 1:
			costType='租车';
			break;
		case 2:
			costType='充值';
			break;
		case 3:
			costType='提现';
			break;	
		case 4:
			costType='违章';
			break;
		case 5:
			costType='故障';
			break;	
		default:
			costType='';
			break;
	}
	return costType;
}
//优惠类型
function couponTypeFormatter(value,row,index){
	var couponType;
	switch(value){
		case 1:
			couponType='折扣';
			break;
		case 2:
			couponType='金额';
			break;
		default:
			couponType='';
			break;
	}
	return couponType;
}
//支付方式
function payTypeFormatter(value,row,index){
	var payType;
	switch(value){
		case 1:
			payType='余额';
			break;
		case 2:
			payType='支付宝';
			break;
		case 3:
			payType='微信';
			break;
		default:
			payType='';
			break;
	}
	return payType;
}
//费用状态
function FeeStatusFormatter(value,row,index){
	var FeeStatus;
	switch(value){
		case 0:
			FeeStatus='待审核';
			break;
		case 1:
			FeeStatus='审核完成';
			break;
		case 2:
			FeeStatus='已完成';
			break;
		case 3:
			FeeStatus='取消';
			break;
		default:
			FeeStatus='';
			break;
	}
	return FeeStatus;
}
//状态
function statusFormatter(value,row,index){
	var status;
	switch(value){
		case 1:
			status='正常';
			break;
		case 2:
			status='作废';
			break;
		default:
			status='';
			break;
	}
	return status;
}
//查询
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
        costNum:$('#costNum').val(),
        memberID:$('#memberID').val(),
        memberName:$('#memberName').val(),
        costType:$('#costType').val(),
        payType:$('#payType').val(),
        costStatus:$('#costStatus').val(),
    };
};
//重置
function doreset(){
	$('#costNum').val('');
	$('#memberID').val('');
	$('#memberName').val('');
	$('#costType').val('');
	$('#payType').val('');
	$('#costStatus').val('');		
}
