package com.info33.mybatisplus.calculate02;

public class OptFor {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 10; k++) {
                    
                }
            }
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime2 - startTime) + "ms");
        int i,j,k;
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 100; j++) {
                for (k = 0; k < 1000; k++) {

                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - endTime2) + "ms");
    }
}
