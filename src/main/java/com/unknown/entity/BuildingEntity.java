package com.unknown.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Building")
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "ward")
	private String ward;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "numberOfBasement")
	private Integer numberOfBasement;
	
	@Column(name = "discribe")
	private String discribe;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "managerName")
	private String managerName;
	
	@Column(name = "managerPhoneNumber")
	private String managerPhoneNumber;
	
	@Column(name = "districtId")
	private Integer districtId;
	
	@Column(name = "buildingTypeId")
	private Integer buildingTypeId;

	@OneToMany(mappedBy = "buildingEntity")
	List<AreaEntity> areaEnties = new ArrayList<>();
	
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

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public String getDiscribe() {
		return discribe;
	}

	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public Integer getBuildingTypeId() {
		return buildingTypeId;
	}

	public void setBuildingTypeId(Integer buildingTypeId) {
		this.buildingTypeId = buildingTypeId;
	}

	public List<AreaEntity> getAreaEnties() {
		return areaEnties;
	}

	public void setAreaEnties(List<AreaEntity> areaEnties) {
		this.areaEnties = areaEnties;
	}

}
