package com.info33.mybatisplus.calculate;

public class Demo3 {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(10);
        user.setName("tom");
        User user0 = new User();
        user0.setAge(14);
        user0.setName("jojoy");


        User user1 = user;
        User user2 = user;
        user1.setAge(11);
        user1.setName("lili");

        user2.setAge(13);
        user1.setName("baobo");
        user2 = user0;

        System.out.println(user);
        System.out.println(user1);
        System.out.println(user2);
    }
}
class User{
    int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}