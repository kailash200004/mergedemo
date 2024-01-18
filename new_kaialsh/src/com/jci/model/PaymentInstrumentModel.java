package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcipaymentinstrument", schema = "dbo")
public class PaymentInstrumentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eopiid")
	private int eopiid;
	
	@Column(name = "fullcontractno")
	private String fullcontractno;
	
	@Column(name = "contractdate")
	private Date contractdate;
	
	@Column(name = "cropyear")
	private String cropyear;
	
	@Column(name = "contractquantity")
	private String contractquantity;
	
	@Column(name = "varietygradewisequantity")
	private String varietygradewisequantity;
	
	@Column(name = "millofficeaddress")
	private String millofficeaddress;
	
	@Column(name = "millsideaddress")
	private String millsideaddress;
	
	@Column(name = "paymenttype")
	private String paymenttype ;
	
	@Column(name = "millaccountcode")
	private String millaccountcode ;
	
	@Column(name = "instrumentno")
	private String instrumentno;
	
	@Column(name = "instrumentdate")
	private Date instrumentdate;
	
	@Column(name = "bankname")
	private String bankname;
	
	@Column(name = "bankbranch")
	private String bankbranch;
	
	@Column(name = "amount")
	private String amount;
	
	@Column(name = "autorevolvingoption")
	private String autorevolvingoption;
	
	@Column(name = "autorevolvingamount")
	private String autorevolvingamount;
	
	@Column(name = "dateofshipment")
	private Date dateofshipment;
	
	@Column(name = "dateofexpiry")
	private Date dateofexpiry;
	
	@Column(name = "generateddate")
	private String generateddate;

	public int getEopiid() {
		return eopiid;
	}

	public void setEopiid(int eopiid) {
		this.eopiid = eopiid;
	}

	public String getFullcontractno() {
		return fullcontractno;
	}

	public void setFullcontractno(String fullcontractno) {
		this.fullcontractno = fullcontractno;
	}

	public Date getContractdate() {
		return contractdate;
	}

	public void setContractdate(Date contractdate) {
		this.contractdate = contractdate;
	}

	public String getCropyear() {
		return cropyear;
	}

	public void setCropyear(String cropyear) {
		this.cropyear = cropyear;
	}

	public String getContractquantity() {
		return contractquantity;
	}

	public void setContractquantity(String contractquantity) {
		this.contractquantity = contractquantity;
	}

	public String getVarietygradewisequantity() {
		return varietygradewisequantity;
	}

	public void setVarietygradewisequantity(String varietygradewisequantity) {
		this.varietygradewisequantity = varietygradewisequantity;
	}

	public String getMillofficeaddress() {
		return millofficeaddress;
	}

	public void setMillofficeaddress(String millofficeaddress) {
		this.millofficeaddress = millofficeaddress;
	}

	public String getMillsideaddress() {
		return millsideaddress;
	}

	public void setMillsideaddress(String millsideaddress) {
		this.millsideaddress = millsideaddress;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public String getMillaccountcode() {
		return millaccountcode;
	}

	public void setMillaccountcode(String millaccountcode) {
		this.millaccountcode = millaccountcode;
	}

	public String getInstrumentno() {
		return instrumentno;
	}

	public void setInstrumentno(String instrumentno) {
		this.instrumentno = instrumentno;
	}

	public Date getInstrumentdate() {
		return instrumentdate;
	}

	public void setInstrumentdate(Date instrumentdate) {
		this.instrumentdate = instrumentdate;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBankbranch() {
		return bankbranch;
	}

	public void setBankbranch(String bankbranch) {
		this.bankbranch = bankbranch;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAutorevolvingoption() {
		return autorevolvingoption;
	}

	public void setAutorevolvingoption(String autorevolvingoption) {
		this.autorevolvingoption = autorevolvingoption;
	}

	public String getAutorevolvingamount() {
		return autorevolvingamount;
	}

	public void setAutorevolvingamount(String autorevolvingamount) {
		this.autorevolvingamount = autorevolvingamount;
	}

	public Date getDateofshipment() {
		return dateofshipment;
	}

	public void setDateofshipment(Date dateofshipment) {
		this.dateofshipment = dateofshipment;
	}

	public Date getDateofexpiry() {
		return dateofexpiry;
	}

	public void setDateofexpiry(Date dateofexpiry) {
		this.dateofexpiry = dateofexpiry;
	}

	public String getGenerateddate() {
		return generateddate;
	}

	public void setGenerateddate(String generateddate) {
		this.generateddate = generateddate;
	}

	public PaymentInstrumentModel(int eopiid, String fullcontractno, Date contractdate, String cropyear,
			String contractquantity, String varietygradewisequantity, String millofficeaddress, String millsideaddress,
			String paymenttype, String millaccountcode, String instrumentno, Date instrumentdate, String bankname,
			String bankbranch, String amount, String autorevolvingoption, String autorevolvingamount,
			Date dateofshipment, Date dateofexpiry, String generateddate) {
		super();
		this.eopiid = eopiid;
		this.fullcontractno = fullcontractno;
		this.contractdate = contractdate;
		this.cropyear = cropyear;
		this.contractquantity = contractquantity;
		this.varietygradewisequantity = varietygradewisequantity;
		this.millofficeaddress = millofficeaddress;
		this.millsideaddress = millsideaddress;
		this.paymenttype = paymenttype;
		this.millaccountcode = millaccountcode;
		this.instrumentno = instrumentno;
		this.instrumentdate = instrumentdate;
		this.bankname = bankname;
		this.bankbranch = bankbranch;
		this.amount = amount;
		this.autorevolvingoption = autorevolvingoption;
		this.autorevolvingamount = autorevolvingamount;
		this.dateofshipment = dateofshipment;
		this.dateofexpiry = dateofexpiry;
		this.generateddate = generateddate;
	}

	public PaymentInstrumentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PaymentInstrumentModel [eopiid=" + eopiid + ", fullcontractno=" + fullcontractno + ", contractdate="
				+ contractdate + ", cropyear=" + cropyear + ", contractquantity=" + contractquantity
				+ ", varietygradewisequantity=" + varietygradewisequantity + ", millofficeaddress=" + millofficeaddress
				+ ", millsideaddress=" + millsideaddress + ", paymenttype=" + paymenttype + ", millaccountcode="
				+ millaccountcode + ", instrumentno=" + instrumentno + ", instrumentdate=" + instrumentdate
				+ ", bankname=" + bankname + ", bankbranch=" + bankbranch + ", amount=" + amount
				+ ", autorevolvingoption=" + autorevolvingoption + ", autorevolvingamount=" + autorevolvingamount
				+ ", dateofshipment=" + dateofshipment + ", dateofexpiry=" + dateofexpiry + ", generateddate="
				+ generateddate + "]";
	}
	
	
	
}
