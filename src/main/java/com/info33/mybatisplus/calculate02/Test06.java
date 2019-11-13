package com.info33.mybatisplus.calculate02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test06 {
    public static void main(String[] args) {
        String str = "erkkktyqqquizzzzzo";
        String reg ="(.)\\1";//按照叠词来进行切割
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        System.out.println("m.groupCount() = " + m.groupCount());
//        while (m.find()){
//            System.out.println(m.group(0));
//            System.out.println(m.group(1));
//            System.out.println("------------------------");
//        }
//        System.out.println(m.group());

        //可以将规则封装成一个组。用()完成。组的出现都有编号。
        //从1开始。 想要使用已有的组可以通过  \n(n就是组的编号)的形式来获取。
        String[] arr = str.split(reg);
        System.out.println(arr.length);
        for(String s : arr)
        {
            System.out.print(s);
        }

    }

}
