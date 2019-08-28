package com.java.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.ex.dao.MemberDao;
import com.java.ex.dto.Member;

public class UpdateMemberService implements MemberCommand{

	@Override
	public String execute(Model model) {
		
		String view = "/update";
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String userid = request.getParameter("userid");

		
		MemberDao dao = new MemberDao();
		Member member = dao.getMember(userid);
		
		
		String[] array = member.getUser_id().split("@");
		
		String user_email_1 = array[0];
		String user_email_2 = array[1];
		
		member.setUser_email_1(user_email_1);
		member.setUser_email_2(user_email_2);
		
		String temp = member.getUser_birth().toString();
		
		String[] array2 = temp.split("-");
		
		member.setUser_birthyy(array2[0]);
		member.setUser_birthmm(array2[1]);
		member.setUser_birthdd(array2[2]);
		
		
		model.addAttribute("member", member);
		
		return view;
	}

}
