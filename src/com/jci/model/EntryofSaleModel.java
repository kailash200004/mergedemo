package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entryofsale", schema = "dbo")
public class EntryofSaleModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entryofsaleid")
	private int entryofsaleid;
	
	@Column(name = "dpcno")
	private String dpcno;
	
	@Column(name = "dpcdate")
	private Date dpcdate;
	
	@Column(name = "millsname")
	private String millsname;
	
	@Column(name = "contractnoanddate")
	private String contractnoanddate;
	
	@Column(name = "dinoanddate")
	private String dinoanddate;
	
	@Column(name = "centername")
	private String centername;

	@Column(name = "agency")
	private String agency;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "challanno")
	private String challanno;
	
	@Column(name = "challandate")
	private Date challandate;
	
	@Column(name = "lotno")
	private String lotno;
	
	@Column(name = "transportno")
	private String transportno;
	
	@Column(name = "cropyear")
	private String cropyear;
	
	@Column(name = "jutevariety")
	private String jutevariety;
	
	@Column(name = "jutegrade")
	private String jutegrade;
	
	@Column(name = "nominalweight")
	private String nominalweight;
	
	@Column(name = "quantity")
	private String quantity;
	
	@Column(name = "rateperquintals")
	private String rateperquintals;

	public int getEntryofsaleid() {
		return entryofsaleid;
	}

	public void setEntryofsaleid(int entryofsaleid) {
		this.entryofsaleid = entryofsaleid;
	}

	public String getDpcno() {
		return dpcno;
	}

	public void setDpcno(String dpcno) {
		this.dpcno = dpcno;
	}

	public Date getDpcdate() {
		return dpcdate;
	}

	public void setDpcdate(Date dpcdate) {
		this.dpcdate = dpcdate;
	}

	public String getMillsname() {
		return millsname;
	}

	public void setMillsname(String millsname) {
		this.millsname = millsname;
	}

	public String getContractnoanddate() {
		return contractnoanddate;
	}

	public void setContractnoanddate(String contractnoanddate) {
		this.contractnoanddate = contractnoanddate;
	}

	public String getDinoanddate() {
		return dinoanddate;
	}

	public void setDinoanddate(String dinoanddate) {
		this.dinoanddate = dinoanddate;
	}

	public String getCentername() {
		return centername;
	}

	public void setCentername(String centername) {
		this.centername = centername;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getChallanno() {
		return challanno;
	}

	public void setChallanno(String challanno) {
		this.challanno = challanno;
	}

	public Date getChallandate() {
		return challandate;
	}

	public void setChallandate(Date challandate) {
		this.challandate = challandate;
	}

	public String getLotno() {
		return lotno;
	}

	public void setLotno(String lotno) {
		this.lotno = lotno;
	}

	public String getTransportno() {
		return transportno;
	}

	public void setTransportno(String transportno) {
		this.transportno = transportno;
	}

	public String getCropyear() {
		return cropyear;
	}

	public void setCropyear(String cropyear) {
		this.cropyear = cropyear;
	}

	public String getJutevariety() {
		return jutevariety;
	}

	public void setJutevariety(String jutevariety) {
		this.jutevariety = jutevariety;
	}

	public String getJutegrade() {
		return jutegrade;
	}

	public void setJutegrade(String jutegrade) {
		this.jutegrade = jutegrade;
	}

	public String getNominalweight() {
		return nominalweight;
	}

	public void setNominalweight(String nominalweight) {
		this.nominalweight = nominalweight;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getRateperquintals() {
		return rateperquintals;
	}

	public void setRateperquintals(String rateperquintals) {
		this.rateperquintals = rateperquintals;
	}

	@Override
	public String toString() {
		return "EntryofSaleModel [entryofsaleid=" + entryofsaleid + ", dpcno=" + dpcno + ", dpcdate=" + dpcdate
				+ ", millsname=" + millsname + ", contractnoanddate=" + contractnoanddate + ", dinoanddate="
				+ dinoanddate + ", centername=" + centername + ", agency=" + agency + ", region=" + region
				+ ", challanno=" + challanno + ", challandate=" + challandate + ", lotno=" + lotno + ", transportno="
				+ transportno + ", cropyear=" + cropyear + ", jutevariety=" + jutevariety + ", jutegrade=" + jutegrade
				+ ", nominalweight=" + nominalweight + ", quantity=" + quantity + ", rateperquintals=" + rateperquintals
				+ "]";
	}

	public EntryofSaleModel(int entryofsaleid, String dpcno, Date dpcdate, String millsname, String contractnoanddate,
			String dinoanddate, String centername, String agency, String region, String challanno, Date challandate,
			String lotno, String transportno, String cropyear, String jutevariety, String jutegrade,
			String nominalweight, String quantity, String rateperquintals) {
		super();
		this.entryofsaleid = entryofsaleid;
		this.dpcno = dpcno;
		this.dpcdate = dpcdate;
		this.millsname = millsname;
		this.contractnoanddate = contractnoanddate;
		this.dinoanddate = dinoanddate;
		this.centername = centername;
		this.agency = agency;
		this.region = region;
		this.challanno = challanno;
		this.challandate = challandate;
		this.lotno = lotno;
		this.transportno = transportno;
		this.cropyear = cropyear;
		this.jutevariety = jutevariety;
		this.jutegrade = jutegrade;
		this.nominalweight = nominalweight;
		this.quantity = quantity;
		this.rateperquintals = rateperquintals;
	}

	public EntryofSaleModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
