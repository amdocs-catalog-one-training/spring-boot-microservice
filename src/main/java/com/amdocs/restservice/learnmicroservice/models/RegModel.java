package com.amdocs.restservice.learnmicroservice.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegModel {
	
	@JsonProperty("login")
	private String login;

	@JsonProperty("password")
	private String password;
	
	
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
	
}
