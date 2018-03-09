<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
//GIT
$(document).ready(function(){
	var cnt=0;
	
	$("select[name=station_Type]").change(function() {
		//alert($("select[name=station_Type] option:selected").val());
		console.log($(this).val());
		$.ajax({
			url:"stationList",
			data:{station_Type:$(this).val()},
			success:function(data){
				$("#station").html(data);
			}
		});
	});

	$('#station').on("change","select[name=station_Station]",function(){
		console.log($("select[name=station_Station] option:selected").val());
		$.ajax({
			url:"stationId",
			data:{station_Station:$("select[name=station_Station] option:selected").val()},
			success:function(data){
				console.log(data);
				$("#station_Id").val(data);
			}
		});
		
	});
	
	$('#fileDiv').on('change','.myfile',function(){//파일 미리보기
		console.log('파일선택 :'+ this);
	    var img = $(this).parent().find('img');
		//$("#img").css("display","");
		img.css("display","");
		var reader = new FileReader();
		
		reader.onload=function(e){
			img.attr('src', e.target.result );
		}
		reader.readAsDataURL(this.files[0])
	});
	
	//파일 input 추가
	$('button').click(function(){
		$('#fileDiv').append('<div><input type="file" class="myfile" name="addfile'+ ++cnt +'">'+
				'<br><img id="img" width="300" height="300" style="display:none" ><hr><div>');
	});
});
</script>
<title>할인게시물업로드</title>


</head>
<body>
	<h3>할인 글 업로드</h3> 
	<form action="uploadsale?member_Id=M001" method="post" enctype="multipart/form-data">

	제목 : 
	<input type="text"  name="discount_Title"><br>
	발권역 : <select name="station_Type">
		<option value="none">==선택==</option>
		<option value="공통혜택">공통혜택</option>
		<option value="전체혜택">전체혜택</option>
		<option value="수도서부">수도서부</option>
		<option value="수도동부">수도동부</option>
		<option value="대전충남">대전충남</option>
		<option value="경북본부">경북본부</option>
		<option value="광주본부">광주본부</option>
		<option value="전남본부">전남본부</option>
		<option value="대구본부">대구본부</option>
		<option value="부산경남">부산경남</option>
		<option value="강원본부">강원본부</option>
		<option value="전북본부">전북본부</option>
	</select>
	
	<div id="station"></div>
	<input type="hidden" id="station_Id" name="station_Id">
	<br>
	가격 : 
	<input type="text"  name="discount_Price"><br>
	할인 업체 : 
	<input type="text"   name="discount_Shopname"><br>
	업체주소 : 
	<input type="text"   name="discount_Map"><br>
	업체번호 : 
	<input type="text"   name="discount_Shophone"><br>
	내용 : 
	<input type="text"  name="discount_Content"><br>
	
	파일 : <button type="button">파일추가</button>
	<div id="fileDiv"></div>
	
	<input type="submit" value="등록" > <input type="button" value="취소" >
	</form>
</body>
</html>