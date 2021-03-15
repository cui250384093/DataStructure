package com.yl.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author candk
 * @Description
 * @date 3/15/21 - 4:30 PM
 */
public class Time {

    public static void showNowTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(date);
        System.out.println("The time is " + dateStr + " now.");
    }
}
