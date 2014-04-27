package yifan.home.atmsi.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yifan.home.atmsi.persist.dao.PlaceDao;
import yifan.home.atmsi.persist.domain.Place;
import yifan.home.atmsi.web.service.PlaceService;

@Service("placeService")
public class PlaceServiceImpl extends AbstractService implements PlaceService {

	@Autowired
	private PlaceDao _placeDao;
	
	@Transactional
	public List<Place> getAll() {
		return _placeDao.getAll();
	}

}
