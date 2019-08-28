<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty loginUser}">
	<jsp:forward page="/login"/>
</c:if>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>掲示板ぺーじ</title>
</head>
<body>
	<h2>会員専用ページ</h2>
	
	<form action="${pageContext.request.contextPath}/logoutRequest">
		<table>
			<tr>
				<td>
					おはようございます。${loginUser.user_name}${loginUser.user_katakana}(${loginUser.user_id})様
				</td>
			</tr>
		
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="ログアウト"> &nbsp;
					<input type="button" value="会員情報変更" onclick="location.href='/ex/updateRequest?userid=${loginUser.user_id}'">
					<input type="button" value="会員脱退">
				</td>
			</tr>
			
	
		
		</table>
	</form>	
	
	

	<br>
	掲示板ぺーじです。
</body>
</html>