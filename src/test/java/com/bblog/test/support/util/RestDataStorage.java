package com.bblog.test.support.util;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestDataStorage {

    private static final String CURRENT_RESPONSE = "CURRENT_RESPONSE";
    private static final String CURRENT_REQUEST = "CURRENT_REQUEST";

    private RestDataStorage() {
    }

    public static RequestSpecification getCurrentRequest() {
        return ThreadLocalMap.getItem(CURRENT_REQUEST, RequestSpecification.class);
    }

    public static void setCurrentRequest(RequestSpecification restRequest) {
        ThreadLocalMap.getMap().put(CURRENT_REQUEST, restRequest);
    }

    public static Response getCurrentResponse() {
        return ThreadLocalMap.getItem(CURRENT_RESPONSE, Response.class);
    }

    public static void setCurrentResponse(Response restResponse) {
        ThreadLocalMap.getMap().put(CURRENT_RESPONSE, restResponse);
    }

}
