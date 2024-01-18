package com.jci.service;

import org.springframework.stereotype.Service;

import com.jci.model.UploadingReceiptModel;
@Service
public interface UploadRecieptService {

	void create(UploadingReceiptModel uploadrecipt);

}
