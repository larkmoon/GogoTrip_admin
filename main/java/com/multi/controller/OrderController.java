package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

	@RequestMapping("cartmain")
	public String cartmain(Model m) {
		m.addAttribute("center","/order/cartmain");
		return "index";
	}
	
	@RequestMapping("buymain")
	public String buymain(Model m) {
		m.addAttribute("center","/order/buymain");
		return "index";
	}
	
	@RequestMapping("buydetailmain")
	public String buydetailmain(Model m) {
		m.addAttribute("center","/order/buydetailmain");
		return "index";
	}
}
