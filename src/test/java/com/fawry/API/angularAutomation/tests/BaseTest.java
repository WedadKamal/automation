package com.fawry.API.angularAutomation.tests;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReporter;
import com.fawry.API.angularAutomation.dataModels.AddUpdateBusinessEntityDM;
import com.fawry.API.angularAutomation.dataModels.MainDataModel;
import com.fawry.API.angularAutomation.pages.HomePage;
import com.fawry.API.angularAutomation.pages.LoginPage;
import com.fawry.API.angularAutomation.strategy.TestDataStrategy;
import com.fawry.API.angularAutomation.utils.Log;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.fawry.API.angularAutomation.utils.PropertiesFilesHandler;
import com.fawry.API.angularAutomation.constants.GeneralConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;


public class BaseTest {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest test ;

	public BaseTest () {

		RestAssured.baseURI= generalCofigsProps.getProperty(GeneralConstants.Server_URL);
		RestAssured.basePath = generalCofigsProps.getProperty(GeneralConstants.Link_Be_Base_Path1);
		RestAssured.registerParser("application/json, text/plain, */*", Parser.JSON);
		RestAssured.defaultParser = Parser.JSON;





	}





	//Selenium and Angular webdrivers
	public WebDriver driver;
	NgWebDriver ngDriver;
	JavascriptExecutor jsDriver;

	//Extent report objects


	//ExtentReports(String filePath, Boolean replaceExisting)
	//ExtentReports extent1 = new ExtentReports("ss", false);


	//Initialize instances of properties files to be used in all tests
	PropertiesFilesHandler propHandler = new PropertiesFilesHandler();
	Properties generalCofigsProps = propHandler.loadPropertiesFile(GeneralConstants.GENERAL_CONFIG_FILE_NAME);
	Properties testdataCofigsProps = propHandler.loadPropertiesFile(GeneralConstants.TEST_DATA_CONFIG_FILE_NAME);

	// Browser's default download path config from properties file
	String browserDefaultDownloadpath = generalCofigsProps.getProperty(GeneralConstants.DEFAULT_DOWNLOAD_PATH);

	HomePage homepage;

	String dateTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	String date = new SimpleDateFormat("yyyyMMdd").format(new Date());


	@BeforeTest(description = "Setting up extent report", alwaysRun = true)
	public void setExtentpertest(){
	 extent.attachReporter(htmlReporter);
           }

