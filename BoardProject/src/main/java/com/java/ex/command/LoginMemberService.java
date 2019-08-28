package com.java.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.java.ex.dao.MemberDao;
import com.java.ex.dto.Member;

public class LoginMemberService implements MemberCommand{

	@Override
	public String execute(Model model) {
		
		MemberDao dao = new MemberDao();
		String view = "/login";
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String user_email_1 = request.getParameter("user_email_1");
		String user_email_2 = request.getParameter("user_email_2");
		
		String userid = user_email_1 + "@" + user_email_2;
		
		String pwd = request.getParameter("pwd");
		
		
		int result = dao.userCheck(userid, pwd);
		
		
		if(result == 1) {
			System.out.println("ログイン成功");
			Member member = dao.getMember(userid);
			

			HttpSession session = request.getSession();
			session.setAttribute("loginUser", member);
			
			view = "/board";
		} else if(result == 0) {
			
			
			System.out.println("パスワードが一致しないです");
			view = "/login";
			model.addAttribute("message", "パスワードが一致しないです");
		} else if(result == -1) {
			System.out.println("アイディーが一存在ないです");
			model.addAttribute("message", "アイディーが一存在ないです");
			view = "/login";
		}
		
		return view;
	}
	
}
