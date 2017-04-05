<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>파일 업로드 테스트</h2>
<h3>@ReqeustParam 전달 방식</h3>
<!-- 파일업로드의 조건 method = post , enctype = multipart/form-data-->
<form name="upload1" action="fileUpload1.do" method="post" enctype="multipart/form-data">
작성자 : <input type="text" name="writer"><br>
올릴파일 : <input type="file" name="upload"><br>
<input type="submit" value="파일올리기">
</form>
<hr>
<h3>MultipartHttpServletRequest 전달 방식</h3>
<!-- 파일업로드의 조건 method = post , enctype = multipart/form-data-->
<form name="upload2" action="fileUpload2.do" method="post" enctype="multipart/form-data">
작성자 : <input type="text" name="writer"><br>
올릴파일 : <input type="file" name="upload"><br>
<input type="submit" value="파일올리기">
</form>
<hr>
<h3>DTO 객체로 전달하는 방식</h3>
<!-- 파일업로드의 조건 method = post , enctype = multipart/form-data-->
<form name="upload3" action="fileUpload3.do" method="post" enctype="multipart/form-data">
작성자 : <input type="text" name="writer"><br>
올릴파일 : <input type="file" name="upload"><br>
<input type="submit" value="파일올리기">
</form>

</body>
</html>