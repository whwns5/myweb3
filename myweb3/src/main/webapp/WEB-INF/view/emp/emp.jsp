<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>사원 등록</h3>
<form name="empAdd" action="empAdd.do">
<fieldset>
	<legend>사원 등록</legend>
	<table border="1" cellspacing="0" width="350">
		<tr>
			<th>사원이름</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>E-mail</th>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<th>부서</th>
			<td><input type="text" name="dept"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="사원등록">
				<input type="reset" value="다시작성"> 
			</td>
		</tr>
	</table>
</fieldset>
</form>
<hr>
<form name="empDel" action="empDel.do">
<fieldset>
	<legend>사원 삭제</legend>
	사원 이름 : <input type="text" name="name">
	<input type="submit" value="삭제">
</fieldset>
</form>
<hr>
<h3><a href="empList.do">모든 사원 내역 보기</a></h3>
<hr>
<form name="empSearch" action="empSearch.do">
<fieldset>
	<legend>사원 검색</legend>
	사원 번호 : <input type="text" name="idx">
	<input type="submit" value="검색">
</fieldset>
</form>
<hr>
<form name="empUpdate" action="empUpdate.do">
<fieldset>
	<legend>사원 수정</legend>
	사원 번호 : <input type="text" name="idx">
	<input type="submit" value="검색">
</fieldset>
</form>

</body>
</html>