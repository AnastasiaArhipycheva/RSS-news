package com.unn.rsslab;

import android.app.Application;
import android.content.Context;

/**
 * Created by Администратор on 19.10.2016.
 */

public class MyApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
