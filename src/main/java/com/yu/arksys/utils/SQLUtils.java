package com.yu.arksys.utils;

import com.yu.arksys.bean.api.DataBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public class SQLUtils {

    public static String getConditionString(Map<String, String> conditions) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("where ");
        conditions.forEach((key, value) -> stringBuilder.append(key).append(value).append(" and "));
        return stringBuilder.substring(0, stringBuilder.lastIndexOf(" and "));
    }

}
