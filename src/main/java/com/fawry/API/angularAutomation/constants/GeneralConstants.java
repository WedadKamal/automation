package com.fawry.API.angularAutomation.constants;

public class GeneralConstants {

	// *************************    General constants used allover the app   ********************************
	public static final String CLEAR = "CLEAR";
	public static final String SUCCESS = "Success";
	public static final String FAILED = "Failed";
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	public static final String TEST_SCOPE_SMOKE = "Smoke";
	public static final String TEST_SCOPE_FULL = "Full";
	public static final String TEST_CASE_METHOD_ADD = "Add";
	public static final String TEST_CASE_METHOD_UPDATE = "Update";
	public static final String STRING_DELIMETER = "#";
	public static final String FILE_DELIMETER = "/";
	public static final String MISMATCH_ERR_MSG = " Mismatched the VALUE that was entered in screen";
	public static final String POM_EXCEPTION_ERR_MSG = "Test Failed due to an exception occured in POM's method";
	public static final String ERR_TYPE_PAGE = "page";
	public static final String ERR_TYPE_NOTIFICATION = "notification";
	public static final String ERR_TYPE_CustomerNotFound = "CustomerNotFound";
	public static final String Add_Admin_Result = "AddAdminResult";
	public static final String SUCCESS_MSG = "SuccessMessage";


	public static final String PROMO_DB_NAME = "PROMO";
	public static final String PROMO_DB_URL_KEY = "PROMO_DB_URL";
	public static final String PROMO_DB_USERNAME_KEY = "PROMO_DB_Username";
	public static final String PROMO_DB_PASSWORD_KEY = "PROMO_DB_Password";


	public static final String BUSINESSENTITY_DB_NAME = "BUSINESS_ENTITY";
	public static final String BUSINESSENTITY_DB_URL_KEY = "BUSINESSENTITY_DB_URL";
	public static final String BUSINESSENTITY_DB_USERNAME_KEY = "BUSINESSENTITY_DB_Username";
	public static final String BUSINESSENTITY_DB_PASSWORD_KEY = "BUSINESSENTITY_DB_Password";


	public static final String USERS_DB_NAME = "USERS";
	public static final String USERS_DB_URL_KEY = "USERS_DB_URL";
	public static final String USERS_DB_USERNAME_KEY = "USERS_DB_Username";
	public static final String USERS_DB_PASSWORD_KEY = "USERS_DB_Password";

	// *************************    General constants to add admin successfully   ********************************
	public static final String ADMIN_USERNAME = "Entesar Mohamed";
	public static final String ADMIN_MAIL= "login.BO.userMail";
	public static final String ADMIN_PASSWORD ="login.BO.passw0rd";
	public static final String BE_MAIL= "login.BE.userMail";
	public static final String BE_MAIL_Update= "login.BE.userMailforUpdate";
	public static final String BE_PASSWORD ="login.BE.passw0rd";
	public static final String LOGIN_ENDPOINT ="login.endpoint";
	public static final String ADMIN_CONFIRMATION_PASSWORD ="P@ssw0rd";
	public static final String ADMIN_ROLE ="CSR_ADMIN";



// **********************************************************************************************************

//  **********************   Test Data config file and its properties key names ***************************

	//Test data configs file and its properties key names
	public static final String TEST_DATA_CONFIG_FILE_NAME = "configFiles//TestDataConfig.properties";

	// Test data strategy to get test data source type and implementing classes
	public static final String TEST_DATA_TYPE = "TestDataType";
	public static final String TEST_DATA_TYPE_CLASS_PATH = "TestDataStrategyClassPath_";
// **********************************************************************************************************

	//  **********************   General config file and its properties key names ***************************
	public static final String GENERAL_CONFIG_FILE_NAME = "configFiles//GeneralConfigs.properties";

	public static final String SMOKE_TEST_FLAG = "isSmockTestScopeEnabled";

	public static final String DEFAULT_DOWNLOAD_PATH = "defaultDownloadPath";

	// Extent report conffigs
	public static final String SCREENSHOT_FAILD_TESTS_PATH = "screenshotsOfFailedTestsPath";
	public static final String EXTENT_REPORT_FILE_PATH = "extentReportFilepath";
	public static final String EXTENT_REPORT_TITLE = "extentReportTitle";
	public static final String EXTENT_REPORT_NAME = "extentReportName";
	public static final String ADD_LOG_TO_EXTENT_REPORT = "addLogToExtentReport";

	//CSr login credentials
	public static final String VALID_USER_MAIL = "login.userMail";
	public static final String VALID_USER_PASSWORD = "login.passw0rd";

	//CSr Search for customer
	public static final String VALID_CUSTOMER_MAIL = "Search.customerMail";
	public static final String VALID_Admin_MAIL = "Search.adminMail";


	//Be Link BasePath
	public static final String Server_URL ="Server_URL";
	public static final String Link_Be_Base_Path1 ="BELinkBasePath1";
	public static final String Link_Be_Base_Path ="BELinkBasePath";
	public static final String Profile_Be_Base_Path ="BEProfileBasePath";


	// Deployment server's OS type to get application's log file accordingly using strategy
	public static final String LOG_SERVER_TYPE = "logServerOS";
	public static final String LOG_SERVER_TYPE_CLASS_PATH = "serverLogStrategyClassPath_";

	public static final String LOG_SERVER_IP = "logServerIp";
	public static final String LOG_SERVER_USERNAME = "logServerUserName";
	public static final String LOG_SERVER_PASSWRD = "logServerPassword";
	public static final String LOG_SERVER_PORT = "logServerPort";
	public static final String LOG_SERVER_IN_CONTAINER = "isDockerContainer";
	public static final String LOG_SERVER_FILE_PATH_IN_CONTAINER = "logFilePathOnServerInContainer";
	public static final String SSH_CMD_TO_GET_CONTAINER_ID = "sshRunCmdToGetContainerID";
	public static final String LOG_SERVER_FILE_PATH = "logFilePathOnServer";
	public static final String LOG_LOCAL_FILE_PATH = "localLogFileDirectory";
	public static final String LOG_LOCAL_FILE_SIZE = "logFileSizeInBytes";
// **********************************************************************************************************


	// *****************     Database config file and its properties key names     **************************
	public static final String DB_CONFIG_FILE_NAME = "configFiles//DBConfigs.properties";

	//Different DB configs
	public static final String CSR_DB_NAME = "MYFAWRY";
	public static final String GW_DB_NAME = "GW";
	public static final String SOF_DB_NAME = "SOF";
	public static final String SW_DB_NAME = "SW";

	public static final String CSR_DB_URL_KEY = "CSR_DB_URL";
	public static final String CSR_DB_USERNAME_KEY = "CSR_DB_Username";
	public static final String CSR_DB_PASSWORD_KEY = "CSR_DB_Password";

	public static final String GW_DB_URL_KEY = "GW_DB_URL";
	public static final String GW_DB_USERNAME_KEY = "GW_DB_Username";
	public static final String GW_DB_PASSWORD_KEY = "GW_DB_Password";

	public static final String SOF_DB_URL_KEY = "SOF_DB_URL";
	public static final String SOF_DB_USERNAME_KEY = "SOF_DB_Username";
	public static final String SOF_DB_PASSWORD_KEY = "SOF_DB_Password";

	public static final String SW_DB_URL_KEY = "SW_DB_URL";
	public static final String SW_DB_USERNAME_KEY = "SW_DB_Username";
	public static final String SW_DB_PASSWORD_KEY = "SW_DB_Password";

// **********************************************************************************************************

}
