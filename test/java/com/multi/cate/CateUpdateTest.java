package com.multi.cate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CateBiz;
import com.multi.vo.CateVO;

@SpringBootTest
class CateUpdateTest {

	@Autowired
	CateBiz biz;
	
	@Test
	void contextLoads() {
		CateVO obj = new CateVO(40,"dd",0);
		try {
			biz.modify(obj);
			System.out.println("complete ...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
