package com.jci.service;

import java.util.List;

import com.jci.model.ImageVerificationModel;
import com.jci.model.PaymentprocesstellyslipModel;
import com.jci.model.VerifyTallySlip;
public interface VerifyTallySlipService {
	public void create(VerifyTallySlip VerifyTallySlip);
	public void update(VerifyTallySlip VerifyTallySlip);
	public VerifyTallySlip edit(int id);
	public void delete(int id);
	public VerifyTallySlip find(int id);
	public List<VerifyTallySlip> getAll(String status, String region);
	public boolean submitform(VerifyTallySlip VerifyTallySlip);

	public String GettransectionDetails(String tallyNo, String region);
//	public VerifyTallySlip findByTally(String tallyslipno);
	public boolean updatebyTally(String status, int verified,String tallyno);
	public PaymentprocesstellyslipModel updatepaymentstatus(String tno);
	public void savedata(PaymentprocesstellyslipModel createpayment);
	public void updatefastatus(String tno);
	public void statusrmzm();
	public List<ImageVerificationModel> getImages(String tallyNo);
	public List<VerifyTallySlip> getAllforRM(String status, String region_zone);
	public String getEmailby_tally(String tnoemail);
	public List<VerifyTallySlip> getAllforZM(String string, String region_zone);
}
