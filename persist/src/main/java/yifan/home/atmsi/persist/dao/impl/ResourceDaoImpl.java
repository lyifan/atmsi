package yifan.home.atmsi.persist.dao.impl;

import org.springframework.stereotype.Component;

import yifan.home.atmsi.persist.dao.ResourceDao;
import yifan.home.atmsi.persist.domain.Resource;

@Component("resourceDao")
public class ResourceDaoImpl 
		extends DaoImpl<Resource>  
		implements ResourceDao {	

	public ResourceDaoImpl() {
		super(Resource.class);
	}
	
}
