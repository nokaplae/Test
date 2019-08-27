<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ログインページ</title>
<script>
function loginCheck() {
	
	// IDの存在チェック 
	if(document.frm.userid.value.length==0) {
		alert("アイディーを書いてください");
		frm.userid.focus();
		return false;
	}	
	
	// IDの最小の長さ
	if(document.frm.userid.value.length < 4) {
		alert("アイディーは４文字以上書いてください");
		frm.userid.focus();
		return false;
	}	
	
	var str = document.frm.userid.value;
	var idReg = /^[A-Za-z0-9]*$/;
	if(!idReg.test(str)) {
		alert("IDは数字と英字だけ使用できます");
		frm.userid.focus();
		return false;
	}
	
	/* パスワードの存在チェック */
	if(document.frm.pwd.value == "") {
		alert("パスワードを書いてください");
		frm.pwd.focus();
		return false;
	}	
	
}


</script>

</head>
<body>
	
	<form action = "${pageContext.request.contextPath}/loginRequest" method = "post" name="frm">
	
		<table>
			<tr>
				<td>アイディー</td>
				<td><input type="text" name="user_email_1" id="userid" value="${userid}">
					<select name = "user_email_2" id="useremail">
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="daum.net">daum.net</option>			
					</select>
				</td>
			</tr>
				
			<tr>
				<td>パスワード</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			
		</table>	
				<input type = "submit" value="ログイン" onclick = "return loginCheck()">
				<input type = "reset" value="取り消し">
				<input type = "button" value = "会員加入" onclick="location.href='/ex/join'">
				<input type = "button" value = "アイディー探し">
				<input type = "button" value = "パスワード探し">
				<br>
				${message}
	</form>
	
	
	
</body>
</html>