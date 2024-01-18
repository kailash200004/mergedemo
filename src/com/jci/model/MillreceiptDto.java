package com.jci.model;

import java.util.Date;

public class MillreceiptDto {
	private int Dientry_id;
	
	private String  Crop_year;
	private String  Jute_variety;
	private String  Bale_mark;
	private String  Vehicle_no;
	Date  Date_of_shipment;
	private String  Challan_no;
	
	
	public int getDientry_id() {
		return Dientry_id;
	}
	public void setDientry_id(int dientry_id) {
		Dientry_id = dientry_id;
	}
	public String getCrop_year() {
		return Crop_year;
	}
	public void setCrop_year(String crop_year) {
		Crop_year = crop_year;
	}
	public String getJute_variety() {
		return Jute_variety;
	}
	public void setJute_variety(String jute_variety) {
		Jute_variety = jute_variety;
	}
	public String getBale_mark() {
		return Bale_mark;
	}
	public void setBale_mark(String bale_mark) {
		Bale_mark = bale_mark;
	}
	public String getVehicle_no() {
		return Vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		Vehicle_no = vehicle_no;
	}
	public Date getDate_of_shipment() {
		return Date_of_shipment;
	}
	public void setDate_of_shipment(Date date_of_shipment) {
		Date_of_shipment = date_of_shipment;
	}
	public String getChallan_no() {
		return Challan_no;
	}
	public void setChallan_no(String challan_no) {
		Challan_no = challan_no;
	}
	@Override
	public String toString() {
		return "MillreceiptDto [Dientry_id=" + Dientry_id + ", Crop_year=" + Crop_year + ", Jute_variety="
				+ Jute_variety + ", Bale_mark=" + Bale_mark + ", Vehicle_no=" + Vehicle_no + ", Date_of_shipment="
				+ Date_of_shipment + ", Challan_no=" + Challan_no + "]";
	}
	
	
	

	
	

}


