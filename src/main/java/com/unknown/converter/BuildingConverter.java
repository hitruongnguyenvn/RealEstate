package com.unknown.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unknown.authorization.UsersBuildingAuthorization;
import com.unknown.entity.AreaEntity;
import com.unknown.entity.BuildingEntity;
import com.unknown.entity.BuildingTypeEntity;
import com.unknown.entity.CityEntity;
import com.unknown.entity.DistrictEntity;
import com.unknown.entity.UsersBuildingEntity;
import com.unknown.entity.UsersEntity;
import com.unknown.model.request.AreaSearchRequest;
import com.unknown.model.request.BuildingSearchRequest;
import com.unknown.model.request.BuildingUpdateRequest;
import com.unknown.model.request.UsersBuildingRequest;
import com.unknown.model.response.BuildingSearchResponse;
import com.unknown.model.response.BuildingUpdateResponse;
import com.unknown.repository.AreaRepository;
import com.unknown.repository.BuildingRepository;
import com.unknown.utils.MapUtils;
import com.unknown.utils.SecurityUtils;

@Component
public class BuildingConverter {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AreaRepository areaRepository;

	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private UsersBuildingAuthorization usersBuildingAuthorization;

	@Autowired
	private AreaConverter areaConverter;

	public BuildingSearchResponse convertEntityToSearchResponse(BuildingEntity buildingEntity,
			Map<String, Object> params) {
		BuildingSearchResponse buildingSearchResponse = modelMapper.map(buildingEntity, BuildingSearchResponse.class);
		DistrictEntity districtEntity = buildingEntity.getDistrictEntity();
		CityEntity cityEntity = buildingEntity.getDistrictEntity().getCityEntity();
		AreaSearchRequest areaSearchRequest = areaConverter.convertMapToSearchRequest(params);
		List<AreaEntity> areaEntities = areaRepository.findByBuildingIdCustom(buildingEntity.getId(), null,
				areaSearchRequest);
		buildingSearchResponse.setAddress(buildingEntity.getStreet() + " - " + buildingEntity.getWard() + " - "
				+ districtEntity.getName() + " - " + cityEntity.getName());
		buildingSearchResponse
				.setCheckUserBuilding(usersBuildingAuthorization.checkUserBuilding(buildingEntity.getId()));
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

	public BuildingUpdateResponse convertEntityToUpdateResponse(BuildingEntity buildingEntity) {
		BuildingUpdateResponse result = new BuildingUpdateResponse.Builder().setId(buildingEntity.getId())
				.setName(buildingEntity.getName()).setWard(buildingEntity.getWard())
				.setStreet(buildingEntity.getStreet()).setNumberOfBasement(buildingEntity.getNumberOfBasement())
				.setDiscribe(buildingEntity.getDiscribe()).setStatus(buildingEntity.getStatus())
				.setManagerName(buildingEntity.getManagerName())
				.setManagerPhoneNumber(buildingEntity.getManagerPhoneNumber())
				.setDistrictId(buildingEntity.getDistrictEntity().getId())
				.setBuildingTypeId(buildingEntity.getBuildingTypeEntity().getId())
				.setDirections(buildingEntity.getDirections()).setLevel(buildingEntity.getLevel())
				.setMap(buildingEntity.getMap()).build();
		return result;
	}

	public BuildingSearchRequest convertMapToSearchRequest(Map<String, Object> params, List<String> buildingTypes) {
		BuildingSearchRequest buildingSearchRequest = new BuildingSearchRequest.Builder()
				.setName(MapUtils.getValue(params, "name", String.class))
				.setDistrict(MapUtils.getValue(params, "district", String.class))
				.setWard(MapUtils.getValue(params, "ward", String.class))
				.setStreet(MapUtils.getValue(params, "street", String.class))
				.setNumberOfBasement(MapUtils.getValue(params, "numberOfBasement", Integer.class))
				.setStatus(MapUtils.getValue(params, "status", Integer.class))
				.setUsersId(MapUtils.getValue(params, "usersId", Integer.class))
				.setManagerName(MapUtils.getValue(params, "managerName", String.class))
				.setManagerPhoneNumber(MapUtils.getValue(params, "managerPhoneNumber", String.class))
				.setAreaTo(MapUtils.getValue(params, "areaTo", String.class))
				.setAreaFrom(MapUtils.getValue(params, "areaFrom", String.class))
				.setPriceTo(MapUtils.getValue(params, "priceTo", Float.class))
				.setPriceFrom(MapUtils.getValue(params, "priceFrom", Float.class)).setBuildingType(buildingTypes)
				.build();
		return buildingSearchRequest;
	}

	public Map<String, Object> convertBuildingSearchRequesToMap(BuildingSearchRequest buildingSearchRequest) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("areaTo", buildingSearchRequest.getAreaTo());
		params.put("areaFrom", buildingSearchRequest.getAreaFrom());
		params.put("priceTo", buildingSearchRequest.getPriceTo());
		params.put("priceFrom", buildingSearchRequest.getPriceFrom());
		return params;
	}

