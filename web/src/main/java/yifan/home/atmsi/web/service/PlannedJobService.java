package yifan.home.atmsi.web.service;

import java.util.List;

import yifan.home.atmsi.persist.domain.PlannedJob;

public interface PlannedJobService {

	void save(String jobRef);
	
	List<PlannedJob> getAll();
	
	PlannedJob getById(int id);

}
