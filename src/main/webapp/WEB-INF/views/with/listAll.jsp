<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 합쳐지고 최소화된 최신 CSS --><script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>



<!-- <script>
var result='${msg}';

if(result='SUCCESS'){
	alert("처리가 완료되었습니다.");
}
</script> -->
</head>
<body>
	<h3>검색창이랑 디폴트 모든 게시글 리스트가 나오는 뷰 (listAll.jsp)</h3>
	<table class="table table-borded">
		<tr>
			<th>동행게시글ID</th>
			<th>동행 게시글 등록일</th>
			<th>동행 게시글 작성자</th>
			<th>동행게시글 제목</th>
			<th>동행게시글 내용</th>
			<th>동행 선호 성별</th>
			<th>동행 시작일</th>
			<th>동행 종료일</th>
		</tr>
		<c:forEach items="${list}" var="withBoardVO">
			<tr>
				<td>${withBoardVO.withboard_Id};</td>
				<td>${withBoardVO.withboard_Regidate};</td>
				<td>${withBoardVO.member_Id}</td>
				<td><a
					href='/with/read?withboard_Id=${withBoardVO.withboard_Id}'>${withBoardVO.withboard_Title};</a></td>
				<td>${withBoardVO.withboard_Content};</td>
				<td>${withBoardVO.withboard_Gender};</td>
				<td>${withBoardVO.withboard_Startdate};</td>
				<td>${withBoardVO.withboard_Enddate};</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>


