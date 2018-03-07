<%@page import="com.korail.utillpage.StationSearch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page
	session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 합쳐지고 최소화된 최신 CSS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/js/jquery.xdomainajax.js"></script>
<script type="text/javascript">
	// SERIOUSLY!

	/* $('#container').load('http://google.com');
	 $.ajax({
	 url : "http://openapi.tago.go.kr/openapi/service/TrainInfoService/getStrtpntAlocFndTrainInfo?ServiceKey=1kFS1xMjgzoJx1YDeqgQP%2BBl96d5sKmGNPBw7hqUqCiAJveWE%2BY1zFwtaNpqnWzDCoCF2fHg2hW9bHqG6ByPgw%3D%3D&depPlandTime=20161001&depPlaceId=NAT010000&arrPlaceId=NAT011668",
	 dataType : "xml", 
	 type : "get",
	 jsonp : "callback", 
	 success : function(res){

	 alert(res);
	 },
	 error:function(xhr,status){
	 alert(status)
	 }
	 }); 
	 */

	/* 	$.ajax({
	 url : "trainsearch",
	 success : function(res) {
	 alert("d" + res);
	 }
	 }); */
</script>


<script>
	$(document)
			.ready(
					function() {
						var arrSearchCode = null;
						var depSearchCode = null;
						$(".depSearch").on(
								"click",
								function() {
									var btn = $(this);
									var name = $(".depStationName").val();

									//alert(name);
									$.ajax({
										url : "search2",
										type : "GET",
										data : {
											"StationName" : name
										},

										success : function(res) {

											depSearchCode = res;
											alert("depSearchCode"
													+ depSearchCode + "dd");//alert(res);
											//alert('현재 요청상태 : '+res);
											//btn.parent().first().text('현재 요청상태 : ');
										},
										error : function(error) {
											alert(error);
										}
									});
								});
						$(".arrSearch").on(
								"click",
								function() {
									var btn = $(this);
									var name2 = $(".arrStationName").val();
									alert(name2);
									//alert(name);
									$.ajax({
										url : "search2",
										type : "GET",
										data : {
											"StationName" : name2
										},
										success : function(res) {

											arrSearchCode = res;
											alert("arrSearchCode"
													+ arrSearchCode + "dd");
										},
										error : function(error) {
											alert(error);
										}
									});
								});
						$(".SearchSche")
								.on(
										"click",
										function() {

											$
													.ajax({
														url : "trainsearch",
														data : {
															"arrSearchCode" : arrSearchCode,
															"depSearchCode" : depSearchCode
														},
														success : function(data) {

															var result = '<table border ="1" ><tr><th>adultcharge</th><th>arrplacename</th><th>arrplandtime</th><th>depplacename</th>'
																	+ '<th>depplandtime</th><th>depplandtime</th></tr>'
															$
																	.each(
																			data,
																			function(
																					index,
																					entry) {

																				result += '<tr><td>'
																						+ entry.adultcharge
																						+ '</td><td>'
																						+ entry.arrplacename
																						+ '</td><td>'
																						+ entry.arrplandtime
																						+ '</td><td>'
																						+ entry.depplacename
																						+ '</td><td>'
																						+ entry.depplandtime
																						+ '</td><td>'
																						+ entry.traingradename
																						+ '</td></tr>';

																			});// end each
															result += '</table>'
															$('#searchResult')
																	.append(
																			result);
															return false;

														}
													});
										});
					});
</script>

<script>
	function getInputDayLabel() {
		var week = new Array('일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일');
		var today = new Date('2014-12-25').getDay();
		var todayLabel = week[today];
		return todayLabel;
	}
</script>
<!-- <script type="text/javascript">
function callAjax() {
    $.ajax({
       url : "http://openapi.tago.go.kr/openapi/service/TrainInfoService/getStrtpntAlocFndTrainInfo",
       data : {
       	ServiceKey : 'hYXnBIW0ZZCNzf5DY%2F7G%2Bhjj0E5BRQx9nyhJ9TAnCQ02KtoB9AEJu7F9RU6zOGQGShNqkXMm4rIOn1KvLUAKyQ%3D%3D',
       	depPlaceId : "NAT010000",                  
       	arrPlaceId : "NAT011668",                 
       	depPlandTime :"20161001", 
},
       success : function(result) {
 
       alert(result);
       }
    });
 }

</script> -->
</head>
<body>



	<form method="post">

		<div class="form-group">
			<label for="exampleInputEmail1">출발역</label> <input type="text"
				class="depStationName" />
			<button type="button" class="depSearch btn-default">검색</button>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">도착역</label> <input type="text"
				class="arrStationName" />
			<button type="button" class="arrSearch btn-default">검색</button>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">출발일</label> <input type="date"
				name="depdate" />
		</div>

		<button type="button" class="SearchSche btn-default">검색</button>
	</form>

	${arrStationName. stationId} ${depStationName. stationId}



	<div id="searchResult"></div>


</body>
</html>