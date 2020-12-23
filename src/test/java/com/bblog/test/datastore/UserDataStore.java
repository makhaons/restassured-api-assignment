package com.bblog.test.datastore;

import com.bblog.test.apimodels.Root;
import com.bblog.test.support.util.ThreadLocalMap;

public class UserDataStore {

    private static final String CURRENT_USER = "CURRENT_USER";

    public static Root getCurrentUser() {
        return ThreadLocalMap.getItem(CURRENT_USER, Root.class);
    }

    public static void setCurrentUser(Root root) {
        ThreadLocalMap.getMap().put(CURRENT_USER, root);
    }
}
