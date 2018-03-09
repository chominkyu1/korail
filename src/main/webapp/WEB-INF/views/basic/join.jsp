<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
		var tempCode=null;
		
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
		
		$("#bt_sendEmail").click(function () {//인증키 이메일로 발송
			var email = $("#authorized_Mail").val();
			//alert(email);
			if(email==""){
				alert("이메일을 입력해 주세요");
			}else{
			$.ajax({
				url:"sendEmail",
				data:{email:email},
				success:function(data){
					alert("입력하신 "+email+"로 인증코드가 발송되었습니다. 확인 후 입력해 주세요.");
					//alert("tempCode >>>> "+data);
					tempCode = data;
				}
			});
			}
			
		});

		$("#bt_validCode").click(function() {//ajax로 입력코드와 임시코드 비교 - 일치하면 일치합니다 alert/ 일치하지 않으면 다시 확인해 주세요 alert
			var input_Code = $("#authorized_Code").val();
		    console.log("DB에 저장된 코드 : "+tempCode+"/// 사용자가 입력한 코드: " +input_Code );
			if(tempCode === input_Code){
				alert("인증이 완료되었습니다!!<br> 계속해서 회원가입을 진행해 주세요.");
				$("#infodiv").css("display", "");
			}else{
				alert("인증에 실패하였습니다!!<br> 입력하신 이메일로 발송된 인증번호를 다시한번 확인해주세요.");
			}
		});
		
		$("input:radio[name=gender]").click(function(){
			var gender =  $("input[name=gender]:checked").val();
			$("#member_Gender").val(gender);
			
		});
		/* 
		$("#member_Loginid").keypress(function () {
			var keyword = $("#member_Loginid").val();
			alert(keyword);
			$.ajax({
				url:"validID",
				data:{keyword:"%"+keyword+"%"},
				success:function(data){
					if(data=0){
						$("span").html("<label style=color: blue>유효한 아이디입니다.</label> ");
					}else{
						$("span").html("<label style=color: red>중복된 아이디가 존재합니다.</label> ");
					}
				}
				
			});
		}); */

});
</script>
<title>회원가입</title>
</head>
<body>
<h3>회원 가입 </h3>
<hr>
 <%-- 
	<form method="post" enctype="multipart/form-data" >
	
		회원 사진 : <input type="file" id="imgup" name="member_Profile" required>
		<img id="img" width="300" style="display: none"><br>
		id:<input type="text" id="member_Loginid" name="member_Loginid" required><span></span><br>
		pass:<input type="password" name="member_Pw" required><br>
		pass확인:<input type="password" required><br>
		이름:<input type="text" name="member_Name" required><br>
		성별:
		<input type="radio" name="gender" value="male"><span>남성</span>&nbsp;&nbsp;
		<input type="radio" name="gender" value="female"><span>여성</span>&nbsp;&nbsp;  
		<input type="hidden" id="member_Gender" name="member_Gender" value=""><br>
		<br>
		이메일:<input type="email" id="authorized_Mail" name="authorized_Mail" required>
		<input type="button" id="bt_sendEmail" value="인증메일보내기"><br>
		
		인증키:<input type="text" id="authorized_Code" name="authorized_Code" required><input type="button" id="bt_validCode" value="인증키확인"> <br>
		<label>전송된 인증번호를 입력해 주세요</label><br>
		<div id="infodiv" style="display: none">
		주소:<input type="text" name="member_Addr" required><br>
		핸드폰번호:<input type="text" name="member_Phone" required ><br>
		생일:<input type="date" name="member_Birth" required><br>
		질문:<select name="member_Ques" required>
			<option value="none">======선택======</option>
			<option value="0">나의 아버지의 성함은?</option>
			<option value="1">내가 태어난고향은?</option>
			<option value="2">나의 어릴때 별명은?</option>
			<option value="3">나의 보물1호는?</option>
			<option value="4">나의 어렸을 적 별명은?</option>
		</select><input type="hidden" name="member_Ques" value=""> <br>
		답변:<input type="text" name="member_Answer" required>
        <br><br>
		<input type="submit" value="가입">
		</div>
		<input type="button" value="취소"><br>
	</form>
	--%>
	<form method="post" enctype="multipart/form-data" >
	
		회원 사진 : <input type="file" id="imgup" name="member_Profile" required>
		<img id="img" width="300" style="display: none"><br>
		id:<input type="text" id="member_Loginid" name="member_Loginid" required value="hjs1234"><span></span><br>
		pass:<input type="password" name="member_Pw" value="1234" required><br>
		pass확인:<input type="password" value="1234" required><br>
		이름:<input type="text" name="member_Name" value="정수기" required><br>
		성별:
		<input type="radio" name="gender" value="male"><span>남성</span>&nbsp;&nbsp;
		<input type="radio" name="gender" value="female" checked="checked"><span>여성</span>&nbsp;&nbsp;  
		<input type="hidden" id="member_Gender" name="member_Gender" value="female"><br>
		<br>
		이메일:<input type="email" id="authorized_Mail" value="hjs2343@naver.com" name="authorized_Mail" required>
		<input type="button" id="bt_sendEmail" value="인증메일보내기"><br>
		
		인증키:<input type="text" id="authorized_Code" name="authorized_Code" required><input type="button" id="bt_validCode" value="인증키확인"> <br>
		<label>전송된 인증번호를 입력해 주세요</label><br>
		<div id="infodiv" style="display: none">
		주소:<input type="text" name="member_Addr" value="encore" required><br>
		핸드폰번호:<input type="text" name="member_Phone" value="212540102" required ><br>
		생일:<input type="date" name="member_Birth" value="1993-06-03" required><br>
		질문:<select name="member_Ques" required>
			<option value="none">======선택======</option>
			<option value="0" selected="selected">나의 아버지의 성함은?</option>
			<option value="1">내가 태어난고향은?</option>
			<option value="2">나의 어릴때 별명은?</option>
			<option value="3">나의 보물1호는?</option>
			<option value="4">나의 어렸을 적 별명은?</option>
		</select><input type="hidden" name="member_Ques" value="0"> <br>
		답변:<input type="text" name="member_Answer" value="호호" required>
        <br><br>
		<input type="submit" value="가입">
		</div>
		<input type="button" value="취소"><br>
	</form>
</body>
</html>