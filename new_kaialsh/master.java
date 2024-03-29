package com.jci.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.google.common.base.CharMatcher;
import com.google.gson.Gson;
import com.jci.model.AddOrganizationModel;
import com.jci.model.AreaDetailCode;
import com.jci.model.BalePreparation;
import com.jci.model.BalePreparationModel;
import com.jci.model.BatchIdentificationModel;
import com.jci.model.CommercialCeilingPriceIntimationModel;
import com.jci.model.CommercialJuteVarietyModel;
import com.jci.model.DailyPurchaseConfModel;
import com.jci.model.DistributionoftallyslipModel;
import com.jci.model.DistrictModel;
import com.jci.model.FarmerRegModel;
import com.jci.model.FarmerRegModelDTO;
import com.jci.model.FarmerRegistrationModel;
import com.jci.model.JbaModel;
import com.jci.model.MSPPriceCalculationModel;
import com.jci.model.MarketArrivalModel;
import com.jci.model.PincodeModel;
import com.jci.model.ProgOfAssortmentModel;
import com.jci.model.RawJuteProcurementAndPayment;
import com.jci.model.RoleMasterModel;
import com.jci.model.RopeMakingModel;
import com.jci.model.RulingMarket;
import com.jci.model.SalesModel;
import com.jci.model.StateList;
import com.jci.model.UserRegistrationModel;
import com.jci.model.VerifyFarmerModel;
import com.jci.model.VerifyTallySlip;
import com.jci.model.ZoneModel;
import com.jci.service.AddOrganisationService;
import com.jci.service.AreaService;
import com.jci.service.BalePreparationService;
import com.jci.service.BalePrepareService;
import com.jci.service.BatchIdentificationService;
import com.jci.service.CommercialCeilingPriceIntimationService;
import com.jci.service.CommercialJuteVarietyGradesPriceService;
import com.jci.service.DailyPurchaseModelConfService;
import com.jci.service.DistributionoftallyslipService;
import com.jci.service.DistrictService;
import com.jci.service.FarmerRegService;
import com.jci.service.FarmerRegistrationService;
import com.jci.service.JBAService;
import com.jci.service.MSPPriceCalculationService;
import com.jci.service.MarketArrivalService;
import com.jci.service.PincodeService;
import com.jci.service.PoliceStationService;
import com.jci.service.ProgOfAssortmentService;
import com.jci.service.PurchaseCenterService;
import com.jci.service.RawJuteProcurementAndPaymentService;
import com.jci.service.RoDetailsService;
import com.jci.service.RoleMasterService;
import com.jci.service.RopeMakingService;
import com.jci.service.RulingMarketService;
import com.jci.service.SalesService;
import com.jci.service.StateService;
import com.jci.service.UserRegistrationService;
import com.jci.service.VerifyFarmerService;
import com.jci.service.VerifyTallySlipService;
import com.jci.service.ZoneService;
import com.jci.service.blockService;

@Controller
public class InsertDataController {

	private static int count = 0;

	// TODO fix the path issue
	//private final String farmerUpload = ".\\JciUploadImages\\farmerReg";
	private final String farmerUpload = "E:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\jciadmin\\JciUploadImages";
	
	private static Logger logger = LogManager.getLogger(InsertDataController.class);

	@Autowired
	PincodeService pincodeService;

	@Autowired
	FarmerRegistrationService farmerRegistrationService;

	@Autowired
	AddOrganisationService addOrganisationService;

	@Autowired
	RopeMakingService ropeMakingService;
	
	@Autowired
	BatchIdentificationService batchService;
	
	@Autowired
	DistrictService distric;

	@Autowired
	BalePreparationService balepreparationservice;

	@Autowired
	JBAService jbaservice;
	
	@Autowired
	 AreaService areaService;
	
	@Autowired
	private StateService stateList;

	@Autowired
	SalesService salesService;

	@Autowired
	FarmerRegService farmerRegService;

	@Autowired
	RawJuteProcurementAndPaymentService rawJuteProcurAndPayService;

	@Autowired
	DailyPurchaseModelConfService DailyPurchasefService;

	@Autowired
	ProgOfAssortmentService progOfAssortmentService;

	@Autowired
	MarketArrivalService marketArrivalService;

	@Autowired
	UserRegistrationService UserRegistrationService;

	@Autowired
	ZoneService zoneService;

	@Autowired
	RoDetailsService roService;

	@Autowired
	PurchaseCenterService purchaseCenterService;

	@Autowired
	RoleMasterService roleService;

	@Autowired
	VerifyFarmerService verifyFarmerService;

	@Autowired
	DistributionoftallyslipService distributionoftallyslipService;

	@Autowired
	VerifyTallySlipService verifyTallySlipService;

	@Autowired
	CommercialCeilingPriceIntimationService commercialCeilingPriceIntimationService;

	@Autowired
	RulingMarketService rulingMarketService;

	@Autowired
	BalePreparationService balePreparationService;
	
	@Autowired
	MSPPriceCalculationService mSPPriceCalculationService;
	
	@Autowired
	CommercialJuteVarietyGradesPriceService commercialJuteVarietyGradesPriceService;
	
	
	@Autowired
	blockService block;
	
	@Autowired
	PoliceStationService PoliceStationService;
	
	@Autowired
	BalePrepareService balePrepareService;

	@RequestMapping("addGrower")
	public ModelAndView Dashboard(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("dashboard");
		return mv;
	}

	@RequestMapping("ViewGrower")
	public ModelAndView ViewGrower(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("View_page");
		return mv;
	}

	@RequestMapping("dashboard")
	public ModelAndView dashboard(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("dashboard");
		return mv;
	}

	@RequestMapping("FarmerRegistration")
	public ModelAndView FarmerRegistration(HttpServletRequest request) {
		List<PincodeModel> pincodeList = pincodeService.getAll();
		List<StateList> Liststate = stateList.getAll();
		List<DistrictModel> DistrictList = distric.getAll();

		ModelAndView mv = new ModelAndView("FarmerRegistration");
		mv.addObject("pincodeList", pincodeList);
		mv.addObject("Liststate", Liststate);
		mv.addObject("DistrictList", DistrictList);


		return mv;
	}
	
	@RequestMapping("addFarmer")
	public ModelAndView addFarmer(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("addFarmer");
		return mv;
	}

