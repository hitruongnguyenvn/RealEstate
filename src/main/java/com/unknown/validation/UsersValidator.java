package com.unknown.validation;

import com.unknown.custom.exception.FormatException;
import com.unknown.model.request.CustomerRequest;

public class UsersValidator {

	public static void validationCreate(CustomerRequest customerRequest) {
		if (!customerRequest.getUserName().matches("^[a-z0-9]+$")) {
			throw new FormatException("User name wrong format");
		}
	}

	/*
	 * public static void validationUpdate(BuildingUpdateRequest buildingRequest) {
	 * if (StringUtils.isNullOrEmpty(buildingRequest.getName())) { throw new
	 * FieldNotFoundException("Name is required"); } if (buildingRequest.getStatus()
	 * == null) { throw new FieldNotFoundException("Status is required"); } if
	 * (buildingRequest.getDistrictId() == null) { throw new
	 * FieldNotFoundException("District is required"); } if
	 * (buildingRequest.getBuildingTypeId() == null) { throw new
	 * FieldNotFoundException("Building type is required"); } }
	 */
}
