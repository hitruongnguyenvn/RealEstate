package com.unknown.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unknown.constant.RoleConstant;
import com.unknown.model.request.BuildingSearchRequest;
import com.unknown.model.request.CustomerRequest;
import com.unknown.model.response.UsersResponse;
import com.unknown.service.BuildingService;
import com.unknown.service.TransactionsService;
import com.unknown.service.TransactionsTypeService;
import com.unknown.service.UsersService;
import com.unknown.utils.SecurityUtils;

@Controller(value = "customerAdmin")
public class CustomerController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private BuildingService buildingService;

	@Autowired
	private TransactionsTypeService transactionsTypeService;

	@Autowired
	private TransactionsService transactionsService;

	@RequestMapping(value = { "/admin/customer" }, method = RequestMethod.GET)
	public ModelAndView customerSearchPage(@ModelAttribute("customerSearch") CustomerRequest customerRequest) {
		ModelAndView modelAndView = new ModelAndView("admin/customer/search");
		modelAndView.addObject("customerSearch", customerRequest);
		modelAndView.addObject("empoloyeeOfCharge",
				usersService.findByTwoRole(RoleConstant.MANAGE, RoleConstant.ADMIN));
		modelAndView.addObject("gender", usersService.getGender());
		List<UsersResponse> responses = usersService.findCustomer(customerRequest);
		modelAndView.addObject("customerResponse", responses);
		return modelAndView;
	}

	@RequestMapping(value = { "/admin/users-create" }, method = RequestMethod.GET)
	public ModelAndView customerCreatePage() {
		ModelAndView modelAndView = new ModelAndView("admin/customer/create");
		modelAndView.addObject("gender", usersService.getGender());
		return modelAndView;
	}

	@RequestMapping(value = { "/admin/users-update" }, method = RequestMethod.GET)
	public ModelAndView customerUpdatePage(@RequestParam(value = "id", required = false) Integer customerId) {
		ModelAndView modelAndView = new ModelAndView("admin/customer/update");
		modelAndView.addObject("gender", usersService.getGender());
		modelAndView.addObject("usersReponse", usersService.findById(customerId));
		BuildingSearchRequest buildingSearchRequest = new BuildingSearchRequest();
		buildingSearchRequest.setUsersId(SecurityUtils.getPrincipal().getId());
		modelAndView.addObject("buildingReponse", buildingService.findBuilding(buildingSearchRequest));
		modelAndView.addObject("transactionsType", transactionsTypeService.findAll());
		modelAndView.addObject("transactions", transactionsService.findByCustomerId(customerId));
		modelAndView.addObject("empoloyeeOfCharge",
				usersService.findByTwoRole(RoleConstant.MANAGE, RoleConstant.ADMIN));
		return modelAndView;
	}

}
