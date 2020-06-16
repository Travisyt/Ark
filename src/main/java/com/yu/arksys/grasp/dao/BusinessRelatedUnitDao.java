package com.yu.arksys.grasp.dao;

import com.yu.arksys.bean.RecordTuple;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier("graspSqlSessionTemplate")
@Component(value = "businessRelatedUnitDao")
public interface BusinessRelatedUnitDao {

    @Select("select bfullname from btype where btypeid = '${id}'")
    String findFullNameById(@Param("id") String id);

}
