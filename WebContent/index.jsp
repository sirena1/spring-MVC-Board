<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}"/>
	<h3>Spring MVC Start!!!!</h3>
	
	<a href="${root}/board/write.do">게시판 작성</a>
	<a href="${root}/board/list.do">글목록</a>
</body>
</html>