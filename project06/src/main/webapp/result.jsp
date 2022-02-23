<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Download</title>
</head>
<body>
<c:forEach var = "file" items="${file_list}" varStatus = "status">
<a href= "/project06/download?fileName=${file.filename}">${file.filename}</a><br/>
</c:forEach>
<button type="button" onclick="location.href='${contextPath}/uploadForm.jsp'">파일 업로드</button>
</body>
</html>