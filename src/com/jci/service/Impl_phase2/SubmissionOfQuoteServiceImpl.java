package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.SubmissionOfQuoteDao;
import com.jci.model.SubmissionOfQuoteModel;
import com.jci.service_phase2.SubmissionOfQuoteService;
@Service
public class SubmissionOfQuoteServiceImpl implements SubmissionOfQuoteService {

	
	@Autowired
	SubmissionOfQuoteDao submissionOfQuoteDao;
	
	@Override
	public void create(SubmissionOfQuoteModel submissionOfQuoteModel) {
		submissionOfQuoteDao.create(submissionOfQuoteModel);
		
	}

	@Override
	public List<SubmissionOfQuoteModel> getAll() {
		// TODO Auto-generated method stub
		 return submissionOfQuoteDao.getAll();
	}

	@Override
	public int bidrollout_No() {
		// TODO Auto-generated method stub
		return submissionOfQuoteDao.bidrollout_No();
	}

}
