package com.info33.mybatisplus.calculate03;

public class Demo03 {
    public static void main(String[] args) {
        Thread myThread = new MyThread();
        for (int i = 0; i < 100; i++) {
            System.out.println("main thread i = " + i);
            if (i == 20) {
                myThread.setDaemon(true);
                myThread.start();
            }
        }
    }
}
class MyThread extends Thread {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("i = " + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}