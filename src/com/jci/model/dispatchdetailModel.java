package com.jci.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity


@Table(name = "jcidispatch_details")
public class dispatchdetailModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Dientry_id")
	private BigInteger Dientry_id ;

	@Column(name = "DI_No")
	private String DI_No;

	@Column(name = "DI_Date")
	private Date DI_Date;

	@Column(name = "Regional_Office")
	private String Regional_Office;

	@Column(name = "Place_of_Shipment")
	private String Place_of_Shipment;

	@Column(name = "Contract_No")
	private String Contract_No;

	@Column(name = "Contract_date")
	private Date Contract_date;

	@Column(name = "Mill_name")
	private String Mill_name;

	@Column(name = "Consignment_note")
	private String Consignment_note;

	@Column(name = "Challan_no", unique = true)
	private String Challan_no;

	@Column(name = "Date_of_shipment")
	private Date Date_of_shipment;

	@Column(name = "Mode_of_shipment")
	private String Mode_of_shipment;

	@Column(name = "Vehicle_no")
	private String Vehicle_no;

	@Column(name = "Driver_name")
	private String Driver_name;

	@Column(name = "License_no")
	private String License_no;

	@Column(name = "Driver_contact")
	private String Driver_contact;

	@Column(name = "Bale_mark")
	private String Bale_mark;

	@Column(name = "Crop_year")
	private String Crop_year;

	@Column(name = "BIN_no")
	private Integer BIN_no;

	@Column(name = "Jute_variety")
	private String Jute_variety;

	@Column(name = "Jute_grade")
	private String Jute_grade;

	@Column(name = "No_of_bales")
	private Integer No_of_bales;

	@Column(name = "Nominal_wt")
	private Double Nominal_wt;

	@Column(name = "Nominal_qty")
	private Double Nominal_qty;

	@Column(name = "Rate")
	private Double Rate;

	@Column(name = "Jute_value")
	private Double Jute_value;

	@Column(name = "Di_status")
	private Integer Di_status;

	@Column(name = "Creation_date")
	private Date Creation_date;

	public BigInteger getDientry_id() {
		return Dientry_id;
	}

	public void setDientry_id(BigInteger dientry_id) {
		Dientry_id = dientry_id;
	}

	public String getDI_No() {
		return DI_No;
	}

	public void setDI_No(String dI_No) {
		DI_No = dI_No;
	}

	public Date getDI_Date() {
		return DI_Date;
	}

	public void setDI_Date(Date dI_Date) {
		DI_Date = dI_Date;
	}

	public String getRegional_Office() {
		return Regional_Office;
	}

	public void setRegional_Office(String regional_Office) {
		Regional_Office = regional_Office;
	}

	public String getPlace_of_Shipment() {
		return Place_of_Shipment;
	}

	public void setPlace_of_Shipment(String place_of_Shipment) {
		Place_of_Shipment = place_of_Shipment;
	}

	public String getContract_No() {
		return Contract_No;
	}

	public void setContract_No(String contract_No) {
		Contract_No = contract_No;
	}

	public Date getContract_date() {
		return Contract_date;
	}

	public void setContract_date(Date contract_date) {
		Contract_date = contract_date;
	}

	public String getMill_name() {
		return Mill_name;
	}

	public void setMill_name(String mill_name) {
		Mill_name = mill_name;
	}

	public String getConsignment_note() {
		return Consignment_note;
	}

	public void setConsignment_note(String consignment_note) {
		Consignment_note = consignment_note;
	}

	public String getChallan_no() {
		return Challan_no;
	}

	public void setChallan_no(String challan_no) {
		Challan_no = challan_no;
	}

	public Date getDate_of_shipment() {
		return Date_of_shipment;
	}

	public void setDate_of_shipment(Date date_of_shipment) {
		Date_of_shipment = date_of_shipment;
	}

	public String getMode_of_shipment() {
		return Mode_of_shipment;
	}

	public void setMode_of_shipment(String mode_of_shipment) {
		Mode_of_shipment = mode_of_shipment;
	}

	public String getVehicle_no() {
		return Vehicle_no;
	}

	public void setVehicle_no(String vehicle_no) {
		Vehicle_no = vehicle_no;
	}

	public String getDriver_name() {
		return Driver_name;
	}

	public void setDriver_name(String driver_name) {
		Driver_name = driver_name;
	}

	public String getLicense_no() {
		return License_no;
	}

	public void setLicense_no(String license_no) {
		License_no = license_no;
	}

	public String getDriver_contact() {
		return Driver_contact;
	}

	public void setDriver_contact(String driver_contact) {
		Driver_contact = driver_contact;
	}

	public String getBale_mark() {
		return Bale_mark;
	}

	public void setBale_mark(String bale_mark) {
		Bale_mark = bale_mark;
	}

	public String getCrop_year() {
		return Crop_year;
	}

	public void setCrop_year(String crop_year) {
		Crop_year = crop_year;
	}

	public Integer getBIN_no() {
		return BIN_no;
	}

	public void setBIN_no(Integer bIN_no) {
		BIN_no = bIN_no;
	}

	public String getJute_variety() {
		return Jute_variety;
	}

	public void setJute_variety(String jute_variety) {
		Jute_variety = jute_variety;
	}

	public String getJute_grade() {
		return Jute_grade;
	}

	public void setJute_grade(String jute_grade) {
		Jute_grade = jute_grade;
	}

	public Integer getNo_of_bales() {
		return No_of_bales;
	}

	public void setNo_of_bales(Integer no_of_bales) {
		No_of_bales = no_of_bales;
	}

	public Double getNominal_wt() {
		return Nominal_wt;
	}

	public void setNominal_wt(Double nominal_wt) {
		Nominal_wt = nominal_wt;
	}

	public Double getNominal_qty() {
		return Nominal_qty;
	}

	public void setNominal_qty(Double nominal_qty) {
		Nominal_qty = nominal_qty;
	}

	public Double getRate() {
		return Rate;
	}

	public void setRate(Double rate) {
		Rate = rate;
	}

	public Double getJute_value() {
		return Jute_value;
	}

	public void setJute_value(Double jute_value) {
		Jute_value = jute_value;
	}

	public Integer getDi_status() {
		return Di_status;
	}

	public void setDi_status(Integer di_status) {
		Di_status = di_status;
	}

	public Date getCreation_date() {
		return Creation_date;
	}

	public void setCreation_date(Date creation_date) {
		Creation_date = creation_date;
	}

	@Override
	public String toString() {
		return "dispatchdetailModel [Dientry_id=" + Dientry_id + ", DI_No=" + DI_No + ", DI_Date=" + DI_Date
				+ ", Regional_Office=" + Regional_Office + ", Place_of_Shipment=" + Place_of_Shipment + ", Contract_No="
				+ Contract_No + ", Contract_date=" + Contract_date + ", Mill_name=" + Mill_name + ", Consignment_note="
				+ Consignment_note + ", Challan_no=" + Challan_no + ", Date_of_shipment=" + Date_of_shipment
				+ ", Mode_of_shipment=" + Mode_of_shipment + ", Vehicle_no=" + Vehicle_no + ", Driver_name="
				+ Driver_name + ", License_no=" + License_no + ", Driver_contact=" + Driver_contact + ", Bale_mark="
				+ Bale_mark + ", Crop_year=" + Crop_year + ", BIN_no=" + BIN_no + ", Jute_variety=" + Jute_variety
				+ ", Jute_grade=" + Jute_grade + ", No_of_bales=" + No_of_bales + ", Nominal_wt=" + Nominal_wt
				+ ", Nominal_qty=" + Nominal_qty + ", Rate=" + Rate + ", Jute_value=" + Jute_value + ", Di_status="
				+ Di_status + ", Creation_date=" + Creation_date + "]";
	}

	public dispatchdetailModel(BigInteger dientry_id, String dI_No, Date dI_Date, String regional_Office,
			String place_of_Shipment, String contract_No, Date contract_date, String mill_name, String consignment_note,
			String challan_no, Date date_of_shipment, String mode_of_shipment, String vehicle_no, String driver_name,
			String license_no, String driver_contact, String bale_mark, String crop_year, Integer bIN_no,
			String jute_variety, String jute_grade, Integer no_of_bales, Double nominal_wt, Double nominal_qty,
			Double rate, Double jute_value, Integer di_status, Date creation_date) {
		super();
		Dientry_id = dientry_id;
		DI_No = dI_No;
		DI_Date = dI_Date;
		Regional_Office = regional_Office;
		Place_of_Shipment = place_of_Shipment;
		Contract_No = contract_No;
		Contract_date = contract_date;
		Mill_name = mill_name;
		Consignment_note = consignment_note;
		Challan_no = challan_no;
		Date_of_shipment = date_of_shipment;
		Mode_of_shipment = mode_of_shipment;
		Vehicle_no = vehicle_no;
		Driver_name = driver_name;
		License_no = license_no;
		Driver_contact = driver_contact;
		Bale_mark = bale_mark;
		Crop_year = crop_year;
		BIN_no = bIN_no;
		Jute_variety = jute_variety;
		Jute_grade = jute_grade;
		No_of_bales = no_of_bales;
		Nominal_wt = nominal_wt;
		Nominal_qty = nominal_qty;
		Rate = rate;
		Jute_value = jute_value;
		Di_status = di_status;
		Creation_date = creation_date;
	}

	public dispatchdetailModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
