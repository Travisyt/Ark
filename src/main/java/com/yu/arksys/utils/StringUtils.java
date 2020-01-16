package com.yu.arksys.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtils {

    public static List<String> splitAsList(String str, String delim) {
        List<String> res = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, delim);
        while (tokenizer.hasMoreTokens()) {
            res.add(tokenizer.nextToken());
        }
        return res;
    }

}
