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



<title>동행게시글 등록 (register.jsp)</title>

<!-- //클릭하면 폼 추가 -->
<script>
	$(document).ready(function() {
		$('#addSche').click(function() {
			$('#addedSche').append('<div id="appended"><div class="form-group"><label for="withsche_Station">동행할 역 : </label> '
					+ '<input type="text" class="form-control" name="withsche_Station" placeholder="동행할 역 :">'
					+ ' </div> <div class="form-group"> <label for="withsche_Startdate">일정 시작일: </label> <input type="date" class="form-control" name="withsche_Startdate" placeholder="일정 시작일: ">'
					+ '</div> <div class="form-group"> '
					+ '<label for="withsche_Enddate">일정 종료일 :</label> <input type="date" class="form-control" name="withsche_Enddate" placeholder="일정 종료일 :">'
					+ ' </div> <div class="form-group">'
					+ ' <label for="withsche_Content">일정 설명 :</label> <input type="text" class="form-control" name="withsche_Content" placeholder="일정 설명 :">'
					+ '<label for="withsche_Addr">일정 주소 :</label> <input type="text" class="form-control" name="withsche_Addr" placeholder="일정 주소 ">'
					+ '<input type="button" class="btnRemove btn btn-danger" value="- 삭제"><br></div>'); // end append 
$('.btnRemove').on('click',function() {$(this).closest("#appended").remove();
});
					}); // end click
}); 
</script>



</head>
<body>
	<div>${writerInfo.member_Id}////아이디 : ${writerInfo.member_Loginid} 게시자 성명 :
		${writerInfo.member_Name} 게시자 성별 : ${writerInfo.member_Gender} 게시자 나이
		: ${writerInfo.member_Birth} 게시자 사진 : ${writerInfo.member_Profile}</div>
	<div class="col-md-4">
		<form role="form" method="post">
 <%-- 			<input type = "text" name="member_Id" value="${writerInfo.member_Id}"> --%>
 
			<div class="form-group">
				<label for="title">동행 요청 게시글 제목 :</label> <input type="text"
					class="form-control" name="withboard_Title"
					placeholder="동행 요청 게시글 제목 :">
			</div>
			<div class="form-group">
				<label for="content">동행 요청 게시글 내용:</label> <input type="text"
					class="form-control" name="withboard_Content"
					placeholder="동행 요청 게시글 내용 :">
			</div>
			<div class="form-group">
				<label for="withStartDate">동행 시작일 : </label> <input type="date"
					name="withboard_Startdate" class="form-control"
					placeholder="동행 시작일 : ">
			</div>
			<div class="form-group">
				<label for="withEndDate">동행 종료일 :</label> <input type="date"
					class="form-control" name="withboard_Enddate"
					placeholder="동행 종료일 :">
			</div>
			<div class="radio">
				<label class="radio-inline"> <input type="radio"
					name="WITHBOARD_Gender" value="0"> 여성
				</label> <label class="radio-inline"> <input type="radio"
					name="withboard_Gender" value="1"> 남성
				</label> <label class="radio-inline"> <input type="radio"
					name="withboard_Gender" value="2"> 무관
				</label>
			</div>
			<div id="addedSche"></div>
			<button type="button" class="btn btn-info" id="addSche">+일정</button>
			<button type="submit" class="btn btn-default">제출</button>
		</form>
	</div>

</body>
</html>