package com.bblog.test.datastore;

import com.bblog.test.apimodels.Root;
import com.bblog.test.support.util.ThreadLocalMap;

public class ArticleDataStore {

    private static final String CURRENT_ARTICLE = "CURRENT_ARTICLE";

    public static Root getCurrentArticle() {
        return ThreadLocalMap.getItem(CURRENT_ARTICLE, Root.class);
    }

    public static void setCurrentArticle(Root root) {
        ThreadLocalMap.getMap().put(CURRENT_ARTICLE, root);
    }
}
