package com.jci.model;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "jcibid_subission1", schema = "dbo")
public class SubmissionOfQuoteModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "BIGINT" ,name = "Submission_id ")
	private BigInteger  Submission_id  ;
	
	
	@Column(name = "Bid_Reference_No")
	private String  Bid_Reference_No ;
	
	@Column( name = "Mill_code")
	private String Mill_code;
	
	
	
	@Column( name = "Mill_name")
	private String Mill_name;
	
	@Column( name = "Lot_Identification")
	private String Lot_Identification ;
	
	
	
	@Column( name = "Quoted_Base_Price")
	private Double Quoted_Base_Price;
	
	
	
	@Column( name = "Bid_Quote_Document")
	private String Bid_Quote_Document;
	
	
	@Column( name = "Created_by")
	private String Created_by;
	
	@Column( name = "Creation_date")
	private Date Creation_date;
	
	@Column( name = "Bid_rank")
	private String Bid_rank;

	public BigInteger getSubmission_id() {
		return Submission_id;
	}

	public void setSubmission_id(BigInteger submission_id) {
		Submission_id = submission_id;
	}

	public String getBid_Reference_No() {
		return Bid_Reference_No;
	}

	public void setBid_Reference_No(String bid_Reference_No) {
		Bid_Reference_No = bid_Reference_No;
	}

	public String getMill_code() {
		return Mill_code;
	}

	public void setMill_code(String mill_code) {
		Mill_code = mill_code;
	}

	public String getMill_name() {
		return Mill_name;
	}

	public void setMill_name(String mill_name) {
		Mill_name = mill_name;
	}

	public String getLot_Identification() {
		return Lot_Identification;
	}

	public void setLot_Identification(String lot_Identification) {
		Lot_Identification = lot_Identification;
	}

	public Double getQuoted_Base_Price() {
		return Quoted_Base_Price;
	}

	public void setQuoted_Base_Price(Double quoted_Base_Price) {
		Quoted_Base_Price = quoted_Base_Price;
	}

	public String getBid_Quote_Document() {
		return Bid_Quote_Document;
	}

	public void setBid_Quote_Document(String bid_Quote_Document) {
		Bid_Quote_Document = bid_Quote_Document;
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

	public String getBid_rank() {
		return Bid_rank;
	}

	public void setBid_rank(String bid_rank) {
		Bid_rank = bid_rank;
	}

	public SubmissionOfQuoteModel(BigInteger submission_id, String bid_Reference_No, String mill_code, String mill_name,
			String lot_Identification, Double quoted_Base_Price, String bid_Quote_Document, String created_by,
			Timestamp creation_date, String bid_rank) {
		super();
		Submission_id = submission_id;
		Bid_Reference_No = bid_Reference_No;
		Mill_code = mill_code;
		Mill_name = mill_name;
		Lot_Identification = lot_Identification;
		Quoted_Base_Price = quoted_Base_Price;
		Bid_Quote_Document = bid_Quote_Document;
		Created_by = created_by;
		Creation_date = creation_date;
		Bid_rank = bid_rank;
	}

	public SubmissionOfQuoteModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SubmissionOfQuoteModel [Submission_id=" + Submission_id + ", Bid_Reference_No=" + Bid_Reference_No
				+ ", Mill_code=" + Mill_code + ", Mill_name=" + Mill_name + ", Lot_Identification=" + Lot_Identification
				+ ", Quoted_Base_Price=" + Quoted_Base_Price + ", Bid_Quote_Document=" + Bid_Quote_Document
				+ ", Created_by=" + Created_by + ", Creation_date=" + Creation_date + ", Bid_rank=" + Bid_rank + "]";
	}
	
	
	
}
