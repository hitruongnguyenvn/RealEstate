package com.unknown.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unknown.model.request.CustomerRequest;
import com.unknown.model.response.UsersResponse;
import com.unknown.service.UsersService;
import com.unknown.validation.UsersValidator;

@RestController(value = "apiUsers")
@RequestMapping("/api/users")
public class UsersAPI {

	@Autowired
	private UsersService usersService;

	@GetMapping
	public List<UsersResponse> getUsers(@RequestParam(value = "buildingId", required = false) Integer buildingId) {
		List<UsersResponse> results = new ArrayList<>();
		return results;
	}

	@PostMapping
	public CustomerRequest insertUsers(@RequestBody CustomerRequest customerRequest) {
		UsersValidator.validationCreate(customerRequest);
		UsersResponse result = usersService.save(customerRequest);
		return customerRequest;
	}

	@PutMapping
	public UsersResponse updatetUsers(@RequestBody CustomerRequest customerRequest) {
		UsersResponse result = usersService.save(customerRequest);
		return result;
	}

	/*
	 * @GetMapping("/{roleId}") public List<UsersResponse>
	 * getUsersByRole(@PathVariable("roleId") Integer id) { List<UsersResponse>
	 * results = usersService.findByRoleId(id); return results; }
	 */
}
