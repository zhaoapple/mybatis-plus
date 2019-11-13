package com.info33.mybatisplus.calculate03;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable ca = new Calld();
        FutureTask futureTask=new FutureTask<>(ca);
        Thread mThread=new Thread(futureTask);
        mThread.start();
        System.out.println("futureTask = " + futureTask.get());

    }

}
class Calld implements Callable{
    @Override
    public Object call() throws Exception {
        System.out.println(" 测试callable " );
        return "测试";
    }
}
