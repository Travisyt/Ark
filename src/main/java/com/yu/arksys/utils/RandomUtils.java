package com.yu.arksys.utils;

import java.util.Random;

public class RandomUtils {

    private static Random random = null;

    private static Random getRandom() {
        if (RandomUtils.random == null) {
            RandomUtils.random = new Random();
        }
        return RandomUtils.random;
    }

    public static String randomString(int length) {
        Random random = RandomUtils.getRandom();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            stringBuffer.append(str.charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    public static Integer randomInteger(int scope) {
        Random random = RandomUtils.getRandom();
        return random.nextInt(scope);
    }

}
