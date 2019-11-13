package com.info33.mybatisplus.calculate02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Test10 {
    public static void main(String[] args) {
//        String date = "2019-02-12";
        String date = LocalDate.now().toString();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(date.substring(0, 4)));
        calendar.set(Calendar.MONTH, Integer.parseInt(date.substring(5, 7)) -1);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        List dates = new ArrayList<>();
        for(int i = 1; i <= maxDay; i++){
            dates.add(i);
        }
        System.out.println("days.toString() = " + dates);
    }
}
