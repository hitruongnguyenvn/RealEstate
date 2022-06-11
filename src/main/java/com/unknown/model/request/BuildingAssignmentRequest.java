package com.unknown.model.request;

import java.util.List;

public class BuildingAssignmentRequest {
	private Integer buildingId;
	private List<Integer> usersId;

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public List<Integer> getUsersId() {
		return usersId;
	}

	public void setUsersId(List<Integer> usersId) {
		this.usersId = usersId;
	}
}
