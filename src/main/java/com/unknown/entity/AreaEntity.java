package com.unknown.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Area")
public class AreaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "floor")
	private Integer floor;

	@Column(name = "area", nullable = true)
	private String area;

	@Column(name = "status", nullable = true)
	private Integer status;

	@Column(name = "price")
	private Double price;

	@Column(name = "deposit")
	private Double deposit;

	@Column(name = "decorateTime")
	private Double decorateTime;

	@ManyToOne
	@JoinColumn(name = "buildingId", nullable = true)
	private BuildingEntity buildingEntity;

	public AreaEntity() {
		super();
		this.setBuildingEntity(new BuildingEntity());
	}

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

	public Integer getBuildingId() {
		return this.buildingEntity.getId();
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingEntity.setId(buildingId);
	}
}
