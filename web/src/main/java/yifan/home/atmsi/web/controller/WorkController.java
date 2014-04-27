package yifan.home.atmsi.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yifan.home.atmsi.persist.domain.PlannedJob;
import yifan.home.atmsi.web.service.PlaceService;
import yifan.home.atmsi.web.service.PlannedJobService;

@Controller
@RequestMapping(value = {"/work"})
public class WorkController extends AbstractController {

	@Autowired
	@Qualifier("webLogger")
	private Logger _logger;
	
	@Autowired
	private PlannedJobService _plannedJobService;
	
	@Autowired
	private PlaceService _placeService;

	@RequestMapping(method=RequestMethod.GET, value={"", "/", "/index"})
	public String index(Model model) {
	
		_logger.debug("calling work index");
		
		this.addToModel(model, "jobs", _plannedJobService.getAll());
		this.addToModel(model, "title", "Jobs");
		
		return "work/index";
	}
	
 	@RequestMapping(value = "/edit/{jobId}", method = RequestMethod.GET)
	public String view(@PathVariable int jobId, Model model) {
		return "work/view";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String _new(Model model) {
		model.addAttribute("job", new PlannedJob());
		return "work/view";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute PlannedJob job, Model model) {
		return "work/index";
	}
}
