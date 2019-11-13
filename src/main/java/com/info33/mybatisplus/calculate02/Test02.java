package com.info33.mybatisplus.calculate02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02 {
    public static void main(String[] args) {
//        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//        features.forEach(System.out::println);
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String newDate = "2019-09-08";
        try {
            Date parse = sdf.parse(newDate);
            System.out.println(date.before(parse));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
