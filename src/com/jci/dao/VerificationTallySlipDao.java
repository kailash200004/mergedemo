package com.jci.dao;

import java.util.Date;
import java.util.List;

import com.jci.model.ImageVerificationModel;
import com.jci.model.PaymentprocesstellyslipModel;
import com.jci.model.VerifyTallySlip;

public interface VerificationTallySlipDao {
	public void create(VerifyTallySlip verifyTallySlip);
	public void update(VerifyTallySlip verifyTallySlip);
	public VerifyTallySlip edit(int id);
	public void delete(int id);
	public VerifyTallySlip find(int id);
	public List <VerifyTallySlip> getAll(String status, String region,String role_type);
	public boolean submitform(VerifyTallySlip verifyTallySlip);
	public String GettransectionDetails(String tallyNo, String region);
	//public  VerifyTallySlip findByTally(String tallyslipno);
	public boolean updatebyTally(String status, int verified,String tallyno);
	public PaymentprocesstellyslipModel getdataforExcelSheet(String tno);
	public void savepaymentdata(PaymentprocesstellyslipModel createpayment);
	public void updatefastatus(String tno);
	public void statusrmzm();
	public List<ImageVerificationModel> getImages(String tallyNo);
	public List<VerifyTallySlip> getAllforRM(String status, String region_zone);
	public String getEmailby_tally(String tnoemail);
	public List<VerifyTallySlip> getAllforZM(String status, String region_zone);
	public void updateexceldata(String jciref, String utrno, String date);
	public void updatestatusPD(String tallyno);
	public void setholdstatus(String tno);
	public List<VerifyTallySlip> getAllHold(String region, String role_type);
	public void updatestatustoPP(String tallyslipno);
}
