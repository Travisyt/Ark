package com.yu.arksys.utils;

import com.yu.arksys.bean.api.DataBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class SQLUtils {

    public static String getConditionString(Map<String, String> conditions) {

        if (conditions.isEmpty()) {
            return "1=1";
        }
        StringBuilder stringBuilder = new StringBuilder();
        conditions.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                String val = value.substring(1);
                // "="、"<"、">"
                String condition = value.substring(0, 1);
                stringBuilder.append(key).append(condition).append("'").append(val).append("'").append(" and ");
            }
        });
        return stringBuilder.substring(0, stringBuilder.lastIndexOf(" and "));
    }

    public static String getConditionString(Map<String, String> conditions, String valueSurround) {
        if (conditions.isEmpty()) {
            return "1=1";
        }
        StringBuilder stringBuilder = new StringBuilder();
        conditions.forEach((key, value) -> stringBuilder.append(key).append(value.substring(0, 1)).append(valueSurround).append(value.substring(1)).append(valueSurround).append(" and "));
        return stringBuilder.substring(0, stringBuilder.lastIndexOf(" and "));
    }

    public static String getFuzzySearchConditionString(String field, String keyword) {
        return "CHARINDEX('" + keyword + "', " + field + ") <> 0";
    }

}
