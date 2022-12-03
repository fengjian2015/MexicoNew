package com.lucksoft.commonui;

import android.app.Application;

public class AppInstance {

    private static Application instance;

    private AppInstance() {}

    public static void init(Application application) {
        instance = application;
    }

    public static Application getApp() {
        return instance;
    }
}
