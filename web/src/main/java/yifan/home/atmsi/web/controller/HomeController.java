package yifan.home.atmsi.web.controller;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value = {"/home","/"})
public class HomeController {

	@Autowired
	private Logger _logger;

	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model) {
	
		model.addAttribute("who", _logger);
		
		return "home";
	}
}
