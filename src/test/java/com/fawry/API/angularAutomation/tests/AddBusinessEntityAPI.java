package com.fawry.API.angularAutomation.tests;

import com.fawry.API.angularAutomation.backendServices.ServicesDelegate;
import com.fawry.API.angularAutomation.backendServices.database.daos.BEDaos;
import com.fawry.API.angularAutomation.constants.GeneralConstants;
import com.fawry.API.angularAutomation.constants.excelIndices.AddUpdateBusinessEntityExcellndices;
import com.fawry.API.angularAutomation.dataModels.AddUpdateBusinessEntityDM;
import com.fawry.API.angularAutomation.dataModels.LoyaltyProgDM;
import com.fawry.API.angularAutomation.pages.AddUpdateBusinessEntityPage;
import com.fawry.API.angularAutomation.pages.GetBusinessEntityPage;
import com.fawry.API.angularAutomation.pages.MainPage;
import com.fawry.API.angularAutomation.utils.Log;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.Argument;
import net.minidev.json.JSONObject;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static java.lang.Integer.parseInt;
import static net.bytebuddy.implementation.FixedValue.value;


public class AddBusinessEntityAPI extends BaseTest {

    ApiLogin LgnObj = new ApiLogin();
    String token = LgnObj.GetloginToken();

    @Test(description = "Add Business entity", dataProvider = "AddBeAPI", priority = 0)
    public void AddBeAPI(AddUpdateBusinessEntityDM AddBEObj) throws AssertionError {

        try {
            test = extent.createTest(AddBEObj.getTestCaseTitle());
            Log.test = test;
            Log.startTestCase(AddBEObj.getTestCaseTitle());
            try {
                Response response = this.AddBusinessEntity(AddBEObj,AddBEObj);
                int ExpectedStatusCode = AddBEObj.getStatus_Code();
                String ErrorType = AddBEObj.getErrType();
                int ActualStatusCode = response.getStatusCode();
                String ActualErrorCode = response.then().extract().path("errorCode");
                SoftAssert AssertionObj = new SoftAssert();
                if (ActualStatusCode == 400 && ActualStatusCode == ExpectedStatusCode) {
                    Log.info("API successed with Actual Status code " + ActualStatusCode + " which is the expected status code " + ExpectedStatusCode);
                    Log.info("API error with Actual Response Error Type " + ActualErrorCode);
                    AssertionObj.assertEquals(ActualErrorCode, ErrorType);
                } else if (ActualStatusCode == 400 && ActualStatusCode != ExpectedStatusCode) {
                    Log.Fail("API Failed with Actual Status code " + ActualStatusCode + " and the expected status code is " + ExpectedStatusCode);
                    Log.Fail("API Failed with Actual Response Error Type " + ActualErrorCode);


                } else if (ActualStatusCode == 500 && ActualStatusCode != ExpectedStatusCode) {
                    Log.Fail("API Failed with Actual Status code " + ActualStatusCode + " and the expected status code is " + ExpectedStatusCode);

                } else if (ActualStatusCode == 201 && ActualStatusCode != ExpectedStatusCode) {
                    Log.Fail("API Failed with Actual Status code " + ActualStatusCode + " and the expected status code is " + ExpectedStatusCode);

                } else if (ActualStatusCode == 201 && ActualStatusCode == ExpectedStatusCode) {
                    Log.info("API successed with Actual Status code " + ActualStatusCode + " which is the expected status code " + ExpectedStatusCode);
                } else if (ActualStatusCode == 500 && ActualStatusCode == ExpectedStatusCode) {
                    Log.info("API successed with Actual Status code " + ActualStatusCode + " which is the expected status code " + ExpectedStatusCode);
                }

                AssertionObj.assertEquals(ActualStatusCode, ExpectedStatusCode);
                AssertionObj.assertAll();

                if (ActualStatusCode == 201) {
                    String Unique_BE_name = AddBEObj.getBE_nameEn();
                    ServicesDelegate backendService = new ServicesDelegate();
                    AddUpdateBusinessEntityDM BusinessEntityInDB = backendService.getBEDetails(Unique_BE_name, GeneralConstants.TEST_CASE_METHOD_ADD);
                    HandlingDBAssertion(response, "nameAr", AssertionObj, BusinessEntityInDB.getBE_nameAr());
                    HandlingDBAssertion(response, "nameEn", AssertionObj, BusinessEntityInDB.getBE_nameEn());
                    HandlingDBAssertion(response, "phoneNumber", AssertionObj, BusinessEntityInDB.getBE_phoneNumber());
                    HandlingDBAssertion(response, "email", AssertionObj, BusinessEntityInDB.getBE_email());
                    //   HandlingDBAssertionint(response,"type.id", AssertionObj,(BusinessEntityInDB.getType_id()));
                    HandlingDBAssertion(response, "type.code", AssertionObj, BusinessEntityInDB.getType_code());
                    HandlingDBAssertion(response, "type.nameEn", AssertionObj, BusinessEntityInDB.getType_nameEn());
                    HandlingDBAssertion(response, "type.nameAr", AssertionObj, BusinessEntityInDB.getType_nameAr());
                    //   HandlingDBAssertion(response,"category.id", AssertionObj,BusinessEntityInDB.getCategory_id());
                    HandlingDBAssertion(response, "category.code", AssertionObj, BusinessEntityInDB.getCategory_code());
                    HandlingDBAssertion(response, "category.nameEn", AssertionObj, BusinessEntityInDB.getCategory_nameEn());
                    HandlingDBAssertion(response, "category.nameAr", AssertionObj, BusinessEntityInDB.getCategory_nameAr());
                    //    HandlingDBAssertion(response,"csp.id", AssertionObj,BusinessEntityInDB.getCSP_id());
                    HandlingDBAssertion(response, "csp.code", AssertionObj, BusinessEntityInDB.getCSP_code());
                    HandlingDBAssertion(response, "csp.nameEn", AssertionObj, BusinessEntityInDB.getCSP_nameEn());
                    HandlingDBAssertion(response, "csp.nameAr", AssertionObj, BusinessEntityInDB.getCSP_nameAr());
                    HandlingDBAssertion(response, "csp.channelCode", AssertionObj, BusinessEntityInDB.getCSP_channelCode());
                    //  HandlingDBAssertion(response,"csp.isDefault", AssertionObj,BusinessEntityInDB.getCSP_isDefault());
                    HandlingDBAssertion(response, "csp.sofUrl", AssertionObj, BusinessEntityInDB.getCSP_sofUrl());
                    HandlingDBAssertion(response, "csp.sender", AssertionObj, BusinessEntityInDB.getCSP_sender());
                    //       HandlingDBAssertion(response,"channels.id", AssertionObj,BusinessEntityInDB.getChannels_INT_id());
                    HandlingDBAssertion(response, "channels.code[2]", AssertionObj, BusinessEntityInDB.getChannels_INT_code());
                    HandlingDBAssertion(response, "channels.nameEn[2]", AssertionObj, BusinessEntityInDB.getChannels_INT_nameEn());
                    HandlingDBAssertion(response, "channels.nameAr[2]", AssertionObj, BusinessEntityInDB.getChannels_INT_nameAr());
                    //       HandlingDBAssertion(response,"status.id", AssertionObj,BusinessEntityInDB.getStatus_id());
                    HandlingDBAssertion(response, "address.address", AssertionObj, BusinessEntityInDB.getAddress());
                    //      HandlingDBAssertion(response,"address.area.id", AssertionObj,BusinessEntityInDB.getAddress_area_id());
                    HandlingDBAssertion(response, "address.area.code", AssertionObj, BusinessEntityInDB.getAddress_area_code());
                    HandlingDBAssertion(response, "address.area.nameEn", AssertionObj, BusinessEntityInDB.getAddress_area_nameEn());
                    HandlingDBAssertion(response, "address.area.nameAr", AssertionObj, BusinessEntityInDB.getAddress_area_nameAr());
                    //       HandlingDBAssertion(response,"address.region.id", AssertionObj,BusinessEntityInDB.getAddress_region_id());
                    HandlingDBAssertion(response, "address.region.code", AssertionObj, BusinessEntityInDB.getAddress_region_code());
                    HandlingDBAssertion(response, "address.region.nameEn", AssertionObj, BusinessEntityInDB.getAddress_region_nameEn());
                    HandlingDBAssertion(response, "address.region.nameAr", AssertionObj, BusinessEntityInDB.getAddress_region_nameAr());
                    HandlingDBAssertion(response, "logoUri", AssertionObj, BusinessEntityInDB.getLogo_URI());
                    //   HandlingDBAssertion(response,"logoUri", AssertionObj,BusinessEntityInDB.getAddress_region_nameAr());
                    AssertionObj.assertAll();  // lazem a7otaha gowa try 3shan t3ml catch
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
            // byfail el test lw el assertion be failed


        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            Assert.fail();
        }
    }

    @DataProvider(name = "AddBeAPI")
    public Object[][] provideAddBusinessEntityAPI(Method method) {
        ArrayList<ArrayList<Object>> resultArray = provideTestData("AddBeAPI");
        Object[][] result = new Object[resultArray.size()][1];

        for (int i = 0; i < resultArray.size(); i++) {
            AddUpdateBusinessEntityDM addBusinessEntityAPITestData = new AddUpdateBusinessEntityDM();
            addBusinessEntityAPITestData.setTestCaseTitle(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.TEST_CASE_TITLE_INDEX).toString());
            addBusinessEntityAPITestData.setBE_nameEn(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.BE_nameEn).toString());
            addBusinessEntityAPITestData.setBE_nameAr(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.BE_nameAr).toString());
            addBusinessEntityAPITestData.setBE_email(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.BE_email).toString());
            addBusinessEntityAPITestData.setBE_phoneNumber(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.BE_phoneNumber).toString());
            addBusinessEntityAPITestData.setCSP_code(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.CSP_code).toString());
            addBusinessEntityAPITestData.setCSP_nameEn(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.CSP_nameEn).toString());
            addBusinessEntityAPITestData.setCSP_nameAr(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.CSP_nameAr).toString());
            addBusinessEntityAPITestData.setCSP_sofUrl(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.CSP_sofUrl).toString());
            addBusinessEntityAPITestData.setCSP_sender(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.CSP_sender).toString());
            addBusinessEntityAPITestData.setCategory_code(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Category_code).toString());
            addBusinessEntityAPITestData.setCategory_nameEn(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Category_nameEn).toString());
            addBusinessEntityAPITestData.setCategory_nameAr(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Category_nameAr).toString());
            addBusinessEntityAPITestData.setType_code(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Type_code).toString());
            addBusinessEntityAPITestData.setType_nameEn(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Type_nameEn).toString());
            addBusinessEntityAPITestData.setType_nameAr(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Type_nameAr).toString());

            addBusinessEntityAPITestData.setCSP_id(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.CSP_id).toString());
            addBusinessEntityAPITestData.setCSP_channelCode(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.CSP_channelCode).toString());
            addBusinessEntityAPITestData.setCSP_isDefault(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.CSP_isDefault).toString());
            addBusinessEntityAPITestData.setCategory_id(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Category_id).toString());
            addBusinessEntityAPITestData.setType_id(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Type_id).toString());
            addBusinessEntityAPITestData.setChannels_POS_id(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Channels_POS_id).toString());
            addBusinessEntityAPITestData.setChannels_MOB_id(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Channels_MOB_id).toString());
            addBusinessEntityAPITestData.setChannels_INT_id(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Channels_INT_id).toString());
            addBusinessEntityAPITestData.setAddress_area_id(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.address_area_id).toString());
            addBusinessEntityAPITestData.setAddress_region_id(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.address_region_id).toString());
            addBusinessEntityAPITestData.setStatus_id(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.status_id).toString());
            addBusinessEntityAPITestData.setStatus_Code(parseInt(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.EXPECTED_STATUS_RESULT).toString()));

            addBusinessEntityAPITestData.setChannels_POS_code(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Channels_POS_code).toString());
            addBusinessEntityAPITestData.setChannels_POS_nameEn(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Channels_POS_nameEn).toString());
            addBusinessEntityAPITestData.setChannels_POS_nameAr(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Channels_POS_nameAr).toString());
            addBusinessEntityAPITestData.setChannels_MOB_code(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Channels_MOB_code).toString());
            addBusinessEntityAPITestData.setChannels_MOB_nameEn(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Channels_MOB_nameEn).toString());
            addBusinessEntityAPITestData.setChannels_MOB_nameAr(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Channels_MOB_nameAr).toString());
            addBusinessEntityAPITestData.setChannels_INT_code(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Channels_INT_code).toString());
            addBusinessEntityAPITestData.setChannels_INT_nameEn(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Channels_INT_nameEn).toString());
            addBusinessEntityAPITestData.setChannels_INT_nameAr(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.Channels_INT_nameAr).toString());
            addBusinessEntityAPITestData.setAddress_area_code(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.address_area_code).toString());
            addBusinessEntityAPITestData.setAddress_area_nameEn(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.address_area_nameEn).toString());
            addBusinessEntityAPITestData.setAddress_area_nameAr(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.address_area_nameAr).toString());
            addBusinessEntityAPITestData.setAddress_region_code(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.address_region_code).toString());
            addBusinessEntityAPITestData.setAddress_region_nameEn(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.address_region_nameEn).toString());
            addBusinessEntityAPITestData.setAddress_region_nameAr(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.address_region_nameAr).toString());
            addBusinessEntityAPITestData.setAddress(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.address).toString());
            addBusinessEntityAPITestData.setTwitter(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.twitter).toString());
            addBusinessEntityAPITestData.setFacebook(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.facebook).toString());
            addBusinessEntityAPITestData.setInstagram(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.instagram).toString());
            addBusinessEntityAPITestData.setYoutube(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.youtube).toString());
            addBusinessEntityAPITestData.setWebsite(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.website).toString());
            addBusinessEntityAPITestData.setLogo(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.logo).toString());
            addBusinessEntityAPITestData.setErrType(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.ERR_TYPE_INDEX).toString());
            addBusinessEntityAPITestData.setExpectedMessage(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.EXPECTED_RES_INDEX).toString());
            addBusinessEntityAPITestData.setTestCaseTitleForView(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.TESTCASE_TITLE_FOR_VIEW).toString());
            result[i][0] = addBusinessEntityAPITestData;
        }
        return result;
    }

    public Response AddBusinessEntity(AddUpdateBusinessEntityDM AddBEObj,AddUpdateBusinessEntityDM DataBaseObj) {

        int BE_ID = 0;
        JSONObject payload = new JSONObject();
        MainPage mainObj = new MainPage();
        mainObj.timestamp(AddBEObj);
        AddUpdateBusinessEntityPage PageObj = new AddUpdateBusinessEntityPage();
        PageObj.AddOJsonObjPayload(AddBEObj,DataBaseObj,false, payload, BE_ID);
        Log.info("sending Add api to http://10.95.0.178/be-api/business-entities");
        Log.info("sending Add api " + payload);

        Response response = given().header("Authorization", "Bearer " + token).
                contentType("application/json\r\n").body(payload).when().log()
                .all().post("");
        this.RespondAPILog(response);
        return response;
        //  int ActualStatusCode = response.getStatusCode();
        //   String ActualErrorCode = response.then().extract().path("errorCode");


    }

}
