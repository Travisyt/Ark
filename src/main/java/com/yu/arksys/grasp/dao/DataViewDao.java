package com.yu.arksys.grasp.dao;

import com.yu.arksys.bean.raw.CustomerSalesOfCommodity;
import com.yu.arksys.bean.raw.DepartmentSalesOfCommodity;
import com.yu.arksys.bean.raw.SalesDataPermonth;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier("graspSqlSessionTemplate")
@Component("DataViewDao")
public interface DataViewDao {

    /**
     * dataView页面中的查询
     * @param ptypeid 商品id
     * @return SalesDataPermonth List
     */
    @Select("select pfullname=(SELECT p.pfullname FROM ptype p WHERE p.ptypeid=MAX(t.PtypeId)),totalnum=-SUM(t.Qty),total=-SUM(t.total),profit=SUM(t.costtotal)-SUM(t.total),profitrate=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)),month=RIGHT(LEFT(MIN(t.date),7),5) from DlySale t where t.PtypeId='${ptypeid}' GROUP BY LEFT(t.date, 7)")
    List<SalesDataPermonth> getSalesDataPermonth(@Param("ptypeid") String ptypeid);

    /**
     * universalData页面中的月销量
     * @param ptypeid 商品id
     * @return SalesDataPermonth List
     */
    @Select("select pfullname=(SELECT p.pfullname FROM ptype p WHERE p.ptypeid=MAX(t.PtypeId)),销售总量=-SUM(t.Qty),销售总价=-SUM(t.total),销售利润=SUM(t.costtotal)-SUM(t.total),利润率=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)),月份=LEFT(MIN(t.date),5)+RIGHT(LEFT(MIN(t.date),7),2) from DlySale t where t.PtypeId='${ptypeid}' GROUP BY LEFT(t.date, 7)")
    List<SalesDataPermonth> getUniversalSalesData(@Param("ptypeid") String ptypeid);

    /**
     * universalData页面中的近三月客户销售分布
     * @param ptypeid 商品id
     * @return CustomerSalesOfCommodity List
     */
    @Select("select t1.*,b.bfullname from (select t.btypeid,totalnum=-SUM(t.Qty),total=-SUM(t.total),profit=SUM(t.costtotal)-SUM(t.total),profitrade=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)) from DlySale t where (MONTH(getdate())-3)<=MONTH(t.date) and t.PtypeId=${ptypeid} GROUP BY t.btypeid) t1 inner join btype b on t1.btypeid=b.btypeid order by total desc")
    List<CustomerSalesOfCommodity> getCustomerSalesLastThreeMonths(@Param("ptypeid") String ptypeid);

    /**
     * universalData部门销售分布
     * @param ptypeid 商品id
     * @return DepartmentSalesOfCommodity List
     */
    @Select("select t1.*,s.kfullname from (select t.ktypeid,totalnum=-SUM(t.Qty),total=-SUM(t.total),profit=SUM(t.costtotal)-SUM(t.total),profitrade=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)) from DlySale t where t.PtypeId=${ptypeid} GROUP BY t.ktypeid) t1 inner join Stock s on s.ktypeid=t1.ktypeid order by total desc")
    List<DepartmentSalesOfCommodity> getDepartmentSalesLastThreeMonths(@Param("ptypeid") String ptypeid);

}
