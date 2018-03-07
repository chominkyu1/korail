<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>티켓 구매</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#purchase").click(function() {
		var paytype = $("input:radio[name='pay']:checked").val();
		var price = $("input:radio[name='ticket']:checked").val();
		var member_Id = $("input[name='member_Id']").val();
		if(paytype=="credit"){
			$.post("creditPage",
					{member_Id:member_Id,
				     tOrder_Price:price
			        });
		}else{
			$.post("order",
					{member_Id:member_Id,
				     tOrder_Price:price
			        });
		}//else
	});
	
	$("#cancle").click(function() {//아직 아무것도 !

	});
	

});
</script>
</head>
<body>
	<h3>내일로 티켓 구매하기</h3>
	<input type="hidden" name="member_Id" value="M003"><!-- member_Id 넘겨주기  -->
	
	일반 내일로  : <input type="radio" value="60000" name="ticket"><span>5일권</span>&nbsp;&nbsp; 
	<input type="radio" value="70000" name="ticket"><span>7일권</span>&nbsp;&nbsp;  <br> 
	프리미엄 내일로  : <input type="radio" value="110000" name="ticket"><span>5일권</span>&nbsp;&nbsp; 
	<input type="radio" value="120000" name="ticket"><span>7일권</span>&nbsp;&nbsp; <br>
	
	결제 수단 <br>
	<input type="radio" value="cash" name="pay"><span>무통장입금</span>&nbsp;&nbsp; 
	<input type="radio" value="credit" name="pay"> <span>신용카드</span>&nbsp;&nbsp; <br>
	
	<input type="button" id="purchase" value="구매">
	<input type="button" id="cancle" value="취소">
</body>
</html>