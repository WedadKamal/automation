package com.fawry.API.angularAutomation.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fawry.API.angularAutomation.constants.GeneralConstants;
import com.fawry.API.angularAutomation.constants.excelIndices.LoginBEExcelIndices;
import com.fawry.API.angularAutomation.dataModels.LoginBusinessEntityDM;
import com.fawry.API.angularAutomation.utils.Log;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static java.lang.Integer.parseInt;

public class ApiLogin extends BaseTest {


    String endpoint = generalCofigsProps.getProperty(GeneralConstants.LOGIN_ENDPOINT);
    String MailStatic = generalCofigsProps.getProperty(GeneralConstants.ADMIN_MAIL);
    String passwordStatic = generalCofigsProps.getProperty(GeneralConstants.ADMIN_PASSWORD);
    String beMail = generalCofigsProps.getProperty(GeneralConstants.BE_MAIL);
    String bePassword = generalCofigsProps.getProperty(GeneralConstants.BE_PASSWORD);



    @Test(description = "login with BE API", dataProvider = "LoginBeAPI")
    public void LoginBeAPI(LoginBusinessEntityDM loginBusinessEntityAPITestData) {

        try {


            ReportTestCaseTitle(loginBusinessEntityAPITestData);
            String Mail = loginBusinessEntityAPITestData.getuserIdentifier();
            String password = loginBusinessEntityAPITestData.getpassword();
            int expectedStatusCode = loginBusinessEntityAPITestData.getExpectedstatusMessage();
            LoginBusinessEntityDM LgnOb = new LoginBusinessEntityDM(Mail,password);
            Log.info("sending api " + LgnOb);
            Response response = RestAssured.given().contentType("application/json\n").body(LgnOb).when().log()
                    .all().post(endpoint);
            int ActualStatuscode = response.getStatusCode();
            StatusAssertion(ActualStatuscode, expectedStatusCode);
            Log.info("API response with " + response.getBody().asString());
            given().contentType("application/json\n").body(LgnOb).when().log()
                    .all().post(endpoint).then().assertThat().statusCode(expectedStatusCode);

        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);

        }


    }

    public String GetloginToken() {


        String Token ="";
        try {
            LoginBusinessEntityDM LgnObstatic = new LoginBusinessEntityDM(MailStatic, passwordStatic);
             Token = given().contentType("application/json\n").body(LgnObstatic).when().log()
                    .all().post(endpoint).then().assertThat().extract().path("token");


    }catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);

        }
        return Token;
    }
    public String GetloginBEToken() {


        String Token ="";
        try {
            LoginBusinessEntityDM LgnObstatic = new LoginBusinessEntityDM(beMail, bePassword);
            Token = given().contentType("application/json\n").body(LgnObstatic).when().log()
                    .all().post(endpoint).then().assertThat().extract().path("token");


        }catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);

        }
        return Token;
    }


    @DataProvider(name = "LoginBeAPI")
    public Object[][] provideAddBusinessEntityAPI(Method method) {
        ArrayList<ArrayList<Object>> resultArray = provideTestData("LoginBeAPI");
        Object[][] result = new Object[resultArray.size()][1];

        for (int i = 0; i < resultArray.size(); i++) {
            LoginBusinessEntityDM loginBusinessEntityAPITestData = new LoginBusinessEntityDM();
            loginBusinessEntityAPITestData.setTestCaseTitle(resultArray.get(i).get(LoginBEExcelIndices.TEST_CASE_TITLE_INDEX).toString());
            loginBusinessEntityAPITestData.setuserIdentifier(resultArray.get(i).get(LoginBEExcelIndices.USER_MAIL_INDEX).toString());
            loginBusinessEntityAPITestData.setpassword(resultArray.get(i).get(LoginBEExcelIndices.USER_PASSWORD_INDEX).toString());
            System.out.println(loginBusinessEntityAPITestData.getpassword());
            loginBusinessEntityAPITestData.setErrType(resultArray.get(i).get(LoginBEExcelIndices.MSG_ON__TEST_FAILURE_INDEX).toString());
            loginBusinessEntityAPITestData.setExpectedstatusMessage(parseInt(resultArray.get(i).get(LoginBEExcelIndices.EXPECTED_RES_INDEX).toString()));

            result[i][0] = loginBusinessEntityAPITestData;
        }
        return result;
    }

}
