package com.unknown.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unknown.model.response.AreaResponse;
import com.unknown.service.IAreaService;

@RestController
@RequestMapping("/api/area")
public class AreaAPI {

	@Autowired
	private IAreaService areaService;

	@GetMapping
	public List<AreaResponse> getEmployees(@RequestParam(value = "buildingId", required = false) Integer buildingId) {
		List<AreaResponse> results = areaService.findByBuildingId(buildingId);
		return results;
	}

}
