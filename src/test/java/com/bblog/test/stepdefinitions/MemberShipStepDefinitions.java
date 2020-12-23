package com.bblog.test.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import static com.bblog.test.datastore.UserDataStore.getCurrentUser;
import static com.bblog.test.support.rest.RestClient.sendPostRequest;
import static com.bblog.test.support.util.Endpoints.USERS;
import static com.bblog.test.support.util.Endpoints.USERS_LOGIN;
import static com.bblog.test.support.util.RestDataStorage.getCurrentResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MemberShipStepDefinitions {

    @Steps
    CommonStepDefinitions commonStepDefinitions;

    @Given("user provides user data without password")
    public void userProvidesUserDataWithoutPassword() {
        commonStepDefinitions.setDataWithOutPassword();
    }

    @Given("user provides invalid user data to login")
    public void userProvidesInvalidUserDataToLogin() {
        commonStepDefinitions.setInvalidData();
    }

    @Given("user provides user data already exist in the application")
    public void userProvidesUserDataAlreadyExistInTheApplication() {
        commonStepDefinitions.setValidDataToSignIn();
    }

    @Given("user provides valid user data to sign in")
    public void userProvidesValidUserDataToSignIn() {
        commonStepDefinitions.setValidDataToSignIn();
    }

    @Given("user provides user data without email address")
    public void userProvidesUserDataWithoutEmailAddress() {
        commonStepDefinitions.setDataWithOutEmail();
    }

    @Given("user provides valid user data to sign up")
    public void userProvidesValidUserDataToSignUp() {
        commonStepDefinitions.setValidDataToSignUp();
    }

    @When("user request to sign in to the application")
    public void userRequestToSignInToTheApplication() {
        sendPostRequest(USERS_LOGIN.getUrl(), getCurrentUser());
    }

    @When("user request to sign up to the application")
    public void userRequestToSignUpToTheApplication() {
        sendPostRequest(USERS.getUrl(), getCurrentUser());
    }

    @And("a response should contain user information")
    public void aResponseShouldContainUserInformation() {
        verifyResponseValue("user.email", getCurrentUser().getUser().getEmail(), getCurrentResponse());
    }

    @And("{string} error is returned")
    public void errorIsReturned(String message) {
        verifyResponseValue("errors.message", message, getCurrentResponse());
    }

    @Then("{string} email error is returned")
    public void emailErrorIsReturned(String message) {
        verifyResponseValue("errors.email", message, getCurrentResponse());
    }

    @Then("{string} password error is returned")
    public void passwordErrorIsReturned(String message) {
        verifyResponseValue("errors.password", message, getCurrentResponse());
    }

    @Then("{string} username error is returned")
    public void usernameErrorIsReturned(String message) {
        verifyResponseValue("errors.username", message, getCurrentResponse());
    }

    @Then("user should get {int} response from the source")
    public void userShouldGetResponseFromTheSource(int statuscode) {
        getCurrentResponse().then().statusCode(statuscode);
    }

    @Step
    public void verifyResponseValue(String path, String value, Response response) {
        String keyvalue = response.jsonPath().getString(path);
        assertThat(keyvalue, is(value));
    }
}
