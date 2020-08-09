package com.yu.arksys.grasp.dao;

import com.yu.arksys.bean.RecordTuple;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Qualifier("graspSqlSessionTemplate")
@Component(value = "MapperDao")
public interface MapperDao {

    /**
     *
     * 取出键值对列表
     */
    @Select("select ${keyField} as id,${valueField} as name from ${tableName}")
    List<RecordTuple> getMapper(@Param("keyField") String keyField, @Param("valueField") String valueField, @Param("tableName") String tableName);

}
