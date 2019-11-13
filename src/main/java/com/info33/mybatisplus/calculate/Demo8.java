package com.info33.mybatisplus.calculate;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo8 {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DATE, -1);
        yesterday.set(Calendar.HOUR, 0);
        yesterday.set(Calendar.MINUTE, 0);
        yesterday.set(Calendar.SECOND, 0);
        Date date = yesterday.getTime();
        System.out.println(format.format(date).substring(0,7));

        BigDecimal aa = new BigDecimal("10.203");
        BigDecimal subtract = aa.subtract(new BigDecimal("8.203"));
        System.out.println("subtract = " + subtract);
//        BigDecimal multiply = aa.multiply(new BigDecimal("0.2"));
//        System.out.println(multiply);

        Calendar instance = Calendar.getInstance();
        int month = instance.get(Calendar.MONTH) + 1;
        System.out.println("month = " + month);

//        String date = "2019-08-28T03:18:19.000Z";
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            Date parse = format.parse(time);
//            System.out.println("format = " + format2.format(parse));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        String date = "2015-12-7T16:00:00.000Z";
//        date = date.replace("Z", " UTC");//注意是空格+UTC
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");//注意格式化的表达式
//        try {
//            Date d = format.parse(date);
//            System.out.println("d = " + d);
//            System.out.println(format2.format(d));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        String a = "11";
//        int v = 1;
//        BigDecimal c = new BigDecimal(11);
//        String typeName = c.getClass().getTypeName();
//        int i = typeName.lastIndexOf(".");
//        String substring = typeName.substring(i+1);
//        System.out.println(substring);
//        System.out.println(c.getClass().getSuperclass());
//        System.out.println(c.getClass().getName());
//        System.out.println(c.getClass().toString());
//        System.out.println(c.getClass().getTypeName());
//        System.out.println(c.getClass().getCanonicalName());

//        Double d = 11.00;
//        Double c = 11.00;
//        System.out.println(d == c);
//        System.out.println(d.equals(c));
//        Long l = 112222222222L;
//        Long v = 112222222222L;
//        System.out.println(l == v);
//        System.out.println(l.equals(v));
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
//        Date newDate = new Date();
//        String yes = "2019-8-15";
//
//        String today = format.format(newDate);
//
//        System.out.println("today = " + today);
//        try {
//            Date parse = format.parse(yes);
//            Date parse2 = format.parse(today);
//            System.out.println("yes = " + parse.getTime());
//            System.out.println("today = " + parse2.getTime());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        String str0 = "hel,lo,wor,l,d";
//
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 100000; i++){
//            str0 += i;
//        }
//        System.out.println(System.currentTimeMillis() - start);
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("a");
//        arrayList.add("b");
//        arrayList.add("c");
//        arrayList.forEach(System.out::println);
//        for (String str: arrayList ) {
//            System.out.println("str = " + str);
//        }
    }
}
