package com.info33.mybatisplus.calculate02;

public class Test03 {
    public static void main(String[] args) {
        String address = "北京北京市";
        int i = address.indexOf("市");
        String substring = address.substring(i - 2, i + 1);
        System.out.println("substring = " + substring);

        String aa = null;
        if(aa == null){
            System.out.println(1111);
        }
    }
}
