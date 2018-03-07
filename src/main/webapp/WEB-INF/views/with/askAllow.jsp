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

<script type="text/javascript">
	$(document).ready(function() {
		$(".status").on("click", function() {

			var btn = $(this);
			var withAsk_State = btn.parent().find("select option:selected").val();//$("#selState  option:selected").val();
			var withAsk_Id = btn.parent().find("input").val();// $("#withAsk_Id").val();
			alert(withAsk_State);
			$.ajax({
				type : "post", // post방식으로 전송
				url : "askAllow", // controller로 보낼 url
				data : {
					'withAsk_State' : withAsk_State,
					'withAsk_Id' : withAsk_Id
				},
				success : function(data) {
					//alert(data);
					//alert(btn.parent().children("p").first().text());
					//alert(btn.parent().children("p:first").text());
					btn.parent().children("p").first().text('현재 요청상태 : '+withAsk_State);
					//btn.parent().children("p:first").text('현재 요청상태 : '+withAsk_State);
				},
				error : function(xhr, status) {
					alert(status);
				}
			});
		});
	});
</script>

</head>
<body>
	<div class="row">
		<div class="col-md-4">
			<div class="list-group">
				<c:forEach items="${list}" var="lista">
					<form>
						<h4 class="list-group-item-heading">${lista.SENDER_ID}님이보낸
							요청입니다.</h4>
						<p class="list-group-item-text" id="a">현재 요청상태 :
							${lista.WITHASK_STATE}</p>
						<p class="list-group-item-text">내게 보낸 메세지 :
							${lista.WITHASK_CONTENT}</p>
						<p class="list-group-item-text">요청아이디 : ${lista.WITHASK_ID}</p>
						<div class="form-group">
							<label for="sel1">요청 상태 변경</label> <select class="form-control"
								id="selState">
								<option value="0">요청 대기</option>
								<option value="1">요청수락</option>
								<option value="2">요청거절</option>
							</select>
						</div>
						<input type="hidden" id="withAsk_Id" value="${lista.WITHASK_ID}">
						<button type="button" class="status btn btn-info">저장</button>
					</form>

				</c:forEach>

			</div>
		</div>

		<div class="col-md-8"></div>
	</div>
</body>
</html>