package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcicash_document", schema = "dbo")
public class genrationcashdocument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CAD Doc No" ,unique = true)
	private String CAD_Doc_No;
    
    @Column(name = "CAD Date",nullable = false)
	private Date CAD_Date;
    
    @Column(name = "BOS No",nullable = false)
	private String BOS_No;
    
    @Column(name = "BOS Date",nullable = false)
	private Date BOS_Date;

	public String getCAD_Doc_No() {
		return CAD_Doc_No;
	}

	public void setCAD_Doc_No(String cAD_Doc_No) {
		CAD_Doc_No = cAD_Doc_No;
	}

	public Date getCAD_Date() {
		return CAD_Date;
	}

	public void setCAD_Date(Date cAD_Date) {
		CAD_Date = cAD_Date;
	}

	public String getBOS_No() {
		return BOS_No;
	}

	public void setBOS_No(String bOS_No) {
		BOS_No = bOS_No;
	}

	public Date getBOS_Date() {
		return BOS_Date;
	}

	public void setBOS_Date(Date bOS_Date) {
		BOS_Date = bOS_Date;
	}

	public genrationcashdocument(String cAD_Doc_No, Date cAD_Date, String bOS_No, Date bOS_Date) {
		super();
		CAD_Doc_No = cAD_Doc_No;
		CAD_Date = cAD_Date;
		BOS_No = bOS_No;
		BOS_Date = bOS_Date;
	}

	public genrationcashdocument() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "genrationcashdocument [CAD_Doc_No=" + CAD_Doc_No + ", CAD_Date=" + CAD_Date + ", BOS_No=" + BOS_No
				+ ", BOS_Date=" + BOS_Date + "]";
	}
    
    
}
