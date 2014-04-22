package yifan.home.atmsi.persist.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import yifan.home.atmsi.persist.domain.PlannedJob;
import yifan.home.atmsi.persist.dao.PlannedJobDao;

@Component("plannedJobDao")
public class PlannedJobDaoImpl 
		extends DaoImpl<PlannedJob> 
		implements PlannedJobDao  {	

	public PlannedJobDaoImpl() {
		super(PlannedJob.class);
	}
}
