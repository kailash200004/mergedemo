package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.SalepricecalculationDao;
import com.jci.model.Salepricecalculation;

@Transactional
@Repository
public class SalepricecalculationDaoImp implements SalepricecalculationDao {

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(Salepricecalculation spc) {
	
		currentSession().saveOrUpdate(spc);
	}

	@Override
	public void update(Salepricecalculation spc) {
		currentSession().saveOrUpdate(spc);

	}

	@Override
	public Salepricecalculation edit(int spc_id) {
		
		return findById(spc_id);
	}

	@Override
	public void delete(int spc_id) {
		String hql = "Delete from dbo.jcisalepricecalculation where spc_id = '"+spc_id+"'";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();

	}

	@Override
	public Salepricecalculation findById(int spc_id) {
		
		return (Salepricecalculation) currentSession().get(Salepricecalculation.class, spc_id);
	}

	@Override
	public List<Salepricecalculation> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(Salepricecalculation.class);
		List<Salepricecalculation> ll=c.list();
		return ll;
	}

}
