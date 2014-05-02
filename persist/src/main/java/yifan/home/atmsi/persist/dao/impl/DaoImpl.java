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

	private final Class<T> _domainClass;

	public DaoImpl(Class<T> domainClass) {
		_domainClass = domainClass;
	}

	@SuppressWarnings("unchecked")
	public T getById(int pkId) {
		return (T) this.getHibernateSessionFactory().get(_domainClass, pkId);
	}
		
	public void save(T entity) {
		this.getHibernateSessionFactory().saveOrUpdate(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return (List<T>)this.getHibernateSessionFactory().createQuery("from " + _domainClass.getName()).setCacheable(true).list();
	}
	
	protected Session getHibernateSessionFactory() {
		return _hibernateSessionFactory.getCurrentSession();
	}
}
