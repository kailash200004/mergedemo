package com.jci.controller;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.CacheControl;

import org.apache.commons.io.IOUtils;
import org.apache.http.impl.bootstrap.ServerBootstrap;
import org.apache.poi.ss.formula.functions.MinaMaxa;
import org.apache.poi.util.SystemOutLogger;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.layout.element.Paragraph;
import com.jci.model.EntryPaymentDetailsModel;
import com.jci.model.EntryofpcsoModel;
import com.jci.model.FinancialConcurenceModel;
import com.jci.model.GenerationOfBillSupplyModel;
import com.jci.model.GenrationDEmandDto;
import com.jci.model.GenrationDemandNoteModel;
import com.jci.model.MillRecieptModel;
import com.jci.model.CaptchaFormModel;
import com.jci.model.CashDocumentModel;
import com.jci.model.ConfirmationClaimSettlementModel;
import com.jci.model.MillreceiptDto;
import com.jci.model.PcsoDateModel;
import com.jci.model.SubmissionOfQuoteModel;
import com.jci.service.Impl_phase2.EmailSender;
import com.jci.service_phase2.ConfirmationofClaimSettlementService;
import com.jci.service_phase2.FinancialConcurenceService;
import com.jci.service_phase2.GenerationofBillService;
import com.jci.service_phase2.GenratedDemandNoteService;
import com.jci.service_phase2.GenrationCashDocumentService;
import com.jci.service_phase2.MillRecieptService;
import com.jci.service_phase2.PaymentDetailService;
import com.jci.service_phase2.PcsoentryService;
import com.jci.service_phase2.SubmissionOfQuoteService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfWriter;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;









@Controller
public class Controller_V {
	
	 private final PdfGenerator_K pdfGenerator;

	    @Autowired
	    public Controller_V(PdfGenerator_K pdfGenerator) {
	        this.pdfGenerator = pdfGenerator;}
	

	@Autowired
	PcsoentryService pcsoentryservice;
	
	@Autowired
	MillRecieptService millRecieptService;
	
	@Autowired
	FinancialConcurenceService FiannacialConcurenceService;
	
	@Autowired
	 private PaymentDetailService paymentDetailService;
	
	@Autowired
	FinancialConcurenceService financialConcurenceservice;
	
	@Autowired
	GenratedDemandNoteService genratedDemandNoteService;
	
	
	@Autowired
	SubmissionOfQuoteService submissionOfQuoteService;
	
	@Autowired
	GenrationCashDocumentService genrationCashDocumentService;
	
	@Autowired
	ConfirmationofClaimSettlementService confirmationofClaimSettlementService;
	
	@Autowired
	GenerationofBillService generationofBillService;
	
	
	  @RequestMapping("entryofpcso")
	    public ModelAndView EntryofpcsoModel(HttpServletRequest request) {
		  String username =(String)request.getSession().getAttribute("usrname");
	          ModelAndView mv = new ModelAndView("entryofpcso");
	          final List<EntryofpcsoModel> allentryofpcsolist = (List<EntryofpcsoModel>)this.pcsoentryservice.getAlldata();
	          mv.addObject("entryofpcsolist", (Object)allentryofpcsolist);
	          if(username == null) {
			     	mv = new ModelAndView("index");
			         }
	          return mv;
	    }
	  
	  
	  @RequestMapping("entryofpcsosave")
	    public ModelAndView saveUserMid(HttpServletRequest request, RedirectAttributes redirectAttributes) {
	         ModelAndView mv= new ModelAndView("entryofpcsosave");
	         String username =(String)request.getSession().getAttribute("usrname");
	          try {
	            	List<EntryofpcsoModel> ll = new ArrayList<>();
	                int c = 0;
	                int count = Integer.valueOf(request.getParameter("count"));	                
	               String referenceno = request.getParameter("referenceno");
	               String referencedate = request.getParameter("referencedate");
	               String pcsodate = request.getParameter("pcsodate");
	               for(int i = 0; i<count; i++)
	                {
	               EntryofpcsoModel entryofpcso = new EntryofpcsoModel();
	               String millcode = request.getParameter("millcode"+c);
	               String millname = request.getParameter("millname"+c);
	               String tallocation = request.getParameter("totalallocation"+c);
	               entryofpcso.setReference_no(referenceno);
	               entryofpcso.setReference_date(referencedate);
	               entryofpcso.setPcso_date(pcsodate);
	               		if(tallocation != "" && tallocation != null )
	                       {
	                              entryofpcso.setMill_code(millcode);
	                              entryofpcso.setMill_name(millname);
	                              entryofpcso.setTotal_allocation(tallocation);	                            	                           
	                              ll.add(entryofpcso);
	                       }
	                       c++;
	                }
	               mv.addObject("entryofpcso", (Object)ll);
	               mv.addObject("referencedate", (Object)referencedate);
	               mv.addObject("pcsodate", (Object)pcsodate);

	          } catch (Exception e) {
	               System.out.println(e);
	          }
	          if(username == null) {
			     	mv = new ModelAndView("index");
			         }
	          return mv;
	    }

	  
	  @RequestMapping("saveentryofpcsodata")
	    public ModelAndView entryofpcsosave(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		  String username =(String)request.getSession().getAttribute("usrname");
        try {
      	
      	   int c = 0;
      	   int count = Integer.valueOf(request.getParameter("count"));
      	   Date date = new Date();
             String referenceno = request.getParameter("refno");
             String referencedate = request.getParameter("refdate");
             String pcsodate = request.getParameter("pcsodate");
             double sumoftotalallocation = Double.parseDouble(request.getParameter("sumoftotalallocation"));
             for(int i = 0; i<count; i++)
      	   {
          	   EntryofpcsoModel entryofpcso = new EntryofpcsoModel();
      		   String millcode = request.getParameter("millcode"+c);
      		   String millname = request.getParameter("millname"+c);
      		   String tallocation = request.getParameter("totalallocation"+c);
      		   entryofpcso.setReference_no(referenceno);
                 SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
                // Date refdate = formatter1.parse(referencedate);
                 entryofpcso.setReference_date(referencedate);
                // Date pcsodt = formatter1.parse(pcsodate);
                 entryofpcso.setPcso_date(pcsodate);
                 String createddate = formatter1.format(date);
                 entryofpcso.setCreated_date(createddate);
      		   entryofpcso.setMill_code(millcode);
      		   entryofpcso.setMill_name(millname);
      		   entryofpcso.setTotal_allocation(tallocation);
      		   entryofpcso.setMillwise_contract(0);
      		   entryofpcso.setPcsowise_contract(0);
      		   entryofpcso.setSumof_totalallocation(sumoftotalallocation);
      		   pcsoentryservice.create(entryofpcso);
      		   c++;
      	   }
				  redirectAttributes.addFlashAttribute("msg",
				  "<div class=\"alert alert-success\"><b>Success !</b> Record created successfully.</div>\r\n"
				  + "");
				 
             }
        catch (Exception e)
        {
             System.out.println(e);
             e.printStackTrace();
        }
        if(username == null) {
		     	return new ModelAndView("index");
		         }
        return new ModelAndView(new RedirectView("entryofpcso.obj"));
  }

	  
	  @RequestMapping("pcsolist") 
	  public ModelAndView pcsolist(HttpServletRequest request) { 
		  String username =(String)request.getSession().getAttribute("usrname");
		  ModelAndView mv = new ModelAndView("PCSO_List");
	  List<Date> pcso = pcsoentryservice.getAll(); 
	  mv.addObject("pcsolist",pcso); 
	  if(username == null) {
	     	mv = new ModelAndView("index");
	         }
	  return mv; 
	  }
	 
