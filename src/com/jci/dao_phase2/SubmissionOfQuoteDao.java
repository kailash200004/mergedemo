package com.jci.dao_phase2;

import java.util.List;


import com.jci.model.SubmissionOfQuoteModel;

public interface SubmissionOfQuoteDao {
	public void create(SubmissionOfQuoteModel submissionOfQuoteModel);
	 public List<SubmissionOfQuoteModel> getAll();
	 public int bidrollout_No();
}
