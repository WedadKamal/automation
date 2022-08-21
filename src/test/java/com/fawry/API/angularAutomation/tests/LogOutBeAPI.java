package com.fawry.API.angularAutomation.tests;

import com.aventstack.extentreports.gherkin.model.Given;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LogOutBeAPI {


    @Test(description = "Business Entity Log out")
    public void BusinessEntityLogOut() {
        String endpoint = "http://10.95.0.178/be-login/assets/i18n/en.json";

        given().contentType("application/json\n").when().log().all().get(endpoint).then().assertThat().statusCode(200);


    }

}
