package yifan.home.atmsi.persist.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import yifan.home.atmsi.persist.dao.Dao;
import yifan.home.atmsi.persist.domain.AtmsiEntity;

public abstract class DaoImpl<T extends AtmsiEntity> implements Dao<T> {

	@Autowired
	@Qualifier("hibernateSessionFactory")
	private SessionFactory _hibernateSessionFactory;

	private final String _tableName;

	public DaoImpl(Class<T> domainClass) {
		_tableName = domainClass.getName();
	}

	public T getById(int pkId) {
		return null;
	}
		
	public void save(T entity) {
		this.getHibernateSessionFactory().save(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return (List<T>)this.getHibernateSessionFactory().createQuery("from " + _tableName).setCacheable(true).list();
	}
	
	protected Session getHibernateSessionFactory() {
		return _hibernateSessionFactory.getCurrentSession();
	}
}
