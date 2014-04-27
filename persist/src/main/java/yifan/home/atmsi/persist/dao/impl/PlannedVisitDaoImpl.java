package yifan.home.atmsi.persist.dao.impl;

import org.springframework.stereotype.Component;

import yifan.home.atmsi.persist.dao.PlannedVisitDao;
import yifan.home.atmsi.persist.domain.PlannedVisit;

@Component("plannedVisitDao")
public class PlannedVisitDaoImpl 
		extends DaoImpl<PlannedVisit> 
		implements PlannedVisitDao {	

	public PlannedVisitDaoImpl() {
		super(PlannedVisit.class);
	}
	
}
