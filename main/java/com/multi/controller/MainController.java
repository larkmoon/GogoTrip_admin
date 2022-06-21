package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.AdminBiz;
import com.multi.vo.AdminVO;

@Controller
public class MainController {
	
	@Autowired
	AdminBiz adbiz;

	@RequestMapping("/")
	public String main() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(Model m, String msg) {
		if(msg !=null && msg.equals("f")) {
			m.addAttribute("failmsg", "Login Fail");
		}
		return "login";
	}
	
	@RequestMapping("/loginimpl")
	public String loginimpl(Model m, String id, String pwd,HttpSession session) {
		AdminVO obj = null; 
		try {
			obj = adbiz.get(id);
			if(pwd != null) {
				if(obj.getPwd().equals(pwd)) {
					session.setAttribute("loginadmin",obj);
				}else {
					throw new Exception();
				}
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			return "redirect:login?msg=f";
		}
		
		return "index";
	}
	
	@RequestMapping("/logout")
	public String logout(String m, HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		return "index";
	}
	
	
}
