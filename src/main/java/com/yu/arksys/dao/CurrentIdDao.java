package com.yu.arksys.dao;

public interface CurrentIdDao {

    Integer getCurrentId(String tableName, String fieldName);

    void changeCurrentId(String tableName, String fieldName, Integer currentId);

}
