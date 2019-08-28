package com.java.ex.controller;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.java.ex.dto.Member;

public class JoinMemberValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub 
		return Member.class.isAssignableFrom(arg0);
	}
	
	

	@Override
	public void validate(Object obj, Errors errors) {
		
		
		System.out.println("validate");
		Member member = (Member)obj;
		
		String user_pwd = member.getUser_pwd();
		String user_name = member.getUser_name();
		String user_katakana = member.getUser_katakana();
		String user_birthyy = member.getUser_birthyy();
		String user_birthmm = member.getUser_birthmm();
		String user_birthdd = member.getUser_birthdd();
		
		
		
		// パスワードの数字、特集文字、英字、スペース、長さをチェック
		Pattern P = Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{5,15}$");
		
		Matcher m = P.matcher(user_pwd);
		
		
		if(m.find() == false) {
			System.out.println("password alpha or special or number is not space");
			errors.reject("password", "trouble");
		} 	
		
		
		
		
/*		if(user_name.length()!=0) {	
			if(user_name.trim().isEmpty()) {	
				System.out.println("name empty");
				errors.reject("name", "required");	
			}	
		}*/
		

	
		// 名前を入力したらネームのスペース及び漢字チェック
		Pattern N = Pattern.compile("^[\u2e80-\u2eff\u31c0-\u31ef\u3200-\u32ff\u3400-\u4dbf\u4e00-\u9fbf\uf900-\ufaff]*$");
		m = N.matcher(user_name);
		
		if(m.find() == false) {
			System.out.println("chineseCharacter is not");
			errors.reject("user_name", "trouble");
		}
		
		
				
		// カタカナを入力したらカタカナのスペースチェック
/*		if(user_katakana.length() != 0) {	
			if(user_katakana.trim().isEmpty()) {	
				System.out.println("katakana empty");
				errors.reject("katakana", "required");	
			}	
		}*/
		
		
		Pattern K = Pattern.compile("^[\u30A0-\u30FF]*$");
		m = K.matcher(user_katakana);
		if(m.find() == false) {
			System.out.println("katakana is not");
			errors.reject("user_katakana", "trouble");
		}
		
		
		// 生年月日の年の数字、スペース、長さチェック
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONTH) + 1;
		int date = cal.get(cal.DATE);
		
		int temp_intyy;
		int temp_intmm;
		int temp_intdd;
		
		Pattern Y = Pattern.compile("[0-9]{4}");
		m= Y.matcher(user_birthyy);
		
		// 入力した所が数字がない
		if(m.find() == false) {
			System.out.println("number not");
			errors.reject("year", "required");
		} 	
		
		temp_intyy = Integer.parseInt(user_birthyy);
		
		// 現在の年と比較
		if(!(temp_intyy >= year-120 && temp_intyy <= year-1)) {
			System.out.println("year not");
			errors.reject("year", "trouble");
			
		}
		
		// 現在の月と比較
		/*temp_intmm = Integer.parseInt(user_birthmm);
		
		if(temp_intmm > month) {
			System.out.println("month not");
			errors.reject("month", "trouble");
		}
*/
		
		
		// 現在の日と比較
		temp_intdd = Integer.parseInt(user_birthdd);
		
		if(!(temp_intdd >= 1 && temp_intdd <= 31)) {
			System.out.println("date not");
			errors.reject("date", "trouble");
		}
		
		
/*		for(int i=0; i<words.length; i++) {						
			if((words[i] >= 33 && words[i] <= 47) || (words[i] >= 58 && words[i] <= 64)
					|| (words[i] >= 91 && words[i] <= 96) || (words[i] >= 123 && words[i] <= 126)) {
				
				spe = true;
			} else if(words[i] >= 48 && words[i] <= 57) {
				number = true;
			} else if(words[i] >= 65 && words[i] <= 122) {
				alpha = true;
			}
		}
		
		if(spe==false || alpha ==false || number == false) {
			
			errors.reject("password", "trouble");
		}*/
		
	}

}
