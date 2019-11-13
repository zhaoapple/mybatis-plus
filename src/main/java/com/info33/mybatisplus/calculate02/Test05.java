package com.info33.mybatisplus.calculate02;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test05 {
    public static void main(String[] args) {
//        String orderPayTime = "";
//        if(orderPayTime != null && !orderPayTime.trim().equals("") ) {
//            System.out.println("119999999999");;
//        }else {
//            System.out.println("11111111111111");
//        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDateTime.now().format(formatter));
        LocalDate date = LocalDate.now();
        System.out.println("date = " + date);
        LocalDate localDate = date.plusYears(0);
        System.out.println("localDate = " + localDate);
        System.out.println("date.isEqual(localDate) = " + date.isEqual(localDate));
    }
}
