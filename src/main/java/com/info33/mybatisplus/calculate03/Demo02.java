package com.info33.mybatisplus.calculate03;

public class Demo02 {
    public static void main(String[] args) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("测试runable");
                    }
                }
        ){}.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println("测试thread");
            }
        }.start();
    }
}