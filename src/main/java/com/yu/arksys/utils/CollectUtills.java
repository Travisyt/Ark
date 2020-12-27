package com.yu.arksys.utils;

import java.util.Map;

public class CollectUtills {

    public static Map<String, Object> putSuccessStatus(Map<String, Object> map) {
        map.put("status", "200");
        return map;
    }

    public static Map<String, Object> putFailStatus(Map<String, Object> map) {
        map.put("status", "0");
        return map;
    }

    public static Map<String, Object> putFailStatus(Map<String, Object> map, String msg) {
        map.put("status", "0");
        map.put("message", msg);
        return map;
    }

}
