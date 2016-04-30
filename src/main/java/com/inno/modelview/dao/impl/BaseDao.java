package com.inno.modelview.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.inno.modelview.dao.Dao;

public class BaseDao<T> extends HibernateDaoSupport implements Dao<T> {

	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
		this.getHibernateTemplate().setCheckWriteOperations(false);
	}

	public Session getSession() {
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	public Integer save(T model) {
		Object id = this.getHibernateTemplate().save(model);
		return (Integer)id;
	}

	public void saveOrUpdate(T model) {
		this.getHibernateTemplate().saveOrUpdate(model);
	}

	public void update(T model) {
		this.getHibernateTemplate().update(model);
		
	}

	public void delete(T model) {
		this.getHibernateTemplate().delete(model);
	}


}
