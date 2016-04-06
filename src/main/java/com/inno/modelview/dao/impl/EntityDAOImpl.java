package com.inno.modelview.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.inno.modelview.dao.EntityDAO;
import com.inno.modelview.model.MEntity;
import com.inno.modelview.viewmodel.EntityViewModel;

@Repository("entityDAO")
public class EntityDAOImpl implements EntityDAO {
	
	private SessionFactory sessionFactory;

	public MEntity findEntityByName(String name) {
        String hsql="from MEntity where name = " + name;
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);        
        return (MEntity) query.list();
	}

	public void saveEntity(MEntity entity) {
		// TODO Auto-generated method stub
		
	}

	public void updateEntity(MEntity entity) {
		// TODO Auto-generated method stub
		
	}

	public void deleteEntityByName(String name) {
		// TODO Auto-generated method stub
		
	}

	public List<EntityViewModel> findAllEntitiesViewModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
