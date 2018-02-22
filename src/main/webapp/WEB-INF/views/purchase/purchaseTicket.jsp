<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	출발역<select>
		<option>서울</option>
		<option>부산</option>
		<option>대구</option>
	</select>
	도착역<select>
		<option>서울</option>
		<option>부산</option>
		<option>대구</option>
	</select><br>
	출발일<select>
	<option>2018</option>
	<option>2019</option>
	<option>2020</option>
	<option>2021</option>
	</select>년
	<select>
	<c:forEach begin="1" end="12" var="m">
	<option>${m }</option>
	</c:forEach>
	</select>월
	<select>
	<c:forEach begin="1" end="31" var="m">
	<option>${m }</option>
	</c:forEach>
	</select>일<br>
	기간<select>
	<option>7일</option>
	<option>11일</option>
	</select>
	<input type="button" value="구매">
	<input type="button" value="취소">
</body>
</html>