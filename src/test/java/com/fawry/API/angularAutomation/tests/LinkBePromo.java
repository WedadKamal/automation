package com.fawry.API.angularAutomation.tests;

import com.fawry.API.angularAutomation.backendServices.ServicesDelegate;
import com.fawry.API.angularAutomation.constants.GeneralConstants;
import com.fawry.API.angularAutomation.constants.excelIndices.LinkBeWithInvExcellndices;
import com.fawry.API.angularAutomation.constants.excelIndices.LinkBeWithPromoExcellndices;
import com.fawry.API.angularAutomation.dataModels.AddUpdateBusinessEntityDM;
import com.fawry.API.angularAutomation.dataModels.LinkBeInvDM;
import com.fawry.API.angularAutomation.dataModels.LinkBePromoDM;
import com.fawry.API.angularAutomation.pages.LinkBeInvPage;
import com.fawry.API.angularAutomation.pages.LinkBePromoPage;
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

public class LinkBePromo extends BaseTest{

    ApiLogin LgnObj = new ApiLogin();
    String token = LgnObj.GetloginToken();

    @Test(description = "LinkBEwithPromo", dataProvider = "LinkBEwithPromo", priority = 0)
    public void LinkBEwithPromo(LinkBePromoDM LinkBEDMObj) {
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
                LinkBePromoPage PromoPageobj = new LinkBePromoPage();
                PromoPageobj.AddOJsonObjPayload(LinkBEDMObj,Payload);
                String endpoint = "/"+BE_ID+"/applications/pe";
                Response response=  LinkBe(Payload,endpoint,token);
                int ActualStatusCode= response.getStatusCode();
                int ExpectedStatusCode = LinkBEDMObj.getStatus_Code();
                String ExpectedErrorCode = LinkBEDMObj.getError_Code();
                if(ActualStatusCode==200 &&ActualStatusCode==ExpectedStatusCode){

                    Log.info("API successed with Actual Status code " + ActualStatusCode + " which is the expected status code " + ExpectedStatusCode);

                    // get features for above API
                    String GetFeaturesAPiName = "pe";
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

    @DataProvider(name = "LinkBEwithPromo")
    public Object[][] provideLinkBEwithPromo(Method method) {
        ArrayList<ArrayList<Object>> resultArray = provideTestData("LinkBEwithPromo");
        Object[][] result = new Object[resultArray.size()][1];
        for (int i = 0; i < resultArray.size(); i++) {

            LinkBePromoDM linkBusinessEntityAPITestData = new LinkBePromoDM();
            linkBusinessEntityAPITestData.setTestCaseTitle(resultArray.get(i).get(LinkBeWithPromoExcellndices.TEST_CASE_TITLE_INDEX).toString());
            linkBusinessEntityAPITestData.setApp_promo_be(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_be).toString());
            linkBusinessEntityAPITestData.setApp_promo_deal(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_deal).toString());
            linkBusinessEntityAPITestData.setApp_promo_deal_manage(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_deal_manage).toString());
            linkBusinessEntityAPITestData.setApp_promo_deal_view(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_deal_view).toString());
            linkBusinessEntityAPITestData.setApp_promo_customer_offer(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_customer_offer).toString());
            linkBusinessEntityAPITestData.setApp_promo_customer_offer_campaign(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_customer_offer_campaign).toString());
            linkBusinessEntityAPITestData.setApp_promo_campaign_view(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_campaign_view).toString());
            linkBusinessEntityAPITestData.setApp_promo_campaign_manage(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_campaign_manage).toString());
            linkBusinessEntityAPITestData.setApp_promo_customer_offer_discount_code(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_customer_offer_discount_code).toString());
            linkBusinessEntityAPITestData.setApp_promo_customer_offer_discount_view(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_customer_offer_discount_view).toString());
            linkBusinessEntityAPITestData.setApp_promo_customer_offer_discount_manage(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_customer_offer_discount_manage).toString());
            linkBusinessEntityAPITestData.setApp_promo_product(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_product).toString());
            linkBusinessEntityAPITestData.setApp_promo_product_feature(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_product_feature).toString());
            linkBusinessEntityAPITestData.setApp_promo_product_manage(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_product_manage).toString());
            linkBusinessEntityAPITestData.setApp_promo_product_view(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_product_view).toString());
            linkBusinessEntityAPITestData.setApp_promo_category_feature(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_category_feature).toString());
            linkBusinessEntityAPITestData.setApp_promo_category_view(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_category_view).toString());
            linkBusinessEntityAPITestData.setApp_promo_category_manage(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_category_manage).toString());
            linkBusinessEntityAPITestData.setApp_promo_branch(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_branch).toString());
            linkBusinessEntityAPITestData.setApp_promo_branch_view(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_branch_view).toString());
            linkBusinessEntityAPITestData.setApp_promo_branch_manage(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_branch_manage).toString());
            linkBusinessEntityAPITestData.setApp_promo_emp(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_emp).toString());
            linkBusinessEntityAPITestData.setApp_promo_emp_view(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_emp_view).toString());
            linkBusinessEntityAPITestData.setApp_promo_emp_manage(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_emp_manage).toString());
            linkBusinessEntityAPITestData.setApp_promo_redemption_manage(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_redemption_manage).toString());
            linkBusinessEntityAPITestData.setApp_promo_redemption_problem(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_redemption_problem).toString());
            linkBusinessEntityAPITestData.setApp_promo_redemption_coupon_operation(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_redemption_coupon_operation).toString());
            linkBusinessEntityAPITestData.setApp_promo_redemption_coupon_redemption(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_redemption_coupon_redemption).toString());
            linkBusinessEntityAPITestData.setApp_promo_redemption_emp_redemption(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_redemption_emp_redemption).toString());
            linkBusinessEntityAPITestData.setApp_promo_loyalty(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_loyalty).toString());
            linkBusinessEntityAPITestData.setApp_promo_loyalty_program(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_loyalty_program).toString());
            linkBusinessEntityAPITestData.setApp_promo_loyalty_program_view(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_loyalty_program_view).toString());
            linkBusinessEntityAPITestData.setApp_promo_loyalty_program_manage(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_loyalty_program_manage).toString());
            linkBusinessEntityAPITestData.setApp_promo_loyalty_customer(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_loyalty_customer).toString());
            linkBusinessEntityAPITestData.setApp_promo_loyalty_customer_view(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_loyalty_customer_view).toString());
            linkBusinessEntityAPITestData.setApp_promo_loyalty_customer_manage(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_loyalty_customer_manage).toString());
            linkBusinessEntityAPITestData.setApp_promo_loyalty_offer(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_loyalty_offer).toString());
            linkBusinessEntityAPITestData.setApp_promo_loyalty_offer_view(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_loyalty_offer_view).toString());
            linkBusinessEntityAPITestData.setApp_promo_loyalty_offer_manage(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_loyalty_offer_manage).toString());
            linkBusinessEntityAPITestData.setApp_promo_loyalty_reports(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_loyalty_reports).toString());
            linkBusinessEntityAPITestData.setApp_promo_loyalty_points(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_loyalty_points).toString());
            linkBusinessEntityAPITestData.setApp_promo_loyalty_points_view(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_loyalty_points_view).toString());
            linkBusinessEntityAPITestData.setApp_promo_loyalty_points_manage(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_loyalty_points_manage).toString());
            linkBusinessEntityAPITestData.setApp_promo_installment(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_installment).toString());
            linkBusinessEntityAPITestData.setApp_promo_installment_bank(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_installment_bank).toString());
            linkBusinessEntityAPITestData.setApp_promo_installment_direct(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_installment_direct).toString());
            linkBusinessEntityAPITestData.setApp_promo_installment_bank_view(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_installment_bank_view).toString());
            linkBusinessEntityAPITestData.setApp_promo_installment_bank_manage(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_installment_bank_manage).toString());
            linkBusinessEntityAPITestData.setApp_promo_installment_direct_view(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_installment_direct_view).toString());
            linkBusinessEntityAPITestData.setApp_promo_installment_direct_manage(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_installment_direct_manage).toString());
            linkBusinessEntityAPITestData.setApp_promo_static_pages(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_static_pages).toString());
            linkBusinessEntityAPITestData.setApp_promo_static_pages_view(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_static_pages_view).toString());
            linkBusinessEntityAPITestData.setApp_promo_static_pages_manage(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_static_pages_manage).toString());
            linkBusinessEntityAPITestData.setApp_promo_accounts(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_accounts).toString());
            linkBusinessEntityAPITestData.setApp_promo_reconciliation(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_reconciliation).toString());
            linkBusinessEntityAPITestData.setApp_promo_reports(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_reports).toString());
            linkBusinessEntityAPITestData.setApp_promo_accounting(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_accounting).toString());
            linkBusinessEntityAPITestData.setApp_promo_audit_trail_report(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_audit_trail_report).toString());
            linkBusinessEntityAPITestData.setApp_promo_dashboard(resultArray.get(i).get(LinkBeWithPromoExcellndices.app_promo_dashboard).toString());
            linkBusinessEntityAPITestData.setIntegrationUrl(resultArray.get(i).get(LinkBeWithPromoExcellndices.integrationUrl).toString());
            linkBusinessEntityAPITestData.setStatus_Code(parseInt(resultArray.get(i).get(LinkBeWithPromoExcellndices.ExpectedStatusCode).toString()));
            linkBusinessEntityAPITestData.setBE_Name(resultArray.get(i).get(LinkBeWithPromoExcellndices.BE_Name).toString());
            linkBusinessEntityAPITestData.setError_Code(resultArray.get(i).get(LinkBeWithPromoExcellndices.error_code).toString());


            //

            result[i][0] = linkBusinessEntityAPITestData;
        }
        return result;
    }
}
