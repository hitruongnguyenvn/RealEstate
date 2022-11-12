package com.unknown.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class UsersEntity {

	@Id
	@Column(name = "id", columnDefinition = "INT", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_name", columnDefinition = "VARCHAR(255)", nullable = false, unique = true)
	private String userName;

	@Column(name = "password", columnDefinition = "VARCHAR(255)", nullable = false)
	private String password;

	@Column(name = "full_name", columnDefinition = "NVARCHAR(255)", nullable = true)
	private String fullName;

	@Column(name = "gender", columnDefinition = "NVARCHAR(100)", nullable = true)
	private String gender;

	@Column(name = "email", columnDefinition = "NVARCHAR(255)", nullable = true)
	private String email;

	@Column(name = "stt", columnDefinition = "INT", nullable = false)
	private Integer stt;

	@Column(name = "phone_number", columnDefinition = "VARCHAR(20)", nullable = true)
	private String phoneNumber;

	@Column(name = "count_post_posted", columnDefinition = "INT", nullable = true)
	private Integer countPostPosted;

	@Column(name = "amount_post_posted", columnDefinition = "INT", nullable = true)
	private Integer amountPostPosted;

	@Column(name = "link_facebook", columnDefinition = "TEXT", nullable = true)
	private String linkFacebook;

	@Column(name = "link_twitter", columnDefinition = "TEXT", nullable = true)
	private String linkTwitter;

	// Một quản lý có nhiều user
	// (Hiện tại UsersEntity chính là quản lý và cũng chính là users)
	@OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
	private List<UsersEntity> usersEntity;

	// Nhiều user cùng một quản lý hay 1 user chỉ có 1 quản lý
	// (Hiện tại UsersEntity chính là quản lý và cũng chính là users)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id", nullable = false)
	private UsersEntity manager;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	private RoleEntity roleEntity;

	@OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
	private List<UsersBuildingEntity> usersBuildingEntities;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private List<TransactionEntity> transactionOfEmployee;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<TransactionEntity> transactionOfCustomer;

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

	public Integer getStt() {
		return stt;
	}

	public void setStt(Integer stt) {
		this.stt = stt;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getCountPostPosted() {
		return countPostPosted;
	}

	public void setCountPostPosted(Integer countPostPosted) {
		this.countPostPosted = countPostPosted;
	}

	public Integer getAmountPostPosted() {
		return amountPostPosted;
	}

	public void setAmountPostPosted(Integer amountPostPosted) {
		this.amountPostPosted = amountPostPosted;
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

	public List<UsersEntity> getUsersEntity() {
		return usersEntity;
	}

	public void setUsersEntity(List<UsersEntity> usersEntity) {
		this.usersEntity = usersEntity;
	}

	public UsersEntity getManager() {
		return manager;
	}

	public void setManager(UsersEntity manager) {
		this.manager = manager;
	}

	public RoleEntity getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}

	public List<UsersBuildingEntity> getUsersBuildingEntities() {
		return usersBuildingEntities;
	}

	public void setUsersBuildingEntities(List<UsersBuildingEntity> usersBuildingEntities) {
		this.usersBuildingEntities = usersBuildingEntities;
	}

	public List<TransactionEntity> getTransactionOfEmployee() {
		return transactionOfEmployee;
	}

	public void setTransactionOfEmployee(List<TransactionEntity> transactionOfEmployee) {
		this.transactionOfEmployee = transactionOfEmployee;
	}

	public List<TransactionEntity> getTransactionOfCustomer() {
		return transactionOfCustomer;
	}

	public void setTransactionOfCustomer(List<TransactionEntity> transactionOfCustomer) {
		this.transactionOfCustomer = transactionOfCustomer;
	}

}
