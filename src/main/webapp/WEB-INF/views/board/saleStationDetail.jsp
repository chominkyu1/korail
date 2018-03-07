<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>할인정보보기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
/* $(document).ready(function(){
	
	$("#modify").click(function() {
		$("input[readonly]").removeAttr("readonly");
		$("h3").html("게시물수정하기");
		
		$("#remove").hide();
		$("#d1").html("<button type=submit id=update>저장하기</button>");
	});
	
	$("#remove").click(function() {
		var discount_Id="${vo.discount_Id }";
		alert("삭제할 번호는?"+discount_Id);
		$.post("remove?discount_Id="+discount_Id, function(status){
	        alert("\nStatus: " + status);
	        $.get("list");
	    });
	});
	*/ 
	$("#goList").click(function() {
		$.get("list");
	});
	 /*
	$("#update").click(
			
			$.post("modify?discount_Id="+"${vo.discount_Id }",
				    {
				discount_Id:"${vo.discount_Id }",
				discount_Title: $("#title").val(),
				discount_Content: $("#content").val(),
				discount_Map:$("#map").val()
				
		    },
		    function(status){
		        alert("\nStatus: " + status);
		    	$.get("list");  
		    }));
			
	
}); */

</script>
</head>
<body>
<h3>게시글 보기</h3>

글번호 : <label>${vo.discount_Id }</label><br>
제목 : <input type="text" readonly id="title" value="${vo.discount_Title }"><br>
업로드일 : <label>${vo.discount_Regidate}</label>
조회수 : <label>${vo.discount_Count}</label><br>
발권역 <label>${stationVO.station_Type } > ${stationVO.station_Station }</label>
내용 : <input type="text" readonly id="content" value="${vo.discount_Content}"><br>
지도 : <input type="text" readonly id="map" value="${vo.discount_Map}"><br>

<button type="submit"  id="goList">목록으로</button>
</body>
</html>