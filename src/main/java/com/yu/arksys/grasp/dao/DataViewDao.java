package com.yu.arksys.grasp.dao;

import com.yu.arksys.bean.raw.*;
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
    @Select("select pfullname=(SELECT p.pfullname FROM ptype p WHERE p.ptypeid=MAX(t.PtypeId)),totalnum=-SUM(t.Qty),total=-SUM(t.total),profit=SUM(t.costtotal)-SUM(t.total),profitrate=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)),month=LEFT(MIN(t.date),5)+RIGHT(LEFT(MIN(t.date),7),2) from DlySale t where t.PtypeId='${ptypeid}' GROUP BY LEFT(t.date, 7)")
    List<SalesDataPermonth> getSalesDataPermonth(@Param("ptypeid") String ptypeid);

    /**
     * universalData页面中的月销量
     * @param ptypeid 商品id
     * @return SalesDataPermonth List
     */
    @Select("select pfullname=(SELECT p.pfullname FROM ptype p WHERE p.ptypeid=MAX(t.PtypeId)),totalnum=-SUM(t.Qty),total=-SUM(t.total),profit=SUM(t.costtotal)-SUM(t.total),profitrade=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)),month=LEFT(MIN(t.date),5)+RIGHT(LEFT(MIN(t.date),7),2) from DlySale t where t.PtypeId='${ptypeid}' GROUP BY LEFT(t.date, 7)")
    List<SalesDataPermonth> getUniversalSalesData(@Param("ptypeid") String ptypeid);

    /**
     * universalData页面中的部门月销量
     * @param ptypeid 商品id
     * @param ktypeid 仓库id
     * @return SalesDataPermonth List
     */
    @Select("select pfullname=(SELECT p.pfullname FROM ptype p WHERE p.ptypeid=MAX(t.PtypeId)),totalnum=-SUM(t.Qty),total=-SUM(t.total),profit=SUM(t.costtotal)-SUM(t.total),profitrade=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)),month=LEFT(MIN(t.date),5)+RIGHT(LEFT(MIN(t.date),7),2) from DlySale t where t.PtypeId='${ptypeid}' and t.KtypeId='${ktypeid}' GROUP BY LEFT(t.date, 7)")
    List<SalesDataPermonth> getUniversalDepartmentSalesData(@Param("ptypeid") String ptypeid, @Param("ktypeid") String ktypeid);

    /**
     * universalData页面中 近三月客户销售分布
     * @param ptypeid 商品id
     * @return CustomerSalesOfCommodity List
     */
    @Select("select t.btypeid,bfullname=(select b.bfullname from btype b where t.btypeid=b.btypeid),totalnum=-SUM(t.Qty),total=-SUM(t.total),profit=SUM(t.costtotal)-SUM(t.total),profitrade=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)) from DlySale t where t.total<>0 and (MONTH(getdate())-3)<=MONTH(t.date) and t.PtypeId='${ptypeid}' GROUP BY t.btypeid order by totalnum desc")
    List<CustomerSalesOfCommodity> getCustomerSalesLastThreeMonths(@Param("ptypeid") String ptypeid);

    /**
     * universalData页面中 近三月部门销售分布
     * @param ptypeid 商品id
     * @return DepartmentSalesOfCommodity List
     */
    @Select("select t1.*,s.kfullname from (select t.ktypeid,totalnum=-SUM(t.Qty),total=-SUM(t.total),profit=SUM(t.costtotal)-SUM(t.total),profitrade=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)) from DlySale t where (MONTH(getdate())-3)<=MONTH(t.date) and t.PtypeId='${ptypeid}' GROUP BY t.ktypeid) t1 inner join Stock s on s.ktypeid=t1.ktypeid order by total desc")
    List<DepartmentSalesOfCommodity> getDepartmentSalesLastThreeMonths(@Param("ptypeid") String ptypeid);

    /**
     * universal页面中 获取商品的库存分布
     *
     * @return CommodityStock List
     */
    @Select("SELECT ktypeid=KtypeId,kfullname=(select kfullname from Stock s where s.ktypeid=g.KtypeId),Qty FROM GoodsStocks g where PtypeId='${ptypeid}'")
    List<CommodityStock> getCommodityStock(@Param("ptypeid") String ptypeid);

    /**
     * universal页面中 获取职员销售均价
     * @param ptypeid 商品id
     * @return EmployeeAverageSalesPrice List
     */
    @Select("select t.etypeid,efullname=(select e.efullname from employee e where e.etypeid=t.etypeid),averageprice=SUM(t.total)/SUM(t.Qty) from DlySale t where ptypeid='${ptypeid}' and Vchtype='11' group by t.etypeid order by averageprice desc")
    List<EmployeeAverageSalesPrice> getEmployeeAverageSalesPrice(@Param("ptypeid") String ptypeid);

}
