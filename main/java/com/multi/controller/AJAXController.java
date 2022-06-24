package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.AdminBiz;
import com.multi.biz.CateBiz;
import com.multi.biz.CustBiz;
import com.multi.vo.AdminVO;
import com.multi.vo.CateVO;
import com.multi.vo.CustVO;

@RestController
public class AJAXController {
	
	@Autowired
	CustBiz cubiz;
	
	@Autowired
	AdminBiz adbiz;
	
	@Autowired
	CateBiz cbiz;
	
	@RequestMapping("/cust/checkid")
	public String custcheckid(String id) {
		CustVO obj = null;
		String result = "";
		
		try {
			obj = cubiz.get(id);
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
	
	@RequestMapping("/cust/checkemail")
	public String custcheckemail(String email) {
		CustVO obj = null;
		String result = "";
		
		try {
			obj = cubiz.getemail(email);
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
	
	@RequestMapping("/cust/checkphone")
	public String custcheckphone(String phone) {
		CustVO obj = null;
		String result = "";

		
		try {
			obj = cubiz.getphone(phone);
			if(obj == null) {
				result = "0";
			}else {
				result = "1";
			}
		} catch (Exception e) {
			result = "2";
		}
		return result;
	}
	
	
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
	
	@RequestMapping("/product/catecheckid")
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
