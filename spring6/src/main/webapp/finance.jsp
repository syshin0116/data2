<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="red">
<h3>주식 정보 시스템입니다.</h3>
<hr>

<form action="stock.do">
code : <input name="code"><br>
<button>code로 네이버에서 크롤링하여 db에 저장</button>
</form>
<hr color=yellow>
<a href="stock.do?code=018260">
<button>삼성SDS</button>
</a>
<a href="stock.do?code=034220">
<button>LG Display</button>
</a>
<a href="stock.do?code=005380">
<button>현대자동차</button>
</a>

<hr>
<form action="create.do">
code : <input name="code"><br>
company : <input name="company"><br>
today : <input name="today"><br>
yesterday : <input name="yesterday"><br>
high : <input name="high"><br>
<button>db에 저장</button>
</form>
</body>
</html>