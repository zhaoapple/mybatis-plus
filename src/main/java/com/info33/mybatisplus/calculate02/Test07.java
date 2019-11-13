package com.info33.mybatisplus.calculate02;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test07 {
    public static void main(String[] args) {

        String str = "211abc";
        String regx = "^2\\d{2}\\w*";
        //匹配
        boolean matches = str.matches(regx);
        System.out.println("matches = " + matches);

        //分割
        String str2 = "aa   1112 sjs asdf  ";
        String regx2 = " +";
        String[] split = str2.split(regx2);
        for (String s : split) {
            System.out.println("s = " + s);

        }

        //获取
        String str3 = "替换替换";
        String regx3 = "换替";
        Pattern p = Pattern.compile(regx3);
        Matcher m  = p.matcher(str3);
        while (m.find()){
            System.out.println(m.group());
        }


        //替换
        String str4 = "替换替换";
        String regx4 = "换";
        String s = str4.replaceAll(regx4, "0");
        System.out.println("s = " + s);

        String strDemo = "测试";
        Date date = new Date();
        Integer a = 0;
        System.out.println(a.getClass());
    }
}
