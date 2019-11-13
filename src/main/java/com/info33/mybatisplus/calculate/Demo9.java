package com.info33.mybatisplus.calculate;

public class Demo9 {
    public static void main(String[] args) {
        Demo9 d = new Demo9();
        d.sysout2();
        d.sysout();
    }
    int a = 10;
    public void sysout(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a++;
        System.out.println("11111111111111111"+a);
    }
    public synchronized void sysout2(){


        sysout();
        a+=2;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sysout();
        System.out.println("22222222222222222"+a);

    }
}
