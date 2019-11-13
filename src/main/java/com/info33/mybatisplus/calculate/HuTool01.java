package com.info33.mybatisplus.calculate;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lisi
 */
public class HuTool01 {
    public static void main(String[] args) throws IOException {
//        String str = "2019-10-11";
//        Date date = DateUtil.parse(str, "yyyy-MM-dd");
//        System.out.println("date = " + date);
//        String today= DateUtil.today();
//        System.out.println("today = " + today);
        //使用BufferReader读取键入信息
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        //创建一个字符数组用来存储键入信息
        String[] str = new String[100];
        System.out.println("请输入文本：");
        System.out.println("输入‘stop’终止输入");
        //循环将键入信息添加到字符数组中
        for (int i = 0;i<100;i++){
            str[i] = bufferedReader.readLine();
            if(str[i].equals("stop")){
                break;
            }
        }//for

        System.out.println("以下是您键入的全部信息：");
        for (int i = 0; i <100 ; i++) {
            if (str[i].equals("stop")) {
                break;
            }
            System.out.println(i+1+"."+str[i]);
        }//for
        bufferedReader.close();//关流

    }
}

