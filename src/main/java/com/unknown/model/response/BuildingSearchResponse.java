package com.unknown.model.response;

import java.util.ArrayList;
import java.util.List;

public class BuildingSearchResponse {
	private Integer id;
	private String name;
	private String address;
	private Integer numberOfBasement;
	private String discribe;
	private String managerName;
	private String managerPhoneNumber;
	private List<String> areaEmpty;
	private List<String> floorEmpty;
	private Boolean checkUserBuilding;

	public BuildingSearchResponse() {
		this.setAreaEmpty(new ArrayList<>());
		this.setFloorEmpty(new ArrayList<>());
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public List<String> getAreaEmpty() {
		return areaEmpty;
	}

	public void setAreaEmpty(List<String> areaEmpty) {
		this.areaEmpty = areaEmpty;
	}

	public List<String> getFloorEmpty() {
		return floorEmpty;
	}

	public void setFloorEmpty(List<String> floorEmpty) {
		this.floorEmpty = floorEmpty;
	}

	public Boolean getCheckUserBuilding() {
		return checkUserBuilding;
	}

	public void setCheckUserBuilding(Boolean checkUserBuilding) {
		this.checkUserBuilding = checkUserBuilding;
	}
}
