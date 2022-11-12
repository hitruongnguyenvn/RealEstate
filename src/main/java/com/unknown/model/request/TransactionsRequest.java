package com.unknown.model.request;

import java.util.List;

public class TransactionsRequest {
	private Integer id;
	private String note;
	private List<Integer> areaIds;
	private Integer customerId;
	private Integer employeeId;
	private Integer transactionTypeId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Integer> getAreaIds() {
		return areaIds;
	}

	public void setAreaIds(List<Integer> areaIds) {
		this.areaIds = areaIds;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getTransactionTypeId() {
		return transactionTypeId;
	}

	public void setTransactionTypeId(Integer transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

}
