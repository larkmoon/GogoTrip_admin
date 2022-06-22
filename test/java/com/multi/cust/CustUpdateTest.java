package com.multi.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@SpringBootTest
class CustUpdateTest {

	@Autowired
	CustBiz biz;
	
	@Test
	void contextloads() {
		CustVO obj = new CustVO("id04", "pwd04", "choi", "ddd@naver.com","01010001001",null,"11000","Seoul",null,3000);
		try {
			biz.modify(obj);
			System.out.println("complete ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}