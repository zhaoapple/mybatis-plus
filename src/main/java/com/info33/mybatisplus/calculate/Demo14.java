package com.info33.mybatisplus.calculate;

import java.util.*;

public class Demo14 {
    public static void main(String[] args) {

        List yy = new ArrayList();
        System.out.println(!yy.isEmpty());

        Integer aaaa = 1000000001;
        Integer bbbb = 1000009901;

        System.out.println(aaaa+bbbb);

        String stra = "周口市明丽区花园小区二单元";
        int i = stra.indexOf("省");
        if(i == -1){
            i=0;
        }
        int j = stra.indexOf("市");
        if(i != 0){
            i += 1;
        }
        String substring1 = stra.substring(i, j + 1);
        System.out.println("substring1 = " + substring1);
        String replace = stra.replace(" ", "");
        System.out.println("replace = " + replace);
        String a = "0";
        String str = "减速市南京";
        int indexOf = str.indexOf("市");
        String substring = str.substring(0, indexOf);
        System.out.println("substring = " + substring);
        
        
        List returnInfos = new ArrayList<>();
        Map<String,Object> amp = new HashMap<>();
        amp.put("id", 10000981L);
        Map<String,Object> amp2 = new HashMap<>();
        amp2.put("id", 10000989L);
        Map<String,Object> amp3 = new HashMap<>();
        amp3.put("id", 10000985L);
        returnInfos.add(amp);
        returnInfos.add(amp2);
        returnInfos.add(amp3);
        System.out.println(returnInfos);
        Collections.sort(returnInfos,new Comparator<Map>() {
            @Override
            public int compare(Map arg0, Map arg1) {
                Long parseLong = Long.parseLong(arg0.get("id").toString());
                Long parseLong2 = Long.parseLong(arg1.get("id").toString());
                return parseLong2.compareTo(parseLong);
            }
        });
        System.out.println(returnInfos);


//        Integer num = 6;
//        if(num !=5 && num !=6){
//            System.out.println(11);
//        }
//        long round = Math.round(1.002);
//        System.out.println("round = " + round);
//
//        Double a = 104999.03;
//        Double b = 1088.00;
//        System.out.println(a+b);
//
//        String ss = "交易关闭";
//        System.out.println(ss.contains("交易关闭"));

//        LocalDate now = LocalDate.now();
//        List days = new ArrayList<>();
//        for (int i = 0; i < 12; i++) {
//            LocalDate localDate = now.plusDays(-i);
//            days.add(localDate);
//        }
//        System.out.println(days);
//
//        String str = "2019-09-04 11:18:46";
//        String substring = str.substring(0, 10);
//        System.out.println("substring = " + substring);
    }
}
