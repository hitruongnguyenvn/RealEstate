package com.unknown.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unknown.entity.BuildingEntity;
import com.unknown.repository.custom.BuildingRepositoryCustom;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Integer>, BuildingRepositoryCustom {

}
