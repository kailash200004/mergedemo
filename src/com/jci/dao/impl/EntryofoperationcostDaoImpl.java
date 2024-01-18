package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.model.Entryofoperationcost;

@Transactional
@Repository
public class EntryofoperationcostDaoImpl implements com.jci.dao.EntryofoperationcostDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(Entryofoperationcost eooc) {
		currentSession().save(eooc);
	}

	@Override
	public void update(Entryofoperationcost eooc) {
		currentSession().saveOrUpdate(eooc);
	}

	@Override
	public Entryofoperationcost edit(int eooc_id) {

		return (Entryofoperationcost) currentSession().get(Entryofoperationcost.class, eooc_id);
	}

	@Override
	public void delete(int eooc_id) {
		String hql = "Delete from dbo.jcientryofoperationcost where eooc_id= '" + eooc_id + "' ";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public Entryofoperationcost findById(int eooc_id) {

		return (Entryofoperationcost) currentSession().get(Entryofoperationcost.class, eooc_id);
	}

	@Override
	public List<Entryofoperationcost> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(Entryofoperationcost.class);
		List<Entryofoperationcost> ll = c.list();
		return ll;
	}

}
