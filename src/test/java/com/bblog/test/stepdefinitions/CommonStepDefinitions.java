package com.bblog.test.stepdefinitions;

import com.bblog.test.apimodels.Root;
import com.bblog.test.apimodels.User;
import com.github.javafaker.Faker;
import net.thucydides.core.annotations.Step;

import static com.bblog.test.datastore.UserDataStore.setCurrentUser;

public class CommonStepDefinitions {

    @Step
    public void setValidDataToSignIn() {
        Root root = new Root();
        User user = new User();
        user.setUsername("bbloguser12345");
        user.setEmail("bbloguser12345@bbloguser12345.com");
        user.setPassword("123456");
        root.setUser(user);
        setCurrentUser(root);
    }

    @Step
    public void setValidDataToSignUp() {
        Faker faker = new Faker();
        Root root = new Root();
        User user = new User();
        user.setUsername(faker.random().hex(15));
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        root.setUser(user);
        setCurrentUser(root);
    }

    @Step
    public void setDataWithOutPassword() {
        Faker faker = new Faker();
        Root root = new Root();
        User user = new User();
        user.setEmail(faker.internet().emailAddress());
        user.setUsername(faker.random().hex(15));
        root.setUser(user);
        setCurrentUser(root);
    }

    @Step
    public void setDataWithOutEmail() {
        Faker faker = new Faker();
        Root root = new Root();
        User user = new User();
        user.setPassword(faker.internet().emailAddress());
        user.setUsername(faker.random().hex(15));
        root.setUser(user);
        setCurrentUser(root);
    }

    @Step
    public void setInvalidData() {
        Root root = new Root();
        setCurrentUser(root);
    }
}
