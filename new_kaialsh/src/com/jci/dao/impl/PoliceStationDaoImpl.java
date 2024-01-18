package com.jci.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.PoliceStationDao;
import com.jci.model.PoliceStationModel;

@Transactional
@Repository

public class PoliceStationDaoImpl implements PoliceStationDao{

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}


	@Override
	public void create(PoliceStationModel PoliceStationlist) {
		currentSession().save(PoliceStationlist);

	}
	@Override
	public void update(PoliceStationModel PoliceStationlist) {
		currentSession().update(PoliceStationlist);

	}
	@Override
	public PoliceStationModel edit(int id) {
		return find(id);
	}
	@Override
	public PoliceStationModel find(int id) {
		return (PoliceStationModel) currentSession().get(PoliceStationModel.class, id);
	}
	@Override
	public List<PoliceStationModel> getAll() {
		//System.out.println("Hello From policeStationListModel");
		List<PoliceStationModel> ll;
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(PoliceStationModel.class);
		ll=c.list();
		return ll;
	}

	@Override
	public void delete(int id) {
		PoliceStationModel prod = new PoliceStationModel();
		String hql = "Delete from dbo.product where id = '"+id+"' " ;
		 this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
		//List<String> results = query.list();
	}

	@Override
	public boolean submitform(PoliceStationModel off) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(off);
		return false;
	}

	@Override
	public List<String> getAllFilledPoliceStation(String F_Block) {

		//System.out.println("block value from DaoImpl is "+PoliceStation);

		String hql = "select police_station from tbl_policeStation where district_id ='"+F_Block+"'";
		
		Query query = this.sessionFactory.getCurrentSession().createSQLQuery(hql);
		List<String> results = query.list();
		//String sql = "select max(position) from dbo.product where menu_name='Insurance'";
		//List<String> listsearch = jdbc.queryForList(sql, String.class);
		return results;
	}


}
