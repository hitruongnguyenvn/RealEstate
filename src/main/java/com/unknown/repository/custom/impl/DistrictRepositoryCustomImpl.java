package com.unknown.repository.custom.impl;

import org.springframework.stereotype.Repository;

import com.unknown.entity.DistrictEntity;
import com.unknown.repository.custom.DistrictRepositoryCustom;

@Repository
public class DistrictRepositoryCustomImpl implements DistrictRepositoryCustom {

	@Override
	public DistrictEntity findByIdCustom(Integer id) {
		return null;
	}

}
