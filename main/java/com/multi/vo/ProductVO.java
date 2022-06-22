package com.multi.vo;

import java.util.Date;

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
	

}
