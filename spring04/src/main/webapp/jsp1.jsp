<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function idCheck(){
	//id에 입력한 값을 가지고 와서 글자수가 5 미만이면 다시 작성하세요. 메시지
	//Documemt document = new Document();
	//미리 객체를 생성해놨음. -> 내장된 객체
	//window:브라우저 전체
	//document: body태그 부분
	//console: 개발할대 확인하는 창 (f12)
	//location: 주소부분, location.href=""
	//history: 탐색 history
	idValue = document.getElementById("id").value;
	idCheckResult = document.getElementById("idCheckResult");
	if(idValue.length < 5){
		console.log("5미만입니다.");
		result = "5글자 미만입니다. 재입력해주세요";
		idCheckResult.style.color = "red";
		document.getElementById("id").value="";	
		document.getElementById("id").focus();
		
	}else{
		result = "5글자 이상입니다. 유효합니다";
		idCheckResult.style.color = "green";
	}
	idCheckResult.innerHTML=result;
}
function pwCheck(){
	pwCheckResult = document.getElementById("pwCheckResult");
	if(document.getElementById("pw1").value == document.getElementById("pw2").value){
		text = "<span style='color:blu'>비밀번호가 일치합니다</span>";
		img = "<img src='resources/img/ok.jpg'height='100' width='100'>";
		//pwCheckResult.style.color = "blue";
	}else{
		text = "<span style='color:red'>비밀번호가 불일치합니다</span>";
		img = "<img src='resources/img/no.png' height='100' width='100'>"
		//pwCheckResult.style.color = "red";
		document.getElementById("pw1").focus();
		document.getElementById("pw1").value="";
		document.getElementById("pw2").value="";
		
	}
	pwCheckResult.innerHTML=text+img;
}
</script>
</head>
<body>
	<h3>자바 스크립트 테스트</h3>
	<hr>
	아이디 :
	<input name="id" id="id" value="text">
	<br>
	<button onclick="idCheck()">아이디 체크</button>
	<br>
	<div id="idCheckResult"></div>
	패스워드1:
	<input name="pw1" id="pw1" value="1234">
	<br> 패스워드2:
	<input name="pw2" id="pw2" value="1234">
	<br>
	<button onclick="pwCheck()">비밀번호 확인</button>
	<div id="pwCheckResult"></div>
	<hr>

</body>
</html>