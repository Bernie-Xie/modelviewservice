package com.inno.modelview.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.inno.modelview.dao.Dao;

public class BaseDao<T> extends HibernateDaoSupport implements Dao<T> {

	@Override
	public void save(T model) {
		this.getHibernateTemplate().save(model);
	}

	@Override
	public void update(T model) {
		this.getHibernateTemplate().update(model);
		
	}

	@Override
	public void delete(T model) {
		this.getHibernateTemplate().delete(model);
	}

	

}
