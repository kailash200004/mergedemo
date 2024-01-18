package com.jci.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jciuserprivilege", schema = "dbo")
public class UserPriviligeModel {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int privilege_id;
	
	private String role_Id;
	
	private String action_permissions;
	
	private String created_date;

	public int getPrivilege_id() {
		return privilege_id;
	}

	public void setPrivilege_id(int privilege_id) {
		this.privilege_id = privilege_id;
	}

	public String getRole_Id() {
		return role_Id;
	}

	public void setRole_Id(String role_Id) {
		this.role_Id = role_Id;
	}

	public String getAction_permissions() {
		return action_permissions;
	}

	public void setAction_permissions(String action_permissions) {
		this.action_permissions = action_permissions;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "UserPriviligeModel [privilege_id=" + privilege_id + ", role_Id=" + role_Id + ", action_permissions="
				+ action_permissions + ", created_date=" + created_date + "]";
	}

	public UserPriviligeModel(int privilege_id, String role_Id, String action_permissions, String created_date) {
		//super();
		this.privilege_id = privilege_id;
		this.role_Id = role_Id;
		this.action_permissions = action_permissions;
		this.created_date = created_date;
	}

	public UserPriviligeModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
