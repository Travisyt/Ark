package com.yu.arksys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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

    /**
     * @param conditions 以HashMap存储条件
     * 规则如下：
     * 条件为'='、'<'、'>'，以符号加值的格式传递。例如：key, >value
     * 条件为'between ... and ...'，以'@min,max'的格式传递
     *
     * @return 返回SQL条件语句
     */
    public static String getConditionString(Map<String, String> conditions) {

        if (conditions.isEmpty()) {
            return "1=1";
        }
        StringBuilder stringBuilder = new StringBuilder();
        conditions.forEach((key, value) -> {
            String val = value.substring(1);
            String head = value.substring(0, 1);
            // between
            if (head.equals("@")) {
                String[] vals = val.split(",");
                stringBuilder.append(key).append(">=").append("'").append(vals[0]).append("'").append(" and ")
                        .append(key).append("<=").append("'").append(vals[1]).append("'").append(" and ");
            }
            // "="、"<"、">"
            else {
                stringBuilder.append(key).append(head).append("'").append(val).append("'").append(" and ");
            }
        });
        return stringBuilder.substring(0, stringBuilder.lastIndexOf(" and "));
    }

    /**
     *
     * @param field 字段
     * @param keyword 关键字
     * @return 模糊查询条件语句
     */
    public static String getFuzzySearchConditionString(String field, String keyword) {
        return "CHARINDEX('" + keyword + "', " + field + ") <> 0";
    }

    public static String surroundWith(String src, String surround) {
        return surround + src + surround;
    }

//    public static void main(String[] args) throws ParseException, NoSuchFieldException, NoSuchMethodException {
//        Date date = new Date(System.currentTimeMillis() + 3600000);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(format.format(date));
//        System.out.println(format.parse("2020-4-4 13:00:00").toString());
//        System.out.println();
//    }

}
