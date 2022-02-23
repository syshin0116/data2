<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드</title>
<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>

</head>
<body>
	<form action="${contextPath}/upload" method="post" enctype="multipart/form-data">
		파일1 : <input type="file" name="file1"><br/>
		파일2 : <input type="file" name="file2"><br/>
		파리터1 : <input type="text" name="param1"><br/>
		파리터2 : <input type="text" name="param2"><br/>
		파리터3 : <input type="text" name="param3"><br/>
		
		<input type="submit" value="업로드">
			
	</form>
</body>
</html>