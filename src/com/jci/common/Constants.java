package com.jci.common;

import java.util.Arrays;
import java.util.List;

public class Constants {

	public final static String STR_MESSAGE = "msg";
	public final static String STR_URL = "url";
	public final static String CAPTCHA = "cap";
	public final static String CAPTCH_ERROR = "capError";
	public final static String CAPTCHA_URL = "captcha";
	public final static String PENDING = "Pending";
	public final static String REJECTED = "Rejected";
	public final static String APPROVED = "Approved";
	public final static String LOGINPAGE = "loginpage";
	public final static String EXPERTSLIST = "exList";
	public final static String REDIRECT = "redirect:";
	public final static String REQUESTED_HEADER = "X-FORWARDED-FOR";
	public final static String USER_AGENT = "User-Agent";
	public static final String USER_MENU = "userMenu";
	public static final String USER_MENU_LIST = "userMenuList";
	public static final String CAPTCHA_ANSWER = "captchaAnswer";
	public static final String CAPTCHA_USER_INPUT = "captchaUserInput";
	public static final String ROLE_SUPER_ADMIN = "superAdmin";
	public static final String ROLE_ADMIN = "admin";
	public static final String ROLE_USER = "user";
	public static final String RESET = "reset";
	public static final String QUERIES = "query";
	public static final String EXPERT_USERS_LIST = "expertUsersList";
	public static final String EXPERT_MAP = "expertMap";
	public static final String EXPERT_TYPE = "expertType";



	/** File Validation*/
	public static final String DOT = ".";
	public static final String COMMA = ",";
	public static final List<String> CONTENT_TYPES = Arrays.asList("png", "jpg", "jpeg","gif");
	public static final Long PROFILE_IMAGE_FILE_SIZE=500L;
	public static final String DATA_IMAGE_BASE64="data:image/##;base64,";

	/** Date Formats */
	public static final String DATEFORMAT_DD_MM_YYYY = "DD-MM-YYYY";
	public static final String DATEFORMAT_DD_MMM_YYYY = "DD-MMM-YYYY";
	public static final String DATEFORMAT_dd_mm_yyyy = "dd-mm-yyyy";
	public static final String DATEFORMAT_dd_mmm_yyyy = "dd-mmm-yyyy";
	public static final String DATEFORMAT_DD_MM_YYYY_hh_mm_ss_a = "DD-MM-YYYY hh:mm:ss a";
	public static final String DATEFORMAT_dd_mm_yyyy_hh_mm_ss_a = "dd-mm-yyyy hh:mm:ss a";
	public static final String DATEFORMAT_DD_MM_YYYY_hh_mm_ss = "DD-MM-YYYY hh:mm:ss";
	public static final String DATEFORMAT_dd_mm_yyyy_hh_mm_ss = "dd-mm-yyyy hh:mm:ss";
	public static final String DATEFORMAT_DDMMYYYYhhmmssahms = "DDMMYYYYhhmmssahms";
	public static final String DATEFORMAT_ddmmyyyyhhmmssahms = "ddmmyyyyhhmmssahms";
	public static final String DATEFORMAT_hhammsshhmmss = "hhammsshhmmss";



	/** Uploaded File Types */
	public static final String BASE_PATH = "BASE_PATH";
	public static final String IMAGE_PATH = "IMAGE_PATH";
	public static final String FILE_PATH = "FILE_PATH";
	public static final String IMAGE_PROFILE = "imageProfile";
	public static final String IMAGE_NEWS_UPDATES = "imageNewsUpdates";
	public static final String IMAGE_OTHERS = "imageOthers";

	/** Login URLs */
	public final static String USER_SESSION = "usersession";
	public final static String LOGIN_PAGE = "/loginpage";
	public final static String LOGIN_PROCESSING = "/loginProcessing";
	public final static String LOGOUT = "/logout";
	public final static String LOG_OUT = "/log_out";
	public final static String SESSION_EXPIRED = "/sessionExpired";
	public final static String LOGIN_NEW = "/loginNew";

	/** User Access */
	public static final String KNOW_YOUR_EXPERTS = "/knowYourExperts";
	public static final String ALL_AVAILABLE_SOLUTION = "/allAvailableSolution";
	public static final String KNOWLEDGE_REPOSITORY = "/knowledgeRepository";
	public static final String IMPLORTED_ITEMS = "/implortedItems";
	public static final String POSE_PROBLEM = "/poseProblem";
	public static final String ADD_ANNOUNCEMENT = "/announcement";
	public static final String SOLUTION_SOUGHT_BY_ME = "/solutionSoughtByMe";
	public static final String SOLUTION_OFFERED_BY_ME = "/solutionOfferedByMe";
	public static final String MY_PROFILE = "/myProfile";
	public static final String MY_PROFILE_TAB = "/myProfileTab";
	public static final String PROPOSE_SOLUTION = "/proposeSolution";
	public final static String ORGANIZATION_TYPE = "/organizationType";
	public final static String USER_STATUS_LIST = "userList";
	public final static String GET_EXPERT_BY_ID = "/expertid";
	public final static String GET_EXPERT = "/getExpert";
	public final static String GET_SUB_EXPERT = "/getSubExpert";
	public final static String CONTEXT = "/bhel";
	public final static String RESOURCES = "/resources/**";
	public final static String FORGET_PASSWORD = "/forgetPassword";
	public final static String FORGET_PASSWORD_SAVE = "/forgetPasswordSave";
	public final static String CHANGE_PASSWORD = "/changePassword";
	public final static String SAVE_CHANGE_PASSWORD = "/saveChangePassword";
	public final static String USER_REGISTRATION = "/userRegistration";
	public final static String INDEX_PAGE = "/home";
	public final static String ERR = "/err";
	public final static String ERROR = "/error";
	public final static String LOGIN_ERROR = "/login-erro";
	public final static String LOGIN_ERROR_PAGE = "/loginpage?error=true";

	/** Super Admin or Admin Access */
	public static final String FACILITIES_SERVICES = "/facilitiesServices";
	public static final String MODERATOR_PROBLEMS = "/moderatorProblems";
	public static final String MODERATOR_SOLUTIONS = "/moderatorSolution";
	public static final String LATEST_UPDATES = "/latestUpdates";
	public static final String ORG_INS_ADDITION = "/orgInsAddition";
	public static final String USER_STATUS = "/userStatus";
	public static final String COORDINATORS_LIST = "/coordinatorsList";
	public static final String FEEDBACK_REPORT = "/feedbackReport";
	public static final String ABUSE_APPROVAL = "/abuseApproval";
	public static final String CONTACT_US_VIEW = "/contactUsView";
	public static final String ANY_OTHER_QUERY_REPORT = "/anyOtherQueryReport";
	public static final String ANY_OTHER_TAG_REPORT = "/anyOtherTagReport";
	public static final String LOCALHOST = "localhost";
	public static final String LatestUps = "/latestups";
	public static final String KnowYourExp = "/know-your-experts";
	public static final String SOLUTION = "/solution";
	public static final String ADD_DATA = "/add-data";
	public static final String QUERY_EDIT = "/queryEdit";
	public static final String QueryUpdate = "/queryUpdate";
	public static final String CONTACT_API_URL = "/contactus";
	public static final String GET_COMPANY_NAME = "/companydata";

	public static final String GET_EXPERT_VIEW ="/expertview";

	public static final String GET_FACDATA = "/facilitiesdata";


}
