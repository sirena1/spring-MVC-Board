<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${root}/jquery/jquery-3.4.1.js"></script>
</head>
<body>
	
	<c:if test="${check > 0}">
		<script type="text/javascript">
			alert("게시판 글이 작성 되었습니다.");
			$(location).attr("href","${root}/board/write.do");
		</script>
	</c:if>
	
	<c:if test="${check == 0}">
		<script type="text/javascript">
			alert("게시판 글이 작성 되지 않았습니다.");
			$(location).attr("href","${root}/board/write.do");
		</script>
	</c:if>
</body>
</html>