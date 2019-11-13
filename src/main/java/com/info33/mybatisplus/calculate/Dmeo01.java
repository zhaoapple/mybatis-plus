package com.info33.mybatisplus.calculate;

public class Dmeo01 {
    //递归计算：斐波那契数列
    //计算数组{1,1,2,3,5,8.......} 第30位值

    public static void main(String[] args) {
        System.out.println("30以内的数字之和为："+cal(30));
    }

    public static Integer cal(int num){
        if(num <0){
            throw new IllegalArgumentException("数字不能为负数");
        }else if(num <=2){
            return 1;
        }else{
            return cal(num-2)+cal(num-1);
        }
    }
}
