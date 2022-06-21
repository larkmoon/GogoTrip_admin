package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/commu")
public class CommuController {
	
	@RequestMapping("commumain")
	public String commumain(Model m) {
		m.addAttribute("center", "/commu/commumain");
		return "index";
	}
	
	@RequestMapping("marker")
	public String marker(Model m) {
		m.addAttribute("center", "/commu/marker");
		return "index";
	}
}
