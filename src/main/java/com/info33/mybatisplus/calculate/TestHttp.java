package com.info33.mybatisplus.calculate;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.util.List;
import java.util.Map;

public class TestHttp {
    public static void main(String[] args) {
        try {
            String postURL = "https://yichihui.com/externops/login";
            PostMethod postMethod = new PostMethod(postURL) ;
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8") ;
            //参数设置，需要注意的就是里边不能传NULL，要传空字符串
            NameValuePair[] data = {
                    new NameValuePair("username","15366025510"),
                    new NameValuePair("password","123456")
            };
            postMethod.setRequestBody(data);
            HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
            // 执行POST方法
            int response = httpClient.executeMethod(postMethod);
            String result = postMethod.getResponseBodyAsString();
            JSONObject jsonObject = JSONObject.parseObject(result);
            String shops = jsonObject.getJSONArray("shops").toJSONString();
            List<Map> list = JSONObject.parseArray(shops.toString(),Map.class);
            System.out.println(list);
            for (Map map : list) {
                Object pic1 = map.get("pic1");
                if(pic1==null){
                    System.out.println("------------");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
