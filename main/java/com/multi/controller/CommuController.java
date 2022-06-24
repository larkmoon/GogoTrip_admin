package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CommuBiz;
import com.multi.biz.MarkerBiz;
import com.multi.vo.CommuVO;
import com.multi.vo.MarkerVO;

@Controller
@RequestMapping("/commu")
public class CommuController {
	
	@Autowired
	CommuBiz cmbiz;
	
	@Autowired
	MarkerBiz mbiz;
	
	@RequestMapping("commumain")
	public String commumain(Model m) {
		List<CommuVO> list = null;
		try {
			list = cmbiz.get();
			m.addAttribute("commulist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "/commu/commumain");
		return "index";
	}
	@RequestMapping("/comdelete")
	public String cdelete(int id) {
		try {
			cmbiz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:commumain";
	}
	
	
	
	// marker
	@RequestMapping("marker")
	public String marker(Model m) {
		List<MarkerVO> list = null;
		try {
			list = mbiz.get();
			m.addAttribute("markerlist",list);
		} catch (Exception e) {
						e.printStackTrace();
		}
		m.addAttribute("center", "/commu/marker");
		return "index";
	}
	@RequestMapping("mdelete")
	public String mdelete(int id) {
		try {
			mbiz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:marker";
	}
}
