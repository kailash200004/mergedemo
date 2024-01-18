package com.jci.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.jci.dao.ContractgenerationDao;
import com.jci.model.Contractgeneration;
import com.jci.model.UpdatedContractQtyDTO;


@Transactional
@Repository
public class ContractgenerationDaoImpl implements ContractgenerationDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(Contractgeneration contractgeneration) {

		currentSession().save(contractgeneration);
	}

	@Override
	public void update(Contractgeneration contractgeneration) {

		currentSession().update(contractgeneration);
	}

	@Override
	public Contractgeneration edit(int id) {
		return find(id);
	}

	@Override
	public void delete(int id) {

		String hql = "Delete from dbo.jcicontractgeneration where contract_id = '" + id + "' ";
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	@Override
	public Contractgeneration find(int id) {

		return (Contractgeneration) currentSession().get(Contractgeneration.class, id);
	}

	@Override
	public UpdatedContractQtyDTO getAll(int id) {
		UpdatedContractQtyDTO updatedContractQtyDTO = new UpdatedContractQtyDTO();
		String querystr =   "select * FROM updated_contract_qty where id="+id;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> data = query.list();
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH);
		int year;
		if(month >= Calendar.APRIL) {
			year=cal.get(Calendar.YEAR);
		}
		else {
			year=cal.get(Calendar.YEAR)-1;
		}
		String finYr= year+"-"+(year+1);
		for(Object[] cart : data) {
			updatedContractQtyDTO.setFin_yr(finYr);
			updatedContractQtyDTO.setId((int)cart[0]);
			updatedContractQtyDTO.setContract_date((String)cart[1]);
			updatedContractQtyDTO.setContract_no((String)cart[2]);
			updatedContractQtyDTO.setMill_code((String)cart[3]);
			if(!((cart[4])==null)) {
			updatedContractQtyDTO.setUpdated_qty(((BigDecimal)cart[4]).doubleValue());
			}
		}
		return updatedContractQtyDTO;
	
	}

	@Override
	public List<UpdatedContractQtyDTO> getAllMills() {

		List<UpdatedContractQtyDTO> result = new ArrayList<>();
		String querystr =   "select * FROM updated_contract_qty";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<Object[]> data = query.list();
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH);
		int year;
		if(month >= Calendar.APRIL) {
			year=cal.get(Calendar.YEAR);
		}
		else {
			year=cal.get(Calendar.YEAR)-1;
		}
		String finYr= year+"-"+(year+1);
		for(Object[] cart : data) {
			UpdatedContractQtyDTO updatedContractQtyDTO = new UpdatedContractQtyDTO();
			updatedContractQtyDTO.setId((int)cart[0]);
			updatedContractQtyDTO.setContract_date((String)cart[1]);
			updatedContractQtyDTO.setContract_no((String)cart[2]);
			updatedContractQtyDTO.setMill_code((String)cart[3]);
			if(!((cart[4])==null)) {
			updatedContractQtyDTO.setUpdated_qty(((BigDecimal)cart[4]).doubleValue());
			}
			updatedContractQtyDTO.setFin_yr(finYr);
			result.add(updatedContractQtyDTO);
		}
		return result;
	
	}

	@Override
	public void create(UpdatedContractQtyDTO updatedcontractqtyDTO) {
		currentSession().save(updatedcontractqtyDTO);
		
	}

}
