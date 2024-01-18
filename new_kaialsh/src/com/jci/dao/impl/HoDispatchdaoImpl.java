package com.jci.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.HoDispatchdao;
import com.jci.model.HODispatchInstructionModel;

@Transactional
@Repository
public class HoDispatchdaoImpl implements HoDispatchdao{
	
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(HODispatchInstructionModel hodispatch) {
		// TODO Auto-generated method stub
		currentSession().save(hodispatch);
	}

}
