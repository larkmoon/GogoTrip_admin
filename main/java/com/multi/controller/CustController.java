package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@Controller
@RequestMapping("/cust")
public class CustController {

	@Autowired
	CustBiz cubiz;
	
	@RequestMapping("add")
	public String add(Model m) {
		m.addAttribute("center","cust/add");
		return "index";
	}
	
	@RequestMapping("/select")
	public String select(Model m) {
		List<CustVO> list = null;
		try {
			list = cubiz.get();
			m.addAttribute("custlist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center","cust/select");
		return "index";
	}
	
	@RequestMapping("delete")
	public String delete(Model m, String id) {
		List<Integer> list = null;
		try {
			list = cubiz.getUpdlist(id);
			for (Integer b : list) {
				cubiz.nullBeforeDelete(b);
			}
			cubiz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:select";
	}
	
	@RequestMapping("registerimpl")
	public String register(Model m, CustVO obj) {
		try {
			cubiz.register(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:select";
	}

}
