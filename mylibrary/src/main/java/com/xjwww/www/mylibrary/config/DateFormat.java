package com.xjwww.www.mylibrary.config;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by www1 on 15/12/28.
 */
public class DateFormat {
    public static String getDateToyyyMMdd(Date date){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public static  String getDateToyyyyMMddTHHmmss(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        String str =formatter.format(date);

        return  str;
    }

    public static Date getDateFromyyyMMddTHHmmss(String str) {
        if (str.length() == 19) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date dt = null;
            try {
                dt = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return dt;
        }
        return null;
    }
    //格式 1990-01-01
    public static Date getDateFromyyyyMMdd(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = null;
        try {
            dt = formatter.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dt;
    }

    public static Date getDateFromyyyyMMddhhmmss(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date dt = null;
        try {
            dt = formatter.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dt;
    }

    public static String getStringFromNowDateToyyyyMMdd() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String str = formatter.format(new Date());// new Date()为获取当前系统时间
        return str;
    }

    /**
     * yyyy-MM-dd hh:mm:ss:SSS
     * @return
     */
    public static String getStringFromNowDateToyyyyMMddhh() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");//设置日期格式
        String str = formatter.format(new Date());// new Date()为获取当前系统时间
        return str;
    }

    public static Float getFloat2(Float f) {
        try {
            DecimalFormat df = new DecimalFormat("######0.00");
            return Float.parseFloat(df.format(f));
        } catch (Exception e){
            return 0.00f;
        }
    }
    public static Float getFloat1(Float f) {
        try {
            DecimalFormat df = new DecimalFormat("######0.0");
            return Float.parseFloat(df.format(f));
        } catch (Exception e){
            return 0.0f;
        }
    }
    public static Double getDouble2(Double f) {
        try {
            DecimalFormat df = new DecimalFormat("######0.00");
            return Double.valueOf(df.format(f));
        }catch (Exception e){
            return 0.00;
        }

    }
    public static Double getDouble1(Double f) {
        try {
            DecimalFormat df = new DecimalFormat("######0.0");
            return Double.valueOf(df.format(f));
        }catch (Exception e){
            return 0.0;
        }
    }

}
