package yifan.home.atmsi.persist.dao.impl;

import org.springframework.stereotype.Component;

import yifan.home.atmsi.persist.dao.PlannedJobDao;
import yifan.home.atmsi.persist.domain.PlannedJob;

@Component("plannedJobDao")
public class PlannedJobDaoImpl 
		extends DaoImpl<PlannedJob> 
		implements PlannedJobDao  {	

	public PlannedJobDaoImpl() {
		super(PlannedJob.class);
	}
}
