package com.jci.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.jci.model.EntryDerivativePrice;
import com.jci.model.StateList;

import com.jci.service.EntryDeryvativePriceService;
import com.jci.service.StateService;

@Controller
public class EntryDerivativeController {

	@Autowired
	private EntryDeryvativePriceService entryDerivativePriceService;

	@Autowired
	StateService stateList;
	

	private static Logger logger = LogManager.getLogger(EntryDerivativeController.class);

	@RequestMapping("entry_derivativeprice")
	public ModelAndView ViewEDPrice(HttpServletRequest request) {
		String username =(String)request.getSession().getAttribute("usrname");
		List<StateList> Liststate = stateList.getAll();
		ModelAndView mv = new ModelAndView("entry_derivativeprice");
		mv.addObject("Liststate", Liststate);
		 if(username == null) {
         	mv = new ModelAndView("index");
             }
		return mv;
	}

	/*
	 * @RequestMapping("saveEDPrice") public ModelAndView saveEDC(HttpServletRequest
	 * request, RedirectAttributes redirectAttributes) {
	 * 
	 * try { EntryDerivativePrice entryDerivativePrice = new EntryDerivativePrice();
	 * String crop_year = request.getParameter("crop_year"); String state =
	 * request.getParameter("state"); String district =
	 * request.getParameter("district"); String delibry_type =
	 * request.getParameter("delibry_type"); String tgr1 =
	 * request.getParameter("tgr1"); String tgr2 = request.getParameter("tgr2");
	 * String tgr3 = request.getParameter("tgr3"); String tgr4 =
	 * request.getParameter("tgr4"); String tgr5 = request.getParameter("tgr5");
	 * String wgr1 = request.getParameter("wgr1"); String wgr2 =
	 * request.getParameter("wgr2"); String wgr3 = request.getParameter("wgr3");
	 * String wgr4 = request.getParameter("wgr4"); String wgr5 =
	 * request.getParameter("wgr5"); String mgr1 = request.getParameter("mgr1");
	 * String mgr2 = request.getParameter("mgr2"); String mgr3 =
	 * request.getParameter("mgr3"); String mgr4 = request.getParameter("mgr4");
	 * String mgr5 = request.getParameter("mgr5"); String mgr6 =
	 * request.getParameter("mgr6"); String bgr1 = request.getParameter("bgr1");
	 * String bgr2 = request.getParameter("bgr2"); String bgr3 =
	 * request.getParameter("bgr3"); String bgr4 = request.getParameter("bgr4");
	 * String bgr5 = request.getParameter("bgr5"); String bgr6 =
	 * request.getParameter("bgr6");
	 * 
	 * //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" + crop_year + "" +
	 * delibry_type + "" + state + "" + district); Date currentdate = new Date();
	 * 
	 * 
	 * SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
	 * 
	 * String formattedDate = df.format(currentdate);
	 * 
	 * String date1=entryDerivativePrice.setCreation_date(formattedDate);
	 * 
	 * entryDerivativePrice.setCrop_year(crop_year);
	 * entryDerivativePrice.setDelibry_type(delibry_type);
	 * entryDerivativePrice.setState(state);
	 * entryDerivativePrice.setDistrict(district);
	 * entryDerivativePrice.setCrop_year(crop_year);
	 * entryDerivativePrice.setDelibry_type(delibry_type);
	 * 
	 * entryDerivativePrice.setTgr1(tgr1); entryDerivativePrice.setTgr2(tgr2);
	 * entryDerivativePrice.setTgr3(tgr3); entryDerivativePrice.setTgr4(tgr4);
	 * entryDerivativePrice.setTgr5(tgr5); entryDerivativePrice.setWgr1(wgr1);
	 * entryDerivativePrice.setWgr2(wgr2); entryDerivativePrice.setWgr3(wgr3);
	 * entryDerivativePrice.setWgr4(wgr4); entryDerivativePrice.setWgr5(wgr5);
	 * entryDerivativePrice.setMgr1(mgr1); entryDerivativePrice.setMgr2(mgr2);
	 * entryDerivativePrice.setMgr3(mgr3); entryDerivativePrice.setMgr4(mgr4);
	 * entryDerivativePrice.setMgr5(mgr5); entryDerivativePrice.setMgr6(mgr6);
	 * entryDerivativePrice.setBgr1(bgr1); entryDerivativePrice.setBgr2(bgr2);
	 * entryDerivativePrice.setBgr3(bgr3); entryDerivativePrice.setBgr4(bgr4);
	 * entryDerivativePrice.setBgr5(bgr5); entryDerivativePrice.setBgr6(bgr6);
	 * 
	 * //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +
	 * entryDerivativePrice);
	 * this.entryDerivativePriceService.create(entryDerivativePrice);
	 * 
	 * redirectAttributes.addFlashAttribute("msg",
	 * "<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"
	 * + ""); } catch (Exception e) { System.out.println(e); } return new
	 * ModelAndView(new RedirectView("entry_derivativeprice.obj")); }
	 */
	
