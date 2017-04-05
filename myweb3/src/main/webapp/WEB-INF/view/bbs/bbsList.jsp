<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>자유 게시판</h2>
<table width="550" border="1" cellspacing="0" bordercolor="blue">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
	<c:if test="${empty lsit}">
		<tr>
			<td colspan="4">등록된 게시글이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.idx}</td>
			<td>${dto.subject}</td>
			<td>${dto.writer}</td>
			<td>${dto.readnum}</td>
		</tr>
	</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="3" align="center">
				${pageStr}
			</td>
			<td>글쓰기</td>
		</tr>
	</tfoot>

</table>
</body>
</html>