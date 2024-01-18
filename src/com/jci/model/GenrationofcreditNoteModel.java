package com.jci.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;

@Entity
@Table(name = "jcicredit_note_settled", schema = "dbo")
public class GenrationofcreditNoteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Crn_id;
	private Date Credit_note_date;
	private String Credit_note_no;
	private String Contract_no;
	private String HO_di;
	private String Challan_no;
	private int bales;
	private double Variety_grade;
	private String Mr_no;
	private Date Mr_date;
	private String Claim_type;
	private Double Settlement_percentage;
	private Double Settlement_amount;
	private Double Credit_note_amount;
	private String Ro_id;
	private int Crn_status;
	private String Created_by;
	private Timestamp Creation_date;
	public int getCrn_id() {
		return Crn_id;
	}
	public void setCrn_id(int crn_id) {
		Crn_id = crn_id;
	}
	public Date getCredit_note_date() {
		return Credit_note_date;
	}
	public void setCredit_note_date(Date credit_note_date) {
		Credit_note_date = credit_note_date;
	}
	public String getCredit_note_no() {
		return Credit_note_no;
	}
	public void setCredit_note_no(String credit_note_no) {
		Credit_note_no = credit_note_no;
	}
	public String getContract_no() {
		return Contract_no;
	}
	public void setContract_no(String contract_no) {
		Contract_no = contract_no;
	}
	public String getHO_di() {
		return HO_di;
	}
	public void setHO_di(String hO_di) {
		HO_di = hO_di;
	}
	public String getChallan_no() {
		return Challan_no;
	}
	public void setChallan_no(String challan_no) {
		Challan_no = challan_no;
	}
	public int getBales() {
		return bales;
	}
	public void setBales(int bales) {
		this.bales = bales;
	}
	public double getVariety_grade() {
		return Variety_grade;
	}
	public void setVariety_grade(double variety_grade) {
		Variety_grade = variety_grade;
	}
	public String getMr_no() {
		return Mr_no;
	}
	public void setMr_no(String mr_no) {
		Mr_no = mr_no;
	}
	public Date getMr_date() {
		return Mr_date;
	}
	public void setMr_date(Date mr_date) {
		Mr_date = mr_date;
	}
	public String getClaim_type() {
		return Claim_type;
	}
	public void setClaim_type(String claim_type) {
		Claim_type = claim_type;
	}
	public Double getSettlement_percentage() {
		return Settlement_percentage;
	}
	public void setSettlement_percentage(Double settlement_percentage) {
		Settlement_percentage = settlement_percentage;
	}
	public Double getSettlement_amount() {
		return Settlement_amount;
	}
	public void setSettlement_amount(Double settlement_amount) {
		Settlement_amount = settlement_amount;
	}
	public Double getCredit_note_amount() {
		return Credit_note_amount;
	}
	public void setCredit_note_amount(Double credit_note_amount) {
		Credit_note_amount = credit_note_amount;
	}
	public String getRo_id() {
		return Ro_id;
	}
	public void setRo_id(String ro_id) {
		Ro_id = ro_id;
	}
	public int getCrn_status() {
		return Crn_status;
	}
	public void setCrn_status(int crn_status) {
		Crn_status = crn_status;
	}
	public String getCreated_by() {
		return Created_by;
	}
	public void setCreated_by(String created_by) {
		Created_by = created_by;
	}
	public Timestamp getCreation_date() {
		return Creation_date;
	}
	public void setCreation_date(Timestamp creation_date) {
		Creation_date = creation_date;
	}
	public GenrationofcreditNoteModel(int crn_id, Date credit_note_date, String credit_note_no, String contract_no,
			String hO_di, String challan_no, int bales, double variety_grade, String mr_no, Date mr_date,
			String claim_type, Double settlement_percentage, Double settlement_amount, Double credit_note_amount,
			String ro_id, int crn_status, String created_by, Timestamp creation_date) {
		super();
		Crn_id = crn_id;
		Credit_note_date = credit_note_date;
		Credit_note_no = credit_note_no;
		Contract_no = contract_no;
		HO_di = hO_di;
		Challan_no = challan_no;
		this.bales = bales;
		Variety_grade = variety_grade;
		Mr_no = mr_no;
		Mr_date = mr_date;
		Claim_type = claim_type;
		Settlement_percentage = settlement_percentage;
		Settlement_amount = settlement_amount;
		Credit_note_amount = credit_note_amount;
		Ro_id = ro_id;
		Crn_status = crn_status;
		Created_by = created_by;
		Creation_date = creation_date;
	}
	@Override
	public String toString() {
		return "GenrationofcreditNoteModel [Crn_id=" + Crn_id + ", Credit_note_date=" + Credit_note_date
				+ ", Credit_note_no=" + Credit_note_no + ", Contract_no=" + Contract_no + ", HO_di=" + HO_di
				+ ", Challan_no=" + Challan_no + ", bales=" + bales + ", Variety_grade=" + Variety_grade + ", Mr_no="
				+ Mr_no + ", Mr_date=" + Mr_date + ", Claim_type=" + Claim_type + ", Settlement_percentage="
				+ Settlement_percentage + ", Settlement_amount=" + Settlement_amount + ", Credit_note_amount="
				+ Credit_note_amount + ", Ro_id=" + Ro_id + ", Crn_status=" + Crn_status + ", Created_by=" + Created_by
				+ ", Creation_date=" + Creation_date + "]";
	}
	public GenrationofcreditNoteModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
