package com.unknown.model.request;

public class BuildingUpdateRequest {

	private Integer id;
	private String name;
	private String ward;
	private String street;
	private Integer numberOfBasement;
	private String discribe;
	private Integer status;
	private String managerName;
	private String managerPhoneNumber;
	private Integer districtId;
	private Integer buildingTypeId;
	private String directions;
	private String level;
	private String map;
	private String area;

	public BuildingUpdateRequest() {

	}

	public BuildingUpdateRequest(Builder builder) {
		this.setId(builder.getId());
		this.setName(builder.getName());
		this.setWard(builder.getWard());
		this.setStreet(builder.getStreet());
		this.setNumberOfBasement(builder.getNumberOfBasement());
		this.setDiscribe(builder.getDiscribe());
		this.setStatus(builder.getStatus());
		this.setManagerName(builder.getManagerName());
		this.setManagerPhoneNumber(builder.getManagerPhoneNumber());
		this.setDistrictId(builder.getDistrictId());
		this.setBuildingTypeId(builder.getBuildingTypeId());
		this.setDirections(builder.getDirections());
		this.setLevel(builder.getLevel());
		this.setMap(builder.getMap());
		this.setArea(builder.getArea());
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

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public static class Builder {
		private Integer id;
		private String name;
		private String ward;
		private String street;
		private Integer numberOfBasement;
		private String discribe;
		private Integer status;
		private String managerName;
		private String managerPhoneNumber;
		private Integer districtId;
		private Integer buildingTypeId;
		private String directions;
		private String level;
		private String map;
		private String area;

		public Integer getId() {
			return id;
		}

		public Builder setId(Integer id) {
			this.id = id;
			return this;
		}

		public String getName() {
			return name;
		}

		public Builder setName(String name) {
			this.name = name;
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

		public String getDiscribe() {
			return discribe;
		}

		public Builder setDiscribe(String discribe) {
			this.discribe = discribe;
			return this;
		}

		public Integer getStatus() {
			return status;
		}

		public Builder setStatus(Integer status) {
			this.status = status;
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

		public Integer getDistrictId() {
			return districtId;
		}

		public Builder setDistrictId(Integer districtId) {
			this.districtId = districtId;
			return this;
		}

		public Integer getBuildingTypeId() {
			return buildingTypeId;
		}

		public Builder setBuildingTypeId(Integer buildingTypeId) {
			this.buildingTypeId = buildingTypeId;
			return this;
		}

		public String getDirections() {
			return directions;
		}

		public Builder setDirections(String directions) {
			this.directions = directions;
			return this;
		}

		public String getLevel() {
			return level;
		}

		public Builder setLevel(String level) {
			this.level = level;
			return this;
		}

		public String getMap() {
			return map;
		}

		public Builder setMap(String map) {
			this.map = map;
			return this;
		}

		public String getArea() {
			return area;
		}

		public Builder setArea(String area) {
			this.area = area;
			return this;
		}

		public BuildingUpdateRequest build() {
			BuildingUpdateRequest result = new BuildingUpdateRequest(this);
			return result;
		}
	}
}
