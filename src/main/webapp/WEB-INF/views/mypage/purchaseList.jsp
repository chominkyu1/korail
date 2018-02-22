<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>티켓결제내역</h3>
	<table border="1">
		<tr>
			<td>결제번호</td>
			<td>티켓명</td>
			<td>결제일</td>
			<td>결제금액</td>
			<td>결제수단</td>
			<td>주문상태</td>
		</tr>
		<tr>
			<td>p001</td>
			<td>내일로11일권</td>
			<td>2018-12-19</td>
			<td>20000원</td>
			<td>Npay</td>
			<td>환불완료</td>
		</tr>
		<tr>
			<td>p002</td>
			<td>내일로11일권</td>
			<td>2018-12-19</td>
			<td>20000원</td>
			<td>Npay</td>
			<td>환불하기</td>
		</tr>
	</table>
	<div>환불완료:취소완료후 환불되금액지급까지완료된상태</div>
	<div>취소완료:주문은 취소했지만 환불금액이 아직 지급되지 않은상태</div>
</body>
</html>