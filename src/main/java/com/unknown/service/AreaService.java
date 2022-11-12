package com.unknown.service;

import java.util.List;

import com.unknown.model.request.AreaUpdateRequest;
import com.unknown.model.response.AreaResponse;

public interface AreaService {

	public List<AreaResponse> findByBuildingId(Integer buildingId, Integer status);

	public AreaResponse save(AreaUpdateRequest updateRequest);

	public void delete(AreaUpdateRequest updateRequest);

	public void updateStatusById(Integer id);
}
