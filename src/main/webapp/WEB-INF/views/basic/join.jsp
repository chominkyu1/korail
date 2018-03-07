<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<input type="file" name="member_Profile"><br>
		id:<input type="text" name="member_Loginid"><br>
		pass:<input type="password" name="member_Pw"><br>
		pass확인:<input type="password"><br>
		이름:<input type="text" name="member_Name"><br>
		<input type="radio" name="member_Gender" value="man">남성
		<input type="radio" name="member_Gender" value="girl">여성
		<br>
		이메일:<input type="text"><input type="button" value="인증메일보내기"><br>
		인증키:<input type="text"><input type="button" value="인증키입력"> <br>
		주소:<input type="text" name="member_Addr"><br>
		핸드폰번호:<input type="text" name="member_Phone"><br>
		질문:<select name="member_Ques">
			<option>별명1호?</option>
			<option>보물1호?</option>
			<option>출생지?</option>
		</select><br>
		답변:<input type="text" name="member_Answer"><br>
		생일:<input type="date" name="member_Birth_jsp"><br>
		<input type="submit" value="가입">
		<input type="button" value="취소"><br>
	</form>
</body>
</html>