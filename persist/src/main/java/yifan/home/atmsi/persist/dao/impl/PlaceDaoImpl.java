package yifan.home.atmsi.persist.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import yifan.home.atmsi.persist.domain.Place;
import yifan.home.atmsi.persist.dao.PlaceDao;

@Component("placeDao")
public class PlaceDaoImpl 
		extends DaoImpl<Place> 
		implements PlaceDao {

	public PlaceDaoImpl() {
		super(Place.class);
	}
	
}
