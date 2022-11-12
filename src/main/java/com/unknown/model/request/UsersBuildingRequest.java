package com.unknown.model.request;

import java.util.List;

public class UsersBuildingRequest {
	private List<Integer> idsOld;
	private List<Integer> idsNew;
	private Integer buildingId;

	public List<Integer> getIdsOld() {
		return idsOld;
	}

	public void setIdsOld(List<Integer> idsOld) {
		this.idsOld = idsOld;
	}

	public List<Integer> getIdsNew() {
		return idsNew;
	}

	public void setIdsNew(List<Integer> idsNew) {
		this.idsNew = idsNew;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

}
