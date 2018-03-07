<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

	<form>
		<div class="form-group">
			<label for="exampleInputEmail1">출발역</label> <input type="text"
				class="form-control" id="stationname" name="stationname"
				placeholder="출발역">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">도착역</label> <input type="text"
				class="form-control" id="stationname" name="stationname"
				placeholder="도착역">
		</div>
		<button type="submit" class="btn btn-default">검색</button>
	</form>

</body>
</html>