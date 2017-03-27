if(!sessionStorage.getItem("operateID")){
	window.location.href = "operationFailure.html"
}
//统计信息显示			
		$(function(){		
			//获得某月的天数
			function getMonthDays(myMonth){
				var monthStartDate = new Date(nowYear, myMonth, 1);
				var monthEndDate = new Date(nowYear, myMonth + 1, 1);
				var days = (monthEndDate - monthStartDate)/(1000 * 60 * 60 * 24);
				return days;
			} 
			//整理日期格式
			function formatDate(date) {
				var myyear = date.getFullYear();
				var mymonth = date.getMonth()+1;
				var myday = date.getDate();
				
				if(mymonth < 10){
				mymonth = "0" + mymonth;
				}
				if(mymonth == 0){
				mymonth = 12;
				}
				if(myday < 10){
				myday = "0" + myday;
				}
				return (myyear+"-"+mymonth + "-" + myday);
			} 
		//昨天的时间
 			var yesterday = new Date();
 				yesterday.setTime(yesterday.getTime()-24*60*60*1000);
 			var yesterdayStr = formatDate(yesterday) 			
 		//今天的时间
 			var today = new Date();
 				today.setTime(today.getTime());
 			var todayStr = formatDate(today) 			
 		//前天的时间
			var dayBefore = new Date();
				dayBefore.setTime(dayBefore.getTime()-24*60*60*1000*2);
			var dayBeforeStr = formatDate(dayBefore)	
			
			var time = new Date();
			var nowYear = time.getFullYear();
			var nowMonth = time.getMonth();
			var nowDay = time.getDate();
			var nowDayOfWeek = time.getDay();	
			
			//获得本周的开始日期
			function getThisWeekStartDate() {
				var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek);
				return formatDate(weekStartDate);
			}
			//获得本周的结束日期
			function getThisWeekEndDate() {
				var weekEndDate = new Date(nowYear, nowMonth, nowDay + (6 - nowDayOfWeek));
				return formatDate(weekEndDate);
			} 			
			
			//获得上周的开始日期
			function getLastWeekStartDate(){
				var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek-7);
				return formatDate(weekStartDate);
			}			
			//获得上周的结束日期
			function getLastWeekEndDate(){
				var weekStartDate = new Date(nowYear, nowMonth, nowDay- (1+ nowDayOfWeek));
				return formatDate(weekStartDate);
			}
					
		//获得本月的开始日期
			function getMonthStartDate(){
				var monthStartDate = new Date(nowYear, nowMonth, 1);
				return formatDate(monthStartDate);
			}
			
		//获得本月的结束日期
			function getMonthEndDate(){
				var monthEndDate = new Date(nowYear, nowMonth, nowDay);
				return formatDate(monthEndDate);
			} 
			
			
		//获得上月开始时间
			function getLastMonthStartDate(){
				var lastMonthStartDate = new Date(nowYear, nowMonth-1, 1);
				return formatDate(lastMonthStartDate);
			}
			
		//获得上月结束时间
			function getLastMonthEndDate(){
				var lastMonthEndDate = new Date(nowYear, nowMonth-1, getMonthDays(nowMonth-1));
				return formatDate(lastMonthEndDate);
			}	
						
		//获取后台信息							
				var dateTime=new Date();		         
		         var yy=dateTime.getFullYear();//年份
		         var MM=dateTime.getMonth()+1;  //月份-因为1月这个方法返回为0，所以加1
		         var dd=dateTime.getDate();//日数		         
		         document.getElementById("startTime").value=yy+"-"+MM+"-"+dd;
		         document.getElementById("endTime").value=yy+"-"+MM+"-"+dd;
				var cookieval=readCookie("operateID");
				var cookievals=readCookie("companyID");
				var data={
						'operatorID':cookieval,
						'companyID':cookievals,
						'beginDate':document.getElementById("startTime").value,
						'endDate':document.getElementById("endTime").value
				};
				function send(datas){
					$.ajax({
					type:'post',
					url:'../../wei_bus/run/queryRuns.do',
					dataType:'JSON',
					data:datas,
					success:function(data){
						var result=data.data;
						if(data.status==0){
							//会员信息
							$('#UserAll').text(result.UserAll);
							$('#UserReged').text(result.UserReged);
							$('#UserReging').text(result.UserReging);
							$('#UserAdd').text(result.UserAdd);
							$('#UserAddReged').text(result.UserAddReged);
							$('#UserAddReging').text(result.UserAddReging);
							//订单信息
							$('#LeaseReserve').text(result.LeaseReserve);
							$('#LeaseGet').text(result.LeaseGet);
							$('#LeaseCancel').text(result.LeaseCancel);
							$('#LeaseFee').text(result.LeaseFee);
							$('#LeaseCoupon').text(result.LeaseCoupon);
							$('#LeasePay').text(result.LeasePay);
							
							$('#LeaseAddReserve').text(result.LeaseAddReserve);
							$('#LeaseAddGet').text(result.LeaseAddGet);
							$('#LeaseAddCancel').text(result.LeaseAddCancel);
							$('#LeaseAddFee').text(result.LeaseAddFee);
							$('#LeaseAddCoupon').text(result.LeaseAddCoupon);
							$('#LeaseAddPay').text(result.LeaseAddPay);
							//车辆信息
							$('#CarAll').text(result.CarAll);
							$('#CarActive').text(result.CarActive);
							$('#CarUnActive').text(result.CarUnActive);
							$('#CarOnline').text(result.CarOnline);
							$('#CarOffline').text(result.CarOffline);
							$('#CarCharging').text(result.CarCharging);
							//异常信息
							$('#IllegalCheck').text(result.IllegalCheck);
							$('#IllegalDealed').text(result.IllegalDealed);
							$('#IllegalDealing').text(result.IllegalDealing);
							$('#FaultAll').text(result.FaultAll);
							$('#FaultDealed').text(result.FaultDealed);
							$('#FaultDealing').text(result.FaultDealing);							
							$('#AccidentAll').text(result.AccidentAll);
							$('#AccidentDealed').text(result.AccidentDealed);
							$('#AccidentDealing').text(result.AccidentDealing);
							
							$('#IllegalAdd').text(result.IllegalAdd);
							$('#FaultAdd').text(result.FaultAdd);
							$('#AccidentAdd').text(result.AccidentAdd);
							//优惠券信息
							$('#CouponCount').text(result.CouponCount);
							$('#CouponFee').text(result.CouponFee);
							
							$('#CouponAddCount').text(result.CouponAddCount);
							$('#CouponAddFee').text(result.CouponAddFee);
							//财务信息
							$('#AccountAllBalance').text(result.AccountAllBalance);
							$('#AccountAllBail').text(result.AccountAllBail);
							
						};
					},
					error:function(){
						//alert('服务异常！');
					}
				});
			}
				send(data);
			//点击日期切换按钮
			$("#btns>.btn").click(function(){
				$(this).siblings().removeClass("btn-success");
				$(this).siblings().addClass("btn-warning");				
				$(this).removeClass("btn-warning");
				$(this).addClass("btn-success");	
				var btnId = $(this).attr("id");
				switch (btnId){
					case "today":{
					data={
						'operatorID':cookieval,
						'companyID':cookievals,
						'beginDate':todayStr,
						'endDate':todayStr,
					};
					$("#startTime").val(todayStr);
					$("#endTime").val(todayStr);
					}
						break;
					case "yesterday":{
					data={
						'operatorID':cookieval,
						'companyID':cookievals,
						'beginDate':yesterdayStr,
						'endDate':yesterdayStr,
					};
					$("#startTime").val(yesterdayStr);
					$("#endTime").val(yesterdayStr);
					}
						break;
					case "dayBefore":{
					data={
						'operatorID':cookieval,
						'companyID':cookievals,
						'beginDate':dayBeforeStr,
						'endDate':dayBeforeStr,
					};
					$("#startTime").val(dayBeforeStr);
					$("#endTime").val(dayBeforeStr);
					}
						break;
					case "thisWeek":{
					data={
						'operatorID':cookieval,
						'companyID':cookievals,
						'beginDate':getThisWeekStartDate(),
						'endDate':getThisWeekEndDate(),
					};
					$("#startTime").val(getThisWeekStartDate());
					$("#endTime").val(getThisWeekEndDate());
					}
					break;
					case "lastWeek":{
					data={
						'operatorID':cookieval,
						'companyID':cookievals,
						'beginDate':getLastWeekStartDate(),
						'endDate':getLastWeekEndDate(),
					};
					$("#startTime").val(getLastWeekStartDate());
					$("#endTime").val(getLastWeekEndDate());
					}
					break;
					case "thisMonth":{
					data={
						'operatorID':cookieval,
						'companyID':cookievals,
						'beginDate':getMonthStartDate(),
						'endDate':getMonthEndDate(),
					};
					$("#startTime").val(getMonthStartDate());
					$("#endTime").val(getMonthEndDate());
					}
					break;
					case "lastMonth":{
					data={
						'operatorID':cookieval,
						'companyID':cookievals,
						'beginDate':getLastMonthStartDate(),
						'endDate':getLastMonthEndDate(),
					};
					$("#startTime").val(getLastMonthStartDate());
					$("#endTime").val(getLastMonthEndDate());
					}
					break;
					default:
						break;
				}				
				send(data);
			});
		})
			var now =new Date();
			$('#startTime').datetimepicker({
				language:'zh-CN',
				format:'yyyy-mm-dd',
				autoclose:true,
				minView:'2',
				endDate:now
			});
			$('#endTime').datetimepicker({
				language:'zh-CN',
				format:'yyyy-mm-dd',
				autoclose:true,
				minView:'2',
				endDate:now
			});		
			$(function(){
				$("#startTime").on("changeDate", function (e) {
					var start = new Date(Date.parse($("#startTime").val()));
		        	$('#endTime').datetimepicker('setStartDate', begin);
		    	});
		    	$("#endTime").on("changeDate", function (e) {
					var end = new Date(Date.parse($("#endTime").val()));
		        	$('#startTime').datetimepicker('setEndDate', end);
		    	});
			})
			function doreset(){
				$("#startTime").datetimepicker('setEndDate', now);
				$("#endTime").datetimepicker('setStartDate', null);			
			}
		