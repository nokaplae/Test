<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会員情報変更ページ</title>
<script>

	function showDiv(id) {
		document.frm.user_name.style.visibility='hidden';
		document.frm.user_katakana.style.visibility='hidden';
	    document.frm.user_name.value = ''; 
	    document.frm.user_katakana.value = ''; 
	    document.frm[id].style.visibility = 'visible'; 
	    document.frm[id].focus(); 
	}
	
	function a() {
		
		alert("aaa");
	}
	
	function goBack() {
		
		window.history.back();
		
	}

</script>


</head>
<body>
<h2>会員情報変更ページ</h2>

	<form action = "" method="post" name="frm">
		<table>
			<tr>
				<td>アイディー : </td>
				<td>
					<input type="text" name = "user_email_1" id="userid" value="${member.user_email_1}" maxlength="15"></input>@
					<input type="hidden" name = "reid">
					<select name = "user_email_2" id="useremail">
						<option value="naver.com" <c:if test="${member.user_email_2 == 'naver.com'}">selected</c:if>>naver.com</option>
						<option value="gmail.com"<c:if test="${member.user_email_2 == 'gmail.com'}">selected</c:if>>gmail.com</option>
						<option value="daum.net"<c:if test="${member.user_email_2 == 'daum.net'}">selected</c:if>>daum.net</option>			
					</select>
				</td>
				<td>
					<input type="button" value="重複チェック" onclick="idCheck()">
				</td>
			
			</tr>
		
		</table>

		
		パスワード : <input type="password" name = "user_pwd" value="${member.user_pwd}" ></input> <br>
		パスワード確認 : <input type="password" name = "pwd_check"></input> <br>
		
		
		<%
			
		
		
		%>
		
		
		
		名前(漢字)<input type="radio" name="radiobutton" value ="1"  onclick="showDiv('user_name')">  <input type="text" name = "user_name" style= "visibility:visible" value = "${member.user_name}"></input> <br>
		ふりがな(かたかな)<input type="radio" name="radiobutton" value = "2" onclick="showDiv('user_katakana')"> <input type="text" name = "user_katakana"  style= "visibility:hidden"> <br>
		
<!-- 		名前(漢字) : <input type="text" name = "user_name"></input> <br>
		ふりがな(かたかな) : <input type="text" name = "user_katakana" disabled="disabled"></input> <br> -->
		<table>
			<tr>
				<td>誕生日 </td>
				<td>
					<input type="text" name="user_birthyy" maxlength="4" placeholder="年（4席）" value="${member.user_birthyy}"></input>
					<select name = "user_birthmm" >
						<option value="">月</option>
						<option value="01" <c:if test="${member.user_birthmm == '01'}">selected</c:if>>1</option>
						<option value="02" <c:if test="${member.user_birthmm == '02'}">selected</c:if>>2</option>
						<option value="03" <c:if test="${member.user_birthmm == '03'}">selected</c:if>>3</option>
						<option value="04" <c:if test="${member.user_birthmm == '04'}">selected</c:if>>4</option>
						<option value="05" <c:if test="${member.user_birthmm == '05'}">selected</c:if>>5</option>
						<option value="06" <c:if test="${member.user_birthmm == '06'}">selected</c:if>>6</option>
						<option value="07" <c:if test="${member.user_birthmm == '07'}">selected</c:if>>7</option>
						<option value="08" <c:if test="${member.user_birthmm == '08'}">selected</c:if>>8</option>
						<option value="09" <c:if test="${member.user_birthmm == '09'}">selected</c:if>>9</option>
						<option value="10" <c:if test="${member.user_birthmm == '10'}">selected</c:if>>10</option>
						<option value="11" <c:if test="${member.user_birthmm == '11'}">selected</c:if>>11</option>
						<option value="12" <c:if test="${member.user_birthmm == '12'}">selected</c:if>>12</option>						
					</select>
					<input type="text" name="user_birthdd" maxlength="2" placeholder="日（２席）" value="${member.user_birthdd}"></input>
				</td>
			</tr>

		
		</table>
		<input type = "submit" value="加入する" onclick="return joinCheck()"></input>
		<input type="button" onclick="javascript:history.back()" value="戻る">
		
	</form>
	


</body>
</html>