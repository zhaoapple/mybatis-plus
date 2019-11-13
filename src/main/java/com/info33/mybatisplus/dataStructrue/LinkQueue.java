package com.info33.mybatisplus.dataStructrue;

public class LinkQueue<T>{
    private QNode<T> front;//队头指针
    private QNode<T> rear;//队尾指针
    private int maxSize;//为了便于操作，使用这个变量表示链队的数据容量

    //初始化
    public LinkQueue(){
        this.front = new QNode<T>();
        this.rear = new QNode<T>();
        this.maxSize = 0;
    }

    //初始化队列
    public void initQueue(){
        front.next = null;
        rear.next = null;
        maxSize = 0;
    }

    //队空判断
    public boolean isNull(){
        if(front.next==null || rear.next==null)
            return true;
        else
            return false;
    }

    //进队
    public void push(QNode<T> node){
        if(isNull()){
            //第一次
            front.next = node;
            rear.next = node;
            maxSize++;
        }
        else{
            node.next = front.next;
            front.next = node;
            maxSize++;
        }
    }
    //出队
    public QNode<T> pop(){
        if(isNull())
            return null;//队为空时，无法出队
        else if(maxSize==1){
            //队只有一个元素时直接初始化即可
            QNode<T> node  = front.next;
            initQueue();
            return node;
        }
        else{
            //准备工作
            QNode<T> p = front;//使用p指针来遍历队列
            for(int i=1;i<maxSize-1;i++)
            /**
             * 第一次遍历，找出倒数第三个节点
             * 第二次遍历，找出倒数第四个节点
             * ...
             * 直到maxSize==1时，获取最顶部的节点
             */
                p = p.next;
            /**
             * 第一次获取倒数第一个节点
             * 第二次获取倒数第二个节点
             * ...
             * 直到获取顶部的节点
             */
            QNode<T> node = rear.next;
            /**
             * 第一次p.next将倒数两个元素赋值给rear.next
             * 第二次p.next将倒数三个元素赋值给rear.next
             * ...
             * 直到将除了最顶部的元素赋值给rear.next
             */
            rear.next = p.next;
            maxSize--;
            return node;
        }
    }

    public static void main(String[] args) {
        LinkQueue<Integer> linkQueue = new LinkQueue<>();
        linkQueue.push(new QNode<Integer>(1));
        linkQueue.push(new QNode<Integer>(2));
        linkQueue.push(new QNode<Integer>(3));
        linkQueue.push(new QNode<Integer>(4));
        linkQueue.push(new QNode<Integer>(5));
        while(!linkQueue.isNull()){
            System.out.println(linkQueue.pop().getData());
        }
    }

}

//链队结点
class QNode<T>{
    private T data;//数据域
    public QNode<T> next;//指针域

    //初始化1
    public QNode(){
        this.data = null;
        this.next = null;
    }
    //初始化2
    public QNode(T data){
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

}
