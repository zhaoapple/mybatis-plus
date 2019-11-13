package com.info33.mybatisplus.dataStructrue;

//双端链表的封装类
public class DoubleEndList {

    public static void main(String[] args) {
        DoubleEndList doubleEndList = new DoubleEndList();
        doubleEndList.insertLast(new Link(1));
//        doubleEndList.insertLast(new Link(2));
//        doubleEndList.insertLast(new Link(3));
//        doubleEndList.insertFirst(new Link(1));
//        doubleEndList.insertFirst(new Link(2));
//        doubleEndList.insertFirst(new Link(3));
        try {
            doubleEndList.deleteFirst();
//            doubleEndList.displayList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Link first;  //指向链表中的第一个链结点
    private Link last;   //指向链表中最后一个链结点

    public DoubleEndList(){
        first = null;
        last = null;
    }

    //插入到链表的首端
    public void insertFirst(Link link){
        if(isEmpty()){  //如果为空链表，则插入的第一个链结点既是表头也是表尾
            last = link;
        }
        link.next = first;
        first = link;
    }

    //插入到链表的末端
    public void insertLast(Link link){
        /**
         * 空链结点的时候，插入的一个结点既是表头也是表尾，first和last指向的地址都是一个
         *当链表再插入一个结点的时候，last.next指向新节点Link，first和last中的结点都会改变
         * 最后将last结点指向link，即始终保证last指向的是新添加的结点，新加的结点放在尾部
         */
        if(isEmpty()){  //如果为空链表，则插入的第一个链结点既是表头也是表尾
            first = link;
        }else{
            //使用last.next操作新的结点，而不能使用first.next操作-会出现后面数据的丢失
            //新的结点会逐个加在first下面，主要通过last操作指针域来实现添加的操作
            last.next = link;
        }
        last = link;
    }

    //删除第一个链结点，返回删除的链结点引用
    public Link deleteFirst() throws Exception{
        if(isEmpty()){
            throw new Exception("链表为空！不能进行删除操作");
        }
        //备份了first结点的信息
        Link temp = first;
        if(first.next == null){
            //如果只有一个链结点，则删除后会影响到last指针，将last指针改为null
            last = null;
        }
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
