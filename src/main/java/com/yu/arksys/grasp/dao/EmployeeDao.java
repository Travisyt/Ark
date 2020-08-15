package com.yu.arksys.grasp.dao;

import com.yu.arksys.bean.raw.EmployeeRecord;
import com.yu.arksys.bean.RecordTuple;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier(value = "graspSqlSessionTemplate")
@Component(value = "EmployeeDao")
public interface EmployeeDao {

    @Select("SELECT etypeid,leveal,soncount,efullname,eusercode,Department,Tel,Address,deleted,erec,Incumbency,ROWINDEX,isStop,updatetag FROM employee")
    List<EmployeeRecord> getEmployeeList();

    @Select("select efullname from employee where etypeid = ${id}")
    String findFullNameById(@Param("id") String id);

    @Select("select etypeid as id,efullname as name from employee")
    List<RecordTuple> getEmployeeMap();

}
