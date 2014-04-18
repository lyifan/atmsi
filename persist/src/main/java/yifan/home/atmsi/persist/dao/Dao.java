package yifan.home.atmsi.persist.dao;

import java.util.List;

import yifan.home.atmsi.persist.domain.AtmsiEntity;

public interface Dao<T extends AtmsiEntity> {
	T		getById(int id);
	void	save(T t);
	List<T> getAll();
}


