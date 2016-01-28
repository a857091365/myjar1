package com.xjwww.www.myjar.config;

import android.content.Context;
import android.graphics.Typeface;

import com.xjwww.www.mylibrary.config.SharedPreferenceLess;

/**
 * Created by www1 on 15/12/28.
 */
public class Config {
    public static Context context;
    public static Typeface typeface;


    /**
     * 设置字体样式
     */
    public static void setTypeface() {
        //typeface = Typeface.createFromAsset(Config.context.getAssets(), "icomoon.ttf");

    }
    /**
     * sharepreference
     */
    public static class sp{
        public static final String trueValue = "1";
        public static final String falseValue = "0";

        public static final String tag_message_reminder = "message_reminder";
        public static  void setMessageReminder(Boolean str){
            SharedPreferenceLess.$put(context, tag_message_reminder, str ? trueValue : falseValue);
        }
        public static Boolean getMessageReminder(){
            return (Boolean) SharedPreferenceLess.$get(context, tag_message_reminder, falseValue).equals(falseValue) ? false : true;
        }

    }

    /**
     * 跳转用
     */
    public static class redirect{
        public static void toLoginFirstActivity(Context context){

        }
    }




}
