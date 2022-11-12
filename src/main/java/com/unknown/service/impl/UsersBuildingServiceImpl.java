package com.unknown.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.authorization.UsersBuildingAuthorization;
import com.unknown.model.request.UsersBuildingRequest;
import com.unknown.repository.UsersBuildingRepository;
import com.unknown.service.UsersBuildingService;

@Service
public class UsersBuildingServiceImpl implements UsersBuildingService {

	@Autowired
	private UsersBuildingRepository usersBuildingRepository;

	@Autowired
	private UsersBuildingAuthorization usersBuildingAuthorization;

	@Override
	@Transactional
	public void updateUsersBuilding(UsersBuildingRequest request) {
		/*
		 * if (request.getBuildingId() != null) {
		 * usersBuildingAuthorization.checkUsersBuilding(request.getBuildingId()); }
		 * List<Integer> idsOld = request.getIdsOld(); List<Integer> idsNew =
		 * request.getIdsNew(); Integer buildingId = request.getBuildingId(); for (int i
		 * = 0; i < idsNew.size(); i++) { if (idsOld.contains(idsNew.get(i))) {
		 * idsOld.remove(idsNew.get(i)); idsNew.remove(idsNew.get(i)); } } for (int i =
		 * 0; i < idsOld.size(); i++) { // delete
		 * usersBuildingRepository.deleteByBuildingIdAnUsersId(buildingId,
		 * idsOld.get(i)); } for (int i = 0; i < idsNew.size(); i++) { // innsert
		 * UsersBuildingEntity usersBuildingEntity = new UsersBuildingEntity();
		 * BuildingEntity buildingEntity = new BuildingEntity(); UsersEntity usersEntity
		 * = new UsersEntity(); buildingEntity.setId(buildingId);
		 * usersEntity.setId(idsNew.get(i));
		 * usersBuildingEntity.setBuildingEntity(buildingEntity);
		 * usersBuildingEntity.setUsersEntity(usersEntity);
		 * usersBuildingRepository.save(usersBuildingEntity); }
		 */

	}

}
