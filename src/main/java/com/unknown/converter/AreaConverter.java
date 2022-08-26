package com.unknown.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unknown.entity.AreaEntity;
import com.unknown.model.response.AreaResponse;

@Component
public class AreaConverter {
	@Autowired
	private ModelMapper modelMapper;

	public AreaResponse convertEntityToResponse(AreaEntity entity) {
		AreaResponse areaResponse = modelMapper.map(entity, AreaResponse.class);
		areaResponse.setBuildingName(entity.getBuildingEntity().getName());
		return areaResponse;
	}
}
