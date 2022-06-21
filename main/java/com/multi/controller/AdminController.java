package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.AdminBiz;
import com.multi.vo.AdminVO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminBiz adbiz;
	
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
	
	@RequestMapping("registerimpl")
	public String register(Model m, AdminVO obj) {
		try {
			adbiz.register(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.addAttribute("center", "admin/select");
		return "index";
	}
}
