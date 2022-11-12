package com.unknown.model.request;

public class CustomerRequest {
	private Integer id;
	private String name;
	private String userName;
	private String email;
	private String phoneNumber;
	private Integer managerId;
	private String gender;
	private String role;
	private Integer empoloyeeOfCharge;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getEmpoloyeeOfCharge() {
		return empoloyeeOfCharge;
	}

	public void setEmpoloyeeOfCharge(Integer empoloyeeOfCharge) {
		this.empoloyeeOfCharge = empoloyeeOfCharge;
	}

}
