package com.inno.modelview.dao;

public interface Dao<T> {

	public void save(T model);
	public void update(T model);
	public void delete(T model);
}
