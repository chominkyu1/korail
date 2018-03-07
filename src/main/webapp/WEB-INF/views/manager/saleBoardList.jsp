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
	
	<input type="button" value="발권지할인">
	<input type="button" value="내일로포괄할인"><br>
	<c:forEach items="${discountAll }" var="discountAll">
	<img alt="..." src="...">${discountAll.discount_Title }<br>
	업로드한날짜:${discountAll.discount_Regidate } <input type="button" value="하위내용"><br>
	<input type="button" value="상세보기"><br>
	<input type="button" value="수정">
	<input type="button" value="삭제"><br>
	</c:forEach>
</body>
</html>