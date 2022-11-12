package com.unknown.model.request;

import java.util.List;

public class BuildingSearchRequest {
	private String name;
	private String district;
	private String ward;
	private String street;
	private Integer numberOfBasement;
	private Integer status;
	private Integer usersId;
	private String managerName;
	private String managerPhoneNumber;
	private String areaTo;
	private String areaFrom;
	private Float priceTo;
	private Float priceFrom;
	private List<String> buildingType;

	public BuildingSearchRequest() {

	}

	public BuildingSearchRequest(Builder builder) {
		this.setName(builder.getName());
		this.setDistrict(builder.getDistrict());
		this.setWard(builder.getWard());
		this.setStreet(builder.getStreet());
		this.setNumberOfBasement(builder.getNumberOfBasement());
		this.setStatus(builder.getStatus());
		this.setUsersId(builder.getUsersId());
		this.setManagerName(builder.getManagerName());
		this.setManagerPhoneNumber(builder.getManagerPhoneNumber());
		this.setAreaFrom(builder.getAreaFrom());
		this.setAreaTo(builder.getAreaTo());
		this.setPriceTo(builder.getPriceTo());
		this.setAreaFrom(builder.getAreaFrom());
		this.setBuildingType(builder.getBuildingType());

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
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

	public String getAreaTo() {
		return areaTo;
	}

	public void setAreaTo(String areaTo) {
		this.areaTo = areaTo;
	}

	public String getAreaFrom() {
		return areaFrom;
	}

	public void setAreaFrom(String areaFrom) {
		this.areaFrom = areaFrom;
	}

	public Float getPriceTo() {
		return priceTo;
	}

	public void setPriceTo(Float priceTo) {
		this.priceTo = priceTo;
	}

	public Float getPriceFrom() {
		return priceFrom;
	}

	public void setPriceFrom(Float priceFrom) {
		this.priceFrom = priceFrom;
	}

	public List<String> getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(List<String> buildingType) {
		this.buildingType = buildingType;
	}

	public static class Builder {
		private String name;
		private String district;
		private String ward;
		private String street;
		private Integer numberOfBasement;
		private Integer status;
		private Integer usersId;
		private String managerName;
		private String managerPhoneNumber;
		private String areaTo;
		private String areaFrom;
		private Float priceTo;
		private Float priceFrom;
		private List<String> buildingType;

		public String getName() {
			return name;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public String getDistrict() {
			return district;
		}

		public Builder setDistrict(String district) {
			this.district = district;
			return this;
		}

		public String getWard() {
			return ward;
		}

		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}

		public String getStreet() {
			return street;
		}

		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}

		public Integer getNumberOfBasement() {
			return numberOfBasement;
		}

		public Builder setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}

		public Integer getStatus() {
			return status;
		}

		public Builder setStatus(Integer status) {
			this.status = status;
			return this;
		}

		public Integer getUsersId() {
			return usersId;
		}

		public Builder setUsersId(Integer usersId) {
			this.usersId = usersId;
			return this;
		}

		public String getManagerName() {
			return managerName;
		}

		public Builder setManagerName(String managerName) {
			this.managerName = managerName;
			return this;
		}

		public String getManagerPhoneNumber() {
			return managerPhoneNumber;
		}

		public Builder setManagerPhoneNumber(String managerPhoneNumber) {
			this.managerPhoneNumber = managerPhoneNumber;
			return this;
		}

		public String getAreaTo() {
			return areaTo;
		}

		public Builder setAreaTo(String areaTo) {
			this.areaTo = areaTo;
			return this;
		}

		public String getAreaFrom() {
			return areaFrom;
		}

		public Builder setAreaFrom(String areaFrom) {
			this.areaFrom = areaFrom;
			return this;
		}

		public Float getPriceTo() {
			return priceTo;
		}

		public Builder setPriceTo(Float priceTo) {
			this.priceTo = priceTo;
			return this;
		}

		public Float getPriceFrom() {
			return priceFrom;
		}

		public Builder setPriceFrom(Float priceFrom) {
			this.priceFrom = priceFrom;
			return this;
		}

		public List<String> getBuildingType() {
			return buildingType;
		}

		public Builder setBuildingType(List<String> buildingType) {
			this.buildingType = buildingType;
			return this;
		}

		public BuildingSearchRequest build() {
			BuildingSearchRequest buildingSearchRequest = new BuildingSearchRequest(this);
			return buildingSearchRequest;
		}

	}

}
