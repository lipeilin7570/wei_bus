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
        url:'../../account/loadExtract.do',
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
                title:'提现编号',
                align:'center',
                valign:'middle',
                sortable:true           
            }, {
                field:'userNo',
                title:'会员编号',
                align:'center',
                valign:'middle',
                sortable:true
            }, {
                field:'userName',
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
                sortable:true          
            }, {
                field:'accountNo',
                title:'提现账号',
                align:'center',
                valign:'middle'
            }, {
                field:'feeMoney',
                title:'提现金额/元',
                align:'center',
                valign:'middle'                                                     
            }, {
                field:'status',
                title:'提现状态',
                align:'center',
                valign:'middle',
                formatter:statusFormatter
            }, {
                field:'auditStatus',
                title:'审核状态',
                align:'center',
                valign:'middle',
                formatter:auditStatusFormatter
            }, {
                field:'accountType',
                title:'提现方式',
                align:'center',
                valign:'middle',
                formatter:accountTypeFormatter
            }, {
                field:'createTime',
                title:'提现申请时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                valign:'middle',
                //formatter:dateFormatter,
                sortable:true 
            }, {
                field:'auditTime',
                title:'提现审核时间',
                align:'center',
                valign:'middle',
                //formatter:dateFormatter,
                sortable:true
            }, {
                field:'auditMan',
                title:'审核人',
                align:'center',
                valign:'middle',
                //formatter:dateFormatter,
                sortable:true     
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
        '<a class="info" href="javascript:void(0)" title="info">审核详情</a>',
    ].join('');
}
window.operateEvents={
	'click .info': function (e, value, row, index){
		$('#btn_table').attr('data-id',row.extractID);
		$('#extractNo').text(row.extractNo);
		$('#userName').text(row.userName);
		$('#feeMoney').text(row.feeMoney);
		$('#btn').click();
	}
}
//审核提交
$(function(){
	$('#btn_but').click(function(){
		var cookieval=readCookie("operateID");
		var data={
				'operatorID':cookieval,
				'extractID':$('#btn_table').attr('data-id'),
				'auditStatus':$('#auditStatus').val(),
				'reason':$('#failReason').val()
		};
		$.ajax({
			type:'post',
			data:data,
			url:'../../account/auditExtract.do',
			dataType:'json',
			success:function(data){
				if(data.status==0){
					alert('审核通过！');
					search();
					ss();
				}else if(data.status==101){
					alert('找不到该提现申请!');
				}else if(data.status==102){
					alert('提现申请已审核!');
				}else{
					alert('系统错误！');
				}
			},
			error:function(){
				alert("服务错误！");
			}
		})
	})
})
//时间校验
/*function dateFormatter(value, row, index) {
	var myDate=new Date();
	myDate.setTime(row.enterTime);
    return myDate.format("yyyy-MM-dd");    
}*/

//提现状态
function statusFormatter(value,row,index){
	var status;
	switch(value){
		case 0:
			status='待审核';
			break;
		case 1:
			status='审核通过';
			break;
		case 2:
			status='审核失败已退回';
			break;
		case 3:
			status='已打款';
			break;			
		default:
			status='';
			break;
	}
	return status;
}
//提现方式
function accountTypeFormatter(value,row,index){
	var accountType;
	switch(value){
		case 1:
			accountType='支付宝';
			break;
		case 2:
			accountType='微信';
			break;		
		default:
			accountType='';
			break;
	}
	return accountType;
}
//审核状态
function auditStatusFormatter(value,row,index){
	var auditStatus;
	switch(value){
		case 1:
			auditStatus='成功';
			break;
		case 2:
			auditStatus='失败';
			break;		
		default:
			auditStatus='';
			break;
	}
	return auditStatus;
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
window.onload = function(){
	var obj_select = document.getElementById("auditStatus");
	var obj_div = document.getElementById("two");
		obj_select.onchange = function(){
			obj_div.style. visibility = this.value==2? "visible" : "hidden";
		}
}