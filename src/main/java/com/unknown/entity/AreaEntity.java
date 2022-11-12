package com.unknown.entity;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "Area")
public class AreaEntity {

	@Id
	@Column(name = "id", columnDefinition = "INT", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "floor", columnDefinition = "INT", nullable = true)
	private Integer floor;

	@Column(name = "area", columnDefinition = "NVARCHAR(255)", nullable = true)
	private String area;

	@Column(name = "status", columnDefinition = "INT", nullable = true)
	private Integer status;

	@Column(name = "price", columnDefinition = "FLOAT", nullable = true)
	private Double price;

	@Column(name = "deposit", columnDefinition = "FLOAT", nullable = true)
	private Double deposit;

	@Column(name = "decorate_time", columnDefinition = "FLOAT", nullable = true)
	private Double decorateTime;

	// Nhiều Area có chung 1 building nhưng mỗi record chỉ có 1 building
	// hay 1 area chỉ có 1 building
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "building_id", nullable = false)
	private BuildingEntity buildingEntity;

	@OneToMany(mappedBy = "areaEntity", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, orphanRemoval = true)
	private List<TransactionEntity> transactionEntities;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	public Double getDecorateTime() {
		return decorateTime;
	}

	public void setDecorateTime(Double decorateTime) {
		this.decorateTime = decorateTime;
	}

	public BuildingEntity getBuildingEntity() {
		return buildingEntity;
	}

	public void setBuildingEntity(BuildingEntity buildingEntity) {
		this.buildingEntity = buildingEntity;
	}

	public List<TransactionEntity> getTransactionEntities() {
		return transactionEntities;
	}

	public void setTransactionEntities(List<TransactionEntity> transactionEntities) {
		this.transactionEntities = transactionEntities;
	}

}
