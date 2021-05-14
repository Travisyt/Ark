package com.yu.arksys.lastyear.dao;

import com.yu.arksys.bean.raw.SalesDataPermonth;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier("lastYearGraspSqlSessionTemplate")
@Component("LastYearDataViewDao")
public interface LastYearDataViewDao {

    /**
     * universalData页面中的查询
     * @param ptypeid 商品id
     * @return SalesDataPermonth
     */
    @Select("select pfullname=(SELECT p.pfullname FROM ptype p WHERE p.ptypeid=MAX(t.PtypeId)),销售总量=-SUM(t.Qty),销售总价=-SUM(t.total),销售利润=SUM(t.costtotal)-SUM(t.total),利润率=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)),月份=LEFT(MIN(t.date),5)+RIGHT(LEFT(MIN(t.date),7),2) from DlySale t where t.PtypeId='${ptypeid}' GROUP BY LEFT(t.date, 7)")
    List<SalesDataPermonth> getUniversalSalesData(@Param("ptypeid") String ptypeid);


}
