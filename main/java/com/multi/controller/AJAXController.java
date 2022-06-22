package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.AdminBiz;
import com.multi.vo.AdminVO;

@RestController
public class AJAXController {
	
	@Autowired
	AdminBiz adbiz;
	
	@RequestMapping("/checkid")
	public String checkid(String id) {
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
}
