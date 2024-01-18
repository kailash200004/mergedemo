package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcicontractgeneration", schema = "dbo")
public class Contractgeneration {
	@Id
	@Column(name="contract_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int contract_id;
	
	@Column(name = "pcso_Date")
	private String pcso_Date;
	
	@Column(name = "contract_Qty")
	private String contract_Qty;
	
	@Column(name = "contactnumber")
	private String contactnumber;
	
	@Column(name = "contract_date")
	private String contract_date;
	
	@Column(name = "crop_year")
	private String crop_year;
	
	@Column(name = "variety")
	private String variety;
	
	@Column(name = "created_date")
	private String created_date;
	
	@Column(name = "grade1_TD1")
	private double grade1_TD1;
	
	@Column(name = "grade2_TD2_W1")
	private double grade2_TD2_W1;
	
	@Column(name = "grade3_TD3_W2_M1_B1")
	private double grade3_TD3_W2_M1_B1;
	
	@Column(name = "grade4_TD4_W3_M2_B2")
	private double grade4_TD4_W3_M2_B2;
	
	@Column(name = "grade5_TD5_W4_M3_B3")
	private double grade5_TD5_W4_M3_B3;
	
	@Column(name = "grade6_TD6_W5_M4_B4")
	private double grade6_TD6_W5_M4_B4;
	
	@Column(name = "grade7_TD7_W6_M5_B5")
	private double grade7_TD7_W6_M5_B5;
	
	@Column(name = "grade8_TD8_W7_M6_B6")
	private double grade8_TD8_W7_M6_B6;
	
	@Column(name = "grade8_W8")
	private double grade8_W8;
	
	public Contractgeneration() {
		
	}
	public int getContract_id() {
		return contract_id;
	}
	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}
	public String getPcso_Date() {
		return pcso_Date;
	}
	public void setPcso_Date(String pcso_Date) {
		this.pcso_Date = pcso_Date;
	}
	public String getContract_Qty() {
		return contract_Qty;
	}
	public void setContract_Qty(String contract_Qty) {
		this.contract_Qty = contract_Qty;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getContract_date() {
		return contract_date;
	}
	public void setContract_date(String contract_date) {
		this.contract_date = contract_date;
	}
	public String getCrop_year() {
		return crop_year;
	}
	public void setCrop_year(String crop_year) {
		this.crop_year = crop_year;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public double getGrade1_TD1() {
		return grade1_TD1;
	}
	public void setGrade1_TD1(double grade1_TD1) {
		this.grade1_TD1 = grade1_TD1;
	}
	public double getGrade2_TD2_W1() {
		return grade2_TD2_W1;
	}
	public void setGrade2_TD2_W1(double grade2_TD2_W1) {
		this.grade2_TD2_W1 = grade2_TD2_W1;
	}
	public double getGrade3_TD3_W2_M1_B1() {
		return grade3_TD3_W2_M1_B1;
	}
	public void setGrade3_TD3_W2_M1_B1(double grade3_TD3_W2_M1_B1) {
		this.grade3_TD3_W2_M1_B1 = grade3_TD3_W2_M1_B1;
	}
	public double getGrade4_TD4_W3_M2_B2() {
		return grade4_TD4_W3_M2_B2;
	}
	public void setGrade4_TD4_W3_M2_B2(double grade4_TD4_W3_M2_B2) {
		this.grade4_TD4_W3_M2_B2 = grade4_TD4_W3_M2_B2;
	}
	public double getGrade5_TD5_W4_M3_B3() {
		return grade5_TD5_W4_M3_B3;
	}
	public void setGrade5_TD5_W4_M3_B3(double grade5_TD5_W4_M3_B3) {
		this.grade5_TD5_W4_M3_B3 = grade5_TD5_W4_M3_B3;
	}
	public double getGrade6_TD6_W5_M4_B4() {
		return grade6_TD6_W5_M4_B4;
	}
	public void setGrade6_TD6_W5_M4_B4(double grade6_TD6_W5_M4_B4) {
		this.grade6_TD6_W5_M4_B4 = grade6_TD6_W5_M4_B4;
	}
	public double getGrade7_TD7_W6_M5_B5() {
		return grade7_TD7_W6_M5_B5;
	}
	public void setGrade7_TD7_W6_M5_B5(double grade7_TD7_W6_M5_B5) {
		this.grade7_TD7_W6_M5_B5 = grade7_TD7_W6_M5_B5;
	}
	public double getGrade8_TD8_W7_M6_B6() {
		return grade8_TD8_W7_M6_B6;
	}
	public void setGrade8_TD8_W7_M6_B6(double grade8_TD8_W7_M6_B6) {
		this.grade8_TD8_W7_M6_B6 = grade8_TD8_W7_M6_B6;
	}
	public double getGrade8_W8() {
		return grade8_W8;
	}
	public void setGrade8_W8(double grade8_W8) {
		this.grade8_W8 = grade8_W8;
	}
	@Override
	public String toString() {
		return "Contractgeneration [contract_id=" + contract_id + ", pcso_Date=" + pcso_Date + ", contract_Qty="
				+ contract_Qty + ", contactnumber=" + contactnumber + ", contract_date=" + contract_date
				+ ", crop_year=" + crop_year + ", variety=" + variety + ", created_date=" + created_date
				+ ", grade1_TD1=" + grade1_TD1 + ", grade2_TD2_W1=" + grade2_TD2_W1 + ", grade3_TD3_W2_M1_B1="
				+ grade3_TD3_W2_M1_B1 + ", grade4_TD4_W3_M2_B2=" + grade4_TD4_W3_M2_B2 + ", grade5_TD5_W4_M3_B3="
				+ grade5_TD5_W4_M3_B3 + ", grade6_TD6_W5_M4_B4=" + grade6_TD6_W5_M4_B4 + ", grade7_TD7_W6_M5_B5="
				+ grade7_TD7_W6_M5_B5 + ", grade8_TD8_W7_M6_B6=" + grade8_TD8_W7_M6_B6 + ", grade8_W8=" + grade8_W8
				+ "]";
	}
	public Contractgeneration(int contract_id, String pcso_Date, String contract_Qty, String contactnumber,
			String contract_date, String crop_year, String variety, String created_date, double grade1_TD1,
			double grade2_TD2_W1, double grade3_TD3_W2_M1_B1, double grade4_TD4_W3_M2_B2, double grade5_TD5_W4_M3_B3,
			double grade6_TD6_W5_M4_B4, double grade7_TD7_W6_M5_B5, double grade8_TD8_W7_M6_B6, double grade8_W8) {
		super();
		this.contract_id = contract_id;
		this.pcso_Date = pcso_Date;
		this.contract_Qty = contract_Qty;
		this.contactnumber = contactnumber;
		this.contract_date = contract_date;
		this.crop_year = crop_year;
		this.variety = variety;
		this.created_date = created_date;
		this.grade1_TD1 = grade1_TD1;
		this.grade2_TD2_W1 = grade2_TD2_W1;
		this.grade3_TD3_W2_M1_B1 = grade3_TD3_W2_M1_B1;
		this.grade4_TD4_W3_M2_B2 = grade4_TD4_W3_M2_B2;
		this.grade5_TD5_W4_M3_B3 = grade5_TD5_W4_M3_B3;
		this.grade6_TD6_W5_M4_B4 = grade6_TD6_W5_M4_B4;
		this.grade7_TD7_W6_M5_B5 = grade7_TD7_W6_M5_B5;
		this.grade8_TD8_W7_M6_B6 = grade8_TD8_W7_M6_B6;
		this.grade8_W8 = grade8_W8;
	}
	
	


	
	
	
	
}
