package com.unknown.repository.custom;

import java.util.List;

import com.unknown.entity.UsersEntity;
import com.unknown.model.request.CustomerRequest;

public interface UsersRepositoryCustom {
	List<UsersEntity> findByRoleId(Integer id);

	List<UsersEntity> findByTwoRole(String roleFirst, String roleSecond);

	List<UsersEntity> findCustomer(CustomerRequest customerRequest);
}
