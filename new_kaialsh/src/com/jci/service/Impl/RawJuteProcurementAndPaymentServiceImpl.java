package com.jci.service.Impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.RawJuteProcurementAndPaymentDao;
import com.jci.model.RawJuteProcurementAndPayment;
import com.jci.service.RawJuteProcurementAndPaymentService;

@Service
public class RawJuteProcurementAndPaymentServiceImpl implements RawJuteProcurementAndPaymentService{

	@Autowired
	RawJuteProcurementAndPaymentDao rawJuteProcurementAndPaymentDao;

	@Override
	public void create(RawJuteProcurementAndPayment rawJuteProcurementAndPayment) {
		rawJuteProcurementAndPaymentDao.create(rawJuteProcurementAndPayment);

	}

	@Override
	public void update(RawJuteProcurementAndPayment rawJuteProcurementAndPayment) {
		rawJuteProcurementAndPaymentDao.update(rawJuteProcurementAndPayment);

	}

	@Override
	public RawJuteProcurementAndPayment edit(int id) {
		return rawJuteProcurementAndPaymentDao.edit(id);
	}

	@Override
	public void delete(int id) {
		rawJuteProcurementAndPaymentDao.delete(id);
	}

	@Override
	public RawJuteProcurementAndPayment find(int id) {
		return rawJuteProcurementAndPaymentDao.find(id);
	}

	@Override
	public List<RawJuteProcurementAndPayment> getAll() {
		return rawJuteProcurementAndPaymentDao.getAll();
	}

	@Override
	public boolean submitform(RawJuteProcurementAndPayment rawJuteProcurementAndPayment) {
		return rawJuteProcurementAndPaymentDao.submitform(rawJuteProcurementAndPayment);
	}

	@Override
	public  List<String> farmerNoVarification(String farmerNo) {
		return  rawJuteProcurementAndPaymentDao.farmerNoVarification(farmerNo);

	}

	@Override
	public List<String> allDpcList() {
		return rawJuteProcurementAndPaymentDao.allDpcList();
	}


	@Override
	public List<String> findJuteOnBasis(int msp_no) {
		return  rawJuteProcurementAndPaymentDao.findJuteOnBasis(msp_no);
	}

	@Override
	public List<String> findGradeOnJuteVariety(String variety, int basis_no) {
		return  rawJuteProcurementAndPaymentDao.findGradeOnJuteVariety(variety, basis_no);
	}

	@Override
	public List<String> findGradePriceJuteVariety(String variety, int basis_no ,String cropyr, String dpcid) {
		return  rawJuteProcurementAndPaymentDao.findGradePriceJuteVariety(variety, basis_no, cropyr,dpcid);
	}

	@Override
	public List<String> getfarmerno(String dpc) {

		return rawJuteProcurementAndPaymentDao.getfarmerno(dpc);
	}

	@Override
	public List<RawJuteProcurementAndPayment> farmerDetailsList() {

		return rawJuteProcurementAndPaymentDao.farmerDetailsList();
	}

	@Override
	public boolean updateProcurement(String status, int verified, String tallyno) {
		// TODO Auto-generated method stub
		return rawJuteProcurementAndPaymentDao.updateProcurement(status, verified,tallyno);
	}

	@Override
	public RawJuteProcurementAndPayment findbyTally(String tallyno) {

		return rawJuteProcurementAndPaymentDao.findbyTally(tallyno);
	}

	@Override
	public boolean updateProcurementerror(String status, int verified, String tallyno, String error,String region) {

		return rawJuteProcurementAndPaymentDao.updateProcurementerror(status, verified,tallyno, error,region);
	}

	@Override
	public List<RawJuteProcurementAndPayment> jutelistbystatus(String status, String dpcid) {

		return rawJuteProcurementAndPaymentDao.jutelistbystatus(status, dpcid);
	}

	@Override
	public boolean validateTally(String tally, String ro) {
		
		return rawJuteProcurementAndPaymentDao.validateTally(tally, ro);
	}

	
	@Override
	public String getbinno(String binno) {
		return rawJuteProcurementAndPaymentDao.getbinno(binno);
		
	}





}
