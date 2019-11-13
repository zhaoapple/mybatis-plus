package com.info33.mybatisplus.dataStructrue;

public class ArrayDemo {
    private String [] strArray;
    private int length = 0;       //数组元素个数

    public static void main(String[] args) {
        ArrayDemo arrayDemo = new ArrayDemo(10);
//        System.out.println(arrayDemo.length);
//        arrayDemo.insert("10");
//        arrayDemo.insert("11");
        arrayDemo.display();
    }

    //构造方法，传入数组最大长度
    public ArrayDemo(int max){
        strArray = new String [max];
    }

    //检测数组是否包含某个元素，如果存在返回其下标，不存在则返回-1
    public int contains(String target){
        int index = -1;
        for(int i=0;i<length;i++){
            if(strArray[i].equals(target)){
                index = i;
                break;
            }
        }
        return index;
    }

    //插入
    public void insert(String elem) {
        strArray[length] = elem;
        length++;
    }

    //删除某个指定的元素值，删除成功则返回true，否则返回false
    public boolean delete(String target){
        int index = -1;
        if((index = contains(target)) !=-1){
            for(int i=index;i<length-1;i++){
                //删除元素之后的所有元素前移一位
                strArray[i] =strArray[i+1];
            }
            length--;
            return true;
        }else{
            return false;
        }
    }

    //列出所有元素
    public void display(){
        for(int i=0;i<length;i++){
            System.out.print(strArray[i]+"\t");
        }
    }
}
