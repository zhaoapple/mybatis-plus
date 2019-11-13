package com.info33.mybatisplus.calculate02;

public class Test09 {
    public static void main(String[] args) {
        print();
    }

    public static void print(){
        while(true) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    Thread.currentThread().setName("t2");
                    System.out.println(Thread.currentThread().getName() + ",implements Runnable");
                }
            }).start();
        }
    }
}
