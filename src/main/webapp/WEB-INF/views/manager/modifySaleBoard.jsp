<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>
<body>
	<h3>할인 글 업로드</h3> 
	<form action="modifysale?discount_Id=D003" method="post">

	<!-- 
		<input type="button" value="지도첨부"><br><select>
		<option>게시글카테고리(1차분류)</option>
		<option>숙박</option>
		<option>할인</option>
	</select>
	<select>
		<option>게시글카테고리(2차분류-발권지할인)</option>
		<option>서울</option>
		<option>부산</option>
	</select><br> -->
	<input type="hidden" value="${vo.discount_Id }">
	제목 : <br>
	<input type="text" value="${vo.discount_Title }" name="discount_Title"><br>
	발권역 : <br>
	<input type="text" value="${vo.station_Id }"  name="station_Id"><br>
	가격 : <br>
	<input type="text" value="${vo.discount_Price }" name="discount_Price"><br>
	할인 업체 : <br>
	<input type="text" value="${vo.discount_Shopname }"  name="discount_Shopname"><br>
	업체주소 : <br>
	<input type="text" value="${vo.discount_Map }"  name="discount_Map"><br>
	업체번호 : <br>
	<input type="text" value="${vo.discount_Shophone }"  name="discount_Shophone"><br>
	내용 : <br>
	<input type="text" value="${vo.discount_Content }" name="discount_Content"><br>
	<input type="submit" value="등록" > <input type="button" value="취소" >
	</form>
</body>
</html>