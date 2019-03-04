package com.epam.bko.at.testtask;

import com.epam.bko.at.testtask.helpers.PropertiesReader;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

public class GitHubApi {
    ValidatableResponse response;

    @DataProvider
    public Object[][] parametersForValidation() {
        return new Object[][]{
                {"login", PropertiesReader.getProperty("login")},
                {"company", PropertiesReader.getProperty("company")}
        };
    }

    @BeforeClass(description = "Make request to API by APIendpoint property")
    public void makeRequest() {
        response = when().get(PropertiesReader.getProperty("APIendpoint")).
                then();
    }

    @Test(description = "Check response contains correct value", dataProvider = "parametersForValidation")
    public void checkLogin(String parameterName, String parameterValue) {
        response.statusCode(200).body(parameterName, equalTo(parameterValue));
    }
}
