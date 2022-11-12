package com.unknown.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unknown.entity.DistrictEntity;
import com.unknown.model.response.DistrictResponse;

@Component
public class DistrictConverter {

	@Autowired
	private ModelMapper modelMapper;

	public DistrictResponse convertEntityToDistrictReponse(DistrictEntity districtEntity) {
		DistrictResponse result = modelMapper.map(districtEntity, DistrictResponse.class);
		return result;
	}
}
