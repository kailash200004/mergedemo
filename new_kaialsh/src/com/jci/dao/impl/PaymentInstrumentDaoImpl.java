package com.jci.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.PaymentInstrumentdao;
import com.jci.model.PaymentInstrumentModel;

@Transactional
@Repository
public class PaymentInstrumentDaoImpl implements PaymentInstrumentdao{

	
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(PaymentInstrumentModel paymentinstrument) {
		
		currentSession().save(paymentinstrument);
	}

}
