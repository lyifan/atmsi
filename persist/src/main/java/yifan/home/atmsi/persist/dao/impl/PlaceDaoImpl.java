package yifan.home.atmsi.persist.dao.impl;

import org.springframework.stereotype.Component;

import yifan.home.atmsi.persist.dao.PlaceDao;
import yifan.home.atmsi.persist.domain.Place;

@Component("placeDao")
public class PlaceDaoImpl 
		extends DaoImpl<Place> 
		implements PlaceDao {

	public PlaceDaoImpl() {
		super(Place.class);
	}
	
}
