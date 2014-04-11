package yifan.home.atmsi.web.controller;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import yifan.home.atmsi.persist.bo.PlannedJobService;

@Controller
@RequestMapping(value = {"/home","/"})
public class HomeController {

	@Autowired
	@Qualifier("webLogger")
	private Logger _logger;
	
	@Autowired
	private PlannedJobService _plannedJobService;

	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model) {
	
		_logger.debug(String.format("(%s)calling web home", _logger));
	
		model.addAttribute("who", _plannedJobService);
		
		return "home";
	}
}
