package com.unknown.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.entity.AreaEntity;
import com.unknown.entity.BuildingEntity;
import com.unknown.entity.CityEntity;
import com.unknown.entity.DistrictEntity;
import com.unknown.model.response.BuildingSearchResponse;
import com.unknown.repository.IAreaRepository;
import com.unknown.repository.IBuildingRepository;
import com.unknown.repository.ICityRepository;
import com.unknown.repository.IDistrictRepository;
import com.unknown.service.IBuildingService;

@Service
public class BuildingService implements IBuildingService {
	@Autowired
	private IBuildingRepository buildingRepository;
	@Autowired
	private IAreaRepository areaRepository;
	@Autowired
	private IDistrictRepository districtRepository;
	@Autowired
	private ICityRepository cityRepository;

	@Override
	public List<BuildingSearchResponse> findAll(Map<String, String> params, List<String> buildingTypes) {
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(params, buildingTypes);
		List<BuildingSearchResponse> results = new ArrayList<>();
		int size = buildingEntities.size();
		for (int i = 0; i < size; ++i) {
			BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse();
			DistrictEntity districtEntity = districtRepository.findById(buildingEntities.get(i).getDistrictId());
			CityEntity cityEntity = cityRepository.findById(districtEntity.getCityId());
			buildingSearchResponse.setId(buildingEntities.get(i).getId());
			buildingSearchResponse.setName(buildingEntities.get(i).getName());
			buildingSearchResponse.setAddress(buildingEntities.get(i).getStreet() + " - " + buildingEntities.get(i).getWard() + " - "
					+ districtEntity.getName() + " - " + cityEntity.getName());
			buildingSearchResponse.setDiscribe(buildingEntities.get(i).getDiscribe());
			buildingSearchResponse.setManagerName(buildingEntities.get(i).getManagerName());
			buildingSearchResponse.setManagerPhoneNumber(buildingEntities.get(i).getManagerPhoneNumber());
			buildingSearchResponse.setNumberOfBasement(buildingEntities.get(i).getNumberOfBasement());
			List<AreaEntity> areaEntities = areaRepository.findByBuildingId(params, buildingEntities.get(i).getId());
			int sizeArea = areaEntities.size();
			int prev = 0;
			boolean check = false;
			if (sizeArea > 0) {
				prev = areaEntities.get(0).getFloor();
			}
			for (int j = 0; j < sizeArea; ++j) {
				StringBuilder builder = new StringBuilder();
				if (prev == areaEntities.get(j).getFloor()) {
					if (areaEntities.get(j).getStatus() == 1) {
						check = true;
						builder.append("Tầng: " + areaEntities.get(j).getFloor());
						builder.append(" - Diện Tích: " + areaEntities.get(j).getArea() + " (Đã thuê)");
						buildingSearchResponse.getAreaEmpty().add(builder.toString());
					} else {
						builder.append("Tầng: " + areaEntities.get(j).getFloor());
						builder.append(" - Diện Tích: " + areaEntities.get(j).getArea() + " (Chưa thuê)");
						buildingSearchResponse.getAreaEmpty().add(builder.toString());
						if (sizeArea == 1) {
							buildingSearchResponse.getFloorEmpty().add("Tầng: " + prev);
						}
					}
				} else {
					if (check == false) {
						buildingSearchResponse.getFloorEmpty().add("Tầng: " + prev);
					}
					check = false;
					prev = areaEntities.get(j).getFloor();
					if (areaEntities.get(j).getStatus() == 1) {
						check = true;
						builder.append("Tầng: " + areaEntities.get(j).getFloor());
						builder.append(" - Diện Tích: " + areaEntities.get(j).getArea() + " (Đã thuê)");
						buildingSearchResponse.getAreaEmpty().add(builder.toString());
					} else {
						builder.append("Tầng: " + areaEntities.get(j).getFloor());
						builder.append(" - Diện Tích: " + areaEntities.get(j).getArea() + " (Chưa thuê)");
						buildingSearchResponse.getAreaEmpty().add(builder.toString());
						if (j == (sizeArea - 1)) {
							buildingSearchResponse.getFloorEmpty().add("Tầng: " + prev);
						}
					}

				}
			}
			results.add(buildingSearchResponse);
		}
		return results;
	}

}
