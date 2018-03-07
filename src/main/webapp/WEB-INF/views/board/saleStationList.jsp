<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
/* $(document).ready(function(){
	function update() {
		$.get("", function(data, status){
            alert("Data: " + data + "\nStatus: " + status);
        });
    };
    function delete() {
    	alert('삭제하시겠습니까?');
    	$.get("list", function(data, status){
            alert("Data: " + data + "\nStatus: " + status);
        });
    };

    
});
		
 */
</script>
</head>
<body>    
	<table>
	<tr bgcolor="pink" bordercolor="black">
		<th>글번호</th>
		<th>발권구분</th>
		<!-- <th>발권역</th> -->
		<th>글제목</th>
		<th>조회수</th>
	</tr>
	<c:forEach items="${list}" var="vo">
	<tr>
		<td>${vo.discount_Id }</td>
		<td>${vo.station_Id }</td>
		<%-- <td>${stationVO.station_Station }</td> --%>
		<td><a href="detail?discount_Id=${vo.discount_Id }">${vo.discount_Title }</a></td>
		<td>${vo.discount_Count }</td>
	</tr>
	</c:forEach>
  </table>
</body>
</html>