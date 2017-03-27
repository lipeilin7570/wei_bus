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
        url:'',
        cache:false,
        height:"auto",
        striped:true,
        pagination:true,
        pageSize:5,
        pageNumber:1,
        //search : true,
        sidePagination:'client',
        contentType:"application/x-www-form-urlencoded",
        queryParams:queryParams,
        queryParamsType:'undefined', // undefined
        sortable:true,
        sortName:"extractNo",
        sortOrder:"desc",
        //showColumns : true,
        responseHandler:checkData,
        columns:[
            {
                field:'check',
                checkbox:true            
            }, {
                field:'extractNo',
                title:'扣款账户',
                align:'center',
                valign:'middle',
                sortable:true                       
            }, {
                field:'userName',
                title:'会员名称',
                align:'center',
                valign:'middle',
                sortable:true
            }, {
                field:'feeMoney',
                title:'扣款金额/元',
                align:'center',
                valign:'middle' 
            }, {
                field:'telPhone',
                title:'手机号',
                align:'center',
                valign:'middle',
                sortable:true                       
            }, {
                field:'createTime',
                title:'扣款时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                valign:'middle',
                //formatter:dateFormatter,
                sortable:true                                                    
            }, {
                field:'status',
                title:'扣款状态',
                align:'center',
                valign:'middle',
                formatter:statusFormatter           
            }, {
                field:'operate',
                title:'操作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                valign:'middle',
                formatter:operateFormatter,
                events:operateEvents
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
function operateFormatter(value, row, index){
    return [
        '<a class="info" href="javascript:void(0)" title="info">查看详情</a>',
    ].join('');
}
window.operateEvents={
	'click .info': function (e, value, row, index){
		$('#btn').click();
	}
}
//时间校验
/*function dateFormatter(value, row, index) {
	var myDate=new Date();
	myDate.setTime(row.enterTime);
    return myDate.format("yyyy-MM-dd");    
}*/

//扣款状态
function statusFormatter(value,row,index){
	var status;
	switch(value){
		case 0:
			status='未入账待审核';
			break;
		case 1:
			status='已入账';
			break;
		case 2:
			status='驳回扣款';
			break;
		default:
			status='';
			break;
	}
	return status;
}

//得到查询参数
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
        ExtractID:$('#ExtractID').val(),
        RentalUserNo:$('#RentalUserNo').val(),
        RentalUserName:$('#RentalUserName').val(),
        TelPhone:$('#TelPhone').val(),
        createTime:$('#createTime').val(),
        status:$('#status').val(),
    };
};
//重置
function doreset(){
	$('#ExtractID').val('');
	$('#RentalUserNo').val('');
	$('#RentalUserName').val('');
	$('#TelPhone').val('');
	$('#createTime').val('');		
}