	  @RequestMapping("contractgenerationPCSOWise")
		public ModelAndView contractgeneration(HttpServletRequest req) {
			  String username =(String)req.getSession().getAttribute("usrname");
			ModelAndView mv = new ModelAndView("contractgeneration");
			List<Date> pcso= pcsoentryservice.getAll(); 
			mv.addObject("pcso", (Object)pcso);
			 if(username == null) {
	         	mv = new ModelAndView("index");
	             }
			return mv;
		}
	  @ResponseBody
		 @RequestMapping(value = "pcsoDates" , method =  RequestMethod.GET )
	     public List<Date> pcsoDates(final HttpServletRequest request){
			 List<Date> pcso= pcsoentryservice.getAll(); 
			 return pcso;
		 }
	  
	  @ResponseBody
		 @RequestMapping(value = "pcso_details" , method =  RequestMethod.GET )
	     public String pcso_details(final HttpServletRequest request){
			  
			 String outerArray = request.getParameter("pcso1");
			 outerArray = outerArray.replaceAll("/", "'").replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "'");
			final String[] bpArr = outerArray.split(",");
				final List<String> list = Arrays.asList(bpArr);
			 List<PcsoDateModel> pcso= pcsoentryservice.pcso_details(outerArray);
			Gson gson= new Gson();
			 return gson.toJson(pcso);
		 }
       //kailash Controller
	 
	@RequestMapping("EntryofPaymentDetails")
		public ModelAndView EntryofpiModelDetails(HttpServletRequest request)
		{	String username =(String)request.getSession().getAttribute("usrname");
			ModelAndView mv = new ModelAndView("EntryofPaymentDetails");
			if(username == null) {
		     	mv = new ModelAndView("index");
		         }
               List<Object>getcontractList1 =  this.paymentDetailService.ContractNo();
			
			mv.addObject("getcontractList1", getcontractList1);
			return mv;
			
		}
		
		@RequestMapping("EntryofMillreceipt")
		public ModelAndView EntryofMillreceipt(HttpServletRequest request)
		
		{	String username =(String)request.getSession().getAttribute("usrname");
			ModelAndView mv = new ModelAndView("EntryofMillReciept");
			MillRecieptModel millRecieptModel = new MillRecieptModel();
			if(username == null) {
		     	mv = new ModelAndView("index");
		         }
		
			//List<Object[]>getdataList =  this.millRecieptService.fetchdata();
			List<Object>getdataList1 =  this.millRecieptService.fetchHODINO();
			
			mv.addObject("getdataList1", getdataList1);
			return mv;
		}
	      

		   //kailash Code
		@ResponseBody
		@RequestMapping(value = "fetchingdata", method = RequestMethod.GET)
		public String hodinofetch(@RequestParam("contractno") String contractno) {
			
			MillRecieptModel millRecieptModelt1 = millRecieptService.fetchdata(contractno);
		    System.err.println("resultList++++++++++"+millRecieptModelt1);
		    Gson gson = new Gson();
		    String resultString =  new Gson().toJson(millRecieptModelt1);
		    return resultString;//gson.toJson((Object)millRecieptModelt1);
	
			}
		
		@ResponseBody
		@RequestMapping(value = "fetchingdatabill", method = RequestMethod.GET)
		public String hodinofetchbill(@RequestParam("contractno") String contractno) {
			
			 List<Object[]>millRecieptModelt1 = generationofBillService.contarctnoformaster(contractno);
		    System.err.println("resultList++++++++++"+millRecieptModelt1);
		    Gson gson = new Gson();
		    String resultString =  new Gson().toJson(millRecieptModelt1);
		    return resultString;//gson.toJson((Object)millRecieptModelt1);
	
			}
		
		

		
		
		@ResponseBody
		@RequestMapping(value = "fetchingdata1", method = RequestMethod.GET)
		public String hodinofetch1(@RequestParam("contractno") String contractno1) {
			
		   List<Object[]>BI_no = generationofBillService.contarctno(contractno1);
		    System.err.println("resultList++++++++++"+BI_no);
		    Gson gson = new Gson();
		    String resultString =  new Gson().toJson(BI_no);
		    return resultString;//gson.toJson((Object)millRecieptModelt1);
		}
		
	
		
		
		
//		@ResponseBody
//		@RequestMapping(value = "fetchingdatamillrecept", method = RequestMethod.GET)
//		public String fetchingdatamillrecept(@RequestParam("contractno") String contractno) {
//			List<Object>getcontractddownlist = confirmationofClaimSettlementService.fetchdataofclaim(contractno);
//		    
//		    Gson gson = new Gson();
//		    String resultString =  new Gson().toJson(getcontractddownlist);
//		    return resultString;//gson.toJson((Object)millRecieptModelt1);
//		}
		
		@RequestMapping("EntryofFinancialConcurence")
		public ModelAndView EntryofFinancialConcurence(HttpServletRequest request)
		{	String username =(String)request.getSession().getAttribute("usrname");
//		String con_no =entryPaymentDetailsModel.getContractno();
			ModelAndView mv = new ModelAndView("EntryofFinancialConcurence");
			if(username == null) {
		     	mv = new ModelAndView("index");
		         }
			
			return mv;
		}
		
		@RequestMapping("EntryGenerationCashagainstDispatch")
		public ModelAndView EntryofGenerationDispatch(HttpServletRequest request)
		{	String username =(String)request.getSession().getAttribute("usrname");
		
			ModelAndView mv = new ModelAndView("EntryGenerationCashagainstDispatch");
			if(username == null) {
		     	mv = new ModelAndView("index");
		         }
			String  bos_no = this.genrationCashDocumentService.fetchBos_No();
			return mv;
		}
		
		
		@RequestMapping("EntrySubmissionofQuote")
		public ModelAndView EntrySubmissionofQuote(HttpServletRequest request)
		{	String username =(String)request.getSession().getAttribute("usrname");
		
			ModelAndView mv = new ModelAndView("SubmissionOfQuote");
			if(username == null) {
		     	mv = new ModelAndView("index");
		         }
			
			return mv;
		}
		@RequestMapping("entryofConfirationSettelment")
		public ModelAndView entryofConfirationSettelment(HttpServletRequest request)
		{	
			String username =(String)request.getSession().getAttribute("usrname");
		
			ModelAndView mv = new ModelAndView("ConfirmationofClaimSettlement");
			if(username == null) {
		     	mv = new ModelAndView("index");
		         }
			 List<Object>getSettlementidlist =  this.confirmationofClaimSettlementService.SettlementId();
			
				
			 mv.addObject("getSettlementidlist", getSettlementidlist); 
			return mv;
		}
		
		
		@RequestMapping("EntryofGenerationBillsupply")
		public ModelAndView EntryofGenrationBillsupply(HttpServletRequest request) {
			String username = (String) request.getSession().getAttribute("usrname");

			ModelAndView mv = new ModelAndView("EntryGenerationBill");
			if (username == null) {
				mv = new ModelAndView("index");
			}
       	List<Object[]> getChallanlist =(List<Object[]>) this.generationofBillService.ChallanNo();
			mv.addObject("getChallanlist", getChallanlist);
			
			
			 int allIndiaSerialNo = 1;
			 int stateSerialNo = 1;
			 String billOfSupplyNo = generateBillOfSupplyNumber(request.getSession(),allIndiaSerialNo,stateSerialNo);
			    mv.addObject("billOfSupplyNo", billOfSupplyNo);

			return mv;
			
			
		}
		private String generateBillOfSupplyNumber(HttpSession session, int allIndiaSerialNo, int stateSerialNo) {
	        String prefix = "B";

	        int currentYear = Calendar.getInstance().get(Calendar.YEAR) % 100;
	        String yearCode = String.format("%02d", currentYear);

	       
	        if (session.getAttribute("allIndiaSerialNo") != null) {
	            allIndiaSerialNo = (int) session.getAttribute("allIndiaSerialNo");
	            allIndiaSerialNo++;
	        }
	        session.setAttribute("allIndiaSerialNo", allIndiaSerialNo);

	        String formattedAllIndiaSerialNo = String.format("%06d", allIndiaSerialNo);

	        String stateGSTCode = "19";

	     
	        if (session.getAttribute("stateSerialNo") != null) {
	            stateSerialNo = (int) session.getAttribute("stateSerialNo");
	            stateSerialNo++;
	        }
	        session.setAttribute("stateSerialNo", stateSerialNo);

	        String formattedStateSerialNo = String.format("%05d", stateSerialNo);

	        String  laString= prefix + yearCode + formattedAllIndiaSerialNo + stateGSTCode + formattedStateSerialNo;
	       String status=this.generationofBillService.billofsupplyno(laString);
	       if ("1".equals(status)) {
	          
	           return generateBillOfSupplyNumber(session, allIndiaSerialNo + 1, stateSerialNo + 1);
	       } else {
	           
	           return laString;
	       }
	    }
		
		
		
		
		
		@RequestMapping("EntryofGenrationDeamandNote")
		public ModelAndView EntryofGenrationDemand(HttpServletRequest request)
		{	String username =(String)request.getSession().getAttribute("usrname");
		
			ModelAndView mv = new ModelAndView("EntryofGenratedDemandNote");
			if(username == null) {
		     	mv = new ModelAndView("index");
		         }
			 List<Object>getdataList1 =  this.genratedDemandNoteService.fetchcon_no();
			
			 int lastSerialNumber=1640;
			 String demandNoteNumber = generateDemandNoteNumber(request.getSession(),lastSerialNumber);
			    mv.addObject("demandNoteNumber", demandNoteNumber);

			 //String demandNoteNumber = generateDemandNoteNumber();
		        mv.addObject("demandNoteNumber", demandNoteNumber); 
		     //GenrationDEmandDto cotract_No =  this.genratedDemandNoteService.fetchContract_no();
           
//			System.out.println("cotract_No>>>>>>>>>>>>>"+cotract_No);
//			Date date =cotract_No.getContract_date();
//			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//			String formattedDate = dateFormat.format(date);
         	mv.addObject("getdataList1", getdataList1);
         	// mv.addObject("demandNoteNumber", demandNoteNumber);
//			mv.addObject("cotract_No", cotract_No);
//			mv.addObject("formattedDate", formattedDate);
			return mv;
		}
