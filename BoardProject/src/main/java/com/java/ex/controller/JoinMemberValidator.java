package com.java.ex.controller;

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
		
		boolean number= false;
		boolean alpha = false;
		boolean spe= false;
		
		char[] words = user_pwd.toCharArray();
		if(user_name == null || user_name.trim().isEmpty()) {
			
			System.out.println("name is null or empty");
			errors.reject("name", "trouble");
			
		}
		
		
		
		for(int i=0; i<words.length; i++) {						
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
			System.out.println("password alpha or special or number is not");
			errors.reject("password", "trouble");
		}
		
	}

}
