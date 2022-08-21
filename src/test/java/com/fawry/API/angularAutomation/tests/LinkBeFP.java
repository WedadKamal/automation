package com.fawry.API.angularAutomation.tests;

import com.fawry.API.angularAutomation.backendServices.ServicesDelegate;
import com.fawry.API.angularAutomation.constants.GeneralConstants;
import com.fawry.API.angularAutomation.constants.excelIndices.AddUpdateBusinessEntityExcellndices;
import com.fawry.API.angularAutomation.constants.excelIndices.LinkBeWithFPExcellndices;
import com.fawry.API.angularAutomation.dataModels.AddUpdateBusinessEntityDM;
import com.fawry.API.angularAutomation.dataModels.BusinessEntityLinkDM;
import com.fawry.API.angularAutomation.pages.AddUpdateBusinessEntityPage;
import com.fawry.API.angularAutomation.pages.GetBusinessEntityPage;
import com.fawry.API.angularAutomation.pages.LinkBeFpPage;
import com.fawry.API.angularAutomation.pages.MainPage;
import com.fawry.API.angularAutomation.utils.Log;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static java.lang.Integer.parseInt;

public class LinkBeFP extends BaseTest {

    public LinkBeFP() {


    }

    ApiLogin LgnObj = new ApiLogin();
    String token = LgnObj.GetloginToken();

