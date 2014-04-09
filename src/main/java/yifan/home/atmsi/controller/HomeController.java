package yifan.home.atmsi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value = {"/home","/"})
public class HomeController {

	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("who", "yifan");
		return "home";
	}
}
