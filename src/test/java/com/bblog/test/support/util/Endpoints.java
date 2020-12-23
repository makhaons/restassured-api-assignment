package com.bblog.test.support.util;

public enum Endpoints {

    USERS_LOGIN("/users/login"),
    USERS("/users");

    private final String url;

    Endpoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}
