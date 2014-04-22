package yifan.home.atmsi.persist.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import yifan.home.atmsi.persist.domain.PlannedVisit;
import yifan.home.atmsi.persist.dao.PlannedVisitDao;

@Component("plannedVisitDao")
public class PlannedVisitDaoImpl 
		extends DaoImpl<PlannedVisit> 
		implements PlannedVisitDao {	

	public PlannedVisitDaoImpl() {
		super(PlannedVisit.class);
	}
	
}
