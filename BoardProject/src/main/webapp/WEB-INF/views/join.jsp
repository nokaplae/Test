<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会員加入ページ</title>
<script>
	
	//　ラジオボタンに従って名前、カタカナを選択
	function showDiv(id) {
		document.frm.user_name.style.visibility='hidden';
		document.frm.user_katakana.style.visibility='hidden';
	    document.frm.user_name.value = ''; 
	    document.frm.user_katakana.value = ''; 
	    document.frm[id].style.visibility = 'visible'; 
	    document.frm[id].focus(); 
	}

	
	//　IDを作る前の検査
	function joinCheck() {
		
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
		
		// IDの重複チェック
		if(document.frm.reid.value.length==0) {
			alert("重複チェックはしないです");
			frm.userid.focus();
			return false;
		}
		
		/* パスワードの存在チェック */
		if(document.frm.user_pwd.value == "") {
			alert("パスワードを書いてください");
			frm.user_pwd.focus();
			return false;
		}	
		
		/* パスワードの再確認*/
		if(document.frm.user_pwd.value != document.frm.pwd_check.value) {
			alert("パスワードは一致しないです");
			frm.user_pwd.focus();
			return false;
		}	
		
		
		/* 名前とかたかなチェック */
		var names = document.getElementsByName('radiobutton');
		var name_value;
		
		for(var i=0; i<names.length; i++) {
			
			if(names[i].checked) {
				name_value= names[i].value;
			}
		}
		
		/* ラジオボタンに従って名前とカタカナの存在チェック*/
		if(name_value == 1) {
			if(document.frm.user_name.value == "") {
				alert("名前を書いてください");
				frm.user_name.focus();
				return false;
			}
		} else if(name_value==2) {
			if(document.frm.user_katakana.value == "") {
				alert("カタカナを書いてください");
				frm.user_katakana.focus();
				return false;
			}
			
		} else {
			alert("名前とカタカナを選択ください");
			return false;
		}
		
		
				
		/* 年の存在チェック */
		if(document.frm.user_birthyy.value.length==0) {
			alert("年を書いてください");
			frm.user_birthyy.focus();
			return false;
		}
		
		
		/* 月の存在チェック */
		if(document.frm.user_birthmm.value == "") {
			alert("月を選択ください");
			frm.user_birthmm.focus();
			return false;
		}
		

		/* 日の存在チェック */
		if(document.frm.user_birthdd.value.length==0) {
			alert("日を書いてください");
			frm.user_birthdd.focus();
			return false;
		}　
		
		return true;
		
	}

	// IDの重複チェック
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
		var idReg = /^[a-zA-Z]+[a-z0-9A-Z]$/g;

		if(!idReg.test(str)) {
			alert("IDは数字と英字だけ使用できます");
			frm.userid.focus();
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
					<input type="text" name = "user_email_1" id="userid" value="${member.user_email_1 }" ></input>@
					<input type="hidden" name = "reid">
					<select name = "user_email_2" id="useremail">
						<option value="naver.com" <c:if test="${member.user_email_2 == naver.com}">selected</c:if>>naver.com</option>
						<option value="gmail.com"<c:if test="${member.user_email_2 == 'gmail.com'}">selected</c:if>>gmail.com</option>
						<option value="daum.net"<c:if test="${member.user_email_2 == 'daum.net'}">selected</c:if>>daum.net</option>			
					</select>
				</td>
				<td>
					<input type="button" value="重複チェック" onclick="idCheck()">
				</td>
			
			</tr>
		
		</table>

		
		パスワード : <input type="password" name = "user_pwd"></input> <br>
		パスワード確認 : <input type="password" name = "pwd_check"></input> <br>
		
		名前(漢字)<input type="radio" name="radiobutton" value ="1" onclick="showDiv('user_name')">  <input type="text" name = "user_name"  style= "visibility:hidden"></input> <br>
		ふりがな(かたかな)<input type="radio" name="radiobutton" value = "2" onclick="showDiv('user_katakana')"> <input type="text" name = "user_katakana"  style= "visibility:hidden"> <br>
		
<!-- 		名前(漢字) : <input type="text" name = "user_name"></input> <br>
		ふりがな(かたかな) : <input type="text" name = "user_katakana" disabled="disabled"></input> <br> -->
		<table>
			<tr>
				<td>誕生日 </td>
				<td>
					<input type="text" name="user_birthyy" maxlength="4" placeholder="年（4席）"></input>
					<select name = "user_birthmm" >
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
		<input type = "submit" value="加入する" onclick="return joinCheck()"></input>
		<input type = "reset" value="取り消し"></input>
	</form>
</body>
</html>