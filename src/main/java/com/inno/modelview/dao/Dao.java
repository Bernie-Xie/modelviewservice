package com.inno.modelview.dao;

public interface Dao<T> {

	Integer save(T model);
	void update(T model);
	void delete(T model);
}
