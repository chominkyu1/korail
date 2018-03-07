<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var station = "${vo.ticket_Station }";
	var startdate = "${vo.ticket_StartDate}";
	if (station=="미정" && startdate=="미정") {
		$("#station").html("<input type=text value='발권역을 선택해 주세요' name=ticket_Station> ");
		$("#startdate").html("<input type=date value='사용시작일을 선택해 주세요' name=ticket_StartDate>");
		$("#edit").html("<input type=submit value='발권지설정'>");
	} else {
		$("#station").html(station);
		$("#startdate").html(startdate);
	}
	
	
	
});
</script>
<title>티켓상세페이지</title>
</head>
<body>
	<h3><font size="15">티켓상세페이지</font></h3>
	<select>
		<option>티켓선택하기</option>
		<option>내일로</option>
		<option>내일로2</option>
	</select><br>
<!-- 	<img alt="..." src="..."> -->
	
	<form action="myticket?ticket_Id=${vo.ticket_Id }" method="post">
TICKET_ID :${vo.ticket_Id }<br>
TICKET_NAME :${vo.ticket_Id }<br>
TICKET_STATION :<div id="station"></div><br>
TICKET_STARTDATE :<div id="startdate"></div><br>
TICKET_VALIDDAY :<h3>${vo.ticket_ValidDate}</h3><br>
    <div id="edit"></div>
	</form>
</body>
</html>