package com.multi.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CateBiz;
import com.multi.biz.ProductBiz;
import com.multi.frame.Util;
import com.multi.vo.CateVO;
import com.multi.vo.ProductVO;

@Controller
@RequestMapping("/product")
public class ProductController {

	@org.springframework.beans.factory.annotation.Value("${admindir}")
	String admindir;
	
	@org.springframework.beans.factory.annotation.Value("${userdir}")
	String userdir;
	
	@Autowired
	ProductBiz pbiz;
	
	@Autowired
	CateBiz cbiz;
	
	
	// Product
	@RequestMapping("add")
	public String add(Model m) {
		List<CateVO> list = null;
		try {
			list = cbiz.getsub();
			m.addAttribute("catelist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	@RequestMapping("productdetail")
	public String pdetail(Model m, int id) {
		ProductVO obj = null;
		List<CateVO> list = null;
		try {
			obj = pbiz.get(id);
			list = cbiz.getsub();
			m.addAttribute("productvalue", obj);
			m.addAttribute("catelist", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "product/productdetail");
		
		return "index";
		
		
	}
	@RequestMapping("product_registimpl")
	public String pregistimpl(Model m, ProductVO obj) {
		String imgname = obj.getMf().getOriginalFilename();
		obj.setCatename(imgname);
		
		try {
			System.out.println(obj);
			pbiz.register(obj);
			Util.saveFile(obj.getMf(),admindir,userdir);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:select";
	}
	
	@RequestMapping("/productupdate")
	public String pupdate(Model m, ProductVO obj) {
		System.out.println(obj);
		String iname = obj.getMf().getOriginalFilename();
		if (!(iname.equals(""))) {
			obj.setImgname(iname);
			Util.saveFile(obj.getMf(),admindir,userdir);
		}else if(obj.getImgname().equals("")) {
			obj.setImgname(null);
		}
		
		System.out.println(obj.getImgname());
		try {
			pbiz.modify(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:select";
	}
	@RequestMapping("/productdelete")
	public String pdelete(int id) {
		try {
			pbiz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:detail?id="+id;
		}
		return "redirect:select";
	}
	
	
	
	
	
	// Category
	@RequestMapping("catemain")
	public String catemain(Model m) {
		List<CateVO> mainlist = null;
		List<CateVO> list = null;
		try {
			mainlist = cbiz.getmain();
			list = cbiz.get();
			m.addAttribute("catemainlist",mainlist);
			m.addAttribute("catelist",list);
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
	
	@RequestMapping("catedetail")
	public String catedetail(Model m, int id) {
		CateVO obj = null;
		List<CateVO> mainlist = null;
		try {
			obj = cbiz.get(id);
			mainlist = cbiz.getmain();
			m.addAttribute("catevalue",obj);
			m.addAttribute("catemainlist",mainlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center","product/catedetail");
		return "index";
	}
	@RequestMapping("catedelete")
	public String catedelete(int id) {
		try {
			cbiz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:catemain";
	}
	
	@RequestMapping("cateupdate")
	public String cateupdate(Model m, CateVO obj) {
		try {
			cbiz.modify(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:catemain";
	}
	
	
}