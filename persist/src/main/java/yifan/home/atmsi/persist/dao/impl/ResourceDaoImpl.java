package yifan.home.atmsi.persist.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import yifan.home.atmsi.persist.domain.Resource;
import yifan.home.atmsi.persist.dao.ResourceDao;

@Component("resourceDao")
public class ResourceDaoImpl 
		extends DaoImpl<Resource>  
		implements ResourceDao {	

	public ResourceDaoImpl() {
		super(Resource.class);
	}
	
}
