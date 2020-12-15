package com.example.authweb.api.dto;


import java.util.Set;

public class UserDto {

	private String name;

	private String username;

	private String tel;

	private String password;

	private String gender;

	private Set<Long> roleIds;

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGender() {
		return gender;
	}

	UserDto setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public String getName() {
		return name;
	}

	UserDto setName(String name) {
		this.name = name;
		return this;
	}

	public String getUsername() {
		return username;
	}

	UserDto setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	UserDto setPassword(String password) {
		this.password = password;
		return this;
	}

	public Set<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Set<Long> roleIds) {
		this.roleIds = roleIds;
	}
}
