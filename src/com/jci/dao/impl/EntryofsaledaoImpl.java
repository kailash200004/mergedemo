package com.jci.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.Entryofsaledao;
import com.jci.model.EntryofSaleModel;

@Transactional
@Repository
public class EntryofsaledaoImpl implements Entryofsaledao {

	
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(EntryofSaleModel entryofsale) {
		// TODO Auto-generated method stub
		currentSession().save(entryofsale);
	}

}
