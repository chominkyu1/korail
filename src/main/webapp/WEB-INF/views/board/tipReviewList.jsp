<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript">
        var result='(msg)';
        if(result='success'){
		alert('수정이 완료되었습니다!')}
        </script>


<body>
	<input type="button" value="tip게시판">
	<input type="button" value="후기게시물"><br>
	<hr>
	<c:forEach items="${list }" var="list">
	<div><a href="tipDetail?tipreview_Id=${list.tipreview_Id }"><input type="image"></a> 
	게시글명: <label>${list.tipreview_Title }</label>,
	작성자명: <label>${list.member_Id }</label>,
	작성일: <label>${list.tipreview_Regidate } </label>,
	스크랩수: <label>${list.tipreview_Regidate } </label><br>
	<textarea rows="5" cols="25" name="tipreview_content">${list.tipreview_Content }</textarea></div>
	</c:forEach>

<hr>
 	<input type="text" name="keyword" id="keywordInput"
 	 value='${cri.keyword }'>
	<button id='검색'>검색</button>
</body>
</html>