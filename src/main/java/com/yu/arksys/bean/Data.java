package com.yu.arksys.bean;

import java.util.List;
import java.util.Map;

public class Data {

    public Data(int totalNum, Map<String, Map<Integer, String>> fieldMapping, List<OrderRecord> data) {
        this.totalNum = totalNum;
        this.fieldMapping = fieldMapping;
        this.data = data;
    }

    public Data() {

    }

    /**
     * 本次查询总行数
     */
    private int totalNum;

    /**
     * 字段枚举
     */
    private Map<String, Map<Integer, String>> fieldMapping;

    /**
     * 数据
     */
    private List<OrderRecord> data;


    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public Map<String, Map<Integer, String>> getFieldMapping() {
        return fieldMapping;
    }

    public void setFieldMapping(Map<String, Map<Integer, String>> fieldMapping) {
        this.fieldMapping = fieldMapping;
    }

    public List<OrderRecord> getData() {
        return data;
    }

    public void setData(List<OrderRecord> data) {
        this.data = data;
    }

    //    public static Data generate() {
//        Integer totalNum = 10;
//        Map<String, Map<Integer, String>> fieldEnum = new HashMap<>();
//        for (int i = 0; i < 2; ++i) {
//            Map<Integer, String> temp = new HashMap<>();
//            for (int j = 0; j < 3; ++j) temp.put(j, "testField" + Integer.toString(j));
//            fieldEnum.put(Integer.toString(i) + "map", temp);
//        }
//        List<String> fields = new ArrayList<>();
//        for (int i = 0; i < 5; ++i) {
//            fields.add("field" + Integer.toString(i));
//        }
//        List<List<String>> data = new ArrayList<>();
//        List<String> rowdata = new ArrayList<>();
//        for (int i=0;i<5;++i) {
//            rowdata.add("a");
//        }
//        for (int i = 0; i < 3; ++i) {
//            data.add(rowdata);
//        }
//        return new Data(totalNum, fieldEnum, fields, data);
//    }

}
