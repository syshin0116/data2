<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css"/>
<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
<script>
// 초기화
	$(function() {
		 
		
		$("#btn_save").click(function() {
			if($("#id").val() == '') {
				alert("아이디을 입력해주세요.");
				$("#id").focus();
				return;
			}
			if($("#title").val() == '') {
				alert("제목을 입력해주세요.");
				$("#title").focus();
				return;
			}
			if($("#context").val() == '') {
				alert("내용 확인을 입력해주세요.");
				$("#context").focus();
				return;
			}
			$('#frmBoard').submit();
		});
		
		/*
			$("#btn_idcheck").click(function() {
			// jquery Ajax
			if($('#m_id').val() == '') {
				alert('아이디를 입력해주세요.');
				return;
			}
			
			
			$.ajax({ 
				url : '${contextPath}/idCheck',
				data: {'check_id':$('#m_id').val()},
				method:'get',
				beforeSend : function(){
		           //URL 전송전에 작업할 내용
		           // console.log('beforeSend');
		        },
		        success:function(data) {
		        	console.log("data:"+data);
		        	//성공적으로 URL 전송하고 난 내용
		        	if(data == "false") {
		        		if(confirm("아이디를 사용하시겠습니까?")) {
		        			$('idcheck').val('1');
		        			$('#m_id').attr('readonly', true);
		        			}
		        	}
		        		else {
		        			alert("아이디를 사용할 수 없습니다.")
		        		}
		        	},
		        	error : function() {
		        		
		        	},
		        	complete: function() {
		        		
		        	}
			});
			*/
	});
</script>
</head>
<body>
<div class="container">
	<div class="section">
	<h2>회원가입</h2>
<table class="bluetop">
			<form action="insert.jsp" method="post" id="frmBoard">
			<input type="hidden" name="idcheck" id="idcheck" value="0"/>
				<tr>
					<th>아이디</th>
						<td>
						<input type="text" name="id" id="id">
					</td>
				</tr>
				
				<tr>
				<th>제목</th>
				<td><input type="text" name="title" id="title"></td>
				</tr>
				
				<tr>
				<th>내용</th>
				<td><textarea name="context" id="context" rows="50" cols="110">내용을 입력하세요.</textarea></td>
				</tr>
				</form>
			</table>
			<div class="btns">
				<button type="button" class="btn_style_submit" id="btn_save">등록</button>
			</div>
		</div>
	</div>

</body>
</html>