	/*
	 * @RequestMapping(value = { "saveEDPrice" }, method = { RequestMethod.POST })
	 * public ModelAndView saveEDC(final HttpServletRequest request,final
	 * RedirectAttributes redirectAttributes) {
	 * 
	 * int c = 1; try { EntryDerivativePriceModel entryDerivativePrice = new
	 * EntryDerivativePriceModel(); final String created_by =
	 * request.getParameter("created_by"); final String crop_year =
	 * request.getParameter("crop_year"); final String state =
	 * request.getParameter("state"); final String district =
	 * request.getParameter("district"); //
	 * System.out.println("district controller = "+ district); final List<String>
	 * list = (List<String>)this.distric.findByDistrictId(district); //
	 * System.out.println("district list controller = "+ list); final String
	 * delivery_type = request.getParameter("delivery_type"); Date currentdate = new
	 * Date(); SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd"); String
	 * createddate = df.format(currentdate); for(int i=0;i<4;i++) { String tgr1 =
	 * request.getParameter("tgr1"+c); if(tgr1 == "" || tgr1 == null) { tgr1 ="0"; }
	 * String tgr2 = request.getParameter("tgr2"+c); if(tgr2 == "" || tgr2 == null)
	 * { tgr2 ="0"; } String tgr3 = request.getParameter("tgr3"+c); if(tgr3 == "" ||
	 * tgr3 == null) { tgr3 ="0"; } String tgr4 = request.getParameter("tgr4"+c);
	 * if(tgr4 == "" || tgr4 == null) { tgr4 ="0"; } String tgr5 =
	 * request.getParameter("tgr5"+c); if(tgr5 == "" || tgr5 == null) { tgr5 ="0"; }
	 * String tgr6 = request.getParameter("tgr6"+c); if(tgr6 == "" || tgr6 == null)
	 * { tgr6 ="0"; } String jutevariety; //
	 * System.out.println("district::::::::::::::"+district); if(c==1) { jutevariety
	 * = request.getParameter("jute1"); } else { jutevariety =
	 * request.getParameter("jute"+c); }
	 * entryDerivativePrice.setCrop_year(crop_year);
	 * entryDerivativePrice.setState(state);
	 * entryDerivativePrice.setDistrict(String.join(",", list));
	 * entryDerivativePrice.setDelivery_type(delivery_type);
	 * entryDerivativePrice.setCreation_date(createddate);
	 * entryDerivativePrice.setStatus(0);
	 * entryDerivativePrice.setJute_variety(jutevariety);
	 * entryDerivativePrice.setGrade1(Double.parseDouble(tgr1));
	 * entryDerivativePrice.setGrade2(Double.parseDouble(tgr2));
	 * entryDerivativePrice.setGrade3(Double.parseDouble(tgr3));
	 * entryDerivativePrice.setGrade4(Double.parseDouble(tgr4));
	 * entryDerivativePrice.setGrade5(Double.parseDouble(tgr5));
	 * entryDerivativePrice.setGrade6(Double.parseDouble(tgr6));
	 * 
	 * entryDerivativePrice.setCreated_by(created_by);
	 * this.entryDerivativePriceService.create(entryDerivativePrice); c++; }
	 * 
	 * 
	 * //this.entryDerivativePriceService.create(entryDerivativePrice);
	 * 
	 * redirectAttributes.addFlashAttribute("msg",
	 * "<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"
	 * + ""); } catch (Exception e) { System.out.println(e); } return null;//new
	 * ModelAndView(new RedirectView("entry_derivativeprice.obj")); }
	 */