//		
		//private String generateDemandNoteNumber()
		private String generateDemandNoteNumber(HttpSession session,int lastSerialNumber){
		    Date currentDate = new Date();
		    SimpleDateFormat yearFormat = new SimpleDateFormat("yy");
		    String fiscalYear = yearFormat.format(currentDate);

//		    int lastSerialNumber = getLastSerialNumberFromDatabase();
		    int newSerialNumber = lastSerialNumber + 1;

		    


		     String  stringdemand= "D" + fiscalYear + String.format("%06d", newSerialNumber);
		     String status=this.genratedDemandNoteService.demandnono(stringdemand);
		       if ("1".equals(status)) {
		          
		           return generateDemandNoteNumber(session,newSerialNumber);
		       } else {
		           
		           return stringdemand;
		       }
		     
		}

	

		

		
	       @ResponseBody
	       @RequestMapping(value = "gradecomposition", method = RequestMethod.GET)
	       public String GradeComposition(@RequestParam("ContractNo") String ContractNo)
	       {
	       List<Object>gradecmposition=confirmationofClaimSettlementService.gradecomposition(ContractNo);
                Gson gson = new Gson();
	             String jsonResponse = gson.toJson(gradecmposition);
	             return jsonResponse;
	             
	             
	       
	       }


		
		@ResponseBody
		@RequestMapping(value = "fetchingdatamillrecept", method = RequestMethod.GET)
		public String fetchingdatatocontractnoji(@RequestParam("contractno") String contractno) {
			List<Object[]>getcontractddownlist = confirmationofClaimSettlementService.fetchdataofclaim(contractno);
		    System.err.println("resultList++++++++++"+getcontractddownlist);
		    Gson gson = new Gson();
		    String resultString =  new Gson().toJson(getcontractddownlist);
		    return resultString;
		}
		@ResponseBody
		@RequestMapping(value = "fetchingdatatocontractno", method = RequestMethod.GET)
		public String fetchingdatatocontractnoq(@RequestParam("contractno") String contractno) {
			GenrationDEmandDto	  getcontractddownlist = genratedDemandNoteService.fetchContract_no(contractno);
		    System.err.println("resultList++++++++++"+getcontractddownlist);
		    Gson gson = new Gson();
		    String resultString =  new Gson().toJson(getcontractddownlist);
		    return resultString;
		}
		
		
		
		@ResponseBody
		@RequestMapping(value = "fetchingdatanominactionclaim", method = RequestMethod.GET)
		public String fetchingdatanominactionclaim(@RequestParam("contractno") int  contractno) {
		    List<Object[]>getsettlementlist = confirmationofClaimSettlementService.fetchdatasttlement(contractno);
		    System.err.println("resultList++++++++++"+getsettlementlist);
		    Gson gson = new Gson();
		    String resultString =  new Gson().toJson(getsettlementlist);
		    return resultString;
		}
		
		
		@ResponseBody
		@RequestMapping(value = "fetchingdataforbill", method = RequestMethod.GET)
		public String fetchingdatanominactionclaimforbill(@RequestParam("contractno") String  contractno) {
			List<Object[]>millRecieptModelt1 = generationofBillService.contarctnoformaster(contractno);
		    System.err.println("resultList++++++++++"+millRecieptModelt1);
		    Gson gson = new Gson();
		    String resultString =  new Gson().toJson(millRecieptModelt1);
		    return resultString;//gson.toJson((Object)millRecieptModelt1);
		}
		
		
		 @RequestMapping("saveentryofpaymentinstrumentDetails") 
		  public ModelAndView saveentryofPID(HttpServletRequest request, RedirectAttributes redirectAttributes,
			        @RequestParam("SupportingDocument") final MultipartFile SupportingDocument) {
			    final File theDir = new File("C:\\Users\\kailash.shah\\documentimage");
			    if (!theDir.exists()) {
			        theDir.mkdirs();
			    }
			    final ModelAndView mv = new ModelAndView();
			    String username = (String) request.getSession().getAttribute("usrname");
			    try {

			        String contractno = request.getParameter("fullcontractno");
			        String Instrument = request.getParameter("Instrument");
			        String instdate = request.getParameter("instdate");
			        String IFSC = request.getParameter("IFSC");
			        String Branch = request.getParameter("Branch");
			        String BankName = request.getParameter("BankName");
			        String payment = request.getParameter("paymenttype");
			        String InstrumentValue = request.getParameter("InstrumentValue");
			        String dateofexpiry = request.getParameter("dateofexpiry");
			        String dateofship = request.getParameter("dateofship");
			        String autorevolvingamount = request.getParameter("autorevolvingamount");
			       // String QtyAllowed = request.getParameter("QtyAllowed");
			        final String filename = SupportingDocument.getOriginalFilename();
			        File serverFile = new File(theDir, filename);
			        SupportingDocument.transferTo(serverFile);
			        
			        // Conditionally set autorevolvingamount based on payment type
			       

			        EntryPaymentDetailsModel entryPaymentDetailsModel = new EntryPaymentDetailsModel();
			        entryPaymentDetailsModel.setContractno(contractno);
			        entryPaymentDetailsModel.setInstrumentno(Instrument);
			        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			        Date instdate1 = formatter1.parse(instdate);
			        entryPaymentDetailsModel.setInstdate(instdate1);
			       
			        entryPaymentDetailsModel.setPayment(payment);
			        entryPaymentDetailsModel.setInstrumentValue(InstrumentValue);
			        //entryPaymentDetailsModel.setQtyAllowed(QtyAllowed);
			        entryPaymentDetailsModel.setSupportingDocument(filename);
			        entryPaymentDetailsModel.setFc_status(0);

			        Date date3 = new Date();
			        Double flag = 0.0;
					
			          
			        if ("NEFT/RTGS".equalsIgnoreCase(payment)) {
			        	   autorevolvingamount = "0";
			                entryPaymentDetailsModel.setAutorevolvingamount(autorevolvingamount);
			                entryPaymentDetailsModel.setDateofship(date3);
			                entryPaymentDetailsModel.setDateofexpiry(date3);
			             
			                entryPaymentDetailsModel.setIFSC(IFSC);
					        entryPaymentDetailsModel.setBranch(Branch);
					        entryPaymentDetailsModel.setBankName(BankName);
			                
			                
			        }
			        else if ("Cheque/DD".equalsIgnoreCase(payment)) {
			        	
			        	autorevolvingamount = "0";
		                entryPaymentDetailsModel.setAutorevolvingamount(autorevolvingamount);
		                entryPaymentDetailsModel.setDateofship(date3);
		                entryPaymentDetailsModel.setDateofexpiry(date3);
		                
			            entryPaymentDetailsModel.setIFSC(IFSC);
					    entryPaymentDetailsModel.setBranch(Branch);
					    entryPaymentDetailsModel.setBankName(BankName);
			        }
			        else if ("Letter_of_Credit".equalsIgnoreCase(payment)) {
			        	 
			                entryPaymentDetailsModel.setIFSC(IFSC);
					        entryPaymentDetailsModel.setBranch(Branch);
					        entryPaymentDetailsModel.setBankName(BankName);
					        

				        	  Date dateofship1 = formatter1.parse(dateofship);
				              entryPaymentDetailsModel.setDateofship(dateofship1);

				              Date dateofexpiry1 = formatter1.parse(dateofexpiry);
				              entryPaymentDetailsModel.setDateofexpiry(dateofexpiry1);
				                
				              entryPaymentDetailsModel.setAutorevolvingamount(autorevolvingamount);
			        }
			       

			        
			          Date date = new Date();
			        entryPaymentDetailsModel.setCreated_date(date);
			      
			        this.paymentDetailService.create(entryPaymentDetailsModel);
			       
			        this.paymentDetailService.contratTable(contractno);
			         redirectAttributes.addFlashAttribute("msg",
			                "<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");

			    } catch (Exception e) {

			        e.printStackTrace();
			    }
			    if (username == null) {
			        return new ModelAndView("index");
			    }

			    return new ModelAndView(new RedirectView("EntryofPaymentDetails.obj"));
			}

			
			
			
			
			@RequestMapping("downloadSupportingDocument")
			public void downloadImage(@RequestParam("filename") String filename, HttpServletResponse response) {
			    String imageDirectory = "C:\\Users\\kailash.shah\\documentimage"; // Replace with your image directory path
			    String imagePath = imageDirectory + File.separator + filename;

			    File imageFile = new File(imagePath);

			    // Check if the file exists
			    if (imageFile.exists()) {
			        try {
			            // Set the content type based on the file type
			            String contentType = determineContentType(filename);
			            response.setContentType(contentType);

			            // Set the content length and attachment disposition
			            response.setContentLength((int) imageFile.length());
			            //response.setHeader("Content-Disposition", "attachment; filename=" + filename);
			            response.setHeader("Content-Disposition", "");
			            // Stream the file content to the response
			            FileInputStream fileInputStream = new FileInputStream(imageFile);
			            OutputStream responseOutputStream = response.getOutputStream();

			            byte[] buffer = new byte[1024];
			            int bytesRead;
			            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
			                responseOutputStream.write(buffer, 0, bytesRead);
			            }

			            fileInputStream.close();
			            responseOutputStream.close();
			        } catch (IOException e) {
			            // Handle IO exception
			            e.printStackTrace();
			            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			        }
			    } else {
			        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			    }
			}

			// Utility method to determine content type based on filename
			private String determineContentType(String filename) {
			    if (filename.endsWith(".pdf")) {
			        return "application/pdf";
			    } else if (filename.endsWith(".jpg") || filename.endsWith(".jpeg")) {
			        return "image/jpeg";
			    } else if (filename.endsWith(".png")) {
			        return "image/png";
			    } else {
			        return "application/octet-stream"; // Default to binary data if content type is unknown
			    }
			}
		/////////////	
      @RequestMapping("downloadPDF")
		 public void downloadPDF(@RequestParam("filename") String filename, HttpServletResponse response) {
    	  String imageDirectory = "C:\\Users\\kailash.shah\\documentimage"; // Replace with your image directory path
		    String imagePath = imageDirectory + File.separator + filename;

		    File imageFile = new File(imagePath);
    	  
    	  try {
			           

			            if (imageFile.exists()) {
			               
			                String contentType = determineContentType1(filename);
			                response.setContentType(contentType);

			                response.setContentLength((int) imageFile.length());
			                response.setHeader("Content-Disposition", "attachment; filename=billofsupplyfinal.pdf");
//			                //response.setHeader("Content-Disposition", "");
			              
			                FileInputStream fileInputStream = new FileInputStream(imageFile);
			                OutputStream responseOutputStream = response.getOutputStream();
//
			                byte[] buffer = new byte[1024];
			                int bytesRead;
			                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
			                    responseOutputStream.write(buffer, 0, bytesRead);
			                }
//
			                fileInputStream.close();
			                responseOutputStream.close();
			            } else {
			                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			            }
			        } catch (IOException e) {
//			            
			            e.printStackTrace();
			            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			        }
			    }
			 private String determineContentType1(String filePath) {
			        if (filePath.endsWith(".pdf")) {
			            return "application/pdf";
			        } else if (filePath.endsWith(".jpg") || filePath.endsWith(".jpeg")) {
			            return "image/jpeg";
			        } else if (filePath.endsWith(".png")) {
			            return "image/png";
			        } else {
			            return "application/octet-stream";
			        }
			    }
