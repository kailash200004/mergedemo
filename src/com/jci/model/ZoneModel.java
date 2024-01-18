package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcizones", schema = "dbo")
public class ZoneModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "zoneid")
	private int zoneid;

	@Column(name = "zonecode")
	private String zonecode;

	@Column(name = "zonename")
	private String zonename;

	@Column(name = "status")
	private String status;

	public ZoneModel() {

	}

	public ZoneModel(int zoneid, String zonecode, String zonename, String status) {
		this.zoneid = zoneid;
		this.zonecode = zonecode;
		this.zonename = zonename;
		this.status = status;
	}

	public int getZoneid() {
		return zoneid;
	}

	public void setZoneid(int zoneid) {
		this.zoneid = zoneid;
	}

	public String getZonecode() {
		return zonecode;
	}

	public void setZonecode(String zonecode) {
		this.zonecode = zonecode;
	}

	public String getZonename() {
		return zonename;
	}

	public void setZonename(String zonename) {
		this.zonename = zonename;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ZoneModel [zoneid=" + zoneid + ", zonecode=" + zonecode + ", zonename=" + zonename + ", status="
				+ status + "]";
	}
}
