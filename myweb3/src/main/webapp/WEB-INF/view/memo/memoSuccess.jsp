<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>메모 작성 완료!</h2>
<%-- <h3>번호 : ${memoDTO.idx}</h3>
<h3>제목 : ${memoDTO.title}</h3>
<h3>내용 : ${memoDTO.content}</h3> --%>
<h3>번호 : ${cmd.idx}</h3>
<h3>제목 : ${cmd.title}</h3>
<h3>내용 : ${cmd.content}</h3>
</body>
</html>