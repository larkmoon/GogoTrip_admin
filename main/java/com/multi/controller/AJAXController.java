package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.AdminBiz;
import com.multi.biz.CateBiz;
import com.multi.vo.AdminVO;
import com.multi.vo.CateVO;

@RestController
public class AJAXController {
	
	@Autowired
	AdminBiz adbiz;
	
	@Autowired
	CateBiz cbiz;
	
	
	@RequestMapping("/admin/checkid")
	public String admincheckid(String id) {
		AdminVO obj = null;
		String result = "";
		
		try {
			obj = adbiz.get(id);
			if(obj == null) {
				result = "0";
			}else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/product/checkid")
	public String catecheckid(String id) {
		CateVO obj = null;
		String result = "";
		int iid = 0;
		
		try {
			iid = Integer.parseInt(id);
			obj = cbiz.get(iid);
			if(obj == null) {
				result = "0";
			}else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
