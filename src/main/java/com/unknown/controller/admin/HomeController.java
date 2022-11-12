package com.unknown.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeAdmin")
public class HomeController {

	@RequestMapping(value = { "/admin/home" }, method = RequestMethod.GET)
	public ModelAndView buildingSearchPage() {
		ModelAndView modelAndView = new ModelAndView("admin/home");
		return modelAndView;
	}
}
