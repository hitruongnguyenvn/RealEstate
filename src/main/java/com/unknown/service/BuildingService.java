package com.unknown.service;

import java.util.List;
import java.util.Map;

import com.unknown.model.request.BuildingSearchRequest;
import com.unknown.model.request.BuildingUpdateRequest;
import com.unknown.model.request.UsersBuildingRequest;
import com.unknown.model.response.AreaResponse;
import com.unknown.model.response.BuildingSearchResponse;
import com.unknown.model.response.BuildingUpdateResponse;

public interface BuildingService {
	public List<BuildingSearchResponse> findBuilding(Map<String, Object> params, List<String> buildingTypes);

	public List<BuildingSearchResponse> findBuilding(BuildingSearchRequest buildingSearchRequest);

	public List<AreaResponse> findAreaByBuildingId(Integer buildingId);

	public BuildingUpdateResponse findById(Integer id);

	public BuildingUpdateResponse save(BuildingUpdateRequest updateRequest);

	public Integer save(UsersBuildingRequest request);

	public void delete(BuildingUpdateRequest updateRequest);

}
