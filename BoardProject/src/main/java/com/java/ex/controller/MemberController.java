package com.java.ex.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.ex.command.IdCheckMemberService;
import com.java.ex.command.JoinMemberService;
import com.java.ex.command.MemberCommand;

@Controller
public class MemberController {
	
	MemberCommand command;
	
	@RequestMapping("/index")
	public String index() {
		
		return "/index";
		
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "/login";
		
	}
	
	@RequestMapping("/join")
	public String join() {
		
		return "/join";
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/idcheck")
	public String idcheck(HttpServletRequest request, Model model) {	
		
		String view = null;
		model.addAttribute("request", request);
		
		command = new IdCheckMemberService();
		view = command.execute(model);
		
		return view;
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/joinRequest")
	public String joinRequest(HttpServletRequest request, Model model)   {
		
		String view = null;
		model.addAttribute("request", request);
		// 加入情報を持ってくる。
	
		command = new JoinMemberService();


		view = command.execute(model);
	

		
		return view;
		
	}
	
}
