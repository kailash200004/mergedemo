package com.jci.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.BalePrepareDao;
import com.jci.model.BalePreparation;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.RopeMakingModel;

@Transactional
@Repository
public class BalePrepareDaoImpl implements  BalePrepareDao {

	@Autowired
	private HttpServletRequest request;
	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(BalePreparation BalePreparation) {
		currentSession().save(BalePreparation);
	}

	@Override
	public void update(BalePreparation BalePreparation) {
		currentSession().update(BalePreparation);
	}

	@Override
	public BalePreparation edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {
		FarmerRegistrationModel farmerRegistrationModel = new FarmerRegistrationModel();
		String hql = "Delete from dbo.bna where id = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public BalePreparation find(int id) {
		return (BalePreparation) currentSession().get(BalePreparation.class, id);
	}

	/*
	 * @Override public List<BalePreparation> getAll(String place_of_packing) {
	 * Criteria c =
	 * this.sessionFactory.getCurrentSession().createCriteria(BalePreparation.class)
	 * ;
	 * 
	 * List<Integer> result = new ArrayList<>(); HttpSession
	 * session1=request.getSession(false); String querystr = ""; int is_ho =
	 * (int)session1.getAttribute("is_ho"); System.out.println("is_hois_ho"+is_ho);
	 * if(is_ho == 1) { querystr =
	 * "SELECT pur.centername,bale.* FROM jcibalepreparation bale left join jcipurchasecenter pur on bale.place_of_packing = pur.CENTER_CODE"
	 * ; }else { querystr =
	 * "SELECT pur.centername,bale.* FROM jcibalepreparation bale left join jcipurchasecenter pur on bale.place_of_packing = pur.CENTER_CODE where bale.place_of_packing = '"
	 * +place_of_packing+"'"; } Session session =
	 * sessionFactory.getCurrentSession(); Transaction tx =
	 * session.beginTransaction(); SQLQuery query =
	 * session.createSQLQuery(querystr); List<Object[]> rows = query.list();
	 * List<BalePreparation> ll = new ArrayList<>(); for(Object[] row: rows) {
	 * 
	 * String dpcName = (String)row[0]; int baleid = (int)row[1]; Date packddate =
	 * (Date)row[2]; String cropyr = (String)row[3]; String binNo = (String)row[4];
	 * String basis = (String)row[5]; String juteVariety = (String)row[6]; String
	 * slipfrom = (String)row[7]; String slipto = (String)row[8]; int baleno =
	 * (int)row[9]; int crtdby = (int)row[10]; String creation = (String)row[12];
	 * String dpccode = (String)row[13]; String jutegrade = (String)row[14];
	 * BalePreparation bale = new BalePreparation(); bale.setBale_no(baleno);
	 * bale.setBaleId(baleid); bale.setBasis(basis); bale.setBin_no(binNo);
	 * bale.setCreated_by(crtdby); bale.setCreation_date(creation);
	 * bale.setCrop_year(cropyr); bale.setJute_grade(jutegrade);
	 * bale.setJute_variety(juteVariety); bale.setPacking_date(packddate);
	 * bale.setPlace_of_packing(dpcName); bale.setSlip_no_from(slipfrom);
	 * bale.setSlip_no_to(slipto);
	 * 
	 * ll.add(bale); } return ll; }
	 */

	@Override
	public List<BalePreparation> getAll(String place_of_packing) {
		String querystr = "";
		querystr =  "SELECT bale.packing_date,bale.jute_grade,SUM(bale.bale_no)as bales, bale.crop_year FROM jcibalepreparation bale where bale.place_of_packing='"+place_of_packing+"' group by packing_date,jute_grade, bale.crop_year";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		List<BalePreparation> ll = new ArrayList<>();
		for(Object[] row: rows) {
			 Date packing_date = (Date)row[0];
			String jute_grade = (String)row[1];
			int bales = (int)row[2];
			String cropyr = (String)row[3];
			BalePreparation bale = new BalePreparation();
			bale.setPacking_date(packing_date);
	        bale.setJute_grade(jute_grade);
	        bale.setBale_no(bales);
	        bale.setCrop_year(cropyr);
			ll.add(bale);
		
		}
		return ll;
	}
	@Override
	public List<BalePreparation> getAlldata() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(BalePreparation.class);
		
		List<Integer> result = new ArrayList<>();
		HttpSession session1=request.getSession(false); 
		String querystr = "";
		int is_ho = (int)session1.getAttribute("is_ho");
	
	    querystr = "SELECT ro.roname,pur.centername,bale.packing_date,bale.jute_grade,SUM(bale.bale_no)as bales, bale.crop_year FROM jcibalepreparation bale left join jcipurchasecenter pur on bale.place_of_packing = pur.CENTER_CODE left join jcirodetails ro on ro.rocode = bale.region  group by packing_date,jute_grade, pur.centername,ro.roname, bale.crop_year\r\n";
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> rows = query.list();
		List<BalePreparation> ll = new ArrayList<>();
		
			for(Object[] row: rows) {
				String region = (String)row[0];
				String place_packing = (String)row[1];
				Date packing_date = (Date)row[2];
				String jute_grade = (String)row[3];
				int bales = (int)row[4];
				String cropyr = (String)row[5];
				BalePreparation bale = new BalePreparation();
				bale.setRegion(region);
				bale.setPlace_of_packing(place_packing);
				bale.setPacking_date(packing_date);
		        bale.setJute_grade(jute_grade);
		        bale.setBale_no(bales);
		        bale.setCrop_year(cropyr);
				ll.add(bale);
			ll.add(bale);
		}
	
		return ll;
	}

	
	@Override
	public boolean submitform(BalePreparation BalePreparation) {
		this.sessionFactory.getCurrentSession().save(BalePreparation);
		return false;
	}

}
