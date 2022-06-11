package com.unknown.service;

import java.util.List;
import java.util.Map;

import com.unknown.model.response.BuildingSearchResponse;

public interface IBuildingService {
	public List<BuildingSearchResponse> findAll(Map<String, String> params, List<String> buildingTypes);
}
