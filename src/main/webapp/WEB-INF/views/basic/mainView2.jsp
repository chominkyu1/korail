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
<h3>세션사용중2</h3>
<p>세션이름:<b>${sessionScope.memberVO.member_Name}</b></p>
<input type="button" value="로그아웃" onclick="location.href='http://localhost/basic/logout'">
</body>
</html>