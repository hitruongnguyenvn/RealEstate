package com.unknown.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class UsersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "userName", nullable = true, unique = true)
	private String userName;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "fullName")
	private String fullName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "email")
	private String email;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "CountPostPosted")
	private Integer CountPostPosted;

	@Column(name = "AmountPostPosted")
	private Integer AmountPostPosted;

	@Column(name = "linkFacebook")
	private String linkFacebook;

	@Column(name = "linkTwitter")
	private String linkTwitter;

	@OneToOne
	@JoinColumn(name = "roleId")
	private RoleEntity roleEntity;

	@OneToOne
	@JoinColumn(name = "managerId", nullable = false)
	private UsersEntity usersEntity;

	@OneToOne(mappedBy = "usersEntity")
	private UsersEntity manager;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Integer getCountPostPosted() {
		return CountPostPosted;
	}

	public void setCountPostPosted(Integer countPostPosted) {
		CountPostPosted = countPostPosted;
	}

	public Integer getAmountPostPosted() {
		return AmountPostPosted;
	}

	public void setAmountPostPosted(Integer amountPostPosted) {
		AmountPostPosted = amountPostPosted;
	}

	public String getLinkFacebook() {
		return linkFacebook;
	}

	public void setLinkFacebook(String linkFacebook) {
		this.linkFacebook = linkFacebook;
	}

	public String getLinkTwitter() {
		return linkTwitter;
	}

	public void setLinkTwitter(String linkTwitter) {
		this.linkTwitter = linkTwitter;
	}

	public RoleEntity getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}

	public UsersEntity getUsersEntity() {
		return usersEntity;
	}

	public void setUsersEntity(UsersEntity usersEntity) {
		this.usersEntity = usersEntity;
	}

	public UsersEntity getManager() {
		return manager;
	}

	public void setManager(UsersEntity manager) {
		this.manager = manager;
	}

}
