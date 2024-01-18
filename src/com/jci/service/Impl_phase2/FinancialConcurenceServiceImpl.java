package com.jci.service.Impl_phase2;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.FinancialConcurenceDao;
import com.jci.model.FinancialConcurenceModel;
import com.jci.service_phase2.FinancialConcurenceService;

@Service
public class FinancialConcurenceServiceImpl implements FinancialConcurenceService {

	
	
	@Autowired
    FinancialConcurenceDao financialConcurencedao;

	@Override
	public void create(FinancialConcurenceModel financialConcurenceModel) {
		// TODO Auto-generated method stub
		financialConcurencedao.create(financialConcurenceModel);
	}
	@Override
    public List<FinancialConcurenceModel> getAllPaymentInstruments() {
        // Implement the method to fetch payment instruments from the DAO
        return financialConcurencedao.getAllPaymentInstruments();
    }
//	@Override
//	public void update(FinancialConcurenceModel financialConcurenceModel) {
//		financialConcurencedao.update(financialConcurenceModel);
//	}

//	@Override
//	public FinancialConcurenceModel edit(int id) {
//		return financialConcurencedao.edit(id);
//	}

//	@Override
//	public void delete(int id) {
//		financialConcurencedao.delete(id);
//	}
	
//	@Override
//    public FinancialConcurenceModel getPaymentInstrumentById(int id) {
//        return financialConcurencedao.getById(id);
//    }

//    @Override
//    public void updatePaymentInstrument(FinancialConcurenceModel financialConcurenceModel) {
//    	financialConcurencedao.update(financialConcurenceModel);
//    }
    @Override
	public   FinancialConcurenceModel find(int id) {
		return financialConcurencedao.find(id);
	}
	@Override
	public double calculateCharges( int  id, String contno) {
		return financialConcurencedao.calculateCharges(id,contno);
	}
	@Override
	public void remark(String remark,String  con_No) {
		financialConcurencedao.remark(remark,con_No);
		
	}
	@Override
	public String ContractedQty(String cont_no) {
    	 return this.financialConcurencedao.ContractedQty(cont_no);
	}
	@Override
	public int paymentid(String cont_no) {
    	 return this.financialConcurencedao.paymentid(cont_no);
	}
	
	
	

}

