package com.amdocs.restservice.learnmicroservice.dao;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PASSWORDS")
public class DaoRegister {

	@Column(name = "LOG_MAIL")
	private String login;

	@Column(name = "PASS")
	private String password;

	@Column(name = "REG_DATE")
	private Date regDate;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	@Id
	@Column(name = "UUID")
	private UUID id;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
