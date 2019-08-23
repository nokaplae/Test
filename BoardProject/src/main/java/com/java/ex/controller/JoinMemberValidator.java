package com.java.ex.controller;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
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
		String user_birtydd = member.getUser_birthdd();
		
	
		// 名前を入力したらネームのスペースチェック
		if(user_name.length()!=0) {	
			if(user_name.trim().isEmpty()) {	
				System.out.println("name empty");
				errors.reject("name", "trouble");	
			}	
		}
		
		
		// カタカナを入力したらカタカナのスペースチェック
		if(user_katakana.length() != 0) {	
			if(user_katakana.trim().isEmpty()) {	
				System.out.println("katakana empty");
				errors.reject("katakana", "trouble");	
			}	
		}

		
		
		// パスワードの数字、特集文字、英字、スペース、長さをチェック
		Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{5,15}$");
		
		Matcher m = p.matcher(user_pwd);
		
		
		if(m.find() == false) {
			System.out.println("password alpha or special or number is not space");
			errors.reject("password", "trouble");
		} 	
		
		
		// 生年月日の年の数字、スペース、長さチェック
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONTH) + 1;
		int date = cal.get(cal.DATE);
		
		int temp_int;
		
		Pattern N = Pattern.compile("[0-9]{4}");
		m= N.matcher(user_birthyy);
		
		// 入力した所が数字がない
		if(m.find() == false) {
			System.out.println("number not");
			errors.reject("year", "trouble");
		} 	
		
		temp_int = Integer.parseInt(user_birthyy);
		
		// 現在の年と比較
		if(!(temp_int <= year-120 && temp_int >= year)) {
			System.out.println("year not");
			errors.reject("year", "trouble");
			
		}
		
		//　生年月日の日の数字、プランク、長さチェック
		
		
		// 現在の月と比較
		
		
		// 現在の日と比較
		
		
		
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
