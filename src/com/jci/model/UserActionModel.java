
package com.jci.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jciuseraction", schema = "dbo")
public class UserActionModel {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int action_id;
	
	private String action_name;

	private String action_status;

	private String created_date;

	public int getAction_id() {
		return action_id;
	}

	public void setAction_id(int action_id) {
		this.action_id = action_id;
	}

	public String getAction_name() {
		return action_name;
	}

	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	public String getAction_status() {
		return action_status;
	}

	public void setAction_status(String action_status) {
		this.action_status = action_status;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "UserActionModel [action_id=" + action_id + ", action_name=" + action_name + ", action_status="
				+ action_status + ", created_date=" + created_date + "]";
	}

	public UserActionModel(int action_id, String action_name, String action_status, String created_date) {
		//super();
		this.action_id = action_id;
		this.action_name = action_name;
		this.action_status = action_status;
		this.created_date = created_date;
	}

	public UserActionModel() {
		// TODO Auto-generated constructor stub
	}

	
}
