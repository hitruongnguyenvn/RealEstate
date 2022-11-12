package com.unknown.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unknown.constant.RoleConstant;
import com.unknown.entity.RoleEntity;
import com.unknown.entity.UsersEntity;
import com.unknown.model.request.CustomerRequest;
import com.unknown.model.response.UsersResponse;
import com.unknown.repository.RoleRepository;
import com.unknown.repository.UsersRepository;
import com.unknown.utils.SecurityUtils;

@Component
public class UsersConverter {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UsersRepository usersRepository;

	public UsersResponse convertEntityToUsersResponse(UsersEntity usersEntity) {
		UsersResponse usersResponse = modelMapper.map(usersEntity, UsersResponse.class);
		usersResponse.setFullNameManage(usersEntity.getManager().getFullName());
		usersResponse.setManageId(usersEntity.getManager().getId());
		return usersResponse;
	}

	public UsersEntity convertCustomerRequestToEntity(CustomerRequest customerRequest) {
		Integer manageId = SecurityUtils.getPrincipal().getId();
		customerRequest.setManagerId(manageId);
		UsersEntity result = modelMapper.map(customerRequest, UsersEntity.class);
		if (customerRequest.getId() == null) {
			UsersEntity manager = new UsersEntity();
			manager.setId(customerRequest.getManagerId());
			RoleEntity role = roleRepository.findOneByCode(RoleConstant.USER);
			result.setManager(manager);
			result.setPassword("$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG");
			result.setRoleEntity(role);
		} else {
			UsersEntity usersOld = usersRepository.findById(customerRequest.getId()).get();
			result.setUserName(usersOld.getUserName());
			result.setPassword(usersOld.getPassword());
			result.setRoleEntity(usersOld.getRoleEntity());
			if (customerRequest.getEmpoloyeeOfCharge() != null) {
				UsersEntity manager = new UsersEntity();
				manager.setId(customerRequest.getEmpoloyeeOfCharge());
				result.setManager(manager);
			} else {
				result.setManager(usersOld.getManager());
			}

		}
		result.setFullName(customerRequest.getName());
		result.setStt(1);
		return result;
	}
}
