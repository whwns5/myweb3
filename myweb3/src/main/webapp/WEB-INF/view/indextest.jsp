<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function showLogin() {
	window.open('memberLogin.do','memberLogin','width=370,height=230,left=600,top=400');
}
function logOut(){
	location.href = 'memberLogOut.do';
}
</script>
</head>
<body>
<h4 style="text-align: right;">
<c:set var="login_id" value="${sessionScope.login_mdto.id}"/>
<c:set var="login_name" value="${sessionScope.login_mdto.name}"/>
<c:choose>
	<c:when test="${empty login_id}">
		<a href="javascript:showLogin();">로그인</a> | 
		<a href="memberJoin.do">회원가입</a>
	</c:when>
	<c:otherwise>
		${login_name} 님 환영합니다. | 
		<a href="javascript:logOut();">로그아웃</a>
	</c:otherwise>
</c:choose>
</h4>
<h2>Index</h2>
<ul>
	<li><a href="bbsList.do">마지막 자유게시판</a></li>
	<li><a href="emp.do">마지막 사원관리 프로그램</a></li>
	<li><a href="fileDownList.do">파일 목록 다운</a></li>
	<li><a href="fileUploadForm.do">파일업로드 테스트</a></li>
	<li><a href="aniFindA.do">애니메이션 검색</a></li>
	<li><a href="hello.do?cp=1">SpringMVC</a></li>
	<li><a href="memoWrite.do">메모 작성하기</a></li>
	<li><a href="order.do">편의점 발주시스템</a></li>
	<li><a href="paramTest.do?idx=3&str=spring">파라미터 테스트</a></li>
	<li><a href="paramTest2.do?idx=3&str=spring">파라미터 테스트2</a></li>
	<li><a href="cookieView.do">쿠키값 확인하기</a></li>
	<li><a href="cookieMake.do">쿠키값 저장하기</a></li>
	<li><a href="sessionView.do">세션 확인하기</a></li>
	<li><a href="sessionMake.do">세션 저장하기</a></li>
	<li><a href="viewTest1.do">명시적 뷰지정</a></li>
	<li><a href="viewTest2.do">명시적 뷰지정2</a></li>
	<li><a href="view/viewTest.do">묵시적 뷰지정</a></li>
	<li><a href="viewTest4.do">컨트롤러에서 다른 명령어 바로 실행하기</a></li>
	<li><a href="modelTest1.do">모델 테스트1(Map)</a></li>
	<li><a href="modelTest2.do">모델 테스트2(Model)</a></li>
	<li><a href="modelTest3.do">모델 테스트3(ModelMap)</a></li>
	<li><a href="model/modelSuccess.do">모델 테스트4(Map 반환)</a></li>
	<li><a href="model/modelSuccess.do">모델 테스트5(Model 반환)</a></li>
</ul>

</body>
</html>


