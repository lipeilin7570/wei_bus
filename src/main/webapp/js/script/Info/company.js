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
        url:'../../company/loadCompany.do',
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
        sortName:"companyid",
        sortOrder:"desc",
        //showColumns : true,
        responseHandler:checkData,
        columns:[
            {
                field:'check',
                checkbox:true          
            }, {
                field:'companyName',
                title:'公司名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                valign:'middle',
                sortable:true
            }, {
                field:'shortName',
                title:'公司简称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                align:'center',
                valign:'middle'
            }, {
                field:'lng',
                title:'经度',                
                valign:'middle'
            }, {
                field:'lat',
                title:'纬度',
                valign:'middle'
            }, {
                field:'contacts',
                title:'负责人',
                align:'center',
                valign:'middle'
            }, {
                field:'companyPhone',
                title:'联系电话',
                valign:'middle' 
            }, {
                field:'createtime',
                title:'创建时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                valign:'middle' 
            }, {
                field:'companyCode',
                title:'公司编号',
                align:'center',
                valign:'middle'            
            }, {
                field:'regionStatus',
                title:'区域标识',
                align:'center',
                valign:'middle',
                formatter:regionStatusFormatter
            }, {
                field:'address',
                title:'公司地址 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                valign:'middle',
            }, {
                field:'status',
                title:'公司状态',
                align:'center',
                valign:'middle',
                formatter:statusFormatter
            }, {
                field:'remark',
                title:'备注',
                align:'center',
                valign:'middle',
                sortable:true            
            }, {
                field:'operate',
                title:'操作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                valign:'middle',
                formatter:operateFormatter,
                events:operateEvents
            }
        ],
        onLoadSuccess:function(){
            //alert("success");
        },
        onLoadError:function(){
            location.reload();
        }
    });
};
//状态
function statusFormatter(value, row, index){
	var status;
    switch(value)
    {
        case 1:
        	status='正常';
            break;
        case 2:
        	status='暂停';
            break;
        default :
        	status='';
            break;
    }
    return status;
}
//区域标识
function regionStatusFormatter(value, row, index){
	var regionStatus;
    switch(value)
    {
        case 1:
        	regionStatus='是';
            break;
        case 2:
        	regionStatus='否';
            break;
        default :
        	regionStatus='';
            break;
    }
    return regionStatus;
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
        companyName:$('#companyname').val(),
        companyCode:$('#conpanycode').val(),
        status:$('#status').val()
    };
};
function operateFormatter(value, row, index){
    return [
        '<a class="edit" href="javascript:void(0)" title="Like">修改信息</a>'
       // '<a class="setMenus" href="javascript:void(0)" title="Like" >授权</a>'
    ].join('');
}
window.operateEvents={		
    'click .edit': function (e, value, row, index){
    	$('#editLoad').click();    	 
    	$('#edit_table').attr("data-id",row.companyID);
    	$('#company_name').val(row.companyName);
    	$('#short_name').val(row.shortName);
    	$('#company_phone').val(row.companyPhone);
    	$('#company_code').val(row.conpanyCode);
    	$('#Lg').val(row.lng);
    	$('#Lt').val(row.lat);
    	$('#Contact').val(row.contacts);
    	$('#CreateTime').val(row.createtime);
    	$('#RegionStatus').val(row.regionStatus);
    	$('#Statu').val(row.status);
    	$('#ParentID').val(row.parentID);
    	$('#remark').val(row.remark);
    	$('#address').val(row.address);                      	
    } 
};
//信息修改
$(function(){
	var cookieval=readCookie("operateID");
	$('#editbut').click(function(){
		var data={
				'operatorID':cookieval,
        		'companyID':$('#edit_table').attr('data-id'),
    			'companyName':$('#company_name').val(),
    			'shortName':$('#short_name').val(),
    			'companyPhone':$('#company_phone').val(),
    			'companyCode':$('#company_code').val(),
    			'regionStatus':$('#RegionStatus').val(),
    			'remark':$('#remark').val()	,        			
    			'parentID':$('#ParentID').val(),
    			'lng':$('#Lg').val(),
    			'lat':$('#Lt').val(),
    			'contacts':$('#Contact').val(),
    			'createtime':$('#CreateTime').val(),
    			'status':$('#Statu').val(),	
    			'address':$('#address').val()	
		}
    	$.ajax({
            type: "POST",
            dataType: "json",
            url: "../../company/changeCompany.do",
            cache:true,
            data:data,                
            success: function (data) {
                if(data.status==0){
                    alert("修改成功！");
                    search();
                    ss();
                }else{
                   alert("修改失败！");
                }
            },
            error: function(){
            	alert("服务异常！");
            }
        });       
    })
})
//新增
function add(){
    $('#impload').click();
}
//新增提交
function urlAdd(){
	var cookieval=readCookie("operateID");
	var data={
			'operatorID':cookieval,
			'companyName':$('#companyname').val(),
			'shortName':$('#shortname').val(),
			'companyPhone':$('#companyphone').val(),
			'companyCode':$('#companycode').val(),
			'parentID':$('#parentid').val(),
			'lng':$('#Lng').val(),
			'lat':$('#Lat').val(),
			'contacts':$('#Contacts').val(),
			'status':$('#Status').val(),
			'regionStatus':$('#regionstatus').val(),
			'remark':$('#Remark').val()	
	};
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "../../company/addCompany.do",
        traditional:true,
        data:data,
        success: function (data) {
            if(data.status==0){
                $("#del_btn").click();
                $("#submit").show();
                $(".del_msg").text("新增成功！");
                search();
                ss();
            }else{
                $("#del_btn").click();
                $("#submit").show();
                $(".del_msg").text("新增失败！");
            }
        },
        error: function(data){
        	$("#del_btn").click();
            $("submit").show();
            $(".del_msg").text("服务异常！");
        }
    });
}