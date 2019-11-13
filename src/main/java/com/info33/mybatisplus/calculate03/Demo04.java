package com.info33.mybatisplus.calculate03;

import java.util.concurrent.*;

public class Demo04 {
    public static void main(String[] args) {
        /**
         *  线程池的好处即将任务的提交与任务的执行解耦开，为一个给定的任务设置执行策略。
         *  异步收集执行线程执行结果
         */
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool);
        Integer sum = 0;
        for (int i = 0; i < 5; i++) {
//            CompletionService用于提交一组Callable任务，其take方法返回已完成的一个Callable任务对应的Future对象。
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    //第三个线程睡眠等待
                    return 1;
                };
            });
            try {
                Integer integer = completionService.take().get();
                System.out.println("integer = " + integer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

