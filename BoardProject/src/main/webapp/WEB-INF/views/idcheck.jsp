<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アイディーチェックページ</title>
</head>
<body>
	<h2>アイディー重複確認</h2>
	<form action="/ex/idcheck" method="get" name = "frm">
		아이디:<input type="text" name="userid" value="<%=request.getParameter("userid")%>">
		<input type="submit" value="重複チェック">
		<br>
	
		<c:if test="${result == 1}">
			<script type="text/javascript">
				opener.document.frm.userid.value="";
			</script>
			${userid} はもう使用中のアイディーです。

		</c:if>
		<c:if test="${result==-1}">
			${userid}　は使用できるアイディーです。
			<input type="button" value="使用" class="cancel" onclick="idok()">
		</c:if>
	
	</form>
	
	
	
</body>
</html>