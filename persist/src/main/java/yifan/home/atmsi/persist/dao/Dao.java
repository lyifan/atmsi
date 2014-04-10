package yifan.home.atmsi.persist.dao;

interface Dao<T> {
	T		getById(int id);
	void	save(T t);
}


