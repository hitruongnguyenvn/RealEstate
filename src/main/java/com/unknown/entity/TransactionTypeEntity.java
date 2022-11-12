package com.unknown.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TransactionType")
public class TransactionTypeEntity {

	@Id
	@Column(name = "id", columnDefinition = "INT", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", columnDefinition = "NVARCHAR(255)", nullable = false)
	private String name;

	@Column(name = "code", columnDefinition = "VARCHAR(50)", nullable = false, unique = true)
	private String code;

	@OneToMany(mappedBy = "transactionTypeEntity", fetch = FetchType.LAZY)
	private List<TransactionEntity> transactionEntities;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<TransactionEntity> getTransactionEntities() {
		return transactionEntities;
	}

	public void setTransactionEntities(List<TransactionEntity> transactionEntities) {
		this.transactionEntities = transactionEntities;
	}

}
