package com.jci.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.PaymentInstrumentdao;
import com.jci.model.PaymentInstrumentModel;
import com.jci.service.PaymentInstrumentService;

@Service
public class PaymentInstrumentServiceImpl implements PaymentInstrumentService {
	@Autowired
    PaymentInstrumentdao paymentinstrumentdao;

	@Override
	public void create(PaymentInstrumentModel paymentinstrument) {
		// TODO Auto-generated method stub
		paymentinstrumentdao.create(paymentinstrument);
	}

}