//			 

			




			   
		
		@RequestMapping("saveFinancialConcurence")  
		public ModelAndView saveentryofFC(HttpServletRequest request, RedirectAttributes redirectAttributes)
		{		String username =(String)request.getSession().getAttribute("usrname");
			try {
			 
				String fullcontractno = request.getParameter("fullcontractno");
				String FC_Issue_Date = request.getParameter("FC_Issue_Date");
				String FC_Ref_No = request.getParameter("FC_Ref_No.");
				String Contracted_Qty = request.getParameter("Contracted_Qty.");
				String QtyAllowed = request.getParameter("QtyAllowed");
				String carryingCostParam = request.getParameter("Carrying_cost");
				double Carrying_Cost_Charged = 0.0; // Default value if the parameter is not present or cannot be parsed

				if (carryingCostParam != null && !carryingCostParam.isEmpty()) {
				    try {
				        Carrying_Cost_Charged = Double.parseDouble(carryingCostParam);
				    } catch (NumberFormatException e) {
				    }
				}

				//double Carrying_Cost_Charged = request.getParameter("Carrying_cost");
				
				
				FinancialConcurenceModel financialConcurenceModel = new FinancialConcurenceModel();
				System.out.print(financialConcurenceModel);
				financialConcurenceModel.setFullcontractno(fullcontractno);
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
				Date contdate = formatter1.parse(FC_Issue_Date);
				
				financialConcurenceModel.setFC_Issue_Date(contdate);
				financialConcurenceModel.setFC_Ref_No(FC_Ref_No);
				financialConcurenceModel.setContracted_Qty(Contracted_Qty);
				financialConcurenceModel.setQtyAllowed(QtyAllowed);
				financialConcurenceModel.setCarrying_Cost_Charged(Carrying_Cost_Charged);

				
				 Date date= new Date();
				 //Date currdate = date.toString();
				 financialConcurenceModel.setCreated_date(date);
				 financialConcurenceModel.setRemarks("Not any");
				this.financialConcurenceservice.create(financialConcurenceModel);
				redirectAttributes.addFlashAttribute("msg",
							"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"
									+ "");
		
			} catch (Exception e) 
			{
				System.out.println("++++++++++++++"+e);
				e.printStackTrace();
			}
			if(username == null) {
		     	return new ModelAndView("index");
		         }
			return new ModelAndView(new RedirectView("viewFinancialConcurence.obj"));
		}