    @Test(description = "LinkBEwithFP", dataProvider = "LinkBEwithFP", priority = 0)
    public void LinkBEwithFP(BusinessEntityLinkDM LinkBEDMObj) {
            try {
                RestAssured.basePath = generalCofigsProps.getProperty(GeneralConstants.Link_Be_Base_Path1);
                test = extent.createTest(LinkBEDMObj.getTestCaseTitle());
                Log.test = test;
                Log.startTestCase(LinkBEDMObj.getTestCaseTitle());
                try {
                    SoftAssert SoftObj = new SoftAssert();
                    String NameEn =  LinkBEDMObj.getBE_Name();
                    ServicesDelegate backendService = new ServicesDelegate();
                    AddUpdateBusinessEntityDM BusinessEntityInDB = backendService.getBEDetails(NameEn, GeneralConstants.TEST_CASE_METHOD_ADD);
                    int BE_ID = parseInt(BusinessEntityInDB.getBE_ID());

                    JSONObject Payload = new JSONObject();
                    LinkBeFpPage FpPageobj = new LinkBeFpPage();
                    FpPageobj.AddOJsonObjPayload(LinkBEDMObj,Payload);
                    String endpoint = "/"+BE_ID+"/applications/fp";

                    Response response=  this.LinkBe(Payload,endpoint,token);
                   int ActualStatusCode= response.getStatusCode();
                   int ExpectedStatusCode = LinkBEDMObj.getStatus_Code();
                    String ExpectedErrorCode = LinkBEDMObj.getError_Code();
                    if(ActualStatusCode==200 &&ActualStatusCode==ExpectedStatusCode){

                        Log.info("API successed with Actual Status code " + ActualStatusCode + " which is the expected status code " + ExpectedStatusCode);

                        // get features for above API
                        String GetFeaturesAPiName = "fp";
                        RestAssured.basePath = generalCofigsProps.getProperty(GeneralConstants.Link_Be_Base_Path);
                        ServicesDelegate backendServiceList = new ServicesDelegate();
                        List<String> FeaturesList = backendServiceList.getBEFeatures(NameEn, GeneralConstants.TEST_CASE_METHOD_ADD);
                        String GetFeaturesBeEndpoint = "/" + BE_ID + "/applications/"+GetFeaturesAPiName+"/features?t=1641365847145";
                        Response GetFeaturesBeresponse = GetFeaturesLinkBe(GetFeaturesBeEndpoint, token);
                        int GetFeaturesBeActualStatusCode = GetFeaturesBeresponse.getStatusCode();
                        if (GetFeaturesBeActualStatusCode == 200) {
                            Log.info("API successed with Actual Status code " + GetFeaturesBeActualStatusCode + " which is the expected status code " + 200);
                            LinkAssertion( GetFeaturesBeresponse, FeaturesList, SoftObj);
                        }else if(GetFeaturesBeActualStatusCode != 200) {
                            Log.Fail("API Failed with Actual Status code " + GetFeaturesBeActualStatusCode + " and the expected status code is " + 200);
                        }
                        SoftObj.assertEquals(200, GetFeaturesBeActualStatusCode);
                        SoftObj.assertAll();
                        Log.info(GetFeaturesAPiName +"Get Features API successed with Assertion fields in Database with API Response");
                    }
                    else if(ActualStatusCode != ExpectedStatusCode) {
                        Log.Fail("API Failed with Actual Status code " + ActualStatusCode + " and the expected status code is " + ExpectedStatusCode);
                    }
                    else if(ActualStatusCode == 400 && ActualStatusCode == ExpectedStatusCode) {
                        Log.info("API successed with Actual Status code " + ActualStatusCode + " which is the expected status code " + ExpectedStatusCode);
                        String ActualErrorCode = response.then().extract().path("error");
                        Log.info("API error with Actual Response Error Type " + ActualErrorCode + " which is the same expected error "+ ExpectedErrorCode);
                        SoftObj.assertEquals(ActualErrorCode,ExpectedErrorCode);

                    }

                    SoftObj.assertEquals(ExpectedStatusCode,ActualStatusCode);
                    SoftObj.assertAll();

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

    @DataProvider(name = "LinkBEwithFP")
    public Object[][] provideLinkBEwithFP(Method method) {
            ArrayList<ArrayList<Object>> resultArray = provideTestData("LinkBEwithFP");
            Object[][] result = new Object[resultArray.size()][1];
            for (int i = 0; i < resultArray.size(); i++) {
                BusinessEntityLinkDM linkBusinessEntityAPITestData = new BusinessEntityLinkDM();
                linkBusinessEntityAPITestData.setTestCaseTitle(resultArray.get(i).get(LinkBeWithFPExcellndices.TEST_CASE_TITLE_INDEX).toString());
                linkBusinessEntityAPITestData.setPrevent_multiple_customer_login(resultArray.get(i).get(LinkBeWithFPExcellndices.prevent_multiple_customer_login).toString());
                linkBusinessEntityAPITestData.setApp_fp(resultArray.get(i).get(LinkBeWithFPExcellndices.app_fp).toString());
                linkBusinessEntityAPITestData.setAllow_cash_account(resultArray.get(i).get(LinkBeWithFPExcellndices.allow_cash_account).toString());
                linkBusinessEntityAPITestData.setPromo(resultArray.get(i).get(LinkBeWithFPExcellndices.promo).toString());
                linkBusinessEntityAPITestData.setInvoice(resultArray.get(i).get(LinkBeWithFPExcellndices.invoice).toString());
                linkBusinessEntityAPITestData.setInstallment(resultArray.get(i).get(LinkBeWithFPExcellndices.installment).toString());
                linkBusinessEntityAPITestData.setShipping_option(resultArray.get(i).get(LinkBeWithFPExcellndices.shipping_option).toString());
                linkBusinessEntityAPITestData.setStore_option(resultArray.get(i).get(LinkBeWithFPExcellndices.store_option).toString());
                linkBusinessEntityAPITestData.setEstatment(resultArray.get(i).get(LinkBeWithFPExcellndices.estatment).toString());
                linkBusinessEntityAPITestData.setIntegrationUrl(resultArray.get(i).get(LinkBeWithFPExcellndices.integrationUrl).toString());
                linkBusinessEntityAPITestData.setStatus_Code(parseInt(resultArray.get(i).get(LinkBeWithFPExcellndices.ExpectedStatusCode).toString()));
                linkBusinessEntityAPITestData.setBE_Name(resultArray.get(i).get(LinkBeWithFPExcellndices.BE_name).toString());

                //

                result[i][0] = linkBusinessEntityAPITestData;
            }
            return result;
        }

    @DataProvider(name = "BEView")
    public Object[][] provideBEView(Method method) {
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
