package com.unknown.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unknown.model.request.UsersBuildingRequest;
import com.unknown.service.UsersBuildingService;

@RestController(value = "apiUsersBuilding")
@RequestMapping("/api/usersbuilding")
public class UsersBuildingAPI {

	@Autowired
	private UsersBuildingService usersBuildingService;

	@PostMapping
	public Integer assignmentBuilding(@RequestBody UsersBuildingRequest request) {
		// usersBuildingService.updateUsersBuilding(request);
		// return request.getBuildingId();
		return null;
	}
}
