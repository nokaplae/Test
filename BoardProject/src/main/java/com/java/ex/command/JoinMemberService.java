package com.java.ex.command;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.java.ex.dao.MemberDao;
import com.java.ex.dto.Member;

public class JoinMemberService implements MemberCommand{

	
	@Override
	public String execute(Model model) {
		// TODO Auto-generated method stub
		String view;
		
		MemberDao dao = new MemberDao();
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
				
		
		String email_1 = request.getParameter("user_email_1");
		String email_2 = request.getParameter("user_email_2");
		
		String pwd = request.getParameter("user_pw");
		String name = request.getParameter("user_name");
		String katakana = request.getParameter("user_katakana");
		
		
		String birthyy = request.getParameter("user_birthyy");
		String birthmm = request.getParameter("user_birthmm");
		String birthdd = request.getParameter("user_birthdd");
		
		String id = email_1+"@"+email_2;
		Date birth = Date.valueOf(birthyy+"-"+birthmm+"-"+birthdd);
		
		Member member = new Member(id, pwd, name, katakana, birth);
		
		
		int result = dao.joinDao(member);
		
		HttpSession session = request.getSession();
		
		if(result == 1) {
			session.setAttribute("userId", member.getUser_id());
			view = "/board";
		} else {
			view = "/join";
		}	
	
		return view;
	
		
	}

	
	
	
	
}
