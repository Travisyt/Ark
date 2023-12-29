package com.yu.arksys.grasp.dao.prices;

import com.yu.arksys.bean.result.prices.CommoditySalesAtPrice;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier(value = "graspSqlSessionTemplate")
@Component(value = "PricesDao")
public interface PricesDao {

    // 售价区间
    // 带月份
    @Select("SELECT pfullname=(SELECT p.pfullname FROM ptype p WHERE p.ptypeid=MAX(t.PtypeId)),qty=-SUM(t.Qty),total=-SUM(t.total),price=t.price,profit=SUM(t.costtotal)-SUM(t.total),profitrate=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)),month='${month}' FROM DlySale t WHERE WHERE RIGHT(LEFT(t.date,7),2) = '${month}' AND t.PtypeId='${ptypeid}' GROUP BY t.price ORDER BY t.price DESC")
    List<CommoditySalesAtPrice> getSalesAtPriceOneMonth(@Param("ptypeid") String ptypeid,@Param("month") String month);
    // 不带月份
    @Select("SELECT pfullname=(SELECT p.pfullname FROM ptype p WHERE p.ptypeid=MAX(t.PtypeId)),qty=-SUM(t.Qty),total=-SUM(t.total),price=t.price,profit=SUM(t.costtotal)-SUM(t.total),profitrate=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)),month='' FROM DlySale t WHERE t.PtypeId='${ptypeid}' GROUP BY t.price ORDER BY t.price DESC")
    List<CommoditySalesAtPrice> getSalesAtPriceAll(@Param("ptypeid") String ptypeid);
}
