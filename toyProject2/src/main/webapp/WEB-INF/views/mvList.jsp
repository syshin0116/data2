<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상영 영화</title>
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function(){
		$('#ticketBtn').click(function() {

		})//btn
	})
</script>
</head>
<body>
	<c:forEach items="${mvList}" var="one">
		<div class="sect-movie-chart">
			<div id="movie" style="float: left; width: 20%; text-align: center;">
				<a href="mvOne?mvId=${one.mvId}"><img src="${one.mvImg}"
					style="width: 55%"></a>


				<div class="movieContents"
					style="display: flex; justify-content: center;">
					<table>
						<tr>
							<td style="text-align: left"><a
								href="mvOne?mvId=${one.mvId}">${one.mvTitle}</a>
								<p>평점: ${one.mvRating}</p>
								<p>상영시간: ${one.mvTime}</p>
								<p>상영관: ${one.mvSection}</p>
								<button id="ticketBtn" onclick="location.href='tInsert.jsp?mvId=${one.mvId}'">예매</button>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</c:forEach>

</body>
</html>