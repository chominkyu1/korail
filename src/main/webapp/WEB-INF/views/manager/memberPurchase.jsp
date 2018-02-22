<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>결제 현황</h3>
	<select>
		<option>전체</option>
		<option>회원아이디</option>
		<option>회원명</option>
		<option>결제일</option>
	</select>
	<input type="text"><input type="button" value="검색"><br>
	
	 <table border="1">
	 	<tr>
	 		<td>회원번호</td>
	 		<td>회원명</td>
	 		<td>회원아이디</td>
	 		<td>결제일</td>
	 		<td>티켓명</td>
	 		<td>결제액</td>
	 		<td>결제수단</td>
	 		<td>결제상태</td>
	 		<td></td>
	 	</tr>
	 	 	<tr>
	 		<td>1</td>
	 		<td>1</td>
	 		<td>1</td>
	 		<td>1</td>
	 		<td>1</td>
	 		<td>1</td>
	 		<td>일반</td>
	 		<td>결제완료</td>
	 		<td><input type="button" value="환불하기"> </td>
	 	</tr>
	 	 	<tr>
	 		<td>2</td>
	 		<td>2</td>
	 		<td>2</td>
	 		<td>2</td>
	 		<td>2</td>
	 		<td>2</td>
	 		<td>블랙</td>
	 		<td>환불완료</td>
	 		<td></td>
	 	</tr>
	 </table>
</body>
</html>