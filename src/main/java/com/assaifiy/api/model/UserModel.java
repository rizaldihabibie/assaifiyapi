package com.assaifiy.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4242528697607453166L;
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name="login_type")
	private String loginType;
	
	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="user_phone")
	private String userPhone;
	
	@Column(name="user_priviledge")
	private String userPriviledge;
	
	@Column(name="user_status")
	private String userStatus;
	
	@Column(name="is_delete")
	private String isDelete;
	
	@Column(name="user_fullname")
	private String userFullname;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPriviledge() {
		return userPriviledge;
	}

	public void setUserPriviledge(String userPriviledge) {
		this.userPriviledge = userPriviledge;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getUserFullname() {
		return userFullname;
	}

	public void setUserFullname(String userFullname) {
		this.userFullname = userFullname;
	}
		

}
