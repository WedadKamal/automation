package com.fawry.API.angularAutomation.tests;

import com.fawry.API.angularAutomation.backendServices.ServicesDelegate;
import com.fawry.API.angularAutomation.constants.GeneralConstants;
import com.fawry.API.angularAutomation.constants.excelIndices.LinkBeWithOrderExcellndices;
import com.fawry.API.angularAutomation.constants.excelIndices.LinkBeWithStoreExcellndices;
import com.fawry.API.angularAutomation.dataModels.AddUpdateBusinessEntityDM;
import com.fawry.API.angularAutomation.dataModels.LinkBeOrderDM;
import com.fawry.API.angularAutomation.dataModels.LinkBeStoreDM;
import com.fawry.API.angularAutomation.pages.LinkBeOrderPage;
import com.fawry.API.angularAutomation.pages.LinkBeStorePage;
import com.fawry.API.angularAutomation.utils.Log;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class LinkBeOrder extends BaseTest{

    ApiLogin LgnObj = new ApiLogin();
    String token = LgnObj.GetloginToken();

    @Test(description = "LinkBEwithOrder", dataProvider = "LinkBEwithOrder", priority = 0)
    public void LinkBEwithOrder(LinkBeOrderDM LinkBEDMObj) {
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
                LinkBeOrderPage OrderPageobj = new LinkBeOrderPage();
                OrderPageobj.AddOJsonObjPayload(LinkBEDMObj,Payload);
                String endpoint = "/"+BE_ID+"/applications/order";
                Response response=  LinkBe(Payload,endpoint,token);
                int ActualStatusCode= response.getStatusCode();
                int ExpectedStatusCode = LinkBEDMObj.getStatus_Code();
                String ExpectedErrorCode = LinkBEDMObj.getError_Code();
                if(ActualStatusCode==200 &&ActualStatusCode==ExpectedStatusCode){

                    Log.info("API successed with Actual Status code " + ActualStatusCode + " which is the expected status code " + ExpectedStatusCode);

                    // get features for above API
                    String GetFeaturesAPiName = "order";
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

    @DataProvider(name = "LinkBEwithOrder")
    public Object[][] provideLinkBEwithOrder(Method method) {
        ArrayList<ArrayList<Object>> resultArray = provideTestData("LinkBEwithOrder");
        Object[][] result = new Object[resultArray.size()][1];
        for (int i = 0; i < resultArray.size(); i++) {
            LinkBeOrderDM linkBusinessEntityAPITestData = new LinkBeOrderDM();
            linkBusinessEntityAPITestData.setTestCaseTitle(resultArray.get(i).get(LinkBeWithOrderExcellndices.TEST_CASE_TITLE_INDEX).toString());
            linkBusinessEntityAPITestData.setOrder_manage(resultArray.get(i).get(LinkBeWithOrderExcellndices.order_manage).toString());
            linkBusinessEntityAPITestData.setOrders_board(resultArray.get(i).get(LinkBeWithOrderExcellndices.orders_board).toString());
            linkBusinessEntityAPITestData.setOrder_customer(resultArray.get(i).get(LinkBeWithOrderExcellndices.order_customer).toString());
            linkBusinessEntityAPITestData.setStatus_Code(parseInt(resultArray.get(i).get(LinkBeWithOrderExcellndices.ExpectedStatusCode).toString()));
            linkBusinessEntityAPITestData.setBE_Name(resultArray.get(i).get(LinkBeWithOrderExcellndices.BE_name).toString());
            linkBusinessEntityAPITestData.setError_Code(resultArray.get(i).get(LinkBeWithOrderExcellndices.error_Code).toString());


            //

            result[i][0] = linkBusinessEntityAPITestData;
        }
        return result;
    }
}
