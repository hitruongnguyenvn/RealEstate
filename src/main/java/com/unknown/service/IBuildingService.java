package com.unknown.service;

import java.util.List;
import java.util.Map;

import com.unknown.model.response.AreaResponse;
import com.unknown.model.response.BuildingResponse;
import com.unknown.model.response.BuildingSearchResponse;

public interface IBuildingService {
	public List<BuildingSearchResponse> findAll(Map<String, Object> params, List<String> buildingTypes);

	public List<AreaResponse> findAreaByBuildingId(Integer buildingId);

	public BuildingResponse findById(Integer id);
}
