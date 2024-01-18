package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.RulingMarketDao;
import com.jci.model.RulingMarket;

@Transactional
@Repository
public class RulingMarketDaoImpl implements RulingMarketDao {

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(RulingMarket rulingMarket) {
		currentSession().save(rulingMarket);
	}

	@Override
	public void update(RulingMarket rulingMarket) {
		currentSession().update(rulingMarket);
	}

	@Override
	public RulingMarket edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		RulingMarket rulingMarket = new RulingMarket();
		String hql = "Delete from dbo.jcirulingmarket where jcirulingmarketid = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public RulingMarket find(int id) {
		return (RulingMarket) currentSession().get(RulingMarket.class, id);
	}

	@Override
	public List<RulingMarket> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(RulingMarket.class);
		List<RulingMarket> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(RulingMarket rulingMarket) {
		this.sessionFactory.getCurrentSession().save(rulingMarket);
		return false;
	}
}
