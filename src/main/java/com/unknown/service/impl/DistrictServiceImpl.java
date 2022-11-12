package com.unknown.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.converter.DistrictConverter;
import com.unknown.entity.DistrictEntity;
import com.unknown.model.response.DistrictResponse;
import com.unknown.repository.DistrictRepository;
import com.unknown.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private DistrictConverter districtConverter;

	@Override
	public List<DistrictResponse> findAll() {
		List<DistrictEntity> districtEntities = districtRepository.findAll();
		List<DistrictResponse> results = new ArrayList<DistrictResponse>();
		for (DistrictEntity item : districtEntities) {
			DistrictResponse districtResponse = districtConverter.convertEntityToDistrictReponse(item);
			results.add(districtResponse);
		}
		return results;
	}

}
