package com.info33.mybatisplus.calculate02;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface  A{
    void opration();
}

class B {
    void realOpration(A fi){
        fi.opration();
    }
}
public class Tests {

    public static void main(String[] args) {
        /**创建接口A的实例*/
        A a = ()-> System.out.println("this is A");
//        a.opration();
        /**再来试试这个支持Lambda表达式的方法*/
//        B b = new B();
//        b.realOpration(()-> System.out.println("this is B"));
//        consumo(500, (x) -> System.out.println(x));
//        consumo2(500, () -> 0.1);
//
//        String s = strOperar(" asdf ", x -> x.substring(0, 2));
//        System.out.println(s);
//        String s1 = strOperar(" asdf ", x -> x.trim());
//        System.out.println(s1);

        List<Integer> l = new ArrayList<>();
        l.add(102);
        l.add(172);
        l.add(13);
        l.add(82);
        l.add(109);
        List<Integer> list = filterInt(l, x -> (x > 100));
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    /**
     * 过滤集合
     * @param list
     * @param pre
     * @return
     */
    public static List<Integer> filterInt(List<Integer> list, Predicate<Integer> pre){
        List<Integer> l = new ArrayList<>();
        for (Integer integer : list) {
            if (pre.test(integer))
                l.add(integer);
        }
        return l;
    }


    public static void consumo (double money, Consumer<Double> c) {
        c.accept(money);
    }
    public static void consumo2 (double money, Supplier<Double> c) {
        System.out.println(c.get());
    }

    /**
     * 字符串操作
     * @param str 需要处理得字符串
     * @param fun Function接口
     * @return 处理之后得字符传
     */
    public static String strOperar(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

}
