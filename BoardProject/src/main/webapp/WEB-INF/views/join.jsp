<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会員加入ページ</title>
<script>

	function idCheck() {
		if(document.frm.userid.value=="") {
			alert("アイディーを入力してください。")
			document.frm.userid.focus();
			return;		
		}
		
		var url = "/ex/idcheck?userid="+document.frm.userid.value+"@"+document.frm.useremail.value;
		window.open(url, "_blank_1",
				"toolbar=no, menubar=no, scrollbars=yes, resizable=no,width=450, height=200");
		
		
	}


</script>
</head>
<body>
	<%
		String conPath = request.getContextPath();
	%>


	<form action = "<%=conPath %>/joinRequest" method="post" name="frm">
		<table>
			<tr>
				<td>アイディー : </td>
				<td>
					<input type="text" name = "user_email_1" id="userid"></input>@
					<select name = "user_email_2" id="useremail">
						<option>naver.com</option>
						<option>gmail.com</option>
						<option>daum.net</option>			
					</select>
				</td>
				<td>
					<input type="button" value="重複チェック" onclick="idCheck()">
				</td>
			
			</tr>
		
		</table>

		
		パスワード : <input type="password" name = "user_pw"></input>
		名前(漢字) : <input type="text" name = "user_name"></input>
		ふりがな(かたかな) : <input type="text" name = "user_katakana"></input>
		<table>
			<tr>
				<td>誕生日 </td>
				<td>
					<input type="text" name="user_birthyy" maxlength="4" placeholder="年（4席）"></input>
					<select name = "user_birthmm">
						<option value="">月</option>
						<option value="01">1</option>
						<option value="02">2</option>
						<option value="03">3</option>
						<option value="04">4</option>
						<option value="05">5</option>
						<option value="06">6</option>
						<option value="07">7</option>
						<option value="08">8</option>
						<option value="09">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>						
					</select>
					<input type="text" name="user_birthdd" maxlength="2" placeholder="日（２席）"></input>
				</td>
			</tr>

		
		</table>
		<input type = "submit" value="加入する" ></input>
		<input type = "reset" value="取り消し"></input>
	</form>
</body>
</html>