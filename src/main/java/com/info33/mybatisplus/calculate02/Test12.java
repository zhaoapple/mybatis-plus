package com.info33.mybatisplus.calculate02;

import java.io.File;

public class Test12 {
    public static void main(String[] args) {
//        FileInputStream is = new FileInputStream();
        File file = new File("E:/9-9/page");
        findFile(file);
    }
    static void findFile(File file){
        if(file.isDirectory()){
            File[] filesArr = file.listFiles();
            for(File f: filesArr){
                findFile(f);
            }
        } else {
//            System.out.println(file.getAbsolutePath());
            System.out.println(file.getName());
        }
    }
}
