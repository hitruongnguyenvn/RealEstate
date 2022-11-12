package com.unknown.model.request;

public class AreaSearchRequest {
	private Integer buildingId;
	private String areaTo;
	private String areaFrom;
	private Float priceTo;
	private Float priceFrom;

	public AreaSearchRequest() {

	}

	public AreaSearchRequest(Builder builder) {
		this.setBuildingId(builder.getBuildingId());
		this.setAreaTo(builder.getAreaTo());
		this.setAreaFrom(builder.getAreaFrom());
		this.setPriceTo(builder.getPriceTo());
		this.setPriceFrom(builder.getPriceFrom());
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
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

	public static class Builder {
		private Integer buildingId;
		private String areaTo;
		private String areaFrom;
		private Float priceTo;
		private Float priceFrom;

		public Integer getBuildingId() {
			return buildingId;
		}

		public Builder setBuildingId(Integer buildingId) {
			this.buildingId = buildingId;
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

		public AreaSearchRequest build() {
			AreaSearchRequest areaSearchRequest = new AreaSearchRequest(this);
			return areaSearchRequest;
		}

	}
}