	@BeforeSuite(description = "Setting up extent report", alwaysRun = true)
	public void setExtent()
	{
		try {
			Log.info("Setting up extent report before test");
			String extentReportFilePath = generalCofigsProps.getProperty(GeneralConstants.EXTENT_REPORT_FILE_PATH);
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + extentReportFilePath +dateTime+ ".html");
			htmlReporter.config().setDocumentTitle(generalCofigsProps.getProperty(GeneralConstants.EXTENT_REPORT_TITLE)); // Tile of report
			htmlReporter.config().setReportName(generalCofigsProps.getProperty(GeneralConstants.EXTENT_REPORT_NAME)); // Name of the report
			htmlReporter.config().setTheme(Theme.DARK);
		//	extent.setSystemInfo("Environment", "QA");

		}
		catch(Exception e)
		{
			Log.error("Error occurred while setting up extent reports", e);
		}

	}

	public Response LinkBe(JSONObject Payload, String endpoint,String token)
	{
		Log.info("sending to End Point http://10.95.0.178/be-api/business-entities" + endpoint);
		this.SendAPILog(Payload);
		Response response = given().header("Authorization", "Bearer " + token).
				contentType("application/json\r\n").body(Payload).when().log()
				.all().put(endpoint);
		this.RespondAPILog(response);
		return response;

	}

	public void LinkAssertion(Response response,List<String> FeaturesList,SoftAssert SoftObj){

		List<String> responselockup = new ArrayList<String>();
		String a = response.asString();


		for (int i = 0; response.then().extract().path("[" + i + "]") != null; i++) {
			String Value = response.then().extract().path("[" + i + "]");
			responselockup.add(Value);
		}

	             for (int i = 0 ; i< responselockup.size() ;i ++){
		String Value= response.then().extract().path("["+i+"]");
		for(int j = 0; j<FeaturesList.size(); j++) {

			if (Value.equalsIgnoreCase(FeaturesList.get(j))){
				SoftObj.assertEquals(FeaturesList.get(j),Value);
				Log.info("Feature Field in DB "+FeaturesList.get(j) +" is Successfully asserted with Feature Field in API Response " +Value);
			}
		} }
	}



	public Response GetFeaturesLinkBe(String endpoint,String token)
	{
		Log.info("sending api to End Point http://10.95.0.178/user-api/business-entities" + endpoint);

		Response response = given().header("Authorization", "Bearer " + token).
				contentType("application/json\r\n").when().log()
				.all().get(endpoint);
		this.RespondAPILog(response);
		return response;

	}
	public void ReportTestCaseTitle(MainDataModel BusinessEntityAPITestData){
		test = extent.createTest(BusinessEntityAPITestData.getTestCaseTitle());
		Log.test = test;
		Log.startTestCase(BusinessEntityAPITestData.getTestCaseTitle());

	}

	public void HandlingDBAssertion(Response response, String Key, SoftAssert AssertionObj,String DBvalue){

		String KeyValue = response.then().extract().path(Key);
		if(KeyValue != null){
			AssertionObj.assertEquals(DBvalue,KeyValue);

		}
	}
	public void HandlingDBAssertionArr(Response response, String Key, SoftAssert AssertionObj,String DBvalue){

		ArrayList KeyValue = response.then().extract().path(Key);
		if(KeyValue != null){
			AssertionObj.assertEquals(DBvalue,KeyValue.get(0));

		}
	}

	public void HandlingDBAssertionint(Response response, String Key, SoftAssert AssertionObj,String DBvalue){

		int keyvalue = response.then().extract().path(Key);

		if( keyvalue != -5){
			AssertionObj.assertEquals(keyvalue,DBvalue);

		}

	}

	public void StatusAssertion(int ActualStatuscode,int expectedStatusCode){
		if (ActualStatuscode == expectedStatusCode){
			Log.info("API successed with Actual Status code " + ActualStatuscode +" which is the expected status code " +expectedStatusCode);
		}else if (ActualStatuscode != expectedStatusCode){
			Log.Fail("API Failed with Actual Status code " + ActualStatuscode + " and the expected status code is " + expectedStatusCode);
		}

	}

	public void SendAPILog(JSONObject payload){
	   Log.info("sending api " + payload);}

	public void SendAPIEndPoint(String EndPoint){
		Log.info("sending api End Point " + EndPoint);}

	public void RespondAPILog(Response response){
            Log.info("API response with " + response.getBody().asString());}

	@Parameters({"url","browserType"})
	//@BeforeClass(description = "Setting up selenium webdriver before each class run", alwaysRun = true)
	public void loadConfiguration(String url,String browserType)
	{
		try {
//			Log.info("Initialize Selenium webdriver before tests' Class");

			// initialize selenium driver that is set as a config in testng.xml
			switch (browserType) {
				case ("Chrome"):
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(setChromeOption());
					break;
				case ("Firefox"):
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver(setFireFoxOption());
					break;
				case ("IE"):
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver();
					break;
				case ("Edge"):
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;
				case ("Opera"):
					WebDriverManager.operadriver().setup();
					driver = new OperaDriver();
					break;
			}

			// initialize angular webdriver
			jsDriver = (JavascriptExecutor) driver;
			ngDriver = new NgWebDriver(jsDriver).withRootSelector("\"app-root\"");
			//ngDriver.waitForAngularRequestsToFinish();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//			Log.info("Selenium webdriver was initialized successfully");
		}
		catch(Exception e)
		{
			Log.error("Error occured while initializing selenium web driver", e);
		}

	}


	//@BeforeClass(description = "Login successfully to the application in order to proceed in business tests", alwaysRun = true)
	public void loginSuccessfully()
	{
//		Log.info("Login with valid credentials before class tests to be able to navigate to required pages frome homepage");
		String vaildUserMail = generalCofigsProps.getProperty(GeneralConstants.VALID_USER_MAIL);
		String vaildUserPassword = generalCofigsProps.getProperty(GeneralConstants.VALID_USER_PASSWORD);
		LoginPage loginPage = new LoginPage(driver, ngDriver);
		loginPage.loginSuccessfully(vaildUserMail, vaildUserPassword);

		//Initialize homepage instance for menulist items navigations
		homepage = new HomePage(driver, ngDriver);
	}

	private ChromeOptions setChromeOption()
	{
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> ChromePrefs = new HashMap<>();
		ChromePrefs.put("profile.default.content_settings.popups", 0);


		ChromePrefs.put("download.default_directory", browserDefaultDownloadpath);
		options.setExperimentalOption("prefs", ChromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}

	private FirefoxOptions setFireFoxOption()
	{
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderlist", 2);
		option.addPreference("browser.download.dir", browserDefaultDownloadpath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		return option;
	}


//	@BeforeMethod(description = "Logging testcase start to log file", alwaysRun = true)
//	public void logTestcaseStart(Method method)
//	{
//		//log test start
//		Log.startTestCase(method.getName());
//	}


	@AfterMethod(description = "Logging test status to log file and extent report", alwaysRun = true)
	public void logTestStatusForReport(ITestResult result) {
		try {
			if (result.getStatus() == ITestResult.FAILURE) {
				Log.info("logging Testcase FAILED " + result.getName() + " in Extent Report");
				test.log(Status.FAIL, "Test Case Name FAILED is " + result.getName()); // to add name in extent report
				test.log(Status.FAIL, "EXCEPTION Thrown is " + result.getThrowable()); // to add error/exception in extent report
				String screenshotPath = getScreenshot(driver, result.getName());
				test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
			} else if (result.getStatus() == ITestResult.SKIP) {
				Log.info("logging Testcase SKIPPED " + result.getName() + " in Extent Report");
				test.log(Status.SKIP, "Test Case SKIPPED is " + result.getName());
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				Log.info("logging Testcase SUCCESS " + result.getName() + " in Extent Report");
				test.log(Status.PASS, "Test Case PASSED is " + result.getName());
			}
			Log.endTestCase(result.getName());
		}
		catch(Exception e)
		{
			Log.warn("Error occured while logging testcase " +result.getName()+ " result to extent report", e);
			e.printStackTrace();
		}
	}

	private String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		Log.info("Taking Screenshot for the FAILED Testcase");

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		//get the path of failed tests screenshots
		String screenShotsPath = generalCofigsProps.getProperty(GeneralConstants.SCREENSHOT_FAILD_TESTS_PATH);

		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + screenShotsPath + date + "/" + screenshotName + dateTime + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}


	//@AfterClass(description = "Quitting selenium driver after each class run", alwaysRun = true)
	public void closeDriver()
	{
//		Log.info("Closing selenium Webdriver after Class");
		if(driver !=null)
			driver.quit();
	}

	@AfterSuite(description = "Closing extent report after running Test", alwaysRun = true)
	public void endReport() {
		try{
		Log.info("Closing Extent report after Test");
		if(extent != null)
			extent.flush();
	}catch (Exception e) {
			Log.error("Error occured while sending test report to recipients " + new Object() {
			}
					.getClass()
					.getName() + "." + new Object() {
			}
					.getClass()
					.getEnclosingMethod()
					.getName(), e);
		}}


/// Check testdata type and retrieve it from its source accordingly
	protected ArrayList<ArrayList<Object>> provideTestData(String methodName)
	{
//		Log.info("Retrieving Test data of testcase " + methodName);

		String connectionProperties = testdataCofigsProps.getProperty(methodName);

		ArrayList<ArrayList<Object>> result = null;
		TestDataStrategy testData;
		String testDataType;
		String testDataTypeClassPath;
		try
		{
			//get test data type to connect to the proper test data source accordingly
			testDataType = testdataCofigsProps.getProperty(GeneralConstants.TEST_DATA_TYPE);

			//get class path of the class that implements methods of proper class path
			testDataTypeClassPath = testdataCofigsProps.getProperty(GeneralConstants.TEST_DATA_TYPE_CLASS_PATH + testDataType);
			//create instance from the proper class of specified data source
			testData = (TestDataStrategy) Class.forName(testDataTypeClassPath).newInstance();

			//load test data from the proper source
			result = testData.loadTestData(connectionProperties);


		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			Log.error("Error occured while retriving test data for Test: " + methodName, e);
		}

		return result;

	}



}
