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
		이름:<input type="text" name="member_Name"><br>
		핸드폰번호:<input type="text" name="member_Phone"><br>
		질문:<select name="member_Ques">
			<option>별명1호?</option>
			<option>보물1호?</option>
			<option>출생지?</option>
		</select><br>
		답변:<input type="text" name="member_Answer"><br>
		<input type="submit" value="확인" onclick="idserarch()">
		<input type="button" value="취소">
	</form>
</body>
<script>
	function idserarch() {
	alert("회원님의 아이디는"${member_Id}"입니다.");
</script>
</html>