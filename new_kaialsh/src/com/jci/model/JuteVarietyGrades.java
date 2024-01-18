package com.jci.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "jcijutegrades", schema = "dbo")
public class JuteVarietyGrades {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gradeid")
	private int gradeid;

	@Column(name = "comcol")
	private int comcol;


	@Column(name = "gradeone")
	private Date gradeone ;

	@Column(name = "gradetwo")
	private Date gradetwo ;

	@Column(name = "gradethree")
	private Date gradethree ;

	@Column(name = "gradefour")
	private Date gradefour ;

	@Column(name = "gradefive")
	private Date gradefive ;

	@Column(name = "gradesix")
	private Date gradesix ;

	@Column(name = "gradeseven")
	private Date gradeseven ;

	@Column(name = "gradeeight")
	private Date gradeeight ;

	@Column(name = "createddate")
	private Date createddate ;

	public int getGradeid() {
		return gradeid;
	}

	public void setGradeid(int gradeid) {
		this.gradeid = gradeid;
	}

	public int getComcol() {
		return comcol;
	}

	public void setComcol(int comcol) {
		this.comcol = comcol;
	}

	public Date getGradeone() {
		return gradeone;
	}

	public void setGradeone(Date gradeone) {
		this.gradeone = gradeone;
	}

	public Date getGradetwo() {
		return gradetwo;
	}

	public void setGradetwo(Date gradetwo) {
		this.gradetwo = gradetwo;
	}

	public Date getGradethree() {
		return gradethree;
	}

	public void setGradethree(Date gradethree) {
		this.gradethree = gradethree;
	}

	public Date getGradefour() {
		return gradefour;
	}

	public void setGradefour(Date gradefour) {
		this.gradefour = gradefour;
	}

	public Date getGradefive() {
		return gradefive;
	}

	public void setGradefive(Date gradefive) {
		this.gradefive = gradefive;
	}

	public Date getGradesix() {
		return gradesix;
	}

	public void setGradesix(Date gradesix) {
		this.gradesix = gradesix;
	}

	public Date getGradeseven() {
		return gradeseven;
	}

	public void setGradeseven(Date gradeseven) {
		this.gradeseven = gradeseven;
	}

	public Date getGradeeight() {
		return gradeeight;
	}

	public void setGradeeight(Date gradeeight) {
		this.gradeeight = gradeeight;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}


	public JuteVarietyGrades(int gradeid, int comcol, Date gradeone, Date gradetwo, Date gradethree, Date gradefour,
			Date gradefive, Date gradesix, Date gradeseven, Date gradeeight, Date createddate) {
		super();
		this.gradeid = gradeid;
		this.comcol = comcol;
		this.gradeone = gradeone;
		this.gradetwo = gradetwo;
		this.gradethree = gradethree;
		this.gradefour = gradefour;
		this.gradefive = gradefive;
		this.gradesix = gradesix;
		this.gradeseven = gradeseven;
		this.gradeeight = gradeeight;
		this.createddate = createddate;
	}

	public JuteVarietyGrades() {

	}
	@Override
	public String toString() {
		return "JuteVarietyGrades [gradeid=" + gradeid + ", comcol=" + comcol + ", gradeone=" + gradeone + ", gradetwo="
				+ gradetwo + ", gradethree=" + gradethree + ", gradefour=" + gradefour + ", gradefive=" + gradefive
				+ ", gradesix=" + gradesix + ", gradeseven=" + gradeseven + ", gradeeight=" + gradeeight
				+ ", createddate=" + createddate + "]";
	}
}
