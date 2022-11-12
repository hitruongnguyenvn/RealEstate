package com.unknown.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unknown.model.request.BuildingSearchRequest;
import com.unknown.model.request.BuildingUpdateRequest;
import com.unknown.model.request.UsersBuildingRequest;
import com.unknown.model.response.BuildingSearchResponse;
import com.unknown.model.response.BuildingUpdateResponse;
import com.unknown.service.BuildingService;
import com.unknown.validation.BuildingValidator;

@RestController(value = "apiBuilding")
@RequestMapping("/api/building")
public class BuildingAPI {

	@Autowired
	private BuildingService buildingService;

	@GetMapping
	public List<BuildingSearchResponse> findAll(@RequestParam Map<String, Object> requestParams,
			@RequestParam(value = "buildingType", required = false) List<String> buildingTypes,
			@RequestBody BuildingSearchRequest buildingSearchRequest) {
		List<BuildingSearchResponse> resutls = new ArrayList<>();
		resutls = buildingService.findBuilding(requestParams, buildingTypes);
		return resutls;
	}

	@PostMapping
	public BuildingUpdateRequest insertBuilding(@RequestBody BuildingUpdateRequest buildingRequest) {
		BuildingValidator.validationCreate(buildingRequest);
		BuildingUpdateResponse result = buildingService.save(buildingRequest);
		return buildingRequest;
	}

	@PutMapping
	public BuildingUpdateResponse updateBuilding(@RequestBody BuildingUpdateRequest buildingRequest) {
		BuildingValidator.validationUpdate(buildingRequest);
		BuildingUpdateResponse result = buildingService.save(buildingRequest);
		return result;
	}

	@DeleteMapping
	public void deleteBuilding(@RequestBody BuildingUpdateRequest updateRequest) {
		buildingService.delete(updateRequest);
	}

	@GetMapping("/{buildingId}")
	public BuildingUpdateResponse getBuildingDetail(@PathVariable("buildingId") Integer id) {
		BuildingUpdateResponse resutl = new BuildingUpdateResponse();
		return resutl;
	}

	@PostMapping("/assignment")
	public Integer assignmentBuilding(@RequestBody UsersBuildingRequest request) {
		buildingService.save(request);
		return request.getBuildingId();
	}

}
