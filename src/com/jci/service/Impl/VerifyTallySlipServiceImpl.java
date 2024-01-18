package com.jci.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.VerificationTallySlipDao;
import com.jci.model.ImageVerificationModel;
import com.jci.model.PaymentprocesstellyslipModel;
import com.jci.model.VerifyTallySlip;
import com.jci.service.VerifyTallySlipService;

@Service
public class VerifyTallySlipServiceImpl implements VerifyTallySlipService {

	@Autowired
	VerificationTallySlipDao VerificationTallySlipDao;

	@Override
	public void create(VerifyTallySlip VerifyTallySlip) {
		VerificationTallySlipDao.create(VerifyTallySlip);
	}

	@Override
	public void update(VerifyTallySlip VerifyTallySlip) {
		VerificationTallySlipDao.update(VerifyTallySlip);
	}

	@Override
	public VerifyTallySlip edit(int id) {
		return VerificationTallySlipDao.edit(id);
	}

	@Override
	public void delete(int id) {
		VerificationTallySlipDao.delete(id);
	}

	@Override
	public VerifyTallySlip find(int id) {
		return VerificationTallySlipDao.find(id);
	}

	@Override
	public List<VerifyTallySlip> getAll(String status, String region,String role_type) {
		return VerificationTallySlipDao.getAll(status, region, role_type);
	}

	@Override
	public boolean submitform(VerifyTallySlip VerifyTallySlip) {
		return VerificationTallySlipDao.submitform(VerifyTallySlip);
	}


	/*
	 * @Override public VerifyTallySlip findByTally(String tallyslipno) { return
	 * VerificationTallySlipDao.findByTally(tallyslipno); }
	 */

	@Override
	public String GettransectionDetails(String tallyNo,String region) {

		return VerificationTallySlipDao.GettransectionDetails(tallyNo,region);
	}

	@Override
	public boolean updatebyTally(String status, int verified, String tallyno) {

		return VerificationTallySlipDao.updatebyTally(status, verified, tallyno);
	}

	@Override
	public PaymentprocesstellyslipModel getdataforExcelSheet(String tno) {
		// TODO Auto-generated method stub
		 return VerificationTallySlipDao.getdataforExcelSheet(tno);
	}

	@Override
	public void savedata(PaymentprocesstellyslipModel createpayment) {
		// TODO Auto-generated method stub
		VerificationTallySlipDao.savepaymentdata(createpayment);
	}

	@Override
	public void updatefastatus(String tno) {
		// TODO Auto-generated method stub
		VerificationTallySlipDao.updatefastatus(tno);
	}

	@Override
	public void statusrmzm() {
		// TODO Auto-generated method stub
		VerificationTallySlipDao.statusrmzm();
	}

	@Override
	public List<ImageVerificationModel> getImages(String tallyNo) {
		
		return VerificationTallySlipDao.getImages(tallyNo);
	}

	@Override
	public List<VerifyTallySlip> getAllforRM(String status, String region_zone) {
		// TODO Auto-generated method stub
		return VerificationTallySlipDao.getAllforRM(status, region_zone);
	}

	@Override
	public String getEmailby_tally(String tnoemail) {
		// TODO Auto-generated method stub
		return VerificationTallySlipDao.getEmailby_tally(tnoemail);
	}

	@Override
	public List<VerifyTallySlip> getAllforZM(String status, String region_zone) {
		// TODO Auto-generated method stub
		return VerificationTallySlipDao.getAllforZM(status, region_zone);
	}

	@Override
	public void updateexceldata(String jciref, String utrno, String date) {
		// TODO Auto-generated method stub
		 VerificationTallySlipDao.updateexceldata(jciref, utrno, date);
	}

	@Override
	public void updatestatusPD(String tallyno) {
		// TODO Auto-generated method stub
		 VerificationTallySlipDao.updatestatusPD(tallyno);
	}

	@Override
	public void setholdstatus(String tno) {
		// TODO Auto-generated method stub
		VerificationTallySlipDao.setholdstatus(tno);
	}

	@Override
	public List<VerifyTallySlip> getAllHold(String region, String role_type) {
		// TODO Auto-generated method stub
		return VerificationTallySlipDao.getAllHold(region, role_type);
	}

	@Override
	public void updatestatustoPP(String tallyslipno) {
		// TODO Auto-generated method stub
		VerificationTallySlipDao.updatestatustoPP(tallyslipno);
	}



}
