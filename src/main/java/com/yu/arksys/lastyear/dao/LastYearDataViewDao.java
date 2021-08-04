package com.yu.arksys.lastyear.dao;

import com.yu.arksys.bean.raw.CustomerSalesOfCommodity;
import com.yu.arksys.bean.raw.DepartmentSalesOfCommodity;
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
    @Select("select pfullname=(SELECT p.pfullname FROM ptype p WHERE p.ptypeid=MAX(t.PtypeId)),totalnum=-SUM(t.Qty),total=-SUM(t.total),profit=SUM(t.costtotal)-SUM(t.total),profitrate=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)),month=LEFT(MIN(t.date),5)+RIGHT(LEFT(MIN(t.date),7),2) from DlySale t where t.PtypeId='${ptypeid}' GROUP BY LEFT(t.date, 7)")
    List<SalesDataPermonth> getUniversalSalesDataLastYear(@Param("ptypeid") String ptypeid);

    /**
     * universalData页面中 去年客户销售分布
     * @param ptypeid 商品id
     * @return CustomerSalesOfCommodity List
     */
    @Select("select t1.*,b.bfullname from (select t.btypeid,totalnum=-SUM(t.Qty),total=-SUM(t.total),profit=SUM(t.costtotal)-SUM(t.total),profitrade=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)) from DlySale t where t.PtypeId='${ptypeid}' GROUP BY t.btypeid) t1 inner join btype b on t1.btypeid=b.btypeid order by total desc")
    List<CustomerSalesOfCommodity> getCustomerSalesLastYear(@Param("ptypeid") String ptypeid);

    /**
     * universalData页面中 去年部门销售分布
     * @param ptypeid 商品id
     * @return DepartmentSalesOfCommodity List
     */
    @Select("select t1.*,s.kfullname from (select t.ktypeid,totalnum=-SUM(t.Qty),total=-SUM(t.total),profit=SUM(t.costtotal)-SUM(t.total),profitrade=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)) from DlySale t where t.PtypeId='${ptypeid}' GROUP BY t.ktypeid) t1 inner join Stock s on s.ktypeid=t1.ktypeid order by total desc")
    List<DepartmentSalesOfCommodity> getDepartmentSalesLastYear(@Param("ptypeid") String ptypeid);


}
