<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
		$('#imgup').change(function() {//파일 미리보기
			console.log('change');
			$("#img").css("display", "");
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#img').attr('src', e.target.result);
			}
			reader.readAsDataURL(this.files[0])
		});
		
		$("select[name=member_Ques]").change(function() {
			alert($(this).val());
			$("input[name=member_Ques]").val($(this).val());
		});
		
		$("#sendEmail").click(function () {//인증키 이메일로 발송
			var email = $("#member_Email").val();
			concole.log(email);
			
			$.post("",{email:email});
		});

		$("#bt_validCode").click(function() {//ajax로 입력코드와 임시코드 비교 - 일치하면 일치합니다 alert/ 일치하지 않으면 다시 확인해 주세요 alert
			
		});
		
		$("input:radio[name=gender]").click(function(){
			var gender =  $("input[name=gender]:checked").val();
			$("#member_Gender").val(gender);
			
		});

});
</script>
<title>회원가입</title>
</head>
<body>
<h3>회원 가입 </h3>
<hr>
	<form method="post" enctype="multipart/form-data">
	
		회원 사진 : <input type="file" id="imgup" name="member_Profile">
		<img id="img" width="300" style="display: none"><br>
		id:<input type="text" name="member_Loginid" required><br>
		pass:<input type="password" name="member_Pw" required><br>
		pass확인:<input type="password" required><br>
		이름:<input type="text" name="member_Name"><br>
		성별:
		<input type="radio" name="gender" value="male"><span>남성</span>&nbsp;&nbsp;  <br>
		<input type="radio" name="gender" value="female"><span>여성</span>&nbsp;&nbsp;  
		<input type="hidden" name="member_Gender" value=""><br>
		<br>
		이메일:<input type="text" id="authorized_Mail" name="authorized_Mail"><input type="button" id="bt_sendEmail" value="인증메일보내기"><br>
		인증키:<input type="text" id="authorized_Code" name="authorized_Code"><input type="button" id="bt_validCode" value="인증키확인"> <br>
		주소:<input type="text" name="member_Addr"><br>
		핸드폰번호:<input type="text" name="member_Phone" ><br>
		생일:<input type="date" name="member_Birth_jsp"><br>
		질문:<select name="member_Ques">
			<option value="none">======선택======</option>
			<option value="0">나의 아버지의 성함은?</option>
			<option value="1">내가 태어난고향은?</option>
			<option value="2">나의 어릴때 별명은?</option>
			<option value="3">나의 보물1호는?</option>
			<option value="4">나의 어렸을 적 별명은?</option>
		</select><input type="hidden" name="member_Ques" value=""> <br>
		답변:<input type="text" name="member_Answer">
        <br><br>
		<input type="submit" value="가입">
		<input type="button" value="취소"><br>
	</form>
</body>
</html>