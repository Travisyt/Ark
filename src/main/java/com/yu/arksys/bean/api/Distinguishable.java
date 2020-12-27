package com.yu.arksys.bean.api;

public interface Distinguishable {

    /**
     * 生成区别码，用于区别两条数据是否来源于同一条记录
     * @return 区别码
     */
    String getDistinguishCode();

}
