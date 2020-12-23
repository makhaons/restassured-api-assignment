package com.bblog.test.support.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hooks {

    @After
    public void after() {
    }

    @Before
    public void before() {
        RestAssured.baseURI = "https://qa-task.backbasecloud.com/api/";
    }
}
