package com.java.ex.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.ex.command.IdCheckMemberService;
import com.java.ex.command.JoinMemberService;
import com.java.ex.command.MemberCommand;
import com.java.ex.dto.Member;

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
	
	@RequestMapping("/joinError")
	public String joinError() {
		
		return "/joinError";
		
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
	public String joinRequest(@ModelAttribute("member")Member member, BindingResult result, Model model)   {
		
		
		
		String view = "/join";
		
		
		JoinMemberValidator validator = new JoinMemberValidator();
		validator.validate(member, result);
		
		
		if(result.hasErrors()) {
			
			view = "/join";
			
		} else {
	
			JoinMemberService joinCommand = new JoinMemberService();

			//command = new JoinMemberService();
			view = joinCommand.execute(member);
			System.out.println("3");
		}
		
/*		String view = null;
		model.addAttribute("request", request);
		// 加入情報を持ってくる。
	
		command = new JoinMemberService();


		view = command.execute(model);*/
	
		
		
		return view;
		
	}
	
}
