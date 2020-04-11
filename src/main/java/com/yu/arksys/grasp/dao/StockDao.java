package com.yu.arksys.grasp.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("graspSqlSessionTemplate")
@Component(value = "stockDao")
public interface StockDao {

    @Select("select kfullname from Stock where ktypeid = ${id}")
    String findFullNameById(@Param("id") String id);

}
