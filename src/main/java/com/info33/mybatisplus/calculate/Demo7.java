package com.info33.mybatisplus.calculate;

import java.util.ArrayList;
import java.util.List;

public class Demo7 {
    //根据某个站点的一年数据计算汇总月份数据

    public static List<Double> queryWeather(List<String> list, int group)
    {
        if (null==list || 0==list.size()) {
            return null;
        }
        List<List<String>> result = new ArrayList<List<String>>();
        // 集合长度
        int size = list.size();
        // 余数
        int remaider = size % group;
        System.out.println("余数:" + remaider);
        // 商
        int number = size / group;
        System.out.println("商:" + number);

        int offset=0;//偏移量
        for(int i=0;i<group;i++){
            List<String> value=null;
            if(remaider>0){
                value=list.subList(i*number+offset, (i+1)*number+offset+1);
                remaider--;
                offset++;
            }else{
                value=list.subList(i*number+offset, (i+1)*number+offset);
            }
            result.add(value);
        }
        System.out.println("result = " + result);
        List<Double> returnList = new ArrayList<>();
        for(int i=0;i<result.size();i++)
        {
            //温度计算
            double temp = temp(result.get(i));
            returnList.add(Math.ceil(temp));
            //降水计算
        }
        return returnList;
    }


    public static double temp(List<String> list)
    {
        double sum = 0;
        for (String string : list) {
           sum += Double.parseDouble(string);
        }
        return sum/(list.size()*1.0);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("12");
        list.add("13");
        list.add("14");
        list.add("15");
        list.add("16");
        list.add("17");
        list.add("18");
        list.add("19");
        list.add("20");
        list.add("21");
        list.add("22");
        list.add("23");
        List<Double> doubles = queryWeather(list, 4);
        System.out.println("doubles = " + doubles);
//        List<List<String>> lists = averageAssign(list, 3);
//        System.out.println(lists);
//        for (int i = 0; i <lists.size() ; i++) {
//            double temp = temp(lists.get(i));
//            System.out.println("temp = " + temp);
//        }
    }

    public static List<List<String>> splitList(List<String> list, int len) {
        if (list == null || list.size() == 0 || len < 1) {
            return null;
        }

        List<List<String>> result = new ArrayList<List<String>>();


        int size = list.size();
        int count = (size + len - 1) / len;


        for (int i = 0; i < count; i++) {
            List<String> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
            result.add(subList);
        }
        return result;
    }

    /**
     * @param list
     * @return
     */
    public static <String> List<List<String>> averageAssign(List<String> list,int n){
        List<List<String>> result=new ArrayList<List<String>>();
        int remaider=list.size()%n;  //(先计算出余数)
        int number=list.size()/n;  //然后是商
        int offset=0;//偏移量
        for(int i=0;i<n;i++){
            List<String> value=null;
            if(remaider>0){
                value=list.subList(i*number+offset, (i+1)*number+offset+1);
                remaider--;
                offset++;
            }else{
                value=list.subList(i*number+offset, (i+1)*number+offset);
            }
            result.add(value);
        }
        return result;
    }

}
