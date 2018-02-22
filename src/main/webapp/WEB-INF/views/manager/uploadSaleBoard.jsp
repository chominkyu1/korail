<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>할인 글 업로드</h3> 업로드일:2018/12/19 <input type="button" value="지도첨부"><br>
	<select>
		<option>게시글카테고리(1차분류)</option>
		<option>숙박</option>
		<option>할인</option>
	</select>
	<select>
		<option>게시글카테고리(2차분류-발권지할인)</option>
		<option>서울</option>
		<option>부산</option>
	</select><br>
	
	<input type="text" value="제목"><br>
	<input type="file" value="첨부파일"><br>
	<input type="text" value="특별가격">
	<input type="text" value="업체명">
	<input type="text" value="업체주소"><br>
	<input type="text" value="발권지명"><br>
	<input type="text" value="내용"><br>
	<input type="button" value="등록">
	<input type="button" value="취소">
	
</body>
</html>