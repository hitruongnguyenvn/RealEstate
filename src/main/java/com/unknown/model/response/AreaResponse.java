package com.unknown.model.response;

public class AreaResponse {
	private Integer id;
	private Integer buildingId;
	private Integer floor;
	private String area;
	private Double price;
	private Double deposit;
	private Double decorateTime;
	private String buildingName;
	private Integer status;
	private String statusString;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
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

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStatusString() {
		return statusString;
	}

	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}
}
