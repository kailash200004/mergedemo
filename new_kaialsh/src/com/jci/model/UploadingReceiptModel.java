package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jciuploadreciept", schema = "dbo")
public class UploadingReceiptModel {
	
	@Id
	@Column(name="reciept_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reciept_id;
	
	@Column(name = "dpc_number")
	private String dpc_number;

	@Column(name="jute_variety")
	private String jute_variety;

	@Column(name="jute_grade")
	private String jute_grade;

	@Column(name="actual_weight")
	private String actual_weight;

	@Column(name = "reciept_date")
	private String reciept_date;
	
	public int getReciept_id() {
		return reciept_id;
	}

	public void setReciept_id(int reciept_id) {
		this.reciept_id = reciept_id;
	}

	public String getDpc_number() {
		return dpc_number;
	}

	public void setDpc_number(String dpc_number) {
		this.dpc_number = dpc_number;
	}

	public String getJute_variety() {
		return jute_variety;
	}

	public void setJute_variety(String jute_variety) {
		this.jute_variety = jute_variety;
	}

	public String getJute_grade() {
		return jute_grade;
	}

	public void setJute_grade(String jute_grade) {
		this.jute_grade = jute_grade;
	}

	public String getActual_weight() {
		return actual_weight;
	}

	public void setActual_weight(String actual_weight) {
		this.actual_weight = actual_weight;
	}

	public String getReciept_date() {
		return reciept_date;
	}

	public void setReciept_date(String reciept_date) {
		this.reciept_date = reciept_date;
	}

	public UploadingReceiptModel(int reciept_id, String dpc_number, String jute_variety, String jute_grade,
			String actual_weight, String reciept_date) {
		super();
		this.reciept_id = reciept_id;
		this.dpc_number = dpc_number;
		this.jute_variety = jute_variety;
		this.jute_grade = jute_grade;
		this.actual_weight = actual_weight;
		this.reciept_date = reciept_date;
	}

	public UploadingReceiptModel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UploadingReceiptModel [reciept_id=" + reciept_id + ", dpc_number=" + dpc_number + ", jute_variety="
				+ jute_variety + ", jute_grade=" + jute_grade + ", actual_weight=" + actual_weight + ", reciept_date="
				+ reciept_date + "]";
	}
	
	
	 
	 
}
