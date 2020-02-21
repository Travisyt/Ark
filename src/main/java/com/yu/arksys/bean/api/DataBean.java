package com.yu.arksys.bean.api;

public abstract class DataBean {

    public final static String D = ",";

    /**
     * 子接口需要重写
     * @return 返回字段列表 以D分割
     */
    public abstract String getFieldsString();

    public abstract String getValuesString();

    /**
     * 子接口需要重写
     * @return 返回表名
     */
    public abstract String getTableName();

}
