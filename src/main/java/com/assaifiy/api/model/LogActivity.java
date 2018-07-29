package com.assaifiy.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="log_activity")
public class LogActivity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="log_id")
	private int Id;
	
	@Column(name="user_fullname")
	private String username;
	
	@Column(name="log_action")
	private String logAction;
	
	@Column(name="log_ipadd")
	private String logIpAddress;
	
	@Column(name="log_url")
	private String logRequestedUrl;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLogAction() {
		return logAction;
	}

	public void setLogAction(String logAction) {
		this.logAction = logAction;
	}

	public String getLogIpAddress() {
		return logIpAddress;
	}

	public void setLogIpAddress(String logIpAddress) {
		this.logIpAddress = logIpAddress;
	}

	public String getLogRequestedUrl() {
		return logRequestedUrl;
	}

	public void setLogRequestedUrl(String logRequestedUrl) {
		this.logRequestedUrl = logRequestedUrl;
	}
		
}
