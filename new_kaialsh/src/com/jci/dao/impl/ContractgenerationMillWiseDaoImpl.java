package com.jci.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.ContractgenerationMillWiseDao;
import com.jci.model.ContractgenerationMillWise;


@Transactional
@Repository
public class ContractgenerationMillWiseDaoImpl implements ContractgenerationMillWiseDao{

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	
	@Override
	public void create(ContractgenerationMillWise contractgeneration) {
		// TODO Auto-generated method stub

		currentSession().save(contractgeneration);
	}

	@Override
	public void update(ContractgenerationMillWise contractgeneration) {
		// TODO Auto-generated method stub
		currentSession().update(contractgeneration);
	}

	@Override
	public ContractgenerationMillWise edit(int id) {
		// TODO Auto-generated method stub
		return find(id);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ContractgenerationMillWise find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContractgenerationMillWise> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<String> derivativePrice(String type, String contract_no) {
		String querystr="";
		String list = "";
		List<String> result = new ArrayList<>();
		if(type.equals("Mill Delivery")){
			querystr = "select top 1 grade1,grade2,grade3,grade4,grade5,grade6 FROM jcientry_derivative_price where state =2 order by creation_date desc";
		}
		else if( type.equals("Ex-Godown")) {
			querystr = "select top 1 grade1,grade2,grade3,grade4,grade5,grade6 FROM jcientry_derivative_price where state =2 order by creation_date desc";
		}
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();
		return result;
	}


	@Override
	public List<String> percentage(String contract_no) {
		String querystr="";
		String list = "";
		List<String> result = new ArrayList<>();		
		querystr = "  select grade1_TD1,grade3_TD3_W2_M1_B1,grade3_TD3_W2_M1_B1,grade4_TD4_W3_M2_B2,grade5_TD5_W4_M3_B3,grade6_TD6_W5_M4_B4,grade7_TD7_W6_M5_B5,grade8_TD8_W7_M6_B6,grade8_W8 from jcicontractgeneration where contactnumber = "+contract_no;		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();
		return result;
	}

}
