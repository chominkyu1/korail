<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신용카드 결제</title>
</head>
<body>
	<h3>카드결제페이지 입니다</h3>
	<form action="purchase/credit" method="post">
	<table border="1">
	<tr>
		<td>
	<input type="radio" name="card">삼성
	<input type="radio" name="card">현대
	<input type="radio" name="card">신한
	<input type="radio" name="card">국민	
		</td>
	</tr>
	<tr>
		<td>
	<input type="text" size="2">-
	<input type="text" size="2">-
	<input type="password" size="2">-
	<input type="password" size="2">		
		</td>
	</tr>
	<tr>
		<td>
	<input type="button" value="승인">
	<input type="button" value="취소">	
		</td>
	</tr>
	</table>
	<input type="hidden" value="${tOrderVO}" name="tOrderVO">
	</form>
</body>
</html>