	public BuildingEntity convertUpdateRequestToEntity(BuildingUpdateRequest updateRequest) {
		BuildingEntity buildingEntity = modelMapper.map(updateRequest, BuildingEntity.class);
		Integer buildingId = updateRequest.getId();
		if (buildingId != null) {
			BuildingEntity buildingEntityOld = buildingRepository.getOne(buildingId);
			List<AreaEntity> areaEntities = buildingEntityOld.getAreaEnties();
			buildingEntity.setAreaEnties(areaEntities);
			buildingEntity.setUsersBuildingEntities(buildingEntityOld.getUsersBuildingEntities());
			if (updateRequest.getArea() != null) {
				areaEntities.clear();
				areaEntities.addAll(convertAreaToAreaEntity(updateRequest.getArea(), buildingEntity));
				buildingEntity.setAreaEnties(areaEntities);
			}
		} else {
			UsersBuildingEntity usersBuildingEntity = new UsersBuildingEntity();
			List<UsersBuildingEntity> usersBuildingEntities = new ArrayList<UsersBuildingEntity>();
			UsersEntity usersEntity = new UsersEntity();
			usersEntity.setId(SecurityUtils.getPrincipal().getId());
			usersBuildingEntity.setUsersEntity(usersEntity);
			usersBuildingEntity.setBuildingEntity(buildingEntity);
			usersBuildingEntities.add(usersBuildingEntity);
			buildingEntity.setUsersBuildingEntities(usersBuildingEntities);
			if (updateRequest.getArea() != null) {
				buildingEntity.setAreaEnties(convertAreaToAreaEntity(updateRequest.getArea(), buildingEntity));
			}
		}
		BuildingTypeEntity buildingTypeEntity = new BuildingTypeEntity();
		buildingTypeEntity.setId(updateRequest.getBuildingTypeId());
		buildingEntity.setBuildingTypeEntity(buildingTypeEntity);
		DistrictEntity districtEntity = new DistrictEntity();
		districtEntity.setId(updateRequest.getDistrictId());
		buildingEntity.setDistrictEntity(districtEntity);
		return buildingEntity;
	}

	public List<AreaEntity> convertAreaToAreaEntity(String area, BuildingEntity buildingEntity) {
		List<AreaEntity> areaEntities = new ArrayList<AreaEntity>();
		String[] result = area.split(";");
		for (int i = 0; i < result.length; i++) {
			String[] resultFinal = result[i].split("-");
			AreaEntity areaEntity = new AreaEntity();
			areaEntity.setFloor(Integer.parseInt(resultFinal[0]));
			areaEntity.setArea(resultFinal[1]);
			areaEntity.setPrice(Double.parseDouble(resultFinal[2]));
			areaEntity.setStatus(0);
			areaEntity.setBuildingEntity(buildingEntity);
			areaEntities.add(areaEntity);
		}
		return areaEntities;
	}

	public BuildingEntity convertUsersBuildingRequestToEntity(UsersBuildingRequest request) {
		BuildingEntity result = new BuildingEntity();
		Integer buildingId = request.getBuildingId();
		if (buildingId != null) {
			List<UsersBuildingEntity> usersBuildingEntities = new ArrayList<UsersBuildingEntity>();
			result = buildingRepository.findById(buildingId).get();
			List<Integer> idsNew = request.getIdsNew();
			for (Integer item : idsNew) {
				UsersBuildingEntity usersBuildingEntity = new UsersBuildingEntity();
				UsersEntity usersEntity = new UsersEntity();
				usersEntity.setId(item);
				usersBuildingEntity.setBuildingEntity(result);
				usersBuildingEntity.setUsersEntity(usersEntity);
				usersBuildingEntities.add(usersBuildingEntity);
			}
			result.getUsersBuildingEntities().clear();
			result.getUsersBuildingEntities().addAll(usersBuildingEntities);
		}
		return result;
	}
}
