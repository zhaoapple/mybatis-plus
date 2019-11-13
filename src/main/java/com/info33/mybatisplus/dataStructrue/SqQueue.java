package com.info33.mybatisplus.dataStructrue;

public class SqQueue<T>{
    private T[] datas;//使用数组作为队列的容器
    private int maxSize;//队列的容量
    private int front;//头指针
    private int rear;//尾指针

    //初始化队列
    public SqQueue(int maxSize){
        if(maxSize<1){
            maxSize = 1;
        }
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.datas = (T[])new Object[this.maxSize];
    }

    //两个状态:队空&队满
    public boolean isNull(){
        if(this.front == this.rear)
            return true;
        else
            return false;
    }

    public boolean isFull(){
        if((rear+1)%this.maxSize==front)
            return true;
        else
            return false;
    }

    //初始化队列
    public void initQueue(){
        this.front = 0;
        this.front = 0;
    }

    //两个操作:进队&出队
    public boolean push(T data){
        if(isFull())
            return false;//队满则无法进队
        else{
            datas[rear] = data;//进队
            rear = (rear+1) % maxSize;//队尾指针+1.
            return true;
        }
    }
    public T pop(){
        if(isNull())
            return null;//对空无法出队
        else{
            T popData = datas[front];//出队
            front = (front+1) % maxSize;//队头指针+1
            return popData;
        }
    }

    //get()
    public T[] getDatas() {
        return datas;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

    public static void main(String[] args) {
        SqQueue<Character> sqQueue = new SqQueue(10);
        sqQueue.push('1');
        sqQueue.push('2');
        sqQueue.push('3');
        Character pop = sqQueue.pop();
        System.out.println("pop = " + pop);
        Character pop2 = sqQueue.pop();
        System.out.println("pop2 = " + pop2);
        Character pop3 = sqQueue.pop();
        System.out.println("pop3 = " + pop3);
    }
}
