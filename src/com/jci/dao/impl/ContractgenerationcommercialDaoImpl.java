package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.ContractgenerationcommercialDao;
import com.jci.model.Contractgenerationcommercial;

@Transactional
@Repository
public class ContractgenerationcommercialDaoImpl implements ContractgenerationcommercialDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(Contractgenerationcommercial contractgenerationcommercial) {

		currentSession().saveOrUpdate(contractgenerationcommercial);

	}

	@Override
	public void update(Contractgenerationcommercial contractgenerationcommercial) {
		currentSession().saveOrUpdate(contractgenerationcommercial);

	}

	@Override
	public Contractgenerationcommercial edit(int cgc_id) {

		return find(cgc_id);
	}

	@Override
	public void delete(int cgc_id) {
		String hql = "Delete from dbo.jcicontractgenerationcommercial where cgc_id = '" + cgc_id + "' ";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();

	}

	@Override
	public Contractgenerationcommercial find(int cgc_id) {
		return (Contractgenerationcommercial) currentSession().get(Contractgenerationcommercial.class, cgc_id);
	}

	@Override
	public List<Contractgenerationcommercial> getAll() {
		List<Contractgenerationcommercial> ll;
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(Contractgenerationcommercial.class);
		ll = c.list();
		return ll;
	}

}
