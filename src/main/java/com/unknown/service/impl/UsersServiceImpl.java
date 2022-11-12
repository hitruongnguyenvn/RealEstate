package com.unknown.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.converter.UsersConverter;
import com.unknown.custom.exception.ErrorGeneralException;
import com.unknown.entity.BuildingEntity;
import com.unknown.entity.UsersBuildingEntity;
import com.unknown.entity.UsersEntity;
import com.unknown.enums.GenderEnum;
import com.unknown.model.request.CustomerRequest;
import com.unknown.model.response.UsersResponse;
import com.unknown.repository.BuildingRepository;
import com.unknown.repository.UsersRepository;
import com.unknown.service.UsersService;
import com.unknown.utils.SecurityUtils;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private UsersConverter usersConverter;

	@Override
	public List<UsersResponse> findByRoleId(Integer id) {
		List<UsersEntity> usersEntities = usersRepository.findByRoleId(id);
		List<UsersResponse> results = new ArrayList<>();
		for (UsersEntity item : usersEntities) {
			UsersResponse usersResponse = usersConverter.convertEntityToUsersResponse(item);
			results.add(usersResponse);
		}
		return results;
	}

	@Override
	public List<UsersResponse> findByTwoRole(String roleFirst, String roleSecond) {
		List<UsersEntity> usersEntities = usersRepository.findByTwoRole(roleFirst, roleSecond);
		List<UsersResponse> results = new ArrayList<>();
		usersEntities.stream().forEach(item -> results.add(usersConverter.convertEntityToUsersResponse(item)));
		return results;
	}

	@Override
	public List<UsersResponse> findAll() {
		List<UsersEntity> usersEntities = usersRepository.findAll();
		List<UsersResponse> results = new ArrayList<>();
		for (UsersEntity item : usersEntities) {
			UsersResponse usersResponse = usersConverter.convertEntityToUsersResponse(item);
			results.add(usersResponse);
		}
		return results;
	}

	@Override
	public List<UsersResponse> findByBuildingId(Integer buildingId) {
		Optional<BuildingEntity> buildingEntity = buildingRepository.findById(buildingId);
		List<UsersBuildingEntity> usersBuildingEntities = null;
		List<UsersResponse> results = new ArrayList<>();
		if (buildingEntity.isPresent()) {
			usersBuildingEntities = buildingEntity.get().getUsersBuildingEntities();
			usersBuildingEntities.stream()
					.forEach(item -> results.add(usersConverter.convertEntityToUsersResponse(item.getUsersEntity())));
		}
		return results;
	}

	@Override
	public Map<String, String> getGender() {
		Map<String, String> gender = new HashMap<String, String>();
		for (GenderEnum item : GenderEnum.values()) {
			gender.put(item.toString(), item.getGenderValue());
		}
		return gender;
	}

	@Override
	public List<UsersResponse> findCustomer(CustomerRequest customerRequest) {
		String role = SecurityUtils.getAuthorities().get(0);
		Integer manageId = SecurityUtils.getPrincipal().getId();
		customerRequest.setRole(role);
		customerRequest.setManagerId(manageId);
		List<UsersEntity> usersEntities = usersRepository.findCustomer(customerRequest);
		List<UsersResponse> results = new ArrayList<>();
		usersEntities.stream().forEach(item -> results.add(usersConverter.convertEntityToUsersResponse(item)));
		return results;
	}

	@Override
	@Transactional
	public UsersResponse save(CustomerRequest customerRequest) {
		if (customerRequest.getId() == null) {
			UsersEntity usersEntity = usersRepository.findOneByUserName(customerRequest.getUserName());
			if (usersEntity != null) {
				throw new ErrorGeneralException("Username Already Exist");
			}
		}
		UsersEntity usersEntity = usersConverter.convertCustomerRequestToEntity(customerRequest);
		UsersResponse result = usersConverter.convertEntityToUsersResponse(usersRepository.save(usersEntity));
		return result;
	}

	@Override
	public UsersResponse findById(Integer id) {
		UsersEntity usersEntity = usersRepository.findById(id).get();
		UsersResponse result = usersConverter.convertEntityToUsersResponse(usersEntity);
		return result;
	}
}
