package com.jci.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "jcibalepreparation", schema = "dbo")
public class BalePreparation {

	@Id
	@Column(name="bale_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int baleId;
	
	@Column(name = "packing_date")
	private Date packing_date;

	@Column(name="crop_year")
	private String crop_year;

	@Column(name="bin_no")
	private String bin_no;

	@Column(name="basis")
	private String basis;
	 
	 
	@Column(name="jute_variety")
	private String jute_variety;
	 

	@Column(name="slip_no_from")
	private String slip_no_from;
	 
	@Column(name="slip_no_to")
	private String slip_no_to;
	 
	@Column(name="bale_no")
	private int bale_no;
	 
	@Column(name="created_by")
	private int created_by;
	 
	@Column(name="status")
	private int status;
	 
	@Column(name="creation_date")
	private String creation_date;
	 
	@Column(name="place_of_packing")
	private String place_of_packing;

	@Column(name="jute_grade")
	private  String jute_grade;

	@Transient
	private String region;
	
	
	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public BalePreparation() {
		super();
	}

	
	public int getBaleId() {
		return baleId;
	}

	public void setBaleId(int baleId) {
		this.baleId = baleId;
	}

	public Date getPacking_date() {
		return packing_date;
	}

	public void setPacking_date(Date packing_date) {
		this.packing_date = packing_date;
	}

	public String getCrop_year() {
		return crop_year;
	}

	public void setCrop_year(String crop_year) {
		this.crop_year = crop_year;
	}

	public String getBin_no() {
		return bin_no;
	}

	public void setBin_no(String bin_no) {
		this.bin_no = bin_no;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	public String getJute_variety() {
		return jute_variety;
	}

	public void setJute_variety(String jute_variety) {
		this.jute_variety = jute_variety;
	}

	public String getSlip_no_from() {
		return slip_no_from;
	}

	public void setSlip_no_from(String slip_no_from) {
		this.slip_no_from = slip_no_from;
	}

	public String getSlip_no_to() {
		return slip_no_to;
	}

	public void setSlip_no_to(String slip_no_to) {
		this.slip_no_to = slip_no_to;
	}

	public int getBale_no() {
		return bale_no;
	}

	public void setBale_no(int bale_no) {
		this.bale_no = bale_no;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}

	public String getPlace_of_packing() {
		return place_of_packing;
	}

	public void setPlace_of_packing(String place_of_packing) {
		this.place_of_packing = place_of_packing;
	}

	public String getJute_grade() {
		return jute_grade;
	}

	public void setJute_grade(String jute_grade) {
		this.jute_grade = jute_grade;
	}

	public BalePreparation(int baleId, Date packing_date, String crop_year, String bin_no, String basis,
			String jute_variety, String slip_no_from, String slip_no_to, int bale_no, int created_by, int status,
			String creation_date, String place_of_packing, String jute_grade, String region) {
		super();
		this.baleId = baleId;
		this.packing_date = packing_date;
		this.crop_year = crop_year;
		this.bin_no = bin_no;
		this.basis = basis;
		this.jute_variety = jute_variety;
		this.slip_no_from = slip_no_from;
		this.slip_no_to = slip_no_to;
		this.bale_no = bale_no;
		this.created_by = created_by;
		this.status = status;
		this.creation_date = creation_date;
		this.place_of_packing = place_of_packing;
		this.jute_grade = jute_grade;
		this.region = region;
	}


	@Override
	public String toString() {
		return "BalePreparation [baleId=" + baleId + ", packing_date=" + packing_date + ", crop_year=" + crop_year
				+ ", bin_no=" + bin_no + ", basis=" + basis + ", jute_variety=" + jute_variety + ", slip_no_from="
				+ slip_no_from + ", slip_no_to=" + slip_no_to + ", bale_no=" + bale_no + ", created_by=" + created_by
				+ ", status=" + status + ", creation_date=" + creation_date + ", place_of_packing=" + place_of_packing
				+ ", jute_grade=" + jute_grade + ", region=" + region + "]";
	}


	

}
