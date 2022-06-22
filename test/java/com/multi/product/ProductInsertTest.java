package com.multi.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.ProductBiz;
import com.multi.vo.ProductVO;

@SpringBootTest
class ProductInsertTest {

	@Autowired
	ProductBiz biz;
	
	@Test
	void contextLoads() {
		// ProductVO obj = new ProductVO(0,"product5",12000,11,null,90,"img5.jpg","description5");
		ProductVO obj = new ProductVO(0,"product6",11000,12,null,0,"img6.jpg","description6");
		try {
			biz.register(obj);
			System.out.println("complete ...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
