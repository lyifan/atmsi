package yifan.home.atmsi.web.controller;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import yifan.home.atmsi.web.service.PlannedJobService;
import yifan.home.atmsi.web.service.PlaceService;

@Controller
@RequestMapping(value = {"/home","/"})
public class HomeController {

	@Autowired
	@Qualifier("webLogger")
	private Logger _logger;
	
	@Autowired
	private PlannedJobService _plannedJobService;
	
	@Autowired
	private PlaceService _placeService;

	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model) {
	
		_logger.debug("calling web home");
		
		model.addAttribute("places", _placeService.getAll());
		model.addAttribute("title", "Home");
		
		return "home";
	}
}
