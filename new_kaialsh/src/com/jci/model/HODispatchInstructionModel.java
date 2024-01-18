package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "jcihodispatch", schema = "dbo")
public class HODispatchInstructionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hodispatchid")
	private int hodispatchid;
	
	@Column(name = "fullcontractno")
	private String fullcontractno;
	
	@Column(name = "contractdate")
	private Date contractdate;
	
	@Column(name = "cropyear")
	private String cropyear;
	
	@Column(name = "contractquantity")
	private String contractquantity;
	
	@Column(name = "varietygradewisequantity")
	private String varietygradewisequantity;
	
	@Column(name = "regionaloffice")
	private String regionaloffice;
	
	@Column(name = "dateofshipment")
	private Date dateofshipment;
	
	@Column(name = "uniqueno")
	private String uniqueno;
	
	@Column(name = "didate")
	private Date didate;
	
	@Column(name = "jutevariety")
	private String jutevariety;
	
	@Column(name = "quentity")
	private String quentity;
	
	@Column(name = "jutegrade1")
	private String jutegrade1;
	
	@Column(name = "jutegrade2")
	private String jutegrade2;
	
	@Column(name = "jutegrade3")
	private String jutegrade3;
	
	@Column(name = "jutegrade4")
	private String jutegrade4;
	
	@Column(name = "jutegrade5")
	private String jutegrade5;
	
	@Column(name = "jutegrade6")
	private String jutegrade6;
	
	@Column(name = "jutegrade7")
	private String jutegrade7;
	
	@Column(name = "jutegrade8")
	private String jutegrade8;

	public int getHodispatchid() {
		return hodispatchid;
	}

	public void setHodispatchid(int hodispatchid) {
		this.hodispatchid = hodispatchid;
	}

	public String getFullcontractno() {
		return fullcontractno;
	}

	public void setFullcontractno(String fullcontractno) {
		this.fullcontractno = fullcontractno;
	}

	public Date getContractdate() {
		return contractdate;
	}

	public void setContractdate(Date contractdate) {
		this.contractdate = contractdate;
	}

	public String getCropyear() {
		return cropyear;
	}

	public void setCropyear(String cropyear) {
		this.cropyear = cropyear;
	}

	public String getContractquantity() {
		return contractquantity;
	}

	public void setContractquantity(String contractquantity) {
		this.contractquantity = contractquantity;
	}

	public String getVarietygradewisequantity() {
		return varietygradewisequantity;
	}

	public void setVarietygradewisequantity(String varietygradewisequantity) {
		this.varietygradewisequantity = varietygradewisequantity;
	}

	public String getRegionaloffice() {
		return regionaloffice;
	}

	public void setRegionaloffice(String regionaloffice) {
		this.regionaloffice = regionaloffice;
	}

	public Date getDateofshipment() {
		return dateofshipment;
	}

	public void setDateofshipment(Date dateofshipment) {
		this.dateofshipment = dateofshipment;
	}

	public String getUniqueno() {
		return uniqueno;
	}

	public void setUniqueno(String uniqueno) {
		this.uniqueno = uniqueno;
	}

	public Date getDidate() {
		return didate;
	}

	public void setDidate(Date didate) {
		this.didate = didate;
	}

	public String getJutevariety() {
		return jutevariety;
	}

	public void setJutevariety(String jutevariety) {
		this.jutevariety = jutevariety;
	}

	public String getQuentity() {
		return quentity;
	}

	public void setQuentity(String quentity) {
		this.quentity = quentity;
	}

	public String getJutegrade1() {
		return jutegrade1;
	}

	public void setJutegrade1(String jutegrade1) {
		this.jutegrade1 = jutegrade1;
	}

	public String getJutegrade2() {
		return jutegrade2;
	}

	public void setJutegrade2(String jutegrade2) {
		this.jutegrade2 = jutegrade2;
	}

	public String getJutegrade3() {
		return jutegrade3;
	}

	public void setJutegrade3(String jutegrade3) {
		this.jutegrade3 = jutegrade3;
	}

	public String getJutegrade4() {
		return jutegrade4;
	}

	public void setJutegrade4(String jutegrade4) {
		this.jutegrade4 = jutegrade4;
	}

	public String getJutegrade5() {
		return jutegrade5;
	}

	public void setJutegrade5(String jutegrade5) {
		this.jutegrade5 = jutegrade5;
	}

	public String getJutegrade6() {
		return jutegrade6;
	}

	public void setJutegrade6(String jutegrade6) {
		this.jutegrade6 = jutegrade6;
	}

	public String getJutegrade7() {
		return jutegrade7;
	}

	public void setJutegrade7(String jutegrade7) {
		this.jutegrade7 = jutegrade7;
	}

	public String getJutegrade8() {
		return jutegrade8;
	}

	public void setJutegrade8(String jutegrade8) {
		this.jutegrade8 = jutegrade8;
	}

	@Override
	public String toString() {
		return "HODispatchInstructionModel [hodispatchid=" + hodispatchid + ", fullcontractno=" + fullcontractno
				+ ", contractdate=" + contractdate + ", cropyear=" + cropyear + ", contractquantity=" + contractquantity
				+ ", varietygradewisequantity=" + varietygradewisequantity + ", regionaloffice=" + regionaloffice
				+ ", dateofshipment=" + dateofshipment + ", uniqueno=" + uniqueno + ", didate=" + didate
				+ ", jutevariety=" + jutevariety + ", quentity=" + quentity + ", jutegrade1=" + jutegrade1
				+ ", jutegrade2=" + jutegrade2 + ", jutegrade3=" + jutegrade3 + ", jutegrade4=" + jutegrade4
				+ ", jutegrade5=" + jutegrade5 + ", jutegrade6=" + jutegrade6 + ", jutegrade7=" + jutegrade7
				+ ", jutegrade8=" + jutegrade8 + "]";
	}

	public HODispatchInstructionModel(int hodispatchid, String fullcontractno, Date contractdate, String cropyear,
			String contractquantity, String varietygradewisequantity, String regionaloffice, Date dateofshipment,
			String uniqueno, Date didate, String jutevariety, String quentity, String jutegrade1, String jutegrade2,
			String jutegrade3, String jutegrade4, String jutegrade5, String jutegrade6, String jutegrade7,
			String jutegrade8) {
		super();
		this.hodispatchid = hodispatchid;
		this.fullcontractno = fullcontractno;
		this.contractdate = contractdate;
		this.cropyear = cropyear;
		this.contractquantity = contractquantity;
		this.varietygradewisequantity = varietygradewisequantity;
		this.regionaloffice = regionaloffice;
		this.dateofshipment = dateofshipment;
		this.uniqueno = uniqueno;
		this.didate = didate;
		this.jutevariety = jutevariety;
		this.quentity = quentity;
		this.jutegrade1 = jutegrade1;
		this.jutegrade2 = jutegrade2;
		this.jutegrade3 = jutegrade3;
		this.jutegrade4 = jutegrade4;
		this.jutegrade5 = jutegrade5;
		this.jutegrade6 = jutegrade6;
		this.jutegrade7 = jutegrade7;
		this.jutegrade8 = jutegrade8;
	}

	public HODispatchInstructionModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
