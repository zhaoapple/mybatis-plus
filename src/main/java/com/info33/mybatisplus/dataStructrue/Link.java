package com.info33.mybatisplus.dataStructrue;

//链结点的封装类
public class Link {

    public int age;
    public Link next;  //指向该链结点的下一个链结点

    //构造方法
    public Link(int age){
        this.age = age;
    }

    //打印该链结点的信息
    public void displayLink(){
        System.out.println("age:"+age);
    }

    public void printlnLink(Link link){

        //递归打印
        link.displayLink();
        if(link.next != null){
            printlnLink(link.next);
        }
        //while循环打印，两者之间的区别
//        while(link != null){
//            link.displayLink();
//            link = link.next;
//        }
    }

}

//链表的封装类
class LinkList {

    public static void main(String[] args) throws Exception {
        LinkList linkList = new LinkList();
        linkList.insertFirst(new Link(1));
        linkList.insertFirst(new Link(2));
        linkList.insertFirst(new Link(3));
        linkList.insertFirst(new Link(4));
        /**
         * deleteByKey修改了之前删除元素后链表中还存在数据的情况
         */
//        linkList.deleteByKey(3);
        linkList.displayList();
//        if(linkList.find(3) == null){
//            System.out.println(1111111);
//        }
//        System.out.println(linkList.find(3));
    }

    private Link first;  //指向链表中的第一个链结点

    public LinkList(){
        first = null;
    }

    //插入到链表的前端
    public void insertFirst(Link link){
        /**
         *将已存在的结点赋值给新的结点的指针域中，新的结点已经是最新的，而原先的结点并没有改变
         * 然后将新的结点赋值给原先的结点，这样就完成了结点的插入，这样插入的设计的很巧妙
         */
        link.next = first;
        first = link;
    }

    //删除第一个链结点，返回删除的链结点引用
    public Link deleteFirst() throws Exception{
        if(isEmpty()){
            throw new Exception("链表为空！不能进行删除操作");
        }
        /**
         * 删除的并不一定是一个结点，只是取到了第一个结点的值
         * 该结点的指针域可能不为空
         * 不直接返回头结点，而是赋值给一个变量返回
         */
        Link temp = first;
        first = first.next;
        return temp;
    }

    //打印出所有的链表元素
    public void displayList(){
        Link cur = first;
        while(cur != null){  //循环打印每个链结点
            cur.displayLink();
            cur= cur.next;
        }
    }

    //删除属性为指定值的链结点
    public Link delete(int key){
        Link link = null; //要删除的结点
        Link cur = first; //当前结点
        Link next = first.next; //后结点
        Link previous = null; //前结点
        while(cur != null){
            if(cur.age == key){  //找到了要删除的链结点
                link = cur;
                //如果当前链结点的前驱为null，证明当其为链表的第一个链结点，删除该链结点后需要对first属性重新赋值
                if(previous ==null){
                    this.first =next;
                }else{
                    //删除操作，即将前驱的next指针指向当前链结点的next，链表中将去当前链结点这一环
                    previous.next= next;
                }
                break;
            }else if(cur.next ==null){  //当前链结点不是目标且下一个链结点为null，证明没有要删除的链结点
                break;
            }

            //当前链结点不是要删除的目标，则向后继续寻找
            next = next.next;
            cur = cur.next;
            previous = cur; //previous指向的地址已经不再是first的地址，更改previous不会更改first
        }
        return link;
    }
    //删除属性为指定值的链结点
    public Link deleteByKey(int key){
        /**
         * 获取当前结点的前一结点，后一结点。
         * 匹配当前结点的数据是否与要删除的数据是否相等。
         * 如果匹配，则将前一结点的指针域指向后一结点。
         * 然后修改原始链表，防止改变指针后原链表没有更改。
         */
        Link link = null; //要删除的结点
        Link cur = first; //当前结点
        Link next = first.next; //后结点
        Link previous = null; //前结点
        while(cur != null){
            if(cur.age == key){  //找到了要删除的链结点
                link = cur;
                //如果当前链结点的前驱为null，证明当其为链表的第一个链结点，删除该链结点后需要对first属性重新赋值
                if(previous ==null){
                    this.first =next;
                }else{
                    //删除操作，即将前驱的next指针指向当前链结点的next，链表中将去当前链结点这一环
                    previous.next= next;
                }
                break;
            }else if(cur.next ==null){  //当前链结点不是目标且下一个链结点为null，证明没有要删除的链结点
                break;
            }

            //当前链结点不是要删除的目标，则向后继续寻找
            next = next.next;
            /**
             *每一次previous的指针指向当前结点的上一个结点，当更改previous时候
             * 指针指向的地址的值也会发生改变，进而first中改地址中的值也会发生相应的改变
             */
            previous = cur;
            cur = cur.next;
        }
        return link;
    }


    //查找属性为指定值的链结点
    public Link find(int key){
        Link link = null;
        Link cur = first;
        while(cur != null){
            if(cur.age == key){
                link = cur;
                break;
            }else if(cur.next == null){
                break;
            }
            cur = cur.next;
        }
        return link;
    }

    //判空
    public boolean isEmpty(){
        return (first == null);
    }

}
