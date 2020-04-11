package com.yu.arksys.grasp.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("graspSqlSessionTemplate")
@Component(value = "businessRelatedUnitDao")
public interface BusinessRelatedUnitDao {

    @Select("select bfullname from btype where id = ${id}")
    String findFullNameById(@Param("id") String id);

}
