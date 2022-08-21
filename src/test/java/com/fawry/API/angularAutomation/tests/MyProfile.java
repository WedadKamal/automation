package com.fawry.API.angularAutomation.tests;

import com.fawry.API.angularAutomation.backendServices.ServicesDelegate;
import com.fawry.API.angularAutomation.constants.GeneralConstants;
import com.fawry.API.angularAutomation.constants.excelIndices.AddUpdateBusinessEntityExcellndices;
import com.fawry.API.angularAutomation.dataModels.AddUpdateBusinessEntityDM;
import com.fawry.API.angularAutomation.pages.AddUpdateBusinessEntityPage;
import com.fawry.API.angularAutomation.pages.MainPage;
import com.fawry.API.angularAutomation.utils.Log;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static java.lang.Integer.parseInt;

public class MyProfile extends BaseTest{
    public MyProfile() {
        RestAssured.basePath = generalCofigsProps.getProperty(GeneralConstants.Profile_Be_Base_Path);
    }

    ApiLogin LgnObj = new ApiLogin();
    String token = LgnObj.GetloginBEToken();

    @Test(description = "Change MyProfile", dataProvider = "MyProfile", priority = 0)
    public void MyProfile(AddUpdateBusinessEntityDM ProfileBEObj) {

        try {
            test = extent.createTest(ProfileBEObj.getTestCaseTitle());
            Log.test = test;
            Log.startTestCase(ProfileBEObj.getTestCaseTitle());
            try {
                String Email = generalCofigsProps.getProperty(GeneralConstants.BE_MAIL);
                ServicesDelegate backendService = new ServicesDelegate();
                AddUpdateBusinessEntityDM BusinessEntityInDBbeforeubdate = backendService.getBEDetails(Email, GeneralConstants.TEST_CASE_METHOD_UPDATE);
                int BeIdDb = parseInt(BusinessEntityInDBbeforeubdate.getBE_ID());

                if (BeIdDb != 0) {
                    Response response = this.MyProfile(ProfileBEObj, BusinessEntityInDBbeforeubdate, BeIdDb);
                    int ExpectedStatusCode = ProfileBEObj.getStatus_Code();
                    int ActualStatusCode = response.getStatusCode();
                    SoftAssert AssertionObj = new SoftAssert();

                    if (ActualStatusCode == ExpectedStatusCode) {
                        //  ServicesDelegate backendService = new ServicesDelegate();
                        AddUpdateBusinessEntityDM BusinessEntityInDB = backendService.getBEDetails(Email, GeneralConstants.TEST_CASE_METHOD_UPDATE);

                        System.out.println("API RES"+response.then().extract().path("nameAr"));
                        System.out.println("DB RES"+BusinessEntityInDB.getBE_nameAr());

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

                    } else if (ActualStatusCode != ExpectedStatusCode) {

                        Log.Fail("API Failed with Actual Status code " + ActualStatusCode + " and the expected status code is " + ExpectedStatusCode);
                        AssertionObj.assertEquals(ActualStatusCode,ExpectedStatusCode);
                    }
                    AssertionObj.assertAll();// lazem a7otaha gowa try 3shan t3ml catch byo2f hena lw feh 7aga failet
                    Log.info("Update API successed with Assertion fields in Database with API Response");
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

    public Response MyProfile(AddUpdateBusinessEntityDM AddBEObj,AddUpdateBusinessEntityDM DataBaseDM, int BE_ID) {

        MainPage mainObj = new MainPage();
        mainObj.timestamp(AddBEObj);
        JSONObject payload = new JSONObject();
        AddUpdateBusinessEntityPage PageObj = new AddUpdateBusinessEntityPage();
        PageObj.AddOJsonObjPayload(AddBEObj,DataBaseDM,true, payload, BE_ID);
        Log.info("sending myProfile api to http://10.95.0.178/be-api/profile");
        Log.info("sending myProfile api " + payload);

        Response response = given().header("Authorization", "Bearer " + token).
                contentType("application/json\r\n").body(payload).when().log()
                .all().put("/profile");
        Log.info("myProfile API response with " + response.getBody().asString());
        return response;
    }

    @DataProvider(name = "MyProfile")
    public Object[][] provideMyProfile(Method method) {
        ArrayList<ArrayList<Object>> resultArray = provideTestData("MyProfile");
        Object[][] result = new Object[resultArray.size()][1];

        for (int i = 0; i < resultArray.size(); i++) {

            AddUpdateBusinessEntityDM addBusinessEntityAPITestData = new AddUpdateBusinessEntityDM();

            addBusinessEntityAPITestData.setPass_Added(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.PASS_BE_ADDED).toString());
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
            addBusinessEntityAPITestData.setTestCaseTitleForUpdate(resultArray.get(i).get(AddUpdateBusinessEntityExcellndices.TESTCASE_TITLE_FOR_UPDATE).toString());

            result[i][0] = addBusinessEntityAPITestData;
        }

        return result;
    }
}
