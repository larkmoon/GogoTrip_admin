package com.multi.commu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CommuBiz;
import com.multi.vo.CommuVO;

@SpringBootTest
class CommuInsertTest {
	
	@Autowired
	CommuBiz biz;
	
	@Test
	void contextloads() {
		CommuVO c1 = new CommuVO("id03", "정보", "담양 죽녹원 정보", "죽녹원정보내용", "전남", null, null);
		CommuVO c2 = new CommuVO("id04", "후기", "김광석 거리", "신나는 대구 여행~~ 쏼라쏼라", "대구", null, null);
		try {
			biz.register(c2);
			System.out.println(c2 + "Inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
