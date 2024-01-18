package com.jci.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.jci.service.UserRegistrationService;

@Controller
public class LoginController {

	public static String dpcCode;

	@Autowired
	UserRegistrationService userRegService;

	@RequestMapping("index")
	public ModelAndView login(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("index");
	
		return mv;
	}

	@RequestMapping("login")
	public ModelAndView loginDetails(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	
	  @RequestMapping("dashboardview") 
	  public ModelAndView dashboardview(HttpServletRequest request){ 
		  System.out.println("dashboard"); 
			String username =(String)request.getSession().getAttribute("usrname");
		  ModelAndView mv = new ModelAndView("dashboard");
		  if(username == null) {
          	mv = new ModelAndView("index");
              }
		  return mv; 
		  }
	 

	  @RequestMapping("loginAction")
      public ModelAndView loginDetailsCheck(HttpServletRequest request, RedirectAttributes redirectAttributes, HttpSession session){
            ModelAndView mv = new ModelAndView("index");
            
            try {
                   String usrname =  request.getParameter("email");
                   String password = request.getParameter("password");
                   if(usrname != null && password != null) {
                   String dpcId = request.getParameter("dpcId");
                   String ifExist =  userRegService.checkLogin(usrname, password);
                   String username =(String)request.getSession().getAttribute("usrname");
                     if(ifExist!=null && ifExist.equalsIgnoreCase("mobile")) { 
                           mv.addObject("msg", "<div class=\"alert alert-danger\"><b>Failure !</b>Mobile User Can not Login Here.</div> \r\n");
                     
                     } else if(ifExist == null){
                     
                     mv.addObject("msg", "<div class=\"alert alert-danger\"><b>Failure !</b>Please Enter correct username and password.</div> \r\n"); 
                     }
                   
                     else
                         {

                                int refId = userRegService.getRefId(usrname);
                                int roleId = userRegService.getUserRoleId(refId);
                                String rolename = userRegService.getUserId(refId);
                                String dpcIdd = userRegService.getUserDpc(refId);
                                String region = userRegService.getUserRegion(refId);
                                String dpc_center = userRegService.getdpc_center(dpcIdd);
                                int is_ho = userRegService.getis_ho(usrname);
                                String roletype = userRegService.getroletypr(usrname);
                                String regionId = userRegService.getregionId(usrname);
                                String zoneId = userRegService.getzoneId(usrname);
                                System.out.println("roletype"+roletype+"======regionId"+regionId+"====zoneId"+zoneId);
                                session.setAttribute("regionId", regionId);
                                session.setAttribute("zoneId", zoneId);
                                session.setAttribute("roletype", roletype);
                                session.setAttribute("is_ho", is_ho);
                                session.setAttribute("userId", refId);
                                session.setAttribute("usrname", usrname);
                                session.setAttribute("dpcId", dpcIdd);
                                session.setAttribute("region", region);
                                session.setAttribute("zoneId", zoneId);
                                session.setAttribute("roleId", roleId);
                                session.setAttribute("refId", refId);
                                session.setAttribute("rolename", rolename);
                                session.setAttribute("dpc_center", dpc_center);
                                
                                  mv= new ModelAndView( (View)new RedirectView("dashboardview.obj")); 
                                 
                         }
                         
                   }        
                     

            }catch(Exception e) {
                   System.out.println(e);
            }
            return mv;
      }
}
