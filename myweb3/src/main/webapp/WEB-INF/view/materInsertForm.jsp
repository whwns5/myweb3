<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/reset.min.css?ver=5" rel="stylesheet" type="text/css">
<link href="css/style.css?ver=5" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/myweb3/js/jquery-3.2.1.min.js"></script>
<script>
window.onload = function(){
	
	selectProfile();
}
function selectProfile(){
	$('#inputImage').on('change', function() {
  	        
  	        ext = $(this).val().split('.').pop().toLowerCase(); //확장자
  	        
  	        if($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1) {
  	            resetFormElement($(this)); //폼 초기화
  	            window.alert('이미지 파일이 아닙니다! (gif, png, jpg, jpeg 만 업로드 가능)');
  	        } else {
  	            file = $('#inputImage').prop("files")[0];
  	            blobURL = window.URL.createObjectURL(file);
  	            $('#profile_img').attr('src', blobURL);
  	        }
  	        return false;
  	    });
}
function goInsert(){
	// 주민번호 세팅
	$('#jumin_no').val($('#first_jumin_no').val() + '-' + $('#second_jumin_no').val());
	// 생년월일 세팅
	$('#birth_ymd').val($('#first_birth_ymd').val() + $('#second_birth_ymd').val() + $('#third_birth_ymd').val());
	// 주소 세팅
	$('#addr').val($('#first_addr').val() + '+' + $('#second_addr').val());
	// 연락처 세팅
	$('#tel').val($('#first_tel').val() + '-' + $('#second_tel').val() + '-' + $('#third_tel').val());
	
	$('#insertForm').submit();
}
function goBack(){
	location.href = 'projectMain.do';
}
</script>
</head>
<body>
<div class="body_content">
	<%@ include file="/WEB-INF/view/menu.jsp"%>
	<div class="box_right">
		<div class="tit f_bold">
			<img alt="icon" src="image/icon.gif"> 사원 기본 정보 수정
		</div>
		<div class="page_menu f_bold">
			<ul class="li_left">
				<li><a href="#">교육정보</a></li>
				<li>|</li>
				<li><a href="#">자격증. 보유기술정보</a></li>
				<li>|</li>
				<li><a href="#">프로젝트 정보</a></li>
				<li>|</li>
				<li><a href="#">경력정보</a></li>
				<li>|</li>
				<li><a href="#">근무정보</a></li>
			</ul>
		</div>
		<form id="insertForm" action="mateInsert.do" method="post" enctype="multipart/form-data">
		<div class="page_box">
			<div class="page_in float_h">
				<div class="picture_pr float_l"><img alt="증명사진" id="profile_img" style="width:100px;height: 110px;" src=""></div>
				<div class="page_mar2 float_l">
					<div class="page_mar1">
						<label class="page4_1">한글이름 : </label>
						<input type="text" name="kor_name" value="">
					</div>
					<div class="page_mar1">
						<label class="page4_1">영문이름 : </label>
						<input type="text" name="eng_name" value="">
					</div>
					<div class="page_mar1">
						<label class="page4_1">한문이름: </label>
						<input type="text" name="han_name" value="">
					</div>
					<div class="page_mar1">
						<label class="page4_1">주민등록번호 : </label>
						<input id="first_jumin_no" type="text" size="6" maxlength="6" value=""> - 
						<input id="second_jumin_no" type="text" size="7" maxlength="7" value="">
						<input type="hidden" name="jumin_no" id="jumin_no" value="0">
					</div>
				</div>
			</div>
			<div class="page_in clear_b">
				<div class="page_line page_mar1">
					<label class="page4_1">일련번호 : </label>
					<input name="user_no" type="text" size="40" value="">
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">사진파일명 : </label>
					<input name="sajin_nm" type="text" size="40" value="">
					<label for="inputImage" class="btn_model"><img src="image/bt_search.gif" width="49" height="18"></label>
                    <input type="file" style="display: none;" id="inputImage" name="upload"  accept="image/*" />
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">생년월일 : </label>
					<input id="first_birth_ymd" type="text" size="8" value=""> 년 
					<input id="second_birth_ymd" type="text" size="5" value=""> 월 
					<input id="third_birth_ymd" type="text" size="5" value=""> 일 ( 
					<input type="radio" name="birth_rn" value="1" checked> 양력 
					<input type="radio" name="birth_rn" value="0"> 음력 )
					<input type="hidden" name="birth_ymd" id="birth_ymd">
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">성별 : </label>
					<input type="radio" name="sex" value="1" checked> 남자 <input type="radio" name="sex" value="2"> 여자
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">결혼유무 : </label>
					<input type="radio" name="marry_yn" value="0" checked> 미혼 <input type="radio" name="marry_yn" value="1"> 기혼
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">년차 : </label>
					<input name="work_year" type="text" size="10" value="">
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">급여 지급유형 : </label>
					<select name="select">
						<option>월급</option>
					</select>
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">희망직무 : </label>
					<select name="hope_work">
						<option value="0" selected>SI</option>
						<option value="1">SM</option>
					</select>
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">입사유형 : </label>
					<select name="join_st">
						<option value="0" selected>정규직</option>
						<option value="1">계약직</option>
					</select>
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">주소 : </label>
					<input id="first_addr" type="text" size="10" value=""> 
					<input id="second_addr" type="text" size="40" value="">
					<input type="hidden" id="addr" name="addr">
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">연락처 : </label>
					<input id="first_tel" type="text" size="10" value=""> - 
					<input id="second_tel" type="text" size="10" value=""> - 
					<input id="third_tel" type="text" size="10" value="">
					<input type="hidden" name="tel" id="tel">
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">이메일 : </label>
					<input name="email" type="text" size="20" value="">
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">기술등급 : </label>
					<input name="tech_grd" type="text" size="20" value="">
				</div>
				<div class="page_mar1">
					<label class="page4_1">주량 : </label>
					<input name="alc_qt" type="text" size="20" value="">
				</div>
			</div>
			<div class="btn_all">
				<button type="button" onclick="goInsert()"><img alt="insert" src="image/bt_enter.gif"></button>
				<button type="button" onclick="goBack()"><img alt="cancel" src="image/bt_cancel.gif"></button>
			</div>
		</div>
		</form>
	</div>
</div>

</body>
</html>