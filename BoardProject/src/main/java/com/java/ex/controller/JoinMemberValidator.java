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
		
		if(user_name == null || user_name.trim().isEmpty()) {
			
			System.out.println("name is null or empty");
			errors.reject("name", "trouble");
			
		}
		
		
	}

}
