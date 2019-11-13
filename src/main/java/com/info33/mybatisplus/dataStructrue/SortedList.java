package com.info33.mybatisplus.dataStructrue;

//有序链表的封装类
public class SortedList {

    public static void main(String[] args) {
        SortedList sortedList = new SortedList();
        sortedList.insertAsc(new Link(1));
        sortedList.insertAsc(new Link(2));
        sortedList.insertAsc(new Link(5));
        sortedList.insertAsc(new Link(4));
        sortedList.insertAsc(new Link(3));
        sortedList.displayList(); // 1 2 3 4 5
    }

    private Link first;  //指向链表中的第一个链结点

    public SortedList(){
        first = null;
    }

    //插入
    public void insert(Link link){
        /**
         * 插入修改first结点，总是通过别的指针引用来改变
         * 同时此指针变量要取变量接收
         */
        Link previous = null; //小于新结点的旧结点
        Link cur = first; //与新结点对比的当前结点
        while(cur != null && link.age>cur.age){  //链表由大到小排列
            previous = cur; //previous指向first，所以可以改变first地址中的值
            cur = cur.next; //当前结点的旧的后结点
        }
        if(previous == null){  //如果previous为null，则证明当前链结点为表头
            this.first = link;
        }else{
            /**
             * link赋值到上个结点的next，然后旧结点赋值给link结点的next
             */
            previous.next = link;
        }
        link.next = cur;
    }

    public void insertAsc(Link link){
        Link pre = null;
        Link cur = this.first;
        while (cur!=null && link.age>cur.age){
            pre = cur;
            cur = cur.next;
        }

        if(pre == null){
            this.first = link;
        }else{
            pre.next = link;
        }
        link.next = cur;

    }

    //删除第一个链结点，返回删除的链结点引用
    public Link deleteFirst() throws Exception{
        if(isEmpty()){
            throw new Exception("链表为空！不能进行删除操作");
        }
        //删除先备份
        Link temp = first;
        first = first.next;
        return temp;
    }

    //打印出所有的链表元素
    public void displayList(){
        Link cur = first;
        while(cur != null){  //循环打印每个链结点
            cur.displayLink();
            cur = cur.next;
        }
    }

    //判空
    public boolean isEmpty(){
        return (first == null);
    }

}
