package com.jci.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.UploadRecieptDao;
import com.jci.model.UploadingReceiptModel;
import com.jci.service.UploadRecieptService;

@Service
public class UploadRecieptServiceImpl implements UploadRecieptService {

	@Autowired
	UploadRecieptDao uploadrecieptDao;
	
	@Override
	public void create(UploadingReceiptModel uploadrecipt) {
		uploadrecieptDao.create(uploadrecipt);
		
	}

}
