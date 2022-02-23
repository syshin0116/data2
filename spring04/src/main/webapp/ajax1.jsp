<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#b1').click(function(){
			$.ajax({
				url: "ajax1",
				data: {
					phone: $('#tel').val()
				},
				success: function(x) {
					alert('성공');
					alert('인증번호는 ' + x);
					$('#result').html('인증번호는 '+x);
					confirmNo = x;
				},
				error: function() {
					alert('실패');
				} //error
			});//ajax
		});//#b1.click
		$('#b2').click(function(){
			$.ajax({
				url: "money.do",
				data:{
					money: $('#money').val(),
					choice: $('#choice').val()
				},
				success: function(x){
					alert('성공');
					alert('result는 ' + x);
					$('#result2').html("할인후 금액:"+ x);
				},
				error: function(){
					alert('실패');
				}
			});//ajax
		});//#b2.click
		$('#b3').click(function() {
			tel2Value = $('#tel2').val()
			noResult = "인증실패"
			$('#result3').css("color", "red");
			if(tel2Value == confirmNo){
				noResult = "인증성공"
				$('#result3').css("color", "green");
			}
			$('#result3').html(noResult)
		});
	});//$function
</script>
</head>
<body>
인증받을 전화번호:
<input type="text" id="tel">
<button id="b1">인증번호 받기</button>
<hr color="red">
<div id="result"></div>
결제금액:<input type="text" id="money"><br>
결제수단(1.계좌이체, 2.신용카드, 3.휴대폰결제):<input type="text" id="choice">
<button id="b2">결제하기</button>
<div id="result2"></div>
인증번호 확인:<input type="text" id="tel2">
<button id="b3">인증번호 확인</button>
<div id="result3"></div>
</body>
</html>