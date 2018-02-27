<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<input type="file"><br>
		id:<input type="text"><br>
		pass:<input type="password"><br>
		pass확인:<input type="password"><br>
		id:<input type="text"><br>
		<input type="radio" id="gen">남성
		<input type="radio" id="gen">여성
		<br>
		주소:<input type="text"><br>
		핸드폰번호:<input type="text"><br>
		질문:<select>
			<option>별명1호?</option>
			<option>보물1호?</option>
			<option>출생지?</option>
		</select><br>
		답변:<input type="text"><br>
		<input type="button" value="가입">
		<input type="button" value="취소"><br>
	</form>
</body>
</html>