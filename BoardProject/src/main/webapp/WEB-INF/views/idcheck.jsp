<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アイディーチェックページ</title>
<script>

	function idok() {
		
		var a = document.frm.userid.value;
		var array = a.split("@");
		
		opener.frm.userid.value = array[0];
		opener.frm.reid.value = document.frm.userid.value; 
		self.close();
		
	}
	
	function idCheck() {
		// IDの存在チェック 
		if(document.frm.userid.value=="") {
			alert("アイディーを入力してください。")
			document.frm.userid.focus();
			return;		
		}
		
		// IDの最小の長さ
		if(document.frm.userid.value.length < 4) {
			alert("アイディーは４文字以上書いてください");
			frm.userid.focus();
			return;
		}	 
		
		// IDの含める文字チェック
		var str = document.frm.userid.value;
		var idReg = /^[A-Za-z0-9]*$/;
		if(!idReg.test(str)) {
			alert("IDは数字と英字だけ使用できます");
			frm.userid.focus();
			return;
		}
	}

</script>
</head>
<body>
	<h2>アイディー重複確認</h2>
	<form action="/ex/idcheck" method="get" name = "frm">
		아이디:<input type="text" name="userid" value="${userid}" maxlength="15">
		<input type="submit" value="重複チェック" onclick="idCheck()">
		<br>
	
		<c:if test="${result == true}">
			<script type="text/javascript">
				opener.document.frm.userid.value="";
			</script>
			${userid} はもう使用中のアイディーです。

		</c:if>
		<c:if test="${result==false}">
			${userid}　は使用できるアイディーです。
			<input type="button" value="使用" class="cancel" onclick="idok()">
		</c:if>
	
	</form>
	
	
	
</body>
</html>