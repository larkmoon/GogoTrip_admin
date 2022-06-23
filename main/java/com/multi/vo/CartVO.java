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
public class CartVO {
	private int id;
	private String uid;
	private int pid;
	private int cnt;
	private Date regdate;
	
	private String pname;
	private int pprice;
	private String catename;
	
	
	// for insert
	public CartVO(String uid, int pid, int cnt) {
		this.uid = uid;
		this.pid = pid;
		this.cnt = cnt;
	}

	
	// for update
	public CartVO(int id, String uid, int pid, int cnt) {
		this.id = id;
		this.uid = uid;
		this.pid = pid;
		this.cnt = cnt;
	}


	public CartVO(int id, String uid, int pid, int cnt, Date regdate) {
		this.id = id;
		this.uid = uid;
		this.pid = pid;
		this.cnt = cnt;
		this.regdate = regdate;
	}
	
	
	
	
	
	
}
