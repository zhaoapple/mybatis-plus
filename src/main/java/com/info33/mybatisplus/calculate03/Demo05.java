package com.info33.mybatisplus.calculate03;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo05 {
    public static void main(String[] args) {
        List lists = new ArrayList<>();
        lists.add("aaa");
        lists.add("bbb");
        Map<String,Object> info = new HashMap<>();
        info.put("id", 123456);
        info.put("name", lists);


        String string = info.toString();
        String jsonString = JSON.toJSONString(info.get("name"));
        JSONArray parseArray = JSON.parseArray(jsonString);
        System.out.println(jsonString);
    }
}
