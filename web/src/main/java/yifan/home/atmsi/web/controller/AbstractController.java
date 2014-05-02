package yifan.home.atmsi.web.controller;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.google.gson.Gson;

public abstract class AbstractController {

	@Autowired
	@Qualifier("webLogger")
	protected Logger _logger;	
	
	@Autowired
	private Gson _gson;
	
	protected void addToModel(Model model, String name, Object entity) {
		model.addAttribute(name, _gson.toJson(entity));
	}
	
	protected void addToModel(Model model, String name, String value) {
		model.addAttribute(name, value);
	}
	
	@InitBinder
	public void binder(WebDataBinder binder) {
		final String datetimeFormat = "yyyy-MM-dd HH:mm:ss";
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
		    public void setAsText(String value) {
		        try {
		            setValue(new SimpleDateFormat(datetimeFormat).parse(value));
		        } catch(ParseException e) {
		            setValue(null);
		        }
		    }
	
		    public String getAsText() {
		    	Object value = getValue();
		        return value == null ? null : new SimpleDateFormat(datetimeFormat).format((Date) value);
		    };
		});
	}
}
