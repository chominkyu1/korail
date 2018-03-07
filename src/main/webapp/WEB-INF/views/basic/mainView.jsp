<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>짜잔</h1>
<h3>로그인성공</h3>
<p>세션이름:<b>${sessionScope.memberVO.member_Name}</b></p><br>
<b>${sessionScope.memberVO.member_Loginid}</b><br>
<b>${sessionScope.memberVO.member_Id}</b><br>
<input type="button" value="로그아웃" onclick="location.href='http://localhost/basic/logout'">
<input type="button" value="다른페이지로" onclick="location.href='http://localhost/basic/mainView2'">
</body>
</html>