package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcirolemaster", schema = "dbo")
public class RoleMasterModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "refid")
	private int refid;

	@Column(name = "rolename")
	private String rolename;

	@Column(name = "roledesc")
	private String roledesc;

	@Column(name = "isactive")
	private int isactive;

	@Column(name = "createdat")
	private Date createdat;

	public RoleMasterModel() {

	}

	public RoleMasterModel(int refid, String rolename, String roledesc, int isactive, Date createdat) {
		this.refid = refid;
		this.rolename = rolename;
		this.roledesc = roledesc;
		this.isactive = isactive;
		this.createdat = createdat;
	}

	public int getRefid() {
		return refid;
	}

	public void setRefid(int refid) {
		this.refid = refid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoledesc() {
		return roledesc;
	}

	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}

	@Override
	public String toString() {
		return "RoleMasterModel [refid=" + refid + ", rolename=" + rolename + ", roledesc=" + roledesc + ", isactive="
				+ isactive + ", createdat=" + createdat + "]";
	}
}
