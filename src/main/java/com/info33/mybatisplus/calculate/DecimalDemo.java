package com.info33.mybatisplus.calculate;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DecimalDemo {
    public static void main(String[] args) {
        Long a = 0L;
        System.out.println(a.equals(0L));
        System.out.println(a == 0);


        String name = "南京苏州";
        boolean contains = name.contains(",") || name.contains("，");
        System.out.println("contains = " + contains);

        String[] nums = {"1.01","1.33","1.11","1.52"};
        BigDecimal totalMoney = new BigDecimal("0.0");
        for (String num : nums) {
            BigDecimal b2 = new BigDecimal(num);
            totalMoney = totalMoney.add(b2);
        }
        System.out.println(totalMoney );
        Calendar cal = Calendar.getInstance();
        System.out.println();
        Date time = cal.getTime();
        SimpleDateFormat  sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(time);
        System.out.println("format = " + format);
    }
}
