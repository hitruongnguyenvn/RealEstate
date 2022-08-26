package com.unknown.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.converter.AreaConverter;
import com.unknown.entity.AreaEntity;
import com.unknown.model.response.AreaResponse;
import com.unknown.repository.IAreaRepository;
import com.unknown.service.IAreaService;

@Service
public class AreaService implements IAreaService {
	@Autowired
	private IAreaRepository areaRepository;
	@Autowired
	private AreaConverter areaConverter;

	@Override
	public List<AreaResponse> findByBuildingId(Integer buildingId) {
		List<AreaEntity> areaEntities = areaRepository.findByBuildingId(null, buildingId);
		List<AreaResponse> result = new ArrayList<>();
		areaEntities.stream().forEach(item -> result.add(areaConverter.convertEntityToResponse(item)));
		return result;
	}
}
