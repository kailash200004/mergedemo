package com.jci.dao.impl_phase2;

import org.hibernate.SessionFactory;
import javax.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.mail.Session;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.FinancialConcurenceDao;
import com.jci.model.FinancialConcurenceDto;
import com.jci.model.FinancialConcurenceModel;
import com.jci.model.VerifyTallySlip;

@Repository
@Transactional
public class FinancialConcurenceDaoImpl implements FinancialConcurenceDao {
	@Autowired
	SessionFactory sessionFactory;
	
	protected org.hibernate.Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(FinancialConcurenceModel financialConcurenceModel) {
		
		currentSession().saveOrUpdate(financialConcurenceModel);
	}

	
	@Override
	    public List<FinancialConcurenceModel> getAllPaymentInstruments() {
	        Criteria criteria = currentSession().createCriteria(FinancialConcurenceModel.class);
	        return criteria.list();
	    }
		public FinancialConcurenceModel find(int id) {
		return (FinancialConcurenceModel) currentSession().get(FinancialConcurenceModel.class, id);
		}
		@Override
		public void remark(String remark ,String  con_No) {
			 String hql = "UPDATE  jcifinancial_concurrence set Remarks =  '" + remark + "'  where Contractno = '" + con_No + "' ";
		    this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
		}
		
		@Override
		public double calculateCharges(int id,String cont_no) {
			System.err.println(cont_no);
			 double charges =0.0;
			List<Object[]> result = new ArrayList<>();
			String sql = "select b.Created_date, c.QtyAllowed, d.Contract_date from jcipayment_arrangement\r\n"
					+ "		    	 b jcicontract d on d.Contract_no = b.Contract_No where b.Contract_No ='" + cont_no + "'";
		
			try {
				org.hibernate.classic.Session session = sessionFactory.getCurrentSession();
				SQLQuery query = session.createSQLQuery(sql);
				result = query.list();
//			    org.hibernate.classic.Session session = sessionFactory.getCurrentSession();
//		    	Transaction tx = session.beginTransaction();
//		    	SQLQuery query = session.createSQLQuery(sql);
//		    	result = query.list();
			    
			   if (result.size() >= 1) {
				for (Object[] row : result) {
					
//		            Date condate = (Date) row[0];
//		            Object qtyAllowedObj = row[1];
//		            Date createddate = (Date) row[2];
		            
		            Timestamp contdateTimestamp = (Timestamp) row[0];
		            //Object qtyAllowedObj = row[1];
		            String createddateString = row[1].toString(); 
                    Date condate = new Date(contdateTimestamp.getTime());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		            Date createddate = dateFormat.parse(createddateString);
		           
//		            float qtyAllowed = 0.0f; // Default value for null
//		            if (qtyAllowedObj != null) 
//		            {
//		            	qtyAllowed = Float.parseFloat(qtyAllowedObj.toString());
//		            }
		         
		            System.out.println("createddate: " + createddate);
		            System.out.println("condate: " + condate);
		            //System.out.println("qtyAllowed: " + qtyAllowed);

		            long diffInMilliseconds = Math.abs(condate.getTime() - createddate.getTime());
		            long daysBetween = TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS);
		           // charges = qtyAllowed * daysBetween * 70;
		            System.out.println("daysBetween" + daysBetween);
		            System.out.println("charges: " + charges);
		           
				}
				return charges;
			  }
		    


			} catch (Exception e) {
			    e.printStackTrace();// Handle exceptions

			}
			return charges;
			 

			
		}
		
		@Override
		public String ContractedQty(String cont_no) {
          String hql1 = " Select Contract_qty from jcicontract where Contract_no ='" + cont_no + "' ";
         return  (String) this.sessionFactory.getCurrentSession().createSQLQuery(hql1).uniqueResult();

		}
		@Override
		public int paymentid(String cont_no) {
			String  hql1 = " Select Payment_id from jcipayment_arrangement  where Contract_No = '" + cont_no + "' ";
		    this.sessionFactory.getCurrentSession().createSQLQuery(hql1).executeUpdate();
		
		    int payid=Integer.parseInt("hql1");  
			return payid;
	       
		}

}

