package com.java.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.ex.dao.MemberDao;

public class IdCheckMemberService implements MemberCommand {

	@Override
	public String execute(Model model) {

		String view;
		int result = -1;
		
		MemberDao dao = new MemberDao();
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		
		String userid = request.getParameter("userid");
		
		result = dao.confirmID(userid);
		
		model.addAttribute("result", result);
		model.addAttribute("userid", userid);
		
		view = "/idcheck";
		
		return view;
	}

}
