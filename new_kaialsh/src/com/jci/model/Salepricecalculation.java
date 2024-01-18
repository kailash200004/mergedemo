package com.jci.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcisalepricecalculation", schema = "dbo")
public class Salepricecalculation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int spc_id;
	private String crop_year;
	private String center;
	private String sale_quantity;
	private String amount;
	private String jute_variety;
	private String jute_grade;
	private String grade_differential;
	private String garsat_rate;
	private String base_price;
	private String bin_number;
	private String operation_cost;
	private String Insurance;
	private String freight;
	private String provision_from_claim;
	private String weight_loss;
	private String marketlevy;
	private String opportunitycostm_argin;
	private String td_five_baseprice;
	private String created_date;

	public Salepricecalculation() {
		
	}


	public Salepricecalculation(int spc_id, String crop_year, String center, String sale_quantity, String amount,
			String jute_variety, String jute_grade, String grade_differential, String garsat_rate, String base_price,
			String bin_number, String operation_cost, String insurance, String freight, String provision_from_claim,
			String weight_loss, String marketlevy, String opportunitycostm_argin, String td_five_baseprice,
			String created_date) {
		super();
		this.spc_id = spc_id;
		this.crop_year = crop_year;
		this.center = center;
		this.sale_quantity = sale_quantity;
		this.amount = amount;
		this.jute_variety = jute_variety;
		this.jute_grade = jute_grade;
		this.grade_differential = grade_differential;
		this.garsat_rate = garsat_rate;
		this.base_price = base_price;
		this.bin_number = bin_number;
		this.operation_cost = operation_cost;
		Insurance = insurance;
		this.freight = freight;
		this.provision_from_claim = provision_from_claim;
		this.weight_loss = weight_loss;
		this.marketlevy = marketlevy;
		this.opportunitycostm_argin = opportunitycostm_argin;
		this.td_five_baseprice = td_five_baseprice;
		this.created_date = created_date;
	}


	public int getSpc_id() {
		return spc_id;
	}

	public void setSpc_id(int spc_id) {
		this.spc_id = spc_id;
	}

	public String getCrop_year() {
		return crop_year;
	}

	public void setCrop_year(String crop_year) {
		this.crop_year = crop_year;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getSale_quantity() {
		return sale_quantity;
	}

	public void setSale_quantity(String sale_quantity) {
		this.sale_quantity = sale_quantity;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getJute_variety() {
		return jute_variety;
	}

	public void setJute_variety(String jute_variety) {
		this.jute_variety = jute_variety;
	}

	public String getJute_grade() {
		return jute_grade;
	}

	public void setJute_grade(String jute_grade) {
		this.jute_grade = jute_grade;
	}

	public String getGrade_differential() {
		return grade_differential;
	}

	public void setGrade_differential(String grade_differential) {
		this.grade_differential = grade_differential;
	}

	public String getGarsat_rate() {
		return garsat_rate;
	}

	public void setGarsat_rate(String garsat_rate) {
		this.garsat_rate = garsat_rate;
	}

	public String getBase_price() {
		return base_price;
	}

	public void setBase_price(String base_price) {
		this.base_price = base_price;
	}

	public String getBin_number() {
		return bin_number;
	}

	public void setBin_number(String bin_number) {
		this.bin_number = bin_number;
	}

	public String getOperation_cost() {
		return operation_cost;
	}

	public void setOperation_cost(String operation_cost) {
		this.operation_cost = operation_cost;
	}

	public String getInsurance() {
		return Insurance;
	}

	public void setInsurance(String insurance) {
		Insurance = insurance;
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

	public String getMarketlevy() {
		return marketlevy;
	}

	public void setMarketlevy(String marketlevy) {
		this.marketlevy = marketlevy;
	}

	public String getOpportunitycostm_argin() {
		return opportunitycostm_argin;
	}

	public void setOpportunitycostm_argin(String opportunitycostm_argin) {
		this.opportunitycostm_argin = opportunitycostm_argin;
	}

	public String getTd_five_baseprice() {
		return td_five_baseprice;
	}

	public void setTd_five_baseprice(String td_five_baseprice) {
		this.td_five_baseprice = td_five_baseprice;
	}

	
	public String getCreated_date() {
		return created_date;
	}


	public String setCreated_date(String created_date) {
		return this.created_date = created_date;
	}


	@Override
	public String toString() {
		return "Salepricecalculation [spc_id=" + spc_id + ", crop_year=" + crop_year + ", center=" + center
				+ ", sale_quantity=" + sale_quantity + ", amount=" + amount + ", jute_variety=" + jute_variety
				+ ", jute_grade=" + jute_grade + ", grade_differential=" + grade_differential + ", garsat_rate="
				+ garsat_rate + ", base_price=" + base_price + ", bin_number=" + bin_number + ", operation_cost="
				+ operation_cost + ", Insurance=" + Insurance + ", freight=" + freight + ", provision_from_claim="
				+ provision_from_claim + ", weight_loss=" + weight_loss + ", marketlevy=" + marketlevy
				+ ", opportunitycostm_argin=" + opportunitycostm_argin + ", td_five_baseprice=" + td_five_baseprice
				+ ", created_date=" + created_date + "]";
	}


}
