package com.unknown.converter;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unknown.entity.AreaEntity;
import com.unknown.entity.BuildingEntity;
import com.unknown.entity.CityEntity;
import com.unknown.entity.DistrictEntity;
import com.unknown.model.response.BuildingResponse;
import com.unknown.model.response.BuildingSearchResponse;
import com.unknown.repository.IAreaRepository;
import com.unknown.repository.ICityRepository;
import com.unknown.repository.IDistrictRepository;

@Component
public class BuildingConverter {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private IDistrictRepository districtRepository;
	@Autowired
	private ICityRepository cityRepository;
	@Autowired
	private IAreaRepository areaRepository;

	public BuildingSearchResponse convertEntityToSearchResponse(BuildingEntity buildingEntity,
			Map<String, Object> params) {
		BuildingSearchResponse buildingSearchResponse = modelMapper.map(buildingEntity, BuildingSearchResponse.class);
		DistrictEntity districtEntity = districtRepository.findById(buildingEntity.getDistrictId());
		CityEntity cityEntity = cityRepository.findById(districtEntity.getCityId());
		buildingSearchResponse.setAddress(buildingEntity.getStreet() + " - " + buildingEntity.getWard() + " - "
				+ districtEntity.getName() + " - " + cityEntity.getName());
		List<AreaEntity> areaEntities = areaRepository.findByBuildingId(params, buildingEntity.getId());
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
		return buildingSearchResponse;
	}

	public BuildingResponse convertEntityToResponse(BuildingEntity buildingEntity) {
		return null;
	}
}
