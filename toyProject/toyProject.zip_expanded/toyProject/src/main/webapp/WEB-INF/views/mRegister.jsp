<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
	<hr>
			<h3 class="active">회원가입</h3>
			<form action="create">
				<table>
					<tr>
						<td class="left">아이디</td>
						<td class="right"><input  class="form-control input-lg"  type="text" name="mId"></td>
					</tr>
					<tr>
						<td class="left">패스워드</td>
						<td class="right"><input  class="form-control input-lg"  type="text" name="mPw"></td>
					</tr>
					<tr>
						<td class="left">이메일</td>
						<td class="right"><input  class="form-control input-lg"  type="text" name="mEmail"></td>
					</tr>
					<tr>
						<td class="left">전화번호</td>
						<td class="right"><input  class="form-control input-lg"  type="text" name="mPhone"></td>
					</tr>
					<tr>
						<td colspan="2">
						<button style="width:200px; height:50px;" class="btn btn-success" type="submit">회원가입하기</button>
						</td>
					</tr>
				</table>
			</form>
			<hr>
</body>
</html>