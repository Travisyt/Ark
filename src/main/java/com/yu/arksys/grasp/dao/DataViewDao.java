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
    @Select("select t.btypeid,bfullname=(select b.bfullname from btype b where t.btypeid=b.btypeid),totalnum=-SUM(t.Qty),total=-SUM(t.total),profit=SUM(t.costtotal)-SUM(t.total),profitrade=CASE SUM(t.total) WHEN 0 THEN 0 ELSE (SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)) END from DlySale t where t.total<>0 and (MONTH(getdate())-3)<=MONTH(t.date) and t.PtypeId='${ptypeid}' GROUP BY t.btypeid order by totalnum desc")
    List<CustomerSalesOfCommodity> getCustomerSalesLastThreeMonths(@Param("ptypeid") String ptypeid);

    /**
     * universalData页面中 近三月部门销售分布
     * @param ptypeid 商品id
     * @return DepartmentSalesOfCommodity List
     */
    @Select("select t1.*,s.kfullname from (select t.ktypeid,totalnum=-SUM(t.Qty),total=-SUM(t.total),profit=SUM(t.costtotal)-SUM(t.total),profitrade=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)) from DlySale t where (MONTH(getdate())-3)<=MONTH(t.date) and t.PtypeId='${ptypeid}' GROUP BY t.ktypeid) t1 inner join Stock s on s.ktypeid=t1.ktypeid order by total desc")
    List<DepartmentSalesOfCommodity> getDepartmentSalesLastThreeMonths(@Param("ptypeid") String ptypeid);

    /**
     * 获取所有有在售数据商品的近三月销售额
     * @return SalesNumOfCommodity List
     */
    @Select("select ptypeid=t.PtypeId,totalnum=-SUM(t.Qty) from DlySale t where (MONTH(getdate())-3)<=MONTH(t.date) GROUP BY PtypeId")
    List<SalesNumOfCommodity> getSalesNumLastThreeMonthsOfCommodityAll();

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

    /**
     * everyday页面中 获取某日某职工销售状况
     */
    @Select("select etypeid='${etypeid}',efullname=(select efullname from employee where etypeid='${etypeid}'),totalSales=SUM(table_1.t_totalSales),totalCost=SUM(table_1.t_totalCost),totalReturn=SUM(table_1.t_totalReturn),totalDiscount=SUM(table_1.t_totalDiscount),netTotalSales=SUM(table_1.t_netTotalSales) from (select t3.btypeid,t_type=(select b3.bfullname from btype b3 where b3.btypeid=(select b2.parid from btype b2 where t3.btypeid=b2.btypeid)),t_efullname,t_totalSales,t_totalCost,t_totalReturn,t_total,t_totalDiscount=(select sum(total) from DlyA where atypeid='000040000390000' and btypeid=t3.btypeid and date='${date}'),t_netTotalSales=t_total-(case when t_totalDiscount is null then 0 else t_totalDiscount end) from (select t1.btypeid,t_efullname,t_totalSales,t_totalCost,t_totalReturn=(case when t_totalReturn is null then 0 else t_totalReturn end),t_total=t_totalSales-(case when t_totalReturn is null then 0 else t_totalReturn end) from (select t.btypeid,t_efullname=(select bfullname from btype b1 where t.btypeid=b1.btypeid),t_totalSales=-SUM(tax_total),t_totalCost=-SUM(costtotal) from DlySale t where etypeid='${etypeid}' and Vchtype='11' and date='${date}' group by btypeid) t1 left join (select btypeid,t_totalReturn=SUM(tax_total) from DlySale where etypeid='${etypeid}' and Vchtype='45' and date='${date}' group by btypeid) t2 on t1.btypeid=t2.btypeid) t3 left join (select btypeid,t_totalDiscount=sum(total) from DlyA where atypeid='000040000390000' and etypeid='${etypeid}' and date='${date}' group by btypeid) t4 on t3.btypeid=t4.btypeid) table_1")
    SalesDataPublicPerday getSalesDataPublicPerday(@Param("etypeid") String etypeid, @Param("date") String date);

    /**
     * universalData页面中，获取某商品之前的进货量
     */
    @Select("SELECT db.Vchcode,bfullname=(select b.bfullname from btype b where b.btypeid=db.btypeid),kfullname=(select k.kfullname from Stock k where k.ktypeid=db.ktypeid),pfullname=(select p.pfullname from ptype p where p.ptypeid=db.PtypeId),db.Qty,db.date FROM DlyBuy db where PtypeId = '${ptypeid}'")
    List<BuyQuantityRecord> getBuyQuantityRecords(@Param("ptypeid") String ptypeid);

}
