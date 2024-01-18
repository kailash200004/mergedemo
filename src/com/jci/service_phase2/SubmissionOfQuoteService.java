package com.jci.service_phase2;

import java.util.List;

import org.springframework.stereotype.Service;


import com.jci.model.SubmissionOfQuoteModel;
@Service
public interface SubmissionOfQuoteService {
	public void create(SubmissionOfQuoteModel submissionOfQuoteModel);
	 public List<SubmissionOfQuoteModel>getAll();
	//public String fetchBos_No();
	 public int bidrollout_No();
}
