package com.xjwww.www.myjar;

import android.app.Application;

import com.xjwww.www.myjar.config.Config;
import com.xjwww.www.myjar.volley.RequestManager;


/**
 * Created by computer on 3/9/15.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Config.context = this;
        Config.setTypeface();
        RequestManager.init(this);
    }
}
