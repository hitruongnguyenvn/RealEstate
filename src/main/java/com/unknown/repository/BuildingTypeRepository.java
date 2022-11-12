package com.unknown.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unknown.entity.BuildingTypeEntity;
import com.unknown.repository.custom.BuildingTypeRepositoryCustom;

public interface BuildingTypeRepository
		extends JpaRepository<BuildingTypeEntity, Integer>, BuildingTypeRepositoryCustom {

}
