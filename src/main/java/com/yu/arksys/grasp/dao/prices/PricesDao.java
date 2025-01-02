package com.yu.arksys.grasp.dao.prices;

import com.yu.arksys.bean.result.prices.CommoditySalesAtPrice;
import com.yu.arksys.bean.result.prices.StockAveragePrice;
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
    @Select("SELECT pfullname=(SELECT p.pfullname FROM ptype p WHERE p.ptypeid=MAX(t.PtypeId)),qty=-SUM(t.Qty),total=-SUM(t.total),price=t.price,profit=SUM(t.costtotal)-SUM(t.total),profitrate=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)+0.00001),month='${yearMonth}' FROM DlySale t WHERE Vchtype = '11' AND LEFT(t.date,7) = '${yearMonth}' AND t.PtypeId='${ptypeid}' GROUP BY t.price ORDER BY t.price DESC")
    List<CommoditySalesAtPrice> getSalesAtPriceOneMonth(@Param("ptypeid") String ptypeid,@Param("yearMonth") String yearMonth);
    // 不带月份
    @Select("SELECT pfullname=(SELECT p.pfullname FROM ptype p WHERE p.ptypeid=MAX(t.PtypeId)),qty=-SUM(t.Qty),total=-SUM(t.total),price=t.price,profit=SUM(t.costtotal)-SUM(t.total),profitrate=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)+0.00001),month='' FROM DlySale t WHERE Vchtype = '11' AND t.PtypeId='${ptypeid}' GROUP BY t.price ORDER BY t.price DESC")
    List<CommoditySalesAtPrice> getSalesAtPriceAll(@Param("ptypeid") String ptypeid);

    @Select("SELECT pfullname=(SELECT p.pfullname FROM ptype p WHERE p.ptypeid=MAX(t.PtypeId)),qty=-SUM(t.Qty),total=-SUM(t.total),price=t.price,profit=SUM(t.costtotal)-SUM(t.total),profitrate=(SUM(t.costtotal)-SUM(t.total))/(-SUM(t.total)+0.00001),month='' FROM DlySale t WHERE Vchtype = '11' AND t.date >= DATEADD(day, -90, GETDATE()) AND t.PtypeId='${ptypeid}' GROUP BY t.price ORDER BY t.price DESC")
    List<CommoditySalesAtPrice> getSalesAtPriceLastThreeMonth(@Param("ptypeid") String ptypeid);

    @Select("select t1.*,stockAveragePrice=(select gs1.Price from GoodsStocks gs1 where gs1.KtypeId='${ktypeid}' and gs1.PtypeId=t1.ptypeid) from (select TOP 1 gs.GoodsDate,ptypeid=gs.ptypeid,ktypeid='${ktypeid}',dynamicStockAveragePrice=gs.Price from T_GoodsStocksGlide gs where gs.ktypeid='${ktypeid}' and gs.Total>0 and gs.ptypeid='${ptypeid}' ORDER BY gs.GoodsDate desc) t1")
    StockAveragePrice getAveragePriceById(@Param("ptypeid") String ptypeid, @Param("ktypeid") String ktypeid);

}