//		
//		@ResponseBody
//		@RequestMapping(value = "saveRemarks", method = RequestMethod.GET)
//			public ModelAndView bnaDeletepay( HttpServletRequest request, RedirectAttributes redirectAttributes,
//					@RequestParam("remarks") String remarks,@RequestParam("contractNo") String contractNo) {
//			System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
//				final ModelAndView mv = new ModelAndView("viewFCpaymentlist");
//				String username = (String) request.getSession().getAttribute("usrname");
//				if (username == null) {
//					return new ModelAndView("index");
//				}
//				try {		
//					if (request.getParameter("id") != null) {
//					final int id = Integer.parseInt(request.getParameter("id")); 
//					//final String  contno=request.getParameter("contno");
//					this.paymentDetailService.update1(contractNo);
//					this.financialConcurenceservice.remark(remarks,contractNo);
//					final EntryPaymentDetailsModel entryPaymentDetailsModel = this.paymentDetailService.find(id);
//					mv.addObject("entryPaymentDetailsModel",entryPaymentDetailsModel);
//				}
//						redirectAttributes.addFlashAttribute("msg",
//							(Object) "<div class=\"alert alert-success\"><b>Success !</b> Data rejected successfully.</div>\r\n");
//
//					return  new ModelAndView(new RedirectView("viewPaymentForFC.obj"));
//				}
//
//				catch (Exception ex) {
//					return mv;
//				}
//			}
			
//	
//		    Gson gson = new Gson();
//		    String resultString =  new Gson().toJson(millRecieptModelt1);
//		    return resultString;gson.toJson((Object)millRecieptModelt1);
		
	    
		
