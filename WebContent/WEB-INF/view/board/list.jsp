<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 목록보기</title>
<link rel="stylesheet" type="text/css" href="${root}/css/board/style.css"/>
</head>
<body>
	<table width="530" align="center">
		<tr>
			<td align="right" bgcolor="D1DBDB">
				<a href="${root}/board/write.do">글쓰기</a>
			</td>
		</tr>
	</table>
	
	<c:if test="${count==0}">
		<table border="1" width="530" cellpadding="2" cellspacing="0" align="center">
			<tr>
				<td align="center">게시판에 저장된 글이 없습니다.</td>
			</tr>
		</table>
	</c:if>
	
	<c:if test="${count>0}">
		<table border="1" width="530" cellpadding="2" cellspacing="0" align="center">
			<tr> 
				<td align="center" width="30">번호</td>
				<td align="center" width="250">제목</td>
				<td align="center" width="70">작성자</td>
				<td align="center" width="100">작성일</td>
				<td align="center" width="50">조회수</td>
			</tr>
			
			<!-- Board List -->
			<c:forEach var="boardDto" items="${boardList}">
				<tr>
					<td>${boardDto.boardNumber}</td>
					<td>${boardDto.subject}</td>
					<td>${boardDto.writer}</td>
					<td>
						<fmt:formatDate value="${boardDto.writerDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>${boardDto.readCount}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br/>
	
	<!-- 페이지 번호 -->
	<center></center>
</body>
</html>