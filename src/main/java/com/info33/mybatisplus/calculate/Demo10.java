package com.info33.mybatisplus.calculate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo10 {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date time = calendar.getTime();
        long timeInMillis = calendar.getTimeInMillis();
        System.out.println(df.format(time));
        System.out.println(timeInMillis);
        Calendar today = Calendar.getInstance();
//        calendar.add(Calendar.DATE, -1);
        today.set(Calendar.HOUR, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        Date today3 = today.getTime();
        long today2 = today.getTimeInMillis();
        System.out.println(df.format(today3));
        System.out.println(today2);

    }
}
