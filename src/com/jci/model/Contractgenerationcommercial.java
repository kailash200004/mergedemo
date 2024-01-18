package com.jci.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcicontractgenerationcommercial",schema = "dbo")
public class Contractgenerationcommercial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cgc_id;
	private String contracttype;
	private String contract_num;
	private String contract_date;
	private String fullPcontactnum;
	private String crop_year;
	private String variety_grade_wise_quantity;
	private String delibrytype;
	private String variety_grade_Wise_sale_price;
	private String locationRegion;
	private String created_date;
	public Contractgenerationcommercial() {
		
	}

	
	
	public Contractgenerationcommercial(int cgc_id, String contracttype, String contract_num, String contract_date,
			String fullPcontactnum, String crop_year, String variety_grade_wise_quantity, String delibrytype,
			String variety_grade_Wise_sale_price, String locationRegion, String created_date) {
		super();
		this.cgc_id = cgc_id;
		this.contracttype = contracttype;
		this.contract_num = contract_num;
		this.contract_date = contract_date;
		this.fullPcontactnum = fullPcontactnum;
		this.crop_year = crop_year;
		this.variety_grade_wise_quantity = variety_grade_wise_quantity;
		this.delibrytype = delibrytype;
		this.variety_grade_Wise_sale_price = variety_grade_Wise_sale_price;
		this.locationRegion = locationRegion;
		this.created_date = created_date;
	}



	public int getCgc_id() {
		return cgc_id;
	}
	public void setCgc_id(int cgc_id) {
		this.cgc_id = cgc_id;
	}
	public String getContracttype() {
		return contracttype;
	}
	public void setContracttype(String contracttype) {
		this.contracttype = contracttype;
	}
	public String getContract_num() {
		return contract_num;
	}
	public void setContract_num(String contract_num) {
		this.contract_num = contract_num;
	}
	public String getContract_date() {
		return contract_date;
	}
	public void setContract_date(String contract_date) {
		this.contract_date = contract_date;
	}
	public String getFullPcontactnum() {
		return fullPcontactnum;
	}
	public void setFullPcontactnum(String fullPcontactnum) {
		this.fullPcontactnum = fullPcontactnum;
	}
	public String getCrop_year() {
		return crop_year;
	}
	public void setCrop_year(String crop_year) {
		this.crop_year = crop_year;
	}
	public String getVariety_grade_wise_quantity() {
		return variety_grade_wise_quantity;
	}
	public void setVariety_grade_wise_quantity(String variety_grade_wise_quantity) {
		this.variety_grade_wise_quantity = variety_grade_wise_quantity;
	}
	public String getDelibrytype() {
		return delibrytype;
	}
	public void setDelibrytype(String delibrytype) {
		this.delibrytype = delibrytype;
	}
	public String getVariety_grade_Wise_sale_price() {
		return variety_grade_Wise_sale_price;
	}
	public void setVariety_grade_Wise_sale_price(String variety_grade_Wise_sale_price) {
		this.variety_grade_Wise_sale_price = variety_grade_Wise_sale_price;
	}
	public String getLocationRegion() {
		return locationRegion;
	}
	public void setLocationRegion(String locationRegion) {
		this.locationRegion = locationRegion;
	}
	public String getCreated_date() {
		return created_date;
	}
	public String setCreated_date(String created_date) {
		return this.created_date = created_date;
	}
	@Override
	public String toString() {
		return "Contractgenerationcommercial [cgc_id=" + cgc_id + ", contracttype=" + contracttype + ", contract_num="
				+ contract_num + ", contract_date=" + contract_date + ", fullPcontactnum=" + fullPcontactnum
				+ ", crop_year=" + crop_year + ", variety_grade_wise_quantity=" + variety_grade_wise_quantity
				+ ", delibrytype=" + delibrytype + ", variety_grade_Wise_sale_price=" + variety_grade_Wise_sale_price
				+ ", locationRegion=" + locationRegion + ", created_date=" + created_date + "]";
	}


	
}
