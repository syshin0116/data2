<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
//아이디가 b1인 것을 클릭했을때가로안에 넣은 이름없는 함수를 실행해주렴.
	$(function() {//body를 먼저 읽고 와서 메모리에 don tree로 읽어들이면  함수의내용대로 처리해주렴.
		$('#b1').click(function() {
			idValue = $('#id').val();
			if(idValue.length<5){
				$('#idCheckResult').html('유효하지 않은 아이디.');
				//append(): 댓글처럼 꼐속 끝에 붙임.
				//html(): 태그가 있는 조각 html코드 일부분으로 대체
				//text(): 태그가 없는 텍스트만
				$('#id').val('');
				$('#id').focus();
				$('#idCheckResult').css("color", "red");
			}else{
				$('#idCheckResult').html('유효한 아이디.');
				$('#idCheckResult').css("color", "green");
			}
		})
		$('#b2').click(function(){
			pw1Value = $('#pw1').val();
			pw2Value = $('#pw2').val();
			if(pw1Value == pw2Value){
				$('#pwCheckResult').html('비밀번호가 같습니다.');
				$('#pwCheckResult').css("color", "green");
			}else{
				$('#pwCheckResult').html('비밀번호가 다릅니다.');
				$('#pwCheckResult').css("color", "red");
				
			}
		})
	})
	
</script>
</head>
<body>
	<h3>자바 스크립트 테스트</h3>
	<hr>
	아이디 :<input name="id" id="id" value="text"><br>
	<button id="b1">아이디 체크</button><br>
	<div id="idCheckResult"></div>
	패스워드1:<input name="pw1" id="pw1" value="1234"><br> 
	패스워드2:<input name="pw2" id="pw2" value="1234"><br>
	<button id="b2">비밀번호 확인</button>
	<div id="pwCheckResult"></div>
	<hr>
</body>
</html>

