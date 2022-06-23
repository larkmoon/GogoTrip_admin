package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.BuyBiz;
import com.multi.biz.BuydetailBiz;
import com.multi.biz.CartBiz;
import com.multi.vo.BuyVO;
import com.multi.vo.BuydetailVO;
import com.multi.vo.CartVO;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	CartBiz crbiz;
	
	@Autowired
	BuyBiz bbiz;
	
	@Autowired
	BuydetailBiz bdbiz;
	
	@RequestMapping("cartmain")
	public String cartmain(Model m) {
		List<CartVO> list = null;
		try {
			list = crbiz.get();
			m.addAttribute("cartlist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center","order/cartmain");
		return "index";
	}
	
	@RequestMapping("buymain")
	public String buymain(Model m) {
		List<BuyVO> list = null;
		try {
			list = bbiz.get();
			m.addAttribute("buylist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center","order/buymain");
		return "index";
	}
	
	@RequestMapping("buydetail")
	public String buydetailmain(Model m, int oid) {
		List<BuydetailVO> list = null;
		try {
			list = bdbiz.getoid(oid);
			m.addAttribute("buydetaillist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center","order/buydetail");
		return "index";
	}
}
