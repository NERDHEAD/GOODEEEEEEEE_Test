package com.nerdhead.edu.ctrl;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nerdhead.edu.dto.MemberDto;
import com.nerdhead.edu.model.service.IService;

@Controller
public class MainController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IService service;
	
	@RequestMapping(value = "signUpForm.do")
	public String signUpForm() {
		return "signUpForm";
	}
	@RequestMapping(value = "signUp.do")
	public String signUp(MemberDto dto) {
		service.signUpMember(dto);
		return "index";
	}
	
	
	
	
	
	@RequestMapping(value = "login.do")
	public String login(String id, String pw, HttpSession session) {
		MemberDto loginDto=(MemberDto)service.loginMember(id, pw);
		log.info("login.do -> "+loginDto);
		session.setAttribute("loginDto", loginDto);
		return "redirect:/index.do";
	}
	@RequestMapping(value = "index.do")
	public String index(HttpSession session) {
		MemberDto loginDto=(MemberDto)session.getAttribute("loginDto");
		log.info("index.do -> "+loginDto);
		if(loginDto==null) {return "index";}
		else {return "redirect:/boardList.do";}
	}
}
