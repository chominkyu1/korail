<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script type="text/javascript">
   $(function(){
	   $('#bt_del').click(function(){
		  //---> /board/tipDelete?tipreview_id=TR001
		   location.href='tipDelete?tipreview_Id=${p.tipreview_Id }';
	   });
   });
  
  </script>
</head>
<body>
<h3> 게시물 수정</h3> 업로드일 0000/0000
<hr>
<br>
<table border="1" cellpadding="5" class="center">
 <tr class="blue">

   <form method="post">
   <input type="hidden" name="member_Id" value="${p.member_Id}">
   <input type="hidden" name="tipreview_Count" value="${p.tipreview_Count}">
    게시글 번호 : <input type="text" name="tipreview_Id" value="${p.tipreview_Id }"><br>
    게시글 카테고리:<input type="text" name="tipreview_Type" value="${p.tipreview_Type }"><br>
    제목: <input type="text" value="${p.tipreview_Title } "name="tipreview_Title"><br>
    등록일:<input type="text" name="tipreview_Regidate" value="${p.tipreview_Regidate }"><br>
    <!-- 첨부파일: <input type="text" name="name"><br>
    -->
    게시글 내용:<br><textarea rows="10" cols="30" name="tipreview_Content">${p.tipreview_Content }</textarea><br>
   <button>수정완료</button><button type="button" id="bt_del">삭제</button>
   </form><br><br>
 
 </tr><br>
</table>
</body>
</html>