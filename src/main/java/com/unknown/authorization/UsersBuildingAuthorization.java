package com.unknown.authorization;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unknown.constant.RoleConstant;
import com.unknown.custom.exception.ErrorGeneralException;
import com.unknown.entity.UsersBuildingEntity;
import com.unknown.entity.UsersEntity;
import com.unknown.repository.UsersRepository;
import com.unknown.utils.SecurityUtils;

@Component
public class UsersBuildingAuthorization {

	@Autowired
	private UsersRepository usersRepository;

	public void checkUsersBuilding(Integer buildingId) {
		Integer userId = SecurityUtils.getPrincipal().getId();
		UsersEntity usersEntity = usersRepository.getOne(userId);
		List<UsersBuildingEntity> entities = usersEntity.getUsersBuildingEntities();
		if (checkRole()) {
			for (UsersBuildingEntity item : entities) {
				if (item.getBuildingEntity().getId() == buildingId) {
					return;
				}
			}
			throw new ErrorGeneralException("No Authorization");
		}
	}

	public Boolean checkUserBuilding(Integer buildingId) {
		try {
			checkUsersBuilding(buildingId);
		} catch (ErrorGeneralException e) {
			return false;
		}
		return true;
	}

	public Boolean checkRole() {
		List<String> roles = new ArrayList<String>();
		roles.add(RoleConstant.ROLE_ADMIN);
		roles.add(RoleConstant.ROLE_USER);
		if (!roles.containsAll(SecurityUtils.getAuthorities())) {
			return false;
		}
		return true;
	}

}
