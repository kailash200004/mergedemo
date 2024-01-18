package com.jci.controller;

import java.text.ParseException;
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

import com.jci.model.Entryofoperationcost;
import com.jci.service.EntryofoperationcostService;

@Controller
public class EntryofoperationcostController {

	@Autowired
	EntryofoperationcostService entryofoperationcostService;

	@RequestMapping("entryofoperationcost")
	public ModelAndView entryofoperationcost(HttpServletRequest request) {
		String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("entryofoperationcost");
		 if(username == null) {
         	mv = new ModelAndView("index");
             }
		return mv;
	}	

	@RequestMapping("saveentryofoperationcost")
	public ModelAndView saveentryofoperationcost(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String username =(String)request.getSession().getAttribute("usrname");
		try {
			Entryofoperationcost entryofoperationcost = new Entryofoperationcost();
			String crop_year = request.getParameter("crop_year");
			String date_of_effect = request.getParameter("date_of_effect");
			String operation_cost = request.getParameter("operation_cost");
			String insurance = request.getParameter("insurance");
			String freight = request.getParameter("freight");
			String provision_from_claim = request.getParameter("provision_from_claim");
			String weight_loss = request.getParameter("weight_loss");
			String market_levy = request.getParameter("market_levy");
			String margin = request.getParameter("margin");
			String opportunity_cost = request.getParameter("opportunity_cost");
			Date currentdate = new Date();
            SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd"); 
            String formattedDate = df.format(currentdate);
            String date1=entryofoperationcost.setCreated_date(formattedDate);
			entryofoperationcost.setCrop_year(crop_year);
			entryofoperationcost.setDate_of_effect(date_of_effect);
			entryofoperationcost.setOperation_cost(operation_cost);
			entryofoperationcost.setInsurance(insurance);
			entryofoperationcost.setFreight(freight);
			entryofoperationcost.setProvision_from_claim(provision_from_claim);
			entryofoperationcost.setWeight_loss(weight_loss);
			entryofoperationcost.setMarket_levy(market_levy);
			entryofoperationcost.setMargin(margin);
			entryofoperationcost.setOpportunity_cost(opportunity_cost);
			this.entryofoperationcostService.create(entryofoperationcost);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		} catch (Exception e) {
			System.out.println(e);
		}
		 if(username == null) {
         	return new ModelAndView("index");
             }
		return new ModelAndView(new RedirectView("entryofoperationcost.jsp.obj"));
	}

	@RequestMapping("editentryofoperationcost")
	public ModelAndView editentryofoperationcost(HttpServletRequest request) {
		String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("editentryofoperationcost");
		int eooc_id = Integer.parseInt(request.getParameter("eooc_id"));

		Entryofoperationcost entryofoperationcost = this.entryofoperationcostService.findEDPBYId(eooc_id);

		mv.addObject("entryofoperationcost", entryofoperationcost);
		List<Entryofoperationcost> entryofoperationcostlist = entryofoperationcostService.getAll();
		mv.addObject("entryofoperationcostlist", entryofoperationcostlist);
		 if(username == null) {
         	mv = new ModelAndView("index");
             }
		return mv;
	}

	@RequestMapping("updateentryofoperationcost")
	public ModelAndView updateentryofoperationcost(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String username =(String)request.getSession().getAttribute("usrname");
		try {
			int eooc_id = Integer.parseInt(request.getParameter("eooc_id"));
			Entryofoperationcost entryofoperationcost = this.entryofoperationcostService.findEDPBYId(eooc_id);
			String crop_year = request.getParameter("crop_year");
			String date_of_effect = request.getParameter("date_of_effect");
			String operation_cost = request.getParameter("operation_cost");
			String insurance = request.getParameter("insurance");
			String freight = request.getParameter("freight");
			String provision_from_claim = request.getParameter("provision_from_claim");
			String weight_loss = request.getParameter("weight_loss");
			String market_levy = request.getParameter("market_levy");
			String margin = request.getParameter("margin");
			String opportunity_cost = request.getParameter("opportunity_cost");
			entryofoperationcost.setCrop_year(crop_year);
			entryofoperationcost.setDate_of_effect(date_of_effect);
			entryofoperationcost.setOperation_cost(operation_cost);
			entryofoperationcost.setInsurance(insurance);
			entryofoperationcost.setFreight(freight);
			entryofoperationcost.setProvision_from_claim(provision_from_claim);
			entryofoperationcost.setWeight_loss(weight_loss);
			entryofoperationcost.setMarket_levy(market_levy);
			entryofoperationcost.setMargin(margin);
			entryofoperationcost.setOpportunity_cost(opportunity_cost);
			this.entryofoperationcostService.update(entryofoperationcost);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		} catch (Exception e) {
			System.out.println(e);
		}
		 if(username == null) {
         	return new ModelAndView("index");
             }
		return new ModelAndView(new RedirectView("entryofoperationcostlist.jsp.obj"));
	}

	@RequestMapping("entryofoperationcostlist")
	public ModelAndView entryofoperationcostgetall(HttpServletRequest request) {
		String username =(String)request.getSession().getAttribute("usrname");
		List<Entryofoperationcost> entryofoperationcost = entryofoperationcostService.getAll();
		ModelAndView mv = new ModelAndView("entryofoperationcostlist");
		mv.addObject("entryofoperationcost", entryofoperationcost);
		 if(username == null) {
         	mv = new ModelAndView("index");
             }
		return mv;
	}

	@RequestMapping("entryofoperationcostDelete")
	public ModelAndView entryofoperationcostDelete(HttpServletRequest request, RedirectAttributes redirectAttributes)
			throws ParseException {
		String username =(String)request.getSession().getAttribute("usrname");
		int eooc_id = Integer.parseInt(request.getParameter("eooc_id"));
		this.entryofoperationcostService.delete(eooc_id);
		redirectAttributes.addFlashAttribute("msg",	"<div class=\"alert alert-success\"><b>Success !</b> List deleted successfully.</div>\r\n" + "");
		 if(username == null) {
         	return new ModelAndView("index");
             }
		return new ModelAndView(new RedirectView("entryofoperationcostlist.obj"));

	}

}
