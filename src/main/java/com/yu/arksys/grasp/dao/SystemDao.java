package com.yu.arksys.grasp.dao;

import com.yu.arksys.bean.EmployeeAction;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier(value = "graspSqlSessionTemplate")
@Component(value = "SystemDao")
public interface SystemDao {

    @Select("select top #{pageSize} ID,FUNNAME,ACTNAME,ACTDATE,ACTORIP,ACTOPER,COMNAME from BR_ACTIONLOG " +
            "where ID not in (select top #{frontPageNum} ID from BR_ACTIONLOG order by #{orderBy}) order by " +
            "#{orderBy}")
    List<EmployeeAction> getActionLog(@Param("pageSize") String pageSize, @Param("frontPageNum") String frontPageNum, @Param("orderBy") String orderBy);

}
