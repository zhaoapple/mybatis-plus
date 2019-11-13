package com.info33.mybatisplus.calculate;


import lombok.Data;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) throws Exception {
//        Map<String,Object> map = new HashMap();
//        UserDemo user = new UserDemo();
//        user.setAge(18);
//        user.setName("李四");
//        Map<String, Object> stringObjectMap = object2Map(user);
//        System.out.println(stringObjectMap);
//        Date date = new Date(1567326239000L);
//        System.out.println("date = " + date);
//        map.put("name", "张三");
//        map.put("cd", 1118);
//        map.put("age", 18);
//        map.put("price",new BigDecimal(1111) );
//        map.put("nums",new Integer[]{1,2,3} );
//        UserDemo o = mapToObject2(map, user.getClass());
//        System.out.println(o);
//        UserDemo userDemo = mapToEntity(map, user.getClass());
//        UserDemo userDemo = mapToObject2(map, user.getClass());
//        System.out.println(userDemo);
//        System.out.println(user);
        UserDemo user = new UserDemo();
        user.setAge(18);
        user.setName("李四");
        UserDemo user1 = new UserDemo("王二",20);
        List getInfos = new ArrayList();
        getInfos.add(user);
        getInfos.add(user1);
        List list = object2Map2(getInfos);
        System.out.println("list = " + list);
//        Map<String, Object> stringObjectMap = object2Map(user);
//        System.out.println("stringObjectMap = " + stringObjectMap);

    }
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null) return null;
        Object obj = beanClass.newInstance();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                continue;
            }
            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
        }
        return obj;
    }
    public static <T> T mapToObject2(Map<String, Object> map, Class<T> beanClass) throws Exception {
        if (map == null) return null;
        T obj = beanClass.newInstance();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                continue;
            }
            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
        }
        return obj;
    }

    public static  <T> T mapToEntity(Map<String, Object> map, Class<T> entity) {
        T t = null;
        try {
            t = entity.newInstance();
            for(Field field : entity.getDeclaredFields()) {
                if (map.containsKey(field.getName())) {
                    boolean flag = field.isAccessible();
                    field.setAccessible(true);
                    Object object = map.get(field.getName());
                    if (object!= null && field.getType().isAssignableFrom(object.getClass())) {
                        field.set(t, object);
                    }
                    field.setAccessible(flag);
                }
            }
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static Map<String, Object> object2Map(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static List<Map<String, Object>> object2Map2(List<Object> objs) {
        List returnInfos = new ArrayList();
        for (Object obj : objs) {
            Map<String, Object> map = new HashMap<>();
            if (obj == null) {
                return null;
            }
            Class clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            try {
                for (Field field : fields) {
                    field.setAccessible(true);
                    map.put(field.getName(), field.get(obj));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            returnInfos.add(map);
        }
        return returnInfos;
    }


}
@Data
class UserDemo{
    String name;
    Integer age;

    public UserDemo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public UserDemo() {
    }
    //    BigDecimal price;
//    Integer[] nums;
}