	@RequestMapping("editentryderivativeprice")
	public ModelAndView editEDP(HttpServletRequest request) {
		String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("editentryderivativeprice");
		int der_id = Integer.parseInt(request.getParameter("der_id"));
		EntryDerivativePrice entryDerivativePrice = this.entryDerivativePriceService.findEDPBYId(der_id);
		mv.addObject("derivativePrice", entryDerivativePrice);
		List<StateList> liststate = stateList.getAll();
		mv.addObject("Liststate", liststate);
		 if(username == null) {
	         	mv = new ModelAndView("index");
	             }
		return mv;
	}

	@RequestMapping("updateEDPrice")
	public ModelAndView updateEDC(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String username =(String)request.getSession().getAttribute("usrname");
		try {
			int der_id = Integer.parseInt(request.getParameter("der_id"));
		//	System.out.println("===id model==>>>>>>>>>>>=== " + der_id);
			EntryDerivativePrice entryDerivativePrice = this.entryDerivativePriceService.findEDPBYId(der_id);
			String crop_year = request.getParameter("crop_year");
			String state = request.getParameter("state");
			String district = request.getParameter("district");
			String delivery_type = request.getParameter("delivery_type");
			String grade1 = request.getParameter("grade1");
			String grade2 = request.getParameter("grade2");
			String grade3 = request.getParameter("grade3");
			String grade4 = request.getParameter("grade4");
			String grade5 = request.getParameter("grade5");
			String grade6 = request.getParameter("grade6");
			
			entryDerivativePrice.setDer_id(der_id);
			entryDerivativePrice.setCrop_year(crop_year);
			entryDerivativePrice.setDelivery_type(delivery_type);
			entryDerivativePrice.setState(state);
			entryDerivativePrice.setDistrict(district);
			entryDerivativePrice.setCrop_year(crop_year);
		
			entryDerivativePrice.setGrade1(grade1);
			entryDerivativePrice.setGrade2(grade2);
			entryDerivativePrice.setGrade3(grade3);
			entryDerivativePrice.setGrade4(grade4);
			entryDerivativePrice.setGrade5(grade5);
			entryDerivativePrice.setGrade6(grade6);
			this.entryDerivativePriceService.update(entryDerivativePrice);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		} catch (Exception e) {
			System.out.println(e);
		}
		 if(username == null) {
	         	return new ModelAndView("index");
	             }
		return new ModelAndView(new RedirectView("entryderivativepricelist.jsp.obj"));
	}

	@RequestMapping("entryderivativepricelist")
	public ModelAndView EntryDerivativePrice(HttpServletRequest request) {
		String username =(String)request.getSession().getAttribute("usrname");
		List<EntryDerivativePrice> edp = entryDerivativePriceService.getAllEDP();
		ModelAndView mv = new ModelAndView("entryderivativepricelist");
		mv.addObject("edp", edp);
		 if(username == null) {
	         	mv = new ModelAndView("index");
	             }
		return mv;
	}

	@RequestMapping("entryderivativepriceDelete")
	public ModelAndView entryderivativepriceDelete(HttpServletRequest request, RedirectAttributes redirectAttributes)
			throws ParseException {
		String username =(String)request.getSession().getAttribute("usrname");
		ModelAndView mv = new ModelAndView("entryderivativepricelist");
		int id = Integer.parseInt(request.getParameter("der_id"));
		entryDerivativePriceService.delete(id);
		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> List deleted successfully.</div>\r\n" + "");
		 if(username == null) {
	         	return new ModelAndView("index");
	             }
		return new ModelAndView(new RedirectView("entryderivativepricelist.obj"));

	}

}
