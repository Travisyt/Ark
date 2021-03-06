package com.yu.arksys.grasp.dao;

import com.yu.arksys.bean.raw.EmployeeAction;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier(value = "graspSqlSessionTemplate")
@Component(value = "SystemDao")
public interface ActionLogDao {

    @Select("select top ${pageSize} ID,FUNNAME,ACTNAME,ACTDATE,ACTORIP,ACTOPER,COMNAME from BR_ACTIONLOG " +
            "where ID not in (select top ${frontPageNum} ID from BR_ACTIONLOG order by ${orderBy}) order by " +
            "${orderBy}")
    List<EmployeeAction> getActionLogWithOrder(@Param("pageSize") String pageSize, @Param("frontPageNum") String frontPageNum, @Param("orderBy") String orderBy);

    @Select("select top ${pageSize} ID,FUNNAME,ACTNAME,ACTDATE,ACTORIP,ACTOPER,COMNAME from BR_ACTIONLOG " +
            "where ID not in (select top ${frontPageNum} ID from BR_ACTIONLOG order by ACTDATE desc) " +
            "order by ACTDATE desc")
    List<EmployeeAction> getActionLog(@Param("pageSize") String pageSize, @Param("frontPageNum") String frontPageNum);

    @Select("select top ${pageSize} ID,FUNNAME,ACTNAME,ACTDATE,ACTORIP,ACTOPER,COMNAME from BR_ACTIONLOG " +
            "where ID not in (select top ${frontPageNum} ID from BR_ACTIONLOG where ${conditions} order by ACTDATE " +
            "desc) and ${conditions} order by ACTDATE desc")
    List<EmployeeAction> getActionLogWithConditions(@Param("pageSize") String pageSize, @Param("frontPageNum") String frontPageNum, @Param("conditions") String conditions);

    @Select("select top ${pageSize} ID,FUNNAME,ACTNAME,ACTDATE,ACTORIP,ACTOPER,COMNAME from BR_ACTIONLOG " +
            "where ID not in (select top ${frontPageNum} ID from BR_ACTIONLOG where ${conditions} order by ${orderBy})" +
            " and ${conditions} order by ${orderBy}")
    List<EmployeeAction> getActionLogWithConditionsAndOrder(@Param("pageSize") String pageSize, @Param("frontPageNum") String frontPageNum, @Param("conditions") String conditions, @Param("orderBy") String orderBy);

    @Select("select count(*) from BR_ACTIONLOG where ${conditions}")
    Integer getActionCount(@Param("conditions") String conditions);

    @Select("select distinct ${field} from BR_ACTIONLOG where ${conditions}")
    List<String> getFieldEnumWithConditions(@Param("field") String field, @Param("conditions") String conditions);

    @Select("select distinct ${field} from BR_ACTIONLOG")
    List<String> getFieldEnum(@Param("field") String field);

}
