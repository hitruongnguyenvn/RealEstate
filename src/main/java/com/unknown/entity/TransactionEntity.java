package com.unknown.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Transactions")
public class TransactionEntity {

	@Id
	@Column(name = "id", columnDefinition = "INT", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "create_date", columnDefinition = "DATE", nullable = true)
	private Date createDate;

	@Column(name = "note", columnDefinition = "TEXT", nullable = true)
	private String note;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "area_id", nullable = false)
	private AreaEntity areaEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable = false)
	private UsersEntity employee;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	private UsersEntity customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transaction_type_id", nullable = false)
	private TransactionTypeEntity transactionTypeEntity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public AreaEntity getAreaEntity() {
		return areaEntity;
	}

	public void setAreaEntity(AreaEntity areaEntity) {
		this.areaEntity = areaEntity;
	}

	public UsersEntity getEmployee() {
		return employee;
	}

	public void setEmployee(UsersEntity employee) {
		this.employee = employee;
	}

	public UsersEntity getCustomer() {
		return customer;
	}

	public void setCustomer(UsersEntity customer) {
		this.customer = customer;
	}

	public TransactionTypeEntity getTransactionTypeEntity() {
		return transactionTypeEntity;
	}

	public void setTransactionTypeEntity(TransactionTypeEntity transactionTypeEntity) {
		this.transactionTypeEntity = transactionTypeEntity;
	}

}
