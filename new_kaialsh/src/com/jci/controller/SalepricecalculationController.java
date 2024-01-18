package com.jci.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.jci.model.Salepricecalculation;
import com.jci.service.SalepricecalculationService;

@Controller
public class SalepricecalculationController {

	@Autowired
	private SalepricecalculationService salepricecalculationService;

	@RequestMapping("salespricecalculation")
	public ModelAndView salespricecalculation(HttpServletRequest request) {
		String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("salepricecalculation");
		if(username == null) {
	     	mv = new ModelAndView("index");
	         }
		return mv;
	}

	@RequestMapping("savesalespricecalculation")
	public ModelAndView saveSalepriceCalculation(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		 String username =(String)request.getSession().getAttribute("usrname");
		try {

			Salepricecalculation salepricecalculation = new Salepricecalculation();
			String crop_year = request.getParameter("crop_year");
			String center = request.getParameter("center");
			String sale_quantity = request.getParameter("sale_quantity");
			String amount = request.getParameter("amount");
			String jute_variety = request.getParameter("jute_variety");
			String jute_grade = request.getParameter("jute_grade");
			String grade_differential = request.getParameter("grade_differential");
			String garsat_rate = request.getParameter("garsat_rate");
			String base_price = request.getParameter("base_price");
			String bin_number = request.getParameter("bin_number");
			String operation_cost = request.getParameter("operation_cost");
			String Insurance = request.getParameter("Insurance");
			String freight = request.getParameter("freight");
			String provision_from_claim = request.getParameter("provision_from_claim");
			String weight_loss = request.getParameter("weight_loss");
			String marketlevy = request.getParameter("");
			String opportunitycostm_argin = request.getParameter("opportunitycostm_argin");
			String td_five_baseprice = request.getParameter("td_five_baseprice");
			Date currentdate = new Date();
            SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd"); 
            String formattedDate = df.format(currentdate);
            String date1=salepricecalculation.setCreated_date(formattedDate);
			salepricecalculation.setCrop_year(crop_year);
			salepricecalculation.setCenter(center);
			salepricecalculation.setSale_quantity(sale_quantity);
			salepricecalculation.setAmount(amount);
			salepricecalculation.setJute_variety(jute_variety);
			salepricecalculation.setJute_grade(jute_grade);
			salepricecalculation.setGrade_differential(grade_differential);
			salepricecalculation.setGarsat_rate(garsat_rate);
			salepricecalculation.setBase_price(base_price);
			salepricecalculation.setBin_number(bin_number);
			salepricecalculation.setOperation_cost(operation_cost);
			salepricecalculation.setInsurance(Insurance);
			salepricecalculation.setFreight(freight);
			salepricecalculation.setProvision_from_claim(provision_from_claim);
			salepricecalculation.setWeight_loss(weight_loss);
			salepricecalculation.setMarketlevy(marketlevy);
			salepricecalculation.setOpportunitycostm_argin(opportunitycostm_argin);
			salepricecalculation.setTd_five_baseprice(td_five_baseprice);
			this.salepricecalculationService.create(salepricecalculation);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(username == null) {
	     	return new ModelAndView("index");
	         }
		return new ModelAndView(new RedirectView("salespricecalculation.obj"));
	}

	@RequestMapping("salespricecalculationlist")
	public ModelAndView salespricecalculationList(HttpServletRequest request) {
		 String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("salepricecalculationlist");
		List<Salepricecalculation> salepricecalculation = this.salepricecalculationService.getAll();
		mv.addObject("salepricecalculationlist", salepricecalculation);
		if(username == null) {
	     	mv = new ModelAndView("index");
	         }
		return mv;
	}

	@RequestMapping("salespricecalculationedit")
	public ModelAndView salespricecalculationEdit(HttpServletRequest request) {
		 String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("salepricecalculationedit");
		if (request.getParameter("spc_id") != null) {
		final int spc_id = Integer.parseInt(request.getParameter("spc_id"));
		final Salepricecalculation salepricecalculation = this.salepricecalculationService.find(spc_id);
		mv.addObject("salepricecalculation", salepricecalculation);
	}
		if(username == null) {
	     	mv = new ModelAndView("index");
	         }
	return mv;
	
	
	}	
	@RequestMapping("updatesalespricecalculation")
	public ModelAndView updateSalepriceCalculation(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		 String username =(String)request.getSession().getAttribute("usrname");
		try {
			int spc_id = Integer.parseInt(request.getParameter("spc_id"));
			Salepricecalculation salepricecalculation = this.salepricecalculationService.find(spc_id);
			String crop_year = request.getParameter("crop_year");
			String center = request.getParameter("center");
			String sale_quantity = request.getParameter("sale_quantity");
			String amount = request.getParameter("amount");
			String jute_variety = request.getParameter("jute_variety");
			String jute_grade = request.getParameter("jute_grade");
			String grade_differential = request.getParameter("grade_differential");
			String garsat_rate = request.getParameter("garsat_rate");
			String base_price = request.getParameter("base_price");
			String bin_number = request.getParameter("bin_number");
			String operation_cost = request.getParameter("operation_cost");
			String Insurance = request.getParameter("Insurance");
			String freight = request.getParameter("freight");
			String provision_from_claim = request.getParameter("provision_from_claim");
			String weight_loss = request.getParameter("weight_loss");
			String marketlevy = request.getParameter("");
			String opportunitycostm_argin = request.getParameter("opportunitycostm_argin");
			String td_five_baseprice = request.getParameter("td_five_baseprice");
			salepricecalculation.setCrop_year(crop_year);
			salepricecalculation.setCenter(center);
			salepricecalculation.setSale_quantity(sale_quantity);
			salepricecalculation.setAmount(amount);
			salepricecalculation.setJute_variety(jute_variety);
			salepricecalculation.setJute_grade(jute_grade);
			salepricecalculation.setGrade_differential(grade_differential);
			salepricecalculation.setGarsat_rate(garsat_rate);
			salepricecalculation.setBase_price(base_price);
			salepricecalculation.setBin_number(bin_number);
			salepricecalculation.setOperation_cost(operation_cost);
			salepricecalculation.setInsurance(Insurance);
			salepricecalculation.setFreight(freight);
			salepricecalculation.setProvision_from_claim(provision_from_claim);
			salepricecalculation.setWeight_loss(weight_loss);
			salepricecalculation.setMarketlevy(marketlevy);
			salepricecalculation.setOpportunitycostm_argin(opportunitycostm_argin);
			salepricecalculation.setTd_five_baseprice(td_five_baseprice);
			this.salepricecalculationService.update(salepricecalculation);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(username == null) {
	     	return new ModelAndView("index");
	         }
		return new ModelAndView(new RedirectView("salespricecalculationlist.obj"));
	}
	
	@RequestMapping("salespricecalculationdelete")
	public ModelAndView salespricecalculationDelete(HttpServletRequest request ,RedirectAttributes redirectAttributes) {
		 String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("entryderivativepricelist");
		int spc_id = Integer.parseInt(request.getParameter("spc_id"));
		salepricecalculationService.delete(spc_id);
		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> List deleted successfully.</div>\r\n" + "");
		if(username == null) {
	     	return new ModelAndView("index");
	         }
		return new ModelAndView(new RedirectView("salespricecalculationlist.obj"));
	
	}	
}
