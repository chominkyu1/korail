<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>요청 허가하는 뷰</title>

</head>
<body>
	<div class="row">
		<div class="col-md-4">
			<div class="list-group">
				<c:forEach items="${list}" var="lista">

					<a href="#" class="list-group-item ">
						<h4 class="list-group-item-heading">${lista.MEMBER_ID}님께보낸
							요청입니다.</h4>
						<p class="list-group-item-text">현재 요청상태 :
							${lista.WITHASK_STATE}</p>
						<p class="list-group-item-text">내가 보낸 메세지 :
							${lista.WITHASK_CONTENT}</p>
						<p class="list-group-item-text">요청아이디 : ${lista.WITHASK_ID}</p>
					</a>

				</c:forEach>

			</div>
		</div>

		<div class="col-md-8"></div>
	</div>
</body>
</html>