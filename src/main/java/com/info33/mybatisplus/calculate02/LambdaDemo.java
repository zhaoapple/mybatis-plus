package com.info33.mybatisplus.calculate02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.forEach(str ->{
            System.out.println(str);
        });
    }

    @Test
    public void test0() {
        List<Integer> list = Arrays.asList(1, 2, 3);

    }

}
