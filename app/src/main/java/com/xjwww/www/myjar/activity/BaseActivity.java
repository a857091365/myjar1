package com.xjwww.www.myjar.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import com.xjwww.www.mylibrary.config.AppManager;

/**
 * Created by www1 on 15/12/28.
 */
public class BaseActivity extends Activity {

    public BaseActivity instance=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);  //将activity 压栈
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 竖屏锁定
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 取消标题
    }
}
