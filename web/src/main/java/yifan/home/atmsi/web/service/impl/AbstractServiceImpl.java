package yifan.home.atmsi.web.service.impl;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

abstract class AbstractService {

	@Autowired
	@Qualifier("webLogger")
	protected Logger _logger;
	
}
