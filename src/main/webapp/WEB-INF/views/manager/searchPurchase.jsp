<%@page import="com.korail.service.PurchaseService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
