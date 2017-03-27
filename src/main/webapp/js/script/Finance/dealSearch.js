if(!sessionStorage.getItem("operateID")){
	window.location.href = "../../operationFailure.html"
}
$(document).ready(function(){   
//    设置时间
    var now=new Date();
    var y = now.getFullYear();
    var m = now.getMonth()+1;
    var d = now.getDate();
	var nh = now.getHours();
	var nm = now.getMinutes();
	var ns = now.getSeconds();
	now.setTime(now.getTime()-nh*3600*1000-nm*60*1000-ns*1000-7*24*3600*1000);//
	var hh = now.getHours()
	var mm = now.getMinutes()
	var ss = now.getSeconds()
	var beginTimeStr = now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate()+" "+hh+"0:"+mm+"0:0"+ss;		
		if(nh<10){
			nh="0"+nh
		}
		if(nm<10){
			nm="0"+nm
		}
		if(ns<10){
			ns="0"+ns
		}
	var endTimeStr = y+"-"+m+"-"+d+" "+nh+":"+nm+":"+ns		
	$("#beginTime").val(beginTimeStr);
	$("#endTime").val(endTimeStr);
	 search();
})
function ss(){
    $('#tab').bootstrapTable('refresh');
}
function checkData(res){
    return res;
}
function search() {
//	var cookieval=readCookie("operateID");
//	var data = {
//		'operatorID':cookieval,
//		'beginTime':$("#beginTime").val(),
//		'endTime':$("#endTime").val(),
//		'dealType':$("#dealType").val(),
//		'tradeType':$("#tradeType").val(),
//		'tradeAccount':$("#tradeAccount").val()
//	}
//	console.log(data)
    $('#tab').bootstrapTable({
        method:'post',
        url:'../../account/queryDeals.do',
        cache:false,
        height:"auto",
        striped:true,
        pagination:true,
        pageSize:5,
        pageNumber:1,
        search : true,
        sidePagination:'client',
        contentType:"application/x-www-form-urlencoded",
        queryParams:queryParams,
        queryParamsType:'undefined', // undefined
        sortable:true,
        sortName:"DealNo",
        sortOrder:"desc",
        //showColumns : true,
        responseHandler:checkData,
        columns:[
            {
                field:'check',
                checkbox:true
            }, {
                field:'DealNo',
                title:'交易流水号',
                align:'center',
                valign:'middle',
                sortable:true 
            }, {
                field:'LeaseNo',
                title:'订单编号',
                align:'center',
                valign:'middle',
                sortable:true
            }, {
                field:'UserName',
                title:'会员名称',
                align:'center',
                valign:'middle'
            }, {
                field:'UserTel',
                title:'手机号',
                align:'center',
                valign:'middle'
            }, {
                field:'DealType',
                title:'交易类型',
                align:'center',
                valign:'middle', 
                formatter:DealTypeFormatter
            }, {
                field:'DealTime',
                title:'交易时间',
                align:'center',
                valign:'middle'
            }, {
                field:'DealMoney',
                title:'交易金额',
                align:'center',
                valign:'middle'
            },{
                field:'TradeAccount',
                title:'支付方式',
                align:'center',
                valign:'middle',
                formatter:payTypeFormatter           
            }, {
                field:'State',
                title:'状态说明',
                align:'center',
                valign:'middle'
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

//交易类型
function DealTypeFormatter(value,row,index){
	var DealType;
	switch(value){
		case 1:
			DealType='充值';
			break;
		case 2:
			DealType='提现';
			break;
		case 3:
			DealType='支付';
			break;
		case 4:
			DealType='提现失败退款';
			break;
		case 5:
			DealType='违约金扣款';
			break;
		default:
			DealType='';
			break;
	}
	return DealType;
}
//支付方式
function payTypeFormatter(value,row,index){
	var payType;
	switch(value){
		case 1:
			payType='支付宝';
			break;
		case 2:
			payType='微信';
			break;
		case 3:
			payType='余额';
			break;
		default:
			payType='';
			break;
	}
	return payType;
}
//查询
var sn;
var so;
function queryParams(params){
	var cookieval=readCookie("operateID");
	sn=params.sortName;
	so=params.sortOrder;
    return{
        pageSize:params.pageSize,
        pageNumber:params.pageNumber,
        sortName:params.sortName,
        sortOrder:params.sortOrder,
        operatorID:cookieval,
		beginTime:$("#beginTime").val(),
		endTime:$("#endTime").val(),
		dealType:$("#dealType").val(),
		tradeType:$("#tradeType").val(),
		tradeAccount:$("#tradeAccount").val()
    };
};