<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	window.alert('${requestScope.msg}');
	opener.memberJoin.id.value = '${requestScope.id}';
	window.self.close();
</script>