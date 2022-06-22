package com.multi.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String phone;
	private Date regdate;
	private String zip;
	private String addrf;
	private String addrs;
	private int point;
	
	// for updatepoint
	public CustVO(String id, int point) {
		this.id = id;
		this.point = point;
	} 
	
}
