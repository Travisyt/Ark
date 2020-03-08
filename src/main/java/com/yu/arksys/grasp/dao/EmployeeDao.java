package com.yu.arksys.grasp.dao;

import com.yu.arksys.bean.EmployeeRecord;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier(value = "graspSqlSessionTemplate")
@Component(value = "EmployeeDao")
public interface EmployeeDao {

    @Select("SELECT etypeid,leveal,soncount,efullname,eusercode,Department,Tel,Address,deleted,erec,Incumbency,ROWINDEX,isStop,updatetag FROM employee")
    List<EmployeeRecord> getEmployeeList();

}
