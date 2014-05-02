package yifan.home.atmsi.web.service;

import java.util.List;

import yifan.home.atmsi.persist.domain.PlannedJob;

public interface PlannedJobService {

	void save(PlannedJob job);
	
	List<PlannedJob> getAll();
	
	PlannedJob getById(int id);

}
