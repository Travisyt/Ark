package com.yu.arksys.utils;

import java.util.Random;

public class RandomUtils {

    public static String randomString(int length) {
        Random random = new Random();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder stringBuffer = new StringBuilder();
        for (int i=0;i<length;++i) {
            stringBuffer.append(str.charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

}
