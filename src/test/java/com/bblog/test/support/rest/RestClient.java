package com.bblog.test.support.rest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpHeaders;

import java.util.HashMap;
import java.util.Map;

import static com.bblog.test.support.util.RestDataStorage.setCurrentRequest;
import static com.bblog.test.support.util.RestDataStorage.setCurrentResponse;

public class RestClient {

    public static Response sendDeleteRequest(String url) {
        Response response = getRequestSpecification().delete(url);
        setCurrentResponse(response);
        return response;
    }

    public static Response sendGetRequest(String url) {
        Response response = getRequestSpecification().get(url);
        setCurrentResponse(response);
        return response;
    }

    public static Response sendGetRequest(String url, String key, String value) {
        Response response = getRequestSpecification(key, value).get(url);
        setCurrentResponse(response);
        return response;
    }

    public static Response sendPostRequest(String url, Object body) {
        Response response = getRequestSpecification(body).post(url);
        setCurrentResponse(response);
        return response;
    }

    public static Response sendPutRequest(String url, Object body) {
        Response response = getRequestSpecification(body).put(url);
        setCurrentResponse(response);
        return response;
    }

    private static RequestSpecification getRequestSpecification(Object body) {
        RequestSpecification requestSpecification = getRequestSpecification();
        requestSpecification.body(body).log().body();
        setCurrentRequest(requestSpecification);
        return requestSpecification;
    }

    private static RequestSpecification getRequestSpecification() {
        RequestSpecification requestSpecification = SerenityRest.given()
                .headers(setCommonHttpHeaders())
                .log().method()
                .log().uri();
        setCurrentRequest(requestSpecification);
        return requestSpecification;
    }

    private static RequestSpecification getRequestSpecification(String key, String value) {
        RequestSpecification requestSpecification = SerenityRest.given()
                .queryParam(key, value)
                .headers(setCommonHttpHeaders())
                .log().method()
                .log().uri();
        setCurrentRequest(requestSpecification);
        return requestSpecification;
    }

    private static Map<String, String> setCommonHttpHeaders() {
        Map<String, String> httpHeaders = new HashMap<>();
        httpHeaders.put(HttpHeaders.ACCEPT, "application/json");
        httpHeaders.put(HttpHeaders.CONTENT_TYPE, "application/json");
        httpHeaders.put(HttpHeaders.AUTHORIZATION, "Basic Y2FuZGlkYXRleDpxYS1pcy1jb29s");
        return httpHeaders;
    }
}
