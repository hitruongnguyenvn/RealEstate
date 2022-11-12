package com.unknown.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unknown.entity.BuildingTypeEntity;
import com.unknown.model.response.BuildingTypeResponse;

@Component
public class BuildingTypeConverter {

	@Autowired
	private ModelMapper modelMapper;

	public BuildingTypeResponse convertEntityToResponse(BuildingTypeEntity buildingTypeEntity) {
		BuildingTypeResponse result = modelMapper.map(buildingTypeEntity, BuildingTypeResponse.class);
		return result;
	}

}
