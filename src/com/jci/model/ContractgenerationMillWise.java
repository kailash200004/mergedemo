package com.jci.model;

import javax.persistence.*;

@Entity
@Table(name="ContractgenerationMillWise", schema="dbo")

public class ContractgenerationMillWise {
@Id
@Column(name="id")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

@Column(name="full_contract_no")
private String full_contract_no;

@Column(name="contract_qty")
private String contract_qty;

@Column(name="delivery_type")
private String delivery_type;

@Column(name="created_date")
private String created_date;

@Column(name="grade1_TD1")
private double grade1_TD1;

@Column(name="grade2_TD2_W1")
private double grade2_TD2_W1;

@Column(name="grade3_TD3_W2_M1_B1")
private double grade3_TD3_W2_M1_B1;

@Column(name="grade4_TD4_W3_M2_B2")
private double grade4_TD4_W3_M2_B2;

@Column(name="grade5_TD5_W4_M3_B3")
private double grade5_TD5_W4_M3_B3;

@Column(name="grade6_TD6_W5_M4_B4")
private double grade6_TD6_W5_M4_B4;

@Column(name="grade7_TD7_W6_M5_B5")
private double grade7_TD7_W6_M5_B5;

@Column(name="grade8_TD8_W7_M6_B6")
private double grade8_TD8_W7_M6_B6;

@Column(name="grade8_W8")
private double grade8_W8;


public ContractgenerationMillWise() {
	
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getFull_contract_no() {
	return full_contract_no;
}


public void setFull_contract_no(String full_contract_no) {
	this.full_contract_no = full_contract_no;
}


public String getContract_qty() {
	return contract_qty;
}


public void setContract_qty(String contract_qty) {
	this.contract_qty = contract_qty;
}


public String getDelivery_type() {
	return delivery_type;
}


public void setDelivery_type(String delivery_type) {
	this.delivery_type = delivery_type;
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
	return "ContractgenerationMillWise [id=" + id + ", full_contract_no=" + full_contract_no + ", contract_qty="
			+ contract_qty + ", delivery_type=" + delivery_type + ", created_date=" + created_date + ", grade1_TD1="
			+ grade1_TD1 + ", grade2_TD2_W1=" + grade2_TD2_W1 + ", grade3_TD3_W2_M1_B1=" + grade3_TD3_W2_M1_B1
			+ ", grade4_TD4_W3_M2_B2=" + grade4_TD4_W3_M2_B2 + ", grade5_TD5_W4_M3_B3=" + grade5_TD5_W4_M3_B3
			+ ", grade6_TD6_W5_M4_B4=" + grade6_TD6_W5_M4_B4 + ", grade7_TD7_W6_M5_B5=" + grade7_TD7_W6_M5_B5
			+ ", grade8_TD8_W7_M6_B6=" + grade8_TD8_W7_M6_B6 + ", grade8_W8=" + grade8_W8 + "]";
}


}
