package com.jci.model;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FinancialConcurenceDto {
	private int payment_id;
	Date contractdate;
	Date Created_date;
	private int contract_no;

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public Date getContractdate() {
		return contractdate;
	}

	public void setContractdate(Date contractdate) {
		this.contractdate = contractdate;
	}

	public Date getCreated_date() {
		return Created_date;
	}

	public void setCreated_date(Date created_date) {
		this.Created_date = created_date;
	}

	public int getContract_no() {
		return contract_no;
	}

	public void setContract_no(int contract_no) {
		this.contract_no = contract_no;
	}

	public FinancialConcurenceDto(int payment_id, Date contractdate, Date created_date, int contract_no) {
		super();
		this.payment_id = payment_id;
		this.contractdate = contractdate;
		this.Created_date = created_date;
		this.contract_no = contract_no;
	}

	public FinancialConcurenceDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FinancialConcurenceDto [payment_id=" + payment_id + ", contractdate=" + contractdate + ", created_date="
				+ Created_date + ", contract_no=" + contract_no + "]";
	}
	
	

}
