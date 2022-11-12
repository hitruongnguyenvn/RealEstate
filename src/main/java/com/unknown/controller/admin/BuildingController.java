package com.unknown.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.unknown.model.request.BuildingSearchRequest;
import com.unknown.service.BuildingService;
import com.unknown.service.BuildingTypeService;
import com.unknown.service.DistrictService;
import com.unknown.service.UsersService;

@Controller(value = "buildingAdmin")
public class BuildingController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private BuildingService buildingService;

	@Autowired
	private DistrictService districtService;

	@Autowired
	private BuildingTypeService buildingTypeService;

	@RequestMapping(value = { "/admin/building" }, method = RequestMethod.GET)
	public ModelAndView buildingSearchPage(
			@ModelAttribute("buildingSearch") BuildingSearchRequest buildingSearchRequest) {
		ModelAndView modelAndView = new ModelAndView("admin/building/search");
		modelAndView.addObject("buildingSearch", buildingSearchRequest);
		modelAndView.addObject("empoloyeeOfCharge", usersService.findAll());
		modelAndView.addObject("district", districtService.findAll());
		modelAndView.addObject("buildingType", buildingTypeService.findAll());
		modelAndView.addObject("buildingReponse", buildingService.findBuilding(buildingSearchRequest));
		return modelAndView;
	}

	@RequestMapping(value = { "/admin/building-create" }, method = RequestMethod.GET)
	public ModelAndView buildingCreatePage() {
		ModelAndView modelAndView = new ModelAndView("admin/building/create");
		modelAndView.addObject("district", districtService.findAll());
		modelAndView.addObject("buildingType", buildingTypeService.findAll());
		return modelAndView;
	}

	@RequestMapping(value = { "/admin/building-update/{buildingId}" }, method = RequestMethod.GET)
	public ModelAndView buildingUpdatePage(@PathVariable("buildingId") Integer id) {
		ModelAndView modelAndView = new ModelAndView("admin/building/update");
		modelAndView.addObject("district", districtService.findAll());
		modelAndView.addObject("area", buildingService.findAreaByBuildingId(id));
		modelAndView.addObject("building", buildingService.findById(id));
		modelAndView.addObject("users", usersService.findAll());
		modelAndView.addObject("buildingType", buildingTypeService.findAll());
		modelAndView.addObject("usersManagement", usersService.findByBuildingId(id));
		return modelAndView;
	}
}
