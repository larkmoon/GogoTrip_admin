package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CateBiz;
import com.multi.biz.ProductBiz;
import com.multi.vo.CateVO;
import com.multi.vo.ProductVO;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductBiz pbiz;
	
	@Autowired
	CateBiz cbiz;
	
	
	
	@RequestMapping("add")
	public String add(Model m) {
		m.addAttribute("center","product/add");
		return "index";
	}
	
	@RequestMapping("select")
	public String select(Model m) {
		List<ProductVO> list = null;
		try {
			list = pbiz.get();
			m.addAttribute("productlist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center","product/select");
		return "index";
	}
	
	@RequestMapping("catemain")
	public String catemain(Model m) {
		List<CateVO> list = null;
		try {
			list = cbiz.getmain();
			m.addAttribute("catemainlist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center","product/catemain");
		return "index";
	}
	
	@RequestMapping("cate_registimpl")
	public String registimpl(Model m, CateVO obj) {
		try {
			cbiz.register(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:catemain";
	}
	
	
	
}