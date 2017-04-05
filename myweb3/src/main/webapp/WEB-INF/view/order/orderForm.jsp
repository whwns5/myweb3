<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>편의점 발주 시스템</h2>
<form name="order" action="order.do" method="post">
상품 1 - [이름 : <input type="text" name="itemdto[0].title"> 
/ 개수: <input type="text" name="itemdto[0].num">
/ 비고 : <input type="text" name="itemdto[0].bigo">]<br>
상품 2 - [이름 : <input type="text" name="itemdto[1].title"> 
/ 개수: <input type="text" name="itemdto[1].num">
/ 비고 : <input type="text" name="itemdto[1].bigo">]<br>
상품 3 - [이름 : <input type="text" name="itemdto[2].title"> 
/ 개수: <input type="text" name="itemdto[2].num">
/ 비고 : <input type="text" name="itemdto[2].bigo">]<br>
편의점 지점정보 : <input type="text" name="marketInfo.address"><br>
주문 담당자 : <input type="text" name="marketInfo.orderName"><br>
<input type="submit" value="발주넣기">
</form>
</body>
</html>