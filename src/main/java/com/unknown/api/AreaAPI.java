package com.unknown.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unknown.model.request.AreaUpdateRequest;
import com.unknown.model.response.AreaResponse;
import com.unknown.service.AreaService;
import com.unknown.validation.AreaValidator;

@RestController(value = "apiArea")
@RequestMapping("/api/area")
public class AreaAPI {

	@Autowired
	private AreaService areaService;

	@GetMapping
	public List<AreaResponse> getEmployees(@RequestParam(value = "buildingId", required = false) Integer buildingId) {
		List<AreaResponse> results = areaService.findByBuildingId(buildingId, 0);
		return results;
	}

	@PutMapping
	public AreaResponse updateArea(@RequestBody AreaUpdateRequest updateRequest) {
		AreaValidator.validation(updateRequest);
		AreaResponse result = areaService.save(updateRequest);
		return result;
	}

	@PostMapping
	public AreaResponse insertArea(@RequestBody AreaUpdateRequest updateRequest) {
		AreaValidator.validation(updateRequest);
		AreaResponse result = areaService.save(updateRequest);
		return result;
	}

	@DeleteMapping
	public Integer deleteArea(@RequestBody AreaUpdateRequest updateRequest) {
		areaService.delete(updateRequest);
		return updateRequest.getBuildingId();
	}
}
