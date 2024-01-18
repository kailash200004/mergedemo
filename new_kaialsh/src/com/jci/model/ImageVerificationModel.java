package com.jci.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class ImageVerificationModel {
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private String F_DOC_Mandate;
	private String F_BANK_DOC;
	private String F_ID_PROF;
	private String F_REG_FORM;
	private String slip_image;
	private String gettally;
	
	
	public String getGettally() {
		return gettally;
	}
	public void setGettally(String gettally) {
		this.gettally = gettally;
	}
	public String getF_DOC_Mandate() {
		return F_DOC_Mandate;
	}
	public void setF_DOC_Mandate(String f_DOC_Mandate) {
		F_DOC_Mandate = f_DOC_Mandate;
	}
	public String getF_BANK_DOC() {
		return F_BANK_DOC;
	}
	public void setF_BANK_DOC(String f_BANK_DOC) {
		F_BANK_DOC = f_BANK_DOC;
	}
	public String getF_ID_PROF() {
		return F_ID_PROF;
	}
	public void setF_ID_PROF(String f_ID_PROF) {
		F_ID_PROF = f_ID_PROF;
	}
	public String getF_REG_FORM() {
		return F_REG_FORM;
	}
	public void setF_REG_FORM(String f_REG_FORM) {
		F_REG_FORM = f_REG_FORM;
	}
	public String getSlip_image() {
		return slip_image;
	}
	public void setSlip_image(String slip_image) {
		this.slip_image = slip_image;
	}



}
