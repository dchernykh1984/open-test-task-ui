package com.epam.bko.at.testtask;

import com.epam.bko.at.testtask.helpers.PropertiesReader;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

public class GitHubApiFailure {
    ValidatableResponse response;

    @BeforeClass(description = "Make request to https://api.github.com/users/defunkt")
    public void makeRequest() {
        response = when().get("https://api.github.com/users/defunkt").
                then().statusCode(200);
    }

    @Test(description = "Check company contains property company")
    public void checkLogin() {
        response.body("company", equalTo(PropertiesReader.getProperty("company")));
    }

}
