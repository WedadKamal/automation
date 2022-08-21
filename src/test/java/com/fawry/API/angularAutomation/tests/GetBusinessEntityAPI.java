package com.fawry.API.angularAutomation.tests;

import com.fawry.API.angularAutomation.backendServices.ServicesDelegate;
import com.fawry.API.angularAutomation.backendServices.database.daos.BEDaos;
import com.fawry.API.angularAutomation.constants.GeneralConstants;
import com.fawry.API.angularAutomation.constants.excelIndices.AddUpdateBusinessEntityExcellndices;
import com.fawry.API.angularAutomation.dataModels.AddUpdateBusinessEntityDM;
import com.fawry.API.angularAutomation.dataModels.GetBusinessEntityDM;
import com.fawry.API.angularAutomation.pages.GetBusinessEntityPage;
import com.fawry.API.angularAutomation.utils.Log;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.bytebuddy.implementation.bind.annotation.Super;
import net.minidev.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.fawry.API.angularAutomation.utils.Log.test;
import static io.restassured.RestAssured.given;
import static java.lang.Integer.parseInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetBusinessEntityAPI extends BaseTest{

    String endPoint = "/search";
    ApiLogin LgnObj = new ApiLogin();
    String token =LgnObj.GetloginToken();



    @Test(enabled = false)
    public void getBusinessEntity() {

        System.out.println(token);
        Response response=    given().header("Authorization", "Bearer " + token).contentType("application/json\r\n")
                        .body("{}").when().log()
                .all().post(endPoint).then().assertThat().statusCode(200)
                .body("businessEntityModels.id",everyItem(notNullValue()))
                .body("businessEntityModels.nameAr",everyItem(notNullValue()))
                .body("businessEntityModels.nameEn",everyItem(notNullValue()))
                .body("businessEntityModels.phoneNumber",everyItem(notNullValue()))
                .body("businessEntityModels.email",everyItem(notNullValue()))
                .body("businessEntityModels.nameAr[0]",equalTo("ميرشانت برودكت"))
                .body("businessEntityModels.nameEn[0]",equalTo("AmalProduct"))
                .body("businessEntityModels.phoneNumber[0]",equalTo("01282716882"))
                .body("businessEntityModels.email[0]",equalTo("Eng.amal87@gmail.com"))
                .body("businessEntityModels.account.businessEntity.nameAr",everyItem(notNullValue()))
                .body("businessEntityModels.account.businessEntity.nameEn",everyItem(notNullValue()))
                .body("businessEntityModels.account.businessEntity.phoneNumber",everyItem(notNullValue()))
                .body("businessEntityModels.account.businessEntity.email",everyItem(notNullValue()))
                .body("businessEntityModels.account.businessEntity.nameAr[0]",equalTo("ميرشانت برودكت"))
                .body("businessEntityModels.account.businessEntity.nameEn[0]",equalTo("AmalProduct"))
                .body("businessEntityModels.account.businessEntity.phoneNumber[0]",equalTo("01282716882"))
                .body("businessEntityModels.account.businessEntity.email[0]",equalTo("Eng.amal87@gmail.com"))
                .extract().response();

        List<Map<String, String>> businessEntityModels = response.jsonPath().getList("businessEntityModels");
        System.out.println(businessEntityModels.size());
        String NameEn =businessEntityModels.get(0).get("nameEn");

        System.out.println(NameEn);


/*        GetBusinessEntityDM ExpectedBusinessEntity = new GetBusinessEntityDM("ميرشانت برودكت","AmalProduct","01282716882","Eng.amal87@gmail.com");
        GetBusinessEntityDM ActualBusinessEntity=  given().header("Authorization", "Bearer " + token).contentType("application/json\r\n")
                .body(Payload).when().post(endPoint).as(GetBusinessEntityDM.class);
                 assertThat(ActualBusinessEntity,samePropertyValuesAs(ExpectedBusinessEntity));*/
       // Map<String, String> businessEntityModels2 = response2.jsonPath().getMap("businessEntityModels");

      // GetBusinessEntityDM ActualBusinessEntity=  response2.as(GetBusinessEntityDM.class);


       // ArrayList<String>=response.path("businessEntityModels");
//        JsonPath jsonPathEvaluator = response.jsonPath();
  //     ArrayList<JsonPath> businessEntityModels= jsonPathEvaluator.get("businessEntityModels");


  //    System.out.println(response.size());

        GetBusinessEntityDM GetBeOb = new GetBusinessEntityDM();
        String Payload = GetBeOb.getPayload();
       //again for log only
        ValidatableResponse Response=  given().header("Authorization", "Bearer " + token).contentType("application/json\r\n").queryParam("nameEn","AmalProduct")
                .body(Payload).when().post(endPoint).then();


        //.body("nameEn"equalTo"AmalProduct");
      Response.log().body();


    }

    @Test(description = "return all get businessentity count right", priority = 0)
    public  void getBusinessEntityCountValidation(){
        try {
            test = extent.createTest("Check Business Entity Count Validation");
            Log.test = test;
            Log.startTestCase("Check Business Entity Count Validation");
            try{
        Response response=    given().header("Authorization", "Bearer " + token).contentType("application/json\r\n")
                .body("{}").when().log()
                .all().post(endPoint);



           RespondAPILog(response);
           int ActualStatusCode = response.getStatusCode();
           int ActualAPIBECount = response.then().extract().path("resultCount");

            BEDaos BED = new BEDaos();
            AddUpdateBusinessEntityDM BusinessEntityInDB = BED.getBECount();
            if (ActualStatusCode==200 && BusinessEntityInDB.getCount()== ActualAPIBECount) {

                response.then().assertThat().body("resultCount", equalTo(BusinessEntityInDB.getCount()));
                Log.info("API successed with Actual API Response Validation BusinessEntity Count which is " +ActualAPIBECount
                + " which is the same in Database with " + BusinessEntityInDB.getCount());
            }
            } catch (AssertionError error) {
                Log.AssertionError("Error occurred in " + new Object() {
                }
                        .getClass().getName() + "." + new Object() {
                }
                        .getClass()
                        .getEnclosingMethod()
                        .getName(), error);
                Assert.fail();

            }
        } catch (Exception erro) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), erro);
            Assert.fail();

        }


    }


    @Test(description = "View Business entity by email API ",dataProvider = "BEView", priority = 1)
    public void ViewBeAPIByEmail(AddUpdateBusinessEntityDM DMObj) {

        try {
            test = extent.createTest("Check View Data (get BE API ) using search by email");
            Log.test = test;
            Log.startTestCase("Check View Data (get BE API ) using search by email");
            try {
                SoftAssert softObj = new SoftAssert();
                String Criteria = "email";
                String NameEn = DMObj.getBE_nameEn();
                ServicesDelegate backendService = new ServicesDelegate();
                AddUpdateBusinessEntityDM BusinessEntityInDB = backendService.getBEDetails(NameEn, GeneralConstants.TEST_CASE_METHOD_ADD);
                String EMailinDB = BusinessEntityInDB.getBE_email();
                JSONObject payload = new JSONObject();
                GetBusinessEntityPage GetPageObj = new GetBusinessEntityPage();
                GetPageObj.BEViewByParam(EMailinDB, Criteria, payload);
                this.SendAPILog(payload);
                Response response = given().header("Authorization", "Bearer " + token).contentType("application/json\r\n")
                        .body(payload).when().log()
                        .all().post(endPoint);
                RespondAPILog(response);
                int ActualStatusCode = response.getStatusCode();
                int countResponseAPI = response.then().extract().path("resultCount");
                List<Map<String, String>> businessEntityModels = response.jsonPath().getList("businessEntityModels");
                System.out.println(businessEntityModels.size());
                if (businessEntityModels.size() > 0 && ActualStatusCode == 200 && BusinessEntityInDB.getBE_nameEn().equalsIgnoreCase(businessEntityModels.get(0).get("nameEn"))) {
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("nameAr"),softObj,BusinessEntityInDB.getBE_nameAr());
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("nameEn"),softObj,BusinessEntityInDB.getBE_nameEn());
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("phoneNumber"),softObj,BusinessEntityInDB.getBE_phoneNumber());
                    HandlingDBAssertionArr(response, "businessEntityModels.email",softObj,BusinessEntityInDB.getBE_email());
                    HandlingDBAssertion(response, "businessEntityModels.type.code[0]",softObj,BusinessEntityInDB.getType_code());
                    HandlingDBAssertion(response,"businessEntityModels.type.nameEn[0]",softObj,BusinessEntityInDB.getType_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.type.nameAr[0]",softObj,BusinessEntityInDB.getType_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.category.code[0]",softObj,BusinessEntityInDB.getCategory_code());
                    HandlingDBAssertion(response,"businessEntityModels.category.nameEn[0]",softObj,BusinessEntityInDB.getCategory_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.category.nameAr[0]",softObj,BusinessEntityInDB.getCategory_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.csp.code[0]",softObj,BusinessEntityInDB.getCSP_code());
                    HandlingDBAssertion(response,"businessEntityModels.csp.nameEn[0]",softObj,BusinessEntityInDB.getCSP_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.csp.nameAr[0]",softObj,BusinessEntityInDB.getCSP_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.csp.channelCode[0]",softObj,BusinessEntityInDB.getCSP_channelCode());
                    HandlingDBAssertion(response,"businessEntityModels.csp.sofUrl[0]",softObj,BusinessEntityInDB.getCSP_sofUrl());
                    HandlingDBAssertion(response,"businessEntityModels.csp.sender[0]",softObj,BusinessEntityInDB.getCSP_sender());
                    HandlingDBAssertion(response,"businessEntityModels.channels.code[0][2]",softObj,BusinessEntityInDB.getChannels_INT_code());
                    HandlingDBAssertion(response,"businessEntityModels.channels.nameEn[0][2]",softObj,BusinessEntityInDB.getChannels_INT_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.channels.nameAr[0][2]",softObj,BusinessEntityInDB.getChannels_INT_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.address.address[0]",softObj,BusinessEntityInDB.getAddress());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.code[0]",softObj,BusinessEntityInDB.getAddress_area_code());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.nameEn[0]",softObj,BusinessEntityInDB.getAddress_area_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.nameAr[0]",softObj,BusinessEntityInDB.getAddress_area_nameAr());//       HandlingDBAssertion(response,"address.region.id", AssertionObj,BusinessEntityInDB.getAddress_region_id());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.code[0]",softObj,BusinessEntityInDB.getAddress_region_code());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.nameEn[0]",softObj,BusinessEntityInDB.getAddress_region_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.nameAr[0]",softObj,BusinessEntityInDB.getAddress_region_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.logoUri[0]",softObj,BusinessEntityInDB.getLogo_URI());

                } else if (businessEntityModels.size() == 0) {
                    softObj.assertTrue(countResponseAPI == 0);
                    Log.Fail("API Failed with no data appear for BusinessEntity Already Added in Database");

                }
                softObj.assertAll(); //byo2f hena lw feh 7aga false lw true ykml 3l log info
                Log.info("get BusinessEntity by " + Criteria + " API successed with Assertion fields in Database with API Response");
            } catch (AssertionError error) {
                Log.AssertionError("Error occurred in " + new Object() {
                }
                        .getClass().getName() + "." + new Object() {
                }
                        .getClass()
                        .getEnclosingMethod()
                        .getName(), error);
                Assert.fail();

            }

        } catch (Exception erro) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), erro);
            Assert.fail();

        }
    }

    @Test(description = "View Business entity by EnName API ",dataProvider = "BEView",priority = 2)
    public void ViewBeAPIByEnName(AddUpdateBusinessEntityDM DMObj) {

        try {
            test = extent.createTest("Check View Data (get BE API ) using search by EnName");
            Log.test = test;
            Log.startTestCase("Check View Data (get BE API ) using search by EnName");
            try {
                SoftAssert softObj = new SoftAssert();
                String Criteria = "nameEn";
                String NameEn = DMObj.getBE_nameEn();
                ServicesDelegate backendService = new ServicesDelegate();
                AddUpdateBusinessEntityDM BusinessEntityInDB = backendService.getBEDetails(NameEn, GeneralConstants.TEST_CASE_METHOD_ADD);
                String NameEninDB = BusinessEntityInDB.getBE_nameEn();
                JSONObject payload = new JSONObject();
                GetBusinessEntityPage GetPageObj = new GetBusinessEntityPage();
                GetPageObj.BEViewByParam(NameEninDB, Criteria, payload);
                this.SendAPILog(payload);
                Response response = given().header("Authorization", "Bearer " + token).contentType("application/json\r\n")
                        .body(payload).when().log()
                        .all().post(endPoint);
                RespondAPILog(response);
                int ActualStatusCode = response.getStatusCode();
                int countResponseAPI = response.then().extract().path("resultCount");
                List<Map<String, String>> businessEntityModels = response.jsonPath().getList("businessEntityModels");
                System.out.println(businessEntityModels.size());
                if (businessEntityModels.size() > 0 && ActualStatusCode == 200 && BusinessEntityInDB.getBE_nameEn().equalsIgnoreCase(businessEntityModels.get(0).get("nameEn"))) {
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("nameAr"),softObj,BusinessEntityInDB.getBE_nameAr());
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("nameEn"),softObj,BusinessEntityInDB.getBE_nameEn());
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("phoneNumber"),softObj,BusinessEntityInDB.getBE_phoneNumber());
                    HandlingDBAssertionArr(response, "businessEntityModels.email",softObj,BusinessEntityInDB.getBE_email());
                    HandlingDBAssertion(response, "businessEntityModels.type.code[0]",softObj,BusinessEntityInDB.getType_code());
                    HandlingDBAssertion(response,"businessEntityModels.type.nameEn[0]",softObj,BusinessEntityInDB.getType_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.type.nameAr[0]",softObj,BusinessEntityInDB.getType_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.category.code[0]",softObj,BusinessEntityInDB.getCategory_code());
                    HandlingDBAssertion(response,"businessEntityModels.category.nameEn[0]",softObj,BusinessEntityInDB.getCategory_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.category.nameAr[0]",softObj,BusinessEntityInDB.getCategory_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.csp.code[0]",softObj,BusinessEntityInDB.getCSP_code());
                    HandlingDBAssertion(response,"businessEntityModels.csp.nameEn[0]",softObj,BusinessEntityInDB.getCSP_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.csp.nameAr[0]",softObj,BusinessEntityInDB.getCSP_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.csp.channelCode[0]",softObj,BusinessEntityInDB.getCSP_channelCode());
                    HandlingDBAssertion(response,"businessEntityModels.csp.sofUrl[0]",softObj,BusinessEntityInDB.getCSP_sofUrl());
                    HandlingDBAssertion(response,"businessEntityModels.csp.sender[0]",softObj,BusinessEntityInDB.getCSP_sender());
                    HandlingDBAssertion(response,"businessEntityModels.channels.code[0][2]",softObj,BusinessEntityInDB.getChannels_INT_code());
                    HandlingDBAssertion(response,"businessEntityModels.channels.nameEn[0][2]",softObj,BusinessEntityInDB.getChannels_INT_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.channels.nameAr[0][2]",softObj,BusinessEntityInDB.getChannels_INT_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.address.address[0]",softObj,BusinessEntityInDB.getAddress());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.code[0]",softObj,BusinessEntityInDB.getAddress_area_code());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.nameEn[0]",softObj,BusinessEntityInDB.getAddress_area_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.nameAr[0]",softObj,BusinessEntityInDB.getAddress_area_nameAr());//       HandlingDBAssertion(response,"address.region.id", AssertionObj,BusinessEntityInDB.getAddress_region_id());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.code[0]",softObj,BusinessEntityInDB.getAddress_region_code());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.nameEn[0]",softObj,BusinessEntityInDB.getAddress_region_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.nameAr[0]",softObj,BusinessEntityInDB.getAddress_region_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.logoUri[0]",softObj,BusinessEntityInDB.getLogo_URI());

                } else if (businessEntityModels.size() == 0) {
                    softObj.assertTrue(countResponseAPI == 0);
                    Log.Fail("API Failed with no data appear for BusinessEntity Already Added in Database");

                }
                softObj.assertAll(); //byo2f hena lw feh 7aga false lw true ykml 3l log info
                Log.info("get BusinessEntity by " + Criteria + " API successed with Assertion fields in Database with API Response");
            } catch (AssertionError error) {
                Log.AssertionError("Error occurred in " + new Object() {
                }
                        .getClass().getName() + "." + new Object() {
                }
                        .getClass()
                        .getEnclosingMethod()
                        .getName(), error);
                Assert.fail();

            }

        } catch (Exception erro) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), erro);
            Assert.fail();

        }
    }

    @Test(description = "View Business entity by PhoneNumber", dataProvider = "BEView",priority = 3)
    public void ViewBeAPIByPhoneNumber(AddUpdateBusinessEntityDM DMObj) {

        try {
            test = extent.createTest("Check View Data (get BE API ) using search by PhoneNumber");
            Log.test = test;
            Log.startTestCase("Check View Data (get BE API ) using search by PhoneNumber");
            try {
                SoftAssert softObj = new SoftAssert();
                String Criteria = "phoneNumber";
                String NameEn = DMObj.getBE_nameEn();
                ServicesDelegate backendService = new ServicesDelegate();
                AddUpdateBusinessEntityDM BusinessEntityInDB = backendService.getBEDetails(NameEn, GeneralConstants.TEST_CASE_METHOD_ADD);
                String PhoneNumberinDB = BusinessEntityInDB.getBE_phoneNumber();
                JSONObject payload = new JSONObject();
                GetBusinessEntityPage GetPageObj = new GetBusinessEntityPage();
                GetPageObj.BEViewByParam(PhoneNumberinDB, Criteria, payload);
                this.SendAPILog(payload);
                Response response = given().header("Authorization", "Bearer " + token).contentType("application/json\r\n")
                        .body(payload).when().log()
                        .all().post(endPoint);
                RespondAPILog(response);
                int ActualStatusCode = response.getStatusCode();
                int countResponseAPI = response.then().extract().path("resultCount");
                List<Map<String, String>> businessEntityModels = response.jsonPath().getList("businessEntityModels");
                System.out.println(businessEntityModels.size());
                if (businessEntityModels.size() > 0 && ActualStatusCode == 200 && BusinessEntityInDB.getBE_nameEn().equalsIgnoreCase(businessEntityModels.get(0).get("nameEn"))) {
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("nameAr"),softObj,BusinessEntityInDB.getBE_nameAr());
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("nameEn"),softObj,BusinessEntityInDB.getBE_nameEn());
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("phoneNumber"),softObj,BusinessEntityInDB.getBE_phoneNumber());
                    HandlingDBAssertionArr(response, "businessEntityModels.email",softObj,BusinessEntityInDB.getBE_email());
                    HandlingDBAssertion(response, "businessEntityModels.type.code[0]",softObj,BusinessEntityInDB.getType_code());
                    HandlingDBAssertion(response,"businessEntityModels.type.nameEn[0]",softObj,BusinessEntityInDB.getType_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.type.nameAr[0]",softObj,BusinessEntityInDB.getType_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.category.code[0]",softObj,BusinessEntityInDB.getCategory_code());
                    HandlingDBAssertion(response,"businessEntityModels.category.nameEn[0]",softObj,BusinessEntityInDB.getCategory_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.category.nameAr[0]",softObj,BusinessEntityInDB.getCategory_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.csp.code[0]",softObj,BusinessEntityInDB.getCSP_code());
                    HandlingDBAssertion(response,"businessEntityModels.csp.nameEn[0]",softObj,BusinessEntityInDB.getCSP_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.csp.nameAr[0]",softObj,BusinessEntityInDB.getCSP_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.csp.channelCode[0]",softObj,BusinessEntityInDB.getCSP_channelCode());
                    HandlingDBAssertion(response,"businessEntityModels.csp.sofUrl[0]",softObj,BusinessEntityInDB.getCSP_sofUrl());
                    HandlingDBAssertion(response,"businessEntityModels.csp.sender[0]",softObj,BusinessEntityInDB.getCSP_sender());
                    HandlingDBAssertion(response,"businessEntityModels.channels.code[0][2]",softObj,BusinessEntityInDB.getChannels_INT_code());
                    HandlingDBAssertion(response,"businessEntityModels.channels.nameEn[0][2]",softObj,BusinessEntityInDB.getChannels_INT_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.channels.nameAr[0][2]",softObj,BusinessEntityInDB.getChannels_INT_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.address.address[0]",softObj,BusinessEntityInDB.getAddress());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.code[0]",softObj,BusinessEntityInDB.getAddress_area_code());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.nameEn[0]",softObj,BusinessEntityInDB.getAddress_area_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.nameAr[0]",softObj,BusinessEntityInDB.getAddress_area_nameAr());//       HandlingDBAssertion(response,"address.region.id", AssertionObj,BusinessEntityInDB.getAddress_region_id());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.code[0]",softObj,BusinessEntityInDB.getAddress_region_code());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.nameEn[0]",softObj,BusinessEntityInDB.getAddress_region_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.nameAr[0]",softObj,BusinessEntityInDB.getAddress_region_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.logoUri[0]",softObj,BusinessEntityInDB.getLogo_URI());

                } else if (businessEntityModels.size() == 0) {
                    softObj.assertTrue(countResponseAPI == 0);
                    Log.Fail("API Failed with no data appear for BusinessEntity Already Added in Database");

                }
                softObj.assertAll(); //byo2f hena lw feh 7aga false lw true ykml 3l log info
                Log.info("get BusinessEntity by " + Criteria + " API successed with Assertion fields in Database with API Response");
            } catch (AssertionError error) {
                Log.AssertionError("Error occurred in " + new Object() {
                }
                        .getClass().getName() + "." + new Object() {
                }
                        .getClass()
                        .getEnclosingMethod()
                        .getName(), error);
                Assert.fail();

            }

        } catch (Exception erro) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), erro);
            Assert.fail();

        }
    }

    @Test(description = "View Business entity by Category and NameEn", dataProvider = "BEView", priority = 4)
    public void ViewBeAPIByCategory(AddUpdateBusinessEntityDM DMObj) {

        try {
            test = extent.createTest("Check View Data (get BE API ) using search by Category and NameEn");
            Log.test = test;
            Log.startTestCase("Check View Data (get BE API ) using search by Category and NameEn");
            try {
                SoftAssert softObj = new SoftAssert();
                String Criteria = "category";
                String CategoryName="Online Store";
                String NameEn = DMObj.getBE_nameEn();
                ServicesDelegate backendService = new ServicesDelegate();
                AddUpdateBusinessEntityDM BusinessEntityInDB = backendService.getBEDetails(NameEn, GeneralConstants.TEST_CASE_METHOD_ADD);
                String PhoneNumberinDB = BusinessEntityInDB.getBE_phoneNumber();
                JSONObject payload = new JSONObject();
                GetBusinessEntityPage GetPageObj = new GetBusinessEntityPage();
                GetPageObj.BEViewByTwoParam(CategoryName, Criteria, NameEn, payload);
                this.SendAPILog(payload);
                Response response = given().header("Authorization", "Bearer " + token).contentType("application/json\r\n")
                        .body(payload).when().log()
                        .all().post(endPoint);
                RespondAPILog(response);
                int ActualStatusCode = response.getStatusCode();
                int countResponseAPI = response.then().extract().path("resultCount");
                List<Map<String, String>> businessEntityModels = response.jsonPath().getList("businessEntityModels");
                System.out.println(businessEntityModels.size());
                if (businessEntityModels.size() > 0 && ActualStatusCode == 200 && BusinessEntityInDB.getBE_nameEn().equalsIgnoreCase(businessEntityModels.get(0).get("nameEn"))) {
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("nameAr"),softObj,BusinessEntityInDB.getBE_nameAr());
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("nameEn"),softObj,BusinessEntityInDB.getBE_nameEn());
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("phoneNumber"),softObj,BusinessEntityInDB.getBE_phoneNumber());
                    HandlingDBAssertionArr(response, "businessEntityModels.email",softObj,BusinessEntityInDB.getBE_email());
                    HandlingDBAssertion(response, "businessEntityModels.type.code[0]",softObj,BusinessEntityInDB.getType_code());
                    HandlingDBAssertion(response,"businessEntityModels.type.nameEn[0]",softObj,BusinessEntityInDB.getType_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.type.nameAr[0]",softObj,BusinessEntityInDB.getType_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.category.code[0]",softObj,BusinessEntityInDB.getCategory_code());
                    HandlingDBAssertion(response,"businessEntityModels.category.nameEn[0]",softObj,BusinessEntityInDB.getCategory_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.category.nameAr[0]",softObj,BusinessEntityInDB.getCategory_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.csp.code[0]",softObj,BusinessEntityInDB.getCSP_code());
                    HandlingDBAssertion(response,"businessEntityModels.csp.nameEn[0]",softObj,BusinessEntityInDB.getCSP_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.csp.nameAr[0]",softObj,BusinessEntityInDB.getCSP_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.csp.channelCode[0]",softObj,BusinessEntityInDB.getCSP_channelCode());
                    HandlingDBAssertion(response,"businessEntityModels.csp.sofUrl[0]",softObj,BusinessEntityInDB.getCSP_sofUrl());
                    HandlingDBAssertion(response,"businessEntityModels.csp.sender[0]",softObj,BusinessEntityInDB.getCSP_sender());
                    HandlingDBAssertion(response,"businessEntityModels.channels.code[0][2]",softObj,BusinessEntityInDB.getChannels_INT_code());
                    HandlingDBAssertion(response,"businessEntityModels.channels.nameEn[0][2]",softObj,BusinessEntityInDB.getChannels_INT_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.channels.nameAr[0][2]",softObj,BusinessEntityInDB.getChannels_INT_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.address.address[0]",softObj,BusinessEntityInDB.getAddress());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.code[0]",softObj,BusinessEntityInDB.getAddress_area_code());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.nameEn[0]",softObj,BusinessEntityInDB.getAddress_area_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.nameAr[0]",softObj,BusinessEntityInDB.getAddress_area_nameAr());//       HandlingDBAssertion(response,"address.region.id", AssertionObj,BusinessEntityInDB.getAddress_region_id());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.code[0]",softObj,BusinessEntityInDB.getAddress_region_code());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.nameEn[0]",softObj,BusinessEntityInDB.getAddress_region_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.nameAr[0]",softObj,BusinessEntityInDB.getAddress_region_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.logoUri[0]",softObj,BusinessEntityInDB.getLogo_URI());

                } else if (businessEntityModels.size() == 0) {
                    softObj.assertTrue(countResponseAPI == 0);
                    Log.Fail("API Failed with no data appear for BusinessEntity Already Added in Database");

                }
                softObj.assertAll(); //byo2f hena lw feh 7aga false lw true ykml 3l log info
                Log.info("get BusinessEntity by " + Criteria + " API successed with Assertion fields in Database with API Response");
            } catch (AssertionError error) {
                Log.AssertionError("Error occurred in " + new Object() {
                }
                        .getClass().getName() + "." + new Object() {
                }
                        .getClass()
                        .getEnclosingMethod()
                        .getName(), error);
                Assert.fail();

            }

        } catch (Exception erro) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), erro);
            Assert.fail();

        }
    }

    @Test(description = "View Business entity by Status and NameEn", dataProvider = "BEView",priority = 5)
    public void ViewBeAPIByStatus(AddUpdateBusinessEntityDM DMObj) {

        try {
            test = extent.createTest("Check View Data (get BE API ) using search by Status and NameEn");
            Log.test = test;
            Log.startTestCase("Check View Data (get BE API ) using search by Status and NameEn");
            try {
                SoftAssert softObj = new SoftAssert();
                String Criteria = "status";
                String CategoryName="Online Store";
                String NameEn = DMObj.getBE_nameEn();
                String Status = "ACTIVE";
                ServicesDelegate backendService = new ServicesDelegate();
                AddUpdateBusinessEntityDM BusinessEntityInDB = backendService.getBEDetails(NameEn, GeneralConstants.TEST_CASE_METHOD_ADD);
                String PhoneNumberinDB = BusinessEntityInDB.getBE_phoneNumber();
                JSONObject payload = new JSONObject();
                GetBusinessEntityPage GetPageObj = new GetBusinessEntityPage();
                GetPageObj.BEViewByTwoParam(Status, Criteria, NameEn, payload);
                this.SendAPILog(payload);
                Response response = given().header("Authorization", "Bearer " + token).contentType("application/json\r\n")
                        .body(payload).when().log()
                        .all().post(endPoint);
                RespondAPILog(response);
                int ActualStatusCode = response.getStatusCode();
                int countResponseAPI = response.then().extract().path("resultCount");
                List<Map<String, String>> businessEntityModels = response.jsonPath().getList("businessEntityModels");
                System.out.println(businessEntityModels.size());
                if (businessEntityModels.size() > 0 && ActualStatusCode == 200 && BusinessEntityInDB.getBE_nameEn().equalsIgnoreCase(businessEntityModels.get(0).get("nameEn"))) {
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("nameAr"),softObj,BusinessEntityInDB.getBE_nameAr());
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("nameEn"),softObj,BusinessEntityInDB.getBE_nameEn());
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("phoneNumber"),softObj,BusinessEntityInDB.getBE_phoneNumber());
                    HandlingDBAssertionArr(response, "businessEntityModels.email",softObj,BusinessEntityInDB.getBE_email());
                    HandlingDBAssertion(response, "businessEntityModels.type.code[0]",softObj,BusinessEntityInDB.getType_code());
                    HandlingDBAssertion(response,"businessEntityModels.type.nameEn[0]",softObj,BusinessEntityInDB.getType_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.type.nameAr[0]",softObj,BusinessEntityInDB.getType_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.category.code[0]",softObj,BusinessEntityInDB.getCategory_code());
                    HandlingDBAssertion(response,"businessEntityModels.category.nameEn[0]",softObj,BusinessEntityInDB.getCategory_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.category.nameAr[0]",softObj,BusinessEntityInDB.getCategory_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.csp.code[0]",softObj,BusinessEntityInDB.getCSP_code());
                    HandlingDBAssertion(response,"businessEntityModels.csp.nameEn[0]",softObj,BusinessEntityInDB.getCSP_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.csp.nameAr[0]",softObj,BusinessEntityInDB.getCSP_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.csp.channelCode[0]",softObj,BusinessEntityInDB.getCSP_channelCode());
                    HandlingDBAssertion(response,"businessEntityModels.csp.sofUrl[0]",softObj,BusinessEntityInDB.getCSP_sofUrl());
                    HandlingDBAssertion(response,"businessEntityModels.csp.sender[0]",softObj,BusinessEntityInDB.getCSP_sender());
                    HandlingDBAssertion(response,"businessEntityModels.channels.code[0][2]",softObj,BusinessEntityInDB.getChannels_INT_code());
                    HandlingDBAssertion(response,"businessEntityModels.channels.nameEn[0][2]",softObj,BusinessEntityInDB.getChannels_INT_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.channels.nameAr[0][2]",softObj,BusinessEntityInDB.getChannels_INT_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.address.address[0]",softObj,BusinessEntityInDB.getAddress());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.code[0]",softObj,BusinessEntityInDB.getAddress_area_code());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.nameEn[0]",softObj,BusinessEntityInDB.getAddress_area_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.nameAr[0]",softObj,BusinessEntityInDB.getAddress_area_nameAr());//       HandlingDBAssertion(response,"address.region.id", AssertionObj,BusinessEntityInDB.getAddress_region_id());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.code[0]",softObj,BusinessEntityInDB.getAddress_region_code());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.nameEn[0]",softObj,BusinessEntityInDB.getAddress_region_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.nameAr[0]",softObj,BusinessEntityInDB.getAddress_region_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.logoUri[0]",softObj,BusinessEntityInDB.getLogo_URI());

                } else if (businessEntityModels.size() == 0) {
                    softObj.assertTrue(countResponseAPI == 0);
                    Log.Fail("API Failed with no data appear for BusinessEntity Already Added in Database");

                }
                softObj.assertAll(); //byo2f hena lw feh 7aga false lw true ykml 3l log info
                Log.info("get BusinessEntity by " + Criteria + " API successed with Assertion fields in Database with API Response");
            } catch (AssertionError error) {
                Log.AssertionError("Error occurred in " + new Object() {
                }
                        .getClass().getName() + "." + new Object() {
                }
                        .getClass()
                        .getEnclosingMethod()
                        .getName(), error);
                Assert.fail();

            }

        } catch (Exception erro) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), erro);
            Assert.fail();

        }
    }

    @Test(description = "View Business entity by Account Number",dataProvider = "BEView",priority = 6)
    public void ViewBeAPIByAccountNumber(AddUpdateBusinessEntityDM DMObj) {

        try {
            test = extent.createTest("Check View Data (get BE API ) using search by Account Number");
            Log.test = test;
            Log.startTestCase("Check View Data (get BE API ) using search by Account Number");
            try {
                SoftAssert softObj = new SoftAssert();
                String Criteria = "accountNumber";
                String NameEn = DMObj.getBE_nameEn();
                ServicesDelegate backendService = new ServicesDelegate();
                AddUpdateBusinessEntityDM BusinessEntityInDB = backendService.getBEDetails(NameEn, GeneralConstants.TEST_CASE_METHOD_ADD);
                String AccountNumber = BusinessEntityInDB.getAccount_Number();
                JSONObject payload = new JSONObject();
                GetBusinessEntityPage GetPageObj = new GetBusinessEntityPage();
                GetPageObj.BEViewByParam(AccountNumber,Criteria,payload);
                this.SendAPILog(payload);
                Response response = given().header("Authorization", "Bearer " + token).contentType("application/json\r\n")
                        .body(payload).when().log()
                        .all().post(endPoint);
                RespondAPILog(response);
                int ActualStatusCode = response.getStatusCode();
                int countResponseAPI = response.then().extract().path("resultCount");
                List<Map<String, String>> businessEntityModels = response.jsonPath().getList("businessEntityModels");
                System.out.println(businessEntityModels.size());
                if (businessEntityModels.size() > 0 && ActualStatusCode == 200 && BusinessEntityInDB.getBE_nameEn().equalsIgnoreCase(businessEntityModels.get(0).get("nameEn"))) {
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("nameAr"),softObj,BusinessEntityInDB.getBE_nameAr());
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("nameEn"),softObj,BusinessEntityInDB.getBE_nameEn());
                    HandlingDBAssertion(response, businessEntityModels.get(0).get("phoneNumber"),softObj,BusinessEntityInDB.getBE_phoneNumber());
                    HandlingDBAssertionArr(response, "businessEntityModels.email",softObj,BusinessEntityInDB.getBE_email());
                    HandlingDBAssertion(response, "businessEntityModels.type.code[0]",softObj,BusinessEntityInDB.getType_code());
                    HandlingDBAssertion(response,"businessEntityModels.type.nameEn[0]",softObj,BusinessEntityInDB.getType_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.type.nameAr[0]",softObj,BusinessEntityInDB.getType_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.category.code[0]",softObj,BusinessEntityInDB.getCategory_code());
                    HandlingDBAssertion(response,"businessEntityModels.category.nameEn[0]",softObj,BusinessEntityInDB.getCategory_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.category.nameAr[0]",softObj,BusinessEntityInDB.getCategory_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.csp.code[0]",softObj,BusinessEntityInDB.getCSP_code());
                    HandlingDBAssertion(response,"businessEntityModels.csp.nameEn[0]",softObj,BusinessEntityInDB.getCSP_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.csp.nameAr[0]",softObj,BusinessEntityInDB.getCSP_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.csp.channelCode[0]",softObj,BusinessEntityInDB.getCSP_channelCode());
                    HandlingDBAssertion(response,"businessEntityModels.csp.sofUrl[0]",softObj,BusinessEntityInDB.getCSP_sofUrl());
                    HandlingDBAssertion(response,"businessEntityModels.csp.sender[0]",softObj,BusinessEntityInDB.getCSP_sender());
                    HandlingDBAssertion(response,"businessEntityModels.channels.code[0][2]",softObj,BusinessEntityInDB.getChannels_INT_code());
                    HandlingDBAssertion(response,"businessEntityModels.channels.nameEn[0][2]",softObj,BusinessEntityInDB.getChannels_INT_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.channels.nameAr[0][2]",softObj,BusinessEntityInDB.getChannels_INT_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.address.address[0]",softObj,BusinessEntityInDB.getAddress());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.code[0]",softObj,BusinessEntityInDB.getAddress_area_code());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.nameEn[0]",softObj,BusinessEntityInDB.getAddress_area_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.address.area.nameAr[0]",softObj,BusinessEntityInDB.getAddress_area_nameAr());//       HandlingDBAssertion(response,"address.region.id", AssertionObj,BusinessEntityInDB.getAddress_region_id());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.code[0]",softObj,BusinessEntityInDB.getAddress_region_code());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.nameEn[0]",softObj,BusinessEntityInDB.getAddress_region_nameEn());
                    HandlingDBAssertion(response,"businessEntityModels.address.region.nameAr[0]",softObj,BusinessEntityInDB.getAddress_region_nameAr());
                    HandlingDBAssertion(response,"businessEntityModels.logoUri[0]",softObj,BusinessEntityInDB.getLogo_URI());

                } else if (businessEntityModels.size() == 0) {
                    softObj.assertTrue(countResponseAPI == 0);
                    Log.Fail("API Failed with no data appear for BusinessEntity Already Added in Database");

                }
                softObj.assertAll(); //byo2f hena lw feh 7aga false lw true ykml 3l log info
                Log.info("get BusinessEntity by " + Criteria + " API successed with Assertion fields in Database with API Response");
            } catch (AssertionError error) {
                Log.AssertionError("Error occurred in " + new Object() {
                }
                        .getClass().getName() + "." + new Object() {
                }
                        .getClass()
                        .getEnclosingMethod()
                        .getName(), error);
                Assert.fail();

            }

        } catch (Exception erro) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), erro);
            Assert.fail();

        }
    }

    @DataProvider(name = "BEView")
    public Object[][] provideAddBusinessEntityAPI(Method method) {
        ArrayList<ArrayList<Object>> resultArray = provideTestData("BEView");
        Object[][] result = new Object[resultArray.size()][1];

        for (int i = 0; i < resultArray.size(); i++) {

            AddUpdateBusinessEntityDM addBusinessEntityAPITestData = new AddUpdateBusinessEntityDM();
            addBusinessEntityAPITestData.setBE_nameEn(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.BE_nameEn).toString());
            result[i][0] = addBusinessEntityAPITestData;
        }

        return result;
    }
}
