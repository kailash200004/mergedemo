package com.jci.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jcientryofoperationcost",schema = "dbo")
public class Entryofoperationcost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eooc_id;
	private String crop_year;
	private String date_of_effect;

	private String insurance;
	private String freight;
	private String provision_from_claim;
	private String weight_loss;
	private String market_levy;
	private String margin;
	private String opportunity_cost;
	private String created_date;
	private String operation_cost;
	public Entryofoperationcost() {
		
	
	}
	
	
	
	public String getCreated_date() {
		return created_date;
	}



	public String setCreated_date(String created_date) {
		return this.created_date = created_date;
	}



	public int getEooc_id() {
		return eooc_id;
	}
	public void setEooc_id(int eooc_id) {
		this.eooc_id = eooc_id;
	}
	public String getCrop_year() {
		return crop_year;
	}
	public void setCrop_year(String crop_year) {
		this.crop_year = crop_year;
	}
	public String getDate_of_effect() {
		return date_of_effect;
	}
	public void setDate_of_effect(String date_of_effect) {
		this.date_of_effect = date_of_effect;
	}
	public String getOperation_cost() {
		return operation_cost;
	}
	public void setOperation_cost(String operation_cost) {
		this.operation_cost = operation_cost;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getFreight() {
		return freight;
	}
	public void setFreight(String freight) {
		this.freight = freight;
	}
	public String getProvision_from_claim() {
		return provision_from_claim;
	}
	public void setProvision_from_claim(String provision_from_claim) {
		this.provision_from_claim = provision_from_claim;
	}
	public String getWeight_loss() {
		return weight_loss;
	}
	public void setWeight_loss(String weight_loss) {
		this.weight_loss = weight_loss;
	}
	public String getMarket_levy() {
		return market_levy;
	}
	public void setMarket_levy(String market_levy) {
		this.market_levy = market_levy;
	}
	public String getMargin() {
		return margin;
	}
	public void setMargin(String margin) {
		this.margin = margin;
	}
	public String getOpportunity_cost() {
		return opportunity_cost;
	}
	public void setOpportunity_cost(String opportunity_cost) {
		this.opportunity_cost = opportunity_cost;
	}



	@Override
	public String toString() {
		return "Entryofoperationcost [eooc_id=" + eooc_id + ", crop_year=" + crop_year + ", date_of_effect="
				+ date_of_effect + ", operation_cost=" + operation_cost + ", insurance=" + insurance + ", freight="
				+ freight + ", provision_from_claim=" + provision_from_claim + ", weight_loss=" + weight_loss
				+ ", market_levy=" + market_levy + ", margin=" + margin + ", opportunity_cost=" + opportunity_cost
				+ ", created_date=" + created_date + "]";
	}

	
	
}
