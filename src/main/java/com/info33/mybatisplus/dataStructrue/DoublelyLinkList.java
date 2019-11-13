package com.info33.mybatisplus.dataStructrue;

//双向链表的封装类
public class DoublelyLinkList {

    public static void main(String[] args) {
        DoublelyLinkList doublelyLinkList = new DoublelyLinkList();
//        doublelyLinkList.addFirst(new Link2(1));
//        doublelyLinkList.addFirst(new Link2(2));
//        doublelyLinkList.addFirst(new Link2(3));
//        doublelyLinkList.addFirst(new Link2(4));
        doublelyLinkList.insertLast(new Link2(1));
        doublelyLinkList.insertLast(new Link2(2));
        doublelyLinkList.insertLast(new Link2(3));
        doublelyLinkList.insertAfter2(2,new Link2(4));
//        doublelyLinkList.displayList();
//        doublelyLinkList.displayList();
//        try {
//            Link2 link2 = doublelyLinkList.deleteFirst();
//            link2.displayLink();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        doublelyLinkList.find(2);
    }

    private Link2 first;  //指向链表中的第一个链结点
    private Link2 last;   //指向链表中的最后一个链结点

    public DoublelyLinkList(){
        first = null;
        last = null;
    }

    //插入到链表的前端
    public void insertFirst(Link2 link){
        /**
         * link赋值给last以及first，则通过last或first其中的一个以及前后结点的指针域都可以改变
         * link所指的地址内存的值。
         * 当首次插入的时候，first与last都指向link1
         * 当插入第二个的时候，将link2到first前结点指针域中
         */
        if(isEmpty()){  //如果为空链表，则插入的第一个链结点既是表头也是表尾
            last = link;
        }else{  //如果不是空链表，则将链表的first指针指向该链结点
            first.previous = link;
        }
        link.next = first;
        /**
         * 这一步改变了first变量的指向的地址，与last不同，所以last不会改变，但如果last中的previous或是next
         *指向的地址与link的地址相同，则会发生相应的改变
         */
        first = link;
    }

    //插入到链表的末端
    public void insertLast(Link2 link){
        if(isEmpty()){  //如果为空链表，则插入的第一个链结点既是表头也是表尾
            first = link;
        }else{
            last.next = link;
            link.previous = last;
        }
        last = link;
    }

    //删除第一个链结点，返回删除的链结点引用
    public Link2 deleteFirst() throws Exception{
        if(isEmpty()){
            throw new Exception("链表为空！不能进行删除操作");
        }
        Link2 temp = first;
        if(first.next == null){
            last = null;  //如果只有一个链结点，则删除后会影响到last指针
        }else{  //如果至少有两个链结点，则将第二个链结点的previous设为null
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    //删除最后一个链结点，返回删除的链结点引用
    public Link2 deleteLast() throws Exception{
        if(isEmpty()){
            throw new Exception("链表为空！不能进行删除操作");
        }
        //删除前备份
        Link2 temp = last;
        if(last.previous == null){
            first = null;  //如果只有一个链结点，则删除后会影响到first指针
        }else{  //如果至少有两个链结点，则将倒数第二个链结点的next设为null
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }

    //查找属性为指定值的链结点
    public Link2 find(int key){
        Link2 cur = first;
        while(cur != null &&cur.age != key ){
            if(cur.next == null){
                return null;  //当前链结点不是要找的目标且已到达表尾
            }
            cur = cur.next;
        }

        return cur;
    }

    //在指定链结点之后插入，操作成功返回true，操作失败返回false

    /**
     * 少参数，使用insertAfter2
     */
    public boolean insertAfter(Link2 link){
        Link2 target = find(link.age);
        boolean flag = true;
        if(target == null){  //没找到插入的参照链结点
            flag = false;
        }else{  //找到了插入的参照链结点
            if(target.next == null){ //参照链结点为表尾
                insertLast(link);
            }else { //该链表至少有两个链结点
                target.next.previous= link;
                link.next =target.next;
                //必须执行完上面两步，才能执行下面这两步
                //上面两步处理了link和它下一个链结点的关系
                //下面两步处理了link和它上一个链结点的关系
                target.next = link;
                link.previous =target;
            }
        }
        return flag;
    }
    public boolean insertAfter2(int age,Link2 link){
        Link2 target = find(age);
        boolean flag = true;
        if(target == null){  //没找到插入的参照链结点
            flag = false;
        }else{  //找到了插入的参照链结点
            if(target.next == null){ //参照链结点为表尾
                insertLast(link);
            }else { //该链表至少有两个链结点
                target.next = link;
                link.previous =target;

                target.next.previous= link;
                link.next =target.next;
                //必须执行完上面两步，才能执行下面这两步
                //上面两步处理了link和它下一个链结点的关系
                //下面两步处理了link和它上一个链结点的关系
            }
        }
        return flag;
    }

    //打印出所有的链表元素
    public void displayList(){
        Link2 cur = first;
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
//链结点的封装类
class Link2 {

    public int age;
    public Link2 next;  //指向下一个链结点
    public Link2 previous;  //指向前一个链结点

    //构造方法
    public Link2(int age){
        this.age = age;
    }

    //打印该链结点的信息
    public void displayLink(){
        System.out.println("age:"+age);
    }
}