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
//加载所有站点信息
function search() {
	var cookieval=readCookie("companyID");
	var data={
			'companyID':cookieval
	};
    $('#tab').bootstrapTable({
        method:'post',
        url:'../../site/loadSite.do',
        processData :true,
        dataType:"json",
        cache:false,
        height:"auto",
        striped:true,
        pagination:true,
        pageSize:5,
        pageNumber:1,
        sidePagination:'client',
        contentType:"application/x-www-form-urlencoded",
        queryParams:data,
        queryParamsType:'undefined', // undefined
        sortable:true,
        sortName:"createTime",
        sortOrder:"desc",
        responseHandler:checkData,
        columns:[
            {
                field:'check',
                checkbox:true
            }, {
                field:'siteName',
                title:'站点名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                valign:'middle',
                sortable:true
            }, {
                field:'siteNo',
                title:'站点编号',
                align:'center',
                valign:'middle',
                sortable:true           
            }, {
                field:'siteMan',
                title:'站点人员',
                align:'center',
                valign:'middle'           
            }, {
                field:'serviceTime',
                title:'运营时间 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                valign:'middle',                          
            }, {
                field:'createTime',
                title:'创建时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                valign:'middle',
                sortable:true 
            }, {
                field:'status',
                title:'站点状态',
                align:'center',
                valign:'middle',
                formatter:statusFormatter
            }, {
                field:'companyShortName',
                title:'所属公司',
                align:'center',
                valign:'middle'         
            }, {
                field:'pileStatus',
                title:'充电桩状态',
                align:'center',
                valign:'middle',
                formatter:pileStatusFormatter 
            }, {
                field:'cars',
                title:'车辆总数',
                align:'center',
                valign:'middle'
            }, {
                field:'usableCar',
                title:'可用车辆',
                align:'center',
                valign:'middle' 
            }, {
                field:'parks',
                title:'车位总数',
                align:'center',
                valign:'middle'
            }, {
                field:'usablePark',
                title:'可用车位',
                align:'center',
                valign:'middle'                                            
            }, {
                field:'usablePile',
                title:'可用充电桩',
                align:'center',
                valign:'middle'
            }, {
                field:'siteRadius',
                title:'站点范围（米）',
                align:'center',
                valign:'middle'
            }, {
                field:'operate',
                title:'操作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                valign:'middle',
                formatter:operateFormatter,
                events:operateEvents
            }
        ],
        onLoadSuccess:function(data){
            //alert("success");       	
        },
        onLoadError:function(){
            //location.reload();
        }
    });
};
function operateFormatter(value, row, index){
    return [
        '<a class="edit" href="javascript:void(0)" title="Like">站点详情</a>|',      
        '<a class="beacon" href="javascript:void(0)" title="Like">信标录入</a>'
    ].join('');
}
window.operateEvents={//站点详情
    'click .edit': function (e, value, row, index){
        $('#editLoad').click();     	 
    	$('#edit_table').attr('data-id',row.siteID);
    	$('#site_Name').val(row.siteName);
    	$('#site_Code').val(row.siteNo);
    	$('#site_Address').val(row.siteAddress);
    	$('#Longitude').val(row.lng);
    	$('#Latitude').val(row.lat);
    	$('#SiteMan').val(row.siteMan);
    	$('#start_Time').val(row.serviceTime);
    	$('#pile_Status').val(row.pileStatus);
    	$('#beaconcount').val(row.beaconCount);
    	$('#Status').val(row.status); 
    	$('#site_Radius').val(row.siteRadius)      
    },
    'click .beacon': function (e, value, row, index){    	
    	$('#beacon_table').attr('data-id',row.siteID);   	    	    	
        $('#beaconLoad').click(); 
    } 
};
//站点详情修改
$(function(){
	var cookieval=readCookie("operateID");
	$('#editbut').click(function(){  
		//坐标转换
		var x_PI = 3.14159265358979324 * 3000.0 / 180.0;
		var PI = 3.1415926535897932384626;
		var a = 6378245.0;
		var ee = 0.00669342162296594323;
		var lng=$('#Longitude').val()*1;
		var lat=$('#Latitude').val()*1;  
		var gcj02towgs84 = coordtransform.gcj02towgs84(lng, lat);
		console.log(gcj02towgs84)
        var data={
        		'operatorID':cookieval,
        		'siteID':$('#edit_table').attr('data-id'),
    			'siteName':$('#site_Name').val(),
    			'siteCode':$('#site_Code').val(),
    			'siteAddress':$('#site_Address').val(),
    			'longitude':gcj02towgs84[0],
    			'latitude':gcj02towgs84[1],
    			'siteRadius':$('#site_Radius').val(),
    			'siteMan':$('#SiteMan').val(),
    			'serviceTime':$('#start_Time').val(),        			
    			'pileStatus':$('#pile_Status').val(),
    			'beaconCount':$('#beaconcount').val(),
    			'status':$('#Status').val(),
    			'remark':$('#Remark').val(),       		
    	};
		console.log(data)
    	$.ajax({
            type: "POST",
            dataType: "json",
            url: "../../site/changeSiteInfo.do",
            traditional:true,
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
//信标录入
$(function(){
	$('#fileSubmit').click(function(){  
		var cookieval=readCookie("operateID");
    	var cookievals=readCookie("companyID");
        var data={
        		'operatorID':cookieval,
        		'siteID':$('#beacon_table').attr('data-id'),
        		'companyID':cookievals,
    			'beaconNo':$('#beaconno').val(),
    			'UUID':$('#uuid').val(),
    			'Major':$('#major').val(),
    			'Minor':$('#minor').val(),
    			'Mac':$('#mac').val(), 
    			'position':$('#position').val(),
    			'fixTime':$('#fixtime').val(),
    			'remark':$('#remark').val()
    	};
    	$.ajax({
            type: "POST",
            dataType: "json",
            url: "../../beacon/addBeancon.do",
            traditional:true,
            data:data,
            success: function (data) {
                if(data.status==0){
                    alert("录入成功！");
                    search();
                    ss();
                }else{
                   alert("录入失败！");
                }
            },
            error: function(){
            	alert("服务异常！");
            }
        });       
    })        	
})
//批量导入
function import_excel(){
	var cookieval=readCookie("operateID");
	var cookievals=readCookie("companyID");
	var formData=new FormData();
	    formData.append('uploadFile', $('#excel_file')[0].files[0]);
	    formData.append('companyID',cookievals);
		formData.append('operatorID',cookieval);	
	$.ajax({		
		   type:"post",
		   dataType:"json",
		   url:"../../site/importSite.do",    	    
		   data:formData,
		   cache:false,
	       processData:false,  
	       contentType:false,
		   success:function (data){			          					 
			   if(data.status==0){ 
				   search();
				   ss();
				   alert("成功导入"+data.data+"条");
				   alert("数据导入失败为第"+data.msg+"条");				   
			   };
		    },
		    error: function (data){	   	    	
		    	alert("服务异常！");	
		    }       			
	})			     
}
//得到查询的参数
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
        sitename:$('#sitename').val(),
        sitecode:$('#sitecode').val(),
        status:$('#status').val(),
        zcode:$('#zcode').val(),
        starttime:$('#starttime').val(),
        endtime:$('#endtime').val()
    };
};
//站点状态
function statusFormatter(value,row,index){
	var status;
	switch(value){
		case 1:
			status='启用';
			break;
		case 2:
			status="停用";
			break;
		default :
			status='';
			break;
	}
	return status;
}
//充电桩状态
function pileStatusFormatter(value,row,index){
	var pileStatus;
	switch(value){
		case 1:
			pileStatus='有';
			break;
		case 2:
			pileStatus="无";
			break;
		default :
			pileStatus='';
			break;
	}
	return pileStatus;
}
//新增
function add(){	
    $('#impload').click();	    	
}
function urlAdd(){
	//坐标转换
	var x_PI = 3.14159265358979324 * 3000.0 / 180.0;
	var PI = 3.1415926535897932384626;
	var a = 6378245.0;
	var ee = 0.00669342162296594323;
	var lng=$('#longitude').val();
	var lat=$('#latitude').val();  	    		
	var wgs84togcj02 = coordtransform.wgs84togcj02(lng, lat);
	
	var cookieval=readCookie("companyID");
	var cookievals=readCookie("operateID");	
	var formData=new FormData($('#uploadForm')[0]);

	  	formData.append('companyID',cookieval);
	  	formData.append('operatorID',cookievals);
	  	formData.append('siteName',$('#siteName').val());
	  	formData.append('siteCode',$('#siteCode').val());
	  	formData.append('zcode',$('#zcode').val());
	  	formData.append('siteAddress',$('#siteAddress').val());
	  	formData.append('longitude',wgs84togcj02[0]);
	  	formData.append('latitude',wgs84togcj02[1]);
	  	formData.append('siteRadius',$('#siteRadius').val());
	  	formData.append('siteMan',$('#siteMan').val());
	  	formData.append('startTime',$('#startTime').val());
	  	formData.append('endTime',$('#endTime').val());
	  	formData.append('pileStatus',$('#pileStatus').val());
	  	formData.append('miniParkingCount',$('#miniParkingCount').val());
	  	formData.append('parkingCount',$('#parkingCount').val());
	  	formData.append('status',$('#status').val());
	  	formData.append('remark',$('#remark').val());	  
	$.ajax({
        type: "POST",
        url: "../../site/addSite.do",                
        dataType:'json', //返回值类型 一般设置为json 
        data:formData,
        cache:false,
        processData:false,  
        contentType:false,
        success: function (data){        
            if(data.status==0){              	
            	alert("新增成功！");
            	
                search();
                ss();
            }else{                
                alert("新增失败！");
            }
        },
        error: function(data) {  
            alert("服务异常！");
        }
    });
}
