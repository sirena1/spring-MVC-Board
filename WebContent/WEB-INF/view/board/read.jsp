<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 읽기</title>
<script type="text/javascript" src="${root}/javascript/board/script.js"></script>
<link rel="stylesheet" type="text/css" href="${root}/css/board/style.css"/>
</head>
<body>
	<table border="1" width="510" cellpadding="2"  cellspacing="0" align="center">
		<tr>
			<td align="center"  height="20" width="125">글번호</td>
			<td align="center"  height="20" width="125">${boardDto.boardNumber}</td>
			
			<td align="center"  height="20" width="125">조회수</td>
			<td align="center"  height="20" width="125">${boardDto.readCount}</td>
		</tr>
		
		<tr>
			<td align="center"  height="20" width="125">작성자</td>
			<td align="center"  height="20" width="125">${boardDto.writer}</td>
			
			<td align="center"  height="20" width="125">작성일</td>
			<td align="center"  height="20" width="125">
				${boardDto.writeDate}
			</td>
		</tr>
		
		<tr>
			<td align="center"  height="200" width="125">글내용</td>
			<td valign="top"  height="200" colspan="3">${boardDto.content}</td>
		</tr>
		
		<tr>
			<td height="30" colspan="4" align="center">
				<input type="button" value="글수정" onclick=" " />
				<input type="button" value="글삭제" onclick=" "/>
				<input type="button" value="답글" onclick=" "/>
				<input type="button" value="글목록" onclick=" "/>
			</td>
		</tr>
	</table>
</body>
</html>