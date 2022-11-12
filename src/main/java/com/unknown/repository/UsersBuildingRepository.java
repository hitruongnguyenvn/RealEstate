package com.unknown.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unknown.entity.UsersBuildingEntity;
import com.unknown.repository.custom.UsersBuildingRepositoryCustom;

public interface UsersBuildingRepository
		extends JpaRepository<UsersBuildingEntity, Integer>, UsersBuildingRepositoryCustom {
}
