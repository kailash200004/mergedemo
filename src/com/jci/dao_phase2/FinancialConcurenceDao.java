package com.jci.dao_phase2;



import java.util.List;

import com.jci.model.FinancialConcurenceModel;


public interface FinancialConcurenceDao {

	public void create(FinancialConcurenceModel financialConcurenceModel);
	 public List<FinancialConcurenceModel> getAllPaymentInstruments();
	 //public void update(FinancialConcurenceModel financialConcurenceModel);
		//public FinancialConcurenceModel edit(int id);
		//public void delete(int id);
		//public List <PaymentInstrumentModel> getAll();
//		PaymentInstrumentModel find(int id);
		//public PaymentInstrumentModel paymentInstrumentProfile(int eopiid);
		//FinancialConcurenceModel getById(int id);
		  //public   void update(PaymentInstrumentModel paymentInstrument);
		//public FinancialConcurenceModel find(int id);
	 public double calculateCharges(int id, String contno);
	 public FinancialConcurenceModel find(int id);
	 public void remark(String remark,String  con_No);
	 public String ContractedQty(String cont_no);
	 public int paymentid(String cont_no);
}

