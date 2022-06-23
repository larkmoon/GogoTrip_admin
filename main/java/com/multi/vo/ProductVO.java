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
	public int id;
	public String name;
	public int price;
	public int cid;
	public Date regdate;
	public int stock;
	public String imgname;
	public String description;
	
	public String catename;
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
	
	

}
