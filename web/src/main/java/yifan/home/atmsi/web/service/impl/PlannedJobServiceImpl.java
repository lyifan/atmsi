package yifan.home.atmsi.web.service.impl;

import java.util.Set;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import yifan.home.atmsi.persist.dao.PlannedJobDao;
import yifan.home.atmsi.persist.domain.*;

import yifan.home.atmsi.web.service.PlannedJobService;

@Service("plannedJobService")
public class PlannedJobServiceImpl extends AbstractService implements PlannedJobService {

	@Autowired
	private PlannedJobDao _plannedJobDao;
	
	@Transactional
	public void save(String jobRef) {

		// need a PlannedJobBuilder to build a job
		PlannedJob job = new PlannedJob();
		
		job.setReference(jobRef);
		Set<PlannedVisit> visits = job.getVisits();
		
		Calendar c = Calendar.getInstance();	
		job.setStart(c.getTime());
		
		for(int i = 0; i < 3; ++i) {
			
			PlannedVisit visit = new PlannedVisit();
			visit.setPlannedJob(job);
			
			visit.setStart(c.getTime());
			c.add(Calendar.MINUTE, 5); // stay 5 min
			visit.setEnd(c.getTime());
			c.add(Calendar.MINUTE, 30); // 30 min on the road
			
			visits.add(visit);
		}
		
		_logger.debug(String.format("Got %d visits.", visits.size()));
		
		job.setEnd(c.getTime());
		
		_plannedJobDao.save(job);

	}

}
