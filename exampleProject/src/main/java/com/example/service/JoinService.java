package com.example.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import com.example.model.Users;
import com.example.repository.UsersRepository;

public class JoinService {
	
	
	public void joinUser(HttpServletRequest request, UsersRepository usersRepository) {
		
		String userEmail_1 = request.getParameter("user_email_1");
		String userEmail_2 = request.getParameter("user_email_2");
		String userPw = request.getParameter("user_pw");
		String userName = request.getParameter("user_name");
		String userKatakana = request.getParameter("user_katakana");
		String userBirthyy = request.getParameter("user_birthyy");
		String userBirthmm = request.getParameter("user_birthmm");
		String userBirthdd = request.getParameter("user_birthdd");
		
		
		Date userbirth = Date.valueOf(userBirthyy + "-" +userBirthmm +"-" +userBirthdd);
		String userId = userEmail_1 +"@" + userEmail_2;
		Users users = new Users();
		
		
		users.setUser_id(userId);
		users.setUser_pw(userPw);
		users.setUser_name(userName);
		users.setUser_katakana(userKatakana);
		users.setUser_birth(userbirth);
		
		
		usersRepository.save(users);
		
		
	}
	
	
}
