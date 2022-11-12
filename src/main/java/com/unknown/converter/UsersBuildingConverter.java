package com.unknown.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unknown.entity.UsersBuildingEntity;
import com.unknown.model.request.UsersBuildingRequest;

@Component
public class UsersBuildingConverter {

	@Autowired
	private ModelMapper modelMapper;

	public UsersBuildingEntity convertRequestToEntity(UsersBuildingRequest request) {
		UsersBuildingEntity result = new UsersBuildingEntity();

		return result;
	}
}
