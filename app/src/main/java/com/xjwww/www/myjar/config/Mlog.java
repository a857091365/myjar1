package com.xjwww.www.myjar.config;

/**
 * Created by computer on 11/9/15.
 */
public class Mlog {
    private static final String tag="xjwww";

    public static void e(String str){
        android.util.Log.e(tag,str);
    }
    public static void e(int str){
        android.util.Log.e(tag,str+"");
    }
}
