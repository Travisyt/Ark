package com.yu.arksys.utils;

import com.yu.arksys.bean.DetailedBillDraft;
import com.yu.arksys.bean.DetailedBillDraftResponse;
import com.yu.arksys.bean.api.DataBean;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * 所有字段必须用单引号包围
 */
public class SQLUtils {

    private static String date;

    static {
        date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static String getCurrentDate() {
        return surroundWith(date, "'");
    }

    public static void refreshCurrentDate(Date d) {
        date = new SimpleDateFormat("yyyy-MM-dd").format(d);
    }

    public static String getConditionString(Map<String, String> conditions) {

        if (conditions.isEmpty()) {
            return "1=1";
        }
        StringBuilder stringBuilder = new StringBuilder();
        conditions.forEach((key, value) -> {
            String val = value.substring(1);
            // "="、"<"、">"
            String condition = value.substring(0, 1);
            stringBuilder.append(key).append(condition).append("'").append(val).append("'").append(" and ");
        });
        return stringBuilder.substring(0, stringBuilder.lastIndexOf(" and "));
    }

    public static String getFuzzySearchConditionString(String field, String keyword) {
        return "CHARINDEX('" + keyword + "', " + field + ") <> 0";
    }

    public static String surroundWith(String src, String surround) {
        return surround + src + surround;
    }

    public static void main(String[] args) throws ParseException, NoSuchFieldException, NoSuchMethodException {
        Date date = new Date(System.currentTimeMillis() + 3600000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date));
        System.out.println(format.parse("2020-4-4 13:00:00").toString());
        System.out.println();
    }

}
