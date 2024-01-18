package com.jci.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.UploadRecieptDao;
import com.jci.model.UploadingReceiptModel;
@Transactional
@Repository
public class UploadRecieptDaoImpl implements UploadRecieptDao {

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(UploadingReceiptModel uploadrecipt) {
		currentSession().save(uploadrecipt);
		
	}


	}


