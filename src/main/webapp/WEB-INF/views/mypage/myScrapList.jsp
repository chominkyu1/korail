<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.1.min.js"></script>
<!-- <script>

$(document).ready(function() {
	$("#getCheckedAll").click(function() {
		$("input[name=tipreview_Id]:checked").each(function() {
			var tipreview_Id = $(this).val();
			console.log(tipreview_Id);
		});

	});
});
</script> -->
</head>
<body>	
	<form method="post" action="/mypage/myScrapDelete">
	<c:forEach items="${ myScrap}" var="list" varStatus="loop">
	<input type="checkbox" name="tipreview_Ids" value="${list.tipreview_Id }">
	 ${list.tipreview_Title } 
	<br>
	</c:forEach>
	<input type="submit" value="삭제" ><br>
	</form>

</body>

</html>