package com.info33.mybatisplus.myself;

import java.io.File;

public class Jiechen {
    public static void main(String[] args) {
        File file = new File("/3");
        file(file);
    }
    //n以内的和
    public static Integer sum(Integer num){
        if(num <0){
            return 0;
        }
        return num+sum(num-1);
    }
    //n以内的阶乘
    public static Integer multiply(Integer num){
        if(num <=0){
            return 1;
        }
        return num*multiply(num-1);
    }
    //计算斐波那契数列的第n项
    public static Integer shuLie(Integer num){
        /**
         * 第n项为第n-1项与n-2项的和
         * ···
         * 第3项为第2项的与第1项的和
         * 第2项为1，第1项为1
         */
        if(num ==0 ){
            return 0;
        };
        if(num ==1){
            return 1;
        }
        return shuLie(num-1)+shuLie(num-2);
    }
    //遍历文件
    public static void file(File pfile){
        File[] files = pfile.listFiles();
        for (File file : files) {
            if(file.isDirectory()){
                file(file);
            }else{
                if(file.getName().endsWith(".md")){
                    System.out.println("文件的AbsolutePath路径为："+file.getAbsolutePath());
                    System.out.println("文件的路径为："+file.getPath());
                }
            }
        }

    }

}
