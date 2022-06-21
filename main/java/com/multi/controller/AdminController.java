package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping("add")
	public String add(Model m) {
		m.addAttribute("center", "admin/add");
		return "index";
	}
	
	@RequestMapping("select")
	public String select(Model m) {
		m.addAttribute("center", "admin/select");
		return "index";
	}
}
