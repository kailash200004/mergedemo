package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcirodetails", schema = "dbo")
public class RoDetailsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roid")
	private int roid;

	@Column(name="distcode")
	private String distcode;

	@Column(name="rocode")
	private String rocode;

	@Column(name="roname")
	private String roname;

	@Column(name="rostreet")
	private String rostreet;

	@Column(name="rophonenumber1")
	private String rophonenumber1;

	@Column(name="rophonenumber2")
	private String rophonenumber2;

	@Column(name="officetype")
	private String officetype;

	@Column(name="shortname")
	private String shortname;

	@Column(name="createdby")
	private int createdby;

	@Column(name="status")
	private int status;

	@Column(name="zonecode")
	private String zonecode;

	public RoDetailsModel() {

	}

	public RoDetailsModel(int roid, String distcode, String rocode, String roname, String rostreet,
			String rophonenumber1, String rophonenumber2, String officetype, String shortname, int createdby,
			int status, String zonecode) {
		super();
		this.roid = roid;
		this.distcode = distcode;
		this.rocode = rocode;
		this.roname = roname;
		this.rostreet = rostreet;
		this.rophonenumber1 = rophonenumber1;
		this.rophonenumber2 = rophonenumber2;
		this.officetype = officetype;
		this.shortname = shortname;
		this.createdby = createdby;
		this.status = status;
		this.zonecode = zonecode;
	}

	@Override
	public String toString() {
		return "RoDetailsModel [roid=" + roid + ", distcode=" + distcode + ", rocode=" + rocode + ", roname=" + roname
				+ ", rostreet=" + rostreet + ", rophonenumber1=" + rophonenumber1 + ", rophonenumber2=" + rophonenumber2
				+ ", officetype=" + officetype + ", shortname=" + shortname + ", createdby=" + createdby + ", status="
				+ status + ", zonecode=" + zonecode + "]";
	}

	public int getRoid() {
		return roid;
	}

	public void setRoid(int roid) {
		this.roid = roid;
	}

	public String getDistcode() {
		return distcode;
	}

	public void setDistcode(String distcode) {
		this.distcode = distcode;
	}

	public String getRocode() {
		return rocode;
	}

	public void setRocode(String rocode) {
		this.rocode = rocode;
	}

	public String getRoname() {
		return roname;
	}

	public void setRoname(String roname) {
		this.roname = roname;
	}

	public String getRostreet() {
		return rostreet;
	}

	public void setRostreet(String rostreet) {
		this.rostreet = rostreet;
	}

	public String getRophonenumber1() {
		return rophonenumber1;
	}

	public void setRophonenumber1(String rophonenumber1) {
		this.rophonenumber1 = rophonenumber1;
	}

	public String getRophonenumber2() {
		return rophonenumber2;
	}

	public void setRophonenumber2(String rophonenumber2) {
		this.rophonenumber2 = rophonenumber2;
	}

	public String getOfficetype() {
		return officetype;
	}

	public void setOfficetype(String officetype) {
		this.officetype = officetype;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getZonecode() {
		return zonecode;
	}

	public void setZonecode(String zonecode) {
		this.zonecode = zonecode;
	}
}
