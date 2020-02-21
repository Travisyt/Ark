package com.yu.arksys.utils;

import com.alibaba.fastjson.JSON;

import java.util.Map;

public class test {

    public static void main(String[] args) {
//        String test_str = "sadaqwda dand ";
//        System.out.println(test_str);
//        System.out.println(test_str.indexOf(" and "));
//        test_str = test_str.substring(0, test_str.lastIndexOf("and "));
//
//        System.out.println(test_str);
        String test_str = "{\"A\":\"2\",\"B\":\"3\"}";
        test_str = "{\"A\":\"2\",\"B\":\"3\"}";
        System.out.println(test_str);
        Map json = JSON.parseObject(test_str, Map.class);
        System.out.println(json);
        System.out.println(json.getClass());
    }

}
