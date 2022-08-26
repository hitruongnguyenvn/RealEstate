package com.unknown.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unknown.model.response.UsersResponse;

@RestController
@RequestMapping("/api/users")
public class UsersAPI {

	@GetMapping
	public List<UsersResponse> getEmployees(@RequestParam(value = "buildingId", required = false) Integer buildingId) {
		List<UsersResponse> results = new ArrayList<>();
		return results;
	}

}
