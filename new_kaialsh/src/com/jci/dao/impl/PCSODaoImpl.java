package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.PCSODao;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.PCSOModel;

@Transactional
@Repository
public class PCSODaoImpl implements PCSODao {

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(PCSOModel pcso) {
		currentSession().save(pcso);
	}

	@Override
	public void update(PCSOModel pcso) {
		currentSession().update(pcso);
	}

	@Override
	public PCSOModel edit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		FarmerRegistrationModel farmerRegistrationModel = new FarmerRegistrationModel();
		String hql = "Delete from dbo.bna where id = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();

	}

	@Override
	public PCSOModel find(int id) {
		return (PCSOModel) currentSession().get(PCSOModel.class, id);
	}

	@Override
	public List<PCSOModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(PCSOModel.class);
		List<PCSOModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(PCSOModel pcso) {
		this.sessionFactory.getCurrentSession().save(pcso);
		return false;
	}

}
