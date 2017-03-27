if(!sessionStorage.getItem("operateID")){
	window.location.href = "../../operationFailure.html"
}
$(document).ready(function(){
    search();
})
function ss(){
	search()
    $('#tab').bootstrapTable('refresh');
}
function checkData(res){
    return res;
}
function search() {
	var cookieval=readCookie("operateID");	
	var data = {
			'operatorID':cookieval,		
			'undeal':$("#illegalType").val(),
			'overDate':$("#illegalStatus").val()
	};
	console.log(data)
    $('#tab').bootstrapTable({
        method:'post',
        url:'../../order/queryIllegalLease.do',
        cache:false,
        height:"auto",
        striped:true,
        pagination:true,
        pageSize:5,
        pageNumber:1,
        search : true,
        sidePagination:'client',
        contentType:"application/x-www-form-urlencoded",
        queryParams:data,
        queryParamsType:'undefined', // undefined
        sortable:true,
        sortName:"illegalNum",
        sortOrder:"desc",
        //showColumns : true,
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
                title:'车牌号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                valign:'middle'
            },{
                field:'LeaseCarModelName',
                title:'车型',
                align:'center',
                valign:'middle'
            }, {
                field:'UserName',
                title:'用户名称',
                align:'center',
                valign:'middle'            
            }, {
                field:'UserPhone',
                title:'手机号码',
                align:'center',
                valign:'middle'
            },{
                field:'LeaseTime',
                title:'订单时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                valign:'middle',
                sortable:true 
            }, {
                field:'LeaseTakeTime',
                title:'提车时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                valign:'middle',                                  
            }, {
                field:'LeaseBackTime',
                title:'还车时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                valign:'middle'
            }, {
                field:'LeaseTakeLoc',
                title:'提车地点&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                align:'center',
                valign:'middle'
            }, {
                field:'LeaseBackLoc',
                title:'还车地点&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                align:'center',
                valign:'middle'            
            }, {
                field:'UnDealIllegal',
                title:'未处理违章数',
                align:'center',
                valign:'middle'
            }, {
                field:'UnDealIllegalPoints',
                title:'未处理罚分总数',
                align:'center',
                valign:'middle'
            }, {
                field:'UnDealIllegalFines',
                title:'未处理罚款总额',
                align:'center',
                valign:'middle'
            }, {
                field:'PayBail',
                title:'已缴纳违章保证金',
                align:'center',
                valign:'middle'
            },{
            	field:'operate',
                title:'操作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                valign:'middle',
                formatter:operateFormatter,
                events:operateEvents 
            }
        ],
        onLoadSuccess:function(){
            //alert("success");
        },
        onLoadError:function(){
//            location.reload();
        }
    });
};

