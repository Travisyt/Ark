package com.yu.arksys.utils;

import java.util.Map;

public class LogUtils {

    public static void dataAccessLog(Map<String, String> kv) {
        System.out.print("== 数据获取 == ");
        kv.forEach((k, v) -> {
            System.out.print(k + " :  " + v);
        });
        System.out.println("");
    }

}
