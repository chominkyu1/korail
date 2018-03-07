<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원현황</h3>
	<br>
	<form method="post">
	<select name="searchType">
		<option value="all">전체</option>
		<option value="id">회원아이디</option>
		<option value="name">회원명</option>
		<option value="date">가입일</option>
	</select>
	<input type="text" name="searchText" id="searchtext">
	<input type="submit" value="검색">
	<br>

	<table border="1">
		<tr>
			<td>회원번호</td>
			<td>회원명</td>
			<td>회원아이디</td>
			<td>전화번호</td>
			<td>성별</td>
			<td>주소</td>
			<td>회원분류</td>
			<td>가입일</td>
			<td>탈퇴일</td>
		</tr>
		<c:forEach items="${ memberList}" var="List">
		<tr>
			<td>${List.member_Id }</td>
			<td><a href="http://localhost/manager/memberDetail?member_Id=${List.member_Id }">${List.member_Name }</a></td>
			<td>${List.member_Loginid }</td>
			<td>${List.member_Phone }</td>
			<td>${List.member_Gender }</td>
			<td>${List.member_Addr }</td>
			<td>${List.member_Type }</td>
			<td>${List.member_Regidate }</td>
			<td>${List.member_Regidate }</td>
		</tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>









