package com.example.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member {
	@Id
	@Column(name = "mem_id")
	private String memId;
	@Column(name = "mem_name")
	private String memName;
	@Column(name = "mem_pass")
	private String memPass;
	@Column(name = "mem_role")
	private String memRole;
	public String getMemId() {
		return memId;
	}
	public String getMemName() {
		return memName;
	}
	public String getMemPass() {
		return memPass;
	}
	public String getMemRole() {
		return memRole;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public void setMemRole(String memRole) {
		this.memRole = memRole;
	}

}
