if(!sessionStorage.getItem("operateID")){
	window.location.href = "../../operationFailure.html"
}
$(document).ready(function(){
    search();
})
function ss(){
	search();
    $('#tab').bootstrapTable('refresh');
}
function checkData(res){
    return res;
}
function search() {
//	var cookieval=readCookie("operateID");
//	var data = {
//		'operatorID':cookieval,
//		'order':$("#timeList").val()
//	}
//	console.log(data);
    $('#tab').bootstrapTable({
        method:'post',
        url:'../../account/queryBalances.do',
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
        sortName:"UpdateTime",
        sortOrder:"desc",
        //showColumns : true,
        responseHandler:checkData,
        columns:[
            {
                field:'check',
                checkbox:true
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
                field:'UpdateTime',
                title:'账户更新时间',
                align:'center',
                valign:'middle', 
                sortable:true
            }, {
                field:'FeeMoney',
                title:'账户总余额',
                align:'center',
                valign:'middle'
            }, {
                field:'FreezeMoney',
                title:'保证金冻结金额',
                align:'center',
                valign:'middle'
            },{
                field:'AcctBalance',
                title:'可用余额',
                align:'center',
                valign:'middle',                           
            }, {
                field:'Pledge',
                title:'押金金额',
                align:'center',
                valign:'middle'
            }, {
                field:'CouponCount',
                title:'剩余优惠券张数',
                align:'center',
                valign:'middle'
            }, {
                field:'CouponMoney',
                title:'剩余优惠券金额',
                align:'center',
                valign:'middle'
            }
        ],
        onLoadSuccess:function(data){
          if(data.status==101){
        	  alert('失败，系统错误!');
          }
        },
        onLoadError:function(){
           // location.reload();
        }
    });
};

window.operateEvents={
	'click #accountSearch':function(e, value, row, index){
		
	}
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
		order:$("#timeList").val()
    };
};