<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 합쳐지고 최소화된 최신 CSS -->

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>동행게시글 세부정보 뷰 (ReadWithBoard.jsp)</title>
<script type="text/javascript">
	
</script>
<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form[role='form']");
		console.log(formObj);

		$("#remove").on("click", function() {
			formObj.attr("action", "remove");
			formObj.submit();
		});

		$("#modify").on("click", function() {
			formObj.attr("action", "modify");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$("#listAll").on("click", function() {
			self.location = 'list?member_Id=${param.member_Id}';
		});

		$("#btn_ask").on("click", function() {
			var serializeData = $(".askform").serialize();
			$.post("ask", serializeData, function(data) {
				self.location = 'list?member_Id=${param.member_Id}';
			});	
		});

	});
</script>



</head>
<body>
	<h3>동행게시글 세부정보 뷰 (ReadWithBoard.jsp)</h3>
	<form role="form" method="post" action="modifyPage" class="askform">
		<input type='hidden' name='withboard_Id'
			value="${withBoardVO.withboard_Id}"> <input type='hidden'
			name='member_Id' value="${withBoardVO.member_Id}"> <input
			type='hidden' name='page' value="${cri.page}"> <input
			type='hidden' name='perPageNum' value="${cri.perPageNum}">
	</form>
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
		<tr>
			<td>${withBoardVO.withboard_Id}</td>
			<td>${withBoardVO.withboard_Regidate}</td>
			<td>${withBoardVO.member_Id}</td>
			<td>${withBoardVO.withboard_Title}</td>
			<td>${withBoardVO.withboard_Content}</td>
			<td>${withBoardVO.withboard_Gender}</td>
			<td>${withBoardVO.withboard_Startdate}</td>
			<td>${withBoardVO.withboard_Enddate}</td>
		</tr>
	</table>
	<table class="table table-borded">
		<tr>
			<th>동행일정ID</th>
			<th>동행일정역</th>
			<th>동행일정시작일</th>
			<th>동행일정종료일</th>
			<th>동행일정내용</th>
			<th>동행게시글ID</th>
		</tr>
		<c:forEach items="${list }" var="withScheVO">
			<tr>
				<td>1${withScheVO.withsche_Id}</td>
				<td>1${withScheVO.withsche_Station}</td>
				<td>${withScheVO.withsche_Startdate}</td>
				<td>${withScheVO.withsche_Enddate}</td>
				<td>${withScheVO.withsche_Content}</td>
				<td>${withScheVO.withboard_Id}</td>
			</tr>
		</c:forEach>
	</table>



	<button id="modify">수정</button>
	<button id="remove">삭제</button>
	<button id="listAll">리스트로</button>




	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#askModal" data-whatever="@getbootstrap">동행요청하기</button>

	<div class="modal fade" id="askModal" tabindex="-1" role="dialog"
		aria-labelledby="askModal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="askModalLabel">New message</h4>
				</div>
				<div class="modal-body">
					<form class="askform">
					<input type="hidden" name ="sender_Id" value ="${param.member_Id}">
						<div class="form-group">
							<label for="recipient-name" class="control-label">Recipient:</label>
							<input type="text" class="form-control" name="member_Id"
								value="${withBoardVO.member_Id}" readOnly>
						</div>
						<div class="form-group">
							<label for="message-text" class="control-label">Message:</label>
							<textarea class="form-control" name="withAsk_Content"
								value="withAsk_Content"></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button id="btn_ask" type="button" class="btn btn-primary">요청하기</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
