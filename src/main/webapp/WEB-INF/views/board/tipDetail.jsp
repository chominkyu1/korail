<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" 
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
      $(function(){
    	  var tipreview_id=TR003;
    	  
    	  function getAllList(){
    		  
    	  
    	  $.ajax({
    		 url:'tipDetail?tipreview_id=TR003',
    		 success:function(result){
    			 console.log(tipreview_id+'게시물에 대한 댓글수==>'+result.length);
    		 	 var str='';
    		 	 $(result).each(function(){
    		 		 str+= '<li data-reply_id='+this.reply_id+":"+this.reply_content+'<button>수정</button></li>';
    		 		 
    		 	 });
    		 	 $('#replies').html(str);
    		 },
    		 error:function(xhr){
    			if(xhr.status==400){
    				alert('댓글이 없습니다!')
    			} 
    		 }
    	  });
      
    	  }//모든 리스트
    	  
    	  $('#replyAddBtn').click(function(){
    		var tipreiveiw_id=$('#newReplyWriter').val();
    		var reply_content=$('#newReplyWriter').val();
    		
    		$.ajax({
    			url:'/replies',
    			data:{
    				tipreview_id:tipreview_id,
    				tipreview_content:tipreview_content
    			},
    				type:'post',
    				success:function(result){
    					if(result == 'success'){
    						alert('댓글이 등록되었습니다!')
    					}
    				getAllList();
    			}
    	  });
    }) //추가버튼
      
    $('#replies').on("click",'replyList button', function(){
       var reply = $(this).parent();
       var reply_id = reply.attr('data-replyid');
       var reply_content = reply.attr('datar-replytext');
       
       $('.model-title').html(reply_id);
       $('#reply_content').val(replytext);
       $('#modDiv').show(500);
    
    });
    
    $('#delBtn').click(funtion(){
    	var reply_id=$(".model-title").text();
    	console.log("삭제할 댓글아이디:"+reply_id);
    	
    	$.ajax({
    		url:'/replies/'+reply_id,
    		type:'delete',
    		success:function(result){
    			if(result=='success'){
    				console.log("삭제성공!")
    				$('#modDiv').hide(500);
    				getAllList();
    			}
    		}
    	})
    }); //삭제버튼
   
    $('#modBtn').click(function(){
    	var reply_id=$(".model-title").text();
    	var reply_content=$("reply_content").val();
    	console.log("수정할 댓글아이디:"+reply_id+",내용:"+replytext);
    	
    	$.ajax({
    		url:'/replies/'+review_id,
    		type:'put',
    		headers:{'Content-Type':'application/json'},
    		data:JSON.stringify({replytext:replytext}),
    		success:function(result){
    			if(result==='success'){
    				console.log("수정성공!");
    				$('#modDiv').hide(500);
    				getAllList();
    				
    			}
    		}
    		
    	});
    	
    	$('#closeBtn').click(function){ 
    		$('#modDiv').hide(500);
    	});
   	 function printPaging(pageMaker){
   		 
   		 var str='';
   		 if(pageMaker.prev)
   			 str+='<li><a href="'+(pageMaker.startPage-1)+'"><< </a></li>';
   			 
   		for(var i=pageMaker.startPage; i<=pageMaker.endPage; i++){
   			var strClass= (pageMaker.cri.page==i) ? 'class=active':'';
   			str += "<li "+strClass+"><a href="+i+">"+i+"</a><li>";
   		}
   		if(pageMaker.next)
   			str+= '<li><a href="'+(pageMaker.endPage+1)+'">>> </a></li>;
   			$('.pagination').html(str);
   	 } //프린트 페이징
   	
   	 function getPageList(page){
   		$.ajax({
   			url:'/replies/'+tipreview_id+"/"+page,
   			dataType:'json',
   			success:function(result){
   				console.log('getPageList>>>'+result);
   				
   				var str='';
   				$(result.list).each(function(){
   					str += '<li data-reply_id='+this.reply_id+'class="replyLi" data-replytext="'
   					+this.replytext+'">"'+this.reply_id+":"+this.replytext+'<button>수정</button></li>';
   					
   				});
   				$('#replies').html(str);
   				printPaging(result.pageMaker);
   			}
   		});
   	 }
   	  getPageList(1);
    });
      }
    </script>

</head>
<body>
<h3>팁과 후기 게시물</h3> 업로드일 0000/0000
<hr>
<br>
<table border="1" cellpadding="5" class="center">
 <tr class="blue">

   
    게시글 번호 : <a>${p.tipreview_Id }</a><br> 
    게시글 카테고리 : <a>${p.tipreview_Type }</a><br>
    제목 : <a>${p.tipreview_Title }</a><br>
    등록일 : <a>${p.tipreview_Regidate }</a><br>
    <!-- 첨부파일: <input type="text" name="name"><br>
    -->
    게시글 내용:<br><textarea rows="10" cols="30">${p.tipreview_Content }</textarea><br>
   <a href="tipModify?tipreview_Id=${p.tipreview_Id }"><button>수정</button></a><a href="tipReviewList">
    <a href="tipDelete?tipreview_Id=${p.tipreview_Id }"><button>삭제</button></a><a href="tipReviewList">
   <button>리스트로</button></a>
   <br><br>
 
 </tr><br>
 <div>
 <div>작성자: <input type="text" id="newReplyWriter"></div>
 <div>댓글내용: <input type="text" id="newReplyText"></div>
 <button id="replyAddBtn">댓글추가</button> 
 </div>
 
</table>
</body>
</html>