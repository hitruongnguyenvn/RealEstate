package com.unknown.service;

import java.util.List;

import com.unknown.model.response.AreaResponse;

public interface IAreaService {

	public List<AreaResponse> findByBuildingId(Integer buildingId);
}
