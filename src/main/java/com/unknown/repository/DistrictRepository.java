package com.unknown.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unknown.entity.DistrictEntity;
import com.unknown.repository.custom.DistrictRepositoryCustom;

public interface DistrictRepository extends JpaRepository<DistrictEntity, Integer>, DistrictRepositoryCustom {

}
