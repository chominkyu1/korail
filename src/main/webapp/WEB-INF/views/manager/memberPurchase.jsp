<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$(".updateState").click(function() {
		alert(this.id+"환불완료 상태로 변경하시겠습니까?");
		$.post("refundUpdate",
				{tOrder_Id:this.id});
	});
	
	$("#search").click(function() {
		var type = $("select option:selected").val();
		var keyword = $("#keyword").val();
		
		alert("type"+type+"keyword"+keyword);
		$.ajax({
			url:"searchPurchase",
			data:{type:type,keyword:keyword },
			success:function(data){
				$("div").html(data);
			}
		});
	});
	
	$("#all").click(function () {
		$.ajax({
			url:"searchPurchase",
			data:{ type:"all"},
			success:function(data){
				$("div").html(data);
				}
			});
	});
	
	$("#refund").click(function () {
		alert("환불리스트 눌렷다");
		$.ajax({
			url:"searchPurchase",
			data:{type:"refund_Id"},
			success:function(data){
				$("div").html(data);
				}
			});
	});


});

</script>
<title>회원 결제 현황</title>
</head>
<body>
	<h3>회원 결제 현황</h3>
	<button id="all">전체리스트보기</button>
	<button id="refund">환불리스트보기</button>
	<select>
		<option value="member_Id">회원번호</option>
		<option value="tOrder_Id">주문번호</option>
	</select>
	<input type="text" id="keyword"><input type="button" value="검색" id="search"><br>
	<div>
	 <table border="1">
	 	<tr>
	 		<th>주문번호</th>
	 		<th>회원번호</th>
	 		<th>주문일자</th>
	 		<th>주문금액</th>
	 		<th>결제수단</th>
	 		<th>결제상태</th>
	 		<th>환불번호</th>
	 		<th>환불일자</th>
	 		<th>환불상태</th>
	 		<th>환불금액</th>
	 	</tr>
	 	<c:forEach items="${dto }" var="list">
	 	 	<tr>
	 		<td>${list.tOrder_Id}</td>
	 		<td>${list.member_Id}</td>
	 		<td>${list.tOrder_Date}</td>
	 		<td>${list.tOrder_Price}</td>
	 		<td><c:choose>
	 		<c:when test="${list.tOrder_PayType ==0}">신용카드</c:when>
	 		<c:otherwise>무통장입금</c:otherwise></c:choose></td>
	 		<td><c:choose>
				 <c:when test="${list.tOrder_State ==0}">결제완료</c:when>			
				 <c:when test="${list.tOrder_State ==1}">입금대기</c:when>
				 <c:when test="${list.tOrder_State ==2}">환불처리중</c:when>
				 <c:otherwise>취소완료</c:otherwise>			
			</c:choose></td>
	 		  <td>${list.refund_Id}</td>
	 		  <td>${list.refund_Date}</td>
	 		  <td><c:choose>
	 		      <c:when test="${list.refund_State ==0}">환불대기<br> 
	 		        <button class="updateState" id="${list.tOrder_Id}">환불완료로 변경하기</button></c:when>
	 		      <c:when test="${list.refund_State ==1}">환불완료</c:when>
	 		    </c:choose></td>
	 		  <td>${list.refund_Sum}</td>
	 	</c:forEach>
	 </table>
	</div>
</body>
</html>