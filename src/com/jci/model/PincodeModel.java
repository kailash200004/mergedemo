package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pincode", schema = "dbo")

public class PincodeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pinid")
	private int pinid;

	@Column(name = "pincode")
	private String pincode;

	@Column(name = "status")
	private String status;

	public PincodeModel() {

	}

	public int getPinid() {
		return pinid;
	}

	public void setPinid(int pinid) {
		this.pinid = pinid;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PincodeModel [pinid=" + pinid + ", pincode=" + pincode + ", status=" + status + "]";
	}

	public PincodeModel(int pinid, String pincode, String status) {
		super();
		this.pinid = pinid;
		this.pincode = pincode;
		this.status = status;
	}



}
