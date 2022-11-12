package com.unknown.validation;

import com.unknown.custom.exception.FieldNotFoundException;
import com.unknown.custom.exception.FormatException;
import com.unknown.model.request.BuildingUpdateRequest;
import com.unknown.utils.StringUtils;

public class BuildingValidator {

	public static void validationCreate(BuildingUpdateRequest buildingRequest) {
		if (StringUtils.isNullOrEmpty(buildingRequest.getName())) {
			throw new FieldNotFoundException("Name is required");
		}
		if (!buildingRequest.getArea().matches("^(-{0,1}[0-9]{1,}-[0-9]{1,}-[0-9]{1,};){1,}$")) {
			throw new FormatException("Area wrong format");
		}
		if (buildingRequest.getStatus() == null) {
			throw new FieldNotFoundException("Status is required");
		}
		if (buildingRequest.getDistrictId() == null) {
			throw new FieldNotFoundException("District is required");
		}
		if (buildingRequest.getBuildingTypeId() == null) {
			throw new FieldNotFoundException("Building type is required");
		}
	}

	public static void validationUpdate(BuildingUpdateRequest buildingRequest) {
		if (StringUtils.isNullOrEmpty(buildingRequest.getName())) {
			throw new FieldNotFoundException("Name is required");
		}
		if (buildingRequest.getStatus() == null) {
			throw new FieldNotFoundException("Status is required");
		}
		if (buildingRequest.getDistrictId() == null) {
			throw new FieldNotFoundException("District is required");
		}
		if (buildingRequest.getBuildingTypeId() == null) {
			throw new FieldNotFoundException("Building type is required");
		}
	}
}
