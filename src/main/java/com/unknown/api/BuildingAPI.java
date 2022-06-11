package com.unknown.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.unknown.custom.exception.FieldNotFoundException;
import com.unknown.model.request.BuildingAssignmentRequest;
import com.unknown.model.request.BuildingRequest;
import com.unknown.model.response.BuildingResponse;
import com.unknown.model.response.BuildingSearchResponse;
import com.unknown.service.IBuildingService;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

	@Autowired
	private IBuildingService buildingService;

	@GetMapping
	public List<BuildingSearchResponse> findAll(@RequestParam Map<String, String> requestParams,
			@RequestParam(value = "buildingType", required = false) List<String> buildingTypes,
			@RequestBody BuildingRequest buildingRequest) {
		List<BuildingSearchResponse> resutls = new ArrayList<>();
		resutls = buildingService.findAll(requestParams, buildingTypes);
		return resutls;
	}
	
	@PostMapping
	public BuildingResponse insertBuilding(@RequestBody BuildingRequest buildingRequest) {
		try {
			validation(buildingRequest);
		} catch (FieldNotFoundException e) {
			throw e;
		}
		
		BuildingResponse result = new BuildingResponse();
		return result;
	}
	
	public void validation(BuildingRequest buildingRequest) {
		if(buildingRequest.getName() == null) {
			throw new FieldNotFoundException("Name is requỉed");
		}
	}
	
	@GetMapping("/{buildingId}")
	public BuildingResponse getBuildingDetail(@PathVariable("buildingId") Integer id) {
		BuildingResponse resutl = new BuildingResponse();
		return resutl;
	}
	
	@PostMapping("/assignment")
	public void assignmentBuilding(@RequestBody BuildingAssignmentRequest assignmentRequest) {
		//logic
	}
	
}
