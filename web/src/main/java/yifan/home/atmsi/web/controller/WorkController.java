package yifan.home.atmsi.web.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yifan.home.atmsi.persist.domain.Place;
import yifan.home.atmsi.persist.domain.PlannedJob;
import yifan.home.atmsi.persist.domain.PlannedVisit;
import yifan.home.atmsi.web.service.PlaceService;
import yifan.home.atmsi.web.service.PlannedJobService;

@Controller
@RequestMapping(value = {"/work"})
public class WorkController extends AbstractController {

	@Autowired
	private PlannedJobService _plannedJobService;
	
	@Autowired
	private PlaceService _placeService;

	@RequestMapping(method=RequestMethod.GET, value={"", "/", "/index"})
	public String index(Model model) {
	
		_logger.debug("calling work index");
		
		model.addAttribute("jobs", _plannedJobService.getAll());
		this.addToModel(model, "title", "Jobs");
		
		return "work/index";
	}
	
 	@RequestMapping(value = "/edit/{jobId}", method = RequestMethod.GET)
	public String view(@PathVariable int jobId, Model model) {
 		
 		PlannedJob job = _plannedJobService.getById(jobId);
 		
 		if( job != null) {	
	
	 		model.addAttribute("title", String.format("Details of job: %s", job.getReference()));
	 		
	 		model.addAttribute("job", job);
 		}
 		
 		model.addAttribute("places", _placeService.getAll());
 		
		return "work/view";
	}
		
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String _new(Model model) {
		model.addAttribute("title", "Create a new job");
		model.addAttribute("job", new PlannedJob());
		model.addAttribute("places", _placeService.getAll());
		return "work/new";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute PlannedJob job, Model model) {
		_plannedJobService.save(job);
		return String.format("redirect:/work/edit/%s", job.getId());
	}
	
}
