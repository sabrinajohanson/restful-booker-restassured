package com.sabrina.api.config;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setup() {
        // Base URL for all requests
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        // Log all requests and responses on failure
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        // Attach full request/response details to the Allure report for every call
        RestAssured.filters(new AllureRestAssured());
    }
}