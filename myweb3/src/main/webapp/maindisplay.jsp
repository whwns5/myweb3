<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/reset.min.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script>
function goUpdate(){
	
}
</script>
</head>
<body>
<div class="body_content">
	<%@ include file="/WEB-INF/view/menu.jsp"%>
	<div class="box_right">
		<div class="tit f_bold">
			<img alt="icon" src="image/icon.gif"> 사원조회
		</div>
		<div class="float_r main_search">
			<select name="select">
				<option selected>::::: 전체 :::::</option>
			</select> 
			<input name="textfield" type="text" class="input"> <a href="#"><img alt="search" src="image/search.gif"></a>
		</div>
		<div class="main_box clear_b">
			<div class="main_tab main_top">
				<img alt="all_icon" src="image/all_icon.gif"> <a href="#">수정</a> 
				<img alt="all_icon" src="image/all_icon.gif"> <a href="#">인사기록카드</a> 
				<img alt="all_icon" src="image/all_icon.gif"> <a href="#">경력정보</a> 
				<img alt="all_icon" src="image/all_icon.gif"> <a href="#">근무정보</a>
			</div>
			<!-------------------------  리스트 ------------------------------>
			<table>
				<tr>
					<th width="35px"></th>
					<th width="85px">이름</th>
					<th width="153px">주민번호</th>
					<th width="91px">성별</th>
					<th width="91px">기술등급</th>
					<th width="91px">입사유형</th>
					<th width="94px">근무여부</th>
				</tr>
				<c:forEach var="dto" items="${arry_mater}">
					<tr><td colspan="7" class="main_bar"></td></tr>
					<tr>
						<td><input type="checkbox" name="checkbox" value="checkbox"></td>
						<td>${dto.kor_name}</td>
						<td>${dto.jumin_no}</td>
						<td>
							<c:if test="${dto.sex eq 1}">남자</c:if>
							<c:if test="${dto.sex eq 2}">여자</c:if>
						</td>
						<td>${dto.tech_grd}</td>
						<td>
							<c:if test="${dto.join_st eq 0}">정규직</c:if>
							<c:if test="${dto.join_st eq 1}">계약직</c:if>
						</td>
						<td></td>
					</tr>
					<tr><td colspan="7" class="main_bar"></td></tr>
				</c:forEach>
				
				<!-- <tr><td colspan="7" class="main_bar"></td></tr>
				<tr>
					<td><input type="checkbox" name="checkbox" value="checkbox"></td>
					<td>홍길동</td>
					<td>123456-1234567</td>
					<td>남</td>
					<td>중급</td>
					<td>정규직</td>
					<td>근무</td>
				</tr>
				<tr><td colspan="7" class="main_bar"></td></tr>
				<tr>
					<td><input type="checkbox" name="checkbox2" value="checkbox"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr><td colspan="7" class="main_bar"></td></tr>
				<tr>
					<td><input type="checkbox" name="checkbox3" value="checkbox"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr><td colspan="7" class="main_bar"></td></tr>
				<tr>
					<td><input type="checkbox" name="checkbox4" value="checkbox"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr><td colspan="7" class="main_bar"></td></tr>
				<tr>
					<td><input type="checkbox" name="checkbox5" value="checkbox"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr><td colspan="7" class="main_bar"></td></tr>
				<tr>
					<td><input type="checkbox" name="checkbox6" value="checkbox"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr><td colspan="7" class="main_bar"></td></tr>
				<tr>
					<td><input type="checkbox" name="checkbox7" value="checkbox"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr><td colspan="7" class="main_bar"></td></tr>
				<tr>
					<td><input type="checkbox" name="checkbox8" value="checkbox"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr><td colspan="7" class="main_bar"></td></tr>
				<tr>
					<td><input type="checkbox" name="checkbox9" value="checkbox"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr><td colspan="7" class="main_bar"></td></tr>
				<tr>
					<td><input type="checkbox" name="checkbox10" value="checkbox"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr><td colspan="7" class="main_bar"></td></tr> -->
			</table>
			<div class="main_paging">
				<a href="#"><img alt="prev_more" src="image/prev.gif"></a>
				<a href="#"><img alt="prev" src="image/pre.gif"></a>
				&nbsp; 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 &nbsp;
				<a href="#"><img alt="next" src="image/next.gif"></a>
				<a href="#"><img alt="next_more" src="image/next_.gif"></a>
			</div>
			<!-------------------------  리스트 ------------------------------>
			<div class="main_tab main_bottom">
				<img alt="all_icon" src="image/all_icon.gif"> <a href="goUpdate()">수정</a> 
				<img alt="all_icon" src="image/all_icon.gif"> <a href="#">인사기록카드</a> 
				<img alt="all_icon" src="image/all_icon.gif"> <a href="#">경력정보</a> 
				<img alt="all_icon" src="image/all_icon.gif"> <a href="#">근무정보</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>