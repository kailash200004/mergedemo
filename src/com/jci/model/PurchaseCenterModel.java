package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcipurchasecenter", schema = "dbo")
public class PurchaseCenterModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pcid")
	private int pcid;

	@Column(name = "district")
	private String district;

	@Column(name = "rocode")
	private String rocode;

	@Column(name = "centername")
	private String centername;

	@Column(name = "baleticketmark")
	private String baleticketmark;

	@Column(name = "phone1")
	private String phone1;

	@Column(name = "phone2")
	private String phone2;

	@Column(name = "address2")
	private String address2;

	@Column(name = "address3")
	private String address3;

	@Column(name = "address4")
	private String address4;

	@Column(name = "status")
	private int status;

	public PurchaseCenterModel() {

	}

	public PurchaseCenterModel(int pcid, String district, String rocode, String centername, String baleticketmark,
			String phone1, String phone2, String address2, String address3, String address4, int status) {
		this.pcid = pcid;
		this.district = district;
		this.rocode = rocode;
		this.centername = centername;
		this.baleticketmark = baleticketmark;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.address2 = address2;
		this.address3 = address3;
		this.address4 = address4;
		this.status = status;
	}

	public int getPcid() {
		return pcid;
	}

	public void setPcid(int pcid) {
		this.pcid = pcid;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getRocode() {
		return rocode;
	}

	public void setRocode(String rocode) {
		this.rocode = rocode;
	}

	public String getCentername() {
		return centername;
	}

	public void setCentername(String centername) {
		this.centername = centername;
	}

	public String getBaleticketmark() {
		return baleticketmark;
	}

	public void setBaleticketmark(String baleticketmark) {
		this.baleticketmark = baleticketmark;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PurchaseCenterModel [pcid=" + pcid + ", district=" + district + ", rocode=" + rocode + ", centername="
				+ centername + ", baleticketmark=" + baleticketmark + ", phone1=" + phone1 + ", phone2=" + phone2
				+ ", address2=" + address2 + ", address3=" + address3 + ", address4=" + address4 + ", status=" + status
				+ "]";
	}
}
