package com.jci.dao.impl_phase2;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.PcsoentryDao;
import com.jci.model.EntryofpcsoModel;
import com.jci.model.PcsoDateModel;

@Transactional
@Repository
public class PcsoentryDaoImpl implements PcsoentryDao{
	
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(EntryofpcsoModel entryofpcso) {
		// TODO Auto-generated method stub
		currentSession().save(entryofpcso);
	}

	@Override
	public List<EntryofpcsoModel> getAlldata() {
		// TODO Auto-generated method stub
		List<EntryofpcsoModel> ll = new ArrayList<>();
		List<Object[]> rows = new ArrayList<>();
		String querystr = "select child_id,client_unit_code,unit_name from jcimilldetailchild";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		rows = query.list();
		//System.out.println(rows);
		for(Object[] row: rows) {
			int childid= (int) row[0];
			String millcode= (String) row[1];
			String millname= (String) row[2];
			EntryofpcsoModel entryofpcsoModel = new EntryofpcsoModel();
			entryofpcsoModel.setPcsorefid(childid);
			entryofpcsoModel.setMill_code(millcode);
			entryofpcsoModel.setMill_name(millname);
			ll.add(entryofpcsoModel);
		}
		//System.out.println("=========== "+ll.toString());
		return ll;
	}

	@Override
	public List<Date> getAll() {
		List<Date> ll = new ArrayList<>();
		List<Date> rows = new ArrayList<>();
		String querystr = "  select  distinct(pcso_date) FROM jcientryofpcso";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		rows = query.list();
		//System.out.println("pcsolist-----------------        "+rows);
		for(Date row: rows) {
			
			
			ll.add((Date)row);
		}
		
		return ll;
	}

	@Override
	public List<PcsoDateModel> pcso_details(String pcso1) {
		List<PcsoDateModel> ll = new ArrayList<>();
		List<Object[]> rows = new ArrayList<>();
		 
		String querystr = "select  mill_name, mill_code,Sum(total_allocation) as total, allocation = cast(  STUFF((Select ',' + CONVERT(varchar(110),total_allocation,250) from [XMWJCI].[dbo].[jcientryofpcso] b where b.mill_code =  a.mill_code and b.pcso_date in ("+pcso1+") for XML PATH ('')),1,1,'' ) as varchar(110))  from  [XMWJCI].[dbo].[jcientryofpcso] a where a.pcso_date in("+pcso1+") group by a.mill_name, a.mill_code";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
	//	System.out.println("pcsolistsffggsss-----------------        "+querystr);
		rows = query.list();
	//	System.out.println("pcsolistssss-----------------        "+rows.size());
		for(Object[] row: rows) {
			 PcsoDateModel model = new PcsoDateModel();
			 model.setMill_code((String)row[1]);
			 //System.out.println(row.toString());
			 model.setName((String)row[0]);
			 model.setQty(((BigDecimal)row[2]).doubleValue());
			 model.setDate_wise((String)row[3]);
			ll.add(model);
		}
		return ll;
	}

}
