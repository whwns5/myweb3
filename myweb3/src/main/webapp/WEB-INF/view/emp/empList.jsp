<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>모든 사원 내역 보기</h2>
<table border="1" cellspacing="0" width="450">
	<thead>
	<tr>
		<th>사원 번호</th>
		<th>사원 이름</th>
		<th>이메일</th>
		<th>부서명</th>
	</tr>
	</thead>
	<c:set var="list" value="${empList}"/>
	<c:if test="${empty empList}">
		<tr>
			<td colspan="4" align="center">등록된 사원이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.idx}</td>
			<td>${dto.name}</td>
			<td>${dto.email}</td>
			<td>${dto.dept}</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>