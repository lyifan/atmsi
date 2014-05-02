package yifan.home.atmsi.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yifan.home.atmsi.persist.dao.PlannedJobDao;
import yifan.home.atmsi.persist.domain.PlannedJob;
import yifan.home.atmsi.persist.domain.PlannedVisit;
import yifan.home.atmsi.web.service.PlannedJobService;

@Service("plannedJobService")
public class PlannedJobServiceImpl extends AbstractService implements PlannedJobService {

	@Autowired
	private PlannedJobDao _plannedJobDao;
	
	@Transactional
	public void save(PlannedJob job) {
		for(PlannedVisit pv : job.getVisits()) {
			pv.setPlannedJob(job);
		}
		_plannedJobDao.save(job);
	}
	
	@Transactional
	public List<PlannedJob> getAll() {
		return _plannedJobDao.getAll();
	}
	
	@Transactional
	public PlannedJob getById(int id) {
		PlannedJob job = _plannedJobDao.getById(id);
		
		// Load the lazy list
		List<PlannedVisit> visits = job.getVisits();
		
		visits.removeIf((v) -> v.getId() == -1);
				
		return job;
	}
}
