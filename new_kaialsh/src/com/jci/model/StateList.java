package com.jci.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_states", schema = "dbo")
public class StateList {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	private String state_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	@Override
	public String toString() {
		return "StateList [id=" + id + ", state_name=" + state_name + "]";
	}

}
