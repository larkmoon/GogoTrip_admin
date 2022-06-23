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
public class BuyVO {
	private int id;
	private String uid;
	private String name;
	private int zip;
	private String addrf;
	private String addrs;
	private String phone;
	private int totalprice;
	private String payment;
	private Date regdate;

	// for insert
	public BuyVO(String uid, String name, int zip, String addrf, String addrs, String phone, int totalprice,
			String payment) {
		this.uid = uid;
		this.name = name;
		this.zip = zip;
		this.addrf = addrf;
		this.addrs = addrs;
		this.phone = phone;
		this.totalprice = totalprice;
		this.payment = payment;
	}

	// for update
	public BuyVO(int id, String uid, String name, int zip, String addrf, String addrs, String phone, int totalprice,
			String payment) {
		this.id = id;
		this.uid = uid;
		this.name = name;
		this.zip = zip;
		this.addrf = addrf;
		this.addrs = addrs;
		this.phone = phone;
		this.totalprice = totalprice;
		this.payment = payment;
	}
	
	
	
	
}