	@RequestMapping("saveFarmerMid")
	public ModelAndView saveFarmer(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		try {
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			// int mobileno = Integer.parseInt(request.getParameter("mobileno"));
			String mobileno = request.getParameter("mobileno");
			String useremail = request.getParameter("useremail");
			// System.out.println("useremail"+ useremail);
			int roleid = Integer.parseInt(request.getParameter("roleid"));
			int orgid = Integer.parseInt(request.getParameter("orgid"));
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			
			String majorwork = request.getParameter("majorwork");
			String ipAddress = null;
			String getWay = request.getHeader("VIA"); // Gateway
			ipAddress = request.getHeader("X-FORWARDED-FOR"); // proxy
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
			}
			FarmerRegistrationModel farmerRegistration = new FarmerRegistrationModel();
			farmerRegistration.setCity(city);
			farmerRegistration.setCreateddate(new Date());
			farmerRegistration.setEnabled(1);
			farmerRegistration.setFirstname(firstname);
			farmerRegistration.setIpaddress(ipAddress);
			farmerRegistration.setLastname(lastname);
			farmerRegistration.setMajorwork(majorwork);
			farmerRegistration.setMobileno(mobileno);
			farmerRegistration.setOrgid(orgid);
			farmerRegistration.setRoleid(roleid);
			farmerRegistration.setState(state);

			farmerRegistration.setStatus(1);
			farmerRegistration.setUseremail(useremail);
			farmerRegistrationService.create(farmerRegistration);
			redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		} catch (Exception e) {
			logger.fatal(e);
		}
		return new ModelAndView(new RedirectView("addFarmer.obj"));
	}

	@RequestMapping("viewFarmerList")
	public ModelAndView viewFarmerList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("ViewFarmer");
		List<FarmerRegistrationModel> allFarmersList = farmerRegistrationService.getAll();
		mv.addObject("farmersList", allFarmersList);
		return mv;
	}

	@RequestMapping("addOrganisation")
	public ModelAndView addOrganisation(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("addOrganisation");
		return mv;
	}

	@RequestMapping("addRopeMaking")
	public ModelAndView addRopeMaking(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("ropeMaking");
		List<String> allDpcList  = purchaseCenterService.getAllDpc();
		mv.addObject("allDpcList", allDpcList);
		return mv;
	}

	@RequestMapping("allOrganisationList")
	public ModelAndView allOrganisationList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("organisationLists");
		List<AddOrganizationModel> organisationList = addOrganisationService.getAll();
		mv.addObject("organisationLists", organisationList);
		return mv;

	}

	@RequestMapping("saveOrganizationMid")
	public ModelAndView saveFarmerMid(HttpServletRequest request) {
		try {
			String organizationtypename = request.getParameter("organizationtypename");
			String organizationtypedisplayname = request.getParameter("organizationtypedisplayname");
			String ipaddress = request.getParameter("ipaddress");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			AddOrganizationModel addOrganizationModel = new AddOrganizationModel();
			addOrganizationModel.setIpaddress(ipaddress);
			addOrganizationModel.setIs_Active(1);
			addOrganizationModel.setOrganizationtypedisplayname(organizationtypedisplayname);
			addOrganizationModel.setOrganizationtypename(organizationtypename);
			addOrganizationModel.setCreateddate(new Date());
			addOrganisationService.create(addOrganizationModel);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(new RedirectView("addOrganisation.obj"));
	}

	@RequestMapping("ropeMakingListing")
	public ModelAndView ropeMaking(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("RopeMakingListing");
		List<RopeMakingModel> ropeList = ropeMakingService.getAll();
		mv.addObject("ropeLists", ropeList);
		return mv;
	}

	@RequestMapping("saveRopeMakingMid")
	public ModelAndView saveRopeMakingMid(HttpServletRequest request) {
		try {
			String datereport = request.getParameter("datereport");
			// System.out.println("datereport ======= "+datereport);
			int creadtedby = 0;
			String basis = request.getParameter("basis");
			String cropyr = request.getParameter("cropyr");
			String placeofactivity = request.getParameter("placeofactivity");
			String jutevariety = request.getParameter("jutevariety");
			String ropemade = request.getParameter("ropemade");
			String ropeUsed = request.getParameter("ropeUsed");
			String balance = request.getParameter("balance");
			String ipaddress = request.getParameter("ipaddress");
			String binno = request.getParameter("binno");
			String rateSlipNoFrom = request.getParameter("rateslipno");
			RopeMakingModel addRopeMaking = new RopeMakingModel();
			addRopeMaking.setBasis(basis);
			addRopeMaking.setBinno(binno);
			addRopeMaking.setCreadtedby(creadtedby);
			// addRopeMaking.setCreateddate(createddate);
			addRopeMaking.setCropyr(cropyr);
			addRopeMaking.setDatereport(datereport);
			addRopeMaking.setIpaddress(ipaddress);
			addRopeMaking.setJutevariety(jutevariety);
			addRopeMaking.setPlaceofactivity(placeofactivity);
			addRopeMaking.setRopemade(Integer.parseInt(ropemade));
			addRopeMaking.setRopeused(Integer.parseInt(ropeUsed));
			addRopeMaking.setRope_balance(Integer.parseInt(balance));
			addRopeMaking.setCreateddate(new Date());
			ropeMakingService.create(addRopeMaking);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(new RedirectView("addRopeMaking.obj"));

	}

	@RequestMapping("jciSales")
	public ModelAndView jciSales(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("addJciSales");
		return mv;
	}

	@RequestMapping("saveSalesMid")
	public ModelAndView saveSales(HttpServletRequest request) {
		try {
			int uniqueNumber = Integer.parseInt(request.getParameter("uniqueNumber"));
			String juteVariety = request.getParameter("jutevariety");
			String vargradeqty = request.getParameter("vargradeqty");
			SalesModel salesModel = new SalesModel();
			salesModel.setCreadtedby(1);
			salesModel.setJutevariety(juteVariety);
			salesModel.setUnqno(22);
			salesModel.setVargradeqty(vargradeqty);
			salesService.create(salesModel);
		} catch (Exception e) {
			System.out.println(e);
		}

		return new ModelAndView(new RedirectView("addJciSales.obj"));
	}

	@RequestMapping("farmerRegistration")
	public ModelAndView farmerRegistration(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("FarmerRegistration");
		mv.addObject("dpcCode", "0122");
		return mv;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "pIcon", method = RequestMethod.GET)
	public String getFoosBySimplePath(HttpServletRequest request) {
		String str = request.getParameter("F_District");
		Gson gson = new Gson();
		return gson.toJson(distric.getAllFilledPosition(str));
	}

	@RequestMapping("saveFarmerRegistrationMid")
	public ModelAndView FarmerRegistrationSave(HttpServletRequest request, RedirectAttributes redirectAttributes,
			@RequestParam("F_ID_PROF") MultipartFile F_ID_PROF, @RequestParam("F_BANK_DOC") MultipartFile F_BANK_DOC,
			@RequestParam("F_REG_FORM") MultipartFile F_REG_FORM) {
		ModelAndView mv = new ModelAndView();
		try {
			String F_NAME = request.getParameter("F_NAME");
			String caste = request.getParameter("caste");
			String gender = request.getParameter("gender");
			String F_ADDRESS = request.getParameter("F_ADDRESS");
			String F_ID_PROF_TYPE = request.getParameter("F_ID_PROF_TYPE");
			String F_ID_PROF_NO = request.getParameter("F_ID_PROF_No");
			String F_REG_BY = request.getParameter("F_REG_BY");
			String F_I_CARE_REGISTERED = request.getParameter("F_I_CARE_REGISTERED");
			String land_holding = request.getParameter("land_holding");
			String F_MOBILE = request.getParameter("F_MOBILE");
			String state=request.getParameter("state");	
			String F_District=request.getParameter("F_District");
			System.out.print(" ...................."+F_District);
			String F_Block=request.getParameter("F_Block");
			String F_Pincode=request.getParameter("pincode");
			String police_station = request.getParameter("police_station");
			System.out.print(" ...................."+police_station);


			String F_AC_NO = request.getParameter("F_AC_NO");
			String bank_ac_type = request.getParameter("bank_ac_type");
			String F_BANK_NAME = request.getParameter("F_BANK_NAME");
			String F_BANK_BRANCH = request.getParameter("F_BANK_BRANCH");
			String F_BANK_IFSC = request.getParameter("F_BANK_IFSC");
			// String F_REG_FORM = request.getParameter("F_REG_FORM");
			String F_Address2 = request.getParameter("F_Address2");
			String duplicateMobiileNo = request.getParameter("dubMobile");
			boolean duplicateMobiile = Boolean.parseBoolean(duplicateMobiileNo);
			String fileUpload = F_ID_PROF.getOriginalFilename();
			String duplicateAccNo = request.getParameter("accNoCheck");
			boolean accountBool = Boolean.parseBoolean(duplicateAccNo);
			String F_BANK_DOCupload = F_BANK_DOC.getOriginalFilename();
			FarmerRegModel farmerRegModel = new FarmerRegModel();
			farmerRegModel.setF_NAME(F_NAME);
			farmerRegModel.setCaste(caste);
			farmerRegModel.setGender(gender);
			farmerRegModel.setF_ADDRESS(F_ADDRESS);
			farmerRegModel.setF_ID_PROF_TYPE(F_ID_PROF_TYPE);
			farmerRegModel.setBank_ac_type(bank_ac_type);
			farmerRegModel.setF_ID_PROF_NO(F_ID_PROF_NO);
			farmerRegModel.setF_REG_BY(F_REG_BY);
			farmerRegModel.setF_I_CARE_REGISTERED(F_I_CARE_REGISTERED);
			farmerRegModel.setLand_holding(land_holding);
			farmerRegModel.setF_MOBILE((F_MOBILE));
			farmerRegModel.setF_AC_NO(F_AC_NO);
			farmerRegModel.setF_Pincode(F_Pincode);

			farmerRegModel.setF_STATE(state);
			farmerRegModel.setF_Block(F_Block);
			farmerRegModel.setF_District(F_District);
			
			farmerRegModel.setPolice_station(police_station);
		
			


			farmerRegModel.setBank_ac_type(bank_ac_type);
			farmerRegModel.setF_BANK_NAME(F_BANK_NAME);
			farmerRegModel.setF_BANK_BRANCH(F_BANK_BRANCH);
			farmerRegModel.setF_BANK_IFSC(F_BANK_IFSC);
			// farmerRegModel.setReg_form(F_REG_FORM);
			farmerRegModel.setF_Address2(F_Address2);
			farmerRegModel.setF_Pincode(F_Pincode);
			farmerRegModel.setIS_VERIFIED(0);
			// farmerRegModel.setF_REG_NO("06" +F_REG_BY +"0000"+count++);
			// farmerRegModel.setF_BANK_DOC(F_BANK_DOC);
			// farmerRegModel.setF_DOC_PATH(F_DOC_PATH);
			// farmerRegModel.setF_ID_PROF(F_ID_PROF);
			/* farmerRegModel.setF_DOC_PATH(F_DOC_PATHupload); */
			// farmerRegModel.setF_UPDATED_BY(f_UPDATED_BY);
			// farmerRegModel.setF_VERFIED_DATE(F_VERFIED_DATE);
			File file = null;
			String pathurl = "";
			// Farmer id proof upload
			try {
				String url = "";

				// farmer Bank Document
				if (F_BANK_DOC.isEmpty() != true) {
					file = new File(farmerUpload + F_BANK_DOC.getOriginalFilename());
					try {
						OutputStream os = new FileOutputStream(file);
						os.write(F_BANK_DOC.getBytes());
						os.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pathurl = file.getAbsolutePath();
					String path = farmerUpload + F_BANK_DOC.getOriginalFilename();
					url = path;
					farmerRegModel.setF_BANK_DOC(url);
					// userquery.setQueryurl(user.getIdUser()+""+"_"+mfile.getOriginalFilename());
				}

				// farmer ID Proof
				if (F_ID_PROF.isEmpty() != true) {
					file = new File(farmerUpload + F_ID_PROF.getOriginalFilename());
					try {
						OutputStream os = new FileOutputStream(file);
						os.write(F_ID_PROF.getBytes());
						os.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					pathurl = file.getAbsolutePath();
					String path = farmerUpload + F_ID_PROF.getOriginalFilename();
					url = path;
					farmerRegModel.setF_ID_PROF(url);
					// userquery.setQueryurl(user.getIdUser()+""+"_"+mfile.getOriginalFilename());
				}

				// farmer ID Proof
				if (F_REG_FORM.isEmpty() != true) {
					file = new File(farmerUpload + F_REG_FORM.getOriginalFilename());
					try {
						OutputStream os = new FileOutputStream(file);
						os.write(F_REG_FORM.getBytes());
						os.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					pathurl = file.getAbsolutePath();
					String path = farmerUpload + F_REG_FORM.getOriginalFilename();
					url = path;
					farmerRegModel.setF_REG_FORM(url);
				}

				//
				//					if (F_ID_PROF.isEmpty() != true) {
				//						try {
				//							Files.copy(F_ID_PROF.getInputStream(),
				//								Paths.get(farmerUpload + F_ID_PROF.getOriginalFilename()),
				//								StandardCopyOption.REPLACE_EXISTING);
				//						} catch (Exception e) {
				//							e.printStackTrace();
				//						}
				//						String path = farmerUpload + F_ID_PROF.getOriginalFilename();
				//						url = path;
				//						farmerRegModel.setF_ID_PROF(url);
				//					}
				//					
				//					// farmer bank document
				//					if (F_BANK_DOC.isEmpty() != true) {
				//						try {
				//							Files.copy(F_BANK_DOC.getInputStream(),
				//									Paths.get(farmerUpload + F_BANK_DOC.getOriginalFilename()),
				//									StandardCopyOption.REPLACE_EXISTING);
				//						} catch (Exception e) {
				//							e.printStackTrace();
				//						}
				//						String path = farmerUpload + F_BANK_DOC.getOriginalFilename();
				//						url = path;
				//						farmerRegModel.setF_BANK_DOC(url);
				//					}
				//					
				//					// farmer bank form
				//					if (F_REG_FORM.isEmpty() != true) {
				//						try {
				//							Files.copy(F_REG_FORM.getInputStream(),
				//									Paths.get(farmerUpload + F_REG_FORM.getOriginalFilename()),
				//									StandardCopyOption.REPLACE_EXISTING);
				//						} catch (Exception e) {
				//							e.printStackTrace();
				//						}
				//						String path = farmerUpload + F_REG_FORM.getOriginalFilename();
				//						url = path;
				//						farmerRegModel.setF_REG_FORM(url);
				//					}

				// mv.addObject("msg", "Farmer Registered Successfully");
			} catch (Exception e) {
				System.out.println(e);
				// TODO: handle exception
				mv.addObject("msg", "Not Save please try again");
			}

			if (accountBool == true && duplicateMobiile == true) {
				farmerRegService.create(farmerRegModel);
				redirectAttributes.addFlashAttribute("msg",
						"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"
								+ "");
			} else {
				redirectAttributes.addFlashAttribute("msg",
						"<div class=\"alert alert-danger\"><b>OOps!</b> Duplicate account number or mobile number or Identitiy Proof Number.</div>\r\n"
								+ "");
			}
		} catch (Exception e) {
			System.out.println(e);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-danger\"><b>Oops !</b> Error in saving record. Please try again</div>\r\n"
							+ "");
		}
		return new ModelAndView(new RedirectView("FarmerRegistration.obj"));
	}

	@RequestMapping("rawJutePaymentAndProcurement")
	public ModelAndView rawJutePaymentAndProcurement(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("RawJutePaymentAndProcurement");
		//List<purchaseCenterService> dpcCeneter = purchaseCenterService.getAll();
		//mv.addObject("dpcCeneter", dpcCeneter);
		return mv;
	}

	@RequestMapping("balePreparation")
	public ModelAndView balePreparation(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("balePrepare");
		List<String> allDpcList  = purchaseCenterService.getAllDpc();
		mv.addObject("allDpcList", allDpcList);
		return mv;
	}
	
	@RequestMapping("saveBalePreparation")
	public ModelAndView saveBalePreparation(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		try {
			// String datereport = request.getParameter("datereport");
			int creadtedby = 0;
			String dpcname = request.getParameter("dpcname");
			String cropyr = request.getParameter("cropyr");
			String jutevariety = request.getParameter("jutevariety");
			String binnumb = request.getParameter("binnumb");
			String basis = request.getParameter("basis");
			String carryforward = request.getParameter("carryforward");
			String carryforwarsrope = request.getParameter("carryforwarsrope");
			BalePreparationModel balePrepare = new BalePreparationModel();
			balePrepare.setDpcnames(dpcname);
			balePrepare.setCropyr(cropyr);
			balePrepare.setJutevariety(jutevariety);
			balePrepare.setBinnumber(binnumb);
			balePrepare.setBasis(basis);
			balePrepare.setCarryoverlossqty(carryforward);
			balePrepare.setCarryropeqty(carryforwarsrope);
			// balePrepare.setCreateddate(new Date());
			balepreparationservice.create(balePrepare);
			redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(new RedirectView("balePreparation.obj"));

	}

	//	@RequestMapping("BalePreparationList")
	//	public ModelAndView BalePreparationList(HttpServletRequest request) {
	//		ModelAndView mv = new ModelAndView("BalePrepList");
	//		List<BalePreparationModel> bale = balepreparationservice.getAll();
	//		mv.addObject("baleslis", bale);
	//		return mv;
	//	}

	@RequestMapping("BaleDelete")
	public ModelAndView locatorDelete(HttpServletRequest request, RedirectAttributes redirectAttributes)
			throws ParseException {
		ModelAndView mv = new ModelAndView("BalePrepList");
		int id = Integer.parseInt(request.getParameter("id"));
		balepreparationservice.delete(id);
		List<BalePreparationModel> bale = balepreparationservice.getAll();
		mv.addObject("baleslis", bale);

		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> List deleted successfully.</div>\r\n" + "");
		return new ModelAndView(new RedirectView("BalePreparationList.obj"));
		// return mv;
	}

	@RequestMapping("BalePreparationList")
	public ModelAndView BalePreparationList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("BalePrepList");
		List<BalePreparationModel> bale = balepreparationservice.getAll();
		mv.addObject("baleslis", bale);
		return mv;
	}

	@RequestMapping(value = { "editBaleList" }, method = { RequestMethod.GET })
	public ModelAndView editBaleList(final HttpServletRequest request) {
		final ModelAndView mv = new ModelAndView("EditBale");
		if (request.getParameter("id") != null) {
			final int id = Integer.parseInt(request.getParameter("id"));
			final BalePreparationModel editBaleList = this.balepreparationservice.find(id);
			mv.addObject("editBaleList", (Object)editBaleList);
		}
		return mv;
	}

	@RequestMapping({ "saveBaleList" })
	public ModelAndView saveBaleList(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView();
		try {
			String id = request.getParameter("id");
			String dpcname = request.getParameter("dpcname");
			String cropyr = request.getParameter("cropyr");
			String binnumb = request.getParameter("binnumb");
			String jutevariety = request.getParameter("jutevariety");
			String basis = request.getParameter("basis");
			String carryforward = request.getParameter("carryforward");
			String carryforwarsrope = request.getParameter("carryforwarsrope");
			BalePreparationModel balePrepare = new BalePreparationModel();
			balePrepare.setId(Integer.parseInt(id));
			balePrepare.setDpcnames(dpcname);
			balePrepare.setCropyr(cropyr);
			balePrepare.setJutevariety(jutevariety);
			balePrepare.setBinnumber(binnumb);
			balePrepare.setBasis(basis);
			balePrepare.setCarryoverlossqty(carryforward);
			balePrepare.setCarryropeqty(carryforwarsrope);
			// farmer Bank Document
			balepreparationservice.create(balePrepare);
			redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record Edit successfully.</div>\r\n");
		}
		catch (Exception e) {
			System.out.println(e);
			redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-dange\"><b>Failure!</b> Error While saving record. Please try againn</div>\r\n");
		}
		return new ModelAndView((View)new RedirectView("BalePreparationList.obj"));
	}

	@RequestMapping("jbaRate")
	public ModelAndView jbaRate(HttpServletRequest request) {
		List<AreaDetailCode> AreaCode = areaService.getAll();

		ModelAndView mv = new ModelAndView("addJba");
		mv.addObject("AreaCode", AreaCode);
		return mv;
	}

	@RequestMapping("saveJbaRate")
	public ModelAndView saveJbaRate(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		try {
			int creadtedby = 0;
			String datejba = request.getParameter("datejba");
			// System.out.println("datejba from controller is"+datejba);
			String jutevariety = request.getParameter("jutevariety");
			String areacode = request.getParameter("areacode");
			String cropyr = request.getParameter("cropyr");

			String gradewisepp = request.getParameter("gradewisepp");
			String grade1 = request.getParameter("gradewisepp1");
			String grade2 = request.getParameter("gradewisepp2");
			String grade3 = request.getParameter("gradewisepp3");
			String grade4 = request.getParameter("gradewisepp4");
			String grade5 = request.getParameter("gradewisepp5");
			String grade6 = request.getParameter("gradewisepp6");
			String grade7 = request.getParameter("gradewisepp7");
			String grade8 = request.getParameter("gradewisepp8");
			
			
			
			
			
			JbaModel jbapri = new JbaModel();
			jbapri.setJbaDate(datejba);
			jbapri.setJutevariety(jutevariety);
			jbapri.setAreaCode(areacode);
			jbapri.setCropyr(cropyr);
			jbapri.setGradeWisePrice(gradewisepp);
			if(grade1!=null) {
				
				jbapri.setGradewisepp1(Double.parseDouble(grade1));
			}
			
			if(grade2!=null) {
				jbapri.setGradewisepp2(Double.parseDouble(grade2));
			}
			if(grade3!=null) {
				
				jbapri.setGradewisepp3(Double.parseDouble(grade3));
			}
			if(grade4!=null) {
				
				jbapri.setGradewisepp4(Double.parseDouble(grade4));
			}
			if(grade5!=null) {
				
				jbapri.setGradewisepp5(Double.parseDouble(grade5));
			}
			if(grade6!=null) {
				jbapri.setGradewisepp6(Double.parseDouble(grade6));
			}
			if(grade7!=null) {
				jbapri.setGradewisepp7(Double.parseDouble(grade7));
			}
			if(grade8!=null) {
				jbapri.setGradewisepp8(Double.parseDouble(grade8));
			}
			jbaservice.create(jbapri);
			redirectAttributes.addFlashAttribute("msg","<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(new RedirectView("jbaRate.obj"));
	}

	@RequestMapping("JbaPriceList")
	public ModelAndView JbaPriceList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("JBAList");
		List<JbaModel> jbapri = jbaservice.getAll();
		mv.addObject("jbaList", jbapri);
		return mv;
	}


	@RequestMapping(value = { "editJBAList" }, method = { RequestMethod.GET })
	public ModelAndView editJBAList(final HttpServletRequest request) {
		final ModelAndView mv = new ModelAndView("EditJBA");
		if (request.getParameter("id") != null) {
			final int id = Integer.parseInt(request.getParameter("id"));
			final JbaModel editJBAList = this.jbaservice.find(id);
			mv.addObject("editJBAList", (Object)editJBAList);
		}
		return mv;
	}

	@RequestMapping({ "saveJBAList" })
	public ModelAndView saveJBAList(HttpServletRequest request, RedirectAttributes redirectAttributes

			) {
		ModelAndView mv = new ModelAndView();
		try {
			String id = request.getParameter("id");
			String datejba = request.getParameter("datejba");
			String jutevariety = request.getParameter("jutevariety");
			String areacode = request.getParameter("areacode");
			String cropyr = request.getParameter("cropyr");
			String gradewisepp = request.getParameter("gradewisepp");
			String grade1 = request.getParameter("gradewisepp1");
			String grade2 = request.getParameter("gradewisepp2");
			String grade3 = request.getParameter("gradewisepp3");
			String grade4 = request.getParameter("gradewisepp4");
			String grade5 = request.getParameter("gradewisepp5");
			String grade6 = request.getParameter("gradewisepp6");
			String grade7 = request.getParameter("gradewisepp7");
			String grade8 = request.getParameter("gradewisepp8");
			JbaModel jbapri = new JbaModel();
			jbapri.setId(Integer.parseInt(id));
			jbapri.setJbaDate(datejba);
			jbapri.setJutevariety(jutevariety);
			jbapri.setAreaCode(areacode);


			jbapri.setCropyr(cropyr);
			jbapri.setGradeWisePrice(gradewisepp);
if(grade1!=null) {
				
				jbapri.setGradewisepp1(Double.parseDouble(grade1));
			}
			
			if(grade2!=null) {
				jbapri.setGradewisepp2(Double.parseDouble(grade2));
			}
			if(grade3!=null) {
				
				jbapri.setGradewisepp3(Double.parseDouble(grade3));
			}
			if(grade4!=null) {
				
				jbapri.setGradewisepp4(Double.parseDouble(grade4));
			}
			if(grade5!=null) {
				
				jbapri.setGradewisepp5(Double.parseDouble(grade5));
			}
			if(grade6!=null) {
				jbapri.setGradewisepp6(Double.parseDouble(grade6));
			}
			if(grade7!=null) {
				jbapri.setGradewisepp7(Double.parseDouble(grade7));
			}
			if(grade8!=null) {
				jbapri.setGradewisepp8(Double.parseDouble(grade8));
			}


			// farmer Bank Document


			jbaservice.create(jbapri);
			redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-success\"><b>Success !</b> Record Edit successfully.</div>\r\n");
		}
		catch (Exception e) {
			System.out.println(e);
			redirectAttributes.addFlashAttribute("msg", (Object)"<div class=\"alert alert-dange\"><b>Failure!</b> Error While saving record. Please try againn</div>\r\n");
		}
		return new ModelAndView((View)new RedirectView("JbaPriceList.obj"));
	}

	@RequestMapping("JbaDelete")
	public ModelAndView JbaDelete(HttpServletRequest request, RedirectAttributes redirectAttributes)
			throws ParseException {
		ModelAndView mv = new ModelAndView("JBAList");
		int id = Integer.parseInt(request.getParameter("id"));
		jbaservice.delete(id);
		JbaModel jbapric = new JbaModel();
		List<JbaModel> jbap = jbaservice.getAll();
		mv.addObject("baleslis", jbap);
		redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> List deleted successfully.</div>\r\n" + "");
		return new ModelAndView(new RedirectView("JbaPriceList.obj"));
		// return mv;
	}

	@RequestMapping("rawJuteProcurementAndPaymentMid")
	public ModelAndView rawJuteProcurementAndPaymentMid(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		try {
			String ipAddress = null;
			String getWay = request.getHeader("VIA"); // Gateway
			ipAddress = request.getHeader("X-FORWARDED-FOR"); // proxy
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
			}
			RawJuteProcurementAndPayment rawJuteProcAndPay = new RawJuteProcurementAndPayment();
			
			  String farmerregno = request.getParameter("farmerregno"); 
			  int formno = Integer.parseInt(request.getParameter("formno"));
			  
			  String datepurchase=request.getParameter("datepurchase"); 
			  String basis = request.getParameter("basis"); 
			 
			  String cropyr =request.getParameter("cropyr"); 
			  String placeofpurchase =request.getParameter("placeofpurchase");
			  
			  String rateslipno = request.getParameter("rateslipno"); 
			  String binno =request.getParameter("binno"); 
			  
			  String jutevariety =request.getParameter("jutevariety");
			  String gquantity =request.getParameter("gquantity");
			   
			  String dquantity = request.getParameter("deductionQuantity");
			  String netquantity = request.getParameter("netquantity"); 
			 
			  String garsatRate =request.getParameter("garsatRate"); 
			  String tallyslipno =request.getParameter("tallyslipno"); 
			  
			  String regFarmer = request.getParameter("regFarmer");
			  String regMolile = request.getParameter("regMolile");
			  
			  String tdbaseprice = request.getParameter("tdbaseprice");
			
			int dpcid = (Integer) request.getSession().getAttribute("dpcId");
		
			int createdBy = (Integer) request.getSession().getAttribute("userId");
			
			String grade0=request.getParameter("g0");
			String grade1=request.getParameter("g1");
			String grade2=request.getParameter("g2");
			String grade3=request.getParameter("g3");
			String grade4=request.getParameter("g4");
			String grade5=request.getParameter("g5");
			String grade6=request.getParameter("g6");
			String grade7=request.getParameter("g7");
			/*System.out.println("grade0   "+grade0);
			System.out.println("grade1   "+grade1);
			System.out.println("grade2   "+grade2);
			System.out.println("grade3   "+grade3);
			System.out.println("grade4   "+grade4);
			System.out.println("grade5   "+grade5);
			System.out.println("grade6   "+grade6);
			System.out.println("grade07   "+grade7);*/
			
			if(grade0!=null && grade0!="0") {
				rawJuteProcAndPay.setGrade1(Double.parseDouble(grade0));
			}
			if(grade1!=null && grade1!="0") {
				
				rawJuteProcAndPay.setGrade2(Double.parseDouble(grade1));
			}
			if(grade2!=null && grade2!="0") {
				
				rawJuteProcAndPay.setGrade3(Double.parseDouble(grade2));
			}
			if(grade3!=null && grade3!="0") {
				
				rawJuteProcAndPay.setGrade4(Double.parseDouble(grade3));
			}
			if(grade4!=null && grade4!="0") {
				
				rawJuteProcAndPay.setGrade5(Double.parseDouble(grade4));
			}
			if(grade5!=null && grade5!="0") {
				
				rawJuteProcAndPay.setGrade6(Double.parseDouble(grade5));
			}
			if(grade6!=null && grade6!="0") {
				
				rawJuteProcAndPay.setGrade7(Double.parseDouble(grade6));
			}
			if(grade7!=null && grade7!="0" ) {
				
				rawJuteProcAndPay.setGrade8(Double.parseDouble(grade7));
			}
			
			  rawJuteProcAndPay.setBasis(basis);
			  rawJuteProcAndPay.setBinno(Integer.parseInt(binno));
			  rawJuteProcAndPay.setCreateddate(new Date());
			  rawJuteProcAndPay.setCropyr(cropyr); 
			  rawJuteProcAndPay.setFormno(formno);
			  rawJuteProcAndPay.setIpaddress(ipAddress);
			  rawJuteProcAndPay.setGrossquantity(Float.parseFloat(gquantity));
			  rawJuteProcAndPay.setIpaddress(ipAddress);
			  rawJuteProcAndPay.setJutevariety(jutevariety);
			  rawJuteProcAndPay.setNetquantity(Float.parseFloat(netquantity));
			  rawJuteProcAndPay.setPlaceofpurchase(placeofpurchase);
			  rawJuteProcAndPay.setRateslipno(Integer.parseInt(rateslipno));
			  rawJuteProcAndPay.setDeductionquantity(Float.parseFloat(dquantity));
			  rawJuteProcAndPay.setGrasatrate(Float.parseFloat(garsatRate));
			  
			  rawJuteProcAndPay.setFarmerregno((farmerregno));
			  rawJuteProcAndPay.setCreadtedby(createdBy);
			  rawJuteProcAndPay.setDateof_entry(new Date());
			  rawJuteProcAndPay.setTd_base(tdbaseprice);
			  rawJuteProcAndPay.setTallyslipno(tallyslipno);
			  
			  if(basis=="msp") {
				  String amountPayable =request.getParameter("amountPayable");
			  rawJuteProcAndPay.setAmountpayable(Float.parseFloat(amountPayable));
			  }
			if(farmerregno==null || farmerregno=="") {
			
				redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-warning\"><b>Oops! </b> Please enter correct registartion number.</div>\r\n" + "");
			}else {
			System.out.println("else part of controller");
				rawJuteProcurAndPayService.create(rawJuteProcAndPay);
				redirectAttributes.addFlashAttribute("msg",
					 "<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
			}			
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		return new ModelAndView(new RedirectView("rawJutePaymentAndProcurement.obj"));
	}

	@RequestMapping("juteProcurementList")
	public ModelAndView juteProcurementList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("juteProcurementList");
		List<RawJuteProcurementAndPayment> procurementList = new ArrayList<RawJuteProcurementAndPayment>();
		try {
			procurementList = rawJuteProcurAndPayService.getAll();
		} catch (Exception e) {
			System.out.println(e);
		}
		mv.addObject("procurementList", procurementList);
		return mv;
	}

	@RequestMapping("dailyPurchaseConf")
	public ModelAndView dailyPurchaseConf(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("DailyPurchaseConf");
		return mv;
	}

	@RequestMapping("dailyPurchaseMid")
	public ModelAndView dailyPurchaseMid(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		try {
			String ipAddress = null;
			String getWay = request.getHeader("VIA"); // Gateway
			ipAddress = request.getHeader("X-FORWARDED-FOR"); // proxy
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
			}
			
			String grade0=request.getParameter("g0");
			String grade1=request.getParameter("g1");
			String grade2=request.getParameter("g2");
			String grade3=request.getParameter("g3");
			String grade4=request.getParameter("g4");
			String grade5=request.getParameter("g5");
			String grade6=request.getParameter("g6");
			String grade7=request.getParameter("g7");
			System.out.println("grade0   "+grade0);
			System.out.println("grade1   "+grade1);
			System.out.println("grade2   "+grade2);
			System.out.println("grade3   "+grade3);
			System.out.println("grade4   "+grade4);
			System.out.println("grade5   "+grade5);
			System.out.println("grade6   "+grade6);
			System.out.println("grade07   "+grade7);
			
			
			String formno = request.getParameter("formno");
			// String datepurchase = request.getParameter("datepurchase");
			String basis = request.getParameter("basis");
			String cropyr = request.getParameter("cropyr");
			String placeofpurchase = request.getParameter("placeofpurchase");
			String binno = request.getParameter("binno");
			String jutevariety = request.getParameter("jutevariety");
			String gquantity = request.getParameter("gquantity");
			String dquantity = request.getParameter("dquantity");
			String netquantity = request.getParameter("netquantity");
			String fibervalue = request.getParameter("fibervalue");
			int createdBy = (Integer) request.getSession().getAttribute("userId");
			String rateslipno = request.getParameter("rateslipno");
			DailyPurchaseConfModel DailyPurchase = new DailyPurchaseConfModel();
			DailyPurchase.setBasis(basis);
			DailyPurchase.setBinno(Integer.parseInt(binno));
			DailyPurchase.setCropyr(cropyr);
			DailyPurchase.setDquantity(Double.parseDouble(dquantity));
			DailyPurchase.setFibervalue(Integer.parseInt(fibervalue));
			DailyPurchase.setFormno((formno));
			DailyPurchase.setGquantity(Double.parseDouble(gquantity));
			DailyPurchase.setIpaddresss(ipAddress);
			DailyPurchase.setJutevariety(jutevariety);
			DailyPurchase.setNetquantity(Double.parseDouble(netquantity));
			DailyPurchase.setPlaceofpurchase(placeofpurchase);
			DailyPurchase.setCreatedby(createdBy);
			DailyPurchase.setRateslipno(rateslipno);
			System.out.println(DailyPurchase.toString());
			DailyPurchasefService.create(DailyPurchase);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(new RedirectView("dailyPurchaseConf.obj"));
	}

	@RequestMapping("dailyPurchaseList")
	public ModelAndView dailyPurchaseList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("dailyPurchaseLIst");
		List<DailyPurchaseConfModel> purchaseList = DailyPurchasefService.getAll();
		mv.addObject("dailyPurchaseList", purchaseList);
		return mv;
	}

	@RequestMapping("saveBalePreparationMid")
	public ModelAndView saveBalePreparationMid(HttpServletRequest request) {
		try {
			String ipAddress = null;
			String getWay = request.getHeader("VIA"); // Gateway
			ipAddress = request.getHeader("X-FORWARDED-FOR"); // proxy
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
			}
			String dateofpacking = request.getParameter("dateofpacking");
			String basis = request.getParameter("basis");
			String cropyr = request.getParameter("cropyr");
			String placeofpacking = request.getParameter("placeofpacking");
			String binno = request.getParameter("binno");
			String jutevariety = request.getParameter("jutevariety");
			String jutegrade = request.getParameter("jutegrade");
			String balecheckslipnofrom = request.getParameter("balecheckslipnofrom");
			String balecheckslipnoto = request.getParameter("balecheckslipnoto");
			String numberofbales = request.getParameter("numberofbales");
			ProgOfAssortmentModel progOfAssortmentModel = new ProgOfAssortmentModel();
			progOfAssortmentModel.setBalecheckslipnofrom(balecheckslipnofrom);
			progOfAssortmentModel.setBalecheckslipnoto(balecheckslipnoto);
			progOfAssortmentModel.setBasis(basis);
			progOfAssortmentModel.setCreateddate(new Date());
			progOfAssortmentModel.setCropyr(cropyr);
			progOfAssortmentModel.setDateofpacking(dateofpacking);
			progOfAssortmentModel.setIpaddress(ipAddress);
			progOfAssortmentModel.setJutegrade(Integer.parseInt(jutegrade));
			progOfAssortmentModel.setJutevariety(jutevariety);
			progOfAssortmentModel.setNumberofbales(Integer.parseInt(numberofbales));
			progOfAssortmentModel.setPlaceofpacking(placeofpacking);
			progOfAssortmentModel.setBinno(binno);
			progOfAssortmentService.create(progOfAssortmentModel);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(new RedirectView("balePreparation.obj"));
	}

	@RequestMapping("marketArrival")
	public ModelAndView marketArrival(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("marketArrival");
		return mv;
	}

	@RequestMapping("saveMarketArrivalMid")
	public ModelAndView saveMarketArrivalMid(HttpServletRequest request) {
		try {
			String ipAddress = null;
			String getWay = request.getHeader("VIA"); // Gateway
			ipAddress = request.getHeader("X-FORWARDED-FOR"); // proxy
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
			}
			String dpcnames = request.getParameter("dpcnames");
			// date format from html calender to database format change code below
			String datearrival = request.getParameter("datearrival");
			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = formatter1.parse(datearrival);
			// date format change code end here
			String jutevariety = request.getParameter("jutevariety");
			String cropyr = request.getParameter("cropyr");
			String arrivedqty = request.getParameter("arrivedqty");
			String mixmois = request.getParameter("mixmois");
			String esgradeoutturn = request.getParameter("esgradeoutturn");
			String maxmois = request.getParameter("maxmois");
			MarketArrivalModel marketArrival = new MarketArrivalModel();
			marketArrival.setArrivedqty(arrivedqty);
			// marketArrival.setCreadtedby(1);
			marketArrival.setCreateddate(new Date());
			// marketArrival.setCreatedfrom(createdfrom);
			marketArrival.setCropyr(cropyr);
			marketArrival.setDatearrival(date1);
			marketArrival.setDpcnames(dpcnames);
			marketArrival.setEsgradeoutturn(esgradeoutturn);
			marketArrival.setIpaddress(ipAddress);
			marketArrival.setJutevariety(jutevariety);
			marketArrival.setMaxmois(maxmois);
			marketArrival.setMixmois(mixmois);
			marketArrivalService.create(marketArrival);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(new RedirectView("marketArrival.obj"));
	}

	@RequestMapping("UserRegistration")
	public ModelAndView userRegistration(HttpServletRequest request) {
		List<ZoneModel> zoneList = zoneService.getAll();
		List<RoleMasterModel> roleList = roleService.getAll();
		ModelAndView mv = new ModelAndView("UserRegistration");
		mv.addObject("zoneList", zoneList);
		mv.addObject("roleList", roleList);

		return mv;
	}

	@RequestMapping("saveUserMid")
	public ModelAndView saveUserMid(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		try {
			String ipAddress = null;
			String getWay = request.getHeader("VIA"); // Gateway
			ipAddress = request.getHeader("X-FORWARDED-FOR"); // proxy
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
			}
			String ho = request.getParameter("ho");
			String zone = request.getParameter("zone");
			String region = request.getParameter("region");
			String centerordpc = request.getParameter("centerordpc");
			String employeeid = request.getParameter("employeeid");
			String employeename = request.getParameter("employeename");
			String email = request.getParameter("emailAddress");
			String mobileno = request.getParameter("mobile");
			String password = request.getParameter("password");
			String usertype = request.getParameter("usertype");
			String duplicateEmail = request.getParameter("emailCheck");
			boolean duplicatemail = Boolean.parseBoolean(duplicateEmail);
			UserRegistrationModel userRegistration = new UserRegistrationModel();
			userRegistration.setDpcId(centerordpc);
			userRegistration.setDatelastchangepassword(new Date());
			userRegistration.setEmail(email);
			userRegistration.setEmployeeid(employeeid);
			userRegistration.setEmployeename(employeename);
			userRegistration.setHo(Integer.parseInt(ho));
			userRegistration.setIpaddress(ipAddress);
			userRegistration.setIs_active(1);
			userRegistration.setMobileno(mobileno);
			userRegistration.setPassword(password);
			if (!ho.equals("1")) {
				userRegistration.setRegion(region);
				userRegistration.setZone(zone);
			}
			userRegistration.setRegistrationdate(new Date());
			userRegistration.setUsername(email);
			userRegistration.setUsertype(usertype);
			userRegistration.setRoleId(Integer.parseInt(usertype));
			boolean emailNotExist = UserRegistrationService.validateEmail(email);
			if (emailNotExist == true) {
				UserRegistrationService.create(userRegistration);
				redirectAttributes.addFlashAttribute("msg",
						"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n"
								+ "");
			} else {
				redirectAttributes.addFlashAttribute("msg",
						"<div class=\"alert alert-warning\"><b>OOps!</b> Duplicate email id.</div>\r\n" + "");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(new RedirectView("UserRegistration.obj"));
	}

	@ResponseBody
	@RequestMapping(value = "findRoByZone", method = RequestMethod.GET)
	public String findRoByZone(HttpServletRequest request) {
		Gson gson = new Gson();
		//System.out.println(roService.zonecode(request.getParameter("id")));
		return gson.toJson(roService.zonecode(request.getParameter("id")));
	}

	@RequestMapping("viewmarketArrival")
	public ModelAndView viewmarketArrival(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("viewmarketArrival");
		List<MarketArrivalModel> allmarketArrivalList = marketArrivalService.getAll();
		mv.addObject("marketArrivalList", allmarketArrivalList);
		return mv;
	}

	@RequestMapping("ViewFarmerRegistration")
	public ModelAndView viewFarmerLists(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("ViewFarmerRegistration");
		List<FarmerRegModelDTO> allFarmersList = farmerRegService.verificationStatus();
		mv.addObject("allFarmersList", allFarmersList);
		return mv;
	}

	@RequestMapping("viewjcisales")
	public ModelAndView viewsalesList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("viewjcisales");
		List<SalesModel> allviewsalesList = salesService.getAll();
		mv.addObject("salesList", allviewsalesList);
		return mv;
	}

	/*
	 * @RequestMapping("viewbalePreparation") public ModelAndView
	 * balePreparationList(HttpServletRequest request) { ModelAndView mv = new
	 * ModelAndView("viewbalePreparation"); List<ProgOfAssortmentModel>
	 * allbalePreparationList = progOfAssortmentService.getAll();
	 * mv.addObject("balePreparationList", allbalePreparationList); return mv; }
	 */

	@ResponseBody
	@RequestMapping("findDpcByRegion")
	public String findDpcByRegion(HttpServletRequest request) {
		Gson gson = new Gson();
		// System.out.println(purchaseCenterService.purchaseCenter(request.getParameter("id")));
		return gson.toJson(purchaseCenterService.purchaseCenter(request.getParameter("id")));
	}

	@RequestMapping("editFarmer")
	public ModelAndView editFarmer(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("viewbalePreparation");
		int id = Integer.parseInt(request.getParameter("id"));
		List<ProgOfAssortmentModel> allbalePreparationList = progOfAssortmentService.getAll();
		mv.addObject("balePreparationList", allbalePreparationList);
		return mv;
	}

	@RequestMapping(value = "verifyFarmer2", method = RequestMethod.GET)
	public ModelAndView verifyFarmer(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		FarmerRegModel farmerDetails = farmerRegService.find(id);
		mv.addObject("farmerDetails", farmerDetails);
		mv.setViewName("verifyFarmer");
		return mv;
	}

	@RequestMapping(value = "saveVerification", method = RequestMethod.POST)
	public ModelAndView saveVerification(HttpServletRequest request) {
		System.out.println("saveVerification = ");
		ModelAndView mv = new ModelAndView("ViewFarmerRegistration");
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			//System.out.println("id = "+id);
			String farmer_reg_no = request.getParameter("farmer_reg_no");
			String ifsc_code = request.getParameter("ifsc_code");
			String ac_no = request.getParameter("ac_no");
			String farmer_name = request.getParameter("farmer_name");
			String address = request.getParameter("address");
			String idProofType = request.getParameter("idProofType");
			String identityProofNo = request.getParameter("identityProofNo");
			FarmerRegModel farmerdetails = farmerRegService.edit(id);
			String farmerRegNoDb = farmerdetails.getF_REG_NO();
			String ifscDb = farmerdetails.getF_BANK_IFSC();
			String accNoDb = farmerdetails.getF_AC_NO();
			String farmerNameDb = farmerdetails.getF_NAME();
			String farmerAddressDb = farmerdetails.getF_ADDRESS();
			String farmerIdProofTypeDb = farmerdetails.getF_ID_PROF_TYPE();
			String farmerIdProodNumberDb = farmerdetails.getF_ID_PROF_NO();
			String farmerRegNoFinal;
			String ifscDbFinal;
			String accNoDbFinal;
			String farmerNameFinal;
			String idProofTypeFinal;
			String idProofNumberFinal;
			String farmerAddressFinal;
			if (farmer_reg_no.equals(farmerRegNoDb)) {
				farmerRegNoFinal = farmerRegNoDb;
			} else {
				farmerRegNoFinal = null;
			}
			if (ifsc_code.equals(ifscDb)) {
				ifscDbFinal = ifsc_code;
			} else {
				ifscDbFinal = null;
			}
			if (ac_no.equals(accNoDb)) {
				accNoDbFinal = ac_no;
			} else {
				accNoDbFinal = null;
			}
			if (farmer_name.equals(farmerNameDb)) {
				farmerNameFinal = farmer_name;
			} else {
				farmerNameFinal = null;
			}
			if (address.equals(farmerAddressDb)) {
				farmerAddressFinal = address;
			} else {
				farmerAddressFinal = null;
			}
			if (idProofType.equals(farmerIdProofTypeDb)) {
				idProofTypeFinal = idProofType; 
			} else {
				idProofTypeFinal = null;
			}
			if (identityProofNo.equals(farmerIdProodNumberDb)) {
				idProofNumberFinal = identityProofNo;
			} else {
				idProofNumberFinal = null;
			}
			VerifyFarmerModel verifyFarmer = new VerifyFarmerModel();
			verifyFarmer.setAccountno(accNoDbFinal);
			verifyFarmer.setAddress(farmerAddressFinal);
			verifyFarmer.setFarmername(farmerNameFinal);
			verifyFarmer.setIfsccode(ifscDbFinal);
			verifyFarmer.setRegno(farmerRegNoFinal);
			verifyFarmer.setIdentityProofType(idProofTypeFinal);
			verifyFarmer.setIdentityProofNumber(idProofNumberFinal);
			verifyFarmer.setStatus(1);
			verifyFarmer.setVerificationdate(new Date());
			verifyFarmer.setRegno(farmer_reg_no);
			Boolean verifyRow =  verifyFarmerService.duplicateVerificationEntryNumberCheck(farmer_reg_no);
			if(verifyRow==true) {
				verifyFarmerService.submitform(verifyFarmer);
			}else {
				System.out.println("Duplicate verification record");
			}
			
			List<FarmerRegModelDTO> allFarmersList = farmerRegService.verificationStatus();
			VerifyFarmerModel farmerById = verifyFarmerService.findbyReg(farmer_reg_no);
			
			if(farmerById.getRegno() != null && farmerById.getIfsccode() != null && farmerById.getAccountno() != null && farmerById.getFarmername() != null
					&& farmerById.getAddress() != null && farmerById.getIdentityProofType() != null && farmerById.getIdentityProofNumber() != null) {
				Boolean result = farmerRegService.updateVerificationStatus(id);
			} else {
				 System.out.println("1st else block");
			}
			
			mv.addObject("allFarmersList", allFarmersList);
		} catch (Exception e) {
			System.out.println(e);
		}
		mv.addObject("msg", "success");
		mv.addObject("farmerdetails", new FarmerRegModel());		
		return new ModelAndView(new RedirectView("ViewFarmerRegistration.obj"));
	}

	@RequestMapping(value = { "editFarmerReg" }, method = { RequestMethod.GET })
	public ModelAndView editFarmerReg(final HttpServletRequest request) {
		final ModelAndView mv = new ModelAndView("editfarmerRegistration");
		if (request.getParameter("id") != null) {
			final int id = Integer.parseInt(request.getParameter("id"));
			final FarmerRegModel farmerDetailsById = this.farmerRegService.find(id);
			mv.addObject("farmerDetailsById", (Object) farmerDetailsById);
		}
		return mv;
	}

	@RequestMapping({ "EditsaveFarmerRegistrationMid" })
	public ModelAndView EditsaveFarmerRegistrationMid(HttpServletRequest request, RedirectAttributes redirectAttributes,
			@RequestParam("F_ID_PROF") MultipartFile F_ID_PROF, @RequestParam("F_BANK_DOC") MultipartFile F_BANK_DOC,
			@RequestParam("F_REG_FORM") MultipartFile F_REG_FORM,
			@RequestParam("F_DOC_Mandate") MultipartFile F_DOC_Mandate) {
		ModelAndView mv = new ModelAndView();
		try {
			String idPrimary = request.getParameter("idPrimary");
			String F_NAME = request.getParameter("F_NAME");
			String caste = request.getParameter("caste");
			String gender = request.getParameter("gender");
			String F_ADDRESS = request.getParameter("F_ADDRESS");
			String f_ID_PROF_TYPE = request.getParameter("F_ID_PROF_TYPE");
			String F_ID_PROF_NO = request.getParameter("F_ID_PROF_NO");
			String F_REG_BY = request.getParameter("F_REG_BY");
			
			System.out.println("F_REG_BY===  "+F_REG_BY);
			
			String F_I_CARE_REGISTERED = request.getParameter("F_I_CARE_REGISTERED");
			String land_holding = request.getParameter("land_holding");
			String F_MOBILE = request.getParameter("F_MOBILE");
			String F_AC_NO = request.getParameter("F_AC_NO");
			String bank_ac_type = request.getParameter("bank_ac_type");
			String F_BANK_NAME = request.getParameter("F_BANK_NAME");
			String F_BANK_BRANCH = request.getParameter("F_BANK_BRANCH");
			String F_BANK_IFSC = request.getParameter("F_BANK_IFSC");
			String F_Address2 = request.getParameter("F_Address2");
			String F_Pincode = request.getParameter("F_Pincode");
			String farmerRegNo = request.getParameter("farmerRegNo");
			//String F_REG_BY = request.getParameter("F_REG_BY");
			final FarmerRegModel farmerRegModel = new FarmerRegModel();
			farmerRegModel.setF_ID(Integer.parseInt(idPrimary));
			farmerRegModel.setF_NAME(F_NAME);
			farmerRegModel.setCaste(caste);
			farmerRegModel.setGender(gender);
			farmerRegModel.setF_ADDRESS(F_ADDRESS);
			farmerRegModel.setF_ID_PROF_TYPE(f_ID_PROF_TYPE);
			farmerRegModel.setF_ID_PROF_NO(F_ID_PROF_NO);
			farmerRegModel.setF_REG_BY(F_REG_BY);
			farmerRegModel.setF_I_CARE_REGISTERED(F_I_CARE_REGISTERED);
			farmerRegModel.setLand_holding(land_holding);
			farmerRegModel.setF_MOBILE(F_MOBILE);
			farmerRegModel.setF_AC_NO(F_AC_NO);
			farmerRegModel.setBank_ac_type(bank_ac_type);
			farmerRegModel.setF_BANK_NAME(F_BANK_NAME);
			farmerRegModel.setF_BANK_BRANCH(F_BANK_BRANCH);
			farmerRegModel.setF_BANK_IFSC(F_BANK_IFSC);
			// farmerRegModel.setF_REG_FORM(F_REG_FORM);
			farmerRegModel.setF_Address2(F_Address2);
			farmerRegModel.setF_Pincode(F_Pincode);
			farmerRegModel.setF_REG_NO(farmerRegNo);
			
			// farmer Bank Document
			File file = null;
			String pathurl = "";
			String url = "";
			if (F_BANK_DOC.isEmpty() != true) {
				file = new File(farmerUpload + F_BANK_DOC.getOriginalFilename());
				try {
					OutputStream os = new FileOutputStream(file);
					os.write(F_BANK_DOC.getBytes());
					os.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pathurl = file.getAbsolutePath();
				String path = farmerUpload + F_BANK_DOC.getOriginalFilename();
				url = path;
				farmerRegModel.setF_BANK_DOC(url);
				// userquery.setQueryurl(user.getIdUser()+""+"_"+mfile.getOriginalFilename());
			}

			// farmer ID Proof
			if (F_ID_PROF.isEmpty() != true) {
				file = new File(farmerUpload + F_ID_PROF.getOriginalFilename());
				try {
					OutputStream os = new FileOutputStream(file);
					os.write(F_ID_PROF.getBytes());
					os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				pathurl = file.getAbsolutePath();
				String path = farmerUpload + F_ID_PROF.getOriginalFilename();
				url = path;
				farmerRegModel.setF_ID_PROF(url);
				// userquery.setQueryurl(user.getIdUser()+""+"_"+mfile.getOriginalFilename());
			}

			// farmer ID Proof
			if (F_REG_FORM.isEmpty() != true) {
				file = new File(farmerUpload + F_REG_FORM.getOriginalFilename());
				try {
					OutputStream os = new FileOutputStream(file);
					os.write(F_REG_FORM.getBytes());
					os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				pathurl = file.getAbsolutePath();
				String path = farmerUpload + F_REG_FORM.getOriginalFilename();
				url = path;
				farmerRegModel.setF_REG_FORM(url);
			}

			// bank mandate upload
			if (F_DOC_Mandate.isEmpty() != true) {
				file = new File(farmerUpload + F_DOC_Mandate.getOriginalFilename());
				try {
					OutputStream os = new FileOutputStream(file);
					os.write(F_DOC_Mandate.getBytes());
					os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				pathurl = file.getAbsolutePath();
				String path = farmerUpload + F_DOC_Mandate.getOriginalFilename();
				url = path;
				farmerRegModel.setF_DOC_Mandate(url);
			}

			this.farmerRegService.create(farmerRegModel);
			redirectAttributes.addFlashAttribute("msg",
					(Object) "<div class=\"alert alert-success\"><b>Success !</b> Record Edit successfully.</div>\r\n");
		} catch (Exception e) {
			System.out.println(e);
			redirectAttributes.addFlashAttribute("msg",
					(Object) "<div class=\"alert alert-dange\"><b>Failure !</b> Error in saving record. Please try again</div>\r\n");
		}
		return new ModelAndView((View) new RedirectView("ViewFarmerRegistration.obj"));
	}

	 @RequestMapping("saveCommercialCeilingPriceIntimation")
	 public ModelAndView saveCommercialCeilingPriceIntimation(HttpServletRequest
	 request) {
	 try {
		 SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		 String dpccode = request.getParameter("dpccode");
		 String dateofentry = request.getParameter("dateofentry");
		 Date date1 = formatter1.parse(dateofentry);
		 String dateofeffect = request.getParameter("dateofeffect");
		 Date date2 = formatter1.parse(dateofeffect);
		 String jutevariety = request.getParameter("jutevariety");
		 String ceilingquantity = request.getParameter("ceilingquantity");
		 String jutegrade = request.getParameter("jutegrade");
		 String ceilingprice = request.getParameter("ceilingprice");
		 CommercialCeilingPriceIntimationModel
		 addCommercialCeilingPriceIntimationModel = new
		 CommercialCeilingPriceIntimationModel();
		 addCommercialCeilingPriceIntimationModel.setDpccode(dpccode);
		 addCommercialCeilingPriceIntimationModel.setDateofentry(date1);
		 addCommercialCeilingPriceIntimationModel.setDateofeffect(date2);
		 addCommercialCeilingPriceIntimationModel.setJutevariety(jutevariety);
		 addCommercialCeilingPriceIntimationModel.setCeilingquantity(ceilingquantity);
		 addCommercialCeilingPriceIntimationModel.setJutegrade(jutegrade);
		 addCommercialCeilingPriceIntimationModel.setCeilingprice(ceilingprice);
		 addCommercialCeilingPriceIntimationModel.setCreateddate(new Date());
		 commercialCeilingPriceIntimationService.create(addCommercialCeilingPriceIntimationModel);
	 } catch (Exception e) {
		 System.out.println(e);
	 }
	 return new ModelAndView(new
	 RedirectView("CommercialCeilingPriceIntimations.obj"));
	
	 }

	@RequestMapping("CommercialCeilingPriceIntimations")
	public ModelAndView CommercialCeilingPriceIntimations(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("CommercialCeilingPriceIntimations");
		return mv;
	}

	@RequestMapping("Distributionoftallyslips")
	public ModelAndView Distributionoftallyslips(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("Distributionoftallyslips");
		return mv;
	}

	@RequestMapping("saveDistributionoftallyslip")
	public ModelAndView saveDistributionoftallyslip(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		try {
			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			String dpccode = request.getParameter("dpccode");
			String dateofreceipt = request.getParameter("dateofreceipt");
			Date date1 = formatter1.parse(dateofreceipt);
			String slipreceived = request.getParameter("slipreceived");
			String seriesstartfrom = request.getParameter("seriesstartfrom");
			String seriestoend = request.getParameter("seriestoend");

			DistributionoftallyslipModel addDistributionoftallyslipModel = new DistributionoftallyslipModel();
			addDistributionoftallyslipModel.setDpccode(dpccode);
			addDistributionoftallyslipModel.setDateofreceipt(date1);
			addDistributionoftallyslipModel.setSlipreceived(slipreceived);
			addDistributionoftallyslipModel.setSeriesstartfrom(seriesstartfrom);
			addDistributionoftallyslipModel.setSeriestoend(seriestoend);
			addDistributionoftallyslipModel.setCreateddate(new Date());
			distributionoftallyslipService.create(addDistributionoftallyslipModel);
			redirectAttributes.addFlashAttribute("msg",
					(Object) "<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n");
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(new RedirectView("Distributionoftallyslips.obj"));

	}

	@RequestMapping("viewDistributionoftallyslips")
	public ModelAndView viewDistributionoftallyslips(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("viewDistributionoftallyslips");
		List<DistributionoftallyslipModel> allDistributionoftallyslips = distributionoftallyslipService.getAll();
		mv.addObject("DistributionoftallyslipsList", allDistributionoftallyslips);
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "validateAccount", method = RequestMethod.GET)
	public String validateAccount(HttpServletRequest request) {
		Gson gson = new Gson();
		boolean abc = farmerRegService.validateAccount(request.getParameter("accNo"));
		return farmerRegService.validateAccount(request.getParameter("accNo")) + "";
	}

	@RequestMapping("viewUserRegistration")
	public ModelAndView viewUserRegistration(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("viewUserRegistration");
		List<UserRegistrationModel> allUserRegistration = UserRegistrationService.getAll();
		mv.addObject("UserRegistrationList", allUserRegistration);
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "validateMobile", method = RequestMethod.GET)
	public String validateMobile(HttpServletRequest request) {
		Gson gson = new Gson();
		return farmerRegService.validateMobile(request.getParameter("mobileno")) + "";
	}

	@ResponseBody
	@RequestMapping(value = "validateEmail", method = RequestMethod.GET)
	public String validateEmail(HttpServletRequest request) {
		Gson gson = new Gson();
		return UserRegistrationService.validateEmail(request.getParameter("Email")) + "";
	}

	@ResponseBody
	@RequestMapping(value = "validateAdhar", method = RequestMethod.GET)
	public String validateAdhar(HttpServletRequest request) {
		Gson gson = new Gson();
		return farmerRegService.validateAdhar(request.getParameter("adharNo")) + "";
	}

	@RequestMapping("viewProcurementList")
	public ModelAndView viewProcurementList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("procurementList");
		List<RawJuteProcurementAndPayment> allProcurementList = rawJuteProcurAndPayService.getAll();
		mv.addObject("procurementList", allProcurementList);
		return mv;
	}

	@RequestMapping("verificationTallyslip")
	public ModelAndView verificationTallyslips(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("verifyTallySlip");
		return mv;
	}

	@RequestMapping("saveTallySlipMid")
	public ModelAndView saveTallySlipMid(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("verifyTallySlip");
		try {
			String farmerRegNo = request.getParameter("farmerRegNo");
			String tallyNo = request.getParameter("tallyNo");
			String dateOfPurchase = request.getParameter("dateOfPurchase");
			String rateSlipNumber = request.getParameter("rateSlipNumber");
			String binNumber = request.getParameter("binNumber");
			String juteVariety = request.getParameter("juteVariety");
			String drumWiseQuantity = request.getParameter("drumWiseQuantity");
			String placeOfPurchase = request.getParameter("placeOfPurchase");
			String netQuantity = request.getParameter("netQuantity");
			String garsatRate = request.getParameter("garsatRate");
			String amountPayable = request.getParameter("amountPayable");
			VerifyTallySlip verifyTallySlip = new VerifyTallySlip();
			verifyTallySlip.setFarmerRegNo(farmerRegNo);
			verifyTallySlip.setTallyNo(tallyNo);
			verifyTallySlip.setRateslipno(Integer.parseInt(rateSlipNumber));
			verifyTallySlip.setBinno(Integer.parseInt(binNumber));
			verifyTallySlip.setJutevariety(juteVariety);
			verifyTallySlip.setDrumwisequantity(Double.parseDouble(drumWiseQuantity));
			verifyTallySlip.setAmountpayable(Integer.parseInt(amountPayable));
			verifyTallySlip.setGarsatrate(Integer.parseInt(garsatRate));
			verifyTallySlip.setNetquantity(Double.parseDouble(netQuantity));
			verifyTallySlip.setPlaceOfPurchase(Integer.parseInt(placeOfPurchase));
		//	Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateOfPurchase);  
			//verifyTallySlip.setPuchasedate(date1);
			verifyTallySlipService.submitform(verifyTallySlip);
			redirectAttributes.addFlashAttribute("msg",
					(Object) "<div class=\"alert alert-success\"><b>Success !</b> Tally slip verified successfully.</div>\r\n");
		} catch (Exception e) {
			System.out.println("Error in tally slip verification form");
		}
		return mv;
	}

	@RequestMapping("viewVerifiedTallySlipList")
	public ModelAndView viewVerifiedTallySlipList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("verifiedTallySlipList");
		List<VerifyTallySlip> verifyList = verifyTallySlipService.getAll();
		mv.addObject("verifyTallySliList", verifyList);
		return mv;
	}

	@RequestMapping("viewCommercialCeilingPrice")
	public ModelAndView viewCommercialCeilingPrice(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("viewCommercialCeilingPrice");
		List<CommercialCeilingPriceIntimationModel> commercialList = commercialCeilingPriceIntimationService.getAll();
		mv.addObject("commercialList", commercialList);
		return mv;
	}

	@RequestMapping("rulingMarketForm")
	public ModelAndView rulingMarket(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("rulingMarket");
		return mv;
	}

	// saveRulingMarketMid
	@RequestMapping("saveRulingMarketMid")
	public ModelAndView saveRulingMarketMid(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("rulingMarket");
		try {
			String dpcname = request.getParameter("dpcname");
			String noofarrival = request.getParameter("noofarrival");
			String dateofarrival = request.getParameter("dateofarrival");
			String jutevariety = request.getParameter("jutevariety");
			String cropyear = request.getParameter("cropyear");
			String arrivedquantity = request.getParameter("arrivedquantity");
			String minmoisture = request.getParameter("minmoisture");
			String maxmoisture = request.getParameter("maxmoisture");
			String gradewisefield = request.getParameter("gradewisefield");
			String gradewiserate = request.getParameter("gradewiserate");
			String estimatedgradecomposition = request.getParameter("estimatedgradecomposition");
			RulingMarket rulingMarket = new RulingMarket();
			rulingMarket.setArrivedquantity(Integer.parseInt(arrivedquantity));
			rulingMarket.setCropyear(cropyear);
			rulingMarket.setDpcname(dpcname);
			rulingMarket.setEstimatedgradecomposition(Integer.parseInt(estimatedgradecomposition));
			rulingMarket.setGradewisefield(Integer.parseInt(gradewisefield));
			rulingMarket.setGradewiserate(Integer.parseInt(gradewiserate));
			rulingMarket.setJutevariety(jutevariety);
			rulingMarket.setMaxmoisture(Integer.parseInt(maxmoisture));
			rulingMarket.setMinmoisture(Integer.parseInt(minmoisture));
			rulingMarket.setNoofarrival(noofarrival);
			rulingMarketService.create(rulingMarket);
		} catch (Exception e) {
			System.out.println("Error in saving ruling market data");
		}
		return mv;
	}

	@RequestMapping("bin")
	public ModelAndView bin(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("bin");
		try {
			
		} catch (Exception e) {
			System.out.println("Error in saving ruling market data");
		}
		return mv;
	}
	
	
	@RequestMapping("saveBinDetails")
	public ModelAndView saveBinDetails(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("bin");
		try {
			String nameOfDpc = request.getParameter("dpcname");
			String cropyear = request.getParameter("cropyr");
			String binNumber = request.getParameter("binnumb");
            String jutevariety = request.getParameter("jutevariety");
            String basis = request.getParameter("basis");
            String carryForwardLoose = request.getParameter("carryforwardloose");
			String carryForwardRope = request.getParameter("carryforwardRope");
			
			BatchIdentificationModel batch = new BatchIdentificationModel();
			batch.setDpcnames(nameOfDpc);  
			batch.setCropyr(cropyear); 
			batch.setBinnumber(binNumber);  
			
			batch.setJutevariety(jutevariety);
			batch.setBasis(basis);
			batch.setCarryoverlossqty(carryForwardLoose);
			batch.setCarryropeqty(carryForwardRope);
			
			batchService.create(batch);
		} catch (Exception e) {
			System.out.println("Error in saving ruling market data");
		}
		return mv;
	}
	
	@RequestMapping("binList")
	public ModelAndView binList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("binList");
		List<BatchIdentificationModel> batch = batchService.getAll();
		mv.addObject("batch", batch);
		return mv;
	}
	
	
	
	
	@RequestMapping("viewRulingMarket")
	public ModelAndView viewRulingMarket(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("viewRulingMarket");
		List<RulingMarket> rulingList = rulingMarketService.getAll();
		mv.addObject("rulingList", rulingList);
		return mv;
	}
	
	@RequestMapping("viewbalePreparation") 
	public ModelAndView viewbalePreparation(HttpServletRequest request) 
	{ 
		ModelAndView mv = new ModelAndView("viewbalePreparation"); 
		List<BalePreparation> viewBale= balePrepareService.getAll();
		mv.addObject("viewBalePreparation",viewBale); 
		return mv; 
	}
	
	@RequestMapping("deleteBaleP") 
	public ModelAndView deleteBaleP(HttpServletRequest request) 
	{ 
		ModelAndView mv = new ModelAndView("viewbalePreparation");
		try {
			String id = request.getParameter("id");
			//System.out.println(id);
			balePreparationService.delete(Integer.parseInt(id));
			List<BalePreparationModel> DeleteBalePreparation=balePreparationService.getAll();
			mv.addObject("viewBalePreparation", DeleteBalePreparation);
			//return new ModelAndView(new RedirectView("deletemarketArival.obj"));
		} catch(Exception e){
			System.out.println("Error in deleting bale preparation");
		}
		return mv; 
	}
	
	@RequestMapping("deleteRopemaking") 
	public ModelAndView deleteRopemaking(HttpServletRequest request) 
	{ 
		ModelAndView mv = new ModelAndView("RopeMakingListing");
		try {
			String id = request.getParameter("id");
			ropeMakingService.delete(Integer.parseInt(id));
			List<RopeMakingModel> DeleteRopem = ropeMakingService.getAll();			
			mv.addObject("ropeLists", DeleteRopem);
			return new ModelAndView(new RedirectView("ropeMakingListing.obj"));
		} catch(Exception e){
			System.out.println("Error in deleting rope making");
		}
		return mv; 
	}
	
	//deleteDpc
	@RequestMapping("deleteDpc") 
	public ModelAndView deleteDpc(HttpServletRequest request) 
	{ 
		ModelAndView mv = new ModelAndView();
		try {
			String id = request.getParameter("id");
			DailyPurchasefService.delete(Integer.parseInt(id));
			List<DailyPurchaseConfModel> allDailyPurchase = DailyPurchasefService.getAll();			
			mv.addObject("dailyPurchaseList", allDailyPurchase);
			return new ModelAndView(new RedirectView("dailyPurchaseList.obj"));
		} catch(Exception e){
			System.out.println("Error in deleting daily purchase");
		}
		return mv; 
	}

	@RequestMapping("deletejuteprocurement") 
	public ModelAndView deletejuteprocurement(HttpServletRequest request) 
	{ 
		ModelAndView mv = new ModelAndView();
		try {
			String id = request.getParameter("id");
			rawJuteProcurAndPayService.delete(Integer.parseInt(id));
			List<RawJuteProcurementAndPayment> DeletejuteProcu = rawJuteProcurAndPayService.getAll();
			mv.addObject("procurementList", DeletejuteProcu);
			return new ModelAndView(new RedirectView("juteProcurementList.obj"));
		} catch(Exception e){
			System.out.println("Error in deleting RawJuteProcurAndPay ");
		}
		return mv; 
	}
	
	@RequestMapping("deletetallyslip") 
	public ModelAndView deletetallyslip(HttpServletRequest request) 
	{ 
		ModelAndView mv = new ModelAndView();
		try {
			String id = request.getParameter("id");
			verifyTallySlipService.delete(Integer.parseInt(id));
			List<VerifyTallySlip> Deletetallyslip = verifyTallySlipService.getAll();
			mv.addObject("verifyTallySliList", Deletetallyslip);
			return new ModelAndView(new RedirectView("viewVerifiedTallySlipList.obj"));
		} catch(Exception e){
			System.out.println("Error in delete TallySlip");
		}
		return mv; 
	}
	
	@RequestMapping("editjuteprocurement") 
	public ModelAndView editjuteprocurement(HttpServletRequest request) 
	{ 
		ModelAndView mv = new ModelAndView("editJuteProcurement");
		try {
			String id = request.getParameter("id");
			RawJuteProcurementAndPayment juteProc = rawJuteProcurAndPayService.find(Integer.parseInt(id));
			mv.addObject("juteProc", juteProc);
		} catch(Exception e){
			System.out.println(e);
		}
		return mv; 
	}
	
	@RequestMapping("updateJuteProcurement") 
	public ModelAndView updateJuteProcurement(HttpServletRequest request, RedirectAttributes redirectAttributes) 
	{ 
		try {
			String ipAddress = null;
			String getWay = request.getHeader("VIA"); // Gateway
			ipAddress = request.getHeader("X-FORWARDED-FOR"); // proxy
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
			}
			String ptsid = request.getParameter("id");
			String tallySlip = request.getParameter("tallyslipno");
			String farmerregno = request.getParameter("farmerregno"); // int
			String formno = request.getParameter("formno"); // int
			String datepurchase = request.getParameter("datepurchase");
			String basis = request.getParameter("basis");
			String cropyr = request.getParameter("cropyr");
			String placeofpurchase = request.getParameter("placeofpurchase");
			String rateslipno = request.getParameter("rateslipno");
			String binno = request.getParameter("binno");
			String jutevariety = request.getParameter("jutevariety");
			double gquantity = Double.parseDouble(request.getParameter("gquantity"));
			double dquantity = Double.parseDouble(request.getParameter("deductionQuantity"));
			double netquantity = Double.parseDouble(request.getParameter("netquantity"));
			double garsatRate = Double.parseDouble(request.getParameter("garsatRate"));
			double amountPayable = Double.parseDouble(request.getParameter("amountPayable"));
			
			
			
			  RawJuteProcurementAndPayment rawJuteProcAndPay = new RawJuteProcurementAndPayment(); 
			  rawJuteProcAndPay.setBasis(basis);
			  rawJuteProcAndPay.setBinno(Integer.parseInt(binno));
			  rawJuteProcAndPay.setCreateddate(new Date()); //
			 // rawJuteProcAndPay.setCreatedfrom(createdfrom);
			  rawJuteProcAndPay.setCropyr(cropyr);
			 
			
			int createdBy = (Integer) request.getSession().getAttribute("userId");
			
			  rawJuteProcAndPay.setPtsid(Integer.parseInt(ptsid));
			  rawJuteProcAndPay.setFormno(Integer.parseInt(formno));
			  rawJuteProcAndPay.setGrossquantity(gquantity);
			  rawJuteProcAndPay.setIpaddress(ipAddress);
			  rawJuteProcAndPay.setJutevariety(jutevariety);
			  rawJuteProcAndPay.setPlaceofpurchase(placeofpurchase);
			  rawJuteProcAndPay.setRateslipno(Integer.parseInt(rateslipno));
			  rawJuteProcAndPay.setDeductionquantity(dquantity);
			  rawJuteProcAndPay.setGrasatrate(garsatRate);
			  rawJuteProcAndPay.setAmountpayable(amountPayable);
			  rawJuteProcAndPay.setFarmerregno((farmerregno));
			  rawJuteProcAndPay.setCreadtedby(createdBy);
			 
			rawJuteProcurAndPayService.create(rawJuteProcAndPay);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success!</b> Record updated successfully.</div>\r\n" + "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(new RedirectView("rawJutePaymentAndProcurement.obj"));
	}
	@RequestMapping(value = "verifyFarmer2_landscape", method = RequestMethod.GET)
	public ModelAndView verifyFarmer2_landscape(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		FarmerRegModel farmerDetails = farmerRegService.find(id);
		mv.addObject("farmerDetails", farmerDetails);
		mv.setViewName("verifyFarmer2_landscape");
		return mv;
	}

	@RequestMapping("deletedistributiontally") 
	public ModelAndView deletedistributiontally(HttpServletRequest request) 
	{ 
		ModelAndView mv = new ModelAndView("viewDistributionoftallyslips");
		try {
			String id = request.getParameter("id");
			distributionoftallyslipService.delete(Integer.parseInt(id));
			List<DistributionoftallyslipModel> Deletedistributiontally = distributionoftallyslipService.getAll();
			mv.addObject("DistributionoftallyslipsList", Deletedistributiontally);
			//return new ModelAndView(new RedirectView("juteProcurementList.obj"));
		} catch(Exception e){
			
			System.out.println("Error in deleting distribution tally market");
		}
		return mv; 
	}
	
	@RequestMapping("deletecommercialprice") 
	public ModelAndView deletecommercialprice(HttpServletRequest request) 
	{ 
		ModelAndView mv = new ModelAndView("viewCommercialCeilingPrice");
		try {
			String id = request.getParameter("id");
			commercialCeilingPriceIntimationService.delete(Integer.parseInt(id));
			List<CommercialCeilingPriceIntimationModel> deleteCommercialList= commercialCeilingPriceIntimationService.getAll();
			mv.addObject("commercialList", deleteCommercialList);
		} catch(Exception e){
			System.out.println("Error in deleting commercial price market");
		}
		return mv; 
	}
	
	@RequestMapping("deleteRulingMarket") 
	public ModelAndView deleteRulingMarket(HttpServletRequest request,RedirectAttributes redirectAttributes) 
	{ 
		ModelAndView mv = new ModelAndView("viewRulingMarket");
		try {
			String id = request.getParameter("id");
			rulingMarketService.delete(Integer.parseInt(id));
			List<RulingMarket> rulingList = rulingMarketService.getAll();
			mv.addObject("rulingList", rulingList);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> List deleted successfully.</div>\r\n" + "");
			return new ModelAndView(new RedirectView("viewRulingMarket.obj"));
		} catch(Exception e){
			System.out.println("Error in deleting ruling market");
		}
		return mv; 
	}
	
	@RequestMapping("editBaleP") 
	public ModelAndView editBaleP(HttpServletRequest request,RedirectAttributes redirectAttributes) 
	{ 
		ModelAndView mv = new ModelAndView("editBalePreparation");
		try {
			String id = request.getParameter("id");
			BalePreparationModel baleMod =  balepreparationservice.find(Integer.parseInt(id));
			mv.addObject("baleMod", baleMod);
			return mv;
		} catch(Exception e){
			System.out.println("Error in update bale preparation");
		}
		return mv; 
	}
	
	@RequestMapping("updateBalePreparation") 
	public ModelAndView updateBalePreparation(HttpServletRequest request,RedirectAttributes redirectAttributes) 
	{ 
		ModelAndView mv = new ModelAndView("editBalePreparation");
		try {
			int creadtedby = 0;
			String id = request.getParameter("id");
			String dpcname = request.getParameter("dpcname");
			String cropyr = request.getParameter("cropyr");
			String jutevariety = request.getParameter("jutevariety");
			String binnumb = request.getParameter("binnumb");
			String basis = request.getParameter("basis");
			String carryforward = request.getParameter("carryforward");
			String carryforwarsrope = request.getParameter("carryforwarsrope");
			BalePreparationModel balePrepare = new BalePreparationModel();
			// addRopeMaking.setCreateddate(createddate);
			balePrepare.setId(Integer.parseInt(id));
			balePrepare.setDpcnames(dpcname);
			balePrepare.setCropyr(cropyr);
			balePrepare.setJutevariety(jutevariety);
			balePrepare.setBinnumber(binnumb);
			balePrepare.setBasis(basis);
			balePrepare.setCarryoverlossqty(carryforward);
			balePrepare.setCarryropeqty(carryforwarsrope);
			// balePrepare.setCreateddate(new Date());
			balepreparationservice.create(balePrepare);
			redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> Record updated successfully.</div>\r\n" + "");
			return new ModelAndView(new RedirectView("viewbalePreparation.obj"));
		} catch(Exception e){
			System.out.println("Error in update bale preparation");
		}
		return mv; 
	}
	
	@RequestMapping(value= {"editRopemaking"}, method = { RequestMethod.GET })
	public ModelAndView editRopemaking(final HttpServletRequest request) {
		final ModelAndView mv = new ModelAndView("editRopemaking");
		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			RopeMakingModel editRopmaking = ropeMakingService.find(id);
			mv.addObject("editRopemaking", editRopmaking);
		}
		return mv;
	}
	
	@RequestMapping("updateRopeMakingMid") 
	public ModelAndView updateRopeMakingMid(HttpServletRequest request,RedirectAttributes redirectAttributes) 
	{ 
		ModelAndView mv = new ModelAndView("editRopemaking");
		try {
			String id = request.getParameter("id");
			String datereport = request.getParameter("datereport");
			int creadtedby = 0;
			String basis = request.getParameter("basis");
			String cropyr = request.getParameter("cropyr");
			String placeofactivity = request.getParameter("placeofactivity");
			String jutevariety = request.getParameter("jutevariety");
			String ropemade = request.getParameter("ropemade");
			String ropeUsed = request.getParameter("ropeUsed");
			String balance = request.getParameter("balance");
			String ipaddress = request.getParameter("ipaddress");
			String binno = request.getParameter("binno");
			//String rateslipno = request.getParameter("rateslipno");
			RopeMakingModel addRopeMaking = new RopeMakingModel();
			addRopeMaking.setRpmrefid(Integer.parseInt(id));
			addRopeMaking.setBasis(basis);
			addRopeMaking.setBinno(binno);
			addRopeMaking.setCreadtedby(creadtedby);
			// addRopeMaking.setCreateddate(createddate);
			addRopeMaking.setCropyr(cropyr);
			addRopeMaking.setDatereport(datereport);
			addRopeMaking.setIpaddress(ipaddress);
			addRopeMaking.setJutevariety(jutevariety);
			addRopeMaking.setPlaceofactivity(placeofactivity);
			addRopeMaking.setRopemade(Integer.parseInt(ropemade));
			addRopeMaking.setRopeused(Integer.parseInt(ropeUsed));
			addRopeMaking.setRope_balance(Integer.parseInt(balance));
			addRopeMaking.setCreateddate(new Date());
			ropeMakingService.create(addRopeMaking);
			redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> Record updated successfully.</div>\r\n" + "");
			return new ModelAndView(new RedirectView("ropeMakingListing.obj"));
		} catch(Exception e){
			System.out.println("Error in update Ropmaking");
		}
		return mv; 
	}
                         
	
	@RequestMapping("editDpc") 
	public ModelAndView editDpc(HttpServletRequest request, RedirectAttributes redirectAttributes) 
	{ 
		ModelAndView mv = new ModelAndView("editDailypurchase");
		try {
			String id = request.getParameter("id");
			DailyPurchaseConfModel dailyPurchase =  DailyPurchasefService.find(Integer.parseInt(id));
			mv.addObject("dailyPurchase", dailyPurchase);
			return mv;
		} catch(Exception e){
			System.out.println("Error in edit DPC");
		}
		return mv; 
	}

	@RequestMapping("updateDailyPurchase") 
	public ModelAndView updateDailyPurchase(HttpServletRequest request, RedirectAttributes redirectAttributes) 
	{ 
		ModelAndView mv = new ModelAndView("dailyPurchaseLIst");
		try {
			String id = request.getParameter("id");
			
				String ipAddress = null;
				String getWay = request.getHeader("VIA"); // Gateway
				ipAddress = request.getHeader("X-FORWARDED-FOR"); // proxy
				if (ipAddress == null) {
					ipAddress = request.getRemoteAddr();
				}
				String formno = request.getParameter("formno");
				 String datepurchase = request.getParameter("datepurchase");
				String basis = request.getParameter("basis");
				String cropyr = request.getParameter("cropyr");
				String placeofpurchase = request.getParameter("placeofpurchase");
				String binno = request.getParameter("binno");
				String jutevariety = request.getParameter("jutevariety");
				String gquantity = request.getParameter("gquantity");
				String dquantity = request.getParameter("dquantity");
				String netquantity = request.getParameter("netquantity");
				String fibervalue = request.getParameter("fibervalue");
				int createdBy = (Integer) request.getSession().getAttribute("userId");
				String rateslipno = request.getParameter("rateslipno");
				DailyPurchaseConfModel DailyPurchase = new DailyPurchaseConfModel();
				DailyPurchase.setDpcid(Integer.parseInt(id));
				DailyPurchase.setBasis(basis);
				DailyPurchase.setBinno(Integer.parseInt(binno));
				DailyPurchase.setCropyr(cropyr);
				DailyPurchase.setDquantity(Double.parseDouble(dquantity));
				DailyPurchase.setFibervalue(Integer.parseInt(fibervalue));
				DailyPurchase.setFormno((formno));
				DailyPurchase.setGquantity(Double.parseDouble(gquantity));
				DailyPurchase.setIpaddresss(ipAddress);
				DailyPurchase.setJutevariety(jutevariety);
				DailyPurchase.setNetquantity(Double.parseDouble(netquantity));
				DailyPurchase.setPlaceofpurchase(placeofpurchase);
				DailyPurchase.setCreatedby(createdBy);
				DailyPurchase.setRateslipno(rateslipno);
				System.out.println(DailyPurchase.toString());
				DailyPurchasefService.create(DailyPurchase);
				redirectAttributes.addFlashAttribute("msg",
						"<div class=\"alert alert-success\"><b>Success !</b> Record saved successfully.</div>\r\n" + "");
			
		} 
		
			catch(Exception e){
			System.out.println("Error in update DPC");
		}
		return new ModelAndView(new RedirectView("dailyPurchaseList.obj"));
	}
	
	@ResponseBody
	@RequestMapping("validateFarmer")
	public String farmerNoVarification(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("RawJutePaymentAndProcurement");
		Gson gson = new Gson();
		String farmerNo= request.getParameter("farmerNo");
		return gson.toJson(rawJuteProcurAndPayService.farmerNoVarification(farmerNo));

	}
	@ResponseBody
	@RequestMapping(value = "findJuteOnBasis", method = RequestMethod.GET)
	public String findJuteOnBasis(HttpServletRequest request) {
		Gson gson = new Gson();
		List<String> result= new ArrayList<String>();
		result=rawJuteProcurAndPayService.findJuteOnBasis(Integer.parseInt(request.getParameter("msp_no")));
		return gson.toJson(result);
	}
	
	@ResponseBody
	@RequestMapping(value = "findGradeOnJuteVariety", method = RequestMethod.GET)
	public String findGradeOnJuteVariety(HttpServletRequest request) {
		Gson gson = new Gson();
		List<String> result;
		result=rawJuteProcurAndPayService.findGradeOnJuteVariety(request.getParameter("variety"),Integer.parseInt(request.getParameter("basis_no")));
		return gson.toJson(result);
	}
	
	@ResponseBody
	@RequestMapping(value = "findGradeOfMSP", method = RequestMethod.GET)
	public String findGradeOfMSP(HttpServletRequest request) {
		Gson gson = new Gson();
		List<String> result;
		result=mSPPriceCalculationService.findGradeOfMSP(request.getParameter("variety"),Integer.parseInt(request.getParameter("basis_no")));
	System.out.println(result.size()+"");
		return gson.toJson(result);
		}
	
	@RequestMapping("mspPriceCalculation")
	public ModelAndView mspPriceCalculation(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("mspPriceCalculation");
		return mv;
	}
	
	@RequestMapping("deleteFarmer")
	public ModelAndView deleteFarmer(final HttpServletRequest request, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("ViewFarmerRegistration");
		try {
			String id = request.getParameter("id");
			farmerRegService.delete(Integer.parseInt(id));
			List<FarmerRegModel> allFarmersList = farmerRegService.getAll();
			mv.addObject("allFarmersList", allFarmersList);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Data deleted successfully.</div>\r\n" + "");
			return new ModelAndView(new RedirectView("ViewFarmerRegistration.obj"));
		} catch(Exception e){
			System.out.println("Error in deleting ruling market");
		}
		return mv; 
	}

	@RequestMapping("editdistributiontally") 
	public ModelAndView editdistributiontally(HttpServletRequest request, RedirectAttributes redirectAttributes) 
	{ 
		ModelAndView mv = new ModelAndView("editDistributiontallyslip");
		try {
			String id = request.getParameter("id");
			DistributionoftallyslipModel distributiontallyslip =distributionoftallyslipService.find(Integer.parseInt(id));
			mv.addObject("distributiontally", distributiontallyslip);
			return mv;
		} catch(Exception e){
			System.out.println("Error in edit DPC");
		}
		return mv; 
	}

	@RequestMapping("updateDistributionoftallyslip") 
	public ModelAndView updateDistributionoftallyslip(HttpServletRequest request, RedirectAttributes redirectAttributes) 
	{ 
		ModelAndView mv = new ModelAndView("editdistributiontally");
		try {
			String id = request.getParameter("id");
			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			String dpccode = request.getParameter("dpccode");
			String dateofreceipt = request.getParameter("dateofreceipt");
			Date date1 = formatter1.parse(dateofreceipt);
			String slipreceived = request.getParameter("slipreceived");
			String seriesstartfrom = request.getParameter("seriesstartfrom");
			String seriestoend = request.getParameter("seriestoend");
			DistributionoftallyslipModel updateDistributionoftallyslipModel = new DistributionoftallyslipModel();
			updateDistributionoftallyslipModel.setRefid(Integer.parseInt(id));
			updateDistributionoftallyslipModel.setDpccode(dpccode);
			updateDistributionoftallyslipModel.setDateofreceipt(date1);
			updateDistributionoftallyslipModel.setSlipreceived(slipreceived);
			updateDistributionoftallyslipModel.setSeriesstartfrom(seriesstartfrom);
			updateDistributionoftallyslipModel.setSeriestoend(seriestoend);
			updateDistributionoftallyslipModel.setCreateddate(new Date());
			distributionoftallyslipService.create(updateDistributionoftallyslipModel);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record updated successfully.</div>\r\n" + "");
				return new ModelAndView(new RedirectView("viewDistributionoftallyslips.obj"));
		
		} catch(Exception e){
			System.out.println("Error in update Distribution Tally Slip");
		}
		return mv; 
	}
	
	@RequestMapping("editcommercialprice") 
	public ModelAndView editcommercialprice(HttpServletRequest request, RedirectAttributes redirectAttributes) 
	{ 
		ModelAndView mv = new ModelAndView("editcommercialprice");
		try {
			String id = request.getParameter("id");
			CommercialCeilingPriceIntimationModel commercialCeilingPrice =commercialCeilingPriceIntimationService.find(Integer.parseInt(id));
			mv.addObject("commercialCeilingprice", commercialCeilingPrice);
			return mv;
		} catch(Exception e){
			System.out.println("Error in edit CommercialCellingPriceIntimation");
		}
		return mv; 
	}

	@RequestMapping("updateCommercialCeilingPriceIntimation") 
	public ModelAndView updateCommercialCeilingPriceIntimation(HttpServletRequest request, RedirectAttributes redirectAttributes) 
	{ 
		ModelAndView mv = new ModelAndView("editcommercialprice");
		try {
			String id = request.getParameter("id");
			 SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			 String dpccode = request.getParameter("dpccode");
			 String dateofentry = request.getParameter("dateofentry");
			 Date date1 = formatter1.parse(dateofentry);
			 String dateofeffect = request.getParameter("dateofeffect");
			 Date date2 = formatter1.parse(dateofeffect);
			 String jutevariety = request.getParameter("jutevariety");
			 String ceilingquantity = request.getParameter("ceilingquantity");
			 String jutegrade = request.getParameter("jutegrade");
			 String ceilingprice = request.getParameter("ceilingprice");
			 CommercialCeilingPriceIntimationModel updateCommercialCeilingPriceIntimationModel = new CommercialCeilingPriceIntimationModel();
			 updateCommercialCeilingPriceIntimationModel.setRpmrefid(Integer.parseInt(id));
			 updateCommercialCeilingPriceIntimationModel.setDpccode(dpccode);
			 updateCommercialCeilingPriceIntimationModel.setDateofentry(date1);
			 updateCommercialCeilingPriceIntimationModel.setDateofeffect(date2);
			 updateCommercialCeilingPriceIntimationModel.setJutevariety(jutevariety);
			 updateCommercialCeilingPriceIntimationModel.setCeilingquantity(ceilingquantity);
			 updateCommercialCeilingPriceIntimationModel.setJutegrade(jutegrade);
			 updateCommercialCeilingPriceIntimationModel.setCeilingprice(ceilingprice);
			 updateCommercialCeilingPriceIntimationModel.setCreateddate(new Date());
			 commercialCeilingPriceIntimationService.create(updateCommercialCeilingPriceIntimationModel);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record updated successfully.</div>\r\n" + "");
				return new ModelAndView(new RedirectView("viewCommercialCeilingPrice.obj"));
		
		} catch(Exception e){
			System.out.println("Error in update commercialCelingPrice");
		}
		return mv; 
	}
	
	
	@RequestMapping("saveGradePriceOfMSP")
	public ModelAndView saveGradePriceOfMSP(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("mspPriceCalculation");
	//	int msp_id=Integer.parseInt(request.getParameter(""));
		try {
			String jutevariety=request.getParameter("jutevariety");
			String cropyr=request.getParameter("cropyr");
			String grade0=request.getParameter("grade0");
			String grade1=request.getParameter("grade1");
			String grade2=request.getParameter("grade2");
			String grade3=request.getParameter("grade3");
			String grade4=request.getParameter("grade4");
			String grade5=request.getParameter("grade5");
			String grade6=request.getParameter("grade6");
			String grade7=request.getParameter("grade7");
			
			MSPPriceCalculationModel mspPriceCalculationModel=new MSPPriceCalculationModel();
			mspPriceCalculationModel.setJute_variety(jutevariety);
			mspPriceCalculationModel.setCrop_yr(cropyr);
			if(grade0!=null) {
				mspPriceCalculationModel.setGrade1(Double.parseDouble(grade0));
			}
			if(grade1!=null) {
				
				mspPriceCalculationModel.setGrade2(Double.parseDouble(grade1));
			}
			if(grade2!=null) {
				
				mspPriceCalculationModel.setGrade3(Double.parseDouble(grade2));
			}
			if(grade3!=null) {
				
				mspPriceCalculationModel.setGrade4(Double.parseDouble(grade3));
			}
			if(grade4!=null) {
				
				mspPriceCalculationModel.setGrade5(Double.parseDouble(grade4));
			}
			if(grade5!=null) {
				
				mspPriceCalculationModel.setGrade6(Double.parseDouble(grade5));
			}
			if(grade6!=null) {
				
				mspPriceCalculationModel.setGrade7(Double.parseDouble(grade6));
			}
			if(grade7!=null) {
				
				mspPriceCalculationModel.setGrade8(Double.parseDouble(grade7));
			}
			mspPriceCalculationModel.setCreated_date(new Date());
			int msp = mSPPriceCalculationService.create(mspPriceCalculationModel);
		//	System.out.println(msp);
			if(msp>=0)
			{
			mv.addObject("msg", "Submitted Successfully....");
			}
			else
			{
				mv.addObject("msg", "Failed to Submit, please try again...");
			}
			
			
	} catch(Exception e){
		System.out.println(e);
	}
		return mv;
			}


	@RequestMapping("editRulingMarket") 
	public ModelAndView editRulingMarket(HttpServletRequest request, RedirectAttributes redirectAttributes) 
	{ 
		ModelAndView mv = new ModelAndView("editRulingMarket");
		try {
			String id = request.getParameter("id");
			RulingMarket rulingMarket =rulingMarketService.find(Integer.parseInt(id));
			mv.addObject("rulingMarket", rulingMarket);
			return mv;
		} catch(Exception e){
			System.out.println("Error in edit RulingMarket");
		}
		return mv; 
	}
	
	@RequestMapping("commercialPriceCalculation")
	public ModelAndView commercialPriceCalculation(HttpServletRequest request) {
		List<ZoneModel> zoneList = zoneService.getAll();
		List<RoleMasterModel> roleList = roleService.getAll();
		ModelAndView mv = new ModelAndView("CommercialJuteVarietyGradesPrice");
		mv.addObject("zoneList", zoneList);
		mv.addObject("roleList", roleList);
		return mv;
	}	
	
	@RequestMapping(value = "saveGradePriceOfCommercial", method = RequestMethod.POST)
	public ModelAndView saveGradePriceOfCommercial(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("CommercialJuteVarietyGradesPrice");
		try {
			String zone=request.getParameter("zone");
			String region=request.getParameter("region");
			String dpc=request.getParameter("dpc");
			String jutevariety=request.getParameter("jutevariety");
			String radioselect =request.getParameter("radioselect");
			String entryDate =request.getParameter("entryDate");
			String effectDate =request.getParameter("effectDate");
			String cqty=request.getParameter("cqty");
			String cropyr=request.getParameter("cropyr");
			
			String grade0=request.getParameter("grade0");
			String grade1=request.getParameter("grade1");
			String grade2=request.getParameter("grade2");
			String grade3=request.getParameter("grade3");
			String grade4=request.getParameter("grade4");
			String grade5=request.getParameter("grade5");
			String grade6=request.getParameter("grade6");
			String grade7=request.getParameter("grade7");
			
			
			CommercialJuteVarietyModel commercialJuteVarietyModel=new CommercialJuteVarietyModel();
			commercialJuteVarietyModel.setJute_variety(jutevariety);
			commercialJuteVarietyModel.setCrop_yr(cropyr);
			commercialJuteVarietyModel.setDpc(dpc);
			commercialJuteVarietyModel.setRegion(region);
			commercialJuteVarietyModel.setCqty(cqty);
			commercialJuteVarietyModel.setZone(zone);
			commercialJuteVarietyModel.setEffectDate(effectDate);
			commercialJuteVarietyModel.setCreated_on(entryDate);
			commercialJuteVarietyModel.setJute_variety(jutevariety);
			commercialJuteVarietyModel.setFormtype(radioselect);
			if(grade0!=null) {
				commercialJuteVarietyModel.setGrade1(Double.parseDouble(grade0));
			}
			if(grade1!=null) {
				
				commercialJuteVarietyModel.setGrade2(Double.parseDouble(grade1));
			}
			if(grade2!=null) {
				
				commercialJuteVarietyModel.setGrade3(Double.parseDouble(grade2));
			}
			if(grade3!=null) {
				
				commercialJuteVarietyModel.setGrade4(Double.parseDouble(grade3));
			}
			if(grade4!=null) {
				
				commercialJuteVarietyModel.setGrade5(Double.parseDouble(grade4));
			}
			if(grade5!=null) {
				
				commercialJuteVarietyModel.setGrade6(Double.parseDouble(grade5));
			}
			if(grade6!=null) {
				
				commercialJuteVarietyModel.setGrade7(Double.parseDouble(grade6));
			}
			if(grade7!=null) {
				
				commercialJuteVarietyModel.setGrade8(Double.parseDouble(grade7));
			}
			
			commercialJuteVarietyGradesPriceService.create(commercialJuteVarietyModel);
	} catch(Exception e){
		System.out.println(e);
	}
	
		return new ModelAndView(new RedirectView("commercialPriceCalculation.obj"));
	}

	@ResponseBody
	@RequestMapping(value = "findGradePriceJuteVariety", method = RequestMethod.GET)
	public String findGradePriceJuteVariety(HttpServletRequest request, HttpSession session) {
		int userid = (Integer) request.getSession().getAttribute("userId");
		int dpcid = (Integer) request.getSession().getAttribute("dpcId");
		Gson gson = new Gson();
		List<String> result;
		result=rawJuteProcurAndPayService.findGradePriceJuteVariety(request.getParameter("variety"),Integer.parseInt(request.getParameter("basis_no")),request.getParameter("cropyr"),dpcid);
	return gson.toJson(result);
	}	
	
	@RequestMapping("mspGradesPriceList")
	public ModelAndView mspGradesPriceList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("mspGradesPriceList");
		List<MSPPriceCalculationModel> msppriceList = new ArrayList<MSPPriceCalculationModel>();
		try {
			msppriceList = mSPPriceCalculationService.getAll();
		} catch (Exception e) {
		//	System.out.println(e);
		}
		mv.addObject("msppriceList", msppriceList);
		return mv;
	}
	
	
	
	@RequestMapping("updateRulingMarket") 
	public ModelAndView updateRulingMarket(HttpServletRequest request, RedirectAttributes redirectAttributes) 
	{ 
		ModelAndView mv = new ModelAndView("editRulingMarket");
		try {
			String id = request.getParameter("id");
			System.out.println(id);
			String dpcname = request.getParameter("dpcname");
			String noofarrival = request.getParameter("noofarrival");
			String dateofarrival = request.getParameter("dateofarrival");
			String jutevariety = request.getParameter("jutevariety");
			String cropyear = request.getParameter("cropyear");
			String arrivedquantity = request.getParameter("arrivedquantity");
			String minmoisture = request.getParameter("minmoisture");
			String maxmoisture = request.getParameter("maxmoisture");
			String gradewisefield = request.getParameter("gradewisefield");
			String gradewiserate = request.getParameter("gradewiserate");
			String estimatedgradecomposition = request.getParameter("estimatedgradecomposition");
			RulingMarket updaterulingMarket = new RulingMarket();
			updaterulingMarket.setJcirulingmarketid(Integer.parseInt(id));
			updaterulingMarket.setArrivedquantity(Double.parseDouble(arrivedquantity));
			updaterulingMarket.setCropyear(cropyear);
			updaterulingMarket.setDpcname(dpcname);
			updaterulingMarket.setEstimatedgradecomposition(Integer.parseInt(estimatedgradecomposition));
			updaterulingMarket.setGradewisefield(Integer.parseInt(gradewisefield));
			updaterulingMarket.setGradewiserate(Integer.parseInt(gradewiserate));
			updaterulingMarket.setJutevariety(jutevariety);
			updaterulingMarket.setMaxmoisture(Integer.parseInt(maxmoisture));
			updaterulingMarket.setMinmoisture(Integer.parseInt(minmoisture));
			updaterulingMarket.setNoofarrival(noofarrival);
			rulingMarketService.create(updaterulingMarket);
			redirectAttributes.addFlashAttribute("msg",
					"<div class=\"alert alert-success\"><b>Success !</b> Record updated successfully.</div>\r\n" + "");
				return new ModelAndView(new RedirectView("viewRulingMarket.obj"));
		
		} catch(Exception e){
			System.out.println(e);
		}
		return mv; 
	}

	
	@ResponseBody
	@RequestMapping(value = "findVByBlock", method = RequestMethod.GET)
	public String getBlockdata(HttpServletRequest request) {
		String str = request.getParameter("F_Block");
		//System.out.println("str controller"+str);
		Gson gson = new Gson();
		return gson.toJson(block.getAllFilledlock(str));
	}
	
	@ResponseBody
	@RequestMapping(value = "findByPoliceStation", method = RequestMethod.GET)
	public String getpoliceStationdata(HttpServletRequest request) {	
		String str = request.getParameter("PoliceStation");
		//System.out.println("str controller"+str);
		Gson gson = new Gson();
		return gson.toJson(PoliceStationService.getAllFilledPoliceStation(str));
	}

	@RequestMapping("saveBale") 
	public ModelAndView saveBale(HttpServletRequest request,RedirectAttributes redirectAttributes) 
	{ 
		ModelAndView mv = new ModelAndView("editBalePreparation");
		try {
			String packingDate =  request.getParameter("packing_date");
//			if(packingDate!=null) {
//				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-dd-mm");
//				String str_date_1 = packingDate;
//				LocalDate local_date_1 = LocalDate.parse(str_date_1, formatter1);
//				System.out.println(local_date_1 +" ==== "+local_date_1.getc);
//			}
			String dpcname =  request.getParameter("dpcname");
			String cropyr =  request.getParameter("cropyr");
			String binnumb =  request.getParameter("binnumb");
			String basis =  request.getParameter("basis");
			String juteVariety =  request.getParameter("jutevariety");
			//String juteGrade =  request.getParameter("jutegrade");
			String fromCheckSlipNo =  request.getParameter("fromCheckSlipNo");
			String toCheckSlipNo =  request.getParameter("toCheckSlipNo");
			String noOfBales =  request.getParameter("noOfBales");
			String grade0 = request.getParameter("grade0");
			String grade1 = request.getParameter("grade1");
			String grade2 = request.getParameter("grade2");
			String grade3 = request.getParameter("grade3");
			String grade4 = request.getParameter("grade4");
			String grade5 = request.getParameter("grade5");
			String grade6 = request.getParameter("grade6");
			String grade7 = request.getParameter("grade7");
			BalePreparation balePreparation = new BalePreparation();
			//balePreparation.setPackingDate(packingDate);
			balePreparation.setPlaceOfPacking(Integer.parseInt(dpcname));
			balePreparation.setCropYear(cropyr);
			//balePreparation.setPackingDate(packingDate);
			balePreparation.setBinNo(binnumb);
			balePreparation.setBasis(basis);
			balePreparation.setJuteVariety(juteVariety);
			// balePreparation.setJute_grade(Integer.parseInt(juteGrade));
			balePreparation.setSlipNoFrom(fromCheckSlipNo);
			balePreparation.setSlipNoTo(toCheckSlipNo);
			balePreparation.setBale_no(Integer.parseInt(noOfBales));
			if(grade0!=null) {
				balePreparation.setGrade1(Double.parseDouble(grade0));
			}
			if(grade1!=null) {
				
				balePreparation.setGrade2(Double.parseDouble(grade1));
			}
			
			if(grade2!=null) {
				balePreparation.setGrade3(Double.parseDouble(grade2));
			}
			if(grade3!=null) {
				
				balePreparation.setGrade4(Double.parseDouble(grade3));
			}
			if(grade4!=null) {
				
				balePreparation.setGrade5(Double.parseDouble(grade4));
			}
			if(grade5!=null) {
				
				balePreparation.setGrade6(Double.parseDouble(grade5));
			}
			if(grade6!=null) {
				balePreparation.setGrade7(Double.parseDouble(grade6));
			}
			if(grade7!=null) {
				balePreparation.setGrade8(Double.parseDouble(grade7));
			}

			balePrepareService.create(balePreparation);
			redirectAttributes.addFlashAttribute("msg",
				"<div class=\"alert alert-success\"><b>Success !</b> Record created successfully.</div>\r\n" + "");
			return new ModelAndView(new RedirectView("viewbalePreparation.obj"));
		} catch(Exception e){
			System.out.println("Error in save bale preparation");
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "findJuteOnBasis", method = RequestMethod.GET)
	public String findJuteOnBasis(HttpServletRequest request) {
		Gson gson = new Gson();
		List<String> result= new ArrayList<String>();
		result=rawJuteProcurAndPayService.findJuteOnBasis(Integer.parseInt(request.getParameter("msp_no")));
		return gson.toJson(result);
	}
	
	@ResponseBody
	@RequestMapping(value = "findGradeOnJuteVariety", method = RequestMethod.GET)
	public String findGradeOnJuteVariety(HttpServletRequest request) {
		Gson gson = new Gson();
		List<String> result;
		result=rawJuteProcurAndPayService.findGradeOnJuteVariety(request.getParameter("variety"),Integer.parseInt(request.getParameter("basis_no")));
		return gson.toJson(result);
		
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "findGradeOnJute", method = RequestMethod.GET)
	public String findGradeOnJute(HttpServletRequest request) {
		Gson gson = new Gson();
		List<String> result;
		result=jbaservice.findGradeOnJute(request.getParameter("jvariety"));
		return gson.toJson(result);
		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "RouteEditforCheck", method = RequestMethod.GET)
	public String RouteEditforCheck(HttpServletRequest request) {
		String str = request.getParameter("id");
		Gson gson = new Gson();
		List <String> DaysCount = jbaservice.GetDayCountofJBA(request.getParameter("id"));
		Integer DaysCount1=Integer.parseInt(DaysCount.toString().replace("[", "").replace("]", ""));
		System.out.println("Edit JBA LIST value is "+DaysCount1);
		
		return gson.toJson(DaysCount1);
	}

	
	@ResponseBody
	@RequestMapping(value = "GetDpcName", method = RequestMethod.GET)
	public String GetDpcName(HttpServletRequest request) {
		int dpcCode = Integer.parseInt(request.getParameter("dpcCode"));
		Gson gson = new Gson();
		List <String> DaysCount = batchService.GetDpcNamefromId(Integer.parseInt(request.getParameter("dpcCode")));
//		Integer DaysCount1=Integer.parseInt(DaysCount.toString().replace("[", "").replace("]", ""));
		
		String d =DaysCount.toString().replace("[", "").replace("]", "");
		//String result = d.replaceAll("^\"|\"$", "");
		
		 

		/*
		 * if (d.startsWith("\"")) { d = d.substring(1, d.length()); } if
		 * (d.endsWith("\"")) { d = d.substring(0, d.length() - 1); }
		 */
		return gson.toJson(d);
	}
	

}



