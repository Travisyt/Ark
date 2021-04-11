package com.yu.arksys.utils;

import java.util.Map;

public class LogUtils {

    public static void dataAccessLog(Map<String, String> kv) {
        System.out.println("== 数据获取 ==");
        kv.forEach((k, v) -> {
            System.out.println(k + " :  " + v);
        });
        System.out.println("-- 完成 --");
    }

}
