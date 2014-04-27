package yifan.home.atmsi.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/home","/"})
public class HomeController extends AbstractController {

	@Autowired
	@Qualifier("webLogger")
	private Logger _logger;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model) {
	
		_logger.debug("calling web home");
		
		this.addToModel(model, "title", "Home");
		
		return "home";
	}
}
