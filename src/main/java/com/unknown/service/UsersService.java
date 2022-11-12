package com.unknown.service;

import java.util.List;
import java.util.Map;

import com.unknown.model.request.CustomerRequest;
import com.unknown.model.response.UsersResponse;

public interface UsersService {
	public List<UsersResponse> findByRoleId(Integer id);

	public List<UsersResponse> findAll();

	public List<UsersResponse> findByBuildingId(Integer buildingId);

	public List<UsersResponse> findByTwoRole(String roleFirst, String roleSecond);

	public Map<String, String> getGender();

	public List<UsersResponse> findCustomer(CustomerRequest customerRequest);

	public UsersResponse findById(Integer id);

	public UsersResponse save(CustomerRequest customerRequest);
}
