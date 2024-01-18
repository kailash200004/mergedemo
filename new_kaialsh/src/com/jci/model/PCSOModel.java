package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcisalespcso", schema = "dbo")
public class PCSOModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pcsoid")
	private int pcsoid;

	@Column(name = "referenceno")
	private String referenceno;

	@Column(name = "referencedate")
	private Date referencedate;

	@Column(name = "pcsodate")
	private Date pcsodate;

	@Column(name = "millcode")
	private String millcode;

	@Column(name = "totalallocation")
	private int totalallocation;

	@Column(name = "createdby")
	private int createdby;

	@Column(name ="ipaddress")
	private String ipaddress;

	@Column(name="status")
	private int status;

	public PCSOModel() {

	}

	public PCSOModel(int pcsoid, String referenceno, Date referencedate, Date pcsodate, String millcode,
			int totalallocation, int createdby, String ipaddress, int status) {
		this.pcsoid = pcsoid;
		this.referenceno = referenceno;
		this.referencedate = referencedate;
		this.pcsodate = pcsodate;
		this.millcode = millcode;
		this.totalallocation = totalallocation;
		this.createdby = createdby;
		this.ipaddress = ipaddress;
		this.status = status;
	}

	public int getPcsoid() {
		return pcsoid;
	}

	public void setPcsoid(int pcsoid) {
		this.pcsoid = pcsoid;
	}

	public String getReferenceno() {
		return referenceno;
	}

	public void setReferenceno(String referenceno) {
		this.referenceno = referenceno;
	}

	public Date getReferencedate() {
		return referencedate;
	}

	public void setReferencedate(Date referencedate) {
		this.referencedate = referencedate;
	}

	public Date getPcsodate() {
		return pcsodate;
	}

	public void setPcsodate(Date pcsodate) {
		this.pcsodate = pcsodate;
	}

	public String getMillcode() {
		return millcode;
	}

	public void setMillcode(String millcode) {
		this.millcode = millcode;
	}

	public int getTotalallocation() {
		return totalallocation;
	}

	public void setTotalallocation(int totalallocation) {
		this.totalallocation = totalallocation;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PCSOModel [pcsoid=" + pcsoid + ", referenceno=" + referenceno + ", referencedate=" + referencedate
				+ ", pcsodate=" + pcsodate + ", millcode=" + millcode + ", totalallocation=" + totalallocation
				+ ", createdby=" + createdby + ", ipaddress=" + ipaddress + ", status=" + status + "]";
	}

}
