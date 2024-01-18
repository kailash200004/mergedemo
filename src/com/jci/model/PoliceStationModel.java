package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[tbl_policeStation]", schema = "dbo")
public class PoliceStationModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "police_station")
	private String police_stationName ;

	@Column(name = "Block_name")
	private String Block_name;

	
	@Column(name = "district_id")
	private String district_id;

	public String getPolice_stationName() {
		return police_stationName;
	}

	public void setPolice_stationName(String police_stationName) {
		this.police_stationName = police_stationName;
	}

	public String getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(String district_id) {
		this.district_id = district_id;
	}

	public String getpolice_stationName() {
		return police_stationName;
	}

	public void setpolice_stationName(String police_stationName) {
		this.police_stationName = police_stationName;
	}

	public String getBlock_name() {
		return Block_name;
	}

	public void setBlock_name(String Block_name) {
		this.Block_name = Block_name;
	}

}
