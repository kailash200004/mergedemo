package com.jci.model;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = " jcicredit_note", schema = "dbo")
public class creditNoteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Crn_id")
	private Long Crn_id ;

	@Column(name = "Credit_note_no",unique = true)
	private String Credit_note_no;

	@Column(name = "Credit_note_date")
	private Date Credit_note_date;

	@Column(name = "Shipment_details")
	private String Shipment_details;

	@Column(name = "BOS_qty")
	private Double BOS_qty;

	@Column(name = "Actual_qty")
	private Double Actual_qty;

	@Column(name = "Short_qty")
	private Double Short_qty;

	@Column(name = "Credit_note_amount")
	private Double Credit_note_amount;

	@Column(name = "Ro_id")
	private String Ro_id;

	

	@Column(name = "Crn_status")
	private int Crn_status;

	@Column(name = "Created_by")
	private String Created_by;
	
	@Column(name = "Creation_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date Creation_date;

	public Long getCrn_id() {
		return Crn_id;
	}

	public void setCrn_id(Long crn_id) {
		Crn_id = crn_id;
	}

	public String getCredit_note_no() {
		return Credit_note_no;
	}

	public void setCredit_note_no(String credit_note_no) {
		Credit_note_no = credit_note_no;
	}

	public Date getCredit_note_date() {
		return Credit_note_date;
	}

	public void setCredit_note_date(Date credit_note_date) {
		Credit_note_date = credit_note_date;
	}

	public String getShipment_details() {
		return Shipment_details;
	}

	public void setShipment_details(String shipment_details) {
		Shipment_details = shipment_details;
	}

	public Double getBOS_qty() {
		return BOS_qty;
	}

	public void setBOS_qty(Double bOS_qty) {
		BOS_qty = bOS_qty;
	}

	public Double getActual_qty() {
		return Actual_qty;
	}

	public void setActual_qty(Double actual_qty) {
		Actual_qty = actual_qty;
	}

	public Double getShort_qty() {
		return Short_qty;
	}

	public void setShort_qty(Double short_qty) {
		Short_qty = short_qty;
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

	public Date getCreation_date() {
		return Creation_date;
	}

	public void setCreation_date(Date creation_date) {
		Creation_date = creation_date;
	}

	
	public creditNoteModel(Long crn_id, String credit_note_no, Date credit_note_date, String shipment_details,
			Double bOS_qty, Double actual_qty, Double short_qty, Double credit_note_amount, String ro_id,
			int crn_status, String created_by, Date creation_date) {
		super();
		Crn_id = crn_id;
		Credit_note_no = credit_note_no;
		Credit_note_date = credit_note_date;
		Shipment_details = shipment_details;
		BOS_qty = bOS_qty;
		Actual_qty = actual_qty;
		Short_qty = short_qty;
		Credit_note_amount = credit_note_amount;
		Ro_id = ro_id;
		Crn_status = crn_status;
		Created_by = created_by;
		Creation_date = creation_date;
	}

	

	@Override
	public String toString() {
		return "creditNoteModel [Crn_id=" + Crn_id + ", Credit_note_no=" + Credit_note_no + ", Credit_note_date="
				+ Credit_note_date + ", Shipment_details=" + Shipment_details + ", BOS_qty=" + BOS_qty + ", Actual_qty="
				+ Actual_qty + ", Short_qty=" + Short_qty + ", Credit_note_amount=" + Credit_note_amount + ", Ro_id="
				+ Ro_id + ", Crn_status=" + Crn_status + ", Created_by=" + Created_by + ", Creation_date="
				+ Creation_date + "]";
	}

	public creditNoteModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}

	

