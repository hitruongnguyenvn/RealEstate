package com.unknown.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unknown.model.response.UsersResponse;

@RestController
@RequestMapping("/api/users")
public class UsersAPI {
	public List<UsersResponse> getEmployees(@RequestParam("buildingId") Integer buildingId){
		List<UsersResponse> results = new ArrayList<>();
		return results;
	}
}
