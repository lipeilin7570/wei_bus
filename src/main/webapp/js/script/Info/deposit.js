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
//加载所有区域信息
function search() {
    $('#tab').bootstrapTable({
        method:'post',
        url:'',
        cache:false,
        height:"auto",
        striped:true,
        pagination:true,
        pageSize:10,
        pageNumber:1,
        sidePagination:'client',
        contentType:"application/x-www-form-urlencoded",
        queryParams:queryParams,
        queryParamsType:'undefined', // undefined
        sortable:true,
        sortName:"regionid",
        sortOrder:"desc",
        responseHandler:checkData,
        columns:[
            {
                field:'check',
                checkbox:true
            }, {
                field:'',
                title:'车型',
                align:'center',
                valign:'middle',
                sortable:true
            }, {
                field:'',
                title:'订单类型',
                align:'center',
                valign:'middle',
                sortable:true
            }, {
                field:'',
                title:'租车保证金',
                align:'center',
                valign:'middle',
                sortable:true
            }, {
                field:'',
                title:'事故保证金',
                align:'center',
                valign:'middle',
                formatter:statusFormatter
            }, {
                field:'',
                title:'故障保证金',
                align:'center',
                valign:'middle',
                sortable:true
            }, {
                field:'',
                title:'公司ID',
                align:'center',
                valign:'middle'           
            }, {
            	 field: 'operation',
                 title: '操作',
                 align:'center',
                 valign:'middle',
                 formatter:function(value,row,index){
                     var s = '<a class = "save" href="javascript:void(0)">信息修改</a>';                    
                     return s+' ';
                 },
                 events:'operateEvents'
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
window.operateEvents = {
	    'click .save': function (e, value, row, index) {
	    	var arr=JSON.stringify(row);
       	 	var name=row.name;
       	 	var regionNo=row.regionno;
       	 	var zcode=row.zcode;
    	 	var remark=row.remark;
    	 		//alert(regionNo);
       	 	$('#Name').val(name);
       	 	$('#RegionNo').val(regionNo);
       	 	$('#Zcode').val(zcode);
       	 	$('#Remark').val(remark)
	        $('#editLoad').click();
	        $('#editbut').click(function(){	        	 
	 	        data={
	 	        	'regionID':row.regionid,
	 	        	'name':$('#Name').val(),
	 	        	'regionNo':$('#RegionNo').val(),
	 	        	'zcode':$('#Zcode').val(),
	 	        	'remark':$('#Remark').val(),
	 	        };
	 	        $.ajax({		
	 				   type:"post",
	 				   dataType:"json",
	 				   url: "../../area/changeRegion.do",    	    
	 				   data:data,
	 				   success: function (data) {	       					   
	 					   if(data.status==0){ 
	 						     alert('修改成功！') 
	 						     search();
	 						     ss();
	 				    	}   				    	     				    		 	    				    		
	 				    },
	 				    error: function (data){	   	    	
	 				    	//alert("1");	
	 				    }
	 			})		
	 	    	    
	        })
	    } 
	};

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
        name:$('#name').val(),
        regionNo:$('#regionNo').val(),
        regionid:$('#regionid').val(),
        zcode:$('#zcode').val(),       
    };
};
//区域状态
function statusFormatter(value,row,index){
	var status;
	switch(value){
		case 1:
			status='正常';
			break;
		case 2:
			status="暂停";
			break;
		default :
			status='';
			break;
	}
	return status;
}

//修改状态
function del(){
	var selects = $('#tab').bootstrapTable('getSelections');
	if(selects.length<=0){//alert('请选择!');
    	$("#removeload").click();
    	$("#removebut").show();
    	$(".removemsg").text("请选择!");
  		}else{
     		bootbox.confirm({
        		message: "确定修改选中的"+selects.length+"信息状态吗?",
        		buttons: {
          			confirm: {
             			label: "确认",
             			className: "btn-primary btn-sm"
          				},
          		cancel: {
             		label: "取消",
             		className: "btn-sm"
          			}
        		},
        	callback: function(result) {
            	if(result){
            		regionID = $.map(selects, function (row) {
                  		return row.regionid;
              		})
              		status=$.map(selects, function (row) {
              			if(row.status==1){
                  			row.status=2;
                  		}else{
                  			row.status=1;
                  		}
                  		return row.status;
              		})
              		$.ajax({
              	  		type: "POST",
              	  		dataType: "json",
              	  		url: "../../area/delRegion.do",
              	  		traditional:true,
              	  		data:{
              	  			regionID:regionID,
              	  			status:status
              	  		},
              	  		success: function (data) {
              	    	if(data.status==0){
              	    		alert('修改成功！');              	        	
              	        	search();
              	        	ss();
              	    	}else{
              	    		alert('修改失败！');             	        	
              	    	}
              	  	},
              	  	error: function(data) {
              	  		alert("error:服务异常！");              	    	
              	   	}
              	});
           	};
        }
      });
  	}
}    


//新增
function add(){	
    $('#impload').click();	    
}
function urlSubmit(){
	$("#regionForm").validate({
		rules:{
			name:"required",
			regionNo:"required",
			zcode:"required",
			remark:"required"
		},	
	});
	if(regionForm.name.value==''){
		return false;
	}else if(regionForm.regionNo.value==''){
		return false;
	}	
		var data={
				'name':$('#name').val(),
				'regionNo':$('#regionNo').val(),
				'zcode':$('#zcode').val(),
				'remark':$('#remark').val(),			
		};
		$.ajax({
	        type: "POST",
	        url: "../../area/addRegion.do",        
	        dataType: "json",
	        async:true,
	        data:data,
	        success: function (data){
	        	if((regionForm.name.value!="")){
                	if((regionForm.regionNo.value!="")){               		
                		return true;
                	}else{
                		
                		alert("区域编号不能为空!");
                		return false;
                	}
                    }else{
	        			alert("名称不能为空!");
	        			return false;
	        		}		
	            if(data.status==0){ 
	            	  alert("新增成功！")
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
