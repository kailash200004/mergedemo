package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.impl_phase2.ConfirmationClaimSettlementDaoImpl;
import com.jci.dao_phase2.ConfirmationClaimSettlementDao;
import com.jci.dao_phase2.GenrationCashDocumentDao;
import com.jci.model.CashDocumentModel;
import com.jci.model.ConfirmationClaimSettlementModel;
import com.jci.service_phase2.ConfirmationofClaimSettlementService;


@Service
public class ConfirmationClaimSettlementServiceImpl implements ConfirmationofClaimSettlementService {
	
	@Autowired
	ConfirmationClaimSettlementDao confirmationClaimSettlementDao;


	@Override
	public void create(ConfirmationClaimSettlementModel confirmationClaimSettlementModel) {
		System.out.println(confirmationClaimSettlementModel);
		confirmationClaimSettlementDao.create(confirmationClaimSettlementModel);
		
	}

	@Override
	public List<ConfirmationClaimSettlementModel> getAll() {
		
		 return confirmationClaimSettlementDao.getAll();
	}

	@Override
	public  List<Object> SettlementId() {
		return confirmationClaimSettlementDao.SettlementId();
	}
	
	@Override
	public  List<Object> gradecomposition( String st) {
		return confirmationClaimSettlementDao.gradecomposition(st);
	}
	

	@Override
	public  List<Object[]> fetchdataofclaim( String st) {
		return confirmationClaimSettlementDao.fetchdataofclaim(st);
	}
	@Override
	public  List<Object[]> fetchdatasttlement( int st) {
		return confirmationClaimSettlementDao.fetchdatasttlement(st);
	}
	

}
