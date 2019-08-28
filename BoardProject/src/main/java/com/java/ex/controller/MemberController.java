package com.java.ex.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.ex.command.*;
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
	
	
	@RequestMapping("/join")
	public String join() {
		
		return "/join";
		
	}
	
	@RequestMapping("/board")
	public String board() {
		
		return "/board";
		
	}
	
	@RequestMapping("/updateRequest")
	public String updateRequest(HttpServletRequest request, Model model) {
		String view;
		model.addAttribute("request", request);
		
		command = new UpdateMemberService();
		view = command.execute(model);
		
		
		return view;
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value ="/logoutRequest")
	public String logoutRequest(HttpServletRequest request, Model model) {
		String view = "/login";
		
		HttpSession session = request.getSession();
		session.invalidate();
		return view;
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value ="/loginRequest")
	public String loginRequest(HttpServletRequest request, Model model) {
		String view;
		
		model.addAttribute("request", request);
		
		command = new LoginMemberService();
		view = command.execute(model);
		
		return view;
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
		
		/*@ModelAttribute("member")Member member*/
		
		String view = "/join";
		
		
		JoinMemberValidator validator = new JoinMemberValidator();
		validator.validate(member, result);
		
		
		if(result.hasErrors()) view = "/join";
			
		else {
	
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
