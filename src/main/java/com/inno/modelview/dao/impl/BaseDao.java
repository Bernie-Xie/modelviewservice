package com.inno.modelview.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.inno.modelview.dao.Dao;

public class BaseDao<T> extends HibernateDaoSupport implements Dao<T> {

	public void save(T model) {
		this.getHibernateTemplate().save(model);
	}

	public void update(T model) {
		this.getHibernateTemplate().update(model);
		
	}

	public void delete(T model) {
		this.getHibernateTemplate().delete(model);
	}

	@Autowired
    public void setMySessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
		this.getHibernateTemplate().setCheckWriteOperations(false);
    }

}