//		
		@ResponseBody
		@RequestMapping("saveRemarks")
		public ResponseEntity<String> saveRemarks(@RequestParam("remarks") String remarks,
				@RequestParam("con_no") String contractNo, @RequestParam("id") int paymentId,
				HttpServletRequest request, RedirectAttributes redirectAttributes) {
			final ModelAndView mv = new ModelAndView("viewFCpaymentlist");

			String username = (String) request.getSession().getAttribute("usrname");
			if (username == null) {
				return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
			}
			try {
				this.financialConcurenceservice.remark(remarks, contractNo);
				this.paymentDetailService.update1(contractNo);

				EntryPaymentDetailsModel entryPaymentDetailsModel = this.paymentDetailService.find(paymentId);
				mv.addObject("entryPaymentDetailsModel", entryPaymentDetailsModel);

////				request.getSession().setAttribute("myModel", entryPaymentDetailsModel);
//////
////				redirectAttributes.addFlashAttribute("contractNo", entryPaymentDetailsModel.getContractno());
////				redirectAttributes.addFlashAttribute("paymentId", entryPaymentDetailsModel.getPayment_id());
//
//				//String modelQueryString = "contractNo=" + entryPaymentDetailsModel.getContractno() + "&paymentType="
////						+ entryPaymentDetailsModel.getPayment_id();
				
				 redirectAttributes.addFlashAttribute("entryPaymentDetailsModel", entryPaymentDetailsModel);
			        
				redirectAttributes.addFlashAttribute("msg",
//
						"<div class=\"alert alert-success\"><b>Success !</b> Data rejected successfully.</div>");
				return new ResponseEntity<>("{\"redirect\":\"viewPaymentForFC.obj\"}",HttpStatus.OK);
			  
			} catch (Exception ex) {
				return new ResponseEntity<>("Error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		
		
		


	
		
		@RequestMapping("saveentryofMillreciept")  
		public ModelAndView saveentryofMR(HttpServletRequest request, RedirectAttributes redirectAttributes)
		{
		
		     final ModelAndView mv = new ModelAndView();
			String username =(String)request.getSession().getAttribute("usrname");
			try {
			
				String HO_DI = request.getParameter("HO_DI_&_Date");
				String Challan_No = request.getParameter("Challan_No");
				//Date Date_of_Shipment = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("Date_of_Shipment"));

			   String Date_of_Shipment = request.getParameter("Date_of_Shipment");
				System.out.println(Date_of_Shipment+"Date_of_Shipment");
				String Vehicle_No = request.getParameter("Vehicle_No.");
				String Challan_Qty = request.getParameter("Challan_Qty");
				double Challan_Qty1 = Double.parseDouble(Challan_Qty);
				String Actual_Qty = request.getParameter("Actual_Qty");
				double Actual_Qty1 = Double.parseDouble(Actual_Qty);
				//float Actual_Qty1 = Float.parseFloat(Actual_Qty); 
				String Quality_Claim = request.getParameter("Quality_Claim");
				
			
				String Bale_Mark = request.getParameter("Bale_Mark");
				String juteewiseqty = request.getParameter("juteewiseqty");
				String Crop_Year = request.getParameter("Crop_Year");
				
				String MR_No = request.getParameter("MR_No");
				String MR_Date1 = request.getParameter("MR_Date");
				String HR_Date1 = request.getParameter("HO_Date");
				
				String Mill_Reciept_Qty = request.getParameter("Mill_Reciept_Qty.");
				double Mill_Reciept_Qty1 = Double.parseDouble(Mill_Reciept_Qty);
				String Short_Qty = request.getParameter("Short_Qty");
				double Short_Qty1 = Double.parseDouble(Short_Qty);
				//float Short_Qty1 = Float.parseFloat(Short_Qty);
				
				
				MillRecieptModel millRecieptModel = new  MillRecieptModel();
				
				 Double flag = 0.0;
					
		          
		        if ("Quality".equalsIgnoreCase(Quality_Claim)) {
		            millRecieptModel.setNCV_percentage(flag);
		            millRecieptModel.setNCV_qty(flag);
		            millRecieptModel.setMoistureContent(flag);
		        }
		        else if ("Quantity".equalsIgnoreCase(Quality_Claim)) {
		            millRecieptModel.setNCV_percentage(flag);
		            millRecieptModel.setNCV_qty(flag);
		            millRecieptModel.setMoistureContent(flag);
		        }
		        else if ("Moisture_Gain".equalsIgnoreCase(Quality_Claim)) {

		        	String Moisture_Content = request.getParameter("MoistureContent12");
					System.out.println("Moisture_Content==="+Moisture_Content);
					 double moistureContent1 = Double.parseDouble(Moisture_Content);
		            millRecieptModel.setMoistureContent(moistureContent1);
		            millRecieptModel.setNCV_percentage(flag);
		            millRecieptModel.setNCV_qty(flag);
		        }
		        else if ("Dust_NCV".equalsIgnoreCase(Quality_Claim)) {
		        	String NCV_Percentage = request.getParameter("NCVPercentage12");
					double NCV_Percentage1 = Double.parseDouble(NCV_Percentage);
		            millRecieptModel.setNCV_percentage(NCV_Percentage1);
		            String NCV_Qty = request.getParameter("NCVQty12");
					double NCV_Qty1 = Double.parseDouble(NCV_Qty);
		            millRecieptModel.setNCV_qty(NCV_Qty1);
		            millRecieptModel.setMoistureContent(flag);
		        }

		           
				
				millRecieptModel.setHO_di(HO_DI);
				millRecieptModel.setChallan_no(Challan_No);
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(Date_of_Shipment);  
			    System.err.println(date1);
				//Date instdate1 = formatter1.parse(Date_of_Shipment);
				millRecieptModel.setDate_shipment(date1);
				millRecieptModel.setVehicle_no(Vehicle_No);
				millRecieptModel.setChallan_qty(Challan_Qty1);
				millRecieptModel.setActual_qty(Actual_Qty1);
				millRecieptModel.setQuality_claim(Quality_Claim);
				//millRecieptModel.setMoistureContent(Moisture_Content);
				//millRecieptModel.setNCV_percentage(NCV_Percentage);
				millRecieptModel.setBale_mark(Bale_Mark);
				
		
				millRecieptModel.setCrop_year(Crop_Year);
				//millRecieptModel.setNCV_qty(NCV_Qty);
				millRecieptModel.setMR_no(MR_No);
				//Date date= new Date();
				
				Date MR_Date = formatter1.parse(MR_Date1);
				millRecieptModel.setMr_date(MR_Date);
				
				 Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(HR_Date1);
//				Date MR_Date3 = formatter1.parse(HR_Date1);
				millRecieptModel.setHo_date(date2);
				
				
				
				//millRecieptModel.setMr_date(MR_Date);
				//millRecieptModel.setMi(Mill_Reciept_Qty);
				millRecieptModel.setShort_qty(Short_Qty1);
				millRecieptModel.setMR_qty(Mill_Reciept_Qty1);
				millRecieptModel.setMill_id("1");
				 Date date= new Date();
				// Date currdate = date.toString();
				 millRecieptModel.setCreated_on(date);
				// millRecieptModel.setHo_date(date);
				 millRecieptModel.setCreated_by("kailash");
				 millRecieptModel.setMR_qty(123.0);
				 millRecieptModel.setClaim_status(2);
				 
				this.millRecieptService.create(millRecieptModel);
				//this.millRecieptService.UpdateContractstatus(HO_DI);
				redirectAttributes.addFlashAttribute("msg",
							"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"
									+ "");
		
			} catch (Exception e) 
			{
			
				e.printStackTrace();
			}
			if(username == null) {
		     	return new ModelAndView("index");
		         }
			
			return new ModelAndView(new RedirectView("EntryofMillreceipt.obj"));
		}
		
		@RequestMapping("saveentryofGenrationDeamandNote")  
		public ModelAndView saveentryofGDN(HttpServletRequest request, RedirectAttributes redirectAttributes)
		{
		
		     final ModelAndView mv = new ModelAndView();
			String username =(String)request.getSession().getAttribute("usrname");
			try {
			
				String Contract_No = request.getParameter("Contract_No");
				String Contract_Date = request.getParameter("Contract_Date");
				String Payment_Due_Date = request.getParameter("Payment_Due_Date");
				String Cancellation_Date = request.getParameter("Cancellation_Date.");
				String Delay_period = request.getParameter("Delay_period");
				String Payment_Ref = request.getParameter("Payment_Ref");
				String contractedQtyStr = request.getParameter("Contracted_Qty");
				 double contractedQty = Double.parseDouble(contractedQtyStr);
				
				String Unit_charge_str = request.getParameter("Unit_charge");
				double Unit_charge = Double.parseDouble(Unit_charge_str);
				String Carrying_cost_str = request.getParameter("Carrying_cost");
				double Carrying_cost = Double.parseDouble(Carrying_cost_str);
				//String Waiver_flag = request.getParameter("Waiver_flag");
				String Remarks = request.getParameter("Remarks");
				//String Waiver_Approved_By = request.getParameter("Waiver_Approved_By");
				//String Dn_status = request.getParameter("Dn_status");
				String Demand_note_no = request.getParameter("Demand_note_no");
				String Demand_note_date = request.getParameter("Demand_note_date");
				
				
				
				
				
				GenrationDemandNoteModel genrationDemandNoteModel = new  GenrationDemandNoteModel();
				
				genrationDemandNoteModel.setContract_no(Contract_No);
				
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
				genrationDemandNoteModel.setDemand_note_no(Demand_note_no);
				Date instdate4 = formatter1.parse(Demand_note_date);
				genrationDemandNoteModel.setDemand_note_date(instdate4);
				genrationDemandNoteModel.setContract_date(Contract_Date);
				genrationDemandNoteModel.setPayment_due_date(Payment_Due_Date);
				//genrationDemandNoteModel.setPayment_date(Cancellation_Date);
				genrationDemandNoteModel.setPayment_date("somevalue");
				genrationDemandNoteModel.setDelay_period(Delay_period);
				genrationDemandNoteModel.setPayment_ref(Payment_Ref);
				genrationDemandNoteModel.setContracted_qty(contractedQty);
				genrationDemandNoteModel.setUnit_charge(Unit_charge);
				genrationDemandNoteModel.setCarrying_cost(Carrying_cost);
				genrationDemandNoteModel.setWaiver_flag(0);
				genrationDemandNoteModel.setRemarks(Remarks);
				genrationDemandNoteModel.setWaiver_approved_by("kailash");
				genrationDemandNoteModel.setDn_status(0);
				genrationDemandNoteModel.setCreated_by("kailash");
				
				Date date= new Date();
				//Date instdate4 = formatter1.parse(Created_on);
				genrationDemandNoteModel.setCreated_on(date);
				//Date date= new Date();
				
			this.genratedDemandNoteService.create(genrationDemandNoteModel);
				redirectAttributes.addFlashAttribute("msg",
							"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"
									+ "");
		
			} catch (Exception e) 
			{
			
				e.printStackTrace();
			}
			if(username == null) {
		     	return new ModelAndView("index");
		         }
			
			return new ModelAndView(new RedirectView("EntryofGenrationDeamandNote.obj"));
		}
		
		
		@RequestMapping("saveentryofSubmissionofQoute")  
		public ModelAndView saveentryofSOQ(HttpServletRequest request, RedirectAttributes redirectAttributes,
				@RequestParam("Bid_Quote_Document") final MultipartFile Bid_Quote_Document)
		{
			 final File theDir = new File("C:\\Users\\kailash.shah\\documentimage");
			    if (!theDir.exists()) {
			        theDir.mkdirs();
			    }
		     final ModelAndView mv = new ModelAndView();
			String username =(String)request.getSession().getAttribute("usrname");
			try {
			
				String Bid_Reference_No = request.getParameter("Bid_Reference_No");
				String Mill_name = request.getParameter("Mill_name");
				String Lot_Identification = request.getParameter("Lot_Identification");
				String Quoted_Base_Price = request.getParameter("Quoted_Base_Price");
				
		        final String filename = Bid_Quote_Document.getOriginalFilename();
		        File serverFile = new File(theDir, filename);
		        Bid_Quote_Document.transferTo(serverFile);
				
				double quotedBasePrice = Double.parseDouble(Quoted_Base_Price);
				
				String Created_by = request.getParameter("Created_by");
				
				
				
				
				
				SubmissionOfQuoteModel submissionOfQuoteModel = new  SubmissionOfQuoteModel();
				
				submissionOfQuoteModel.setBid_Reference_No(Bid_Reference_No);
				
				
			
				
				submissionOfQuoteModel.setMill_name(Mill_name);
				submissionOfQuoteModel.setLot_Identification(Lot_Identification);
				submissionOfQuoteModel.setQuoted_Base_Price(quotedBasePrice);
				
				
				submissionOfQuoteModel.setBid_Quote_Document(filename);
				
			
				
		
			
				submissionOfQuoteModel.setCreated_by(Created_by);
				Date  date =new Date();
				 
				submissionOfQuoteModel.setCreation_date(date);
				submissionOfQuoteModel.setBid_rank("1");
				//Date date= new Date();
				
			this.submissionOfQuoteService.create(submissionOfQuoteModel);
				redirectAttributes.addFlashAttribute("msg",
							"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"
									+ "");
		
			} catch (Exception e) 
			{
			
				e.printStackTrace();
			}
			if(username == null) {
		     	return new ModelAndView("index");
		         }
			
			return new ModelAndView(new RedirectView("EntrySubmissionofQuote.obj"));
		}
		
		@RequestMapping("saveentryofGenrationCashDocument")  
		public ModelAndView saveentryofGenrationDeamandNote(HttpServletRequest request, RedirectAttributes redirectAttributes)
		{
		
		     final ModelAndView mv = new ModelAndView();
			String username =(String)request.getSession().getAttribute("usrname");
			try {
			
				/* String CAD_Doc_No = request.getParameter("CAD_Doc_No"); */
				String CAD_Date = request.getParameter("CAD_Date");
				String BOS_No = request.getParameter("BOS_No");
				String BOS_Date = request.getParameter("BOS_Date");
				CashDocumentModel cashDocumentModel = new  CashDocumentModel();
				/* cashDocumentModel.setCAD_Doc_No(CAD_Doc_No); */
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
				Date instdate1 = formatter1.parse(CAD_Date);
			    cashDocumentModel.setCAD_Date(instdate1);
				cashDocumentModel.setBOS_No(BOS_No);
				Date instdate2 = formatter1.parse(BOS_Date);
				cashDocumentModel.setBOS_Date(instdate2);
			
				
			this.genrationCashDocumentService.create(cashDocumentModel);
				redirectAttributes.addFlashAttribute("msg",
							"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"
									+ "");
		
			} catch (Exception e) 
			{
			
				e.printStackTrace();
			}
			if(username == null) {
		     	return new ModelAndView("index");
		         }
			
			return new ModelAndView(new RedirectView("EntryGenerationCashagainstDispatch.obj"));
		}
		
		
		@RequestMapping("saveConfirmationOfClaimSettelment.obj")  
		public ModelAndView saveConfirmationOfClaimSettelment(HttpServletRequest request, RedirectAttributes redirectAttributes)
		{
		
		     final ModelAndView mv = new ModelAndView();
			String username =(String)request.getSession().getAttribute("usrname");
			try {
			
				/* String CAD_Doc_No = request.getParameter("CAD_Doc_No"); */
				String Settlement_Id1 = request.getParameter("Settlement_Id1");
				int Settlement_Id12 = Integer.parseInt(Settlement_Id1);
				String Date_of_inspection1 = request.getParameter("Dateofinspection");
				String fullcontractno = request.getParameter("fullcontractno");
				String Challan_No1 = request.getParameter("Challan_No1");
				//String MR_No1 = request.getParameter("MR_No1");
				//String Bale_Mark1 = request.getParameter("Bale_Mark1");
				//String Jute_Variety_Grade_wise1 = request.getParameter("Jute_Variety_Grade_wise1");
				//String Crop_Year1 = request.getParameter("Crop_Year1");
				//String Quality_Claim1 = request.getParameter("Quality_Claim1");
				//double Quality_Claim12 = Double.parseDouble(Quality_Claim1);
				//String Moisture_Content1 = request.getParameter("Moisture_Content1");
				//double Moisture_Content12 = Double.parseDouble(Moisture_Content1);
				//String NCV_Percentage1 = request.getParameter("NCV_Percentage1");
				//double NCV_Percentage12 = Double.parseDouble(NCV_Percentage1);
				double defaultValue = 0.0;
				
				
				
				
				
				
			
				String Inspection_by1 = request.getParameter("Inspectionby1");
				String Supporting_document1 = request.getParameter("Supportingdocument1");
				
				ConfirmationClaimSettlementModel confirmationClaimSettlementModel = new  ConfirmationClaimSettlementModel();
				
				String Claim_Amount1 = request.getParameter("ClaimAmount");
				
				 if (Claim_Amount1 != null) {
				       
				    	double Claim_Amount12 = Double.parseDouble(Claim_Amount1);
				    	confirmationClaimSettlementModel.setClaim_Amount(Claim_Amount12);
				     } else {
				    	 double Claim_Amount12 =defaultValue ;
				    	 confirmationClaimSettlementModel.setClaim_Amount(Claim_Amount12);
				     }
				 
				 String Quality_Settlement1 = request.getParameter("Quality_Settlement1");
				 if (Quality_Settlement1 != null) {
				       
				    	double Quality_Settlement12 = Double.parseDouble(Quality_Settlement1);
				    	confirmationClaimSettlementModel.setQuality_settlement(Quality_Settlement12);
				     } else {
				    	 double Quality_Settlement12 =defaultValue ;
				    	 confirmationClaimSettlementModel.setQuality_settlement(Quality_Settlement12);
				     }
				 
				 String Moisture_Settlement1 = request.getParameter("Moisture_Settlement1");
				 if (Moisture_Settlement1 != null) {
				       
				    	double Moisture_Settlement12 = Double.parseDouble(Moisture_Settlement1);
				    	confirmationClaimSettlementModel.setMoisture_settlement(Moisture_Settlement12);
				     } else {
				    	 double Moisture_Settlement12 =defaultValue ;
				    	 confirmationClaimSettlementModel.setMoisture_settlement(Moisture_Settlement12);
				     }
				
				 String NCV_Settlement1 = request.getParameter("NCV_Settlement1");
				 if (NCV_Settlement1 != null) {
				       
				    	double NCV_Settlement12 = Double.parseDouble(NCV_Settlement1);
				    	confirmationClaimSettlementModel.setNcv_settlement(NCV_Settlement12);
				     } else {
				    	 double NCV_Settlement12 =defaultValue ;
				    	 confirmationClaimSettlementModel.setNcv_settlement(NCV_Settlement12);
				     }
				 
				 
					String Settlement_Amount1 = request.getParameter("SettlementAmount");
					
					if (Settlement_Amount1 != null) {
					       
				    	double Settlement_Amount12 = Double.parseDouble(Settlement_Amount1);
				    	confirmationClaimSettlementModel.setSettlement_amt(Settlement_Amount12);
				     } else {
				    	 double Settlement_Amount12 =defaultValue ;
				    	 confirmationClaimSettlementModel.setSettlement_amt(Settlement_Amount12);
				     }
					
				
				
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
				Date instdate1 = formatter1.parse(Date_of_inspection1);
				confirmationClaimSettlementModel.setSettlement_id(Settlement_Id12);
				//confirmationClaimSettlementModel.setMill(Settlement_Id12);
				confirmationClaimSettlementModel.setDate_of_Inspection(instdate1);
				confirmationClaimSettlementModel.setContract_No(fullcontractno);
				confirmationClaimSettlementModel.setChallan_No(Challan_No1);
				
				
				
				
				
				
				
				confirmationClaimSettlementModel.setInspection_by(Inspection_by1);
				confirmationClaimSettlementModel.setSupporting_doc(Supporting_document1);
				
				Date date1 = new Date();
				confirmationClaimSettlementModel.setInspection_date(date1);
				confirmationClaimSettlementModel.setDispute_flag(0);
				confirmationClaimSettlementModel.setOM_Official("vishal");
				confirmationClaimSettlementModel.setMill("1");
				confirmationClaimSettlementModel.setFA_Official("Pradeep");
				confirmationClaimSettlementModel.setCreated_by("kailash");
				confirmationClaimSettlementModel.setCreated_on(date1);
				
			
			
				
			this.confirmationofClaimSettlementService.create(confirmationClaimSettlementModel);
				redirectAttributes.addFlashAttribute("msg",
							"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"
									+ "");
		
			} catch (Exception e) 
			{
			
				e.printStackTrace();
			}
			if(username == null) {
		     	return new ModelAndView("index");
		         }
			
			return new ModelAndView(new RedirectView("entryofConfirationSettelment.obj"));
		}
		
		@RequestMapping({ "viewMillReciept" })
		public ModelAndView viewMillReciept(final HttpServletRequest request) {
			String username = (String) request.getSession().getAttribute("usrname");
			ModelAndView mv = new ModelAndView("viewMillReciept");
			if (username == null) {
				mv = new ModelAndView("index");
			}
												

			final List<MillRecieptModel> allUserRegistration = (List<MillRecieptModel>) this.millRecieptService
					.getAllPaymentInstruments();
			mv.addObject("millRecieptModel", allUserRegistration);
			

			return mv;
		}
		
		
		@RequestMapping({ "ViewofGenerationBillsupply" })
		public ModelAndView viewBillofSupplyReciept(final HttpServletRequest request) {
			String username = (String) request.getSession().getAttribute("usrname");
			ModelAndView mv = new ModelAndView("viewGenerationBill");
			if (username == null) {
				mv = new ModelAndView("index");
			}
										

			final List<GenerationOfBillSupplyModel> GenerationOfBill = (List<GenerationOfBillSupplyModel>) this.generationofBillService.getAll();
			mv.addObject("GenerationOfBill", GenerationOfBill);
			

			return mv;
		}
		 @RequestMapping("saveentryofGenrationbill") 
		  public ModelAndView saveentryofGenrationbill(HttpServletRequest request, RedirectAttributes redirectAttributes
			       ) {
			    final File theDir = new File("C:\\Users\\kailash.shah\\documentimage");
			    if (!theDir.exists()) {
			        theDir.mkdirs();
			    }
			    final ModelAndView mv = new ModelAndView();
			    String username = (String) request.getSession().getAttribute("usrname");
			    try {

			        String Challan_No1 = request.getParameter("Challan_No1");
			        String Challan_Date1 = request.getParameter("Challan_Date1");
			        String Shipment_Details = request.getParameter("Shipment_Details");
			        String Shipment_Value1 = request.getParameter("Shipment_Value1");
			        String SGST_Amt = request.getParameter("SGST_Amt");
			        String CGST_Amt = request.getParameter("CGST_Amt");
			        String IGST_Amt = request.getParameter("IGST_Amt");
			        String TCS_Amt = request.getParameter("TCS_Amt");
			        String TDS_Amt = request.getParameter("TDS_Amt");
			        String Bill_of_Supply = request.getParameter("Bill_of_Supply");
			        String Invoice_Value = request.getParameter("Invoice_Value");
			        String BOS_Date = request.getParameter("BOS_Date");
			        String Supplier_Name = request.getParameter("Supplier_Name");
			        String Supplier_GSTN = request.getParameter("Supplier_GSTN");
			        String Supplier_Address = request.getParameter("Supplier_Address");
			        String Recipient_Name = request.getParameter("Recipient_Name");
			        String Recipient_GSTN = request.getParameter("Recipient_GSTN");
			        String Recipient_Address = request.getParameter("Recipient_Address");
			        String Consignee_Name = request.getParameter("Consignee_Name");
			        String Consignee_GSTN = request.getParameter("Consignee_GSTN");
			        String Consignee_Address = request.getParameter("Consignee_Address");
			        String Conract_no = request.getParameter("Contarct_no");
			        String Clientstate = request.getParameter("Clientstate");
			        String Clientcode = request.getParameter("Clientcode");
			        String ClientPan = request.getParameter("ClientPan");
//			       // String QtyAllowed = request.getParameter("QtyAllowed");
////			        final String filename = SupportingDocument.getOriginalFilename();
////			        File serverFile = new File(theDir, filename);
////			        SupportingDocument.transferTo(serverFile);
////			        
//			        // Conditionally set autorevolvingamount based on payment type
			        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			       // Date instdate1 = formatter1.parse(Challan_Date1);
			       // Date instdate2 = formatter1.parse(Challan_Date1);
			        GenerationOfBillSupplyModel generationOfBillSupplyModel = new GenerationOfBillSupplyModel();
			        generationOfBillSupplyModel.setChallan_No(Challan_No1);
			        generationOfBillSupplyModel.setChallan_date(Challan_Date1);
			        generationOfBillSupplyModel.setShipment_details(Shipment_Details);
			        generationOfBillSupplyModel.setShipment_value(Shipment_Value1);
			        generationOfBillSupplyModel.setSGST_amt(SGST_Amt);
			        generationOfBillSupplyModel.setCGST_amt(CGST_Amt);
			        generationOfBillSupplyModel.setIGST_amt(IGST_Amt);
			        generationOfBillSupplyModel.setTCS_amt(TCS_Amt);
			        generationOfBillSupplyModel.setTDS_amt(TDS_Amt);
			        generationOfBillSupplyModel.setBill_of_supply_no(Bill_of_Supply);
			        generationOfBillSupplyModel.setInvoice_value(Invoice_Value);
			        generationOfBillSupplyModel.setBOS_date(BOS_Date);
			        generationOfBillSupplyModel.setSupplier_name(Supplier_Name);
			        generationOfBillSupplyModel.setSupplier_gSTN(Supplier_GSTN);
			        generationOfBillSupplyModel.setSupplier_address(Supplier_Address);
			        generationOfBillSupplyModel.setRecipient_name(Recipient_Name);
			        generationOfBillSupplyModel.setRecipient_gSTN(Recipient_GSTN);
			        generationOfBillSupplyModel.setRecipient_address(Recipient_Address);
			        generationOfBillSupplyModel.setConsignee_name(Consignee_Name);
			        generationOfBillSupplyModel.setConsignee_gSTN(Consignee_GSTN);
			        generationOfBillSupplyModel.setConsignee_address(Consignee_Address);
			        generationOfBillSupplyModel.setContract_no(Conract_no);
			      
			          Date date = new Date();
			          generationOfBillSupplyModel.setCreation_date(date);
			          generationOfBillSupplyModel.setRo_id("1");
			          //generationOfBillSupplyModel.setBos_file_path("documents");
			          List<Object[]> list = generationofBillService.Dispatchentry(Challan_No1);
			       
			          
//			          
////			         
			          
			          PdfGenerator_K pdfgenereatorK = new PdfGenerator_K();
			          String filePath = pdfgenereatorK.generateBillPdf( Invoice_Value,Challan_No1,Shipment_Details,Supplier_Name,
				        		Supplier_GSTN,Supplier_Address,Recipient_Name,Recipient_GSTN,Recipient_Address,Consignee_Name,Consignee_GSTN,
				        		Consignee_Address,Bill_of_Supply, Conract_no,Clientstate,Clientcode,ClientPan,BOS_Date, list);
				        
				      
				        
				        generationOfBillSupplyModel.setBos_file_path(filePath);
				    System.out.println(filePath);
				    System.out.println(filePath);
				    System.out.println(filePath);
				    
				       
			        
			        this.generationofBillService.create(generationOfBillSupplyModel);
			        
			       
//			        
//			       
//			        this.paymentDetailService.contratTable(contractno);
			         redirectAttributes.addFlashAttribute("msg",
			                "<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");

			    } catch (Exception e) {

			        e.printStackTrace();
			    }
			    if (username == null) {
			        return new ModelAndView("index");
			    }
			    
			    
			    // Starting Email Sender
	           
	            EmailSender email=new EmailSender();
	            InternetAddress[] toAddresses=null;
	            
	             String subject="Bill of Supply attachement";
	            
	              String body = "In this All information regarding Bill of supply . ";
	              
	              String filename="C:\\Users\\kailash.shah\\Downloads\\website.jpg";
	              //String filename = "C:\\Users\\kailash.shah\\documentimage\\" + filePath;
	              String username1="";
	              try {
	                  //toAddresses  = {  new InternetAddress("vishal.vishwakarma@cyfuture.com") ,new InternetAddress("animesh.anand@cyfuture.com")};
	            
	              
	                    toAddresses = new InternetAddress[]{
	                                 new InternetAddress("shahkailash2000@gmail.com"),
	                                 new InternetAddress("kailashshahsha81@gmail.com")
	                             };
	              
	              } catch (AddressException e) {
	                  // TODO Auto-generated catch block
	                  e.printStackTrace();
	            }
	            
	             email.sendEmail( toAddresses ,  body , subject, filename, username1);
	            
	           

			    
			    // End Email
			    
			    
//
			    return new ModelAndView(new RedirectView("EntryofGenerationBillsupply.obj"));
			}
		 

//		
//		

	
//		
}
		 

