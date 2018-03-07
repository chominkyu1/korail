<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>동행게시글 작성 뷰</title>
<script type="text/javascript">
  
</script>
</head>
<body>
 <h3>게시글 업로드</h3>
  <hr>
  <form method="post">
     게시글 카테고리:<input type="text" name="tipreview_type"><br>
     작성자:<input type="text" name="tipreview_id"><br>
     제목:<input type="text" name="tipreview_title"><br>
     첨부파일:<input type="text" name="tipreview_count"><br>
   <!--   해시태그:<input type="text" name="tipreview_regidate"><br> -->
     방문한역:<input type="text" name="member_id"><br>
     게시글 내용:<textarea rows="5" cols="25" name="tipreview_content">123</textarea><br>
 <input type="submit" value="등록"><br>
 
  </form><br>
 <hr>
<h4>댓글</h4>
 <textarea rows="3" cols="30">
  댓글내용 
 </textarea><br>
  <input type="button" value="등록"><br>
 
</body>
</html>