package com.info33.mybatisplus.calculate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Demo13 {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String strtime= "2017/7/28 11:15";
        String replace = strtime.replace("/", "-");
        Date parse = format.parse(replace);
        System.out.println("parse = " + parse);


        Calendar yesterday = Calendar.getInstance();
//        yesterday.add(Calendar.DATE, -5);
        yesterday.add(Calendar.HOUR_OF_DAY, 0);
        yesterday.set(Calendar.MINUTE, 0);
        yesterday.set(Calendar.SECOND, 0);
        long yesterdayTime = yesterday.getTimeInMillis();




        String dayTime = "2019-08-28T03:18:19.000Z";
        String substring = dayTime.substring(0, 10);
        System.out.println(substring.equals("2019-08-29"));
        System.out.println("substring = " + substring);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 日期时间转字符串
        LocalDateTime now = LocalDateTime.now();
        String nowText = now.format(formatter);
        System.out.println("nowText=" + nowText);

        // 字符串转日期时间
        String datetimeText = "1999-12-31 23:59:59";
        LocalDateTime datetime = LocalDateTime.parse(datetimeText, formatter);
        System.out.println(datetime);
        String s = datetime.toString().replaceAll("T", " ");
        System.out.println("s = " + s);

//        System.out.printf("%tT",new Date());
        System.out.println(LocalDate.now().getDayOfMonth());
        System.out.println(LocalDate.now().getMonthValue());
        System.out.println(LocalDate.now().getEra());

//        Calendar today = Calendar.getInstance();
//        today.add(Calendar.DATE,-5);
//        today.set(Calendar.HOUR_OF_DAY, 0);
//        today.set(Calendar.MINUTE, 0);
//        today.set(Calendar.SECOND, 0);
//        Date date = today.getTime();
//        String dateStr = format.format(date);
//        System.out.println("dateStr = " + dateStr);
//        List days = new ArrayList<>();
//        LocalDate date1 = LocalDate.now();
//        System.out.println("date1 = " + date1);
//        LocalDate date2 = LocalDate.of(2019, 8, 1);
//        System.out.println("date2 = " + date2);

//        LocalDate date = LocalDate.now();
//        System.out.printf("日=%s","2019-09-02");

//        String url = "我叫%s,今年%s岁。";
//        String name = "小明";
//        String age = "28";
//        url = String.format(url,name,age);
//        System.out.println(url); //我叫小明，年28岁
//        System.out.println(MessageFormat.format("该域名{0}被访问了 {1} 次.", "1000.00" , 1));
//
//        LocalDate now = LocalDate.now();
//        LocalDate date = LocalDate.of(2019, 9, 2);
//        System.out.println("日期是否相等=" + now.equals(date));


//        LocalTime time = LocalTime.now();
//        LocalTime newTime = time.plusHours(2);
//        System.out.println("newTime=" + time);

//        LocalDate date = LocalDate.now();
//        LocalDate newDate = date.plus(args);
//        LocalDate newDate = date.plusYears(1);
//        LocalDate newDate = date.plusMonths(1);
//        LocalDate newDate = date.plusDays(1);
//        System.out.println("newDate=" + newDate);

        // 解析日期
//        String dateText = "2018-09-24";
//        LocalDate date = LocalDate.parse(dateText, DateTimeFormatter.BASIC_ISO_DATE);
//        LocalDate date = LocalDate.parse(dateText, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        System.out.println("格式化之后的日期=" + date);

        // 格式化日期
//        dateText = date.format(DateTimeFormatter.ISO_DATE);
//        dateText = date.format(DateTimeFormatter.BASIC_ISO_DATE);
//        System.out.println("dateText=" + dateText);


//        for (int countSatrtDay = -4; countSatrtDay <= 0; countSatrtDay++){
//            Calendar today = Calendar.getInstance();
//            today.add(Calendar.DATE, countSatrtDay);
//            today.set(Calendar.HOUR_OF_DAY, 0);
//            today.set(Calendar.MINUTE, 0);
//            today.set(Calendar.SECOND, 0);
//            Date date = today.getTime();
//            String dateStr = format.format(date);
//            days.add(dateStr);
//        }
//        for (Object day : days) {
//            System.out.println("day = " + day);
//        }
//        long todayTime = today.getTimeInMillis();
//        Date time = today.getTime();
//        System.out.println(format.format(time));
//        today.add(Calendar.DATE,-2);
//        Date time2 = today.getTime();
//        System.out.println(format.format(time2));

//        System.out.println("todayTime = " + todayTime);
    }
}
