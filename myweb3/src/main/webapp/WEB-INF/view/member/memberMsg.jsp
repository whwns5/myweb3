<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = request.getParameter("msg");
	if(msg != null){
%>
		<script>
			window.alert('${requestScope.msg}');
		</script>
<%
	}
%>
<script>
 location.href = '${requestScope.href}';
</script>