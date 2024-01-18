package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.UserActionDao;
import com.jci.model.UserActionModel;
import com.jci.model.UserRoleModel;
@Transactional
@Repository
public class UserActionDaoImpl implements UserActionDao {
	
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}


	@Override
	public void create(UserActionModel useraction) {
		currentSession().save(useraction);
		
	}


	@Override
	public List<UserActionModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(UserActionModel.class);
		List<UserActionModel> ll=c.list();
		return ll;
	}

}
