package com.fawry.API.angularAutomation.tests;

import com.fawry.API.angularAutomation.backendServices.ServicesDelegate;
import com.fawry.API.angularAutomation.constants.GeneralConstants;
import com.fawry.API.angularAutomation.constants.excelIndices.LinkBeWithBeExcellndices;
import com.fawry.API.angularAutomation.constants.excelIndices.LinkBeWithBranchExcellndices;
import com.fawry.API.angularAutomation.dataModels.AddUpdateBusinessEntityDM;
import com.fawry.API.angularAutomation.dataModels.LinkBeBeDM;
import com.fawry.API.angularAutomation.dataModels.LinkBeBranchDM;
import com.fawry.API.angularAutomation.pages.LinkBeBePage;
import com.fawry.API.angularAutomation.pages.LinkBeBranchPage;
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

public class LinkBeBranch extends BaseTest{

    ApiLogin LgnObj = new ApiLogin();
    String token = LgnObj.GetloginToken();

    @Test(description = "LinkBEwithBranch", dataProvider = "LinkBEwithBranch", priority = 0)
    public void LinkBEwithBranch(LinkBeBranchDM LinkBEDMObj) {
        try {
            test = extent.createTest(LinkBEDMObj.getTestCaseTitle());
            Log.test = test;
            Log.startTestCase(LinkBEDMObj.getTestCaseTitle());
            try {
                RestAssured.basePath = generalCofigsProps.getProperty(GeneralConstants.Link_Be_Base_Path1);
                SoftAssert SoftObj = new SoftAssert();
                String NameEn =  LinkBEDMObj.getBE_Name();
                ServicesDelegate backendService = new ServicesDelegate();
                AddUpdateBusinessEntityDM BusinessEntityInDB = backendService.getBEDetails(NameEn, GeneralConstants.TEST_CASE_METHOD_ADD);
                int BE_ID = parseInt(BusinessEntityInDB.getBE_ID());

                JSONObject Payload = new JSONObject();
                LinkBeBranchPage BrPageobj = new LinkBeBranchPage();
                BrPageobj.AddOJsonObjPayload(LinkBEDMObj,Payload);
                String endpoint = "/"+BE_ID+"/applications/be";
                Response response=  LinkBe(Payload,endpoint,token);
                int ActualStatusCode= response.getStatusCode();
                int ExpectedStatusCode = LinkBEDMObj.getStatus_Code();

                String ExpectedErrorCode = LinkBEDMObj.getError_Code();
                if(ActualStatusCode==200 &&ActualStatusCode==ExpectedStatusCode){

                    Log.info("API successed with Actual Status code " + ActualStatusCode + " which is the expected status code " + ExpectedStatusCode);

                    // get features for above API
                    String GetFeaturesAPiName = "be";
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

    @DataProvider(name = "LinkBEwithBranch")
    public Object[][] provideLinkBEwithBranch(Method method) {
        ArrayList<ArrayList<Object>> resultArray = provideTestData("LinkBEwithBranch");
        Object[][] result = new Object[resultArray.size()][1];
        for (int i = 0; i < resultArray.size(); i++) {
            LinkBeBranchDM linkBusinessEntityAPITestData = new LinkBeBranchDM();
            linkBusinessEntityAPITestData.setTestCaseTitle(resultArray.get(i).get(LinkBeWithBranchExcellndices.TEST_CASE_TITLE_INDEX).toString());
            linkBusinessEntityAPITestData.setBranch_table_qr(resultArray.get(i).get(LinkBeWithBranchExcellndices.branch_table_qr).toString());
            linkBusinessEntityAPITestData.setBranch_table(resultArray.get(i).get(LinkBeWithBranchExcellndices.branch_table).toString());
            linkBusinessEntityAPITestData.setBranch(resultArray.get(i).get(LinkBeWithBranchExcellndices.branch).toString());
            linkBusinessEntityAPITestData.setApp_be(resultArray.get(i).get(LinkBeWithBranchExcellndices.app_be).toString());
            linkBusinessEntityAPITestData.setBranch_service(resultArray.get(i).get(LinkBeWithBranchExcellndices.branch_service).toString());
            linkBusinessEntityAPITestData.setBranch_shift(resultArray.get(i).get(LinkBeWithBranchExcellndices.branch_shift).toString());
            linkBusinessEntityAPITestData.setBranch_coverage(resultArray.get(i).get(LinkBeWithBranchExcellndices.branch_coverage).toString());
            linkBusinessEntityAPITestData.setBranch_working_hours(resultArray.get(i).get(LinkBeWithBranchExcellndices.branch_working_hours).toString());
            linkBusinessEntityAPITestData.setBranch_category(resultArray.get(i).get(LinkBeWithBranchExcellndices.branch_category).toString());
            linkBusinessEntityAPITestData.setStatus_Code(parseInt(resultArray.get(i).get(LinkBeWithBranchExcellndices.ExpectedStatusCode).toString()));
            linkBusinessEntityAPITestData.setBE_Name(resultArray.get(i).get(LinkBeWithBranchExcellndices.BE_name).toString());
            linkBusinessEntityAPITestData.setError_Code(resultArray.get(i).get(LinkBeWithBranchExcellndices.Error_Code).toString());


            //

            result[i][0] = linkBusinessEntityAPITestData;
        }
        return result;
    }
}
