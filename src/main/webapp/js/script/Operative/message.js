$(document).ready(function(){
    search();
})
//从表格查询
function ss(){
    $('#tab').bootstrapTable('refresh');
}
function checkData(res){
    return res;
}
//请求后台和返回的参数数据
function search() {
    $('#tab').bootstrapTable({
        method:'post',
        url:'',
        cache:false,
        height:"500",
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
        sortName:"",
        sortOrder:"",
        //showColumns : true,
        responseHandler:checkData,
        columns:[
            {
                field:'check',
                width:'30px',
                checkbox:true
            }, {
                field:'userNum',
                title:'用户编号',
                align:'center',
                valign:'middle',
                width:'50px',
                sortable:true
            }, {
                field:'msgTitle',
                title:'消息标题',
                align:'center',
                valign:'middle',
                width:'50px',
                sortable:true
            }, {
                field:'msgType',
                title:'消息类型',
                align:'center',
                valign:'middle',
                width:'50px',
                formatter:msgTypeFormatter,
                sortable:true
            }, {
                field:'createTime',
                title:'创建时间',
                align:'center',
                valign:'middle',
                width:'50px',
                formatter:dateFormatter,
                sortable:true
            }, {
                field:'msgObj',
                title:'消息对象',
                align:'center',
                valign:'middle',
                formatter:msgObjFormatter,
                width:'50px'           
            }, {
                field:'msgStatus',
                title:'状态',
                align:'center',
                valign:'middle',
                formatter:msgStatusFormatter,
                width:'50px' 
            }, {
                field:'msgContent',
                title:'消息内容',
                align:'center',
                valign:'middle',
                width:'50px'  
            }, {
                field:'linkType',
                title:'跳转类型',
                align:'center',
                valign:'middle',
                formatter:linkTypeFormatter,
                width:'50px'  
            }, {
                field:'createManID',
                title:'创建人ID',
                align:'center',
                valign:'middle',
                width:'50px'
            }, {
                field:'createMan',
                title:'创建人',
                align:'center',
                valign:'middle',
                width:'50px'
            }, {
                field:'companyID',
                title:'公司ID',
                align:'center',
                valign:'middle',
                width:'50px'
            }, {
                field: 'Remark',
                title: '备注',
                align: 'center',
                valign: 'middle',
                width: '50px'
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
//查询请求参数
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
        userNum: $('#userNum').val(),
        msgTitle: $('#msgTitle').val(),
        msgStatus: $('#msgStatus').val(),
        msgType: $('#msgType').val(),
        createTime: $('#createTime').val(),
        msgObj: $('#msgObj').val(),
        linkType:$('#linkType').val()
    };
}
//时间校验
function dateFormatter(value, row, index){
    var myDate=new  Date();
    myDate.setTime(row.createTime);
    return myDate.formatter('yy-MM-dd')
}
//消息状态
function msgStatusFormatter(value,row,index){
    var msgStatus;
    switch(value)
    {
        case 1:
        	msgStatus='正常';
            break;
        case 2:
        	msgStatus='下架';
            break;
        default :
        	msgStatus='';
            break
    }
    return msgStatus;
}
//消息对象
function msgObjFormatter(value,row,index){
    var msgObj;
    switch(value)
    {
        case 1:
            msgObj='全部';
            break;
        case 2:
            msgObj='指定用户';
            break;
        default :
            msgObj='';
            break
    }
    return msgObj;
}
//消息类型
function msgTypeFormatter(value,row,index){
    var msgType;
    switch(value)
    {
        case 1:
            msgType='站内';
            break;
        case 2:
            msgType='站外';
            break;
        default :
            msgType='';
            break
    }
    return msgType;
}
//跳转类型
function linkTypeFormatter(value,row,index){
    var linkType;
    switch(value)
    {
        case 1:
        	linkType='url';
            break;
        case 2:
        	linkType='app';
            break;
        default :
        	linkType='';
            break
    }
    return linkType;
}
var now =new Date();
$('#createTime').datetimepicker({
    language: 'zh',
    format : 'yyyy-mm-dd',
    autoclose : true,
    minView : '2',
    endDate:now
});
//重置
function doreset(){
    $("#createTime").val('');
    $("#userNum").val('');
    $("#msgTitle").val('');
    $("#msgType").val('');
    $("#msgObj").val('');
    $("#msgStatus").val('');
    $("#linkType").val('');
}