package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "updated_contract_qty", schema = "dbo")
public class UpdatedContractQtyDTO {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="contract_date")
	private String contract_date;
	
	@Column(name="contract_no")
	private String contract_no;
	
	@Column(name="mill_code")
	private String mill_code;
	
	@Column(name="updated_qty")
	private double updated_qty;
	
	@Column(name="created_by")
	private int created_by;
	
	@Column(name="created_on")
	private String created_on;

	@Column(name="fin_yr")
	private String fin_yr;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContract_date() {
		return contract_date;
	}

	public void setContract_date(String contract_date) {
		this.contract_date = contract_date;
	}

	public String getContract_no() {
		return contract_no;
	}

	public void setContract_no(String contactnumber) {
		this.contract_no = contactnumber;
	}

	public String getMill_code() {
		return mill_code;
	}

	public void setMill_code(String mill_code) {
		this.mill_code = mill_code;
	}

	public double getUpdated_qty() {
		return updated_qty;
	}

	public void setUpdated_qty(double d) {
		this.updated_qty = d;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	public String getFin_yr() {
		return fin_yr;
	}

	public void setFin_yr(String fin_yr) {
		this.fin_yr = fin_yr;
	}


	public UpdatedContractQtyDTO() {
		
	}

	public UpdatedContractQtyDTO(int id, String contract_date, String contract_no, String mill_code, double updated_qty,
			int created_by, String created_on, String fin_yr) {
		super();
		this.id = id;
		this.contract_date = contract_date;
		this.contract_no = contract_no;
		this.mill_code = mill_code;
		this.updated_qty = updated_qty;
		this.created_by = created_by;
		this.created_on = created_on;
		this.fin_yr = fin_yr;
	}

	@Override
	public String toString() {
		return "UpdatedContractQtyDTO [id=" + id + ", contract_date=" + contract_date + ", contract_no=" + contract_no
				+ ", mill_code=" + mill_code + ", updated_qty=" + updated_qty + ", created_by=" + created_by
				+ ", created_on=" + created_on + ", fin_yr=" + fin_yr + "]";
	}
	
}