function operateFormatter(value, row, index){
    return [
        '<a class="detail" href="javascript:void(0)" title="like">违章详情</a>&nbsp;',
    ].join('');
}
window.operateEvents={
		'click .detail':function(e, value, row, index){			
			$('#violationDetail').click();
			$("#violation-table").attr('data-id',row.LeaseID)
//	违章详情	
			console.log(row)
			var operateID=readCookie("operateID");
			var data={
				'operatorID':operateID,
				'leaseID':$("#violation-table").attr('data-id')
			};				
			$.ajax({		
		 		type:"post",
		 		dataType:"json",
		 		url: "../../order/queryLeaseIllegal.do",    	    
		 		data:data,
		 		success: function (data) {	
		 			if(data.status==0){	 
		 				var datas = data.data;
		 				var htmlStr = '<table class="table table-bordered illegalTable">'+		 				
		 				'<tr><td class="title">违章时间</td><td><input type="text" id="violationTime"></td>'+
		 				'<td class="title">当前状态</td><td><input type="text" id="nowStatus"/></td></tr>'+
						'<tr><td class="title">违章地址</td><td><textarea id="violationAddr"></textarea></td>'+
						'<td class="title">违章内容</td><td><textarea id="violationContent"></textarea></td></tr>'+
						'<tr><td class="title">罚款</td><td><input type="text" id="fine"></td>'+
						'<td class="title">扣分</td><td><input type="text" id="punishPoints"></td></tr>'+
						'<tr><td class="title">处理时间</td><td><input type="text" id="DealTime"></td>'+
						'<td class="title">最后审核时间</td><td><input type="text" id="lastCheckTime"></td></tr>'+
						'<tr><td class="title">处理凭据</td><td><img src="" id="detailDepends" style="width:200px;height:150px;"></td></tr>'+
						'<tr><td class="title">审核结果</td><td><select class="checkResult"><option value="1">违章已处理</option><option value="2">违章仍未处理完毕</option></select></td>'+
						'<td class="title">审核失败的原因</td><td><textarea class="failReason"></textarea></td></tr>'+
						'<tr><td></td><td></td><td></td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
						'<button class="btn btn-primary btn-sm impbut" onclick="checkSend(event)" data-dismiss="modal">提交审核结果</button></td><tr/></table>'
						$("#thumbnail").attr("src",datas.LeaseCarModelIcon);
						$("#leaseNo").val(datas.LeaseNo);
						$("#leaseCarNo").val(datas.LeaseCarNo);
						$("#leaseTime").val(datas.LeaseTime);
						$("#carType").val(datas.LeaseCarModelAlias +datas.LeaseCarModelName);
						$("#pickTime").val(datas.LeaseTakeTime);
						$("#backTime").val(datas.LeaseBackTime);
						$("#pickAddress").val(datas.LeaseTakeLoc);
						$("#backAddress").val(datas.LeaseBackLoc);
						$("#memberName").val(datas.UserName);
						$("#memberTel").val(datas.UserPhone);
						$("#alreadyPaid").val(datas.PayBail);
						$('#violation-table').attr('data-id',datas.leaseID);						
						$(".illegalTable").remove();
						
						var illegalID = [];
						
		 				for(var i=0;i<datas.Illegals.length;i++){		 								
		 					$("#violation-table").after(htmlStr);	
		 					$("#violationTime").val(datas.Illegals[i].IllegalTime);
							$("#violationContent").val(datas.Illegals[i].Description);
							$("#violationAddr").val(datas.Illegals[i].Address);
							$("#collectionUnit").val(datas.Illegals[i].CollectionUnit);
							$("#punishPoints").val(datas.Illegals[i].Points);
							$("#fine").val(datas.Illegals[i].Fine);	
													
							illegalID.push(datas.Illegals[i].IllegalID);							
							var status;
							switch (datas.Illegals[i].Status){
								case 1:{
									status = "已录入待处理"
								}				
									break;
								case 2:{
									status = "客户已确认"
								}				
									break;
								case 3:{
									status = "客户已处理待审核"
								}				
									break;
								case 4:{
									status = "已处理审核中"
								}			
									break;
								case 5:{
									status = "已确认处理完毕"
								}			
									break;
								case 6:{
									status = "取消"
								}				
									break;
								default:
									break;
							}
								$("#nowStatus").val(status)
								$("#DealTime").val(datas.Illegals[i].DealTime);
								$("#lastCheckTime").val(datas.Illegals[i].AuditTime);
								$("#detailDepends").attr("src",datas.Illegals[i].DealProof);									  
		 				}		 				
		 				illegalID.forEach(function(val,index){		 					
		 					$(".impbut")[index].setAttribute("data-illegalid",val);	
		 					$(".checkResult")[index].setAttribute("data-illegalid",val);
		 					$(".failReason")[index].setAttribute("data-illegalid",val);
		 				})
		 			}	
		 			$("#tableBox input").attr("disabled","disabled");
		 			$("#tableBox textarea").attr("disabled","disabled")
		 			$(".failReason").removeAttr("disabled")
		 		},
		 		error: function (data){
//		 			 alert("服务异常");	
		 		}
		 	})   		 	
		}
}
function checkSend(ev){			
		var dataIllegalid = $(ev.target).attr("data-illegalid")													
		var cookieval=readCookie("operateID");								
		var data = {
				'operatorID':cookieval,
				'auditStatus':$("select[data-illegalid="+dataIllegalid+"]").val(),
				'failReason':$("textarea[data-illegalid="+dataIllegalid+"]").val(),
				'illegalID':dataIllegalid
		};		 		
		$.ajax({
			type:"post",
			dataType:"json",
			url: "../../order/auditIllegal.do",    	    
			data:data,
			success: function (data) {	
				console.dir(data)
				if(data.status==0){ 
					alert('审核提交成功！') 
					search();
					ss();	 	 				
				}else if(data.status==101){
					alert("找不到车辆")
				}else if(data.status==102){
					alert("违章已录入不能重复录入")
				}   				    	     				    		 	    				    		
			},
			error: function (data){		 			
//				alert("服务异常");	
			}
		})		
	}
var sn;
var so;
function queryParams(params) {
    sn = params.sortName;
    so = params.sortOrder;
    return {
        pageSize: params.pageSize,
        pageNumber: params.pageNumber,
        sortName: params.sortName,
        sortOrder: params.sortOrder,
        illegalNum: $('#illegalNum').val(),
        carNum: $('#carNum').val(),
        userId: $('#userId').val(),
        carID: $('#carID').val(),
        illegalTime: $('#illegalTime').val(),
        illegalType: $('#illegalType').val(),
        illegalStatus: $('#illegalStatus').val(),
        completeTime: $('#completeTime').val()
    };
}
//function dateFormatter(value, row, index){
//    var myDate=new  Date();
//    myDate.setTime(row.createTime);
//    return myDate.formatter('yy-MM-dd')
//}
function illegalStatusFormatter(value,row,index){
    var illegalStatus;
    switch(value)
    {
        case 1:
            illegalStatus='未处理';
            break;
        case 2:
            illegalStatus='已处理';
            break;
        case 3:
            illegalStatus='已撤销';
            break;
        default :
            illegalStatus='';
            break;
    }
    return illegalStatus;
}
var now =new Date();
$('#illegalTime').datetimepicker({
    language: 'zh',
    format : 'yyyy-mm-dd',
    autoclose : true,
    minView : '2',
    endDate:now
});
$('#completeTime').datetimepicker({
    language: 'zh',
    format : 'yyyy-mm-dd',
    autoclose : true,
    minView : '2',
    endDate:now
});
$('#createTime').datetimepicker({
    language: 'zh',
    format : 'yyyy-mm-dd',
    autoclose : true,
    minView : '2',
    endDate:now
});
function doreset(){
    $("#beginTime").datetimepicker('setEndDate', now);
    $("#endTime").datetimepicker('setStartDate', null);
}
$(function(){
    $("#beginTime").on("changeDate", function (e) {
        var begin = new Date(Date.parse($("#beginTime").val()));
        $('#endTime').datetimepicker('setStartDate', begin);
    });
    $("#endTime").on("changeDate", function (e) {
        var end = new Date(Date.parse($("#endTime").val()));
        $('#beginTime').datetimepicker('setEndDate', end);
    });
})