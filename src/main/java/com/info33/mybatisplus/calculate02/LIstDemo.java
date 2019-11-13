package com.info33.mybatisplus.calculate02;

import java.util.*;
import java.util.stream.Collectors;

public class LIstDemo {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person("张1",1,1);
        Person p2 = new Person("张2",101,101);
        Person p3 = new Person("张10",10,101);
        list.add(p1);
        list.add(p2);
        list.add(p3);

        /**
         * 1.forEach()进行遍历集合
         *    item：可以是任意值。类似于for循环中的循环值
         */
//        list.forEach(item->{
//            //设置值
//            item.setName(item.getName()+"测试");;
//            //输出语句
//            System.out.println(item.toString());
//        });

        /**
         * 2.stream()流操作
         */
        //2.1. 去重 distinct() 去重；collect(Collectors.toList())。封装成集合,对对象不能去重，对基本类型可以
        List<Person> distinctList = list.stream().distinct().collect(Collectors.toList());
//        distinctList.forEach(System.out::println);
        //2.2 排序  sorted((第一个对象，第二个对象)->返回值)  （升降序看是第几个对象与第几个对象比较）
        //倒序排只要将o1与o2互换位置
        List<Person> sortedList = list.stream().sorted((o1,o2)->o1.getAge()-o2.getAge()).collect(Collectors.toList());
//        System.out.println(sortedList);
        //2.3 过滤 ， filter(item->{})   item为每一项。 按照自己的需求来筛选list中的数据
        List<Person> filterList = list.stream().filter(item->item.getAge()>3).collect(Collectors.toList());
        //2.4 map(), 提取对象中的某一元素.  用每一项来获得属性（也可以直接用  对象::get属性()）
        List<String> mapList1 = list.stream().map(Person::getName).collect(Collectors.toList());
        List<String> mapList2 = list.stream().map(item->item.getName()).collect(Collectors.toList());
        List<Integer> mapList3 = list.stream().map(item->item.getAge()).collect(Collectors.toList());
        System.out.println(mapList3);
        //2.5 统计 sum() 。mapToDouble() 转换成double。还有其他类型转换。可以自己研究。
        //           max(),min(),average()
        double sum = list.stream().mapToDouble(Person::getAge).sum();
        //2.6 分组   Collectors.groupingBy(属性名)
        Map<Integer, List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getAge));
        //2.7 多重分组 Collectors.groupingBy(属性，Collectors.groupingBy(属性))
        Map<String, Map<Integer, List<Person>>> map2 = list.stream().collect(Collectors.groupingBy(t->t.getName(),Collectors.groupingBy(t->t.getAge())));
        //2.8 分组并计算综合        Collectors.summarizingLong()
        Map<String, Map<Integer, LongSummaryStatistics>> map3 = list.stream().collect(Collectors.groupingBy(t->t.getName(),Collectors.groupingBy(t->t.getAge(),Collectors.summarizingLong(Person::getSize))));

        /**
         *  3.  集合比较的简写方式
         */
        list.sort((o1,o2)->{return o1.getAge()-o2.getAge();});


        //去重
        List<Long> idList = new ArrayList<Long>();
        idList.add(1L);
        idList.add(1L);
        idList.add(2L);
        List<Long> distinctIdList = idList.stream().distinct().collect(Collectors.toList());
//        System.out.println(distinctIdList);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        integers.forEach(num -> {
            if(num == 1){
//                System.out.println(num);
            }
        });
//        integers.forEach(System.out::println);

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> mapped = numbers.stream().map(x -> x * 2).collect(Collectors.toList());
//        mapped.forEach(System.out::println);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum1 = numbers.stream().reduce((x, y) -> x + y).get();
//        System.out.println(sum1);
        List<Integer> collect = numbers.stream().filter(num -> num >= 4).collect(Collectors.toList());
//        System.out.println(collect);
    }
}
