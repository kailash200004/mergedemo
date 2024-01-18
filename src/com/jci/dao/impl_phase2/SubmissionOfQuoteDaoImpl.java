package com.jci.dao.impl_phase2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.SubmissionOfQuoteDao;

import com.jci.model.SubmissionOfQuoteModel;
@Repository
@Transactional
public class SubmissionOfQuoteDaoImpl  implements SubmissionOfQuoteDao{
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(SubmissionOfQuoteModel submissionOfQuoteModel) {
		currentSession().saveOrUpdate(submissionOfQuoteModel);
		
	}

	@Override
	public List<SubmissionOfQuoteModel> getAll() {
		 Criteria criteria = currentSession().createCriteria(SubmissionOfQuoteModel.class);
	        return criteria.list();
	}
	

	@Override
	 public int  bidrollout_No() {
	 
		    String hql = "Select bid_roll_out from  jcibid_creation ";
		    
		   return this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	       
		}
	
	

}
