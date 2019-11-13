package com.info33.mybatisplus.calculate02;

import java.util.ArrayList;
import java.util.List;

public class Test08 {
    public static void main(String[] args) {
        String str = "上海上海市";
        String aa = str.replace("市", "");
        System.out.println("aa = " + aa);
    }
    public static String filterSameCode(String str) {
        List<Character> list = new ArrayList<Character>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        for (int j = 0; j < list.size(); j++) {
            for (int n = j + 1; n < list.size(); n++) {
                if (list.get(j).equals(list.get(n))) {
                    list.remove(n);
                    n--;
                }
            }
        }
        StringBuffer sb=new  StringBuffer();
        for(Character s:list) {
            sb.append(s);
        }
        return sb.toString();
    }
}
