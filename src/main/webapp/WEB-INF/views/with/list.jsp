<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 합쳐지고 최소화된 최신 CSS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}

	$(".pagination li a").on("click", function(event) {

		event.preventDefault(); //<a href> 막아주기

		var targetPage = $(this).attr("href");//<a href="3">

		var jobForm = $("#jobForm"); // <form id="jobForm" action = "/board/listPage">
		jobForm.find("[name='page']").val(targetPage);
		jobForm.attr("action", "/with/list").attr("method", "get");
		jobForm.submit();
	});
</script>


<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$(".btn")
								.on(
										"click",
										function() {
											//var queryString = $("form[id=search]").serialize();

											//alert(queryString);
											$
													.ajax({
														type : "GET", // post방식으로 전송
														url : "withSearch", // controller로 보낼 url
														data : {
															"member_loginId" : $(
																	"#member_loginId")
																	.val(),
															"withsche_Station" : $(
																	"#withsche_Station")
																	.val(),
															"withboard_Startdate" : $(
																	"#withboard_Startdate")
																	.val(),
															"withboard_Gender" : $(
																	"#withboard_Gender")
																	.val(),
															"search_Category" : $(
																	"#search_Category")
																	.val(),
															"search_Keyword" : $(
																	"#search_Keyword")
																	.val(),

														},
														success : function(data) {	$('#searchResult').html('');
															$
																	.each(
																			data,
																			function(
																					index,
																					entry) {
																				var html = '<tr>';
																				html += '<td>'
																						+ entry.withboard_Id
																						+ '</td>';
																				html += '<td>'
																						+ entry.withboard_Regidate
																						+ '</td>';
																				html += '<td>'
																						+ entry.member_Id
																						+ '</td>';
																				html += '<td>'
																						+ entry.withboard_Content
																						+ '</td>';
																				html += '<td>'
																						+ entry.withboard_Gender
																						+ '</td>';
																				html += '<td>'
																						+ entry.withboard_Startdate
																						+ '</td>';
																				html += '<td>'
																						+ entry.withboard_Enddate
																						+ '</td>';
																				
																				html += '</tr>';
																				$('#searchResult').html(html);
																			});// end each

															return false;

														},
														error : function(jqXHR,
																textStatus,
																errorThrown) {
															alert("에러 발생~~ \n"
																	+ textStatus
																	+ " : "
																	+ errorThrown);
															self.close();
														}
													});
										});
					});
</script>

</head>
<body>

	<div class="col-md-4">
		<form id="search" name="search" action="post">
			<input type="text" class="form-control" id="member_loginId"
				placeholder="member" value="member_loginId" readOnly>
			<div class="form-group">
				<label for="exampleInputEmail1">동행역</label> <input type="text"
					class="form-control" id="withsche_Station" placeholder="동행역">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">동행일</label> <input type="date"
					class="form-control" id="withboard_Startdate" placeholder="동행시작일">
			</div>
			<label for="exampleInputFile">동행 선호성별</label> <select
				id="withboard_Gender" class="form-control">
				<option value="0">전체</option>
				<option value="1">여성</option>
				<option value="2">남성</option>

			</select> <label for="exampleInputFile">조회구분</label> <select
				id="search_Category" class="form-control">
				<option value="0">제목+내용</option>
				<option value="1">제목</option>
				<option value="2">내용</option>
				<option value="3">작성자</option>
			</select><label for="exampleInputFile">검색키워드'</label> <input type="text"
				class="form-control" id="search_Keyword">
			<button type="button" class="btn btn-default">제출</button>
		</form>
	</div>
	<div class="col-md-8"><div id="searchResult"></div>
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
						href='/with/read${pageMaker.makeQuery(pageMaker.cri.page) }&member_Id=${param.member_Id}&withboard_Id=${withBoardVO.withboard_Id}'>${withBoardVO.withboard_Title};</a></td>
					<td>${withBoardVO.withboard_Content};</td>
					<td>${withBoardVO.withboard_Gender};</td>
					<td>${withBoardVO.withboard_Startdate};</td>
					<td>${withBoardVO.withboard_Enddate};</td>
				</tr>
			
			</c:forEach>

		</table>
</div>

		<div class="box-footer">
			<div class="text-center">
				<ul class="pagination">

					<c:if test="${pageMaker.prev}">
						<li><a href="${pageMaker.startPage - 1}">&laquo;</a></li>
					</c:if>

					<c:forEach begin="${pageMaker.startPage }"
						end="${pageMaker.endPage }" var="idx">
						<li
							<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
							<a href="${idx}">${idx}</a>
						</li>
					</c:forEach>

					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						<li><a href="${pageMaker.endPage +1}">&raquo;</a></li>
					</c:if>

				</ul>
			</div>
		</div>


		<!-- /.box-footer-->

		<!--/.col (left) -->

		<!-- /.content -->

		<form id="jobForm">
			<input type='hidden' name="page" value="${pageMaker.cri.perPageNum}">
			<input type='hidden' name="perPageNum"
				value="${pageMaker.cri.perPageNum}">
		</form>
</body>
</html>


