package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GlobalConfig {
    public String BASE_URL = "https://api.github.com";

    public String token = "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";

    public RequestSpecification request = RestAssured.given();
    public Response response;
    public void authenticationWithPrivateToken(String baseUrl, String token) {
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given();
        request.header("Authorization", "Token " + token);
    }


}


