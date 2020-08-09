package com.yu.arksys.bean;

/**
 * 包含表名、ID字段、值字段的Bean
 * 用于寻找对应关系
 */
public class TableMapInfo {

    public TableMapInfo() {
    }

    public TableMapInfo(String tableName, String keyFieldName, String valueFieldName) {
        this.tableName = tableName;
        this.keyFieldName = keyFieldName;
        this.valueFieldName = valueFieldName;
    }

    private String tableName;

    private String keyFieldName;

    private String valueFieldName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getKeyFieldName() {
        return keyFieldName;
    }

    public void setKeyFieldName(String keyFieldName) {
        this.keyFieldName = keyFieldName;
    }

    public String getValueFieldName() {
        return valueFieldName;
    }

    public void setValueFieldName(String valueFieldName) {
        this.valueFieldName = valueFieldName;
    }
}
