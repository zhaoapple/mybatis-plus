package com.info33.mybatisplus.dataStructrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BrecketChecker {
    /**
     * 分隔符匹配
     * 分隔符匹配程序从字符串中不断地读取程序，每次读取一个字符，若发现它是左分隔符（{、[、(），将它压入栈中。
     * 当读到一个右分隔符时（)、]、}），弹出栈顶元素，并且查看它是否和该右分隔符匹配。
     * 如果它们不匹配，则程序报错。如果到最后一直存在着没有被匹配的分隔符，程序也报错
     */

    private String input;  //存储待检查的字符串

    //构造方法，接受待检查的字符串
    public BrecketChecker(String in){
        this.input = in;
    }

    //检查分隔符匹配的方法
    public void check(){
        int strLength = input.length();
        Stack stack = new Stack(strLength);

        for(int i=0;i<strLength;i++){

            char ch =input.charAt(i);  //一次获取串中的单个字符

            switch(ch){
                case '{' :
                case '[' :
                case '(' :
                    //如果为左分隔符，压入栈
                    stack.push(ch);
                    break;
                case '}' :
                case ']' :
                case ')' :
                    //如果为右分隔符，与栈顶元素进行匹配
                    if(!stack.isEmpty()){
                        char chx = stack.pop();

                        if((ch == '{' && chx != '}')||
                                (ch == '(' && chx != ')')||
                                (ch == '[' && chx != ']')
                                ){
                            System.out.println("匹配出错！字符："+ch+",下标："+i);
                        }else{
                            System.out.println("匹配成功！字符："+ch+",下标："+i);
                        }
                    }else{
                        System.out.println("匹配出错！字符："+ch+",下标："+i);
                    }

                default :
                    break;
            }

        }

        if(!stack.isEmpty()){
            //匹配结束时如果栈中还有元素，证明右分隔符缺失
            System.out.println("有括号没有关闭！");
        }
    }
    public static void main(String[] args) {

        System.out.println("输入需要检测的字符串：");
        String str = getString();
        BrecketChecker checker = new BrecketChecker(str);
        checker.check();
    }

    public static String getString(){
        String str = "";
        try{
            InputStreamReader reader =new InputStreamReader(System.in);
            BufferedReader bReader = new BufferedReader(reader);
            str = bReader.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
        return str;
    }

}
