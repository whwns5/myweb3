<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 수정</h2>
<form name="empUpdate" action="empUpdate.do" method="post">
번호 : <input type="text" name="idx" value="${edto.idx}" readonly="readonly"><br>
이름 : <input type="text" name="name" value="${edto.name}" ><br>
E-MAIL : <input type="text" name="email" value="${edto.email}"><br>
E-MAIL : <input type="text" name="email" value="${dto2.email}"><br>
부서 : <input type="text" name="dept" value="${dto3.dept}"><br>
<input type="submit" value="수정">
</form>
</body>
</html>