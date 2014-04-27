package yifan.home.atmsi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.google.gson.Gson;

public abstract class AbstractController {

	@Autowired
	private Gson _gson;
	
	protected void addToModel(Model model, String name, Object entity) {
		model.addAttribute(name, _gson.toJson(entity));
	}
	
	protected void addToModel(Model model, String name, String value) {
		model.addAttribute(name, value);
	}
}
