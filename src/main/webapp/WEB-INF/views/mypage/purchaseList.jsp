<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".refund").click(function() {
		alert(this.id+"번 티켓을 환불신청 하시겠습니까?");
		$.post("refund",
				{tOrder_Id:this.id});
	});
	
	var msg = "${msg}";
	if(msg=="success"){
		alert("환불신청이 완료되었습니다")
	}else{
		alert("환불신청이 불가능합니다.")
	}
});
</script>
<title></title>
</head>
<body>
	<h3>나의 티켓결제내역</h3>
	<table border="1" bgcolor="pink">
		<tr>
			<th>결제번호</th>
			<th>티켓명</th>
			<th>결제일</th>
			<th>결제금액</th>
			<th>결제수단</th>
			<th>주문상태</th>
		</tr>
		<c:forEach items="${dtoList }" var="dto">
		
		<tr>
			<td>${dto.tOrder_Id }</td>
			<td>${dto.ticket_Name }</td>
			<td>${dto.tOrder_Date }</td>
			<td>${dto.tOrder_Price }원</td>
			<td><c:choose>
			       <c:when test="${dto.tOrder_PayType ==0}">신용카드</c:when>
			       <c:otherwise>무통장입금</c:otherwise>
			    </c:choose></td>
			<td><c:choose>
				<c:when test="${dto.tOrder_State ==0}">결제완료</c:when>			
				<c:when test="${dto.tOrder_State ==1}">입금대기</c:when>
				<c:when test="${dto.tOrder_State ==2}">환불처리중</c:when>
				<c:otherwise>취소완료</c:otherwise>			
			    </c:choose></td>
			<td><c:if test="${dto.tOrder_State<2}"><button id="${dto.tOrder_Id }" class="refund">환불하기 (${dto.tOrder_Id })</button></c:if> </td>
		</tr>
		</c:forEach>
		
	</table>
	<div>환불완료:취소완료후 환불되금액지급까지완료된상태</div>
	<div>취소완료:주문은 취소했지만 환불금액이 아직 지급되지 않은상태</div>
</body>
</html>