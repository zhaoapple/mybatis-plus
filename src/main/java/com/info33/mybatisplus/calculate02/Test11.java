package com.info33.mybatisplus.calculate02;

public class Test11 {
    public static void main(String[] args) {
        
        int i = 1;
        int c = (++i)+(++i);
        System.out.println("c = " + c);
        //设置线程名字
//        Thread.currentThread().setName("main thread");
//
//        for(int i = 0;i<5;i++){
//            MyThread myThread = new MyThread();
//            myThread.setName("子线程:");
//            //开启线程
//            myThread.start();
//        }
//        System.out.println(Thread.currentThread().getName() );

        Thread thread = new Thread(new MyRunnable());
        thread.start();
        System.out.println("thread.getName() = " + thread.getName());
//        Thread th = new Thread(){
//            public void run(){
//                Thread.currentThread().setName("线程名字");
//                System.out.println("11111111111");
//            }
//        };
    }
}
class MyThread extends Thread{
    //重写run()方法
    public void run(){
//        for(int i = 0;i < 5; i++){
            System.out.println(Thread.currentThread().getName());
//        }
    }
}
class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}