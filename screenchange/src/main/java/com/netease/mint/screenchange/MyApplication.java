package com.netease.mint.screenchange;

import android.app.Application;
import android.content.Context;

/**
 * Created by bjmaoqisheng on 2017/7/11.
 */

public class MyApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
//        InputMethodHolder.init(base);
        super.attachBaseContext(base);
    }
}
