package com.sellingperfume.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class UserEntity extends AbtractEntity {
	@NotNull
	@Column(name = "birthday", columnDefinition = "varchar(50)")
	private String birthday;

	@NotNull
	@Column(name = "username", columnDefinition = "varchar(50)", unique = true)
	private String username;

	@NotNull
	@Column(name = "password", columnDefinition = "varchar(200)")
	private String password;

	@NotNull
	@Column(name = "name", columnDefinition = "varchar(50)")
	private String name;

	@NotNull
	@Column(name = "phone", columnDefinition = "varchar(50)", unique = true)
	private String phone;
	
	@Email
	@NotNull
	@Column(name = "email", columnDefinition = "varchar(50)", unique = true)
	private String email;

	@NotNull
	@Column(name = "adress", columnDefinition = "varchar(50)", unique = true)
	private String adress;

	
	@Column(name = "avatar", columnDefinition = "varchar(250)")
	private String avatar;

	
	@Column(name = "status_user", columnDefinition = "boolean default true ")
	private boolean status_user;

	
	@Column(name = "sex", columnDefinition = "boolean default true ")
	private boolean sex;
	
	@Column(name="Serect_Key")
	private String serect_keyString;
	
	@Column(name="Active_OTP_Status", columnDefinition = "boolean default true ")
	private boolean Active_OTP_Status;
	
	@Column(name="Login_Status", columnDefinition = "boolean default true ")
	private boolean Login_Status;
	
	public String getSerect_keyString() {
		return serect_keyString;
	}

	public void setSerect_keyString(String serect_keyString) {
		this.serect_keyString = serect_keyString;
	}

	public boolean isActive_OTP_Status() {
		return Active_OTP_Status;
	}

	public void setActive_OTP_Status(boolean active_OTP_Status) {
		Active_OTP_Status = active_OTP_Status;
	}

	public boolean isLogin_Status() {
		return Login_Status;
	}

	public void setLogin_Status(boolean login_Status) {
		Login_Status = login_Status;
	}

	public void setStatus_user(boolean status_user) {
		this.status_user = status_user;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public boolean isStatus_user() {
		return status_user;
	}

	public UserEntity() {
		super();
	}

}
