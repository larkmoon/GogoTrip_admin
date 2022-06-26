package com.multi.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductVO {
	private int id;
	private String name;
	private int price;
	private int cid;
	private Date regdate;
	private int stock;
	private String imgname;
	private String description;
	
	private String catename;
	private MultipartFile mf;

	public ProductVO(int id, String name, int price, int cid, Date regdate, int stock, String imgname,
			String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.cid = cid;
		this.regdate = regdate;
		this.stock = stock;
		this.imgname = imgname;
		this.description = description;
	}

	public ProductVO(int id, int price) {
		this.id = id;
		this.price = price;
	}
	
	

}
