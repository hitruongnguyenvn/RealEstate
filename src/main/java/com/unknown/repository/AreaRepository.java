package com.unknown.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unknown.entity.AreaEntity;
import com.unknown.repository.custom.AreaRepositoryCustom;

public interface AreaRepository extends JpaRepository<AreaEntity, Integer>, AreaRepositoryCustom {

}
